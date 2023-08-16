									Spring Boot Microservices
									=========================
* Service Discovery
* Centralized Configuration
* Distributed Tracing
* Event Driven Architecture
* Centralized Logging
* Circuit Breaker
* Secure Microservice using Keyclock
Distributed Logging using ELK stack.

       +---------------------------------------+                +--------------------------------------+
       |            API GATEWAY                | <------------> |         Authorization Server       |
       |                                       |                |                                    |
       +-------------------+-------------------+                +-------------------+----------------+
                           |                                                        
              Discovery Service (Eureka)                                           
                           |                                                        
           +---------------v-----------------+                                    
           |     Product Service             |                                   
           |                                 |                                    
           |    +-------------------------+  |                                    
           |    |        MongoDB          |  |                                    
           |    |        Database         |  |                                    
           |    +-------------------------+  |                                    
           +---------------------------------+                                    
                           |                                                   
                           | Communication                                     
                           |                                                   
            +--------------v--------------+                                    
            |   Notification Service      |                                    
            |                            |                                    
            |   +---------------------+  |                                   
            |   |                     |  |                                    
            |   |                     |  |                                   
            |   |                     |  |                                    
            |   |                     |  |                                    
            |   |                     |  |                                    
            |   +---------------------+  |                                   
            +---------------------------+                                    
                           |                                                   
                           | Communication                                     
                           |                                                   
            +--------------v-------------+                                    
            |     Inventory Service      |                                    
            |                            |                                    
            |   +---------------------+  |                                    
            |   |   Postgresql Database| |                                    
            |   +---------------------+  |                                    
            +----------------------------+                                    
                           |                                                   
                           | Communication                                     
                           |                                                   
            +--------------v--------------+                                    
            |       Order Service         |                                    
            |                             |                                    
            +-----------------------------+                                    
                                                                               


Lets suppose, we have 4 Microservices 
1. Product service which exposes the REST API which backed by MongoDB which mainly takes care
of the Product Configuration of the application.

2. Inventory Service -> It will verify if a product is in stock or not before customer orders for
the Product. This Microservice is also exposed as REST API backed by MYSQL db.

3. Order Service -> It also exposes by REST APIs and backed by MYSQL db. This takes cares of 
processing the orders places by the users. As part of Order Processing we are going to make the 
syncronous processing with the inventory service and we are going to make it ressilient 
with RESILIENCE4J library.

4. Notification Service -> We are going to perform asyncronous communication using Event driven 
Architecture. As soon as the order is placed then Event is going to fire, and the notification 
service will listen to this event and will send the notification.

We are going to use the API Gateway microservice so that all the request will be routed to 
the corresponds services. We can implement security here because client/user will deal with 
API Gateway directly instead of each service.

As you can see there are many microservice, we need a way to enable service to service communication
without hardcoding the service information inside the service. for that is by using Spring Cloud Netflix
Eureka as servie registry.

* And for all the services there will be some configurations and properties which needs to 
be mapped .Suppose if we want to change a property in application.properties of the Product
Service, then  we manually change the property build and compile and deploy the service.
If we want to do this for multiple services common in microservicies Architecture then its
not going to work, instead of that we are going to maintain all the configurations properties
inside a centralized CONFIG SERVER that is backed by a git repository.

* If we want to store the secret information like username and password, it doesnot make 
any sense to store it in publically, thus we need a safe and secure place to store all these.
We can store in Hashicorp Valut.

* We are going to build our microservice as resillient microservices, our order service is 
communication with inventory service and due to some case Inventory service is not responding 
so in this case instead of calling the Inventory service, we will execute fallback logic
where we will handle this falure gracefully and inform the upstream microservice that the
inventory service is down. This is actually called as CIRCUIT BREAKER PATTERN.

* As we have many microservice then it is going to hard to debug any issues. If the request is done
and the response is slow then we dont know where is the problem.So for this we are going to use 
a library called ZIPKIN.

* We will also use ELK to implement centralized logging so we can access the logs of all
the services at one place.

**What is Service Discovery
===========================

+--------------------+                  +-----------------------+
|   Order Service    |                   |   Product Service    |
|                    |                   |                      |
|                    |Get /api/product   |                      |
|                    +------------------>+                      |
|                    |                   |                      |
+--------------------+                  +-----------------------+

The Order service is calling the Product Service Rest API then we have to manually hardcode the 
hostname or url of Product service inside the Order service.

Lets say if we have two or 100 of  Product Service instance then what we will do to hit from
Order service Because its very common to have multiple instances of Services to make the 
availability.

Thus, what we need is the automatically detection of all the available services in our network.
So this is known as "Service Discovery". So we need a server which act as a central place 
where all the other services will come and register themselves for example using a name, then
discovery server will maintain the live overview with all the available services.

So the process of services registering themselves with the discovery server is called Service 
Registry.

How a discovery Server knows that a service is up or down
=========================================================
The clients/service sends continiously heart beat request to the discovery server and if the 
server didnot receive the heartbeat request from the clients then it will mark those services
is "down".

* To implement the server and client functionality Spring Cloud introduces the Spring Cloud 
Eureka Project (this contains the implementation of spring cloud eureka server and the 
spring cloud eureka client).

The frequently used port number is 8761
server.port=8761
eureka.client.register-with-eureka=false, because it will not register to the server as client and 
eureka.client.fetch-registry=false , disable to local copy of registry
make sure to add @EnableEurekaServer
like this code below,
-----------------------------------------------------------------------
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
-------------------------------------------------------------------------
thats it.

Now add the services as clients to the eureka server.
@SpringBootApplication
@EnableEurekaClient
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
spring.application.name=order-service
server.port=0
eureka.instance.instance-id=${spring.application.name}:${random.uuid}
					---@@@@@@@@@@@@@@@@@---

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
add in application.properties
------------------------------
spring.application.name=product-service
server.port=0 //because to make allow for multiple instances and at runtime it will get assigned the port.
eureka.instance.instance-id=${spring.application.name}:${random.uuid}

============================================================================================================
============================================================================================================

Understanding Centralized Configuration
=======================================
Now we have two instnces of Product Service and Order Service.
If I want to change the property inside the Product Service, then I have to first
checkout to the code in my local-> Change the property -> Compile the code -> Deploy Changes.

Not only that but also I need to take down the other instaces of it and redeploy it again.

This is looking easy for fewer number of microservices, but what about tens and 100s of
instances. This will become too complex right.

For this, we need Centralized location where we will store all the configurations properties 
of the microservice. And If there are any changes to that properties then it should be 
dynamically load them to our microservices instead of restarting all the instances.
 

Thus, Spring Cloud brings functionality using this "spring-cloud-config-server". where
we can store the configuration in the git repository.

So by providing the url of the git repository we can read the properties dynamically
whenever they are changed.
		

   +---------------------+       +-----------------------+       +----------------------+
   |    Order Service    | ----> |    Config Server      | <---- |   Product Service    |
   +---------------------+       +-----------------------+       +----------------------+
                                            |
                                            | 
                                            |
                                            v
                          		 +-----------------------+
                        	     |   Git Repository      |
                     	         |                       |
                          		 |                       |
                           		 +-----------------------+


To create the config server, 


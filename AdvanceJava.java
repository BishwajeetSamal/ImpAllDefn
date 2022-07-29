json vs yaml
cron code to run after particular interval of time
projects
actuator 
aop
failsafe 
failfast
threadpool
multithreading in third way
SOCIAL login is called third party login

magic number


typing in communicator
f5 andr k lie
f6 aage jane k lie

bean class flow
bean life cycle in java
container started -> bean instantiated ->


design pattern


Thread using ExecutorService to be written in thread file







*************SpringBoot*******SpringBoot***************SpringBoot**********SpringBoot********

******************************************JPA************************************************

Searching in jpa
findByNameContaining to search using some value 
we can also write custom query using like operator if some error occures
if query also searches using some foreign key then naming will be of the entity 
and the foreign key can not be directly passes in this case we must pass the object to search
publicc Page<Users> findByUserNameContainingIgnoreCaseOrFirstName
					ContainingIgnoreCaseOrLastNameContainingIgnoreCase
					AndGenderInOrderByCreatedAt
					(String userName ,String firstName ,String lastName ,List<Gender> genders, Pageable pageable);
pagable object is always passed in last parameter 
we can use PageRequest.of((pageNumber-1),pageSize)
internally limit query is used here 
select * from students limit offset,noOfRecordToDisplay
here offset is number of record to skip and second parameter tells how many records to display
findByStudentNameContainingIgnoreCaseAndClassesIn(String student,List<Classes> classes)
return type of query is Page when pagable is passed
return type is optional while normal searching optional is a class which provides a set of functions 
JPA	Hibernate
JPA is a Data Access Abstraction used to reduce the amount of boilerplate code	
Hibernate is an implementation of Java Persistence API and offers benefits of loose coupling
orm object relational maping 
mapping a object with a database table
object fields becomes the name of columns in table and object name becomes the table name
Jpa is just guideline to implement orm
hibernate is orm tool providing the implementation of jpa
in short jpa is interface and hibernate is implementation
List<ChatMessage> chatMessagesList = chatMessageRepository.findBySenderUserIdAndReciverUserIdAndCreatedAtLessThanAndIsDeletedOrderByCreatedAtDesc(fromUser , toUser , chatRequest.getCreatedAt() , false , pageable);
first we short the data according to the short by condition then we retrive the data

*******************************************************************************************
Spring:-
---------
1. Spring is the most popular application development framework of Java. 
2. The main feature of the Spring Framework is dependency Injection or Inversion of Control (IoC).
3. With the help of Spring Framework, we can develop a loosely coupled application. 

4.Spring is a widely used Java EE framework for building applications.
5.The developer writes a lot of code to do the minimal task.
6.To test the Spring project, we need to set up the sever explicitly.
7.It does not provide support for an in-memory database.
8.Developers manually define dependencies for the Spring project in pom.xml.

Spring Boot:-
-------------
1.Spring Boot is a module of Spring Framework. Spring Boot makes it easy to quickly bootstrap and start 
  developing a Spring-based application.  
2.It allows us to build a stand-alone application with minimal or zero configurations.
  It hides a lot of complexity behind the scene so that the developer can quickly get started and develop 
  Spring-based applications easily.
3.Spring Boot Framework is widely used to develop REST APIs.
4.The primary key feature of Spring Boot is Autoconfiguration. 
5.It automatically configures the classes based on the requirement.
6.It reduces boilerplate code.
7.Spring Boot offers embedded server such as Jetty and Tomcat, etc.
8.It offers several plugins for working with an embedded and in-memory database such as H2.
9.Spring Boot comes with the concept of starter in pom.xml file that internally takes care 
of downloading the dependencies JARs based on Spring Boot Requirement.

Spring MVC:-
------------
1.A Spring MVC is a Java framework which is used to build web applications.
2. It follows the Model-View-Controller design pattern.
3. It implements all the basic features of a core spring framework like Inversion of Control, Dependency Injection.
4.A Spring MVC provides an elegant solution to use MVC in spring framework by the help of DispatcherServlet.
5.Here, DispatcherServlet is a class that receives the incoming request and maps it to the right resource such as controllers, models, and views.
5.DispatcherServlet class works as the front controller. It is responsible to manage the flow of the Spring MVC application.



Dependency Injection:- //This is not language dependent. It is a concept of design patterns.
-----------------------
1. It is a design pattern(we follow this pattern to make application.). 
Dependency Injection is a fundamental aspect of the Spring framework, through which the Spring container 
“injects” objects into other objects or “dependencies”.

Simply put, this allows for loose coupling of components and moves the responsibility of managing
 components onto the container.

 Bean:-
 -------
 In Spring, a bean is an object that the Spring container instantiates, assembles, and manages.

**************************************Annotations*****************************************
----------------------------------
1.@SpringBootApplication
2.@EnableAutoConfiguration
3.@Configuration
4.@ComponentScan
5.@Bean
6.@Autowired
7.@Component
8.@Controller
9.@Service
10.@Repository
11.Qualifier
12.@Lazy
13.@RequestMapping
14.@ResponseBody
15.@RequestBody
16.@RestController
17.@PathVariable
18.@RequestParam
19.@ControllerAdvice //To handle the Global Exception

----------------------------------

1.@SpringBootApplication = @EnableAutoConfiguration + @Configuration + @ComponentScan
======================
1.The @SpringBootApplication annotation is a convenience annotation that combines the 
( @EnableAutoConfiguration,@Configuration and the @ComponentScan ) annotations in a Spring Boot application.
2.@SpringBootApplication is used as the entry point of the application.

(i.) @EnableAutoConfiguration
------------------------------
The @EnableAutoConfiguration annotation enables Spring Boot to auto-configure the application context.
For example, when we define the spring-boot-starter-web dependency in our classpath, Spring boot 
auto-configures Tomcat and Spring MVC
									
(ii.) @Configuration
---------------------
Configuration class marks a class as a source of bean/method bean.
Those objects of beans are managed by Spring.
Example --->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
@Bean  //this marks it as a bean , Thus we don't need to create the object of this returned bean. 
//We can directly autowired.
public Student getStudent(){
	return new Student();
}

//and if we want to access the the object then use
@Autowired
private Student student;
Example End ----->>>>>>>>>>>>>>>>>>>>>>>>>
Thus, Bean object managed by spring Container.
It helps inside class to identify for all the  bean declared.
Spring @Configuration annotation indicates that the class has @Bean definition methods. 
So Spring container can process the class and generate Spring Beans to be used in the application.

(iii.) @ComponentScan
----------------------
we can pass package and all classes in that package or subpackages, get scans for spring beans.
for example ->> @ComponentScan(basePackages={"other_package"}). It also scan the sub packages of it.
This annotation enables component-scanning so that the web controller classes and other components 
you create will be automatically discovered and registered as beans in Springs Application Context.

2. @Component
-------------
@Bean for Method and as like this @Component is for class.
@Component is a class level annotation. 
During the component scan, Spring Framework automatically detects classes annotated with @Component.

3. @Controller
---------------
It behaves as a @Component and MVC controller mapping.

4. @Service
------------
We use to write the business logic.

5.@Repository
----------------
It will behave as Component and provide some facilities for DAO. (Data access objects)

6.@Qualifier
-------------
The @Qualifier is used to resolve ambiguous dependencies i.e, it helps @Autowired annotations to choose one of the dependency.
If there are multiple implementations for single interface then we can use @Qualifier to choose required implementation at runtime

For Example ---->>>>>
@Bean("student1")
@Lazy //this will not execute
public Student getStudent(){
	return new Student("student1");
}


@Bean("student2")
public Student cerateStudent(){
	return new Student("student2");
}
By  using @Autowired
private Student student;// this will make problem
//because IOC container will get confuse which bean to be called because it have 2 beans with same name.
//Thus, to get a particular bean object we use Qualifier.
@Qualifier("student2")
private Student student;

7. @RequestMapping
-------------------
 1. It is used to map web requests onto specific handler classes and/or handler methods. or
 Simply put, the annotation is used to map web requests to Spring Controller methods.
 @RequestMapping — by Path ---> @RequestMapping(value="/home",method=RequestMethod.GET)  //We cann use GET,POST,PUT etc.	

 @RequestMapping — the HTTP Method---> @RequestMapping("/api/v1") with @GetMapping,@PostMapping etc.

8. @ResponseBody
----------------
1.If we want to send the JSON response. It invokes the controller that the object return is automatically 
serialized into JSON and passed back to as HTTP response.  

9. @RequestBody
---------------
1. It is used inside the @RequestMapping. When backend applications get data in body of request as a json then
 RequestBody automatically deserialize into the java object. (Frontend JSON to Backend simple java Object).
Or we can say,@RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling 
automatic deserialization of the inbound HttpRequest body onto a Java object.

10. @RestController
-------------------
1. We can use @RestController instead of @Controller and @ResponseBody.
It eliminates the need to annotate every request handling method of the controller class with the
 @ResponseBody annotation.

11. @PathVariable
------------------
1. When we get data in url. We use @PathVariable. // like url is localhost:3000/v1/api/243/132
//Here we can get 243 and 132 in @PathVariable.
So we can get like  --->>>
 @RequestMapping(value="/v1/api/{userId}/{pageNo}")
 public String user(@PathVariable("userId") Integer userId,@PathVariable("pageNo") Integer pageNo){

 }
Thus,@PathVariable annotation can be used to handle template variables in the request URI mapping, and
 set them as method parameters.

 12. @RequestParam
 -----------------
 1.@RequestParam to extract query parameters, form parameters, and even files from the request.
 2. Annotation which indicates that a method parameter should be bound to a web request parameter.
@RequestParam("email") String email
if url like - // localhost:3000/v1/api?pageNumber=123
@RequestParam(defaultValue = "1",required = false)int pageNumber{
	try{

	}catch(){

	}
}

13.@Value
----------
By the help of this annotation, we are able to get the value inside of any mentioned properties inside "application.properties".
For Example --->
 @Value("${cassandra.keyspace}") //this cassandra.keyspace is inside the application.properties.
  private String keySpace;

@Param are to accept the data passed in query string


@MappedSuperclass
For ib support type of class

@PathVariable is used to accept variables passed in url

@RequestBody is used to accept the json object passed with request

@AutoConfiguration 

@Entity is used to define databases classes

@Service is used to indicate service class

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString 
all these can be used by lombook dependency @Data combination of all above

@Value is used forr using values from sproperties file
@Value("${source.file.name}")
String name;
this way we will get the name in name variable 

@RestController
combination of @Controller and @ResponseBody
@controller marks the class as a web request handler returns a String or view
@ResponseBody returns json or xml formate 
we are returning object this object is converted to json by ResponseBody

@RestController annotation in Sprint boot?
It is a combination of @Controller and @ResponseBody, used for creating a restful controller. 
It converts the response to JSON or XML. It ensures that data returned by each method will be 
written straight into the response body instead of returning a template.

@Configuration shown a particular class is a source of bean

In @Controller, we can return a view in Spring Web MVC.	
In @RestController, we can not return a view.

@EnableAutoConfiguration, in the scenario where you do not want it to be applied.
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

@MessageMapping for web socket

@SendTo for returning the message to a particular url(subscribed by a user)

@EnableWebSocketMessageBroker

@DestinationVariable same as path variables different name in message mapping 

@Qualifier if multiple classes implements a specific interface and we write 
@Autowired on the interface name then this will create ambuigity that which object we should get
here we can use @Qualifier to give specific name of the class that which class object we shold get


@Override, @Deprecated are marker interface

*******************************************************************************************
|========================|
|Write Custom Annotations|
|========================|

@Target({ElementType.Type,Element.Type.METHOD}) //If we use "ElementType.Type" then applicable for class,interface,enum and if we want for method then use "Element.Type.METHOD" 
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{      //multi valued Annotation
	int myValue() default 0;
	String name() default "Bishwajeet";
	String city() default "Jajpur"
}


@interface MyAnno{      //multi valued Annotation
	int myValue() default 0;
}

@interface MyAnno{} //marker interface 
--------------------------
Now we can use as a annotation, in java
@MyAnno //if we use like this, then default value get used
@MyAnno(myValue=369,name="Samal",city="Puri") //we will be able to provide the value
public class Demo{

}


MainExample.java
-----------------
class MainExample{
	public static void main(String []args){
		Demo d = new Demo();
		Class c = d.getClass();
		System.out.println(c.getName());

		MyAnno an = (MyAnno) c.getAnnotation(MyAnno.class); //getAnnotation Method return Annotation type thats why we need to TypeCast.
		System.out.println(an.myValue());
		System.out.println(an.name());
		System.out.println(an.city());
	}
}


Output
------
example.Demo

369
Samal
Puri 

*******************************************************************************************

BCryptPasswordEncryptor can be used to encrypt password before saving it in 
databases can be defined in main class like
@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
String password = bCryptPasswordEncoder.encode(registerDto.getUserPassword());
!(bCryptPasswordEncoder.matches(loginDto.getPassword(), u.getUserPassword())

*******************************************************************************************


*******************************************************************************************

public RestResponse register(@Valid @RequestBody UsersDto usersDto, BindingResult result)
{
	if (result.getAllErrors() != null){
                    return new StatusResponse(400, result.getAllErrors().get(0).getDefaultMessage(), null);
	}
}

*******************************************************************************************


*******************************************************************************************

ModelMAPPER class can be used to convert model to dto and vice versa
@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
@Autowired
ModelMapper modelMapper
Entity e = modelMapper.map(registerDto, Users.class);
u.setPassword(bCryptPasswordEncoder.encode(registerDto.getUserPassword()));
u.save();

**Communicator*************************************************************************
**************Communicator*************************************************************
**************************Communicator*************************************************
**************************************Communicator*************************************
**************************************************Communicator*************************
**************************************************************Communicator*************
**************************************************************************Communicator*
**************************************************************Communicator*************
**************************************************Communicator*************************
**************************************Communicator*************************************
**************************Communicator*************************************************
**************Communicator*************************************************************
*Communicator**************************************************************************
*************Communicator**************************************************************
*************************Communicator**************************************************
*************************************Communicator**************************************
*************************************************Communicator**************************
*************************************************************Communicator**************
*************************************************************************Communicator**
*************************************************************Communicator**************
*************************************************Communicator**************************
***********************************Communicator****************************************

first we register the endoint
then we subscribe to a channel
then we send and recive the messages on the specific channel
publiic se encrypt 
priivate se decrypt



http                 vs          WebSocket
request response   		  continous connection after handshake
for restfull apis		  live data           	
unidirectioal 			  bidirectional
half duplex			 	  full duplex




STOMP-WebSocket (Simple or Streaming Text Oriented Message Protocol)
* It is a basic protocol which defines us the basic functionalities like connect,send,subscribe.
*We can connect to the server with our client and we can send the message to subscribed one.

The WebSocket API enables web applications to handle bidirectional communications whereas 
STOMP is a simple text-orientated messaging protocol. The STOMP protocol is commonly used 
inside a web socket when a web app needs to support bidirectional communication with a web server.




endpoing 
to send the message to online user we can use
SimpMessageSendingOperations messageTemplate;
this is predifined class and provides us a varity of methods to send the messages
we can set the object , receiver and the destination 


Firebase Cloud Messaging (FCM) is a cross-platform messaging solution that lets you 
reliably send messages at no cost.
we can register our app on the fcm and we will get credentials to set in our 
properties file to set the notifications

http - stateless protocol
ws - statefull protocol
stomp - simple text oriented message protocol

.connect
.subscribe
.send

configuration file
-------------------
@EnableWebSocketMessageBroker class level
@Configuration
first WebSocketMessageConfig implements WebSocketMessageBrokerConfigurer
//interface contains two endpoints 
1st-> registerStompEndpoints(StompEndpointRegistry registry){
	registry.addEndPoint("/stomp-endpoint")
	.withSockJS();
}


2nd-> configureMessageBroker(MessageBrokerRegistery registry){
	registry.enableSimpleBroker("/topic");
	registry.setApplicationDestinationPrefixes("/app"); 
}


Create Controller
-----------------
@Controller
public class GreetingController{

}






101 ka login
{
"hash":"XgMRkN1fOADY63xQjPCq9Ex2R7RqXQE2484u7bi3/h43htjbH3TfWp5yfKg2oRdPEOXBrx89EagzoY8oDPOlbLQxu/h9B5MnkgGA+UIpNrENWoFHLCGPLgUK5ZLJLpWjQW+CaHofkBJVH7g3ffMmlsOOsBWN4YNicX15NPHfr4E=",
"type":"LOGIN",
"device":{
      "deviceType":"string",
      "deviceModel":"string",
      "version":"string",
      "osVersion":"string",
      "appVersion":"string",
      "udid":"string",
      "token":"string"
   }
}
102 ka login
{
"hash":"jzZQoxc8BUJos9LHMcd2FJMG9TCwk3bntxyMMikE4wQVwq4L7MBIGiyKu5k1o7VOzkb8V/8kkXruZOod137P4xOnbwdfd+Pj2XizaiwDCVF9G7P1RBykCo1pgXW1Nf2r4zRkzAOrpvpfDQJzkDmJ+xA1Q+IL2gasbRndWcP7AdA=",
"type":"LOGIN",
"device":{
      "deviceType":"string",
      "deviceModel":"string",
      "version":"string",
      "osVersion":"string",
      "appVersion":"string",
      "udid":"string",
      "token":"string"
   }
}

//get solo chat object
{
    "fromUserId":"String",
    "toUserId":"String",
    "createdAt":int, 
    "pageSize":int
}



{
	"content":"test one from 100 to 101",
	"toUser":"101",
	"fromUsers":"100"
}




*******************************************************************************************



***************************************Oauth2**********************************************


callback url







*******************************************************************************************

***************************************errorcodes**********************************************


404 Not FoundPermalink
	This is by far the most common error code you can get. It indicates that the URL 
	you used in your request doesn’t exist on the server.
	While this is a 4XX error, which usually means something on the client is wrong, 
	this can also indicate a server problem. Sometimes API URLs change after a version 
	update, but sometimes they change because something on the server went wrong.
	The best course of action is to check if you don’t have a typo in your client 
	code before checking if the API has issues.

401 UnauthorizedPermalink
	This status code means you haven’t yet authenticated against the API. 
	The API doesn’t know who you are and so it won’t serve you.
	For most APIs you need to sign up and get an API key. This key is 
	then used inside an HTTP header field when you send a request, telling the API who you are.

403 ForbiddenPermalink
    The forbidden status indicates that you don’t have permission to request that URL. 
    The difference to the Unauthorized status is that you’re authenticated, 
    but the user or role you’re authenticated for isn’t permitted to make the request.
    This also occurs when you have an authentication issue, like when using the wrong API 
	key or trying to access features your subscription plan doesn’t allow for.

400 Bad RequestPermalink
	The bad request status is one of the most generic error messages. 
	It implies that you did something wrong in your request. 
	If no additional error information is given in the response body, 
	you have to check the docs. You could be missing a query or body field in 
	the request, or a header could be wrong. It could also be that some of 
	your request data might have the an incorrect format.


429 Too Many RequestsPermalink
	Most API subscription plans have limits — the cheaper the plan, the fewer requests 
	per second are allowed for your API key.
	If you’re sending too many requests in a short amount of time, 
	consider throttling them in your client. This status can also indicate that you 
	hit a daily, weekly, or monthly limit on your account.
	Sometimes an API sounds like a right fit until you see the limits, and suddenly 
	it doesn’t work for your use case anymore. Check what’s part of your API subscription 
	before integrating, otherwise you may run into problems weeks or months after integrating the API.
	
The HTTP status code 500 is a generic error response. It means that the server encountered 
	an unexpected condition that prevented it from fulfilling the request. This error is 
	usually returned by the server when no other error code is suitable.

HTTP 409 error status: The HTTP 409 status code (Conflict) indicates that the request could 
	not be processed because of conflict in the request, such as the requested resource is not 
	in the expected state, or the result of processing the request would create a conflict within 
	the resource.

The HTTP 402 Payment Required is a nonstandard response status code that is reserved for future use. This status code was created to enable digital cash or (micro) payment systems and would indicate that the requested content is not available until the client makes a payment.

201 -created

200 -success

202 -accepted

1000 -CLOSE_NORMAL
	  Successful operation / regular socket shutdown

1001 -CLOSE_GOINGAWAY
	  Client is leaving (browser tab closing)

1002 -CLOSE_PROTOCOL_ERROR
	  Endpoing received a malformed frame

1003 -CLOSE_UNSUPPORTED
	  Endpoint received a unsupported frame
	  e.g. binary only endpoint received a text frame

1014 -Bad gateway	
	  Server acting as gateway received an invalid response

1015 -TLS handshake fail	
	  Transport Layer Security handshake failure

1013 -Try again later
	  Temporary server condition forced blocking client's request

1011 -server error
	  Internal server error while operating

1009- CLOSE_TOO_LARGE
	  if received frame is toooooooooooo large to be processed

400 client

500 server

200 success

300 redirection 

100 informational

504 gatewatTimeout






*******************************************************************************************

*********************************Interview**********************************************


Que: Difference bw spring and spring boot?
Ans: 1. embedded servers tomcat and jetty
	 2. embedded in memory database h2
	 3. entire app vs standalone apps
	 4. dependeny injections - auto configuration
	 5. more code vs less code
	 6. stater dependencies

difference bw spring boot and spring mvc







Que: What is Thymeleaf ?
Ans: Used with html5 to generate dynamic content
     can be used in place of jsp
	 capable of proccessing html,xml, javascript, css and plain text
	 mostly used for generating html view for web application
	 this is server side java engin not client side





Que: Can we change the port of the embedded Tomcat server in Spring boot?
Ans: Yes, we can change the port of the embedded tomcat server by using the application properties file. 
	 this file, you have to add a property of “server.port” and assign it to any port you wish to. 
	 server.port=8081. 







Que: Explain Tight vs loose Coupling?
Ans: Two classes implementing a interface which object we will get
	 in tight coupling when two classes are dependent on each other ie if one class is using the object 
	 of other class and object is created by new keyword it is called tight coupling
	 for example first class is car and second is travel then travel is dependent on car
 	 but if we want to used
	 bike then we must change all the code 
	 for solution we can use interface vechile and create a reference of vehicle and can create
 	 object of desired vehicle
	 ie multiple vehicles can implement the vehicle interface 
	 in case of spring boot we can write autowire on the interface variable and it will get their
	 object of the implemented class and if multiple claases are implementimg the interface 
	 then we will get the ambuigity and to solve this object
	 @Qualifier is used where we can specift the class name of which we want the object 

Que: Flow of bean Life Cycle?

Que: What is MVC Architecutre?

Que: What are WebHooks
     Third party calling api to inform us somthing is called web hooks
     Webhooks are automated messages sent from apps when something happens. 
     They have a message—or payload—and are sent to a unique URL—essentially 
     the app's phone number or address. Webhooks are almost always faster than 
     polling, and require less work on your end.


spring is a complete frameworks
springboot is module of spring
It does not provide support for an in-memory database.	It offers several plugins for working with an embedded and in-memory database such as H2.
To test the Spring project, we need to set up the sever explicitly.	Spring Boot offers embedded server such as Jetty and Tomcat, etc.
pringboot provides auto configuration 
for example we dont need extra controller for controlling
The primary feature of the Spring Framework is dependency injection.	The primary feature of Spring Boot is Autoconfiguration. It automatically configures the classes based on the requirement.
difficult VS ESAY


Spring Boot easily promotes the use of Microservice architecture because of 
it auto configuration, embedded servers and simplified dependency management. 
Spring Boot helps development teams to create services quickly and efficiently 
because there is little time spent with initial set up and downloading the 
appropriate application servers or packages. To coin Pivotal, developers can 
‘just run’ the application.

Spring MVC is a web-based framework that provides a 3-tier architecture system called 
the Model-View-Controller. The design of this architecture is to loosely couple each 
responsibility of the application logic.
The Model component handles the application data, while the View component handles 
the presentation layer that facilitates the application requests and presents the 
application response, and the Controller handles the incoming requests, creates 
proper models, and returns the appropriate request to the View. Spring MVC is and 
was used to create HTTP oriented web-based applications with lots of different 
configurations and environments

The major differences between Spring Boot and Spring MVC come down to differences 
between context and overall scale.

Spring MVC is a specific Spring-based web framework in a traditional sense. That means 
it requires manual build configurations, specifying dependencies separately, and the 
use an application server.

Spring Boot, on the other hand, is more like a module of Spring designed to package 
Spring applications or frameworks with automation and defaults.

So in theory one could have a Spring MVC project packaged as a Spring Boot application
Both can be classified as Spring frameworks however the scale of Spring Boot encompasses 
many types of Spring frameworks While, Spring MVC on the other hand specifies the design 
of the framework.

Spring-boot-starter	Core starter, including auto-configuration support, logging, and YAML

Spring IoC Container is the core of Spring Framework. It creates the objects, configures 
and assembles their dependencies, manages their entire life cycle. The Container uses 
Dependency Injection(DI) to manage the components that make up the application. 
It gets the information about the objects from a configuration file(XML) or Java Code 
or Java Annotations and Java POJO class. These objects are called Beans. Since the 
Controlling of Java objects and their lifecycle is not done by the developers, hence 
the name Inversion Of Control. 










To create a custom endpoint in Spring Boot 2.x, you can use the @Endpoint annotation.
To disable the auto-configuration property, you have to exclude attribute of 







starter dependencies
spring-boot-starter is a starter dependency and this makes a application a springboot application

maven
c drive m2 folder


a bean or a reference variable in entity class can be decleared as lazy so that
its object is not created during the initial run
it gets created only when it is used 
else all the beans and components are loaded on theinitial run

@AutoConfiguration makes configuration esay as in spring we were to design a main controller
which takes the request and forwards to the appropriate controller 
also lot of xml configuration was also required but in case of springboot this is managed automatically

Simply put, authentication is the process of verifying who someone is, 
whereas authorization is the process of verifying what specific applications, 
files, and data a user has access to.


*******************************************************************************************




















kafka 
distributed event streaming technology system
linkedin and twitter
rabitmq
amqp
advance message quiuing protocol
to transfer messages in queue


simplty agr samne vala abi connected nahi h or apn msg bhej rhe h toh queue me hol krne k lie
apn rabitmq and kafka use krte h

broker mtlb no of queues 
sonali msg behj rhi he
tu broker h  
multiple receiver h
producer and consumer
direct exchange me sonali key degi or agr consumer ne sam key di toh msg usko dedenge
fanout exchange 
sonali ne msg dia tu queue h 
msg sbko forward krdega
topic exchange 
isme apn pattern match hone pr msg dete h jese like operator ki working hoti h


rabbitmq me agr queue se recever ko msg dedia h toh msg queue me se delete hojaega
lekin apn kafka me retaintion period de skte h taki agr kuch time baad firre hame vahi message chahie 
toh ham get kr skte h



smtp simple mail tranfer protocol


kafka me exchange nahi hota h 
isme sidha consumer ka naam hi dedete h taki jo b user us naam ka jo use msg dedo



kafka is used more beacause it works on streaming(binary) data
 
heavy messeges can be partitioned in kafka bou not in rabitmq we can make multiple queues
asynchronous can be activated in rabbit mq














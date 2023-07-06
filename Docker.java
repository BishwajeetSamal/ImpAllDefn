What Is a Network Interface?
-----------------------------
A network interface is the point of interconnection between a computer and a private or public network. 

What is Unix Socket ?
----------------------
A UNIX socket, AKA Unix Domain Socket, is an inter-process communication mechanism that allows 
bidirectional data exchange between processes running on the same machine.


=========================================================================================================
---------------------------------------------------------------------------------------------------------
Docker
========
Note. If you want to create  container then you must required an image.
Ex -- doker container create alpine6.

2. If you want to provide instance names of images.
Example -- docker container run --name 

3. If you want to run image and and at the same time want to edit.
Example -- docker container run ****

4.If you want to delete after run 
Example -- delete container run -rm -it ****

5.How to create volume ?
docker volume create volume_name   
////////////check created volume
docker volume ls

Now we can mount the volume
Example -- docker container run -it-v vol-1:/app -v Volume_name:Container_directory



Bind Mounts
------------
11. docker container run -v /home/users:/app alpine


1. docker run --name my-own-postgres -e  POSTGRES_PASSWORD 


Task need to complete
-----------------------
1. Make our owm project using docker. Java.
2. Caching in Docker
3. Learn from Docker file


Containers
--------
1.Docker container technology was launched in 2013 as an open source Docker Engine.
2.Docker provides the ability to package and run an application in a loosely isolated environment called a 
container. 
3.The isolation and security allows you to run many containers simultaneously.
4.Containers are lightweight and contain everything needed to run the application.


Docker architecture🔗
---------------------
1.Docker uses a client-server architecture.
2.The Docker client talks to the Docker daemon, which does the heavy lifting of building, running, and 
distributing your Docker containers.
3.The Docker client and daemon can run on the same system, or you can connect a Docker client to a 
remote Docker daemon.
4.The Docker client and daemon communicate using a REST API, over UNIX sockets or a network interface.

Docker Client ----> docker build, docker pull, docker run
     ↓ (communicates via docker daemon)
Docker Host ---> Docker daemon + Containers + Images(like ubuntu, postgresql etc)
     ↓
Registry(Docker Hub) have Ngnix, ubunntu etc.

The Docker daemon
-------------------
The Docker daemon (dockerd) listens for Docker API requests and manages Docker objects such as 
images, containers, networks, and volumes. A daemon can also communicate with other daemons to manage 
Docker services.

The Docker client
-----------------
The Docker client (docker) is the primary way that many Docker users interact with Docker. 
When you use commands such as docker run, the client sends these commands to dockerd, which carries them out.
The docker command uses the Docker API. The Docker client can communicate with more than one daemon.

Docker registries
------------------
A Docker registry stores Docker images. Docker Hub is a public registry that anyone can use, and Docker is
 configured to look for images on Docker Hub by default. You can even run your own private registry.

When you use the docker pull or docker run commands, the required images are pulled from your configured 
registry. When you use the docker push command, your image is pushed to your configured registry.


Docker objects
--------------
When you use Docker, you are creating and using images, containers, networks, volumes, plugins, and other
 objects. This section is a brief overview of some of those objects.

 Images
 --------
An image is a read-only template with instructions for creating a Docker container.
Often, an image is based on another image, with some additional customization. 
For example, you may build an image which is based on the ubuntu image, but installs the Apache web server 
and your application, as well as the configuration details needed to make your application run.

Containers
------------
A container is a runnable instance of an image. You can create, start, stop, move, or delete a container
 using the Docker API or CLI. You can connect a container to one or more networks, attach storage to it, or
 even create a new image based on its current state.

Example docker run command
---------------------------
The following command runs an ubuntu container, attaches interactively to your local command-line
session, and runs /bin/bash.

 // docker run -i -t ubuntu /bin/bash

When you run this command, the following happens (assuming you are using the default registry configuration):

1.If you do not have the ubuntu image locally, Docker pulls it from your configured registry, as though you
 had run docker pull ubuntu manually.
2.Docker creates a new container, as though you had run a docker container create command manually.
3.Docker allocates a read-write filesystem to the container, as its final layer. 
4.Docker creates a network interface to connect the container to the default network, since you did not 
specify any networking options.
5.Docker starts the container and executes /bin/bash. 
6.When you type exit to terminate the /bin/bash command, the container stops but is not removed. 

Some commands
---------------
1.docker ps
----------
 List containers or This command is used to list the running containers.

2.docker ps --all OR docker ps -a
-------------------------------
Show all containers (default shows just running) / Show both running and
 stopped containers or This command is used to show all the running and exited containers.

3.docker ps -s
---------------
Show disk usage by container

4. docker pull
---------------
Usage: docker pull <image name> 
Pull an image or a repository from a registry or This command is used to pull images from the docker
repository(hub.docker.com)

6.docker images
---------------
To see which images are present locally, use the docker images command
This command lists all the locally stored docker images

7.docker run
-------------
Give Custom name
docker run -d --name container_name image_name


Run a command in a new container or This command is used to create a container from an image.
Usage: docker run -it -d <image name>  //image name like ubuntu, postgres

8.docker create
----------------
Create a new container

9.docker exec
--------------
Usage: docker exec -it <container id> bash
This command is used to access the running container

10.docker stop
--------------
Usage: docker stop <container id>
This command stops a running container

11.docker kill
---------------
Usage: docker kill <container id>
This command kills the container by stopping its execution immediately.
 The difference between ‘docker kill’ and ‘docker stop’ is that ‘docker stop’ gives the container time 
 to shutdown gracefully, in situations when it is taking too much time for getting the container 
 to stop, one can opt to kill it.

 12.docker commit
 -----------------
 Usage: docker commit <conatainer id> <username/imagename>
 This command creates a new image of an edited container on the local system

 13.docker build
 ----------------
 Usage: docker build <path to docker file>
 This command is used to build an image from a specified docker file

 14. docker rmi
 --------------
 Usage: docker rmi <image-id>
This command is used to delete an image from local storage

15.docker rm
--------------
Usage: docker rm <container id>
This command is used to delete a stopped container

16.docker login
---------------
This command is used to login to the docker hub repository

17.docker push
--------------
Usage: docker push <username/image name>
This command is used to push an image to the docker hub repository

Docker Compose
--------------
Docker Compose is basically used to run multiple Docker Containers as a single server.
Suppose if I have an application which requires WordPress, Maria DB and PHP MyAdmin.
 I can create one file which would start both the containers as a service without the need to start each 
 one separately. It is really useful especially if you have a microservice architecture.


1.docker run nginx // download from docker hub if not present locally
2. To provide a port to run use
docker run -p 8989:8989 nginx //here -p is to provide the post which nginx need to follow

------------------------------------------------------------------
//command to get IP for particular container in docker
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' c35a8b72e668
//c35a8b72e668 is container id   

http://172.17.0.2/  output 
-------------------------------------------------------------------
But as you close the terminal . Docker IP also stops working thus, we can use -d flag.
Now we can the command like
docker run -d -p 8989:8989 nginx

*if i want to remove all stopped containers then we can use 
docker system prune then yes

* -f flag in docker used to do it forcefully

* To move to a particular containter
docker exec -it <container_id> bash
  

*Now we see how to copy file in container // i means interactive and t means tty
docker exec -it <container_id> bash //we move to the container
create any random file if you wish to copy
exit // get out of the container
docker cp <source> <destination> //lets do the copy
docker cp <container_id>:file_name.txt giveName.txt  // this helps to copy the file from one container
to anathor container.

*Now we can create a image of the updated container 
docker commit <container_id>
we can give tag wich was none 
docker commit <container_id> RepositoryName/RepositoryName : Tag //Respository name like bishwajeet/nginx:6.7
 

======================================================================================================
Docker is written in the Go programming language and takes advantage of several features of the Linux 
kernel to deliver its functionality. ----------------------------------------------------------------
--------------------------------------
Docker uses a technology called namespaces to provide the isolated workspace called the container.
When you run a container, Docker creates a set of namespaces for that container.
These namespaces provide a layer of isolation. 

What is Jenkins and why we use it?
-----------------------------------
Continuous Integration is the most important part of DevOps that is used to integrate various DevOps stages.
 Jenkins is the most famous Continuous Integration tool.
Jenkins is an open-source automation tool written in Java with plugins built for Continuous Integration 
purposes. Jenkins is used to build and test your software projects continuously making it easier for 
developers to integrate changes to the project, and making it easier for users to obtain a fresh build.
 It also allows you to continuously deliver your software by integrating with a large number of testing 
 and deployment technologies.
 With Jenkins, organizations can accelerate the software development process through automation. 
 Jenkins integrates development life-cycle processes of all kinds, including build, document, test, 
 package, stage, deploy, static analysis, and much more.

=======================================================================================================

Springboot Docker
=================
Install docker in your machine 
--------------------------------

1. create springboot application, build rest apis

2. create a jar 

3. create dockerfile inside project named "DockerFile"

4. Inside docker file, add necessary things
**********************************************************************************|
     // # base docker images                                                      |
     FROM openjdk:1521                                                            |
                                                                                  |
      // # add label                                                              |
     LABEL maintainer = "javaguides.net" //some metadata for the docker image     |
                                                                                  |
      // # add jar file                                                           |
     ADD target/abc-demo-0.0.1-SNAPSHOT.jar  springboot-docker-demo.jar           |
                                                                                  |
     ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]                    |
***********************************************************************************

Now, we have docker file, now run
* docker build -t springboot-docker-demo:latest .  -> This command will cerate a docker image

* docker images -> This command helps to show all the images

* To run the image in a container -> docker run -p 8081:8080 springboot-docker-demo 

Now it will run the project in our container


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


KUBERNETES (Container management tool)
======================================
KUBERNETES is an opensource container-orchestration engine or container management tool, it automates
deploying, scaling and managing containerized application. (It will manages our containers at runtime.)

It is also known as "k8s"
It was initailly designed by google, and now its manintaining by "Cloud Native Computing Foundation (CNCF)"
It is open-source and written in go language.

container -> Docker, we can run any application in this docker container.


Management ->  K8S manages the "deploying", "Scheduling", "scaling" and "load balancing"  your application.
Tool

USECASE (Why k8s came into picture)
===================================
__________________________
Microservice 1 -> DB     |
     ↓                   |
   kafka                 | -> Dockerize Microservice-1 into container-1
     ↓                   |  same Dockerize Microservice-2 into container-2, pull kafka image and I can run this in container-3
Microservice 2 -> DB     |  , I can take pull of DB image from Dockerhub and run in container-4, Thus I can deploy on multiple
_________________________|    containers

Because here is very less number of containers, so I can manage it.
But practically we are not managing the 4-5 containers, but it can have nth numbers of containers for each application.

Like walmart, amazon we saw rare downtime because they have multiple containers to achieve the sacalability, and it is not
easy to manage the container manually.

Manually managing is not easy means, Deploying, Scheduling, Scaling, Load Balancing, Batch Execution, Roll Back, Monitoring. 
Thats why KUBERNETES came into picture

Write your code and pushed it to the container then everytime will be taken care by k8s.
We have other container mgmgt tool aswell, DOCKER COMPOSE, MARATHON etc.

K8S Components
==============

POD -In K8S we don't interact to the container directly. The container is wrapped to a functional unit called Pods.
     It can have single container or multiple containers as well. And Each pod is associated to the single IP address.
So that Pod-1 can talk to anathor Pod, like Pod-2.

NODE -> Pods are wrapped by node. It can have single Pod or can have multiple pod.

CLUSTER -> Nodes are wrapped by Cluster. It can have single Node or can have multiple node.

Replication Controller / Replica Set -> It act as a replica or backup of the pod. If a single pod get crashed due to 
     certain condition then it can lead to loss, so to handle this we use Replica set.
     We can create as many as repica set I want.
   -If any pod get crashed then it will bring the new replica set of that pod and will assign an ip to that pod.

Service -> As we know inside a node we can have multiple pods, lets name this as a frontend pod(where angular is running) 
and anathor pod named Backend pod.
* Each pod is assigned to a unique address. Because of this they can communicate to each other.
* If any pod will get crashed then immediately replica set will bring up a new pod with new IP address.
* But what if this will be keep going :-
 Then frontend will need  to connect to backend with new IP address again and again thus, Service came into picture.
 Now each pod will be associate to one service or multiple can group together to a single service with label and selector.

* Lets assume one pod associate to one service where service will provide a static ip and dns name.
Thus, each pod can communicate by DNS name instead of using the IP address.

* Service also play the role of load balancer where traffic coming to pods are handled by the service .

Deployment -> Deployments are kubernetes objects that are used for managing pods.

* You can scale you application by increasing the number of running pods or update the running application 
using Deployment object.

kubectl cerate deployment first-deployment - 
image=<DOCKER_IMAGE_NAME> --port = 8080 --replicas=4

Secrets, Config Map - Both secrets and config map used to store sensitive information like passwords, secret key, api key.
* These two are placed outside of pods.
* If inside node there is multiple pods, they can point to the same secrets and configMap. 
* In Secret we can add sensitive information with encrypted format, however in ConfigMap it stored as a plain text.
Lets say you are configuring your datasource properties then only the password you can configure in the secret and rest 
other details like url, driver-class name etc will be stored in Config map . 

ETCD -> *Kubernetes uses etcd as a key-value database store. It stores the configuration of the kubernetes cluster in etcd.
* It stores all the secret and configMap data inside etcd database.
* Max limit is 1mb to store secrets.


Basics and Architechture
========================

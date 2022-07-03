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
Example -- docker contain er run --name 

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


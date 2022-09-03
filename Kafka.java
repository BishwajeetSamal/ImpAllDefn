									KAFKA
									=====
Kafka is a distributed Message streaming platform that uses publish and 
subscribe mechanism to stream(means flow) the records(means data).
Originally developed by LinkedIn and later donated to apache foundation.
Kafka is open source.
Currently used by many big enterprises like LinkedIn, Airbnb, Netflix, 
uber, Walmart.

What is event streaming?
========================>
1.Event streaming is the digital equivalent of the human body's central nervous system.
2.Technically speaking, event streaming is the practice of capturing data in real-time from event
sources like databases, sensors, mobile devices, cloud services, and software applications in the form of streams of events.

What can I use event streaming for?
===================================>
Event streaming is applied to a wide variety of use cases across a plethora of industries and organizations.
 Its many examples include:
 *To process payments and financial transactions in real-time, such as in stock exchanges, banks, and insurances.
 *To track and monitor cars, trucks, fleets, and shipments in real-time, such as in logistics and the automotive industry.
 *To continuously capture and analyze sensor data from IoT devices or other equipment, such as in factories and wind parks.
 *To collect and immediately react to customer interactions and orders, such as in retail, the hotel and travel industry, and mobile applications.
 *To monitor patients in hospital care and predict changes in condition to ensure timely treatment in emergencies.
 *To serve as the foundation for data platforms, event-driven architectures, and microservices.

 Apache Kafka® is an event streaming platform. What does that mean?
 ==================================================================

 -----------****
 Apache kafka is used for building real-time data pipelines and streaming applications,
 Uber, Spotify and slack are few companies who use Kafka in 
 their technology stack.
Need Of Kafka
=============
Problems faced without Kafka
============================
            ↓
*The current-day industry is emerging with lots of real-time data that needs to be
processed in real-time.
For example :-
> Sensor data that is used to predict the failure of a system ahead of time.
> Real-time economic data that is based on the preliminary estimates and is frequently
adjusted for better estimates to be available. So this is all of the financial data which
is being generated from the stocks and so on.

 Now what happens is > Organisations can have multiple servers at front-end and back-end 
 like the Web or Application Server for hosting websites or applications.

So All of the servers will need to communicate with the database
server, this we will have multiple data pipelines connecting
all of them to the database server.

FrontEnd , Application1, Application2, ChatServer <----> Database Server, Security System,
Realtime Monitoring, Other Services, Data Warehouse etc will communicate i.e.
All the frontend will interact with backend servers which make many data pipelines.

Here we have 4 servers on frontend and 5 servers in backend. So here we can see
about 50 data pipelines and this is huge amount of data pipeline and 
dealing with these data pipelines become cumbersome and time consuming task.

*Data pipelines are getting complex witht the increase in the number of system.
*Adding a new system or a server requires more data pipelines which will
make a data flow more complicated.
*Managing these data pipelines becomes very difficult  as each pipeline has its own
set of requirements.
*Adding or removing some pipelines is difficult in such cases.

How does KAFKA resolve this problem ?
======================================
Kafka is basically a messaging system. 
So what is messaging system, Consider this is a system between the frontend servers and the backend servers.
It decouples data pipelines. Now what happens is you have got the producers which produces all
of the messages or generate all of the data and all of the data stored in the form of the stream
in the Kafka cluster.

So you can consider the Kafka cluster group of servers which are known as brokers.

            Producer, Producer, Producer -> Kafka Cluster <- Consumer, Consumer, Consumer
Now all of the data is being generated in real-time from these producers and the data is stored in streams called Kafka Cluster.
Now the consumers generate the request and it takes the or consumes the data from the Kafka cluster.
So this is how process flows.
So all the producers generates all the data which is stored in the Kafka Cluster and from this Kafka
cluster Consumers consumes all of the data. So here data Pipelines have decreased over here.


KAFKA
=====
Apache Kafka is an open-source, distributed, publish-subscribe messaging system that manages 
and maintains the real-time stream of data from different applications, websites etc.

So this basically means that this is an intermediate system between all the producers and all
of the consumers. And it basically provides the proper system which we can deal and maintain
the real-time stream of data so Apache Kafa Basically.

*Apache Kafka was originated at LinkedIn, later became an open-sourced Apache project in 2011,
and then the first-class Apache project in 2012.
*Kafka is written in Scala and Java
*Kafka is fast, scalable, durable, fault-tolerant and distributed by design.

**Kafka was originally developed at LinkedIn, and was subsequently open sourced in early 2011.

Lets Understand the Solution Provided by Kafka
===============================================
*Apache Kafka reduces the complexity of data pipelines.
*It makes communication between systems simpler and managable.
*With  Kafka, it is easy to establish remote communication and send data across a network.
*We can establish asynchronous communication and send messages with the help of Kafka.

__________________________________________________________________________________
asynchronous communication -> means that the producers over here keep on sending the messages
in the form of the stream to Kafka Cluster and they donot have to wait for an acknowledgement
from the Kafka clustered. So these producers will keep on sending the messages which would be
stored in the Kafka cluster and they would be consumed by all of these consumers over here so
___________________________________________________________________________________

*It ensures reliable communication between all the producers and all of the consumers.

Kafka Features
================
1.Scalibility
2.High Volume
3.Fault Tolerance
4.


Kafka is highly scalable in nature because it has distributed systems with no downtime. Means
Lets Say if you has just one server which would take care of all of the messages consuming
from the producers and only this serversends all of the messages back to the consumer now
dealing with the huge amount of data by a single server is very difficult, so this is where
they've got something as a kafka server who have we got multiple brokers and all of these 
multiple brokers simultaneously take care of all of the messages coming from the producer 
over there and Kafka can also take care of huge volume of data so kafka can take care of 
terabytes of data which is continiously being generated by all of the producers and it can 
seamlessly send them to the consumers at the backend and kafka also provides fault tolerance
because if there is failure of one node then all the data which is present in that particular 
node would have a replicas stored in some other systems so lets say if there is one broker 
which feels then the data which is present on that broker would also be present in two or
three more brokers. So this is how it provides fault tolerance and Kafka also provides 
reliablity because it has distributed partition replicated and fault tolerant next Kafka
also provides distributed commit logs that as messages persist on the disks as fast as 
possible so the producer sends a message and this message is immediately stored in the 
form of a distributed log in the disk and the performance of apache Kafka is very well.

Performance of Kafka  is good, basically mean is "high throughput". Throughput mean is 
basically the amount of information which is being passed in a particular amount of time.
There are also called Producer throughput and Consumer Throughput.

So Producer Throughput is the amount of information which the producer is generated in a
particular amount of time and the Consumer Throughput is the amount of data that consumers can
consume in a particular amount of time.
So this is how Kafka ensures that there is very high performance and Kafka also provides 
zero downtime. Now Kafka is very fast and guarentee zero downtime and zero data loss and 
anathor feature of Kafka is it is extensible. So there are many ways by which applications 
can plug in and make use of Kafka. So you can used on any platform and use it for multiple
purposes.

Kafka Components
================





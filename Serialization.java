												Serialization
												=============
In the process of serialization the object get converted into Byte Stream. This byte stream either saved into memory
or database or in File. This bytestream is transferred to JVM2 to from JBM1. This bytestream will deserialize 
and the object is retreived to the original state and will be executed in JVM2.

Thus, Serialization in Java is the process of converting the Java Code Object into a Byte stream, to transfer the 
Object code from one JVM to anathor and recreate it using the process of Deserialization.

Why do we need Serialization ?
===============================
1.Communication
-------------------
Serialization involves the procedure of object Serialization and transmission. This enables multiple computer 
systems to design, share and execute objects simultaneously.

2.Persistence
---------------
The state of any object can be directly stored  applying Serialization on to it and it can be stored into a database
so that it can be retrieved later.
Note that only the particular state of an object is stored here not the entire object.

3.Deep Copy
------------
Cloning process is made simple by using Serialization and an exact replica of object is obtained by the process
of serializing the object into an byte array and then deserializing it..

4.Caching
------------
The time consuming to building the object is more compared to the time required for deserializing it. Hence 
we can prove that serialization mininizes the time consuming by caching the gaint object.

5.Cross JVM Synchronization
-----------------------------
The major advantage of serialization is that it works across on different JVMs that might be running on different 
Architechtures or Operating System. 

How do we Serialize an object
==============================
A java object is Serializable and only if its class or its parent class is implementing either of the two libraries
1. java.io.Serializable
2.java.io.Externalizable

Advantages 
===========
* Serialization process doesnot require third party software.
* The Serialization procedure is simple.
*Serialization process id universal.
*It is easy to use and simple to customize.
*Serialized data stream support Encryption, Compression, Authentication and secure java computing.
*Many critical technologies relying on Serialization. 
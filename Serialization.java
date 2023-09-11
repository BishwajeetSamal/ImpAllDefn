												Serialization
												=============
In the process of serialization the object get converted into Byte Stream. This byte stream either saved into memory
or database or in File. This bytestream is transferred to JVM2 to from JBM1. This bytestream will deserialize 
and the object is retreived to the original state and will be executed in JVM1.

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

1. Introduction
================
* Serialization is the conversion of the state of an object into a byte stream
* serialization is the conversion of a Java object into a static stream (sequence) of 
bytes, which we can then save to a database or transfer over a network.


2. Serialization and Deserialization
====================================
* The serialization process is instance-independent; for example, we can serialize 
objects on one platform and deserialize them on another. 

* Classes that are eligible for serialization need to implement a special marker 
interface, Serializable. 

* Both ObjectInputStream and ObjectOutputStream are high level classes that extend 
java.io.InputStream and java.io.OutputStream, respectively.

* ObjectOutputStream can write primitive types and objects to an OutputStream 
as a stream of bytes. We can then read these streams using ObjectInputStream.
_________________________________________________________________
* The most important method in ObjectOutputStream is:

public final void writeObject(Object o) throws IOException;
__________________________________________________________________
This method takes a serializable object and converts it into a sequence (stream) of bytes.



* ObjectInputStream is:
______________________________________________________
public final Object readObject() 
  throws IOException, ClassNotFoundException;

______________________________________________________
This method can read a stream of bytes and convert it back into a Java object. 
It can then be cast back to the original object

Note ->  static fields belong to a class (as opposed to an object) and are not serialized.
* we can use the keyword transient to ignore class fields during serialization


*Let’s illustrate serialization with a Person class. Note that static fields belong 
to a class (as opposed to an object) and are not serialized. Also, note that we 
can use the keyword transient to ignore class fields during serialization:


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    static String country = "ITALY";
    private int age;
    private String name;
    transient int height;

    // getters and setters
}


The test below shows an example of saving an object of type Person to a local file, and 
then reading the value back in:

@Test 
public void whenSerializingAndDeserializing_ThenObjectIsTheSame() () 
  throws IOException, ClassNotFoundException { 
    Person person = new Person();
    person.setAge(20);
    person.setName("Joe");
    
    FileOutputStream fileOutputStream
      = new FileOutputStream("yourfile.txt");
    ObjectOutputStream objectOutputStream 
      = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(person);
    objectOutputStream.flush();
    objectOutputStream.close();
    
    FileInputStream fileInputStream
      = new FileInputStream("yourfile.txt");
    ObjectInputStream objectInputStream
      = new ObjectInputStream(fileInputStream);
    Person p2 = (Person) objectInputStream.readObject();
    objectInputStream.close(); 
 
    assertTrue(p2.getAge() == person.getAge());
    assertTrue(p2.getName().equals(person.getName()));
}

We used ObjectOutputStream for saving the state of this object to a file using 
FileOutputStream. The file “yourfile.txt” is created in the project directory. 
This file is then loaded using FileInputStream. ObjectInputStream picks this 
stream up and converts it into a new object called p2.

* Note ->
=========
* When a class implements the java.io.Serializable interface, all its sub-classes are 
serializable as well. 

Conversely, when an object has a reference to another object, these objects must 
implement the Serializable interface separately, or else a NotSerializableException 
will be thrown:

public class Person implements Serializable {
    private int age;
    private String name;
    private Address country; // must be serializable too
}


If one of the fields in a serializable object consists of an array of objects, then 
all of these objects must be serializable as well, or else a NotSerializableException 
will be thrown.
										JVM (Java Virtual Machine)
										==========================

Virtual machine is a software simulation of a machine which can perform operations similiar
to physical machine.

Virtal machine is not physically present.
Multiple vm can exist within a single hot at one time.


JVM is a runtime engine responsible to run java based applications.

It has two main tasks:-
1. load .class file
2. execute .class file.


The JVM is a virtual machine that executes Java bytecode. It provides an environment in which
Java programs can run independent of the underlying hardware and operating system.

.java -- (compile) --> .class (byte code) --> Now this .class file goes to JVM.


Class Loader
===========
a. Loading
-----------
* It will read .class file and store corresponding information information in the method area.
For each class file, JVM will store following indormation the method area:

# Fullu Qualified class name
# Fully Qualified parent class name
# Methods information
# Variables Information
# Constructor Information
# Modifiers Information
# Constant Pool Information etc.

There are three types of class loaders:-
1. Bootstrap ClassLoader -> responsible to load the classes present in rt.jar 
(rt.jar file is present in bootstrap classpath i.e. jdk\jre\lib)

2. Extension ClassLoader -> responsible to load the classes from classes from extension class path (i.e.
jdk\jre\lib\ext\*.jar)


3. Application ClassLoader -> responsible to load the classes from application classpath. It interally uses
environment variable class path.


b. Linking
-----------
In linking three activities are performed:-

1. Verification -> It verifies the .class files. It checks for the valid bytecodes. This makes the Java
secure aswell. If it gets any invalid bytecode then the .class file will not going to be executed.
If verification fails, then JVM will provide "java.lang.VerifyError" exception.

2. Preparation -> It basically helps to allocat memory to the class level data like static variables,
and it initializes the default value (no the oriiginal values).


3. Resoluton -> It is a process of replacing the symbolic names in our program are replaced with
 original memory references from method area.

c. Initalization
-----------------
In this process, two activities will be performed :
1. All static variables are assingned with oriiginal values.
2. static blocks will be executed from top to bottom.

Memory Areas
============
It has many components:-
1. Method Area (It stores the class level Data. like Fully Qualified class name. Fully Qualified parent
class name, variables, methods,constructor information)
* Method area is created when JVM is started.
*It stores .class file information and static variables.
*Per JVM one memory area, therefore multiple threads can access this area, so it is not thread safe.


2. Heap Memory ->* Heap area is created when JVM is started.
* It stores objects, instance variables and arrays (as every arrays is an object in java.)
*It can be accessed my multiple threads, so the data stored in heapo area is not thread safe.

3. Stack Area -> *Whenever a new thread is created, a separate stack area will also be cerated.
*It stores the current running method and local variables.
*When the method is completed, the corresponding entry from the stack will be removed.
*After completing all the method calls, the stack will become empty and that empty stack will be destroyed
by the JVM just before terminating the thread.
* The data stopred in the stack is available only for the corresponding thread and not available to the 
remaining thread, so this area is thread safe.


4.PC Register -> * It holds the address of the next executing instruction.
* For every thread, a separate pc register is cerated, so it is also thread safe.


5. Native Method Area -> All native method calls involed by the thread will be stored in the corresponding
native method stack.
*For every thread seperate native method dtack will be created.
*It is also thread safe.

Execution Engine
================
* Execution engine is resposible to execute java class file.
* It contains mainly two components:-
1. Interpreter -> A odule that alternatively decodes and executes every statement or line in some body of code.
* The java Interpreter decodes and executes bytecode for the JVM.
--------------------------------------------------------------------------
	byte code -> interpret -> machine code or native code -> execute
--------------------------------------------------------------------------


2. JIT Compiler -> JIT stands for Just-in-time which means that code gets compiled when it is needed, not 
before runtime.

* The main purpose of JIT compiler is to improve performance.

* JVM maintains a count as of how many time a function is executed. If this count exceeds a predefined limit
or threashld value, the JIT compiles the code into machine language which can directly be executed,
by the processor (unlike the normal case in which javac compile the code into bytecode and then java.)

* Also next time this function is calculated same compiled code is executed again unlike normal interpretation
in which the code is interpreted again line by line. This makes executin faster.

* JIT compilation is applicable only for the repetedly required methods, not for every method.



Java Native Interface
=====================
*An Interface that allows Java to interact with code written in anathor language.
* It acts as mediator for java method calls & the corresponding native libraries. i.e
JNI is responsible to provide information about native libraries to the JVM . 

* Native Method library provides or holds native library information.
* The java command-line utility is an example of one such application, that launches Java code in JVM.

Native Method Libraries
========================






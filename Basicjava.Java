										🔥🔥  DESIGN PATTERNS
										  	  ================
Design Patterns are very popular among software developers. 

In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in 
software design. A design pattern isnt a finished design that can be transformed directly into code. 
It is a description or template for how to solve a problem that can be used in many different situations.
The 4 peoples created the design patterns. They are also called Gang Of 4.

It is classified into three design patterns:-

1.Creational patterns provide object creation mechanisms that increase flexibility and reuse of existing code.
-------------------------------------------------------------------------------------------------------------
2.Structural patterns explain how to assemble objects and classes into larger structures, while keeping these 
structures flexible and efficient.---------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------
3.Behavioral patterns take care of effective communication and the assignment of responsibilities between objects.
---------------------------------------------------------------------------------------------------------------


1. Creational Design Patterns :-
-----------------------------
In software engineering, creational design patterns are design patterns that deal with object creation
 mechanisms, trying to create objects in a manner suitable to the situation. 
1.Singleton --(i.)Singleton pattern restricts the instantiation of a class and ensures that only one instance of
 the class exists in the java virtual machine.
 (ii.)The singleton class must provide a global access point to get the instance of the class.
 (iii.)Singleton pattern is used for logging, drivers objects, caching and thread pool.
 Java Singleton Pattern Implementation
 *************************************
To implement a Singleton pattern, we have different approaches but all of them have the following common concepts.
*Private constructor to restrict instantiation of the class from other classes.
*Private static variable of the same class that is the only instance of the class.
*Public static method that returns the instance of the class, this is the global access point for outer world
 to get the instance of the singleton class.
------------------Program for Single Dessign pattern-----------------------------


package com.journaldev.singleton;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;
    
    private StaticBlockSingleton(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new StaticBlockSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}


-----------------------------or------------------------------------|______________________________________
class SingleTon{                                                   |Learn it for Compulsory.**************|
    static private singleObj=null;                                 |____(V.V IMP)__________________________________|
    private Singleton(){                                           |
                                                                   |
    }                                                              |
    public static Singleton getInstance(){                         |
        if(singleObj==null){                                       |
            singleObj = new SingleTon();                           |
        }                                                          |
        return singleObj;                                          |
    }                                                              |
}                                                                  |
                                                                   |
------------------------------end----------------------------------|-------------------
2.Factory-- Factory method, that means there is a method which is a factory, and in general factories are 
involved with creational stuff and here with this an object is being created. It is one of the best ways to
 create an object where object creation logic is hidden to the client.

3.Abstract Factory
4.Builder
5.Prototype


2. Structural Design Patterns
-----------------------------
6.Adapter
7.Composite
8.Proxy
9.Fly Weight
10.Facade
11.Bridge
12.Decorator


3.Behavioural Design Patterns
-----------------------------
13.Template method
14.Mediator
15.Chain of Responsibility
16.Observer
17.Strategy
18.Command
19.StackTraceElement
20.Visitor
21.Iterator
22.Interpreter
23.Memento

This does not mean that all design patterns should use in a single software.
It depennds upon the requirement.







									🔥🔥 AOP(Aspect Oriented Programming)
										 ================================
1.Aspect oriented programming(AOP) as the name suggests uses aspects in programming.
2.It can be defined as the breaking of code into different modules, also known as modularisation, where the aspect
is the key unit of modularity.
3.Aspects enable the implementation of crosscutting concerns such as- transaction, logging not central to business
logic without cluttering the code core to its functionality. 
Let’s have a look at the three dominant frameworks in AOP:
*AspectJ
*JBoss
*Spring

1.Aspect: The class which implements the JEE application cross-cutting concerns(transaction, logger etc) is known 
as the aspect. 
2.Weaving: The process of linking Aspects with an Advised Object. It can be done at load time, compile time or 
at runtime time. Spring AOP does weaving at runtime.
3.Advice: The job which is meant to be done by an Aspect or it can be defined as the action taken by the Aspect 
at a particular point.
There are five types of Advice :-
(i).  @Before
(ii). @After
(iii).@AfterReturning
(iv). @Around
(v).  @AfterThrowing


It is the methodology which we will create the applications like OOP.
AOP gives the flexibility for the cross-cutting concerns.
What AOP says us that just try to remove those cross-cutting concerns from the main business logic and keep 
those things at different place and run it separately.
Thus, business logic is different and cross-cutting concerns like (logging,authenticating, authorization and 
sanitizing) the data.

We can use the aspectJ library to implement the AOP with springboot framework.
<dependency>
<groupId>org.springframework</groupId>
<artifact>spring-context</artifact>
<version>5.3.14</version>
</dependency>

<dependency>
<groupId>org.aspectj</groupId>
<artifact>aspectjrt</artifact>
<version>1.9.7</version>
</dependency>


<dependency>
<groupId>org.aspectj</groupId>
<artifact>aspectjweaver</artifact>
<version>1.9.7</version>
</dependency>

@Component
@Aspect
public class LoggingAspect{
	//Suppose this is the method which we want to call before any method.
	@Before("execution(* demo.ShoppingCart.checkout())") //here * means allow any return type
	public void logger(){
		System.out.println("Loggers");
	}
}


//Suppose i want to execute or call the logger method before the execution of checkout method then we can use @Before
public class ShoppingCart{
	public void checkout(){
		System.out.println("Checkout method called");
	}
}

It won't work brecause we need to enable  the AOP to use it. we can use'
@EnableAspectJAutoProxy

Many point-cuts annotations are like.
@After
@AfterReturningAValue 
@AfterThrowingAValue
@AroundTheMethod
@Pointcut("within(demo..*)")


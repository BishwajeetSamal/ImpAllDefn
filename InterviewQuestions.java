
JAVA INTERVIEW QUESTIONS
---------------------------------------------------------------------------------------
Que 1. Can main method be overloaded and Overrided ?
Ans1. (1).The main method can be overloaded but cannot be overridden in Java.
(2).The main is a static method and the static method cannot be overridden in Java.
(3).Overloading takes place at compile time and overriding takes place at runtime.
-----------------------------------------------------------------------------------|
/**																				   |
 * Java Program to show that you can overload main method in JAVA   			   |
 * but you cannot override main method.											   |
 * 																				   |													   |				
 */																				   |
public class Helloworld {														   |
																				   |
    /**																		       |	
     * Standard main method, JVM will only call this method	                       |
     * even if you provided multiple overloaded version.	                       |
     * 																			   |
     */																			   |
    public static void main(String[] args) {						               |
        System.out.println("Inside main(String[] args) method ....");              |
       																			   |
    }																	           |
    		                                                                       |
    																			   |
    /**																			   |
     * An overloaded main method which accepts Integer[] instead of                |
     * String[] as argument. 													   |															   |
     */																	       	   |		
    public static void main(Integer[] args){                              		   |
        System.out.println("Inside main(Integer[] args) method ....");			   |
    }																			   |
    																			   |
    																			   |
    /**																			   |
     * Another overloaded main method which accepts Double[] instead of 		   |
     * String[] as argument. 													   |																   |
     */																			   |
    public static void main(Double[] args){										   |
        System.out.println("Inside main(Double[] args) method ....");			   |
    }																			   |
    																			   |
}																				   |			
																				   |
Output																			   |
Inside main(String[] args) method ....	It will work for String args.			   |	
---------------------------------------------------------------------------------------

Que 2. Why we need to use Getters and Setters ?
Ans2. (1).A setter updates the value of a variable, while a getter reads the value of a variable.
(2). for accessing the variables outside a class without getters/setters, we have to mark those as public, protected, or default.
Thus,we are losing control over the data and compromising the fundamental OOP principle – encapsulation.
(3). Since anyone can change the non-private fields from outside the class directly, we cannot achieve immutability.
(4).  If you make a field public, it means you provide direct access to the caller. Then, the caller can do anything with your 
field, either knowingly or unknowingly. 
But, if you provide a getter/setter, you provide them indirect access while taking full control.
(5).etters/setters, we create a provision to add any validation method in the future, currently, there is no 
validation, but if anything
oes wrong in the future we just add validation logic in the setter.

Que3 . What is the Difference Between == and .equals() Method in Java ?
Ans3. 1. The main difference between is [.equals() is a method and == operator ].
2. We can use == operators for reference comparison (address comparison) and .equals() method for content comparison.
In simple words, == checks if both objects point to the same memory location whereas .equals() evaluates to the comparison 
of values in the objects.

|---------------------------------------------------------------------------|	
|													   						|
|	public class Test {														|
    public static void main(String[] args)
    {
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
 
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true
    }
}											
|																		    |
|	  												                        |
|---------------------------------------------------------------------------|
Explanation: Here, we create two objects, namely s1 and s2. 

Both s1 and s2 refer to same objects.
When we use the == operator for s1 and s2 comparison, the result is true as both have the same addresses in the string constant pool.
Using equals, the result is true because it’s only comparing the values given in s1 and s2.

-------------------------------------------
Que 4. What is Singleton Class ? //Runtime is a singleton class. For any java class if we are allowed to create 
// only one object,such type of class is called singleton class.

Ans4. In object-oriented programming, a singleton class is a class that can have only one object 
(an instance of the class) at a time.
Remember the key points while defining class as a singleton class that is while designing a singleton class: 

Make a constructor private.
Write a static method that has the return type object of this singleton class. Here, the concept of Lazy 
initialization is used to write this static method.
|---------------------------------------------------------------------------|	
|													   						|
|	public final class Test {
    =========================================================================================
    |private static Test t = new Test(); //This approach is wrong for outside creating the object by using new keyword because constructor is private but wer can do inside class.
    =========================================================================================
    private static Test t; //Its default value is null
    //private constructor
    private Test() {        
    }
    //public factory method
    public static Test getTest() {
        if(t == null) {
            t = new Test();
        }
        
        return t;
    }
}											
|																		    |
|	  												                        |
|---------------------------------------------------------------------------|
Advantage of Singleton class
-----------------------------
1. Memory performance Improvement.
2. Reuse same object for every similiar requirement.
3. Singleton prevents other objects from instantiating their own copies of the Singleton object, ensuring that all objects access the single instance. 

Que5.Difference between string stringbuffer and stringbuilder ?
//Strings are one of the most popular classes used while programming in Java by developers. 
//But, since Strings are immutable, Java came up with two utility classes: StringBuilder and StringBuffer 
//to make the String manipulations easy.
Ans5. Java provides three classes to represent a sequence of characters: String, StringBuffer, and 
StringBuilder.
1. String is immutable whereas StringBuffer and StringBuilder are mutable classes.
2. StringBuffer is thread-safe and synchronized whereas StringBuilder is not. It means two threads cannot call the methods of StringBuffer simultaneously.
3. StringBuffer is less efficient than StringBuilder and StringBuilder is faster than StringBuffer. 
4. StringBuffer was introduced in Java 1.0 
5. String concatenation operator (+) internally uses StringBuffer or StringBuilder class.

Que6. String pool in Java?
Ans 6.  1.String Pool in Java is a pool of Strings which is stored in Java Heap Memory. String Pool is a storage area in Java heap.
2. It is also known as String Intern Pool or String Constant Pool.
3.By default, it is empty and privately maintained by the Java String class.
4.Whenever we create a string the string object occupies some space in the heap memory. Creating 
a number of strings may increase the cost and memory too which may reduce the performance also.
5.The JVM performs some steps during the initialization of string literals that increase the performance and decrease the memory load. To decrease the number of String objects 
created in the JVM the String class keeps a pool of strings.

Que7. What is thread-safe in Java ?
Ans7 . As we know Java has a feature, Multithreading, which is a process of running multiple threads 
simultaneously. When multiple threads are working on the same data, and the value of our data is changing, that
 scenario is not thread-safe and we will get inconsistent results. When a thread is already working on an 
 object and preventing another thread on working on the same object, this process is called Thread-Safety.

 How to achieve Thread Safety
There are four ways to achieve Thread Safety in Java. These are:

1. Using Synchronization -Synchronization is the process of allowing only one thread at a time to complete the 
particular task. Or It is a process by which we control the accessability of multiple threads to a particular
shared resource.
***Without Synchronization, data inconsistency and thread interference may occur.
***The problem with Synchronization is that it increases the waiting time period of threads. And second is 
Created the performance issues. To overcome the Synchronization disadvatages, java provides one package
i.e. java.util.concurrent.
***Static Synchronization is for the class the class level.


We can use synchronized keyword for method to make it synchronized.
We can use synchronized block for reducing the waiting time for other code to accessed by threads.
2. Using Volatile Keyword.
3. Using Atomic Variable.
4. Using Final Keyword.-Final Variables are also thread-safe in java because once assigned some reference of an
object It cannot point to reference of another object. 

Que8. Difference between final, finally and finalize ?
Ans8. The final, finally, and finalize are keywords in Java that are used in exception handling.
------------------------------------------------------------ 
1. final(lowercase) is a reserved keyword in java.
	Use with variables ,methodsa nd class.We cannot change value after the first initialization.
	final int a=10;
	a=a+20; //error -----//cannot change value
	* final method cannot be override but can overloaded.
	*private, static, final // we can overload but cannot be overrided.
	* If the class is final then we will not able to inherit that.
	--------------------------------------------------------
	2. finally
	It is a block i.e.
	finally{

	}

	Use it with either try or try_catch block.
	try{}finally{}   
	//or
	try{}catch(){}finally{}
	It is used to realease the resource or we write the cleanup code.
If i do not want to use finally then just terminate the program.
We can do it by using // System.exit(0); 
	---------------------------------------------------------------
	3. finalize(){}
	It is a method .Finalize() is the method of Object class. Perform clean-up activities and minimize memory leaks.
	* It is executed just before Garbage Collector.
	Any resource that is open it can be closed by using finalize() method.
	----------------------------------------------------------------------------------
	----------------------------------------------------------------------------------
	****************************************************************************************

	 What is Data Warehousing?
The process of collecting, extracting, transforming, and loading data from multiple sources and storing them in
 one database is known as data warehousing.
--------------------------------------------------------------------------------
 Q- Explain different types of relationships amongst tables in a DBMS.
Ans-Following are different types of relationship amongst tables in a DBMS system:

One to One Relationship:  This type of relationship is applied when a particular row in 
table X is linked to a singular row in table Y.

One to Many Relationship: This type of relationship is applied when a single row in 
table X is related to many rows in table Y.

Many to Many Relationship: This type of relationship is applied when multiple rows in 
table X can be linked to multiple rows in table Y.

Self Referencing Relationship: This type of relationship is applied when a particular row in 
table X is associated with the same table.
-----------------------------------------------------------------------------------
Que->Explain the difference between intension and extension in a database.
Ans->Following is the major difference between intension and extension in a database:

Intension: Intension or popularly known as database schema is used to define the description of the database
 and is specified during the design of the database and mostly remains unchanged.

Extension: Extension on the other hand is the measure of the number of tuples present in the database at any 
given point in time. The extension of a database is also referred to as the snapshot of the database and its value 
keeps changing as and when the tuples are created, updated, or destroyed in a database.
------------------------------------------------------------------------------------
Que->Explain the difference between the DELETE and TRUNCATE command in a DBMS.
Ans->1. DELETE command: this command is needed to delete rows from a table based on the condition provided by the 
WHERE clause.
2. It can be rolled back if required.
3. It maintains a log to lock the row of the table before deleting it and hence it’s slow.

TRUNCATE command: this command is needed to remove complete data from a table in a database. It is like a DELETE 
command which has no WHERE clause.
It removes complete data from a table in a database. It can be lead to data loss.
It doesn’t maintain a log and deletes the whole table at once and hence it’s fast.

Que->Why the main () method in Java is always static?
Ans->Java main() method is always static, so that compiler can call it without the creation of an object or 
before the creation of an object of the class. In any Java program, the main() method is the starting point from
 where compiler starts program execution.
============================================================================================
Java Interview Question (Predikly) Date: - 27/06/2022 Time:4:00 PM (Bishwajeet Samal)
----------------------------------------------------------------------------------------------------------------------------

Q1. What is SpringBootApplication ?
--------------------------------------
 Ans --> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications 
that you can "just run". It is used for Rapid Application Development.
Spring Boot is an open source Java-based framework used to create a micro Service.
You can get started with minimum configurations without the need for an entire Spring configuration setup.

Advantages
-----------
Spring Boot offers the following advantages to its developers −

Easy to understand and develop spring applications
Increases productivity
Reduces the development time
==================================================================================================
 @SpringBootApplication ?
 -------------------------
 Its same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan 
 annotations.
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

(iii.) @ComponentScan
----------------------
we can pass package and all classes in that package or subpackages, get scans for spring beans.
for example ->> @ComponentScan(basePackages={"other_package"}). It also scan the sub packages of it.
This annotation enables component-scanning so that the web controller classes and other components 
you create will be automatically discovered and registered as beans in Springs Application Context.
======================================================================================================

Q2. What is wait and sleep in multithreading ?
-----------------------------------------------
Ans --> wait() is used for inter-thread communication while sleep() is used to introduce 
pause on execution, generally.Thread. sleep() sends the current thread into the “Not Runnable” state for 
some amount of time.
wait() causes current thread to wait until another thread invokes the notify() method or the notifyAll() method
 for this object. 

LifeCycle of Thread
--------------------
Five Stages
-----------
1. Create the thread. (using t.start)
2. Runnable  (JVM will allocate the processor by using thread scheduler.)
3. running
4. Dead state
5. Non-Runnable State (sleep(),wait(),suspend())


Daemon threads
---------------
1.Daemon threads are which runs in background of anathor thread.
2.It provides service to the threads.
For ex - Garbage Collector, Finalizer, Attach Listeners, Signal Dispathcers etc.
Real life example like we write the text in MSWord but the spell check also works. This check is done by
daemon threads. 
Methods for the daemon threads
-------------------------------
1. public final void setDaemon(boolean b)  // means true or false
2. public final boolean isDaemon() // it will return true or false if thread is daemon or not

class Test extends Thread
{
    public void run(){
        System.out.println("Run this Thread");
    }

    public static void main(String []args){
         System.out.println("Main Method");
         Test t = new Test();
         t.setDaemon(true);
         t.start();
    }
}

Case 1
--------
Whenever we create the daemon thread it is compulsory to create the thread before start() method.
Else we get the exception IllegalThreadStateException(RuntimeException/Unchecked Exception).

Case 2
--------
We cannot create main thread as daemon thread. 

sleep()
--------
In Thread class , there are two sleep methods i.e spleep method is overloaded.
1. public static native void sleep(long milli) throws InterruptedException //native methods means thats the implementation done in other language.
2. public static void sleep(long milli,int nano) throws InterruptedException

Sleep method will inhibit the execution of thread as the time is provided.
As the sleep time gets completed then the execution of thread continious again.

//Here i want to provide the gap during the execution
------------------------------------------------------
public class Test{
        p s v main(String []args){  //main thread
            for(int i=1;i<=5;i++){
                try{
                    Thread.sleep(1000);  //sleep for 1sec
                    sop(i);
                }catch(Exception e){
                    sop(e);
                }
                
            }
        }
}


sleep() in multithreading
-------------------------
class Test extends Thread{
    public void run(){
        try
        {
            for(int i=1;i<=5;i++){
                sop(i+": "+Thread.currentThread().getName()); //print like Thread-1,Thread-1,Thread-0
                Thread.sleep(1000);
            }
        }catch(Exeption e){
            sop(e);
        }
    }

    public static void main(){
        Test t1 = new Test();
        t1.start();

        Test t2 = new Test();
        t2.start();
    }
}


yield()
-------
It stops the current executing thread and give a chance to other threads for execution.
-> Working 
-----------
In java 5, it uses sleep() method internally
In java 6, thread provides the hint to the thread scheduler, then it depends on the thread-scheduler to 
accept or ignore the hint.
Thus we cannot get the constant ouptput each time.

public static native yield(); 

public class Test extends Thread {
 public void run(){
        for(int t=0;i<=5;i++){
            sop(Thread.currentThread().getName()+"-"+i);
        }

        p s v m(){
            Test t= new Test();
            t.start();

            for(int i=1;i<=5;i++){
                Thread.yield();
                sop("main thread"+i);
            }
        }
}


Que -> What is immutable class in JAVA ? //Immutable class in java means that once an object is created, we cannot change its content.
Ans:-> In Java, when we create an object of an immutable class, we cannot change its value.
For example, String is an immutable class. Hence, we cannot change the content of a string once created.
Besides, we can also create our own custom immutable classes. 
1. declare the class as final so it cannot be extended or child classes can’t be created.
2.all class members should be private so they cannot be accessed outside of class
3.shouldn't contain any setter methods to change the value of class members
4.the getter method should return the copy of class members
5.class members are only initialized using constructor

In Java, all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable

---------------------------------------
// class is declared final
final class Immutable {

  // private class members
  private String name;
  private int date;

  Immutable(String name, int date) {

    // class members are initialized using constructor
    this.name = name;
    this.date = date;
  }

  // getter method returns the copy of class members
  public String getName() {
    return name;
  }

  public int getDate() {
    return date;
  }

}

class Main {
  public static void main(String[] args) {

    // create object of Immutable
    Immutable obj = new Immutable("Programiz", 2011);

    System.out.println("Name: " + obj.getName());
    System.out.println("Date: " + obj.getDate());
  }
}
-----------------------------------------

I have 5 years of experience working as Java Developer.
I have worked on various project in springboot,springMVC and some part spring security as well and
have experience on Restful Services,JPA and worked on SQL database like
Postgres and the MySql.

Que-> Difference between @Component vs @Service and @Repository ?
=================================================================
Ans-> These annotations are used to define an object. Basically we give authority to spring to cerate 
object for us. So for that we need to add those annotations on respective 
classes like @Controller for the Controller or @RestController for the Restful Services, @Service for the business logic, @Repository
is for the DAO layer where it will interact with the database.

Que-> What will happen if you see a @Service over a DAO ?
===========================================================
Ans-> If we use @Component for DAO layer it will work fine, but for the visibility it is required else it will look like a normal or generic class.
And one more benifit of @Repository is used to handle Persistent related exceptions that spring provide but with @Component we won't will get the advantage.

Any exception thrown by the persistence layer , doesn't matter what JDBC used.Like Hybernate or any ORM.So any kind of exception it will throw, spring will 
wrap that of own exception that is called DataAccessException.

---------------------------------------********************-----------------------------
Que-> Spring Bean Scopes ?
Ans-> From the spring specs, there are five types of bean scopes supported :
1. singleton(default*)
Scopes a single bean definition to a single object instance per Spring IoC container.

2. prototype
Scopes a single bean definition to any number of object instances.

3. request
Scopes a single bean definition to the lifecycle of a single HTTP request; that 
is each and every HTTP request will have its own instance of a bean created off 
the back of a single bean definition. Only valid in the context of a web-aware 
Spring ApplicationContext.

4. session

Scopes a single bean definition to the lifecycle of a HTTP Session. Only valid 
in the context of a web-aware Spring ApplicationContext.

5. global session
Scopes a single bean definition to the lifecycle of a global HTTP Session. 
Typically only valid when used in a portlet context. Only valid in the context of
a web-aware Spring ApplicationContext.

@Configuration
public class AppConfiguration {
    @Bean
    @Scope("singleton")
    public Manager getManager(){
        return new Manager();
    }
}

@Bean
@Scope(value="prototype")
public MyBean myBean() {
    return new MyBean();
}

@Bean
@Scope(value="request")
public MyBean myBean() {
    return new MyBean();
}
---------------------------------------********************-----------------------------

Que->Explain Bean Life Cycle ?
===============================
Ans->For BeanLifeCycle we have two annotations ,1.@PostConstruct and 2.@PreDestroy
So Whenever your container is created, your beans will be instantiated and then the particular method which
 have @PostConstruct that will be called first and then 
furthur activities will take place.
And At the end the methods which are written using @PreDestroy, those method will be called just before the 
container about to destroy and the bean get out of the container.
For Example, create a Database connection with @PostConstruct and this will be one time activity and to close 
the Database connection or clean the resource with @PreDestroy.

How to Customize the Bean Life Cycle ?
--------------------------------------
Spring framework provides the following four ways for controlling life cycle events of a bean:
InitializingBean and DisposableBean callback interfaces
*Aware interfaces for specific behavior
Custom init() and destroy() methods in bean configuration file
@PostConstruct and @PreDestroy annotations.

Que-> How to close or stop the springboot application manually by code ?
Ans-> By using context.close() or context.stop(), but the context is pointing 
to the application context.

Que->  What the Rest client you have used in your project ?
Ans-> Rest Template. It is a client to consume the data and uses Rest services.


Que-> getForEntity() and getForObject() difference ?
Ans-> These are the method found in RestTemplate.
getForObject() will perform a GET and return an object.
getForEntity() : executes a GET request and returns an object of ResponseEntity class that contains both the status code and the resource as an object.

Que-> Advantages if using ResponseEntity ?
Ans-> By using this we will send the HTTP status and along with this we can send the body.

Que->Delete API status code ?
Ans->200 (OK) or 204 (No Content).

Que-> Do you think we have to handle the timeout whenever we are going for Rest Template ?
Ans->When are connecting to our server those connections are made with the thread.
  If one thread is waiting for the connection , anathor thread also want to access the it will also be in wait state.
  Thus, we need to use the timeout and it is necessary.

Que-> Read Timeout and the Server Timeout ?
Ans->Implement timeout to release the blocked threads.
If we are not able to establish a connection to the server.
Read timeout happens when able to establish the connection but we are trying to read some data and we are not getting the response back.

Que->What is Versioning in Restful webservices ?
Ans-> So versioning means that we are adding new functionality to a API and we want that particular functionality
 used by the user.
Versioning example like request param using Request Parameters and we can have in Headers. 
Producers in @GetMapping and @PostMapping.
Versioning is the most important and difficult part of the API as it takes backward API compatible. 
Versioning helps us to iterate faster when
 the changes are identified. We should always version our Web API.
 When we made a breaking change in Web API, we should up versioned the API. 
 The most commonly used approaches fall into three categories:

URI Versioning
Versioning using Custom Request Header
Versioning using Accept Header

Que-> How authentication in RestWebServices work and how your RestWebservice get secure ?
Ans->For that we have security configuration class for an API which will be extending to configureAdapter.
So basically when we are hitting a request it will go to the authentication filter and 
further it will give us an authentication object but that is not a validated object. That object will passed to 
the Authentication Manager Builder then the builder will find the appropriate authentication provider. 
The provider will validate validate that object.So there are multiple authentication provider.
Like DAO Authentication Provider.

Que->When we make a Rest call from Postman or using Rest template and we are passing something into the header.?
Ans->We basically pass the token, like  JWT token in our header and that will be used for the authentication 
purpose.


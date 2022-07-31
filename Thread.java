Multitasking
------------
-> Performing multiple task at a single time.
Like VLC,Word,browser all are using CPU.
Mutitasking can be achived by 
1. Process Based Mutitasking/Multi-Processing    
2.Thread Based Mutitasking/Multithreading

Multi-Processing 
---------------
When one system is connected to multiple processors in order to complete the task.
One OS-> CPU_1 + CPU_2 etc. 
It is best suited at system level or OS level.

Multithreading
--------------
Executing multiple threads(sub-process,small task) at single time.
Tasks are achived through methods. Methods are a set of code which perform a set of task. 

Difference between Process and Thread
=======================================
1.A program in executing state is process whereas Thread is a subpart of process.
2.Process is heavy weight and thread is lightweight.
3.Context Switching takes more time in process and thread takes less time.
4.Communication takes more time but in thread Communication takes less time.
5.Each process has different address space whereas thread share same address space.
6.Process are not dependent on each other but threads are dependent on each other.
7.Process doesnt require synchronization whereas Threads may require synchronization.
8.Process uses larger resources whereas thread takes less resource.
9.Process take large time for creation and Thread take less time for creation.
{{{{{ //It is a process that involves switching of the CPU from one process or task to anathor.
//In this phenomenon,the execution of process that is present in the running state is suspended by the kernel and 
//anathor process that is present in the ready state is executed by the CPU.
//														It is one of the essential features of the mutitasking 
//operating system. The process are switched so fastly that gives an the illusion to the user that all processes 
//are being executed at the same time.}}}}} 

Ways to create a Thread:-
-----------------------
There are three ways to create the thread.
1. By using Thread Class (It is present inside java.lang package)
2.By Runnable Method
3. By Executors Framework.

Thread Lifecycle:-
-----------------
Threads can go through five different status in its life cycle as shown below.

1.New: When the thread instance is created, it will be in “New” state.
2.Runnable: When the thread is started, it is called “Runnable” state.
3.Running: When the thread is running, it is called “Running” state.
4.Waiting: When the thread is put on hold or it is waiting for the other thread to complete, then 
that state will be known as “waiting” state.
5.Terminated: When the thread is dead, it will be known as “terminated” state.

Methods in Thread
------------------
start() – Starts the thread.
getState() – It returns the state of the thread.
getName() – It returns the name of the thread.
getPriority() – It returns the priority of the thread.
setPriority(int priority) - used to set the priority range 1 minimum to 10 maximum
pulic staic int NORM_PRIORITY
pblic sttic int MAX_PRIORITY
ublic satic int MIN_PRIORITY
by default we get thr priority of parent thread ehich is 5 by default for main thread
sleep() – Stop the thread for the specified time.
yield()- It stops the current executing thread and give a chance to other threads for execution. It give the hint to thread scheduler.
Join() – Stop the current thread until the called thread gets terminated.
isAlive() – Check if the thread is alive.
Deamon thread
setDeamon(true);
isDeamon();


we can not change deamon status after starting the thread we will get exception IllegalThreadStateException.
yield() method
Suppose there are three threads t1, t2, and t3. Thread t1 gets the processor and starts its execution and thread 
t2 and t3 are in Ready/Runnable state. The completion time for thread t1 is 5 hours and the completion time for 
t2 is 5 minutes. Since t1 will complete its execution after 5 hours, t2 has to wait for 5 hours to just finish 
5 minutes job. In such scenarios where one thread is taking too much time to complete its execution, we need a 
way to prevent the execution of a thread in between if something important is pending. yield() helps us in doing so. 
The yield() basically means that the thread is not doing anything particularly important and if any other threads
 or processes need to be run, they should run. Otherwise, the current thread will continue to run.

sleep() method
This method causes the currently executing thread to sleep for the specified number of milliseconds, subject to the
 precision and accuracy of system timers and schedulers. 

//  sleep for the specified number of milliseconds
public static void sleep(long millis) throws InterruptedException

//sleep for the specified number of milliseconds plus nano seconds
public static void sleep(long millis, int nanos) 
                         throws InterruptedException

join() Method
If a thread wants to wait for anathor thread to complete its task, then we should use join method.

The join() method of a Thread instance is used to join the start of a thread’s execution to the end of another 
thread’s execution such that a thread does not start running until another thread ends. If join() is called on a
 Thread instance, the currently running thread will block until the Thread instance has finished executing. 
 The join() method waits at most this many milliseconds for this thread to die. A timeout of 0 means to wait 
 forever 

Syntax:// waits for this thread to die.
 public final void join() throws InterruptedException

// waits at most this much milliseconds for this thread to die
public final void join(long millis) 
              throws InterruptedException

// waits at most milliseconds plus nanoseconds for this thread to die.
The java.lang.Thread.join(long millis, int nanos)

A process is a program which is running
We can have subprocesses for it

Three ways to create Thread
1. Thread //class thread resides in package java.lang;
2.Runnable
3.ExecutorService 


class Thread implements Runnable{
	//constructor

	//methods
	1.run()
	2.start()
	3.sleep()
	4.join()
	5.getName() and setName()
	6.interrupted,priority
	7.daemonJV
}

================================================================00000000000
class Test extends Thread 										|==----|
{																| ===------|
    public void run(){ 											|====-----------|
        System.out.println("Run this Thread");					|   =====----------|
    }															|	  ======----------|
    															|	+     ======-----------|
    public static void main(String []args){						|	*		======------------|
         System.out.println("Main Method");						|				======-----------|
         Test t = new Test();									|		*			======---------|
         t.start(); //thread gets created						|						======-------1
    }															|					*		======----------
}																|								======----
																|			*			*		  ============13
																|								======----1	
So, 4 steps to create a thread.									|							======1-----
-----------------------------------								|						======----
1.Extends the Thread class.										|----		*			 ======----
2.Override the run method. Inside the run method we write the task.||			  ======--------------
3.Create an object of the class.								|----			   ====	----------------
4.Start the thread by using start() method.						|		    ===--------------
																|	     ===----------
===================================================================================================
Create new Thread -> Runnable -> JVM will allocate the processor -> Running -> When task is completed -> dead.

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
As the sleep time gets completed then the execution of thread continues again.

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



Thread interrupt() in java
========================
1.Use:-
------
It is used to interrupt an executing thread.
2.interrupt():-
-------------
This method will only works when the thread is in sleeping or waiting state.
3.If thread is not in sleeping or waiting state then calling an interrupt() method will perform normal behaviour.
4.When we use an interrupt() method it throws an exception called InterruptedException.
5.Syntax - public void interrupt(){--}


class Test extends Thread{
	public void run(){
		try{
			for(int i=1;i<=5;i++){
				spo(i);
				Thread.sleep(1000); 
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String []args){
		Test t = new Test();
		t.start();
		t.interupt();
	}
}  //Now it will work because the thread is in sleeping mode.


Thread interrupted() and isInterrupted() in java
=================================================
1.interrupted() and isInterrupted() method is used to check whether a thread is interrupted or not.
2.interrupted() method clears the interrupted status from true to false if the thread is interrupted.
3.isInterrupted() method doesnt clears the interrupted status.
4.interrupted() method will change the result but isInterrupted() method will produce same result if called more than once.
5.Syntax
-------
public static boolean interrupted(){---}
public boolean isInterrupted(){---}
----------------------------------------------------------------------------------------------------------------
package demo;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Demo {
	static void show1() throws InterruptedException
	{
		for (int i = 0; i <100; i++) {
			System.out.println("show1111111111111111   "+i);
//			Thread.sleep(10);
		}
	}
	static void show2() throws InterruptedException
	{
		for (int i = 0; i <100; i++) {
			System.out.println("show22222222222222222   "+i);
//			Thread.sleep(10);
		}
	}
	static void show3() throws InterruptedException
	{
		for (int i = 0; i <100; i++) {
			System.out.println("33333333333333333333333333333333333333333333333333333   "+i);
//			Thread.sleep(10);
		}
	}
	static void show4() throws InterruptedException
	{
//		for (int i = 0; i <1000000; i++) {
//			System.out.println("44444444444444444444444444444444444444444444444444444444444444444444444444   "+i);
//		Thread.sleep(10);
//		}
		IntStream.range(0, 100).forEach(n -> {
			System.out.println("4444444444444    "+n);
		});
	}
	//23092
	//16232
	static void threading() {
		ExecutorService executorService = Executors.newFixedThreadPool(50);
		executorService.submit(
				()->{
					try {
						show1();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				);
		executorService.submit(
				()->{
					try {
						show2();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				);
		executorService.submit(
				()->{
					try {
						show3();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				);
		executorService.submit(
				()->{
					try {
						show4();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				);
	
		executorService.shutdown();
		
		try {
			while(!executorService.awaitTermination(1, TimeUnit.MILLISECONDS)) {
				System.out.println("still processing ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException{
		System.out.println("Hello world");
		long start = System.currentTimeMillis();
		
		threading();
		
		long end = System.currentTimeMillis();
		
		
		
		System.out.println("time taken");
		System.out.println(end-start);
		
//		for (int i = 0; i <100000; i++) {
//			
//			System.out.println("main method-------------   "+i);
//		}
	}
}

Thread Priorities In Java
=========================
1.JVM provides the priorities to each thread and according to these priorities, JVM allocates the processor.
2.Priorities are represented in the form of integer values.which ranges from 1-10.
3. 1-> MIN_PRIORITY, 5-> NORM_PRIORITY, 10->MAX_PRIORITY
4. 0,less than 1, greater than 10 are not valid priorities.
5. Methods are (1). public final void setPriority(int value) and second method is
					public final int getPriority()
**Bydefault for main method the priority is 5.
6. Priorities are inherited from parent thread.
7. If priority value is not in between 1-10 then it will throw the Runtime exception i.e. IllegalArgumentException.
8. Priorities depends on the platform. Windows doesnt support priorities of Thread. 


one more way to implement thread 
here size of thread pool determines that a particular object can execute 
how many execute methods at a time 
if given 1 then only one execute will run and we will get only 1111111 as output 
no mixed output
if given 4 then all the outputs will be mixed i.e. 1 2 3 4

Que-> What is Synchronization ?
Ans-> It is the process by which we control the accessibility of multiple threads to a particular shared resource.





ExecutorService is a JDK API that simplifies running tasks in asynchronous mode
Generally speaking, ExecutorService automatically provides a pool of threads and 
an API for assigning tasks to it.
ExecutorService is an interface, an instance of any its implementations can be used. 
There are several implementations to choose from in the java.util.concurrent package
ExecutorService can execute Runnable and Callable tasks 
The execute() method is void and doesnt give any possibility to get the result of a 
tasks execution or to check the tasks status (is it running):
executorService.execute(runnableTask);
submit() submits a Callable or a Runnable task to an ExecutorService and returns 
a result of type Future:
Future<String> future = 
  executorService.submit(callableTask);
invokeAny() assigns a collection of tasks to an ExecutorService, causing each to run, 
and returns the result of a successful execution of one task (if there was a successful execution):
String result = executorService.invokeAny(callableTasks);
invokeAll() assigns a collection of tasks to an ExecutorService, causing each to run, 
and returns the result of all task executions in the form of a list of objects of type Future:
List<Future<String>> futures = executorService.invokeAll(callableTasks)
The shutdownNow() method tries to destroy the ExecutorService immediately, but it doesn't 
guarantee that all the running threads will be stopped at the same time:
This method returns a list of tasks that are waiting to be processed. It is up to the developer 
to decide what to do with these tasks.
One good way to shut down the ExecutorService (which is also recommended by Oracle) is to use 
both of these methods combined with the awaitTermination() method:
/*

create runnable tasks by implementing runnable
pass them to service.execute(new Task());


FixedThreadPool
insted of creating a lot of threads for every task 
we create a thred pool having fixed threads 
we assign them tasks which are stored in blocking queue
these threads picks the tasks and executes them 
take task and execute them
blocking queue is thread safe
ideal size for thread pool
cpu core decides how many thread can execute at same time
so having a lot of thread is not the solution 
ideal
threads equals of the number of cores in cpu 
Runtime.getRuntime().availbleProcessors();
this is somthing which is not practical 
beacause if our tasks are io dependent 
then all can wait and processor will become empty.
cpu intesive - same as cores
io intensive - larger number



variable thread pool
have synchronous queue
if we submit task then it checks for 
free thread if not available then it creates a thread 
and assigns the task to it 
threritically it can create upto 1000 threads
if thread is idea for 60 seconds thread is killed
Executors.newChachedThreadPool();


delayed thread pool
schedulethread pool
uses delay queue 
newScheduledThreadPool();


single thread pool
signle thread executor 
single thread is there 
blocking queue is used 
executes in sequence
if thread is killed due to some reason they get automaticallly recreated


CustomeRejectionHandler handles the rejected task



service.shutdown()
initilizes the shutdown and will not accept any new task
but will complete the alredy given tasks. 


service.shutdownNow()
initiates shutdown and returns the queued tasks.
if intruption is ignored then will act like normal shutdown
This will attempt to stop all executing tasks 
right away, and skips all submitted but non-processed tasks

service.awaitTermination()
The awaitTermination method of ExecutorService in 
Java is used to wait for all the tasks submitted 
to the service to complete execution:
After the shutdown of the service was initiated
The wait time for the termination of the service 
is over
The current thread of execution is interrupted
The method takes a timeout parameter that indicates the maximum time to wait for all the tasks submitted to finish.




Callable interface

static class Task implements Callable<Integer>
{
	public Integer call() throws Exception
	{
	return new Randow().nextInt();
	}
}

executorService.execute() accepts the runnable tasks

executorService.submit() accepts both runnable and callable

Future is the return type if we pass callable method in .submit
method

if we return a value from callable and it is not available
and we are trying to use them then it can be a blocking
operation 
future is placeholder which will arive in some time in future

if we try to get the value before its ready 
main thread will go in block state and waits foe getting thr
value from callable 
after getting the value 
main will continue



CompletableFuture.supplyAsync(()->h).thenApply().....all operation operating same thread
CompletableFuture.supplyAsync(()->h).thenApplyAsync().....different threads for ecery method chained


ExecutorService cpuBound = Executor.newFixedThreadPool(4);
ExecutorService cpuBound = Executor.newChachedPool();
CompletableFuture.supplyAsync(()->getOrder(),ioBound)
					.thenApplyAsync(order -> enrich(order),cpuBound)
					.thenApply(o -> performPayment(o))
					.thenAccept(order -> sendEmail(order))
does not blocks anything 
if we do not use any executorservice then default will be used





*/
By extending Thread class:


public class PlayMusic extends Thread {
 
public void run() {
for(int i=0;i<1000;i++) {
System.out.println("Music Playing ...... ");
}
}
 
public static void main(String Args[])
{
 
PlayMusic p=new PlayMusic();
p.start();
 
for(int i=0;i<1000;i++) {
System.out.println("coding");
}
}
}


Implementing Runnable Interface:

public class DemoThread implements Runnable{
public void run() {
for(int i=0;i<1000;i++) {
System.out.println("hey thread1 started");
}
}
public static void main(String[] args) {
DemoThread d=new DemoThread();
Thread t1=new Thread(d);
t1.start();
 
DownloadThread down =new DownloadThread();
Thread t2=new Thread(down);
t2.start();
}
}









//Synchronization

/*
to resolve data inconsistancy problem we need 
to use synchronized keyword 
synchronized is not for variables
if a method or block is decleared as synchronized then
only one object allowed to access the block at a time
synchronized is a modifier applicable only for methoa and blocks
not for classes and variables
advantage
resolve data inconsistancy
disadvantage
waiting is increasing time consuming 
internally synchronized concept is based on object lock

every object have its unique internal lock
if a thread wants to execute synch mehtod
on the given object first it has to get the lock of that object
once thread got the lock then it is allowed to execute any sync mehtod
on that object once execution completes the lock is released 
all this is managed by jvm not by programmer 


two area in object synch area and non sync area

update-add update delete replace -state of object changing- operation in sync area

non sync -  when object state is not changing


synchronization 
process synchronization
thread synchronization 
          mutual exlusive
                        synchronized method
                        block
                        static synchronization
          cooperation
												wait notify notifyall



SYNCHRONIZED METHOD
class X
{
	sync m1()
	sync m2()
	m3()
}
t1 executing m1
t2 came and wanted to execute m1- will enter into waiting state 
t3 came wanted to execute m2 - will wait sinxhe t1 have the lock of x
lock conceot is on object not on method
t4 wants to execute m3 - no issues since it is not synchronized
if a thread is executing a synchronied method of a class
other threads are not allowed to execute any other synchronized 
method of that class at the same time corresponding to same object

if multiple thread operating on multiple thread then synchronization 
is not required here 


STATIC SYNCHRONIATION

class X
{
	static sync m1()
	static sync m2()
	static m3()
	sync m4()
	m5()
}

Object X
t1 wants to execute m1
t1 will get class level lock of x
t2 wants to execute m1 - t2 will enter into waiting 
t3 wants m2 -t3 will wait
t4 wants m3 - will get change
t5 wants m4 - objec level is available will get
t6 wants m5 will get
while a thread is ecexuting static synchronized method
remaining threadsa are not allowed to static sync method of that class
simultaneously
remaining threadsa  are allowed to execute
normal static methodsm
synchronized static method 
normal instance methods.

if multiple objects are there with different threads 
then this will again create the data inconsistancy to solve this
ststic synchronization is introduced
if we make static synchronized methods 
then thread requires class level lock and not object level lock
thats why even two object calling method of a class which is synhronized
we will get regular output
beacause the lock first thread will get corresponsing to the first 
object will be the class level lock 
not the object level
class level lock 
every class in java has a unique lock also known as
class level lock
if a thread wants to access any static synchronised method
then it requires the class level lock




SYNCHRONIZED BLOCK
method code can be larger 
but synchronization can be required for very little part
here we can use synchronized block 
synchronized(this)//we can pass the reference of object
{
	
} 
reduced the waiting time 
improves the performance
block have less scope whereas method have entire method scope 
works on concept of object level lock
if we want to get lock of some particular object to allow the access of the block of code then we can pass the object reference
if we want to allow the access the code of synchronized block only 
to the object having class level lock then we can pass tha class inside like
synchronised(Display.class)


  








INTER-THREAD COMMUNICATION

wait notify notifyall

wait
current thread leaved the lock gives it to some other thread 
now it waits for the other thread to complete its execution 
or we can specify the time for it to get back
public final void wait() throws IntrruptedException
public final void wait(long timeout) throws IntrruptedException

notify 
invokes the waiting(single) thread and leaves the lock of self

notifyAll
wake all thread in waiting state and release self lock

to call these method thread must have the lock fo the object
i.e. the thread should be in synchronized area

class TotalEarning extends Thread
{
	int total_earning = 0;
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			total_earning+=100;
		}
	}
	
}
class Demo 
{
	p s v m ()
	{
		TotalEarning te = new TotalEarning();
		te.start();
		System.out.println(te.total_earnings);
	}
}
te = 0;


we will tell main thread to wait 

class TotalEarning extends Thread
{
	int total_earning = 0;
	public void run()
	{
		synchronized(this)
		{
			for(int i=0;i<10;i++)
			{
				total_earning+=100;
			}
			this.notify();
		}
		}
	
}
class Demo 
{
	p s v m () thhrows IntrruptedException
	{
		TotalEarning te = new TotalEarning();
		te.start();
		//System.out.println(te.total_earnings);
		 synchronized(te)
		{
			te.wait();
		//System.out.println(te.total_earnings);
		}
		//System.out.println(te.total_earnings);
	}
}

non access modifiers


Volatile 
using volatile forces the thread to read and write 
variables directly from RAM memory
Thread have local Cache memory
time to time it flushes into main from local cache
When many thread are using same volatile variable
all of them see the last version that is 
present in ram memory and not possible old copy in cache.





SERIALIZATION
Serialization in Java is a mechanism that is used in 
converting the state of an object into a byte stream.
public class SerialDemo
{
		psvm()
			{
					Save obj = new Save();
					obj.i=4;

					File f = new File("obj.txt");
					FileOutputStream fos = new FileOutputStream(f);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(obj);

					FileInputStream fis = new FileInputStream(f);
					ObjectInputStream ois = new OIS(fis);
					Save obj1 = (Save) ois.readObject();		
			}
}
class Save implements Searilization
{
	int i;
}



To transfer object from one plae to another 
we serialize objects 
it coverts the object to some byte stream 
and deserialize at the receiver end

Used beacause
Communication bw jvms 
Persistence to store in databse
Deep Copy 
Building takes more time then serialization
Stores only the state and not the object


java.io.Serializable
java.io.Externalizable 



if super class is serializable all childresn will be serilizable
Serilization of static varibales is ignored during the process

Externalizable Interface
writeExternalMethod
readExternalMethod

Transient in Java is used to mark the member variable not 
to be serialized when it is persisted to streams of bytes. 
This keyword plays an important role to meet security 
constraints in Java. It ignores the original value of 
a variable and saves the default value of that variable 
data type.





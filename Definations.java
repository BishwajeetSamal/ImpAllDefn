/*
BugsMirror
RivaInfotech mr9 orbit mall
TechSolvo

*/


intro on call then que of any update



mid level and high level prgoramming difference
8.58sgpa







introduction:-
 Good Afternoon sir/mam.. 
 I am keshav Vyas, and i am form khategaon,
 currently am persuing Master of computer application from shree govindram sakseria 
 institute of technology and science indore with a current aggregate of 8.62
 i had done my bechlor of science from holker science college indore.

 i am an honest and enthusiatic person.
 i generally take problem as an opportuinity to improve my abilities
 my biggest strength is my confidence apart from that i am hardworking and 
 selfmotivated perosn with a positive attitude toward my carrear and my life.

 my hobies are watching movies and web series 

 my short term goal is to work in a reputated compny like yours where i can
 enhance my skills and knowledge and my long term goal us to see my compny in top most
 position where i am also one of the peroson responsible for it.
 
 my programming skills are c java html css and sql
 right now i am also working on javascript
 thats all form my side thank you 


i had scored 85.8 percentage in higher secondary education -12th
i had scored 7.6 cgpa  in secondary education -10th
bsc 54.7%






Strength:-
 I am a self-motivated, honest, hardworking person with a positive 
 attitude towards my career. I never stop until I finish the task 
 on deadline.i like to keep things organised I can adapt to new 
 things new environments easily and making new friends also goes 
 quite smooth with me.




Why should we hire you?
 As I have just started with my career in data science, 
 I don’t have many practical achievements to talk about.
 “Being a fresher, I think I am very flexible and adaptive to learning new things. 
 i am a hardworking and a desciplined person
 if I am chosen to contribute then  i will surely contribute something 
 capable for the growth of the company. 



Rate me ?
 m sorry sir but i don't think i am in a position to rate you at all

 if insisted..
 but if it is a part of my interview then i would say you are 9 on 10 sir..
 its nothing about you lacked but its like form the phycology that
 we always have a room for improvement.
why?



Confidence vs overconfidene?
 Confidence means a belief that I have the capability and capacity to do 
 this work like any other competent person, while overconfidence means 
 a belief that it's only me who has the competence and capabilities to
 do this work and no other.


Why us?
 Sir, everyone wants to work with the best organization where they 
 learn a lot of new things and make their skills strong and I will 
 believe this company is one of them.


OverQualified?
	I think I'm qualified for this job but not overqualified because I'm 
	just a fresher and have lots more to learn because learning never ends.


where after 5 year
	In 5 years from now, I see myself as an knowledgeable and 
	respected person in this company where I have an in-depth 
	knowledge of the industry and the domain.
	a person to whome new comers can seek for help




Ever thought of starting a buiseness?
 
 This is something every person think of at some point of life
 and yes this tought came in my mind also but i was never very 
 serious about it right now i am more focused to build my career first later 
 i may think about it.


Acedmic Failure?
iit madaras

 
	



Weakness:-
	i feel like i am somewhat an overthiker.
	thats why i end up taking some time in making decisions.
	sometimes i am short temperd too.		













Project 
Hostel hub

moving toward my project i have made two project 
first one is hoste managemtn syatem, 
this is a website for hostel
searching where users can search and book hostels online for 
there preffered location and facilities 
in this project there are mainly two modules one is for user and other is for 
owner of hostel
here owner can add remove and update hostel details 
owner moduls also provides facility to see the bookings for his hostel
and also to he can see the feedbacks and queries of user

and in user module user can search and book hostel according to theri needs
they can also write their queries and feedbacks..

i have used html css in front end and for backend i have used
JSP and for databse mysql server is used
i have also used a littel bit of javaScript for validation puspose only 

Sunil Chhetri


another project was maternity healthcare management system
this was a grorp project and my responsibility was to explain 
jdbc connectivity and working of jsp
remaining working was handled by my teammates
basically project gives the information about gynecologits with their consultation fees
ratings ,revies, qalifications and adress.facility to book apointments online
is also available...
this project also provides information needed for the maternal woman related
to health, exercise diet plan etc 


thats it









JAVA
---------------------------------------------------------------------------------------
Extra Que-- Wrapper Classes
===========================
1.A Wrapper class is a class whose object wraps or contains primitive data types. 
2. This class encapsulates a single value for the primitive data type.
For instance the wrapper class for "int" is Integer,for "float" is Float and so on.
boolean->Boolean
byte->Byte
char->Character
short->Short
int ->Integer
long->Long
float->Float
double->Double

Some methods of wrapper classes are here-
valueOf() --static method.
parseXxx() -- static method  //converts the string to respective format. 
 for example =====>  int a = Integer.parseInt("123");
xxxValue() --Instance method of wrapper class. // this is used for to get the value from wrapper Class to value

for example --
Integer i1 = Integer.valueOf("123"); //need to pass as string
Double d1 = Double.valueOf("1.23");
---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------
JAVA ACCESS MODIFIERS
=====================
Java supports four categories of accessibility
1.private 
2. protected
3.public 
4.default

Note -- Outer class can be only of public or default.
Inner class can be of any access modifiers. 

---------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------
INITIALIZATION BLOCK
====================
There are two types of initialization blocks.
1. Instance Initialization Block
2.Static Initialization Block

1. Instance Initialization Block
--------------------------------
private class Test{
	private int x;


	//This is initalization block. 
|------------------------------------------------------|	
|	{												   |
|	System.out.println("Initialixation block:x="+x);   |
|	x=5;											   |
|	}  												   |
|------------------------------------------------------|

	public static void main(String []args){
		Test t1=new Test();
	}
}
1. Initalization block can be multiple in the class.
2. It will be executed when an instance of class is created.
3. Multiple block are converted in as one block by compiler and written in the very initial line inside 
constructor.
4. Return keyword cannot be used in Initialization block.

2. Static Initialization Block
-------------------------------
public class Test{
	private static int k;
	//This is static initialization block
|------------------------------------------------------|	
|	static {										   |
|	System.out.println("Initialixation block:x="+x);   |
|	x=50;											   |
|	}  												   |
|------------------------------------------------------|
	public static void main(String []args){
		Test t1=new Test();
	}
}
1. A static initializer declared in a class is executed prior to when the class is initialized.
2. Static initializers may be used to initialize the class variables of the class.
3. return keyword cannot be used in static initialization block.
4.this or super can not be used in static block.
---------------------------------------------------------------------------------------
CONSTRUCTOR
===========
1.We use constructors to initialize the object with the default or initial state.
2.The name of the constructor is same as the class name.
3. It has no return type.
4.  It is not mandatory for the programmer to write a constructor for the class.Compiler implicitly provide
a default constructor for the class.
5. Constructor can be overloaded and can be parametrized.

There are two types of constructors in Java:
1.Parametrized Constructor
2.Default Constructor
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
FINAL keyword
============
1. final instance variable
2. final static variable
3. final local variable
4. final class
5. final methods

1. final instance variable
----------------------------
A java variable can be declared using the keyword final.Then the final variable can be assigned only once.

A variable that is declared as final and not initailzed is called a blank final variable. 
A blank final varibale forces either the constructors to initailze it or initialization block to do this job.

Note==>>> We can  initailze only for once.
*******************************************
public class Example{
	private int x; // instance member variable. It will contain 0 instead of garbage value.
	private final int y; //final instance variable. It will be blank varible until you initialize it.
	private static int z; //static member variable. It will contain 0 instead of garbage value.
	private static int z1; //static final variable.It will be blank varible until you initialize it.
}
I can initalize the final variable by initialization block. {x=5}.
Also we can initalize through constructor.

2. final static variable
-------------------------
1. Static member variable when qualified with final keyword, it becomes blank until initailzed.
2. Final static variable can be initailzed during declaration or written the static block.
Only two ways to initalize the static final variable . First at the time of initialization and  static block.

I can initalize the final variable by initialization block. static {z1=5}.

3. final local variable
-----------------------
public void fun(){
	int k; 
	int l; //final local variable
	k=k+1;
}
Local variables that are final must be initailzed 
---------------------------------------------------------------------------------------

QUE 1 : what is a class
a class is a logical entity
it does not have any physical existance
is is a logical template to create objects that share common properties and methods
Hence, all objects in a given class will have the same methods or properties
For example, we can consider a car as a class that has characteristics like steering 
wheels, seats,
brakes, etc. 
And its behavior is mobility. But we can say Honda City having a reg.number 4654 is 
an ‘object’  
that belongs to the class ‘car’.
decleared by kryword class

QUE 2: what is an Object

It is a basic unit of Object-Oriented Programming and represents the real life entities
like anything that has a physical existance
An object consists of : 
State: represents the data (value) of an object.
Behavior: represents the behavior (functionality) of an object such as deposit, withdraw, etc.
Identity: An object identity is typically implemented via a unique ID. 
The value of the ID is not visible to the external user. 
However, it is used internally by the JVM to identify each object uniquely.
if dog is considerd as object then 
identity is name
color breed age is state
behaviour is bark sleep eat etc



QUE 3: what do you mean by polymorphism ?
The process of representing one Entity in multiple forms is known as polymorphism. 
2 types: 
1. Compile time polymorphism:  Whenever an object is bound with their functionality at 
the compile-time, this is known as the compile-time polymorphism. At compile-time, java 
knows which method to call by checking the method signatures . So this is called compile-time 
polymorphism or statiic or early binding. Compile-time polymorphism is achieved through method 
overloading. Method Overloading says you can have more than one function with the same name 
in one class having a different prototype(means arguments).
2. Runtime polymorphism:  Whenever an object is bound with the functionality at run time, 
this is known as runtime polymorphism. The runtime polymorphism can be achieved by method 
overriding. Java virtual machine determines the proper method to call at the runtime, not 
at the compile time. It is also called dynamic or late binding. Method overriding says 
child class has the same method as declared in the parent class. It means if child class 
provides the specific implementation of the method that has been provided by one of its parent 
class then it is known as method overriding

Advantages of runtime polymorphism over compiletime polymorphsim are: 
Less memory space
Less execution time
More performance
Real life example of polymorphism in Java
Man is only one, but he takes multiple roles like - 
he is a dad to his child, he is an employee, a salesperson and many more. 
This is known as Polymorphism.
Real life example of runtime polymorphism: 
we create two class Person an Employee, 
Employee class extends Person class feature and override walk() method. 
We are calling the walk() method by the reference variable of Parent class. 
Since it refers to the subclass object and subclass method overrides the Parent class method, 
subclass method is invoked at runtime. Here method invocation is 
determined by the JVM not compiler, So it is known as runtime polymorphism.

QUE 4: what do you mean by INHERITENCE?
Inheritance: 

The process through which one class acquires all the properties and characteristics 
(like fields and methods) of another classes is called inheritance.
here the class from which we inherit the properties is called as a
super class or parent class and the class in which properties are getting inherited is calles 
chile class or sub class
To apply inheritance, extends keyword is used.
for example if there is a class a and a class b
if we want to inherit properties of class a in class b then we will write
class b extends a


Purpose : to achieve fast performance, and to provide reusability of code, 
so that one class has to write only specific features.

TYPES: 
1. Single inheritance: 
	  subclasses inherit the features of one superclass.

2. Multilevel inheritance: 
	 this means that the super class is also a child class for some other super class
	 for example there is a class a b c 

3. Heirarchical inheritance: 
	 one class can have more than one child classes this is an example of hei..

4. Multiple inheritance: 
	 if one class inhertis properties from more than one parent class than this is called
	 multilevel..
	 but java does not supports multiple inheretence in case of ClassCastException 
	 beacause it may create ambiguity
	 for example there is a class c which extends both class a and b
	 now both class ab and b contains show method
	 if we call show mthod form the object of c class then this will
	 create ambiguity 
	 supports multiple inhertence in case of interface 
	 beacause there if two methods with same name exista then they are considered as same 


	 real life example :-
	 smartphone inherits basic properties of phone
	 we ourself inherits properties form out parents

QUE 5: what do you mean by abstraction?
Abstraction is a process of hiding the implementation details and showing only 
functionality to the user.
Another way, it shows only essential things to the user and hides the internal details, 
for example, 
sending SMS where you type the text and send the message. You don't know the internal 
processing about the message delivery.
abstract class and interface








QUE 6: what do you mean by abstract class?
		abstract class is like a class where we can have variable and method
		mthods can be both abstract as well as non abstract methods
		aabstract method is a method that is declared without an implementation
		aabstract keyword is used to declear a absract class and abstract methods
		if a class contains even a single abstract method then the class must be decleared 
		as aabstract
		since we can not create instacnce of a abstract class therefor to access the data
		of abstract class inhertiting it is must
		not if a class inhertis form a abstract class then it must provide implementation
		for all the abstract method of abstract class or it shouuld be decleared as abstract.
		static methods are also allowed in abstract class.
		and we can directly access them by using the class name.

QUE 7: what do you mean by Interface?
		interface is also just like a class having methods and variables
		but all the methods of interface are by default publicc and abstractt
		and all the variables of an interface are by default static public final
		interface is decleared by using interface keyword
		and implement keyword is used to implement a interface
		we can not create instance of interface therefor to access the data and methods of
		interface we must implement it 
		now if we impkement a interaface in a classes
		then it is compulsory to provdide the implementation of all the methods of the
		interface in the class or that class should be decleared as abstract
		functional interface- one abstract method
		marker interface- zero abstract method
		it is used to provide multiple inhertence and pure abstraction 
		for example there is interface a ............




QUE 8: what do you mean by Data Encapsulation?
		Encapsulation is one of the four fundamental OOPs concepts. 
		The other three are inheritance, polymorphism, and abstraction.
		Encapsulation in Java is a mechanism of wrapping the data (variables) 
		and code acting on the data (methods) together as a single unit. 
		In encapsulation, the variables of a class will be hidden from other classes, 
		and can be accessed only through the methods of their current class. 
		Therefore, it is also known as data hiding.
		To achieve encapsulation in Java −
		Declare the variables of a class as private.
		Provide public setter and getter methods to modify and view the variables values.



Que 9: What do you mean by method overloading and method overriding?
		Overloading:-
			if a class has multiple methods having same name but different in parameters, 
			it is known as Method Overloading.
			There are two ways to overload the method in java
			By changing number of parameter
			By changing the data type
			or by changing the order of parameters
			we cant not perform method overloading by changint the reurn type of method
			if we want to perform same operation, but number of argument or data types
			of arguments differ every time then having same name of method inproves 
			the redability of code
			suppose we want to perform addition of numberes but arguments differ in
			number every time then we can create multiple methods with same name
			and different parameters so that programer can call the same method with 
			different parameters every time..
			main method can also be overloaded
			but compiler searches for the string vali main
			then the overloaded can be calles from dtring vali main

			method signature- name and parameters list(no and types)

			two method with same signature but different return type
			will get error
			pdpp dosent affects overloading 
			overloaded can be synchronised


		Overriding:-
			If a subclass provides the specific implementation of the method that has 
			been declared by one of its parent class, it is known as method overriding.
			The method must have the same name as in the parent class
			The method must have the same parameter as in the parent class.
			There must be an IS-A relationship (inheritance).
			if we dont like the defenation of a mthod in parent classes
			then overriding provides us the facility to change that defination.
			we can not override static final private  

			return type also should be same in case of primitive data types
			Covarient method overriding
			in case if objects are getting returned
			method of sub class can return the same as well as child of 
			return type of suber class method
			super returning Object 
			sub can return object as well as string or any other object 

			if method of super class throws an exception then 
			then sub class can
			throw same exception 
			can throw child exception 
			does not throw exception
			but can not throw super exception
			checked exception rules
			
			a sub class can override any method decleared in same package
			which is not private



			both static hiding 
			both instance overriding
			one static one instance is error
			dynamic method dispatch is synoname for overriding

			constructors does not gets inherited

			we cannot override main method as it is static
			shadowing of static function is method hiding
			variable hiding local instance super valriabe example
			
		



Que 10: what are the features of java?
		Object-oriented
		Simple
			Java is easy to learn and its syntax is quite simple, clean and easy to understand
		Secure
			as it does not provieds explicit pointers user does not access to the address 
			directly
		Platformindependent
			Unlike other programming languages such as C, C++ etc which are compiled into 
			platform specific machines. Java is guaranteed to be write-once, run-anywhere language.
			On compilation Java program is compiled into bytecode. 
			This bytecode is platform independent and can be run on any machine
		Multi-Threaded
			Java multithreading feature makes it possible to write program that can do many 
			tasks simultaneously
		MemoryManagement
			java also provied the concept of gc so the memory managemant is bttere
			and user need not wory about unrechable objects
		Robust
			the main areas which Java improved were Memory Management and mishandled Exceptions 
			by introducing automatic Garbage Collector and Exception Handling.

Que 11: What is cloning?
		If we want to copy the data of an existing object but with seperate memory
		then cloning is used...
		clone method is used to clone an object which is a method of object class
		clone method is protected and return type of clone method is object
		there are two types of cloning shallow cloning and deep cloning deep cloning is 
		alse known as user defined cloning 
		not in shallow cloning only primitive data types are copied
		but reference variables are not copied 
		but in deep cloning both are copied
		object class supports shallow cloning by default		



Que 12: What do you mean by constructor?
		Constructor is a special type of member function used to intilize instance variable
		constructor name is same as that of a class name and it does not have return types
		constructore is automatically called when we create an intance of the classes
		is does not requires explicit calling
		there are two types of constructors 
		default
		parametrized

Que 13: What do you mean by instanceblock?
		instance block is an element of class declered by just open and closed 
		curly brackets 
		it is executed upon the creation of objet 
		in general we can say that the instance block is executed befor the costructor
		but practically instance block gets placed in every constuctor just below
		super keyword thats why when constructor is called then first instance block
		code is eecuted then construcotr code is executed
		Just like constructors, instance blocks can be used to initialize the 
		instance variables during object creation.
		Just like constructors, instance blocks can also be used to write the 
		logic of the program which has to be executed automatically for all 
		objects during their creation. (Main Purpose)
 



Que 14: What do you mean by staticblock?

		to initilizze the static variables
		called only once when the class is loaded
		decleared by static{}




Que 15: Why array index starts with zero?
		when we write x[i] then it is internally treated as
		*(x+i) where x holds the address of base element or
		the first element of array now if we will start the 
		index with one then when we will try to access the 
		first element then we will write x[1] but  this will
		be internally treated as *(x+1) that is one will be 
		added in the address of dirst elemnt and we will get
		second element of the array. thus if the index starts with 
		one then we wont be able toh acchess the first element 
		of array  thats why array index starts with zero

Que 16: What is mthod hiding?
		When a child class defines a static method with the same 
		signature as a static method in the parent class, 
		then the child's method hides the one in the parent class. 
		here in method hiding the binding is done on compiletime
		correspoding to the reference variable as static method can
		be directly acceese by class name and objet is not required


Que 17: What is pointer?
		The pointer in C language is a variable which stores the address 
		of another variable. This variable can be of type int, char, 
		array, function, or any other pointer. The size of the pointer 
		depends on the architecture. 
		On a 32 bit machine, your address range is 32 bits, 
		so a pointer will always be 4 bytes. 
		On a 64 bit machine were you have an address range of 64 bits, 
		a pointer will be 8 bytes.


Que 18: Why is void pointer?
		A pointer which does not have any data type associated with it 
		is callled void pointer.
		it can be used to store adress of any kind
		but while dereferencing it we must type cast it to appropriate
		data type
		when we allocate dynamic memory using mallock and callock 
		then void pointer is there return type
		that is memory allocated vy these functions can be used for
		any purpose.
		int x=10;
		char y='a';
		void *p= &x;
		p=&y;


Que 19: Why is NULL pointer?
		a pointer pointing to null is called null pointer
		can not be dereferenced
		can not be compared a ponteri hlding a real objec
		if we want to declear a poinert but dont want it to hold 
		any adress 
		by defaut it will point to some garbage location


Que 20: What is dangling pointer?
		a pointer poiniting to a memory location which has been freed 
		or the a location whose content has been deleted is called
		dangling pointer.

		delocating the memroy
		int *ptr=(int *) malock(sizeof(int));
		free(ptr);dangling
		ptr=null;nill

		returnig local variable in function

		int * func()
		{
			int a=10;
			return &a;
		}
		int main()
		{
			int *ptr=func();
		}


	vaiable going our of scope
	{
		int *ptr;
		{
		int i=0;
		ptr=&i;
		}
		ptr is dangling here
	}




Que 21: What is wild pointer?
		uninitilized pointers are called wild pointers
		it points to some arbitrary location
		and may cause program to crash or behave abnoramlly
		dereferencing it may cause problem
		should initilizw with null;



Que 22: Normalization?

	Normalization
	Normalization is the process of organizing the data in the database.
	Normalization is used to minimize the redundancy from a relation or 
	set of relations and to remove insertion update and delete anomolies.
	Data redundancy is defined as the storing of the same data in multiple locations

	1- Update Anomaly: 
				Let say we have 10 columns in a table out of which 2 
				are called employee Name and employee address. 
				Now if one employee changes it’s location then we 
				would have to update the table. But the problem is, 
				if the table is not normalized one employee can have 
				multiple entries and while updating all of those entries 
				one of them might get missed.
	2- Insertion Anomaly: 
				Let’s say we have a table that has 4 columns. 
				Student ID, Student Name, Student Address and Student Grades. 
				Now when a new student enroll in school, even though first 
				three attributes can be filled but 4th attribute will have 
				NULL value because he doesn't have any marks yet.
	3- Deletion Anomaly: 
				This anomaly indicates unnecessary deletion of important 
				information from the table. Let’s say we have student’s 
				information and courses they have taken as follows 
				(student ID,Student Name, Course, address). 
				If any student leaves the school then the entry related 
				to that student will be deleted. However, that deletion 
				will also delete the course information even though course 
				depends upon the school and not the student.
	1NF: The first normal form signifies that each cell of the table must only have single value. 
	Therefore, each intersection of rows and columns must hold atomic values. 
	For example: If we have a column name phone_number than each row for that column 
	must save only single phone number.
	2NF: We saw candidate key above and here is where it plays a role. 
	2NF rule signifies that no non-prime attributes in the table are dependent 
	on any of the candidate key. In simple words, 
	If the table is representative of two different entities then it should be broken 
	down into their own entities. 
	For example: 
	If we have a table 
	(Student ID, Student Name, Course Number, Course Name, Teacher ID, Teacher Name) 
	this is representing information about each student enrolled in each course 
	which is taught by each teacher in school. 
	Since it is a representative of three different entities it must be normalized into 2NF form.
	3NF: This rule signifies that tables must be in 2NF form and each table should only 
	contain columns that are non-transitively depended on primary key of their own table. 
	In simple words, if we have a table 
	(Transaction ID, price, quantity, total_sales) 
	here the total sales is the product of price and quantity (price*quantity). 
	Hence sales is transitively depended in Transaction ID which is a primary key here. 
	So each attribute must directly depend upon the primary key.
	Normalization divides the larger table into the smaller table and links 
	them using relationship.
	The normal form is used to reduce redundancy from the database table.

		



Que 23: Structure ?
		Structures are like user defined data types in c
		it helps us to combile data of different types togather
		similer to array but can store data of different type 
		which is more usefull
		struct ketord is used to create structure
		suppose we want to store information of students
		like name contact no email empid
		struct employee
		{
			int id;
			char name[30];
			float marks;
		}e1,e2;


		struct employee
		{
			int id;
			char name[30];
			float marks;
		};                        //38bytes
		struct empoyee e1,e2;



		made outside main method(linked list example)


Que 23: Union ?
		User difned data type
		in Structure every member has his own memory location
		whereas in union uses a singe h=shared memory location
		the single shared memory location is equal to the size of
		its largest data member
		union employee
		{
			int id;
			char name[30];
			float marks;
		};                        //30bytes
		union empoyee e1,e2;
		union keyword is used to declear a union
		only one member is used at a time remaining gets corrupted
			





Que 24: File system vs DBMS?
		
		dbms
			client server architecture
		filesystem
			client server architecture
		dbms
			does not requires the location of data
		filesystem
			location of data is required
		dbms
			concurrent acess is provided by protocols
		filesystem
			inconsitancy may ocure
		dbms
			Security is provided 
			various views for various users
			role based security
		filesystem
			no sucurity protocols
		dbms
			data redundancy is removed
			primary key 
			foreign key
		filesystem
			redundancy


		client server archi
		data redundance 
		security
		cuncurrent access



Que 25: acid properties?
	A transaction is a single logical unit of work which accesses and possibly modifies the contents of a database. Transactions access data using read and write operations. 
In order to maintain consistency in a database, before and after the transaction, certain properties are followed. These are called ACID properties. 
Atomicity 
By this, we mean that either the entire transaction takes place at once or doesn’t happen at all. There is no midway i.e. transactions do not occur partially. Each transaction is considered as one unit and either runs to completion or is not executed at all. It involves the following two operations. 
—Abort: If a transaction aborts, changes made to database are not visible. 
—Commit: If a transaction commits, changes made are visible. 
Atomicity is also known as the ‘All or nothing rule’. 

Consistency 
This means that integrity constraints must be maintained so that the database is consistent 
before and after the transaction. It refers to the correctness of a database. 
Referring to the example above, 
The total amount before and after the transaction must be maintained. 
Total before T occurs = 500 + 200 = 700. 
Total after T occurs = 400 + 300 = 700. 
Therefore, database is consistent. Inconsistency occurs in case T1 completes but T2 fails. 
As a result T is incomplete. 

Isolation 
This property ensures that multiple transactions can occur concurrently without leading 
to the inconsistency of database state. Transactions occur independently without interference. 
Changes occurring in a particular transaction will not be visible to any other transaction 
until that particular change in that transaction is written to memory or has been committed. 
This property ensures that the execution of transactions concurrently will result in a state 
that is equivalent to a state achieved these were executed serially in some order. 

Durability: 
This property ensures that once the transaction has completed execution, the updates and 
modifications to the database are stored in and written to disk and they persist even if 
a system failure occurs. These updates now become permanent and are stored in non-volatile 
memory. The effects of the transaction, thus, are never lost. 


Que 26: Why final variable is blank?
	if we will store zero in final variable like instance and static variable
	then this will be of no use for us bcoz in this case zero will become final
	and we wont be able to update this value later..
	thats why in order to assign a value on run time we left it blank
	or later in the program according to our need

Que 27: Instanceof keyword ?
		this is used to check weater a given variable is a instance of a given class 
		or not... it is used only if the reference varibale and the given class have
		parent child relation

Que 28: Difference bw get and post method ?
		Get method can be bookmarked whereas post an not be bookmarked
		get method can be cached but post cannot b cached
		parameter are passed through url in get method
		whereas data is passed through internal body parts in post method
		in get method parameer remains in history 
		whereas in post method parameter does not remains in history
		in get method only ascii values are allowed 
		whereas in post method binart data can be als sent
		get is less secure and shouls not be used with sensitie data
		limited length in getv ut no limitataion in post

Que 29: Error and Exception
	Errors are non recoverable 
	Exceptions can be handled
	Error occures beacause of the enviornment in which the program is running
	Exception occures due to the program itself
	Error are in java.lang.error package
	Exception are in java.lang.exception package
	example of error are virtual machine error
	example of exception are io exception

	Two types of error are there 
	compile time which occures due to syntax error
	and run time which occures dur to lack of recources
	exception are also divided into two categories
	checked and uncheked
	exceptions which can ;be checked by compiler are called
	checked exception 
	whereas exception which are not checked by compiler are
	called uncheked exception

Que 30: ER model
	An Entity–relationship model (ER model) describes the structure 
	of a database with the help of a diagram, which is known as Entity 
	Relationship Diagram (ER Diagram). An ER model is a design or blueprint 
	of a database that can later be implemented as a database.
	
	entity is anything which has physical existance
	attributes are charatersictics of entity
	relation represents relations bw entities
Oval
	entities are represented by Box
	relation are represented by diamond
	types of attriutes
	simple can not be broken further
	single valued
	multivalued--having multiple values--by double eclipse
	composite--consisting of more simple attributes
	derived--derived from other--dotted circle
	key attribute--unique--underline in circle

Que 31: Types of relationships/cardinality
	one to one--->1-1
	example: person-passport

		employee          works              dept
	eid name age 						did dname loc






					eid    did


	pk can be both eid or did
	table will be merged on pk side
		one to many--->1-m
		example: country-city
				 customer-order
				 person-account
			customer                         order
 	     id name city		            ono name cost




						gives
					id ono date

	
	PK:- will be of many side 
	table merged on many side i.e. on pk side


	many to many--->m-m
		example: student-cource
				 books-author
				 album-artist
			Student                        Cource
	      id name city		            Cno name credit
	



					   study
					id cno date

	
	PK:- will be composite
	can not be merged


Que 32: Orace connectivity
	import java.sql.*;  
	class OracleCon
	{  
	public static void main(String args[])
	{  
		try
		{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
  		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","oracle");    
		Statement stmt=con.createStatement();  
  		ResultSet rs=stmt.executeQuery("select * from emp");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		con.close();  
		}
		catch(Exception e){ System.out.println(e);}  
		}  
	}  



Que:33	What is Stack Memory?
 Stack in java is a section of memory which contains methods, 
 local variables, and reference variables. 
 Stack memory is always referenced in Last-In-First-Out order. 
 Local variables are created in the stack.
 The stack memory can grow or contract as any new methods get 
 called and returned accordingly.
 Any variable in the stack can run as long as the scope of the 
 method exists.
 It gets auto-allocation and deallocation as and when a method 
 undergoes execution. 
 In the case of full memory, the java.lang.StackOverFlowError sets off.
 It is faster in access when compared to the heap memory.

Que:34 What is Heap Memory?
 Heap is a section of memory which contains Objects and may also 
 contain reference variables. Instance variables are created in the heap
In heap memory, when it gets full, it returns java.lang.OutOfMemoryError.

Que:35 What is Method area Memory?
	class level data and static variables are stored in mam

Que:36 What is Method PC Register Memory?
	corresponding to eery thread there is a pc register
	that holds the adress of next instruction to be executed

Que:37 What is  native Memory?
	to hold native method infrmation.

Que:38 What is JDK?
	java Developement kit 
	responsible for developing and running java prpgram
	JDK = JRE + Developing tools

Que:39 What is JRE?
	Java runtime enviornment 
	just to run the program
	interpret read and execute
	JRE = JVM + library classes
	
Que:39 What is JVM?
	it takes..from copy for now

Que:40 What is SDLC?
	best differes according to the deveopment process
	agile-->little little modules-->better one
	planning-->analysis-->RequirmentGathering-->
	-->desigining-->coding(unitTestingAssertEquals ans is given by us and checked by developer)-->testing-->deployment
	Waterfall>time consumnig one by one taks sequientially done competely 
	old one


Que:41 What is Stateless forgetfull protocol?
	HTTP is stateless forgetfull protocol
	it does not remembers what it did in last
	step if a request is sent then everytime
	the request is considered as a new request
	even if the sender is same
	soo in order to identify an user some session tracking 
	techniaque are provided these are called session tracking 
	techniques
	1--cookies
	2--session
	3--hiddedform fild
	4--urlrewriting

Que:42 size of int in c and java?
	In java size of data types are independent of the machine architracture
	byte - 1 byte - 8 bits - range -128 to 127 - 2^7 to 2^7-1
	short - 2 byte - 
	int - 4 byte - 2147483647
	long - 8 byte 
	float - 4 byte
	double - 8 byte
	char - 2 byte 65535
	boolean - 1 byte 

Que 43: Immutability of String

Ans:Immutable means cannot be changed
	When the compiler sees a String literal, 
	it looks for the String in the pool. If 
	a match is found, the reference to the 
	new literal is directed to the existing 
	String and no new String object is created. 
	The existing String simply has one more reference. 
	Here comes the point of making String objects immutable
	In the String constant pool, a String object is likely 
	to have one or many references. 
	If several references point to same String without even knowing it, 
	it would be bad if one of the references modified that String value. 
	That’s why String objects are immutable.







Que 44: What do you mean by Fail-fast and Fail-safe
	Iterators in java are used to iterate over the Collection objects.
	Fail-Fast iterators immediately throw ConcurrentModificationException 
	if there is structural modification of the collection. Structural 
	modification means adding, removing any element from collection while a 
	thread is iterating over that collection. Iterator on ArrayList, HashMap 
	classes are some examples of fail-fast Iterator.
	Fail-Safe iterators don’t throw any exceptions if a collection 
	is structurally modified while iterating over it. This is because, 
	they operate on the clone of the collection, not on the original 
	collection and that’s why they are called fail-safe iterators. 
	Iterator on CopyOnWriteArrayList, ConcurrentHashMap classes are examples 
	of fail-safe Iterator.
	To know whether the collection is structurally modified or not, 
	fail-fast iterators use an internal flag called modCount which is 
	updated each time a collection is modified.Fail-fast iterators checks 
	the modCount flag whenever it gets the next value (i.e. using next() method), 
	and if it finds that the modCount has been modified after this iterator has 
	been created, it throws ConcurrentModificationException.
	 while (iterator.hasNext()) {
	            System.out.println(cityCode.get(iterator.next()));
	            // adding an element to Map
	            // exception will be thrown on next call
	            // of next() method.
	            // cityCode.put("Istanbul", "Turkey");
	            // cityCodes.remove("ABC");
	            // both will throw the exception
	        }
	 Iterator<Integer> itr = al.iterator();
	        while (itr.hasNext()) {
	            if (itr.next() == 2) {
	                // will not throw Exception
	                itr.remove();
	            }
	        }
	
	Fail Safe Iterator
	First of all, there is no term as fail-safe given in many places as Java SE specifications 
	does not use this term. I am using this term to demonstrate the difference between Fail 
	Fast and Non-Fail Fast Iterator. These iterators make a copy of the internal 
	collection (object array) and iterates over the copied collection. Any structural 
	modification done to the iterator affects the copied collection, not original collection. 
	o, original collection remains structurally unchanged. 
	Fail-safe iterators allow modifications of a collection while iterating over it.
	These iterators don’t throw any Exception if a collection is modified while iterating over it.
	They use copy of original collection to traverse over the elements of the collection.
	These iterators require extra memory for cloning of collection. Ex : ConcurrentHashMap, 
	CopyOnWriteArrayList
	 ConcurrentHashMap<String, Integer> map
	            = new ConcurrentHashMap<String, Integer>(); 
	 CopyOnWriteArrayList<Integer> list
	            = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 });
	The major difference is fail-safe iterator doesn’t throw any Exception, contrary to 
	fail-fast Iterator.This is because they work on a clone of Collection instead of the 
	original collection and that’s why they are called as the fail-safe iterator.
		 
		






Fully qualified class Name is class name with its package
like
java.util.Scanner


Data_Structure
1.bubble short

2.insertionsort
	Insertion sort is a simple sorting algorithm that works similar to the way you sort 
	playing cards in your hands. 
	The array is virtually split into a sorted and an unsorted part. 
	values from the unsorted part are picked and placed at the correct 
	position in the sorted part.
3.mergesort

4.selectionsort
	Selection sort is a simple sorting algorithm. This sorting algorithm is an 
	in-place comparison-based algorithm in which the list is divided into two parts, 
	the sorted part at the left end and the unsorted part at the right end. 
	Initially, the sorted part is empty and the unsorted part is the entire list.
	The smallest element is selected from the unsorted array and swapped with the leftmost 
	element, and that element becomes a part of the sorted array. 
	This process continues moving unsorted array boundary by one element to the right


5.heapsort


6.combsort
Comb Sort is mainly an improvement over Bubble Sort. 
Bubble sort always compares adjacent values. 
So all inversions are removed one by one. 
Comb Sort improves on Bubble Sort by using gap of size more than 1. 
The gap starts with a large value and shrinks by a factor of 1.3 in 
every iteration until it reaches the value 1. 
Thus Comb Sort removes more than one inversion counts with one swap 
and performs better than Bubble Sort.
The shrink factor has been empirically found to be 1.3
(by testing Combsort on over 200,000 random lists) [Source: Wiki]
Although, it works better than Bubble Sort on average, worst case remains O(n2).
if gap is 9 or 10 then gap = 11;********



7.quicksort


8.Stack
A Stack is a linear data structure that follows the LIFO (Last-In-First-Out) principle
if we want to insert elemnts or if we want to delete elements than both the operations are done 
on same end which is calles the top of the stack.
that is we can say that stack is like a container in which insertion and deletion 
both is done on same end called top of the stack
some standad operation which can be performed on stack are
push()- insert a element at top
pop()- delete the element at top and returns it
peek()- return the element at top
isEmpty()- tells weather stack is empty or not
isFull()- tells weather stack is full or not.

9. Queue

















SQL-Structured Query Language

Why do we use in operator?
in operator allows us to provide multiple value in where Clause
it is a short hand o multiple OR

why do we use limit keyword?
to improve the performance while retriving data form a very large table

why do we use group by clause?
by using group by caluse we can get a group of rows having same value c
corrosponidn to a particular column 

why do we use having clause?
generally used in combination of group by caluse
when we use group by then data is also aggregated and to provide condition to
aggregated data having caluse is used bcoz where cannot b used here'



outer join
Left outer join
This join returns all the rows of the table on the left side of the join and matching rows for 
the table on the right side of join. 
The rows for which there is no matching row on right side, the result-set will contain null. 
LEFT JOIN is also known as LEFT OUTER JOIN

Right outer join
retrives all the data from the right table and the matching data if any frok the left tables
null is inserted if match is not found

Left outer join
retves data from both the table weather there ia any match or not


inner join
The INNER JOIN keyword selects all rows from both the tables as long as the condition satisfies. 
This keyword will create the result-set by combining all 
rows from both the tables where the condition satisfies 
i.e value of the common field will be same.



what is primary key?
Primary key can e used to uniquely indentify each row of a tbale
A primary key is a key which can not be left null and also we can not insert 
duplicate values in primary key column
can be composite as well as single.


what is foreign key?
A Foreign Key is a database key that is used to link two tables together. 
A FOREIGN KEY is a field (or collection of fields) in one table, 
that refers to the PRIMARY KEY in another table.
The table with the foreign key is called the child table, 
and the table with the primary key is called the referenced or parent table.
The FOREIGN KEY constraint is used to prevent actions that would destroy links between tables.

case when then end
	switch case of sql


what do you mean by views?
A view is a virtual table ie., if we want a small updation, we need to create new tables, 
so we can overcome thiz problem by using views.
( existing table   from which view is created is referred to as base table)
View is of 2 types: 
1. Simple View: view that contains only single base table. 
We cant use aggregate functions . We can use insert , delete and update commands directly
Syntax: 
Create view emp2
As select id, name from emp1 where experience >10;
2. Complex View: view that contains more than one base tables. We can use aggregate functions. 
We can't use insert , delete and update commands directly.
Syntx: 
Create view empview as selct emp1.ID, name , country from emp1, emp2 where emp1.ID= emp2.ID;


what do you mean by indexes?
Index are used to retrive the records at faster speed than tables , 
thus it leads to improve to performance. 
It makes retrieval faster, but makes any updation ( insert, delete , update) slower.
The reason behind this is that  updating a table with indexes takes more time 
than updating a table without (because the indexes also need an update) 
Best suits for RETRIEVAL.
Syntax: create index countryindex on emp1(country); 
Here, ON is used.
To drop index: 
DROP INDEX table_name.index_name;
Indexes are automatically created when PRIMARY KEY and UNIQUE constraints are defined on table 
columns.
There are 2 types of indexes: 
A. Clustered index
B. Non clustered index
* in a table there can be only one clustered index or one or more than one non_clustered index.
* In Clustered index there is no separate index storage but in Non_Clustered index there is separate index storage for the index.
* Clustered index is slower than Non_Clustered index.


what do you mean by stored procedures?
A stored procedure is a prepared SQL code that you can save, 
so the code can be reused over and over again, just by calling it to execute. 
To create: 
CREATE PROCEDURE SelectAllCustomers
AS
SELECT * FROM Customers
GO;

How to execute: 
EXEC SelectAllCustomers;


We can also pass parameters , so that stored procedures can act accordingly.

Example: 
To create: 
CREATE PROCEDURE SelectAllCustomers @City nvarchar(30), @PostalCode nvarchar(10)
AS
SELECT * FROM Customers WHERE City = @City AND PostalCode = @PostalCode
GO;

To execute: 
EXEC SelectAllCustomers @City = 'London', @PostalCode = 'WA1 1DP';


What do you mean by no sql?









instanc variable insde static method
run time and compil time polymorphism
static final int x what not constructor







if(year%400==0 || (year%4==0&&year%100!=0))




365 days 6 hours  islie har 4 saal me ek din extra

365 days 5hr 48 min 45 sec 
11 min 15 sec less then 6 hrs this makes 1day extra in 100 year
remove 1 day in 100 saal this makes only 18 hours that is 6 hrs extra 
removed in every 100 year '
therefor remove this one day in every 400 year' 



Second heighest salary

SELECT * 
FROM Employees 
ORDER BY SALARY DESC LIMIT 1,1;


SELECT * FROM Employees ORDER BY SALARY DESC LIMIT N-1,1;


At first, the Salary of all employees is arranged in decreasing order 
using ORDER BY DESC command.
Next the LIMIT command has two arguments first is the OFFSET i.e. 
this indicates after how many rows records are fetched, second is 
the LIMIT which tells how many records are to be fetched.

Binary Search tree
	comapre the root if samller then root go left else right
	keep doing this untill we reach to leaf level

A tree is a hierarchical data structure defined as a collection of nodes. Nodes represent value and nodes are connected by edges.


1.1. What is concurrency?
Concurrency is the ability to run several programs or several parts of a program in parallel. 
If a time consuming task can be performed asynchronously or in parallel, this improves the throughput
 and the interactivity of the program.
 The simplest way to avoid problems with concurrency is to share only immutable data between threads. 
 Immutable data is data which cannot be changed.
 To make a class immutable define the class and all its fields as final.
 Java runnable is an interface used to execute code on a concurrent thread. 
 ----------------------------------
 * Concurrency is the ability to run several or multi programs or applications in parallel.
 ----------------------------------































104 - jama
4--4
7--3
11--4




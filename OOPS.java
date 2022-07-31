									OOPS(Object oriented Programming)
								    =================================
1.OOP is a programming paradigm or methoddology.

Paradigm can also be termed as method to solve some problem or do some task. Programming paradigm is an approach
to solve problem using some programming language or also we can say it is a method to solve a problem using tools
and techniques that are available to us following some approach.
For example -> Object Oriented Paradigm, Procedure Paradigm, Functional Paradigm, Logical Paradigm, Structural Paradigm

6 main pillars are for OOPS
1.Class
2.Object and methods
3.Encapsulation
4.Polymorphism
5.Abstraction
6.Inheritance

Que->Which language is purely object oriented language ?
Ans-> Smalltalk, In Smalltalk, primitive values such as integers, booleans and characters are also objects.

---------------------------------------------------------------------------------------
Class is a collection of objects.
Class is not a real world entity. It is just a template or blueprint or prototype.
Class does not occupy memory.
---------------------------------------------------------------------------------------

Method is basically a set of codes which perform a particular task.
Advantage of creating Method is :-
1.Code reusability
2.Code Optimization
-----------------------------------------------------------------------------------------
Object is instance of class. Like Dog is an instance of Animal.
Object is real world enitity.
Object occupies memory.
Object consist of identity(name), state / attributes(fields) and behaviour(methods).

We can cerate the object by using:-
1.new keyword.
2.newInstance() method
3.clone() method
4.desialization
5.factory methods
-----------------------------------------------------------------------------------------

*Encapsulation like POJO class
--------------
Encapsulation in java is a machanism of wrapping the data(variables) and code acting on that data(methods) together
as a single unit.
To achieve encapsulation 
1.Declare the variables of a class is private.
2.Provide public setter and getter methods to modify and view the variables values.

In ecapsulation, the variables of a class will be hidden from other classes, and can be accessed only through  the
methods of their current class. This concept is known as Data Hiding.


*Inheritance (IS-A Relationship)
------------
Advantage of Inheritance is code reusability but the disadvantage is that it become tightly coupled.
One more advantage, because of inheritance runtime polymorphism also have existence which allow method Overriding.
*In java Multiple and Hybrid inheritance is not possible.
*Constructor never get inherited.
*private members never get inherited.
The process through which one class acquires all the properties and characteristics 
   (like fields and methods) of another classes is called inheritance.
   here the class from which we inherit the properties is called as a
   super class or parent class and the class in which properties are getting inherited is calles 
   chile class or sub class
   To apply inheritance, extends keyword is used.
   for example if there is a class a and a class b
   if we want to inherit properties of class a in class b then we will write
  class b extends a
   
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
  ...
   QUE 8: what do you mean by Data Encapsulation?
   		Encapsulation is one of the four fundamental OOPs concepts. 
   		The other three are inheritance, polymorphism, and abstraction.
   		Encapsulation in Java is a mechanism of wrapping the data (variables) 
   		and code acting on the data (methods) together as a single unit. 
  
  		The method must have the same name as in the parent class
  		The method must have the same parameter as in the parent class.
  		There must be an IS-A relationship (inheritance).
   			if we dont like the defenation of a mthod in parent classes
   			then overriding provides us the facility to change that defination.

Inheritance (IS-A), Association (HAS-A), Aggregation & Composition - Relationship in Classes Java
--------------------------------------------------------------------------------------------------
Types of relationship
1. Inheritance (is-a)
2.Association (has-a) -> It has Aggregation and Composition. It doesnt produce tightly coupled.
Association is a relation between two seperate classes which establishes through their objects.
Association can be one-to-one, one-to-many, many-to-one, many-to-many.
Aggregation -- weak bonding like (Car and Music Player)
Composition -- strong bonding like (Car and Engine)




Advantage
---------
Code reusability
Cost cutting
Reduce Redundancy



*Polymorphism
-------------
Polymorphism means "many forms", and it occurs when we have many classes that are related to each other by inheritance.
Polymorphism is the ability of an object to take on different forms. In Java, polymorphism refers to the ability
of a class to provide different implementations of a method, depending on the type of object that is passed to 
the method.

Types of Polymorphism
---------------------
You can perform Polymorphism in Java via two different methods:

1.Method Overloading  Or Compiletime Polymorphism Or Static Polymorphism
2.Method Overriding	or Runtime Polymorphism Or Dynamic Polymorphism

Method Overloading // Overloading resolves the ambiguity error
------------------
1.should have same name of method
2.Have all overloaded methods in same class
3.Should have different Arguments
*Sequence of parameters matter in this. Different data type will also work for the overloading.
*In Java method overloading is not possible by changing the return type of the method.
*Main method can be overloaded because JVM always call the main() method which receives string array as arguments 
only.

*Automatic Promotion
--------------------
One type is promoted to anathor implicitly if no matching datatype is found.
byte->short->int->long->double
long->float
long->double
float->double
char->int

Whike resolving Overloaded Methods, Compiler will always give precedence for the child type argument than compared 
with parent type argument.

Suppose void show(int... a){} //This will allow mutliple arguments
The varargs allows the  method to accept zero or mutliple arguments.Before varargs either we use overloaded method
or take an  array as the method parameter but it was not considered good because it leads to the maintenance 
problem. If we do not know how many arguments we will have to pass in the method, args is the better approach.
											In general, varargs get least priority i.e. if no other methods matched,
then only varargs method will get the chance, because it came in 1.0 version and varargs came in 1.5 version.

Method Overriding // There should be the inheritance
-----------------
Method overriding allows a subclass or child class to provide a specific implementation of a method that is 
already provided by one of its superclasses or parent classes. The implementation in the subclass overrides
(replaces) the implementation in the superclass by providing a method that has same name, same parameters
or signature and same return type as the method in the parent class.

1.Same name
2.Different class
3.Same Arguments
Final methods can not be overridden
An overriding method can also return a subtype of the type returned by the overridden method. 
This subtype is called a covariant return type.

Que->Do overiding method must have same return type or subtype ?
Ans->Before 1.4 version the return type should be same but after JDK 5.0 onwards we can use covarient return type.
Covarient means to have different return type for a overriding method in child class, but childs return
type should be the subtype of parent return type.
This phenomena is known as Covarient return type.

Object -> String,StringBuffer,StringBuilder,Number,Character,Boolean,Void etc.
Number->Byte,Short,Integer,Long,Float,Double

Que-> Overriding and Access-Modifiers rule ?
Ans->The access modifier for an overriding methods can allow more, but not less, access than the overridden method.
FOr example, a protected instance method in the super class can be made public, but not private, in the subclass.
Doing so, it will generate compile time error. 

***********************hierarchy of access modifiers in java ????????????
ANS-> 
Simply put, there are four access modifiers: public, private, protected and default (no keyword).
Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the 
class.
Default: The access level of a default modifier is only within the package. It cannot be accessed from outside 
the package. If you do not specify any access level, it will be the default.
Protected: The access level of a protected modifier is within the package and outside the package through child
 class. If you do not make the child class, it cannot be accessed from outside the package.
Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside 
the class, within the package and outside the package.

Default – No keyword required
Private
Protected
Public
 public > protected > default > private i.e in Overriding access modifier should be the highest priority
 in child class overrided method and lower access modifer in parent class overrided method.

 Overriding and Exception HAndling
 ==================================
 Rule 1:- If the super class overridden method does not throw an exception, subclass Overriding methods can only 
 throws the uncheked exception, throwing checked exception will lead to compile-time error.

 Rule 2:- If the super-class overridden method does throws an exception,subclass overriding method can only throw 
 same, subclass exception. Throwing parent exception in Exception hierarchy will lead to compile time error.
 Also there is no issue if subclass overridden method is not throwing any exception. 

*Abstraction
------------
Abstraction is hiding internal implementation & just highlighting the setup services that we are offering.
We achieve abstraction in two ways:-
1.Abstract Class - (0-100%) abstraction
2.Interfaces - (100%) abstraction

1.Abstract class
----------------
abstract class Vehicle{
	int no_of_tyres;
	void start(); //A method without body(no implementation) is known as abstract method.
}

Note:- 
1.A method must always be declared in an abstract class, or we can say that if a class has an abstract
method, it should be declared abstract as well.

2.If class is abstract that doesnt mean it should have abstract method.
3.If a regular class extends an abstract class, then the class must have to implement all the abstract method
of abstract parent class or it has to be declared abstract as well.
4.We can not create the object of Abstract class.But we can create the reference.
5.Abstract method in a abstract class are meant to be overridden is derived concrete classes otherwise compile time 
error will be thrown.
6.Constructors are allowed in abstract class.

2.Interfaces
------------
1.Interfaces are similiar to Abstract class but having all the methods of abstract type.
2.Interfaces  are the blueprint of the class. It specify what a class must do and not how.
3.It is used to achieve abstraction. It supports multiple inheritance.
4.It can be used to loose coupling.
5.If we not specify the access modifier in method then it will automatically use public and abstract keyword prior 
to method.
6.Fields are bydefault become public static final. 
	public static final int a=10;
7.In java 8 version we can build default concrete methods and static also.
default void display(){-- }
public static void run(){--}

In 9th version we can create private methods.

interface I1{
	void show();
}

class Test implements I1{
	void show(){--}
}
Because here overriding concept takes place thats why it follows the rules of Overriding.

this keyword
------------
Object have state and behavoiur. this keyword is the reference variable that refers to the current object.


super
-----
It is also the reference variable which is used to refer immediate parent class object.
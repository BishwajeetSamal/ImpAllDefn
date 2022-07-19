

												♨️ Java 8
												----------
1.Java 8 has introduced a lot of new APIs that have changed the way code is written in Java. Code written in Java 8
is more concise, more readable, and faster, but a developer needs a thorough understanding of the concepts to 
fully utilize the power of Java 8.


Anonymous functions
-------------------
1. No Name that is name less
2.No return type
3. No access modifier

What is a lambda expression?
-----------------------------
It is a anonymous function.
Lambda expressions are introduced in Java 8. These are used primarily to define inline implementation of a functional 
interface, i.e., an interface with a single method only.

Lambda expression eliminates the need of anonymous class and gives a very simple yet powerful functional programming
capability to Java.

Java lambda expression is treated as a function, so compiler does not create .class file.
1. Java is an object-oriented language. By introducing lambdas in Java 8, the authors of Java tried to add elements of 
functional programming in Java.
----------------------------------------------------------------------------
difference between object-oriented programming and functional programming is?
*******************************************************************************
In object-oriented programming, objects and classes are the main entities. If we create a function then it should 
exist within a class. A function has no meaning outside the scope of the class object.
In functional programming, functions can exist outside the scope of an object. We can assign them to a reference 
variable and we can also pass them to other methods as a parameter.
----------------------------------------------------------------------------
A lambda expression is just an anonymous function, i.e., a function with no name and that is not bound to an 
identifier. We can pass it to other methods as parameters, therefore, using the power of functional programming 
in Java.
Why use Lambda Expression
-----------------------------
1. To provide the implementation of Functional interface.
2. Less coding.


Lambda expressions can only implement functional interfaces, which is an interface with only one abstract method. 
The lambda expression essentially provides the body for the abstract method within the functional interface.
    
Java Lambda Expression Syntax
--------------------------------
(argument-list) -> {body}  
Java lambda expression is consisted of three components.

1) Argument-list: It can be empty or non-empty as well.

2) Arrow-token: It is used to link arguments-list and body of expression.

3) Body: It contains expressions and statements for lambda expression.
-----------------------------------------
() -> {  
//Body of no parameter lambda  
}

One Parameter Syntax

(p1) -> {  
//Body of single parameter lambda  
}  

(p1,p2) -> {  
//Body of multiple parameter lambda  
}  
-----------------------------------------

How to write a lambda expression#
---------------------------------
 We have a functional interface called Greeting.
@FunctionalInterface //@FunctionalInterface annotation is used to ensure that the functional interface 
//cant have more than one 
//abstract method -- method without body
-----------------------------
=====================================================================================
public interface Greeting {
    void greet();
}
---------------------------
public class HindiGreeting implements Greeting {

    // Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Namaste");
    }
}
---------------------------
public class EnglishGreeting implements Greeting {
    
    // Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Good Morning");
    }
}

---------------------------

public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        Greeting hindiGreeting = new HindiGreeting();
        wish(hindiGreeting);  // Passing an object of HindiGreeting.

        Greeting englishGreeting = new EnglishGreeting();
        wish(englishGreeting);  // Passing an object of EnglishGreeting.
    }
}

Output
----------
Namaste
Good Morning
===========================================================================================
This is a classic object-oriented programming example. 
Now, what if we want our WellWisher class to greet in all the languages available?

Do we need to create a class for each language, e.g., SpanishGreeting, FrenchGreeting, etc?

Isn’t it possible that we don’t create any class and just send a function to the wish(Greeting greeting) method?

Our wish(Greeting greeting) method will directly execute the function that is provided to it and print the greeting.

This is possible through anonymous classes. We will quickly see how this can be done through an anonymous 
class, and then jump straight back into lambdas.

In the below example, we will change the WellWisher class to use an anonymous class.
==================================
public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        // We are passing an anonymous class object to the wish method.
        wish(new Greeting() {
            @Override
            public void greet() {
                System.out.println("Namaste");
            }
        });
    }
}


@FunctionalInterface
public interface Greeting {
    void greet();
}

Output --
---------
Namaste
=====================================
In the above example, we don’t need to create a class for each language. We can use an anonymous class, and
 that does the trick for us in the example above. 
 Although the class is anonymous, we are still creating a class.

 To make our code less cumbersome, let’s remove all the unnecessary code step-by-step and create our first lambda expression.

 Step 1 -> The compiler knows that the wish(Greeting greeting) method takes in a parameter of type Greeting. 
 So, we don’t need to specifically create an anonymous class of type greeting.
--------------------------
============================
 public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        wish(
            public void greet() {
                System.out.println("Namaste");
            }
            );
    }
}

Step 2 -> We know that the Greeting interface has only one method. So, we don’t need to provide the method name. 
We are only concerned with the method body.

public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        wish(

            public void () {
                System.out.println("Namaste");
            }
            );
    }
}

Step 3 -> The compiler can understand that the body does not return anything. So, mentioning the return type is 
redundant. We can also remove the public declaration.

public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String args[]) {
        wish(
                () -> {
                    System.out.println("Namaste");
                }
        );
    }
}

Note--->>>>Please note that we add a -> between the empty brackets and the method body. 
This is how a lambda expression is declared.
-----------------------------------------------------
There still is one more improvement we can make. Since the method body contains only a 
single line, the curly braces are also unnecessary.
public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    // Passing a lambda expression to wish method.
    public static void main(String args[]) {
        wish( () -> System.out.println("Namaste") );
    }
}

@FunctionalInterface
public interface Greeting {
    void greet();
}
Output------>
---------
Namaste
========================================================
when we write a lambda expression, we are basically sending a function as a method parameter, and
 it is directly getting executed.
-----------------------------------------------------------

Java Comparator Using Lambda
****************************

Learn how to use the power of lambdas to write a concise comparator.

1.If you’ve been working with Java for some time, then you’ve probably encountered a scenario where 
you need to sort the elements in a collection.
2.If your collection contains a wrapper class object then the sorting is very easy. Since all the wrapper classes 
implement the Comparable interface, you can directly use Collections.sort() to sort your collection.
3.However, if your collection contains a custom class object then you need to provide the logic to sort your object.
4.In this lesson, we will look at an example in which we will sort a list of Person class objects using a comparator. 
Then, we will write a program to do the same task using lambdas.

Comparator example using anonymous class#
-----------------------------------------
First, we will create a Person class.
public class Person {

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}

Now, we have a PersonService class. It has a getPersons(List<Person> persons) method. It takes a list of person
 objects as input and returns a list of person object in sorted order.

 In this method, we are creating an anonymous comparator, which sorts the Person objects on the basis of name.
 import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public static List<Person> getPersons(List<Person> persons){
        // Created an anonymous Comparator, which sorts the Person object on the basis of Person name.
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        return persons;
    }
}

Finally, we have a PersonMain class that runs our logic.
import java.util.List;

public class PersonMain {

    public static void main(String args[]){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        // Calling getPerson() method which will return the List of Person in sorted order.
        List<Person> sortedPersons = PersonService.getPersons(persons);

        System.out.println("Persons after sorting");
        // Printing the name of each person.
        for(Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }
    }
}
Output
---------------------
Persons after sorting
Person Name : Amit
Person Name : Carl
Person Name : John
Person Name : Kane
Person Name : Vikram
================================================
If you look at the Comparator interface, you notice that it is a functional interface. 
It has only one abstract method called compare(). This makes it a perfect candidate to be used in lambdas.

Comparator example using a lambda expression
---------------------------------------------
Now, let’s see how we can write the same logic using a lambda expression. 
when writing lambdas, we only need to consider the input parameters and the method body.
Below is the signature of the compare() method.

int compare(T o1, T o2)
It takes two parameters as input and returns an int.

Let’s start constructing the lambda expression:
The structure of lambda will be like:
(p1, p2) -> {};
Here, p1 and p2 are the two input parameters. We can name them anything.
Now, we will add the body.
(p1, p2) -> p1.getName().compareTo(p2.getName());
 lambda expression for sorting the Person objects based on name.
 You can see how easy and concise it is to write code with lambdas instead of using anonymous classes.
 =================
 import java.util.Collections;
import java.util.Comparator;
import java.util.List;
PersonService.java
-------------------
public class PersonService {

    public static List<Person> getPersons(List<Person> persons) {
        // Instead of creating an anonymous class, we have provided a lambda expression.
        Collections.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        return persons;
    }
}

PersonMain.java
-------------------------
import java.util.ArrayList;
import java.util.List;

public class PersonMain {

    public static void main(String args[]){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John" , 23 , "USA"));
        persons.add(new Person("Carl" , 23 , "Australia"));
        persons.add(new Person("Amit" , 23 , "India"));
        persons.add(new Person("Vikram" , 23 , "Bhutan"));
        persons.add(new Person("Kane" , 23 , "Brazil"));
        // Calling getPerson() method which will return the List of Person in sorted order.
        List<Person> sortedPersons = PersonService.getPersons(persons);

        System.out.println("Persons after sorting");
        for(Person person : sortedPersons){
            System.out.println("Person Name : " + person.getName());
        }
    }
}

Person.java
------------
public class Person {

    private String name;
    private int age;
    private String country;

    public Person(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}

Output
---------
Persons after sorting
Person Name : Amit
Person Name : Carl
Person Name : John
Person Name : Kane
Person Name : Vikram
===============================
//This adds the 1000 in salary using lambda expression.
package pretest;
import java.util.ArrayList;
import java.util.List;

public class Test {
        
     public static void main(String []args) {
           List<Person> persons =new ArrayList<>();
           persons.add(new Person(1 , "Bishwajeet" , 90000));
            persons.add(new Person(1 , "Farhan" , 90000));
            persons.add(new Person(1 , "Keshav" , 830000));
           
       
//   Stream<Person> stream = persons.stream();
//   stream.forEach(p -> System.out.println(p));
//   
     
            persons.stream().forEach(p -> System.out.println(p));
            persons.stream().forEach((p) -> {
         p.setSalary(p.getSalary()+1000);
     });
     
     persons.stream().forEach(p -> System.out.println(p));
     }
}
===============This adds the 1000 in salary using lambda expression.
Streams will also be able to utilize both lambda expressions and functional interfaces.
-------------------------------------------------------------------------

										Function Interface
										------------------
Function is a category of functional interfaces that takes an object of type T and returns an object of type R.
A functional interface is an interface that contains a single abstract method. As with regular interfaces, functional 
interfaces are allowed to have any number of default methods.
 Several existing interfaces already follow this pattern: Callable, ActionListener, and Runnable.
Functional Interface in java Examples
-------------------------------------
Runnable ---> run()
Callablec--->call()
Comparable--->compareTo()
ActionListener--->actionPerformed()

Predefined Functional Interface
------------------------------
1.  Predicate(I)
2. Function
3. Consumer
4. Supplier


Without Functional interface we cannot invoke lamda functions.It is compulsory to have.
Predicate Functional Interface
==============================
    1.Java 8 provides some in-built functional interfaces in the java.util.function package. 
    2.These interfaces are required so that, while writing lambda expressions, we don’t need to worry 
    about creating a functional interface.
    There are 43 predefined interfaces in Java 8.

    ----------------------------------------
Predicate<T>---Represents a predicate (boolean-value function) of one argument (reference type)--boolean test(T t)
DoublePredicate -----Accepts one double-value argument  --- boolean test(double value)
IntPredicate   ----- Accepts one int-value argument. -----boolean test(int value)
LongPredicate  ---- Accepts one long-value argument ---boolean test(long value)
BiPredicate<T,U> -----   Accepts two arguments (reference types)----- boolean test(T t, U u)
Function<T, R>
==============
R apply(T t)----This is the abstract method of the Function interface. It takes one argument of type T as input 
and returns a value of type R.
--------------------------------------------

import java.util.function.Function;
 
public class FunctionInterfaceDemo {
 
    public static void main(String[] args) {
        // Created a function which returns the length of string.
        Function<String, Integer> lengthFunction = str -> str.length();
        
        System.out.println("String length: " + lengthFunction.apply("This is awesome!!"));
 
    }
}
Output
----------
String length: 17
------------------------------------------
compose(Function<? super V, ? extends T> before)
Returns a composed function that first applies the function provided as a parameter on the input, and then 
applies the function on which it is called, to the result.
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String args[]) {

        // Function which adds 10 to the given element.
        Function<Integer, Integer> increment = x -> x + 10;
        // Function which doubles the given element.
        Function<Integer, Integer> multiply = y -> y * 2;
        // Since we are using compose(), multiplication will be done first and then increment will be done.
        System.out.println("compose result: " + increment.compose(multiply).apply(3));

    }
}
Output
-----------
compose result: 16
--------------------------------------------------
andThen(Function<? super R,? extends V> after)
This method returns a composed function that first applies the function on which it is called on the input, and 
then applies the function provided as parameter, to the result.
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String args[]) {
        Function<Integer,Integer> increment = x -> x + 10;
        Function<Integer,Integer> multiply = y -> y * 2;
        // Since we are using andThen(), increment will be done first and then multiplication will be done.
        System.out.println("andThen result: " + increment.andThen(multiply).apply(3));

    }
}
Output
----------
andThen result: 26
-----------------------------------------------------
BiFunction<T,U,R>
-----------------
we will create a BiFunction that takes two numbers as input and returns their sum.
import java.util.function.BiFunction; 
  
public class BiFunctionInterfaceDemo { 
    public static void main(String args[]) 
    { 
        
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b; 
  
        System.out.println("Sum = " + add.apply(2, 3)); 
  
    } 
} 
-----------------------------------------------------
package pretest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Bishwajeet", 20000));
        persons.add(new Person(1, "Farhan", 50000));
        persons.add(new Person(1, "Keshav", 3000));

//   Stream<Person> stream = persons.stream();
//   stream.forEach(p -> System.out.println(p));
//   

            persons.stream().forEach(p -> System.out.println(p));
            //by farhan Sir
            ---------------
            List<Person> personsSorted = persons.stream().sorted(Comparator.comparing(Person::getSalary)).collect(Collectors.toList());
            //by keshav Sir
            ---------------
//          List<Person> personsSorted = persons.stream().sorted(Comparator.comparing(o -> -o.getSalary())).collect(Collectors.toList());
        
            personsSorted.stream().forEach(p -> System.out.println(p));
    
    }
}

|-------------------------------|
To sort according to salary.    |
|-------------------------------|
Output-
-----------
Person [id=1, name=Bishwajeet, salary=20000]
Person [id=1, name=Farhan, salary=50000]
Person [id=1, name=Keshav, salary=3000]
Person [id=1, name=Farhan, salary=50000]
Person [id=1, name=Bishwajeet, salary=20000]
Person [id=1, name=Keshav, salary=3000]

Multithreading with Lamabda Expression
=======================================

-----------------------------------------------------------------------------------------------------
                                         |  *|I|* Strings *|I|* |
                                         | --*--*------*--*---- |
                                         |======================|
1.String is non-primitive datatype becuase it references a memory location where data is stored in the 
heap memory or String Constant Pool. It doesnot have fixed size of like primitive datatype.
2.String is the sequence of characters.
3.To represent the sequence of charecters, java have also created the interface. That is CharSequence.
4.String is a class.
5.public final class String extends Object implements CharSequence,Serializable,Comparable{
    //methods 
} 
6.String s = new String(); // This object is immutable object.
  String s = "amit"; // This object is immutable object.
  To create String, there are three classes:-
  1. String
  2.StringBuffer
  3.StringBuilder
(1. String is slower.)(2. StringBuffer is faster than String.)(3.StringBuilder is faster than StringBuffer)
String does not have reverse() method but SrtingBuffer and StringBuilder have.

String Constant Pool OR String Literal Pool
============================================
Whenever we create a object or variable then where it get stored. ?
---------------------------------------------------------------------
1.String Constant Pool (or String Literal Pool) is an area in heap memory where java stores String Literal
values.
2.String Constant Pool resides in Method Area (1.6 version) and in 1.7 version onwards String Constant
Pool resides in Heap Area. It can increase or decrease size in heap area.
It is a special memory area in heap.

String s1 = new String("bishwajeet"); // object created by using new keyword will provide area in heap area
//and s1 will point to it. Here bishwajeet is literal. So inside the String Literal Pool memory will create
//and that memory in SCP handled by the JVM internally.

If String s2 = "satyajeet"; // This will create the memory in String Constant Pool and s2 will point it.

In s1 case, two objects were created and for s2, one object will created.

Thats why we use s2 kind of object. (If String s2 = "satyajeet";)
In String Constant Pool, Garbage Collectors doesnot work because a reference 
variable internally is maintained by JVM but works for heap memory.

Special case
============
1st case
---------
1. String s1 = new String("rano"); // 2 objects created one in heap and other in SCP
2. String s2 = new String("jeet"); // 2 objects created one in heap and other in SCP
3. String s3 = new String("rano");// 1 object created in heap and because s1 with same literal is present
//in SCP thats why it will not create in String constant Pool.

Here, s1,s2 will have and created the memory in heap as well as in String Constant Pool.
But when we create s3 having same literal as s1. Then s3 will get the memory in heap area but again 
with same literal it will not create a memory for "rano" in String Literal Pool. Both s1 and s3 in SCP
points to the same memory area.

2nd case
---------
If i will create String s4 = "rano";
Because rano already in string literal pool , then it will not create any object. s4 will point to the object
which is present in SCP.
String s5 = "rano"; // This will also point to the same object in SCP.

What is String immutable ? .Why it is immutable ?
==================================================
Immutable means unchangable. String objects are immutable. It means once String object is created, its data
or state cannot be changed but a new string object is created.

String s = new String("bishwajeet");
s.concat(" java"); //After concat it will not update it in previous object rather it will create a new object
sop(s); //It will give output bishwajeet, because here reference haven't changed
But if
s=s.concat(" golang"); //Now the output will be bishwajeet golang, because it will change the reference.

String immutability always relates to string objects.

Que. Why String Objects are Immutable ?
Ans. String city1="Jajpur"; //It will make the reference inside the String Constant Pool
     String city2="Jajpur"; //city2 will point to the same city1 is pointing because string literal is
     //already present
     String city3 = "Jajpur";// It will point to the reference where city1 and city2 are pointing

     Now, city3 = "Jagannath Puri"; //Now city3 will point to the new one.
Thus, Strings are immutable in java because String objects are cached in String Pool. 
The string is immutable means that we cannot change the object itself, but we can change the reference to
the object. The string is made final to not allow others to extend it and destroy its immutability.
 
Why Strings are final in Java  (Difference between final and immutability)
==========================================================================
final keyword is used with class, method and variables
final class cannot be extend.
final method cannot be Override.
final variable value cannot be changed
But why string class is final

final class String{
     
}

Note:-
------
1. To make a immutable class :- 
------------------------------ 
1.Make the class final or Declare the class as final so it cannot be extended.
2. Make all fields private so that direct access is not allowed.
3.All methods can have getters but not setters. or Do not provide setter methods for variables.
4.Make all mutable fields final so that its value can be assigned only once. Thus, making it immutabile.
5.Initialize all the fields via a constructor performing deep copy.
6.Perform cloning of objects in the getter methods to return a copy rather than returning the actual 
object reference.

String Class Constructors
-------------------------
class String{
    public String(){} //no args constructor

    public String(String s){} //here we pass the string literal

    public String(StringBuffer sb){} 

    public String(StringBuilder sb){} 

    public String(char[] ch){}

    public String(byte[] b){}  

    //and many more constructors
}

String Class Methods
=====================
1.compareTo() - Compares two strings lexicographically (lexicographical order is alphabetical order).
2.compareToIgnoreCase() - Compares two strings lexicographically, ignoring case differences
3.concat() - Appends a string to the end of another string
4.contains() - Checks whether a string contains a sequence of characters
5.charAt() - Returns the character at the specified index (position)
6.isEmpty() - Checks whether a string is empty or not
7.length() - Returns the length of a specified string
8.trim() - Removes whitespace from both ends of a string
9.valueOf() - Returns the string representation of the specified value
10.static join(CharSequence delimiter,CharSequence... elements) //This is the static method. Here 3dots used
//because it allows to take as many characters possible.
12.String overrides equals() and hashCode() methods.


String s1="Bishwajeet";
String s2=" Samal";
sop(s1+s2); //Bishwajeet Samal
sop(s1+10); //Bishwajeet10
sop(s1+10+20); //Bishwajeet1020
sop(10+20+s1); //30Bishwajeet
sop(10+s1+20); //10Bishwajeet20
sop(s1+20/10); // Bishwajeet2
sop(s1+10-5); //error (Subtract in string is not possible)
sop(String.join(",",s1,s2));  // Bishwajeet, Samal


Rules to be remembered to create Constructors
---------------------------------------------
While defining the constructors you should keep the following points in mind.

A constructor does not have return type.

The name of the constructor is same as the name of the class.

A constructor cannot be abstract, final, static and Synchronized.

You can use the access specifiers public, protected & private with constructors.


StringBuffer (Its default size is 16.) If size get over then result will be (16*2)+2 i.e. (size*2)+2
============
It is a class. The object created through StringBuffer is stored in the heap. 
StringBuffer never adds to the string pool.All methods are synchronized.
Synchronization
===============
synchronization in Java guarantees that no two threads can execute a synchronized method which requires 
the same lock simultaneously or concurrently. And thus,synchronization increases waiting time of thread
and effects performance of the system.
To overcome the problem of slow performance of StringBuffer methods, Java introduced StringBuilder concept
in JDK 1.5 version and creates all the methods of StringBuilder as non-synchronized which increases the
methods performance.
All methods of StringBuffer are same in StringBuilder. The difference is that StringBuffer is synchronized
whereas StringBuilder is non-synchronized i.e. not thread safe.

StringBuffer and StringBuilder are mutable objects in Java. String has concat() method whereas StringBuffer
has append() method.
They provide append(), insert(), delete(), and substring() methods for String manipulation.
StringBuffer sb = new StringBuffer("Bishwajeet"); // This will create a object in a memory location.
sb.append(" java"); //this will append the  with the value and change into the existing object or in same
//memory location.

**Main difference between String  and StringBuffer is, String objects are immutable and StringBuffer
objects are mutable.  // Like notepad , Editors etc.
Que -> When to use String and StringBuffer ?
Ans -> If the data does not change or change one or two times only, use String.
If data is constantly or frequently changing like in calculator, notepad etc. we should use StringBuffer.

**StringBuffer is a class.
public final class StringBuffer extends AbstractStringBuilder implements implements java.io.Serializable,
CharSequence{
    //4 Constructors
    StringBuffer(){}
    StringBuffer(CharSequence seq){}
    StringBuffer(String str){}
    StringBuffer(int capacity){}

    //methods
    public synchronized int length(){...}
    public synchronized int capacity(){...}
    public synchronized StringBuffer append(){...}
    public synchronized StringBuffer insert(){...}
    public synchronized StringBuffer reverse(){...}
    public synchronized StringBuffer delete(){...}
    public synchronized StringBuffer deleteCharAt(){...}
    public synchronized StringBuffer replace(){...}
    etc ...

}

*Default capacity for the StringBuffer is 16.
StringBuffer sb = new StringBuffer("Bishwajeet"); 
We can change the size then add the capacity
StringBuffer sb = new StringBuffer(1000); // 1000 

----------------------------
StringBuffer sb ="Bishwajeet";  // this will throw AN Exception,Exception in thread "main" 
//java.lang.Error: Unresolved compilation problem: Type mismatch: cannot convert from String to StringBuffer

Thus, we need to write use 
StringBuffer buffer = new StringBuffer(); //default size is 16
buf = new StringBuffer("hi"); //default Size + size of String = 18
buffer.append("h1"); // size is 16.
buffer.append("Bishwajeet Samal"); // Now size is 34 . Formula is ((size * 2) +2)
buffer.charAt(3); // h
buffer.delete(2,6); //It will delete from 2nd index and upto (lastindex-1) Ans -> Bijeet Samal
buffer.deleteCharAt(2); //It will delete an element in particular Index
buffer.indexOf("s"); // It will give the index 
buffer.lastIndexOf("s"); // It will give the index of last present element of that element provided 
buffer.insert(3,"zzz"); //It will add zzz in 3rd position.
buffer.replace(start,end,null);
buffer.replace(3,6,"m"); // It will replace the value from starting index upto (lastIndex-1)
buffer.reverse(); // It will reverse the String .
buffer.subSequence(3,6);//It will a give a subSequence 
buffer.subString(3,6);//It will a give a subString 

StringBuffer sb1 = new StringBuffer("bishwajeet");
StringBuffer sb2 = new StringBuffer("bishwajeet");
System.out.println(sb1.equals(sb2));  // false 
//Because StringBuffer class doesn't override equals method of Object class but String class override the
//equals method of Object class. Here sb1 and sb2 are pointing to different objects.

But if, StringBuffer sb2 = sb1.append("h1");
System.out.println(sb1.equals(sb2));  //true because it now points to same object.

Difference between Object equals method and String equals method
------------------------------------------------------------------
The equals() Method of the Object class does not know how to compare Strings, it only knows how to compare 
objects. For comparing strings, a string class will override the equals() Method and compare strings in it.
Object.equals() will compare only references, where String.









StringBuffer is slower and StringBuilder is fast.
StringBuilder(All methods of StringBuffer are same in StringBuilder. The difference is that StringBuffer 
    is synchronized whereas StringBuilder is non-synchronized i.e. not thread safe.)
======================================================================================================
public final class StringBuilder extends AbstractStringBuilder implements implements java.io.Serializable,
CharSequence{
    //4 Constructors
    StringBuilder(){}
    StringBuilder(CharSequence seq){}
    StringBuilder(String str){}
    StringBuilder(int capacity){}

    //methods
    public int length(){...}
    public int capacity(){...}
    public StringBuilder append(){...}
    public StringBuilder insert(){...}
    public StringBuilder reverse(){...}
    public StringBuilder delete(){...}
    public StringBuilder deleteCharAt(){...}
    public StringBuilder replace(){...}
    etc ...

}

Que-> Why char array is preferred over string for storing passwords in Java?
--------------------------------------------------------------------------------
Ans-> String objects are immutable in Java and therefore if a password is stored as plain text it will be
available in memory until Garbage collector clears it, but String objects are stored in String Literal Pool
for re-usability and Garbage collection is not applicable in SCP, which is a security threat.
    With an array, you can explicitly wipe the data after you are done with it. You can overwrite the array
with anything you like, and the password won’t be present anywhere in the system, even before Garbage
collection.

Q->Is array stored in heap or stack?
-------------------------------------
A->the reference types in Java are stored in heap area.
 Since arrays are reference types (we can create them using the new keyword) these are also stored in heap
  area.

We can pass char array in String constructor
for example -
------------
char[] c = {'a','b','c','d'}
String s = new String(c);
sop(s);  // output abcd string will get print

====================================================================================================
Nested Classes in Java
-----------------------
In Java, it is possible to define a class within another class, such classes are known as nested classes.
They enable you to logically group classes that are only used in one place, thus this increases the use 
of encapsulation, and creates more readable and maintainable code.

inner class vs anonymous inner class java
-------------------------------------------
A normal class can implement any number of interfaces but the anonymous inner class can implement only one
interface at a time. A regular class can extend a class and implement any number of interfaces 
simultaneously. But anonymous Inner class can extend a class or can implement an interface but not both
at a time.

For regular/normal class, we can write any number of constructors but we can’t write any constructor 
for anonymous Inner class because the anonymous class does not have any name and while defining constructor 
class name and constructor name must be same.
=====================================================================================================
                                             Generics In Java
                                             ================
Generics was added in Java 5 to provide compile-time type checking and removing risk of ClassCastException that 
was common while working with collection classes. 

Java Generic methods are generic classes enable programmers to specify,with a single method declaration, a set 
of related methods or, with a single class declaration, a set of related types.
Java Genrics is one of the most important features introduced in Java 5.
 -------------------------------------------start---------------------------------------------   
    public class Example{
        public <E> void printArray(E []s){
            traditional loop
            -----------------
            // for(int i=0;i<s.length;i++){
            //     System.out.println(s[i]);
            // }
            forEach
            -------
            for(E val : s){
                System.out.println(val);
            }
        }


        public static void main(String []args){
            Example e1 = new Example();
            String countries[] = new String[]{"India","Pak","Nepal"};
            Integer numbers[] = {12,34,56,77};
            e1.printArray(countries);
            e1.printArray(numbers);
        }
    }

//Output
India
Pak
Nepal
12
34
56
77
---------------------------------------------end-------------------------------------------
Rules 
====
1.All generic method declarations have a type parameter section delimited by angle bracket(< and >) the preceded
method return type.
2.Each type parameter section contains one or more type parameters seperated by commas.
3.The type parameters can be used to declare the return type.

Imp Rule
========
Type parameters can represent only reference types, not primitive types(like int,double and char).

Generics Class
==============
--------------------------------------------start-----------------------------------------------
//Single class to manage all the String , Integer type data for calculation
class MyData<T>{
   // Integer i;
    T i;
    public void add(T i1){
        i=i1;
    }

    public T get(){
        return i;
    }
}

public class Example{
    public static void main(String []args){
        // MyData m = new MyData();
        MyData<Integer> m1 = new MyData<Integer>();
        MyData<String> m1 = new MyData<String>();
        Integer k = new Integer(5);
        m.add(5);
        m.add("Bishwajeet");
        System.out.println("m1"+m1.get()+" m2"+m2.get() );

    }
}

//Output
----------
m1=5 m2=Bishwajeet

----------------------------------end------------------------------------
1. A generic class declaration looks like a non-generic class declaration, except that the class name is followed
by a type parameter section.
2.As with generic methods, the type parameter section of a generic class can have one or more type parameters 
seperated by commas.

Java Generic Type
================
Java Generic Type Naming convention helps us understanding code easily and having a naming convention is one of the best practices of Java programming language. So generics also comes with its own naming conventions. Usually, type parameter names are single, uppercase letters to make it easily distinguishable from java variables. The most commonly used type parameter names are:

E – Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
K – Key (Used in Map)
N – Number
T – Type
V – Value (Used in Map)
S,U,V etc. – 2nd, 3rd, 4th types

Sometimes we don’t want the whole class to be parameterized, in that case, we can create java generics method.
 Since the constructor is a special kind of method, we can use generics type in constructors too.


                                                Stream API
                                                -----------

Collections and Stream
========================
1. If we want to represent a group of individual objects as a single entity, then we should go for the collection.
If we want to process the objects from the collection then we should go for the stream.

If we want the stream then we should use stream() method.

Stream s = c.stream(); // It present in java.util.stream;

1.The addition of the Stream API was one of the major features added to Java 8.
2. A Stream in Java can be defined as a sequence of elements from a source that supports aggregate 
operations on them.

***Source − Stream takes Collections, Arrays, or I/O resources as input source.

***Aggregate Operations => Stream supports aggregate operations like filter, map,
 limit, reduce, find, match, and so on. Pipelining − Most of the stream operations return stream itself so
  that their result can be pipelined.

3. The source here refers to collections or arrays that provide data to a stream.
4.Streams can be created from different element sources, e.g., a collection or an array with the
 help of stream() and of() methods. 

 Generating Streams
 --------------------
With Java 8, Collection interface has two methods to generate a Stream.
stream() − Returns a sequential stream considering collection as its source.
parallelStream() − Returns a parallel Stream considering collection as its source.

For example
----------==========================================
ArrayList<Integer> l = new ArrayList<Integer>();
l.add(0);
l.add(5);
l.add(10);
l.add(15);
l.add(15);
l.add(18);
l.add(2);

System.out.println(l);
List<Integer> l2 = l.stream().filter(i->i%2==0).collect(Collectors.toList());
System.out.println(l2);

Output
======
[0, 5, 10, 15, 18, 2]
[0, 10, 18, 2]
---------============================================

 a) Stream.of(v1, v2, v3….)
----------------------------
We are creating a stream of integers using the Stream.of() method.
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args)
    {
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
        stream.forEach(p -> System.out.println(p));
    }
}

Output
--------
1
2
3
4
5
6
7
8
9
---------------------------------------
b) List.stream()
----------------
we are creating a stream from a List
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Stream<String> stream = list.stream();
        stream.forEach(p -> System.out.println(p));
    }
}

Output
--------
a
b
c
d
-------------------------------------------------

The Stream interfaces
------------------------
The Stream API defines a few interfaces such as Stream, IntStream, LongStream, etc.

The Stream<T> interface is for object elements. For primitives, it defines IntStream, LongStream and DoubleStream interfaces.

if you are dealing with primitives because wrapping primitives to objects and auto-boxing is a costly process.

    Terminal operations
-------------------------
These methods produce some results, e.g., count(), toArray(..), and collect(..)
The streams operations can be further classified as:


For Example
==========
public static void main(String []args){
    ArrayList<Integer> marks = new ArrayList<Integer>();
    marks.add(70);
    marks.add(45);
    marks.add(10);
    marks.add(65);
    marks.add(20);
    marks.add(25);
    System.out.println(marks);
    long noOfFailedStudent = marks.stream().filer(i->i<35).count();
    System.out.println(noOfFailedStudent);
} 

1.filtering
2.slicing
3.mapping
4.matching and finding
5.reduction
6.collect

filter() method
---------------
The Stream interface has a filter() method to filter a stream. This is an intermediate operation.
 Below is the method definition of filter() method.
 Stream filter(Predicate<? super T> predicate)
 Parameter -> A predicate to apply to each element to determine if it should be included.

Return Type -> It returns a stream consisting of the elements of this stream that match the given predicate.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        //Created a list of integers
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(12);
        list.add(23);
        list.add(45);
        list.add(6);

        list.stream()                           // Created a stream from the list
                .filter(num -> num > 10)        //filter operation to get only numbers greater than 10
                .forEach(System.out::println);  // Printing each number in the list after filtering.

        //Again printing the elements of List to show that the original list is not modified.
        System.out.println("Original list is not modified");
        list.stream() 
                .forEach(System.out::println);
    }
}
Output
---------
12
23
45
Original list is not modified
1
12
23
45
6

filter() with custom object
---------------------------
import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        //Created a list of Person object.
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));

        // We are filtering out those persons whose age is more than 18 and less than 60
        list.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 60)
                .forEach(System.out::println);

    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

Output
----------
Person{name='Dave', age=23}
Person{name='Ryan', age=54}


filter() chaining
-----------------
We can also chain the filter method to make the code more readable.


import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));

        list.stream()
                .filter(person -> person.getName() != null ) // Filtering the object where name is not null
                .filter(person -> person.getAge() > 18 ) // Filtering the objects where age is greater than 18
                .filter(person -> person.getAge() < 60) // Filtering the objects where age is less than 60
                .forEach(System.out::println);

    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

Output
---------
Person{name='Dave', age=23}
Person{name='Ryan', age=54}
---------------------------------------------------------
Mapping Operations in Stream
----------------------------
Mapping operations are those operations that transform the elements of a stream and return a new 
stream with transformed elements.
We can use a variety of methods to transform a stream into another stream object. The two most common methods 
used are :- 
1.map()  
2.flatMap()


For Example
===========
ArrayList<Integer> marks = new ArrayList<Integer>();
marks.add(0);
marks.add(5);
marks.add(10);
marks.add(15);
marks.add(15);
marks.add(18);
marks.add(2);

System.out.println(marks);
List<Integer> updatedMarks = marks.stream().map(i->i+5).collect(Collectors.toList());
System.out.println(updatedMarks);

Output
======
[0, 5, 10, 15, 15, 18, 2]
[5, 10, 15, 20, 20, 23, 7]


The map() method takes a lambda expression as its only argument and uses it to change every individual element 
in the stream. 
Its return value is a new stream object containing the changed elements.
<R> Stream<R> map(Function<? super T, ? extends R> mapper)

Input Parameter -> A function to apply to each element.

Return Type -> Returns a stream consisting of the results of applying the given function
 to the elements of the stream.

 Let’s look at a basic example of map().
 In the below example, we have a list of names. We need to print all the names on the list in the upper case.
 -------------
 import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");
        // map() is used to convert each name to upper case.
        // Note: The map() method does not modify the original list.
        list.stream()
                .map(name -> name.toUpperCase()) //map() takes an input of Function<T, R> type.
                .forEach(System.out::println);   // forEach() takes an input of Consumer type.

    }
}
---------------

Understanding mapToInt()#
=-----------------------
Given a list of words, we need to print the length of each word.
To solve this problem, we can use a map(), which takes s -> s.length() lambda expression as input. 
The input is a string and output is an integer. If we use map(s -> s.length()) , then it will return 
a stream of integers.

 If we use the mapToInt() method instead of map(), it will return IntStream instead of Stream.

 So, if we are sure that our function is going to return a primitive, instead of using map() use 
 mapToInt(), mapToLong() or mapToDouble().


 import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");

        list.stream()
                .mapToInt(name -> name.length())
                .forEach(System.out::println);

    }
}

Output
[-------]
4
3
4
4
3
----------------------------------------------------------------------------
Understanding flatMap()#
-------------------------
Stream flatMap() method is used to flatten a stream of collections to a stream of elements combined
 from all collections.

 Basically, flatMap() is used to do following operation:

Stream<String[]> -> flatMap -> Stream<String>

Stream<Set<String>> -> flatMap -> Stream<String>

Stream<List<String>> -> flatMap -> Stream<String>

Now, the question is why do we need to flatten our stream? The reason is that intermediate methods such 
as filter() and distinct() do not work on streams of Collections.

These methods only work on streams of primitives or objects. So, we need to flatten our stream before using
 these intermediate functions.

Let’s see an example of flatMap(). In the below code we have a List<List<String>>.

We need to filter the strings and then print the filtered strings. The below code, will not print anything
 because we are not flattening our stream.

 import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));

        Stream<List<String>> stream1 = list.stream();
        // filter() method do not work on stream of collections
        Stream<List<String>> stream2 = stream1.filter(x -> "a".equals(x.toString()));
        //This will not print anything
        stream2.forEach(System.out::println);
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));
        //Created a stream from the list.
        Stream<List<String>> stream1 = list.stream();
        // Flattened the stream.
        Stream<String> stream2 = stream1.flatMap(s -> s.stream());
        //Applied filter on flattened stream.
        Stream<String> stream3 = stream2.filter(x -> "a".equals(x));
        
        stream3.forEach(System.out::println);
    }
}

Output
-------
a

The above code can be written in a concise format as shown below. It was first written as an individual 
operation just for explanation.

list.stream()
                .flatMap(s -> s.stream())
                .filter(x -> "a".equals(x))
                .forEach(System.out::println);

                Similar to the map() method, flatMap() also has a primitive variation. These are:

flatMapToInt
flatMapToLong
flatMapToDouble
----------------------------------------------------


Optional in Java 8: Part 1
---------------------------
In this lesson, we will look at the newly introduced Optional class. We will also look at different ways 
of creating an Optional.

What is an Optional?#
---------------------
Java 8 has introduced a new class Optional<T> in the java.util package.

The Optional<T> is a wrapper class that stores an object of type T. The object may or may not be present 
in the optional.

According to Oracle, “Java 8 Optional works as a container type for the value which is probably absent or null.
 Java Optional is a final class present in the java.util package.”

Let us look at how things worked before optional was introduced. In the below example, we have a getEmployee() method which gets the employee object from a Map. After fetching the employee object, we will print its details.

import java.util.HashMap;
import java.util.Map;

public class StreamDemo {

    Map<Integer, Employee> empMap = new HashMap<>();

    public Employee getEmployee(Integer employeeId) {
        return empMap.get(employeeId);
    }

    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();

        //Fetching the employee with id 123. But since map is empty this will be null.
        Employee emp = demo.getEmployee(123);

        // This will throw Null Pointer Exception because emp is null
        System.out.println(emp.getName()); 
    }
}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}


Output
------------
Exception in thread "main" java.lang.NullPointerException
    at StreamDemo.main(StreamDemo.java:19)

    As you can see, every time we use an object there is a chance of that dreaded NullPointerException. To 
    overcome this we need to add null checks, which result in a lot of boilerplate code.
     Using Optional makes the code more readable and less prone to error.

The below example shows how the same program can be written using an Optional<T>. At line 11, instead of directly 
returning the Employee object, we are wrapping it into an Optional.

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StreamDemo {

    Map<Integer, Employee> empMap = new HashMap<>();

    public Optional<Employee> getEmployee(Integer employeeId) {
        // Before returning the employee object we are wrapping it into an Optional
        return Optional.ofNullable(empMap.get(employeeId));
    }

    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        Optional<Employee> emp = demo.getEmployee(123);
        // Before getting a value from Optional we check if the value is present through isPresent() method.
        if(emp.isPresent()){
            System.out.println(emp.get().getName());  // We use get() method to get the value from Optional.
        } else{
            System.out.println("No employee returned.");
        }
    }
}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

Output
----------
No employee returned.

After looking at the above code, you might be wondering what the use of Optional<T> is if we need to check 
whether the value in the optional is null or not, using the isPresent() method.
 Why can’t we just use the method directly and do a null check instead of wrapping it into an Optional<T>?

The benefit of Optional<T> is not that we are saved from applying a null check. 
The benefit is that Optional<T> class provides us lots of utility methods that we can apply to our wrapped objects.

Different ways of creating an Optional#

--------------------------------------------
There are three different ways of creating an Optional object.
1) Using empty() method.#
We can create an empty optional using the empty() method. The optional created through empty() will contain 
a null value.
Optional < Person > person = Optional.empty();

2.Using of() method
-------------------
We can create an Optional object that has a non-null value using of() method. If we create an 
Optional using the of() method and the value is null, then it will throw a Null Pointer Exception.

To create an Optional using the of() method, when you are really sure that the value is not null, do the following.
Person person = new Person();
Optional<Person> optional = Optional.of(person);

3) Using ofNullable() method
------------------------------
If while creating the Optional, you are not sure if the value is null or not null, then use the ofNullable() method. 
If a non-null value is passed in Optional.ofNullable(), then 
it will return the Optional, containing the specified value. Otherwise, it will return an empty Optional.
Person person = new Person();
Optional<Person> optional = Optional.ofNullable(person);

This lesson provided a basic introduction to what an Optional is. In the next lesson, we 
will look at all the methods present in the Optional class.

Optional in Java 8: Part 2
----------------------------

In the previous lesson, we looked at the Optional<T> class. You learned what an Optional is and how to create it.

In this lesson, we will look at all the operations that we can perform using an Optional.

Below is the list of methods available in the Optional class.
1) isPresent()
---------------
The isPresent() method is used to check if the optional contains a value or if it is null.

The method isPresent() returns the value true in case the id of the Optional objects contains a
 non-null value. Otherwise, it returns a false value.
 Optional<Person> optional = getPerson();
if(optional.isPresent()){
        System.out.println(optional.get.getName())
}

2) ifPresent(Consumer<? super T> consumer)
--------------------------------------------
Here is the syntax of ifPresent() method.
public void ifPresent(Consumer<? super T> consumer)

It takes in a Consumer as a parameter and returns nothing. When ifPresent() is called, if a value is present, the
 specified consumer is invoked with the value. Otherwise, nothing happens.

 import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StreamDemo {

    Map<Integer, Employee> empMap = new HashMap<>();

    public void populateEmployee() {
        empMap.put(123, new Employee("Alex", 23, 12000));
    }

    public Optional<Employee> getEmployee(Integer employeeId) {
        // Before returning the employee object we are wrapping it into an Optional
        return Optional.ofNullable(empMap.get(employeeId));
    }

    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        demo.populateEmployee();
        Optional<Employee> emp = demo.getEmployee(123);
        emp.ifPresent(System.out::println);
    }
}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

Output
-------
Employee{name='Alex', age=23, salary=12000}

3) get()
-------
The get() method returns a value if it is present in this Optional. Otherwise, it throws NoSuchElementException.

It is risky to use this method without checking if the value is present or not using isPresent() method.

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null);
        // This will throw exception because optional contains a null value.
        System.out.println(optional.get());
    }
}

Output
------
Exception in thread "main" java.util.NoSuchElementException: No value present
    at java.util.Optional.get(Optional.java:135)
    at OptionalDemo.main(OptionalDemo.java:11)

4) orElse(T other)
------------------
This method returns the value present in the optional. If no value is present, then a default value provided 
as a parameter is returned.
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null);
        // This will return the default value.
        System.out.println(optional.orElse("default string"));
    }
}

Output
-------
default string

5) orElseGet(Supplier<? extends T> other)
------------------------------------------
This method returns the value present in the optional. If no value is present, then the value calculated from 
the supplier provided as a parameter is returned.

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {

    public static String getDefaultValue(){
        return "default";
    }

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null);
        // This will return the default value.
        System.out.println(optional.orElseGet(OptionalDemo::getDefaultValue));
    }
}

Output
---------
default

6) orElseThrow(Supplier<? extends T> other)
--------------------------------------------
This method returns the value present in the optional. If no value is present, then it throws the exception 
created by the provided supplier.

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null);
        // This will throw exception
        try {
            System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

Output
-------
java.lang.Exception: Resource not found.
    at OptionalDemo.lambda$main$0(OptionalDemo.java:10)
    at java.util.Optional.orElseThrow(Optional.java:290)
    at OptionalDemo.main(OptionalDemo.java:10)

7) Optional<T> filter(Predicate<? super T> predicate)
------------------------------------------------------
The filter() method is used to check if the value in our optional matches a particular condition. If yes, then the
optional with the value is returned. Otherwise, an empty optional is returned.

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable("orange");
        // Since the filter condition is matched, this will return the optional.
        System.out.println(optional.filter(str -> str.equals("orange")));

        // Since the filter condition is not matched, this will return empty optional.
        System.out.println(optional.filter(str -> str.equals("apple")));

    }
}
Output
-------
Optional[orange]
Optional.empty


8) map(Function<? super T, ? extends U> mapper)
------------------------------------------------
As per Java docs, “if a value is present, apply the provided mapping function to it, and if the result is 
non-null, return an Optional describing the result. Otherwise, return an empty Optional.”

import java.util.*;

public class StreamDemo {

    public static void main(String[] args) {

        // Creating an Optional of Employee object.
        Optional<Employee> optional = Optional.of(new Employee("Adam", 54, 20000));

        optional
                .map(emp -> emp.getSalary()) // Fetching the salary from employee object.
                .filter(sal -> sal > 10000) // Checking if the salary is greater than 10000.
                .ifPresent(System.out::println);
    }
}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

Output
-------
20000

9) flatMap(Function<? super T, Optional<U>> mapper)
--------------------------------------------------
Similar to the map() method, we also have the flatMap() method as an alternative for transforming values.

The difference is that the map transforms values only when they are unwrapped, whereas flatMap takes a wrapped 
value and unwraps it before transforming it.

Let’s take the same example that we discussed while looking at map(). There is a slight modification though.
 The getSalary() method will return Optional<Address>, so the return type of optional.map(emp -> emp.getSalary()) 
 operation will be Optional<Optional<Integer>> .

 Optional<Optional<Integer>> op1 = optional.map(emp -> emp.getSalary());

 If we don’t need a nested Optional, then we can use a flatMap().

 Optional<Integer> op1 = optional.flatMap(emp -> emp.getSalary());

 import java.util.*;

public class OptionalDemo {

    public static void main(String[] args) {

        // Creating an Optional of Employee object.
        Optional<Employee> optional = Optional.of(new Employee("Adam", 54, 20000));
        optional.flatMap(emp -> emp.getSalary())
                .filter(sal -> sal > 10000)
                .ifPresent(System.out::println);
    }
}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Optional<Integer> getSalary() {
        return Optional.of(salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

Output
-------
20000
[-===========================================================-]
Collectors: Collection Operations.
[------------------------------------]
Collectors
============
Collectors is a final class that extends the Object class. It provides the most common mutable reduction 
operations that could be required by application developers as individual static methods.

Some of the important reduction operations already implemented in the Collectors class are listed below:

toList()--Collects stream elements in a List.

toSet()--Collects stream elements in a Set.
toMap()--Returns a Collector that accumulates elements into a Map whose keys and values are the result of
 applying the provided mapping functions to the input elements.

 collectingAndThen()--Collects stream elements and then transforms them using a Function

 summingDouble(), summingLong(), summingInt()---Sums-up stream elements after mapping them to a Double/Long/Integer 
 value using specific type Function

 reducing()---Reduces elements of stream based on the BinaryOperator function provided

 partitioningBy()---
partitioningBy()    Partitions stream elements into a Map based on the Predicate provided

counting()--- Counts the number of stream elements

groupingBy()---Produces Map of elements grouped by grouping criteria provided

mapping()---
Applyies a mapping operation to all stream elements being collected

joining()---For concatenation of stream elements into a single String

minBy()/maxBy()---Finds the minimum/maximum of all stream elements based on the Comparator provided

1. Collectors.toList()#
-----------------------
It returns a Collector that collects all of the input elements into a new List.

Suppose we need to get a list of employee names. We can use the toList() method.
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String args[]){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex" , 23, 23000, "USA"));
        employeeList.add(new Employee("Ben" , 63, 25000, "India"));
        employeeList.add(new Employee("Dave" , 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi" , 43, 67000, "China"));
        employeeList.add(new Employee("Ryan" , 53, 54000, "Libya"));
        
        List<String> empName = employeeList.stream()
                .map(emp -> emp.getName())
                .collect(Collectors.toList());
        
        System.out.println(empName);
    }
}

class Employee {
    String name;
    int age;
    int salary;
    String country;

    Employee(String name, int age, int salary, String country) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

Output
------
[Alex, Ben, Dave, Jodi, Ryan]

2. Collectors.toSet()
----------------------
It returns a Collector that collects all input elements into a new Set.

Suppose we have a list of employees, and we need to get a set of countries to which our 
employees belong then we can use toSet() method.

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String args[]){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex" , 23, 23000, "USA"));
        employeeList.add(new Employee("Ben" , 63, 25000, "India"));
        employeeList.add(new Employee("Dave" , 34, 56000, "Bhutan"));
        employeeList.add(new Employee("Jodi" , 43, 67000, "China"));
        employeeList.add(new Employee("Ryan" , 53, 54000, "Libya"));
        
        Set<String> empName = employeeList.stream()
                .map(emp -> emp.getCountry())
                .collect(Collectors.toSet());
        
        System.out.println(empName);
    }
}

class Employee {
    String name;
    int age;
    int salary;
    String country;

    Employee(String name, int age, int salary, String country) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

Output
------
[USA, Bhutan, China, Libya, India]

3. Collectors.toCollection(Supplier<C> collectionFactory)
=---=====================================================
This method returns a Collector that collects all of the input elements into a new Collection. 
This method takes a Supplier as a parameter. The Supplier supplies the collection of our choice.

Below is an example of collecting the first three employees in a LinkedList.

Note: In the below example, at line 18 we provid the supplier to toCollection() method as LinkedList::new. We can also write it as () -> new LinkedList<>(); but we 
should always prefer method references as they are shorter and more readable.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String args[]) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Alex", 23, 23000));
        employeeList.add(new Employee("Ben", 63, 25000));
        employeeList.add(new Employee("Dave", 34, 56000));
        employeeList.add(new Employee("Jodi", 43, 67000));
        employeeList.add(new Employee("Ryan", 53, 54000));

        LinkedList<String> empName = employeeList.stream()
                .map(emp -> emp.getName())
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(empName);
    }
}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name) {
        this.name = name;
    }

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

Output
------
[Alex, Ben, Dave, Jodi, Ryan]

4. Collectors.toMap()
---------------------
toMap() is used to collect stream elements into a Map instance. This method takes two parameters

keyMapper - used for extracting a Map key from a stream element

valueMapper - used for extracting a value associated with a given key

Suppose we have a list of strings, and we need to create a map where the key is the string and 
the value is the length of the string. In this case, we can use the toMap() method.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("far");
        list.add("away");
        list.add("again");

        Map<String,Integer> nameMap = list.stream()
                .collect(Collectors.toMap(s -> s , s -> s.length()));

        System.out.println(nameMap);
    }
}

Output
-------
{away=4, far=3, again=5, done=4}

The problem with the above example is that, if the list has duplicate elements, toMap() will throw an exception.

To solve this problem, there is an overloaded version of toMap() that takes an additional BinaryOperator as a 
parameter. This is used to decide which element should be considered in case of duplicates.

In the below example, we have provided a BinaryOperator that will take the first element in case a duplicate 
element is found. Since the length of both strings will be the same it doesn’t matter which element we take.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("far");
        list.add("away");
        list.add("done");

        Map<String,Integer> nameMap = list.stream()
                .collect(Collectors.toMap(s -> s , s -> s.length(), (s1,s2) -> s1));

        System.out.println(nameMap);
    }
}
Output
-------
{away=4, far=3, done=4}



There is one more overloaded version of toMap() method, which allows us to provide the implementation of Map
 that you want to use.

In the below example, we will convert our stream to a HashMap.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("far");
        list.add("away");
        list.add("done");

        Map<String,Integer> nameMap = list.stream()
                .collect(Collectors.toMap(s -> s , s -> s.length(), (s1,s2) -> s1, HashMap::new));

        System.out.println(nameMap);
    }
}
ETC...


                                            JAVA Collections
                                            -----------------
 Introduction to Collections
 ---------------------------
 Introduction
 ------------
 A collection is an object that groups multiple elements into a single unit. The Java Collections Framework 
 is a unified architecture for representing and manipulating collections. It contains the interfaces, their 
 implementations, and algorithms to process the data stored in a collection.    

 In Java, we have a Collection interface extended by other interfaces such as List, Set, and Queue. 
 Apart from the Collection interface, we have a Map interface. The Map does not implement the Collection 
 interface because it stores key-value pairs, and the classes that come under the Collection 
 interface store only values.                                       

 Difference between Collection and Collections
 ---------------------------------------------
The differences between a Collection and Collections are given below.

A Collection is an interface, whereas Collections is a class.
A Collection interface provides the standard functionality of a data structure to List, Set, and Queue. 
However, the Collections class provides the utility
 methods that can be used to search, sort, and synchronize collection elements.

 ArrayList: Introduction
 -----------------------
 ArrayList is the most widely used implementation of the List interface. 
 Some of the slient features of an ArrayList are:

Elements are stored in the order of insertion.
It allows the storage of duplicate elements.
ArrayList also supports null elements.

Internal implementation of ArrayList
------------------------------------
An ArrayList stores data in a resizable array. Before Java 8, when an ArrayList was created, an array of default 
size ten was created internally. 
Now, when an ArrayList is created, an array of size zero is created. Only when the first element is inserted does 
the array size change to ten. This is called lazy initialization, and it saves a lot of memory.

Before adding an element in ArrayList, its capacity is checked. If the internal array is full, then a new array of
 size \lgroup n+\frac{n}{2}+1\rgroup
⟮(n+n/2+1) is created (e.g., if the capacity is ten, then a new array of size 16 will be created). 
 The elements from the old array will be copied to the new array. This increases the capacity of an
  ArrayList, which is a time-consuming process.

  Time complexities for ArrayList operations
  ------------------------------------------
  Adding an element
  -------------------
Since an array backs an ArrayList, the addition of an element takes O(1) time in most of the cases. 
It will take more time if the ArrayList is full and needs to be resized. In that scenario, a new array will 
be created, and elements will be copied from the old array to the new array.

Removing an element
--------------------
The remove operation has O(n)

 complexity in the worst case and O(1) in the best case. There are two overloaded versions of 
 the remove() method in ArrayList:

1.The first one takes the index of the element that needs to be removed as input. The element can be found in O(1)

 time using the index, but when the element is removed, the other elements need to be moved to the left. 
 So, if the last element is removed the complexity will be O(1) otherwise, O(n).
In the second case, the remove() method takes the element that needs to be removed as input. 
The array is scanned from the beginning to find the first occurrence of that element, and then it is removed. 
This has a complexity of O(n).

Fetching an element
-------------------
Fetching an element from an array using an index is O(1) constant-time operation. 
So, fetching an element from an ArrayList takes constant time.

Creating an ArrayList
---------------------
There are three ways to create an ArrayList:

Using the no-arg constructor
----------------------------
The default constructor does not take any argument and creates a List of size zero. 
Below is the syntax to create ArrayList using the default constructor.
List list = new ArrayList();

Using the constructor that takes initial capacity
--------------------------------------------------
We can also provide an initial capacity while creating an ArrayList. The benefit is that if we know
 that our ArrayList will contain a minimum of 100 elements, then we can 
create the ArrayList with a size of 100. Thus, our ArrayList will not require frequent resizing.

List list = new ArrayList(50);

Using existing Collection
-------------------------
An ArrayList can also be created using an existing Collection. The newly created ArrayList will contain all the 
elements in the same order in the original collection.

List list = new ArrayList(oldList);

ArrayList: Inserting and Retrieving Elements
----------------------------------------------
Inserting into an ArrayList
---------------------------
There are four ways to add elements in an ArrayList:
Inserting a single element at the end
---------------------------------------
To add a single element at the end of the List, the add(E e) method can be used, where E refers to any 
type of object. This method will check if there is sufficient capacity in the ArrayList. 
If the ArrayList is full, then it will resize it and insert the element at the end.

Inserting a single element at a given index
--------------------------------------------
We can also insert an element at a particular index using the add(int index, E element) method. 
This method will insert the element at the given index and will shift the element currently at that 
position (if any) and any subsequent elements to the right. This method will throw IndexOutOfBoundsException
 if the provided index is less than zero or greater than the size of ArrayList.

Inserting multiple elements from another Collection
---------------------------------------------------
If we have a Collection and we need to add all its elements to another ArrayList, then the 
addAll(Collection c) method can be used.
 This method will add all the elements at the end of the ArrayList.
list.addAll(anotherList).

Inserting multiple elements from another Collection at a particular index
-------------------------------------------------------------------------
If we have a Collection and need to add all its elements to another ArrayList at a particular index, then 
the addAll(int index, Collection c) method can be used. This method inserts all of the specified collection 
elements into this list, starting at the specified position.
It also shifts the element currently at that position (if any) and any subsequent elements to the right.

list.addAll(3, anotherList)

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        
        list.add(4);  // This will add 4 at the end of the List.
        System.out.println(list);
        
        list.add(1, 50); // This will add 50 at index 1. All the other elements will be shifted to right.
        System.out.println(list);

        List newList = new ArrayList(); // Creating a new List which will be added to original list.
        newList.add(150);
        newList.add(160);

        list.addAll(newList); // This will add all the elements present in newList to list.
        System.out.println(list);
    }
}
Output
-------
[1, 2, 3]
[1, 2, 3, 4]
[1, 50, 2, 3, 4]
[1, 50, 2, 3, 4, 150, 160]

Note: ArrayListDemo.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.

In the above example, you must have encountered a warning message stating, “ArrayListDemo.java uses 
unchecked or unsafe operations”. The reason for this is that our ArrayList is of raw type, meaning that while 
creating the ArrayList, we did not define what type of elements this ArrayList can hold. 
If we had defined the type of elements it can hold when we created the ArrayList, then it is called a parameterized
 type. It can be done as shown below.

 List<String> list = new ArrayList<>();

So, we need to provide the type of object within <> while creating the list.
Creating a parameterized Collection is very important. Without it, there can be serious errors, which we 
will see in the next lesson when we discuss ArrayList iteration.

Fetching elements from an ArrayList
-----------------------------------
To fetch an element from ArrayList, we can use the get(int index) method. 
This method takes an index as input and returns the element at that index. 
The index provided should be equal or greater than zero and should be less than ArrayList size.

We can fetch the size of the ArrayList using the size() method.

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        
        System.out.println("The element at index two is " + list.get(1));

        System.out.println("The size of the List is  " + list.size());
        
    }
}
Output
------
[1, 2, 3]
The element at index two is 2
The size of the List is  3

ArrayList: Few More Operations
------------------------------
Removing an element from an ArrayList
-------------------------------------
Elements can be removed from an ArrayList in the following ways.

Removing an element at a particular index
-----------------------------------------
We can use the remove(int index) method to remove an element at a particular index. 
The index should be less than the size of ArrayList, otherwise, IndexOutOfBoundsException is thrown.

Removing a particular element from the ArrayList
------------------------------------------------
We can also specify the element that we want to remove using the remove(Object o) method, and the 
first occurrence of that element will be removed.

Removing all the elements within a range
----------------------------------------
Let’s suppose we need to remove all the elements from index 5 to 9.
 This can be done using the removeRange(int fromIndex, int toIndex) method.
  This method will remove, from this list, all of the elements whose index is between 
  fromIndex, inclusive, and toIndex, exclusive. Please note that this method is not defined in the List class.

  Removing all the elements within a given Collection
  ----------------------------------------------------
We can use the removeAll(Collection<?> c) method to remove, from the given list, all of the elements that are
contained in the specified collection.
So, it can be used only when the reference type is also ArrayList and not List.

Removing all the elements from the ArrayList
---------------------------------------------
We can use the clear() method to remove all the elements from the ArrayList.
We saw that remove(int index) removes a method at the given index and remove(Object o) removes the 
given object from the ArrayList. Suppose we have an ArrayList that contains five elements i.e [13, 21, 43, 2, 9]. 
Now, if we do list.remove(2), then which overloaded method will be called. Will remove(int index) be called or 
remove(Object o) be called? remove(int index) will be called because we are passing a primitive to remove method. 
If we want to delete element 2, we should call 
remove(new Integer(2)) because elements are stored in an ArrayList as objects and not primitives.

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        
        System.out.println(list);
        
        list.remove(1);  // This will remove the element at index 1 i.e 20.
        System.out.println(list);
        
        list.remove(new Integer(30)); // This will remove 30 from the list
        System.out.println(list);

        list.clear(); //This will remove all the elements from the list.
        System.out.println(list);       
    }
}

Output
--------
[10, 20, 30, 40, 50, 60, 70, 80]
[10, 30, 40, 50, 60, 70, 80]
[10, 40, 50, 60, 70, 80]
[]

Replacing all the elements of the ArrayList
-------------------------------------------
A new method, replaceAll(UnaryOperator<E> operator), was added in Java 8. This method takes a single 
UnaryOperator type argument. The UnaryOperator interface is a functional interface that has a single abstract 
method, apply(), that returns a result of the same object type as the operand.

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");

        list.replaceAll((element) -> element.toUpperCase());

        System.out.println(list);
    }
}
Output
1------
[APPLE, BANANA]

Additional operations on ArrayList
----------------------------------
Updating an element in ArrayList
--------------------------------
To update an element in ArrayList, the set(int index, E e) method can be used. 
This method takes the index, which needs to be updated and a new value.

Checking if an element is present in the ArrayList
--------------------------------------------------
To check if an element is present in the list, we can use the contains(Object o) method. 
This method returns true if the 
element is present in the list; otherwise, it returns false.
Let’s say we have an ArrayList that contains String objects; we need to make all the elements in this list
 uppercase. In this case, we can use the replaceAll() method and provide it with a lambda expression that 
 converts each element into uppercase.

 If we need the index of the first occurrence of the element, then the indexOf(Object o) method can be used. 
 And if we need the last occurrence of the element, the lastIndexOf(Object o) can be used.

 import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

        list.set(1, 100);

    System.out.println(list);

        if (list.contains(30)) {
            System.out.println("List contains 30");
        }

        System.out.println("Index of first occurence of 10 is " + list.indexOf(10));
        System.out.println("Index of last occurence of 10 is " + list.lastIndexOf(10));
    }
}

Output
-------
[10, 100, 30, 40, 10]
List contains 30
Index of first occurence of 10 is 0
Index of last occurence of 10 is 4

ArrayList: Iteration
--------------------
Lets discuss how an ArrayList can be iterated.
Iterating an ArrayList
-----------------------
Below are the different methods to iterate over an ArrayList.
Using for loop
--------------
An ArrayList can be iterated easily using a simple for loop or an enhanced for loop as shown below.
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List <Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
         
        for (int i = 0; i < list.size(); i++) { //Simple for loop
            System.out.println(list.get(i));
        }

        for (Integer i : list) {   //Enhanced for loop
            System.out.println(i);
        }
    }
}

Output
------
10
20
30
40
10
20
30
40

Using Iterator
--------------
The iterator() method in ArrayList returns an Iterator type object. The Iterator interface declares the 
below methods that help with iterating an ArrayList.

hasNext() — This method returns true if there are more elements in the list; otherwise, it returns false.

next() — This method returns the next element in the list. Before calling next(), we should always 
call hasNext() to verify that there is an element; otherwise, NoSuchElementException will be thrown.

remove() — This method removes the last element returned by the iterator. It can be called only once per call to 
the next().

forEachRemaining(Consumer<? super E> action) — This method was introduced in Java 8. It performs the given 
action for each remaining element until all elements have been processed or the action throws an exception.
 This method’s benefit is that we do not need to check if there is a next element every time.

To understand the working of the forEachRemaining() method, you should be familiar with basic concepts of 
functional programming that were introduced in Java 8.

Below is an example of iterating an ArrayList using the iterator.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

        Iterator<Integer> itr = list.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Iterating using forEachRemaining() method
        System.out.println("Iterating using forEachRemaining() method");
        Iterator<Integer> newItr = list.iterator();
        newItr.forEachRemaining(element -> System.out.println(element));
    }
}

Output
------
10
20
30
40
10
Iterating using forEachRemaining() method
10
20
30

If we try to directly remove an element while iterating an ArrayList using an iterator is created, then
 ConcurrentModificationException will also be thrown. We should always use the remove() method in the iterator 
 to remove an element from the ArrayList.

The below program will fail because we are trying to delete the element from the list directly.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListPractice {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            int next = itr.next();
            
            if (next == 30) {
                list.remove(new Integer(30));
            }
        }
    }
}

Output
-------
Exception in thread "main" java.util.ConcurrentModificationException
    at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
    at java.util.ArrayList$Itr.next(ArrayList.java:859)
    at ArrayListPractice.main(ArrayListPractice.java:18)

The code shown below is the correct way to delete an element from the list.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);

        Iterator<Integer> itr = list.iterator();

        while(itr.hasNext()) {
            int next = itr.next();
            if(next == 30) {
                itr.remove();
            }
        }
        System.out.println(list);
    }
}

Output
------
[10, 20, 40, 10]

If an element is added to the ArrayList after the iterator is created then also
 ConcurrentModificationException will be thrown.

 import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(45);

        Iterator<Integer> itr = list.iterator();
        list.add(54);

        while(itr.hasNext()) {
            System.out.println(itr.next()); 
        }
    }
}

Output
-------
Exception in thread "main" java.util.ConcurrentModificationException
    at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
    at java.util.ArrayList$Itr.next(ArrayList.java:859)
    at ArrayListDemo.main(ArrayListDemo.java:17)


ArrayList: Iteration using ListIterator
---------------------------------------
ListIterator
------------
The Iterator provides very limited capabilities as we can iterate only in the forward direction and we can’t update or insert an element to the list while iterating. To overcome these problems, we can use ListIterator. The listIterator() method returns an object of type ListIterator which can then be used to iterate the ArrayList.

Below are the methods that are available in the ListIterator interface.

hasNext() — This method is used to check if there is a next element in the list when the list is iterated in the
 forward direction.

next() — This method returns the next element in the list and advances the cursor position.

hasPrevious() — This method is used to check if there is a next element in the list when the list is iterated in
 the backward direction.

previous() — This method returns the previous element in the list and moves the cursor position backward.

nextIndex() — This method returns the index of the element that would be returned by a subsequent call to next().
 It returns the list size if the list iterator is at the end of the list.

previousIndex() — This method returns the index of the element that would be returned by a subsequent call to 
previous(). It returns -1 if the list iterator is at the beginning of the list.

remove() — This method removes the last element that was returned by next() or previous() from the list. 
This call can only be made once per call to next() or previous(). It can be made only if add() has not been called 
after the last call to next() or previous().

set(E e) — This method replaces the last element returned by next() or previous() with the specified element. 
This call can be made only if neither remove() nor add() have been called after the last call to next() or 
previous().

add(E e) — This method inserts the specified element into the list. The element is inserted immediately before the
element that would be returned by next(), if any, and after the element that would be returned by previous(), if 
any.

The below example shows ListIterator working.

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Getting ListIterator
        ListIterator<Integer> listIterator = list.listIterator();

        // Traversing elements
        System.out.println("Forward Direction Iteration:");
        while (listIterator.hasNext()) {
            System.out.println("Next element is " + listIterator.next() + 
            " and next index is " + listIterator.nextIndex());
            
        }

        // Traversing elements, the iterator is at the end at this point
        System.out.println("Backward Direction Iteration:");
        while (listIterator.hasPrevious()) {
            System.out.println("Previous element is " + listIterator.previous() + 
            " and previous index is " + listIterator.previousIndex());
        }
    }
}

Why raw type Collection should be avoided
-------------------------------------------
Whenever we create a Collection, we should provide the type of object it can hold.
This is called parameterized type Collection. A raw type Collection does not have any type of safety, and an object
of any type can be inserted into it. In the below example, we have created a raw type ArrayList. 
Elements of Integer and String type are added to it. This code will compile but will fail at run-time with 
ClassCastException.

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void doSomeWork(List list) {
        list.add("India");
    }

    public static void main(String args[]) {
        List list = new ArrayList();
        list.add(10);
        list.add(20);
        doSomeWork(list);

        Integer i = (Integer) list.get(2);
    }
}

Output
------
Note: ArrayListDemo.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
    at ArrayListDemo.main(ArrayListDemo.java:16) 
This would have been avoided if we had used parameterized type.

ArrayList: Iteration using ListIterator
----------------------------------------
Lets discuss how to iterate an ArrayList using a ListIterator.
ListIterator
-------------
The Iterator provides very limited capabilities as we can iterate only in the forward direction and we can’t 
update or insert an element to the list while iterating. To overcome these problems, we can use ListIterator. 
The listIterator() method returns an object of type ListIterator which can then be used to iterate the ArrayList.

Below are the methods that are available in the ListIterator interface.

hasNext() — This method is used to check if there is a next element in the list when the list is iterated in the 
forward direction.

next() — This method returns the next element in the list and advances the cursor position.

hasPrevious() — This method is used to check if there is a next element in the list when the list is iterated in 
the backward direction.

previous() — This method returns the previous element in the list and moves the cursor position backward.

nextIndex() — This method returns the index of the element that would be returned by a subsequent call to next(). 
It returns the list size if the list iterator is at the end of the list.

previousIndex() — This method returns the index of the element that would be returned by a subsequent call to 
previous(). It returns -1 if the list iterator is at the beginning of the list.

remove() — This method removes the last element that was returned by next() or previous() from the list. 
This call can only be made once per call to next() or previous(). It can be made only if add() has not been called
after the last call to next() or previous().

set(E e) — This method replaces the last element returned by next() or previous() with the specified element. 
This call can be made only if neither remove() nor add() have been called after the last call to next() or 
previous().

add(E e) — This method inserts the specified element into the list. The element is inserted immediately before 
the element that would be returned by next(), if any, and after the element that would be returned by 
previous(), if any.

The below example shows ListIterator working.

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Getting ListIterator
        ListIterator<Integer> listIterator = list.listIterator();

        // Traversing elements
        System.out.println("Forward Direction Iteration:");
        while (listIterator.hasNext()) {
            System.out.println("Next element is " + listIterator.next() + 
            " and next index is " + listIterator.nextIndex());
            
        }

        // Traversing elements, the iterator is at the end at this point
        System.out.println("Backward Direction Iteration:");
        while (listIterator.hasPrevious()) {
            System.out.println("Previous element is " + listIterator.previous() + 
            " and previous index is " + listIterator.previousIndex());
        }
    }
}

Output
-------
Forward Direction Iteration:
Next element is 10 and next index is 1
Next element is 20 and next index is 2
Next element is 30 and next index is 3
Next element is 40 and next index is 4
Backward Direction Iteration:
Previous element is 40 and previous index is 2
Previous element is 30 and previous index is 1
Previous element is 20 and previous index is 0

Why raw type Collection should be avoided
-----------------------------------------
Whenever we create a Collection, we should provide the type of object it can hold. 
This is called parameterized type Collection. A raw type Collection does not have any type of safety, and an
 object of any type can be inserted into it. In the below example, we have created a raw type ArrayList. 
 Elements of Integer and String type are added to it. This code will compile but will fail at run-time with 
 ClassCastException. This would have been avoided if we had used parameterized type.

 import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void doSomeWork(List list) {
        list.add("India");
    }

    public static void main(String args[]) {
        List list = new ArrayList();
        list.add(10);
        list.add(20);
        doSomeWork(list);

        Integer i = (Integer) list.get(2);
    }
}

Output
-------
Note: ArrayListDemo.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
    at ArrayListDemo.main(ArrayListDemo.java:16)

ArrayList Sorting
------------------
Sorting an ArrayList in ascending order
---------------------------------------
The Collections class contains a sort(List<T> list) method, which is used to sort an ArrayList. 
This method takes an ArrayList as input and sorts it in ascending order.

In the sort(List<T> list) method, T represents the type of object that is stored in the ArrayList.
The Collections.sort(List<T> t) method takes an ArrayList of type T objects as the input.
It is a must that T should implement the Comparable interface; otherwise, the code will not compile.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        Collections.sort(list);
        System.out.println("ArrayList in asc order: " + list);
    }
}
Output
------
ArrayList in asc order: [9, 12, 29, 34, 75, 76]

There is another way to sort an ArrayList using streams, which is a Java 8 feature. Once we create a stream then 
we can use the sorted() method of the Stream class, which returns the stream of objects in sorted order.

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("ArrayList in asc order: " + sortedList);
    }
}

Output
-------
ArrayList in asc order: [9, 12, 29, 34, 75, 76]

Sorting an ArrayList in descending order
----------------------------------------
There is another overloaded version of the sort() method, i.e., sort(List<T> list, Comparator<? super T> c), which
 takes a List and Comparator object as the input.

 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("ArrayList in desc order: " + list);
    }
}

Output
------
ArrayList in desc order: [76, 75, 34, 29, 12, 9]

The ArrayList can be sorted in reverse order using streams by passing Comparator.reverseOrder() 
to the sorted() method.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        List<Integer> sortedList = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("ArrayList in asc order: " + sortedList);
    }
}

Output
-------
ArrayList in asc order: [76, 75, 34, 29, 12, 9]

In Java 8, the sort(Comparator<? super E> c) method was added to the List interface. 
If we look at the implementation of the Collections.sort() method, then we will find that it internally 
calls the sort() method of the List interface. The code is shown below.

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }

Let’s see how the sort() method of the List interface sorts a list. When the sort() method is called, an array 
containing all elements in this list is created and sorted. After sorting the array, the list is iterated and 
each element is reset from the corresponding position in the array.

The elements are first copied to an array and then sorted because it takes less time to sort a linked list using
 this approach.

 Understanding Comparable Interface
 -----------------------------------
 Lets discuss Comparable Interface in Java.

 Comparable introduction
 -----------------------
 In the previous lesson, we saw that the Collections.sort() method sorts the given List in ascending order. 
 But the question is, how does the sort() method decide which element is smaller and which one is larger?

Each wrapper class(Integer, Double, or Long), String class, and Date class implements an interface called 
Comparable. This interface contains a compareTo(T o) method which is used by sorting methods to sort the Collection. 
This method returns a negative integer, zero, or a positive integer if this object is less than, equal to, or 
greater than the object passed as an argument.

If we use the Collections.sort(List<T> list) method to sort an ArrayList, then the class whose objects are stored
 in the ArrayList must implement the Comparable interface.
If the ArrayList stores an Integer, a Long, or a String, then we don’t need to worry as these classes already 
implement the Comparable interface. But if the ArrayList stores a custom class object, then that class must 
implement the Comparable interface.

In the below example, we have a custom class called Employee. We have stored some Employee objects in an 
ArrayList, and we need to sort it. The below example will not compile as the Employee class does not implement 
the Comparable interface.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

}

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));

        Collections.sort(list);
        System.out.println("ArrayList in asc order: " + list);
    }
}

Output
------
ArrayListDemo.java:25: error: no suitable method found for sort(List<Employee>)
        Collections.sort(list);
                   ^
    method Collections.<T#1>sort(List<T#1>) is not applicable
      (inference variable T#1 has incompatible bounds
        equality constraints: Employee
        upper bounds: Comparable<? super T#1>)
    method Collections.<T#2>sort(List<T#2>,Comparator<? super T#2>) is not applicable
      (cannot infer type-variable(s) T#2
        (actual and formal argument lists differ in length))
  where T#1,T#2 are type-variables:
    T#1 extends Comparable<? super T#1> declared in method <T#1>sort(List<T#1>)
    T#2 extends Object declared in method <T#2>sort(List<T#2>,Comparator<? super T#2>)
1 error

In the below example, the Employee class implements the Comparable interface. 
The code will run successfully and will sort the Employee objects in ascending order of their age.

Employee.java
-------------------
class Employee implements Comparable<Employee> {

    String name;
    int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee emp) {
        //We will sort the employee based on age in ascending order
        //returns a negative integer, zero, or a positive integer as this employee age
        //is less than, equal to, or greater than the specified object.
        return (this.age - emp.age);
    }
}

ArrayListDemo.java
--------------------
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));
        list.add(new Employee("Matt", 19));
        list.add(new Employee("Roy", 72));

        Collections.sort(list);
        for(Employee emp : list) {
            System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
        }
    }
}
Output
-------
Employee Name: Matt, Employee Age: 19
Employee Name: Jane, Employee Age: 29
Employee Name: Alex, Employee Age: 54
Employee Name: Roy, Employee Age: 72

How to write implementation of the compareTo() method
-----------------------------------------------------
Let’s say you have a custom class, and you need to write the implementation of the compareTo() method.

The first step will be to select the fields within that class where you need to sort the objects. 
For example, if you have a Vehicle class then you would like to sort it on the basis of the year it was sold.

Once you have decided the field where the sorting will be done, then the second step will be to write the 
implementation of the compareTo(T o) method. The compareTo(T o) method takes only one object as an input. 
The comparison is made with the calling object. Let’s say we have two Vehicle class objects:

Vehicle v1 = new Vehicle();
Vehicle v2 = new Vehicle();

Then v1.compareTo(v2) should return:

-1 if the production year of v1 is less than the production year of v2
1 if the production year of v1 is greater than the production year of v2
0 if the production year of v1 is equal to the production year of v2

If we need to sort the Vehicle class on the basis of the year it was made, the logic will look as below:

Vehicle.java
-------------
public class Vehicle implements Comparable<Vehicle> {

    String brand;
    Integer makeYear;
    
    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }

    @Override
    public int compareTo(Vehicle o) {
        return this.makeYear - o.makeYear;
        // We can also use the compareTo() method of the Integer class.
        //return this.makeYear.compareTo(o.makeYear);
    }
}

ArrayListDemo.java
------------------
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));

        Collections.sort(list);
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}

Output
------
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: Volkswagen, Vehicle Make: 2010
Vehicle Brand: BMW, Vehicle Make: 2015

If we need to sort the Vehicle class on the basis of the brand name, the logic will be as below:
Vehicle.java
-------------
public class Vehicle implements Comparable<Vehicle> {

    String brand;
    Integer makeYear;
    
    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }

    @Override
    public int compareTo(Vehicle o) {
        //Using the compareTo() method of String class.
        return this.brand.compareTo(o.brand);
    }
}

ArrayListDemo.java
------------------
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));

        Collections.sort(list);
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}

Output
-------
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: BMW, Vehicle Make: 2015
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Volkswagen, Vehicle Make: 2010

Understanding Comparator Interface
-----------------------------------
One of the major drawbacks of using a Comparable interface is that the comparing logic gets fixed.
 If we take the example of the Vehicle class that we looked at in the previous lesson, then it can be sorted 
 either on the basis of the brand or the production year depending on the implementation of the compareTo() method.

If we need some flexibility in sorting, we should use the Comparator interface instead of the Comparable interface. 
The Comparator interface has a method, compare(T o1, T o2), which takes two objects, o1 and o2 as parameters.
 It returns -1 if o1 <o2, 1 if o1 > o2 and 0 if o1 is equal to o2.

If we need to use the Comparator interface, then we can’t use the Collections.sort(List<T> t) method as T should
 implement the Comparable interface. There is another overloaded 
 method, sort(List<T> list, Comparator<? super T> c), that takes the list as well as a Comparator object as input.
 It then sorts the List on the basis of logic, which is provided in the Comparator implementation.

The below code shows how to create a custom Comparator. We will create two custom comparators: one for sorting by
 brand and one for sorting by year.

 import java.util.Comparator;

public class BrandComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.brand.compareTo(o2.brand);
    }
}

------------

import java.util.Comparator;

public class MakeYearComparator implements Comparator<Vehicle>{

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.makeYear.compareTo(o2.makeYear);
    }
}

In the below example, we have used both the Comparators to sort on the basis of brand and production year.

BrandComparator.java
--------------------
import java.util.Comparator;

public class BrandComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.brand.compareTo(o2.brand);
    }
}

Vehicle.java
------------
public class Vehicle {

    String brand;
    Integer makeYear;
    
    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}

ArrayListDemo.java
------------------
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));

        System.out.println("Sorting by brand name.");
        Collections.sort(list, new BrandComparator());
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
        
        System.out.println("Sorting by make year.");
        Collections.sort(list, new MakeYearComparator());
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}

MakeYearComparator.java
------------------------
import java.util.Comparator;

public class MakeYearComparator implements Comparator<Vehicle>{

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.makeYear.compareTo(o2.makeYear);
    }
}

Output
------
Sorting by brand name.
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: BMW, Vehicle Make: 2015
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Volkswagen, Vehicle Make: 2010
Sorting by make year.
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: Volkswagen, Vehicle Make: 2010
Vehicle Brand: BMW, Vehicle Make: 2015

We can also use an anonymous class in the sort method instead of creating a separate class that implements 
Comparator. This is shown in the below example.
Vehicle.java
------------
public class Vehicle {

    String brand;
    Integer makeYear;
    
    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}

ArrayListDemo.java
-------------------
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));
        System.out.println("Sorting by brand name");
        Collections.sort(list, new Comparator<Vehicle>() {

            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.brand.compareTo(o2.brand);
            }
        });
        
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
        
        System.out.println("Sorting by make year");
        Collections.sort(list, new Comparator<Vehicle>() {

            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.makeYear.compareTo(o2.makeYear);
            }
        });
        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}

Output
------
Sorting by brand name
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: BMW, Vehicle Make: 2015
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Volkswagen, Vehicle Make: 2010
Sorting by make year
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: Volkswagen, Vehicle Make: 2010

The above code can be further simplified if we use lambda expressions instead of anonymous classes. 
Lambda expressions were introduced in Java 8.

Vehicle.java
-----------
public class Vehicle {

    String brand;
    Integer makeYear;
    
    public Vehicle(String brand, Integer makeYear) {
        super();
        this.brand = brand;
        this.makeYear = makeYear;
    }
}

ArrayListDemo.java
-------------------
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Vehicle> list = new ArrayList<>();
        list.add(new Vehicle("Volkswagen", 2010));
        list.add(new Vehicle("Audi", 2009));
        list.add(new Vehicle("Ford", 2001));
        list.add(new Vehicle("BMW", 2015));
        System.out.println("Sorting by brand name");
        Collections.sort(list, (o1, o2) -> o1.brand.compareTo(o2.brand));

        for (Vehicle vehicle : list) {
            System.out.println("Vehicle Brand: " + vehicle.brand + ", Vehicle Make: " + vehicle.makeYear);
        }
    }
}
Output
-------
Sorting by brand name
Vehicle Brand: Audi, Vehicle Make: 2009
Vehicle Brand: BMW, Vehicle Make: 2015
Vehicle Brand: Ford, Vehicle Make: 2001
Vehicle Brand: Volkswagen, Vehicle Make: 2010

LinkedList: Introduction
------------------------
The LinkedList class in Java implements the List and the Deque interface.
 Some of the salient features of a LinkedList are:

The elements are inserted in the order of insertion.

It supports duplicate elements.

We can add any number of null elements.

Internal implementation of LinkedList#
The LinkedList class has a static inner class called Node. This class contains three fields:

item - This contains the value of the current element.

next - This contains the pointer to the next element.

prev - This contains the pointer to the previous element.

Below is the code for the Node class.

private static class Node<E> {
     E item;
     Node<E> next;
     Node<E> prev;

     Node(Node<E> prev, E element, Node<E> next) {
         this.item = element;
         this.next = next;
         this.prev = prev;
     }
 }

 When an element is added to the LinkedList, a new Node instance is created.
  Depending on where the new node is being added, the prev and next fields are set.

When a node at index i is removed, the next field of node at index i-1 is set to the node at index i+1. 
Similarly, the prev field of node at index i+1 is set to node i-1.

Time complexities for LinkedList operations
--------------------------------------------
Let’s see what the time complexities are for different operations in a LinkedList.

Adding an element
-----------------
The complexity of adding an element in a LinkedList is O(1).
 If we need to search for the position where the Node needs to be inserted, then the complexity is O(n), but the
  element is usually inserted at the beginning or end, which makes it O(1).

  The biggest benefit of LinkedList, in comparison to an array, is that in a LinkedList, in comparison to an array, is that when new 
  elements are added or removed, the other elements are not rearranged.

  Removing an element
  --------------------
  Removing an element is also an O(1)
 operation if we are aware of the position of the element that needs to be removed. If we need to search 
 and remove an element, it is an O(n) operation.

 
 Searching an element
 --------------------
Searching an element is an O(n) operation, as the entire LinkedList is iterated to search the element 
in the worst case.

Creating a LinkedList
---------------------
There are two ways to create a LinkedList:
Using the no-arg constructor
----------------------------
The default constructor does not take any argument and creates a LinkedList of size zero.
 Below is the syntax to create LinkedList using the default constructor.

 List<Integer> list = new LinkedList<Integer>();    

 Using existing Collection
 ---------------------------
A LinkedList can also be created using an existing Collection.
 The newly created LinkedList will contain all the elements in the same order as the original Collection.

 List<Integer> list = new LinkedList<Integer>(oldList);

 Inserting an element into a LinkedList
 ---------------------------------------
Let’s look at some of the methods used to insert an element into LinkedList.
Inserting a single element at the end.
------------------------------------
To insert a single element at the end, we can use the add(E e) or addLast(E e) method. 
These methods insert the given element at the end of the list and do not return anything.

Inserting a single element at the beginning
--------------------------------------------
We can use the addFirst(E e) method to insert an element at the beginning.

Inserting an element at a particular index
--------------------------------------------
We can use the add(int index, E element) method to insert an element at a particular index.
 The index should be greater than zero and less than the size of the LinkedList; 
 otherwise, IndexOutOfBoundsException is thrown.

Inserting multiple elements from another Collection
---------------------------------------------------
If we have a Collection and we need to add all its elements to another LinkedList, then the 
addAll(Collection c) method can be used. This method will add all the elements at the end of the LinkedList.

list.addAll(anotherList)

Inserting multiple elements from another Collection at a particular index
-------------------------------------------------------------------------
If we have a Collection and we need to add all its elements to another LinkedList at a particular 
index, then the addAll(int index, Collection c) method can be used. This method inserts all of the elements in 
the specified collection into this list starting at the specified position.

list.addAll(3, anotherList)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1); // Adds 1 to the list.
        linkedList.add(2); // Adds 2 to the end of the list.
        linkedList.addLast(3); // Adds 3 to the end of the list.
        System.out.println(linkedList);

        linkedList.addFirst(10); // Adds 10 to the start of the list.
        System.out.println(linkedList);

        linkedList.add(2, 20); // Adds 20 to second position in the list.
        System.out.println(linkedList);

        List<Integer> list = new ArrayList<>();
        list.add(101);
        list.add(102);
        list.add(103);

        linkedList.addAll(3, list); // Adds the collection of elements at third position in the list.
        System.out.println(linkedList);
    }
}

Output
--------
[1, 2, 3]
[10, 1, 2, 3]
[10, 1, 20, 2, 3]
[10, 1, 20, 101, 102, 103, 2, 3]

Fetching element from a LinkedList
-------------------------------------
Let’s discuss the different methods to fetch an element from LinkedList.

Fetching the first element
---------------------------
We can use the getFirst() method to fetch the first element in the list. 
If the LinkedList is empty, then NoSuchElementException is thrown.

Fetching the last element
-------------------------
We can use the getLast() method to fetch the last element in the list. 
If the LinkedList is empty, then NoSuchElementException is thrown.

Fetching an element at a particular index
------------------------------------------
We can fetch an element at a particular index by using the get(int index) method. 
The index should be more than zero and less than the size of the LinkedList; otherwise, IndexOutOfBoundsException
 is thrown.

 import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        
        System.out.println(linkedList.getFirst()); //Fetching the first element.

        System.out.println(linkedList.getLast()); //Fetching the last element.
        
        System.out.println(linkedList.get(2)); //Fetching the element at second index.
    }
}

Output
-------
1
6
3

Removing element from a LinkedList
------------------------------------
Let’s discuss the different methods to remove an element from LinkedList.

Removing the first element
---------------------------
We can use the removeFirst() method to remove the first element in the list. 
If the LinkedList is empty, then NoSuchElementException is thrown.

Removing the last element
---------------------------
We can use the removeLast() method to remove the last element in the list. 
If the LinkedList is empty, then NoSuchElementException is thrown.

Removing an element at a particular index
-----------------------------------------
We can remove an element at a particular index by using the remove(int index) method. 
The index should be more than zero and less than the size of the LinkedList; otherwise, IndexOutOfBoundsException 
is thrown.


Removing a particular element
-----------------------------
We can use the remove(Object o) method to remove a particular element from the LinkedList. 
If there is more than one occurrence of a particular element, then the first occurrence is removed. 
If we want to remove the last occurrence of an element, the removeLastOccurrence() method can be used.

import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(5);
        System.out.println("LinkedList before removing any element " + linkedList);
        
        linkedList.remove(); //Removes the first element.
        System.out.println("LinkedList after removing first element " + linkedList);

        linkedList.removeLast(); //Removes the last element.
        System.out.println("LinkedList after removing last element " + linkedList);
        
        linkedList.remove(new Integer(2)); //Removes the first occurrence of 2.
        System.out.println("LinkedList after removing first occurrence of 2. " + linkedList);
        
        linkedList.removeLastOccurrence(new Integer(4)); //Removes the last occurrence of 4.
        System.out.println("LinkedList after removing the last occurrence of 4. " + linkedList);
    }
}

Output
------
LinkedList before removing any element [1, 2, 3, 4, 2, 4, 5]
LinkedList after removing first element [2, 3, 4, 2, 4, 5]
LinkedList after removing last element [2, 3, 4, 2, 4]
LinkedList after removing first occurrence of 2. [3, 4, 2, 4]
LinkedList after removing the last occurrence of 4. [3, 4, 2]

Sorting a LinkedList
---------------------
To sort a LinkedList, we can use the sort() method of the Collections class as shown in the example below.

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        
        linkedList.add(20);
        linkedList.add(2);
        linkedList.add(12);
        linkedList.add(40);
        linkedList.add(76);
        linkedList.add(41);
        linkedList.add(53);
        
        Collections.sort(linkedList);
        
        System.out.println(linkedList);
    }
}

Output
---------
[2, 12, 20, 40, 41, 53, 76]

CopyOnWriteArrayList: Introduction
-----------------------------------
Lets discuss a thread-safe list called CopyOnWriteArrayList.

The ArrayList and LinkedList data structures that we have discussed until now are not thread-safe. 
This means that if we are working in an environment where multiple threads are simultaneously adding or removing 
elements from a list, it may not work as intended. If a thread is iterating over a list and, in the 
meantime, another thread tries to add an element to the list, then ConcurrentModificationException will be thrown.

Now, if we want to use a list in a multi-threaded environment, we have few options.
 The first option is using a Vector. The Vector is a legacy class in which all the methods are synchronized.
  Since for each operation, such as add or remove, the entire list is locked, it is slow. Hence it is no 
  longer used.

  The second option is making our list thread-safe by using the Collections.synchronizedList() method, which
   we have already discussed in this lesson. The problem with this method is that it also locks the entire list 
   for each operation. So, there is no performance benefit.

    To overcome these issues CopyOnWriteArrayList was introduced. 
This is a thread-safe list with high performance. We will discuss how it works in the upcoming lesson but in 
this lesson, we will focus on how it is used.

Creating a CopyOnWriteArrayList
---------------------------------
There are three ways to create a CopyOnWriteArrayList:
Using the no-arg constructor#
The default constructor does not take any argument and creates a CopyOnWriteArrayList of size zero. 
CopyOnWriteArrayList has an Object array type field named array.

private transient volatile Object[] array;

When we create a list using this constructor, the array field is initialized with size zero.

public CopyOnWriteArrayList() {
    setArray(new Object[0]);
}

final void setArray(Object[] a) {
   array = a;
}

Below is the syntax to create CopyOnWriteArrayList using the default constructor.

List list = new CopyOnWriteArrayList();

Using an existing array#
We can also create a CopyOnWriteArrayList using an existing array. First, a copy of the existing array
 is made using the Arrays.copyOf() method, and then the array variable is initialized with this copied array.

 public CopyOnWriteArrayList(E[] toCopyIn) {
        setArray(Arrays.copyOf(toCopyIn, toCopyIn.length, Object[].class));
    }

Using existing Collection
-------------------------
A CopyOnWriteArrayList can also be created using an existing Collection. 
An array is created using the elements of the passed Collection, and the array variable is initialized with this 
created array.

Inserting elements into a CopyOnWriteArrayList
-------------------------------------------------
Let’s discuss some of the ways we can insert elements into a CopyOnWriteArrayList.

Using the add(E e) method
----------------------------
The add(E e) method inserts an element at the end of the list. If some other thread is iterating the list 
while a new element is getting added, then it will not throw ConcurrentModificationException. How this happens 
    will be discussed in the internal working lesson.

Using the add(int index, E element) method
--------------------------------------------
We can use this method if we want to add an element to a particular index.
 The index provided should be greater than zero and less than or equal to the size of the 
 list; otherwise, IndexOutOfBoundsException is thrown. When an element is added at an index, the element 
 currently at that position (if any), and any subsequent elements to the right, are shifted to the right.

 Using the addAll(Collection c) method
 ------------------------------------
 The addAll(Collection c) method inserts all the elements present in the provided collection at the end of the list. 
 The elements are inserted in the same order as returned by the iterator of the passed collection.

 Using the addIfAbsent(E e) method
 ----------------------------------
 The addIfAbsent() method adds an element at the end of the list only if the element is not present in the list.

 Using the addAllAbsent(Collection c) method
 --------------------------------------------
This method appends all of the specified Collection elements that are not already contained in this list, to the
 end of this list, in the order that the specified Collection’s iterator returns them.

 CopyOnWriteArrayList: Internal Working
 --------------------------------------
 The internal workings of CopyOnWriteArrayList is a very important topic for Java interviews.
  In this lesson, we will see how CopyOnWriteArrayList provides thread-safety.

We know that a CopyOnWriteArrayList is internally backed by an array, so let’s call it backarray for the purpose 
of understanding. Throughout this lesson, wherever we use the term backarray, it means the array in which all the 
elements added to the CopyOnWriteArrayList is maintained.

There is a ReentrantLock defined in the CopyOnWriteArrayList as shown below:

/** The lock protecting all mutators */
final transient ReentrantLock lock = new ReentrantLock();

When a new element is added in a CopyOnWriteArrayList then the following procedure takes place:

1.The thread that is adding the element acquires a lock on the lock object using the lock.lock() method.
 If some other thread tries to add an element to the list, then it will not get access.
2.The thread that has acquired the lock will then make the copy of the backarray. So as shown in the below snippet, a
 new array is created and all the elements from the backarray are added to this new array. The size of this new 
 array is one more than the backarray.

 Object[] newElements = Arrays.copyOf(elements, len + 1);

 3.Now, the element that needs to be added will be added at the end of this newly copied array.

 newElements[len] = e;

 4.Finally the backarray will now be pointed to this new array and the lock will be released.
  In this way, a new element is added to the CopyOnWriteArrayList in a thread-safe manner.

  You might be wondering what would happen if one thread is trying to add an element to the list and the other is
   trying to remove an element from the list. When a thread tries to read an element from the list, it will refer
    to the backarray. Multiple threads can read the data from the list without locking. It is only when adding an
     element that a lock is required, and the backarray should be copied. So, CopyOnWriteArrayList is ideal for 
     situations where add operations are minimal, and there are mostly read operations.

     It is also important to understand why a copy of the backarray is made when an element is added and why just
      acquiring the lock is not sufficient as it will stop other threads from adding at the same time.

The reason for copying the backarray is to make traversal synchronized. This is a bit difficult to 
understand, so let me explain it through an example. But prior to that, let’s define one more term to help 
understand the example. We already know that backarray means the array that contains the elements added to the 
CopyOnWriteArrayList. The array that we get by copying the backarray will be called copiedarray.


Let’s say we have created a CopyOnWriteArrayList that has five elements. So, the size of the backarray is five.

There is a thread, thread1, that wants to iterate our list. This thread will create an iterator.
 The returned iterator provides a snapshot of the state of the list when the iterator was constructed.

 The thread1 is iterating the array, and in the meantime, another thread, thread2, comes to add an element to 
 the list. If this thread adds the element to the backarray, then ConcurrentModificationException will be thrown.
  To avoid this, thread2 will create a copy of the backarray, and then it will add the new element to this copied 
  array.
The thread1 will complete its iteration, but it will not be able to see the newly added element. 
Now, if a new thread, thread3, wants to iterate the list, then it will again create the iterator. 
And this time it will get the snapshot of the backarray, which has six elements.

Please note that when CopyOnWriteArrayList creates an iterator, the “snapshot” is a reference to its current
 array, not a copy of the array.

 CopyOnWriteArrayList: Iteration
 ----------------------------------
Lets discuss how we can iterate over a CopyOnWriteArrayList.

Iteration using forEach()
-------------------------
We can use the forEach(Consumer<? super E> action) method to iterate over a CopyOnWriteArrayList. 
This method was added in Java 8 and takes a lambda expression of type Consumer as the parameter.

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String args[]) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.forEach(System.out::println);
    }
}

Output
------
Apple
Banana
Orange


Iteration using iterator()
---------------------------
The iterator() method returns an iterator that provides a snapshot of the state of the list when the iterator was
 constructed. No synchronization is needed while traversing the iterator because the iteration is being done on a
  snapshot.

In the ArrayList iteration lesson, we saw that if after creating an iterator, an element is added to the ArrayList 
then ConcurrentModificationException is thrown. This is not the case with CopyOnWriteArrayList because the addition
of elements takes place on the copy and not the actual array. But the iterator will be able to access only the 
elements which were present at the time of the creation of the iterator. Let’s understand this further 
through an example.

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String args[]) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        
        //Created an iterator
        Iterator<String> itr = list.iterator();
        //Adding elements after creating iterator. ConcurrentModificationException will not be thrown.
        list.add("Papaya");

        //Iterating the list through the iterator that was created earlier. Papaya will not be present.
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        
        System.out.println("Again getting the iterator");
        //Again creating the iterator. This time papaya will be present.
        itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}


Output
--------
Apple
Banana
Orange
Again getting the iterator
Apple
Banana
Orange
Papaya


There is one interesting thing about this iterator that makes it different from the iterator of other List 
implementations such as ArrayList or LinkedList. The iterator returned by the iterator() method of 
CopyOnWriteArrayList class does not support the remove method. In this lesson, we discussed that if we want to 
delete an element from the ArrayList while iterating, then we should use the iterator’s remove method. 
The same does not hold true for a CopyOnWriteArrayList.

In CopyOnWriteArrayList, we can directly remove the element from the list while iterating and 
ConcurrentModificationException will not be thrown as shown in the below example.

The reason for this is that we are iterating over a snapshot of the List but when we remove an element, it is
 removed from the copy of the List. So no ConcurrentModificationException is thrown.

 import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String args[]) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        
        //Created an iterator
        Iterator<String> itr = list.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
            list.remove("Orange");
        }
        System.out.println("Again creating the iterator");
        //Created an iterator
        itr = list.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
            
        }
        
    }
}

Output
-----
Apple
Banana
Orange
Again creating the iterator
Apple
Banana


The one last thing that we need to discuss is why the iterator of CopyOnWriteArrayList does not have the remove 
method. Firstly it is not needed as in a CopyOnWriteArrayList we can directly remove the element from the List 
without fearing any exception. Secondly, if there was a remove method in the iterator() then it will not be very
 useful. It will remove the element from the snapshot that is created for iteration. The actual array which holds 
 the data will not be changed.

 HashSet: Creation and Insertion
 -------------------------------
 HashSet is a class in the java.utils package which implements the Set interface. Some of the features of HashSet are:

1.HashSet does not allow duplicate elements.
2.HashSet allows only one null element.
3.The elements are inserted in random order in a HashSet.
4.A HashSet is internally backed by a HashMap.

Creating a HashSet
------------------
There are four different constructors available to create a HashSet in Java:

Using the no-arg constructor
---------------------------
The simplest way to create a HashSet is by using the no-arg constructor. 
This constructor creates a HashSet with an initial capacity of 16 and a load factor of 0.75.

Below is the code syntax to create a HashSet.

Set<Integer> set= new HashSet<>();

Load factor is a number that defines when a Set should be resized.
 If the load factor is 0.75, then the Set should be resized when it is 75% full.

 Using the Constructor that takes initial capacity
 --------------------------------------------------
 We can also provide the initial capacity while creating the HashSet.
  If we are already aware that our HashSet will contain more than 16 elements, then it is better to provide
   some initial capacity as it reduces the number of resizes. In this case, also, the default load factor (0.75)
    is used.

Using the constructor that takes initial capacity and load factor
------------------------------------------------------------------
We can also provide initial capacity along with the load factor while creating the HashSet. 
If we don’t want frequent resizing, we can set the load factor to a higher number.

Using the constructor that takes another Set as a parameter
------------------------------------------------------------
We can also create a HashSet using another Set by passing it to the constructor. 
The newly created HashSet will have the same size as that of the passed Set, whereas the load factor will 
default to 0.75.

Inserting an element into a HashSet#
There is an add(E e) method available that inserts an element into the HashSet. If the element is not already
 present, then this method puts the element and returns true. If the element is already present, then it returns 
 false.

 import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();
        
        System.out.println("Inserting 23 in the HashSet:  " + set.add(23));
        System.out.println("Inserting 34 in the HashSet:  " + set.add(34));
        System.out.println("Inserting 23 in the HashSet:  " + set.add(23));
        
        System.out.println(set);
        
    }
}

Output
------
Inserting 23 in the HashSet:  true
Inserting 34 in the HashSet:  true
Inserting 23 in the HashSet:  false
[34, 23]

Fetching an element from a HashSet
----------------------------------
Unlike ArrayList, there is no get() method in a HashSet because a HashSet is not backed by an array. 
The elements are stored in random order in a HashSet, and we can’t get a particular element. 
If we want to check whether a particular element is in the HashSet or not, then we can use the contains() method.

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();
        
        set.add(23);
        set.add(34);
        set.add(56);
        
        System.out.println(set.contains(23));
        
    }
}

Output
------
true


HashSet: Additional Operations
------------------------------
Lets discuss some more operations that can be done on ArrayList.

Removing an element from a HashSet
-----------------------------------
Below are the ways that we can remove an element from the HashSet.

Using the remove(Object o) method
---------------------------------
We can use the remove(Object o) method to remove an element from HashSet. This method takes an object that needs to be removed as a parameter. If the element is removed, then this method returns true. If the element is not present, then it returns false.

Using the clear() method
------------------------
We can use the clear() method to remove all the elements from a HashSet.

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();
        
        set.add(23);
        set.add(34);
        set.add(56);
        
        set.remove(23);
        
        System.out.println("HashSet after removing one element" + set);
        
        set.clear();
        
        System.out.println("HashSet after removing all elements" + set);
        
    }
}

Output
------
HashSet after removing one element[34, 56]
HashSet after removing all elements[]

Checking if the HashSet is empty
--------------------------------
We can check if the HashSet is empty using the isEmpty() method.
 This method returns true if the Set does not have any elements and returns false if the Set has some elements.

 import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        System.out.println(set.isEmpty());
    }
}

Output
------
false

HashSet: Iteration and Sorting
--------------------------------
Lets look at different ways to iterate a HashSet.
Iterating a HashSet
-------------------
Below are the different methods to iterate over a HashSet.

Using for loop
----------------
A HashSet can be easily iterated using an enhanced for loop as shown below.

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        for(int i : set) {
            System.out.println(i);
        }
    }
}

Output
-------
34
23
56

Using Iterator
-----------------
HashSet can also be iterated using an iterator as shown in the below example.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        Iterator<Integer> itr = set.iterator();
        
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

Output
------
34
23
56

Using forEach() method#
We can use the forEach(Consumer<? super T> action) method defined in the Iterable class. 
This method was introduced in Java 8. It accepts an action that needs to be performed for each element 
as a parameter.

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        set.forEach(System.out::println);
    }
}


Output
-------
34
23
56


Sorting a HashSet
-------------------
Since a HashSet stores the elements in random order, it is not possible to store the elements in a HashSet in 
sorted order. If we want to sort the elements of a HashSet, then we should convert it into some other Collection
 such as a List, TreeSet, or LinkedHashSet. We will discuss TreeSet and LinkedHashSet in upcoming lessons.

Here we will see how we can convert a HashSet to an ArrayList, and then we can use the elements from the List. 
As discussed here, we can create an ArrayList by sending another collection to its constructor. We can sort this 
ArrayList using the sort() method of the Collections class.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
    public static void main(String args[]) {
        Set<Integer> set = new HashSet<>();

        set.add(23);
        set.add(34);
        set.add(56);

        // Creating an ArrayList from existing set.
        List<Integer> list = new ArrayList<>(set);
        // Sorting the list.
        Collections.sort(list);
        
        list.forEach(System.out::println);
    }
}

Output
---------
23
34
56

HashMap: Creation and Insertion
-------------------------------
HashMap is a class in the java.utils package that implements the Map interface. 
It is used to store the key-value pair. Let’s suppose we need to store the stock prices of some companies. 
In this case, we can use a HashMap. The company name will be the key and the stock price will be the value.

Some of the features of HashMap are:

The keys should be unique.
HashMap allows only one null key.
The values can be null or duplicate.
The keys are stored in random order.
Creating a HashMap
-------------------
There are four different constructors available to create a HashMap in Java.

Using the no-arg constructor
-----------------------------
The simplest way to create a HashMap is by using the no-arg constructor.
 This constructor creates a HashMap with an initial capacity of 16 and load factor of 0.75.

Below is the code syntax to create a HashMap. It states that the key is a String type and the value is an 
Integer type.

Map<String, Integer> map = new HashMap<>();

Load factor is a number that defines when a Map should be resized. 
If the load factor is 0.75, then it means that the Map should be resized when it is 75 percent full.

Using the constructor that takes initial capacity
--------------------------------------------------
We can also provide the initial capacity while creating the HashMap. If we are already aware that our HashMap 
will contain more than 16 elements, then it is better to provide some initial capacity as it reduces the number
 of resizes. In this case, also, the default load factor (0.75) is used.

Using the constructor that takes initial capacity and load factor
----------------------------------------------------------------
We can also provide initial capacity with the load factor while creating the HashMap.
 If we don’t want frequent resizing then we can set the load factor to a higher number.

Using the constructor that takes another Map as a parameter#
We can also create a HashMap using another Map by passing it to the constructor. 
The newly created HashMap will have the same size as that of the passed Map, whereas the load factor will 
default to 0.75

Inserting into a HashMap
-------------------------
Let’s discuss all the methods that we can use to insert a key-value pair in a HashMap.

Using the put() method
----------------------
We can use the put(K key, V value) method to insert a key-value pair in the HashMap. If the key is not present, then a new key-value pair will be added. If the key is already present, then the value will be updated.

Using the putIfAbsent() method
--------------------------------
The putIfAbsent(K key, V value) method inserts a key-value pair only if it is not already present in the Map. If the key is already present then its value will not be updated. This method was added in Java 8.

Using the putAll() method
--------------------------
The putAll(Map<? extends K, ? extends V> m) method copies all of the mappings from the specified map to this map. These mappings will replace any mappings that this map had for any of the keys currently in the specified map.

The below example shows HashMap working properly.

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    
    public static void main(String args[]) {
        
        Map<String, Integer> stockPrice = new HashMap<>();
        
        stockPrice.put("Oracle", 56); //Inserting share price of Oracle in the Map.
        System.out.println(stockPrice);
        
        stockPrice.put("Oracle", 60); //Inserting share price of Oracle again. This will update the value.
        System.out.println(stockPrice);
        
        stockPrice.putIfAbsent("Oracle", 70); //Inserting share price of Oracle again using putIfAbsent() method. This will not update the value.
        System.out.println(stockPrice);
    }
}

Output
--------
{Oracle=56}
{Oracle=60}
{Oracle=60}


HashMap: Updation and Removal
[----------------------------]
Fetching an element from a HashMap
---------------------------------
There are two ways to get an element from a HashMap.

Using the get() method#
The get(Object key) method takes a key as a parameter and returns the value corresponding to that key. If the key is not present, it returns null.

Using the getOrDefault() method
-------------------------------
The getOrDefault(Object key, V defaultValue) method is useful if are not sure whether a key is present in the Map or not. If the key is present then this method returns the value corresponding to the key and if the key is not present then the default value is returned.

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        System.out.println(stockPrice.get("Oracle"));
        System.out.println(stockPrice.get("Google")); //This will return null.
        
        //Since Google is not present in our Map, this will insert it with default value of 100.
        System.out.println(stockPrice.getOrDefault("Google", 100));
    }
}


Output
------
56
null
100

Replacing a value in HashMap
-----------------------------
When we insert a key-value pair in HashMap and the key is already present then its value gets updated. But if we only want to update the value of a key that is present in the Map, then we can use the replace() method. There are two overloaded versions of the replace() method and one replaceAll() method. All three methods were added in Java 8.

Using the replace(K key, V oldValue, V newValue) method#
The replace(K key, V oldValue, V newValue) method takes three parameters: the key, the old value, and a new value. It checks if the current value of the key is equal to the oldValue provided in the parameter. If yes then it replaces the value with newValue and returns true; otherwise, it returns false.

Using the replace(K key, V value) method
-----------------------------------------
This method takes only two parameters: a key and a value. It replaces the value of the key with the new value provided as a parameter and returns the old value. If the key is not present, then it returns null.

Using the replaceAll(BiFunction<? super K, ? super V, ? extends V> function) method#
This method takes a BiFunction as input and replaces the values of all the keys with the result of the given function. Suppose we need to add ten to the stock price of each company. Instead of updating the value for each stock one by one, we can use this method. The lambda expression to do this task will look like this:

(key, value) -> value + 10

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        
        // This will not replace the value of Oracle because current value is not 70.
        stockPrice.replace("Oracle", 70, 76);
        System.out.println(stockPrice.get("Oracle"));
        
        // This will replace the value of Oracle because current value is 56.
        stockPrice.replace("Oracle", 56, 76);
        System.out.println(stockPrice.get("Oracle"));
        
        // This will replace the value of Fiserv as current value does not matter.
        stockPrice.replace("Fiserv", 100);
        System.out.println(stockPrice.get("Fiserv"));

        // Using the replaceAll() method to add 10 to the price of each stock.
        stockPrice.replaceAll((k,v) -> v + 10);
        System.out.println(stockPrice);

        
    }
}

Output
------
56
76
100
{Fiserv=110, Microsoft=223, Oracle=86, BMW=83}


Removing an element from a HashMap
-----------------------------------
An element can be easily removed for the HashMap using the remove(Object key) method.
 It takes a key as a parameter and removes that key from the map. This method returns the value of the key that
  was removed. If the key is not present, then it returns null.

Another overloaded version of this method remove(Object key, Object value) was added in Java 8. This method removes
a key only if it is currently mapped to the specified value. This method returns true if the key is 
removed; otherwise, it returns false.

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        
        //This will remove Oracle from the Map and return 56.
        System.out.println(stockPrice.remove("Oracle"));
        
        //This will return null as Google is not present in the Map.
        System.out.println(stockPrice.remove("Google"));

        //This will return false because the value passed does not match the value of BMW in the Map.
        System.out.println(stockPrice.remove("BMW", 45));


    }
}
Output
----------
56
null
false

HashMap: A Few More Operations
---------------------------------
Additional operations on HashMap#
Checking if a key is present in the HashMap#
We can use the containsKey(Object key) method to check if a given key is present in the HashMap. 
This method returns true if the key is present and returns false if the key is not present. 
Similarly, we have a containsValue(Object value) method that returns true if one or more keys are mapped to
 this value.

 import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        
        System.out.println(stockPrice.containsKey("Oracle"));
        
        System.out.println(stockPrice.containsValue(73));
    }
}

Output
------
true
true

Fetching all the keys from HashMap
------------------------------------
If we need to fetch all the keys that are stored in a HashMap, then we can use the keySet() method. 
This method returns a Set containing all the keys present in the Map.

Fetching all the values from HashMap
------------------------------------
If we need to fetch all the values stored in a HashMap, we can use the values() method.
 This method returns a Collection containing all the values present in the Map.

 import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);
        
        System.out.println("HashMap Keys");
        Set<String> keys = stockPrice.keySet();
        for(String key : keys) {
            System.out.println(key);
        }
        
        System.out.println("HashMap Values");
        Collection<Integer> values = stockPrice.values();
        for(Integer value : values) {
            System.out.println(value);
        }
        
    }
}
Output
----------
HashMap Keys
Fiserv
Microsoft
Oracle
BMW
HashMap Values
117
213
56

Checking if the HashMap is empty#
We can check if the HashMap is empty using the isEmpty() method. This method returns true if the Map does not have any elements and returns false if the Map has some elements.

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String args[]) {
        Map<String, Integer> map = new HashMap<>();

        map.put("abc", 23);
        map.put("def", 34);
        map.put("ghi", 56);

        System.out.println(map.isEmpty());
    }
}
Output
-------
false


HashMap: Java 8 Improvements
-----------------------------
Till now, we have discussed most of the operations that are supported in a HashMap.
 We have also looked at some of the operations that were added in Java 8, but we have not covered all of them. 
 In this lesson, we will look at a few more operations that were added with Java 8.

The compute() method#
The compute(Key, BiFunction) method allows us to update a value in HashMap. This method tries to compute a 
mapping for the specified key and its current mapped value (or null if no current mapping is found). 
This method is used to atomically update a value for a given key in HashMap.

If the remapping function passed in compute returns null, the mapping is removed from the Map (or remains absent
 if initially absent).
If the remapping function throws an exception, the exception is rethrown, and the current mapping is left unchanged.

The syntax of this method is:

compute(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction)
Let’s say we have a HashMap in which the key is a String, and the value is an Integer. We need to increment 
the value for a given key by one, and if the key is not present, we need to insert the key with the default value 
of 10. We can create a lambda expression and pass it to the compute() method.

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> map = new HashMap<>();
        map.put("India", 5);
        map.put("USA", 3);
        map.put("China", 5);
        map.put("Russia", 6);
        
        // This will increment the value of India by 1 as it is present in the Map
        map.compute("India", (k, v) -> v == null ? 10 : v + 1);

        // This will insert Vietnam in the Map with default value of 10.
        map.compute("Vietnam", (k, v) -> v == null ? 10 : v + 1);

        System.out.println(map);

    }
}

Output
-----------
{Vietnam=10, USA=3, China=5, India=6, Russia=6}

The computeIfAbsent() method
-----------------------------
The computeIfAbsent(Key, Function) method of the HashMap class is used to compute the value for a given key using 
the given mapping function and enter that computed value in HashMap; otherwise, it’s null. Please note that the 
computeIfAbsent() will work only if the key is not present or if the key is present with a null value.

The syntax of this method is:

public V 
       computeIfAbsent(K key,
             Function<? super K, ? extends V> remappingFunction)
Let’s say we have a HashMap in which the key is a String and the value is the length of the String. We can use 
the computeIfAbsent() method to insert new pairs in the Map. We will pass a lambda function that returns the 
length of the key.
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> map = new HashMap<>();
        map.put("India", 5);
        map.put("USA", 3);
        map.put("China", 5);
        map.put("Russia", 6);
        
        map.computeIfAbsent("Vietnam", k -> k.length());
        
        System.out.println(map);

    }
}
Output
------
{Vietnam=7, USA=3, China=5, India=5, Russia=6}

The computeIfPresent() method
---------------------------------
The computeIfPresent(Key, BiFunction) method of the HashMap class allows you to compute the value of mapping for a
specified key if the key is already associated with a value or is mapped to null.

If the mapping function of this method returns null, the mapping is removed.
If the remapping function throws an exception, the exception is rethrown, and the mapping is left unchanged.
The syntax of this method is:

public Object computeIfPresent(Object key,
                  BiFunction remappingFunction)
Let’s say we have a HashMap in which the key is a String and the value is some Integer. Then we can use 
computeIfPresent() method to update the value in the Map. We will pass a lambda function that will calculate
 a value if the key is already present in the Map.

 import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> map = new HashMap<>();
        map.put("India", 5);
        map.put("USA", 3);
        map.put("China", 5);
        map.put("Russia", 6);
        
        // This will increment the value of India by 1 as it is present in the Map
        map.computeIfPresent("India", (k, v) -> v == null ? 10 : v + 1);

        // This will not insert Vietnam in the Map. 
        map.computeIfPresent("Vietnam", (k, v) -> v == null ? 10 : v + 1);

        System.out.println(map);

    }
}
Output
--------
{USA=3, China=5, India=6, Russia=6}


The merge() method
------------------
The merge function can be used to merge two Maps. This method takes three arguments:

key — The key that needs to be merged.
value — The value that needs to be inserted in case the key is not present.
remappingFunction — This is a BiFunction that is used to update the value if the key is present.
We will begin to understand the working of this method using an example. Let’s say we have two Maps in
 which the key is the name of a person and the value is the amount of money that person has borrowed from us.
  It is possible that a person is present in both the Maps. So, we need to merge these Maps to find the total 
  amount that each person has borrowed from us.

The syntax of this method is:

merge(K key, V value,
            BiFunction remappingFunction)


import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Jay", 5000);
        map1.put("Rahul", 3000);
        map1.put("Nidhi", 4500);
        map1.put("Amol", 60000);
        
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Jay", 7000);
        map2.put("Rahul", 4500);
        map2.put("Nidhi", 1200);
        map2.put("Saurav", 25000);
        
        map1.forEach((key,value) -> map2.merge(key, value, (v1, v2) -> v1 + v2));
        
        System.out.println(map2);

    }
}

Output
-----------
{Saurav=25000, Rahul=7500, Jay=12000, Amol=60000, Nidhi=5700}

HashMap: Iteration
-----------------
Iterating a HashMap is a bit challenging compared to a List or a Set as it contains pairs of elements. 
In a map, each key-value pair is called Entry. The entrySet() method returns the Set view of the mapped elements. 
We can iterate over this Set using any of the below approaches.

Iterating using a for loop#
We can easily iterate the EntrySet returned by the entrySet() method using an enhanced for loop. The Entry class
 contains two methods: getKey() and getValue(), which can be used to get the key and value respectively.

 import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        Set<Entry<String, Integer>> entrySet = stockPrice.entrySet(); // Returns a Set of Entries

        for (Entry<String, Integer> entry : entrySet) {
            System.out.println("Company Name: " + entry.getKey() + " Stock Price: " + entry.getValue());
        }
    }
}
Output
------
Company Name: Fiserv Stock Price: 117
Company Name: Microsoft Stock Price: 213
Company Name: Oracle Stock Price: 56
Company Name: BMW Stock Price: 73

Iterating using an iterator
--------------------------
Instead of using a for loop, we can get the iterator on the EntrySet and then use it to iterate the HashMap.
 If we remove an element from the EntrySet, then it is also removed from the original Map.

 import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        Set<Entry<String, Integer>> entrySet = stockPrice.entrySet(); // Returns a Set of Entries
        
        Iterator<Entry<String, Integer>> itr = entrySet.iterator(); //Getting the iterator

        while (itr.hasNext()) {
            Entry<String,Integer> entry = itr.next();
            System.out.println("Company Name: " + entry.getKey() + " Stock Price: " + entry.getValue());
            
            if(entry.getKey().equals("Oracle")) {
                itr.remove();
            }
        }
        System.out.println(stockPrice);
    }
}

Output
------
Company Name: Fiserv Stock Price: 117
Company Name: Microsoft Stock Price: 213
Company Name: Oracle Stock Price: 56
Company Name: BMW Stock Price: 73
{Fiserv=117, Microsoft=213, BMW=73}

Iterating using the forEach() method
--------------------------------------
The forEach(BiConsumer<? super K, ? super V> action) method is a default method that was introduced in Java 8. 
It takes a BiConsumer as a parameter. The below example shows how we can use the forEach method to print the 
key-value pairs.

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<String, Integer> stockPrice = new HashMap<>();

        stockPrice.put("Oracle", 56);
        stockPrice.put("Fiserv", 117);
        stockPrice.put("BMW", 73);
        stockPrice.put("Microsoft", 213);

        stockPrice.forEach((key, value) -> System.out
                .println("Company Name: " + key + " Stock Price: " + value));

    }
}

Output
-------
Company Name: Fiserv Stock Price: 117
Company Name: Microsoft Stock Price: 213
Company Name: Oracle Stock Price: 56
Company Name: BMW Stock Price: 73

TreeMap: Creation and Insertion
-------------------------------
TreeMap is a class in the java.utils package that stores the keys in sorted order. 
Some of the features of TreeMap are:

The entries in TreeMap are sorted in the natural ordering of its keys.

It does not allow null keys, however there can be null values.

The TreeMap is not thread-safe, although it can be made thread-safe using the synchronizedMap() method of the
 Collections class.

Since a TreeMap stores the keys in sorted order, the objects that we are storing in the TreeMap should either 
implement the Comparable interface or we should pass a Comparator while creating the TreeMap object.

Creating a TreeMap
--------------------
There are four different ways to create a TreeMap object.

Using a no-arg constructor
----------------------------
A TreeMap can be created easily using the no-arg constructor.
 The keys that we will store in this TreeMap must implement the Comparable interface.

Using the constructor with Comparator as an argument
-------------------------------------------------------
If the objects that we are storing in a TreeMap as a key do not implement the Comparable interface or if 
we need to store the keys in descending order, then we can provide a custom Comparator while creating the TreeMap.
 Now, when the keys are stored in the TreeMap, they are sorted as per the logic provided by the Comparator.

Using constructor with the argument of type Map
------------------------------------------------
A TreeMap can be created from another Map as well. The keys are stored in ascending order irrespective of the 
order that the elements are stored in the provided Map.

Using constructor with the argument of type SortedMap
-------------------------------------------------------
This constructor behaves as a copy constructor and creates a TreeMap with the same 
elements and ordering of the provided sorted map.

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    
    public static void main(String args[]) {
        
        // Creating a TreeMap which will store all the elements in reverse order.
        TreeMap<String, Integer> reverseMap = new TreeMap<>(Comparator.reverseOrder());     
        reverseMap.put("Oracle", 43);
        reverseMap.put("Microsoft", 56);
        reverseMap.put("Apple", 43);
        reverseMap.put("Novartis", 87);         
        System.out.println("Elements are stored in reverse order: " + reverseMap);
        
        // Creating a HashMap which will store all the elements in random order.
        Map<String, Integer> hashMap = new HashMap<>();     
        hashMap.put("Oracle", 43);
        hashMap.put("Microsoft", 56);
        hashMap.put("Apple", 43);
        hashMap.put("Novartis", 87);
        System.out.println("Elements are stored in random order: " + hashMap);
        
        // Creating a TreeMap using existing HashMap. This will store the elements in ascending order.
        TreeMap<String, Integer> treeMap1 = new TreeMap<>(hashMap);
        System.out.println("Elements are stored in ascending order: " + treeMap1);
        
        // Creating a TreeMap using existing TreeMap. This will store the elements in the same order as it was in the passed Map.
        TreeMap<String, Integer> treeMap2 = new TreeMap<>(reverseMap);
        System.out.println("Elements are stored in descending order: " + treeMap2);
    }
}
Output
--------
Elements are stored in reverse order: {Oracle=43, Novartis=87, Microsoft=56, Apple=43}
Elements are stored in random order: {Apple=43, Microsoft=56, Oracle=43, Novartis=87}
Elements are stored in ascending order: {Apple=43, Microsoft=56, Novartis=87, Oracle=43}
Elements are stored in descending order: {Oracle=43, Novartis=87, Microsoft=56, Apple=43}


Inserting elements in a TreeMap
-------------------------------
Let’s discuss all the methods that we can use to insert the key-value pairs in a TreeMap.

Using the put() method
-------------------------
We can use the put(K key, V value) method to insert a key-value pair in the TreeMap. If the key is not present, then a new key-value pair will be added. If the key is already present, then the value will be updated.

Using the putAll() method
--------------------------
The putAll(Map<? extends K, ? extends V> m) method copies all of the mappings from the specified map to this map. These mappings will replace any mappings that this map had for any of the keys currently in the specified map.

The below example shows a working example of TreeMap.

import java.util.TreeMap;

public class TreeMapDemo {
    
    public static void main(String args[]) {
        TreeMap<String, Integer> map = new TreeMap<>();
        
        map.put("Oracle", 43);
        map.put("Microsoft", 56);
        map.put("Apple", 43);
        map.put("Novartis", 87);
        
        System.out.println(map);
        
        TreeMap<String, Integer> finalMap = new TreeMap<>();
        
        map.put("Google", 65);
        map.put("Audi", 32);
        finalMap.putAll(map);
        
        System.out.println(finalMap);
    }
}

Output
--------
{Apple=43, Microsoft=56, Novartis=87, Oracle=43}
{Apple=43, Audi=32, Google=65, Microsoft=56, Novartis=87, Oracle=43}


TreeMap: Fetching and Removal
--------------------------------
Fetching an element from a TreeMap
----------------------------------
The following methods can be used to fetch elements from a TreeMap.

Fetching the value for a particular key
---------------------------------------
We can fetch the value for a particular key using the get(Object o) method. This method will return the value 
of the key if the key is present. If the key is not present, it will return null.

Fetching the smallest key
---------------------------
As we are aware that a TreeMap stores elements in sorted order, we can fetch the smallest key using the 
firstKey() method. If the TreeMap is empty, then NoSuchElementException is thrown. If we want to get the smallest
 entry, then the firstEntry() method can be used.

Fetching the largest key#
We can fetch the largest key using the lastKey() method. If the TreeMap is empty, then NoSuchElementException 
is thrown. If we want to get the largest entry, then the lastEntry() method can be used.


import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapDemo {
    
    public static void main(String args[]) {
        
        TreeMap<String, Integer> map = new TreeMap<>();     
        map.put("Oracle", 43);
        map.put("Microsoft", 56);
        map.put("Apple", 76);
        map.put("Novartis", 87);
        
        //Fetching the first entry in the Map.
        Entry<String, Integer> firstEntry = map.firstEntry();
        
        
        System.out.println("Smallest key: " + firstEntry.getKey() + ", Value: " + firstEntry.getValue());
        
        //Fetching the last entry in the Map.
        Entry<String, Integer> lastEntry = map.lastEntry();
        System.out.println("Largest key: " + lastEntry.getKey() + ", Value: " + lastEntry.getValue());
    }
}

Output
---------
Smallest key: Apple, Value: 76
Largest key: Oracle, Value: 43

Removing an element from a TreeMap
----------------------------------
To remove an element from TreeMap, the remove(Object o) method can be used. This method returns the previous
 value for this key if the key is present. If the key is not present, then null is returned.

 import java.util.TreeMap;

public class TreeMapDemo {
    
    public static void main(String args[]) {
        TreeMap<String, Integer> map = new TreeMap<>();
        
        map.put("Oracle", 43);
        map.put("Microsoft", 56);
        map.put("Apple", 43);
        map.put("Novartis", 87);
        
        System.out.println("Removing Oracle from Map. This will return the value corresponding to Oracle: " + map.remove("Oracle"));
        System.out.println("Removing Google from Map. This will return null as Google is not present in the Map: " + map.remove("Google"));
    }
}

Output
---------
Removing Oracle from Map. This will return the value corresponding to Oracle: 43
Removing Google from Map. This will return null as Google is not present in the Map: null


Updating values in a TreeMap
----------------------------
If we put a key-value pair in a TreeMap, and it is already present, then the value is updated. 
But what if we want to update the value of a key only if it is already present in the Map? In that case, we can
 use the replace() method provided in the TreeMap.

It has the following two variations:

Replacing without checking the previous value#
The replace(Key k, value v) method is used to replace the value of the given key. If the key is present then 
this method replaces the old value with the new value and returns the old value. If the key is not present then 
null is returned.

Replacing after checking the previous value#
The replace(K key, V oldValue, V newValue) method is used to replace the value of the given key if its current 
value is the same as the provided value. If the value is replaced, then true is returned. If not, then false is 
z`zreturned.

import java.util.TreeMap;

public class TreeMapDemo {
    
    public static void main(String args[]) {
        
        TreeMap<String, Integer> map = new TreeMap<>();     
        map.put("Oracle", 43);
        map.put("Microsoft", 56);
        map.put("Apple", 76);
        map.put("Novartis", 87);
        
        System.out.println("Replacing the value of Oracle : " + map.replace("Oracle", 67));
        System.out.println("Latest value of Oracle : " + map.get("Oracle"));
        
        System.out.println("Replacing the value of Apple only if current value is 50 : " + map.replace("Apple", 50, 90));
        System.out.println("Latest value of Oracle : " + map.get("Apple"));
        
        System.out.println("Replacing the value of Apple only if current value is 76 : " + map.replace("Apple", 76, 90));
        System.out.println("Latest value of Oracle : " + map.get("Apple"));
    }
}

Output
---------
Replacing the value of Oracle : 43
Latest value of Oracle : 67
Replacing the value of Apple only if current value is 50 : false
Latest value of Oracle : 76
Replacing the value of Apple only if current value is 76 : true
Latest value of Oracle : 90

TreeMap: Sorting a TreeMap by Values
------------------------------------
Lets discuss how we can sort the TreeMap elements on the basis of values.

We have a TreeMap in which we need to store the stock data.
 The key is the company’s name, and value is the price of the stock of that company.

By default, when we store the Map’s stock data, it will be stored in sorted order by key.
 But we need to store the data such that it is sorted by value. This means that the first element will 
 be the company with the lowest stock price, and the last element will be the company with the highest stock price.

We know that while creating a TreeMap object we can provide a Comparator implementation that will be used to sort
 the elements. We can write a Comparator implementation so that it sorts the elements based on values instead of 
 keys.

The below example shows how we can sort the elements on the basis of values. We have created a Comparator 
implementation that compares the values for the two keys passed to it.

Please note that in the below implementation, we are returning 1 if both the values are the same.
 The reason for doing this is that if two values are the same, then the TreeMap will consider it as duplicate, and
  it will not insert the keys in the Map.


import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {

    public static TreeMap<String, Integer> sortByValues(TreeMap<String, Integer> map) {

        Comparator<String> valueComparator = new Comparator<String>() { 
            
            // return comparison results of values of two keys 
            public int compare(String k1, String k2) 
            { 
                int comp = map.get(k1).compareTo( 
                    map.get(k2)); 
                if (comp == 0) 
                    return 1; 
                else
                    return comp; 
            } 
      
        };

        TreeMap<String, Integer> mapSortedByValues = new TreeMap<>(valueComparator);

        mapSortedByValues.putAll(map);
        return mapSortedByValues;

    }

    public static void main(String args[]) {

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Oracle", 43);
        map.put("Microsoft", 56);
        map.put("Apple", 76);
        map.put("Novartis", 87);
        map.put("Google", 23);
        map.put("Audi", 101);

        System.out.println(sortByValues(map));
    }
}
Output
----------
{Google=23, Oracle=43, Microsoft=56, Apple=76, Novartis=87, Audi=101}

The above logic can be a bit simplified if we use the lambda expressions while creating Comparator as shown below.

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {

    public static TreeMap<String, Integer> sortByValues(TreeMap<String, Integer> map) {

        Comparator<String> valueComparator = (k1, k2) -> {

            int comp = map.get(k1).compareTo(map.get(k2));
            if (comp == 0)
                return 1;
            else
                return comp;
        };

        TreeMap<String, Integer> mapSortedByValues = new TreeMap<>(valueComparator);

        mapSortedByValues.putAll(map);
        return mapSortedByValues;

    }

    public static void main(String args[]) {

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Oracle", 43);
        map.put("Microsoft", 56);
        map.put("Apple", 76);
        map.put("Novartis", 87);
        map.put("Google", 23);
        map.put("Audi", 101);

        System.out.println(sortByValues(map));
    }
}

Output
-----------
{Google=23, Oracle=43, Microsoft=56, Apple=76, Novartis=87, Audi=101}

TreeMap: HashMap Sorting
--------------------------
How to sort a HashMap by key and value is one of the most important interview questions employers ask, and there 
is no single answer to it. We did not discuss this topic in the HashMap section because it requires some knowledge
 of TreeMap, which we have discussed in this section.

Let’s discuss some of the ways to sort a HashMap.
Using a TreeMap
---------------
As we have already seen that the elements are stored in a TreeMap in sorted order by default, we can create a
 TreeMap and then add all the elements from our HashMap to the TreeMap using the putAll() method.

 import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(123, "Alex");
        employeeMap.put(342, "Ryan");
        employeeMap.put(143, "Joe");
        employeeMap.put(234, "Allen");
        employeeMap.put(432, "Roy");
        
        System.out.println("Unsorted map " + employeeMap);
        
        TreeMap<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.putAll(employeeMap);
        System.out.println("Sorted map " + sortedMap);

    }
}
Output
------
Unsorted map {432=Roy, 342=Ryan, 234=Allen, 123=Alex, 143=Joe}
Sorted map {123=Alex, 143=Joe, 234=Allen, 342=Ryan, 432=Roy}

Using an ArrayList
-------------------
We can store all the keys in an ArrayList, and then use the sort() method of the Collections class 
to sort the list. If we want to sort the values, then we can store the values in ArrayList and sort them.
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(123, "Alex");
        employeeMap.put(342, "Ryan");
        employeeMap.put(143, "Joe");
        employeeMap.put(234, "Allen");
        employeeMap.put(432, "Roy");
        
        List<Integer> keyList = new ArrayList<>(employeeMap.keySet());
        Collections.sort(keyList);
        System.out.println(keyList);
        
        
        List<String> valuesList = new ArrayList<>(employeeMap.values());
        Collections.sort(valuesList);
        System.out.println(valuesList);

    }
}
Output
-------
[123, 143, 234, 342, 432]
[Alex, Allen, Joe, Roy, Ryan]

Using lambdas and streams
--------------------------
Java 8 introduced some methods to easily sort a HashMap by key or value.
 The comparingByKey comparator is used to sort the elements by key and comparingByValue comparator is used 
 to sort the elements by value.

The below example shows how we can sort a HashMap by key or value.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapDemo {

    public static void main(String args[]) {

        Map<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(123, "Alex");
        employeeMap.put(342, "Ryan");
        employeeMap.put(143, "Joe");
        employeeMap.put(234, "Allen");
        employeeMap.put(432, "Roy");

        System.out.println("Sorting by key");
        employeeMap.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, String>comparingByKey())
        .forEach(System.out::println);

        System.out.println("Sorting by value");
        employeeMap.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .forEach(System.out::println);

    }
}
Output
-------
Sorting by key
123=Alex
143=Joe
234=Allen
342=Ryan
432=Roy
Sorting by value
123=Alex
234=Allen
143=Joe
432=Roy
342=Ryan


LinkedHashMap: Introduction
-----------------------------
We have already discussed that a HashMap does not maintain insertion order and TreeMap stores the elements in 
sorted order. Now, if we want to store the elements in a Map in insertion order, then a LinkedHashMap can be used.
LinkedHashMap is a class in the java.utils package that implements the Map interface and extends the HashMap class. It is similar to HashMap with the additional feature of maintaining the order of elements inserted into it.

Some of the important features of a LinkedHashMap are:

It does not allow duplicate keys.
It may have one null key and multiple null values.
It is non-synchronized.

Creating a LinkedHashMap
--------------------------
There are five different constructors available to create a LinkedHashMap object. We will discuss 
each of them here:

Using a no-arg constructor#
The no-arg constructor, LinkedHashMap(), creates a Map with a default capacity of 16 and a default load
 factor of 0.75. The elements are stored in the insertion order.

Using the constructor that takes initial capacity#
The LinkedHashMap(int capacity) constructor is used if we need to provide the initial capacity of the Map.
 This constructor is used if we are already aware of the number of elements that the Map will store.
  The initial capacity should be greater than zero; otherwise, IllegalArgumentException will be thrown.

Using the constructor that takes initial capacity and load factor#
The LinkedHashMap(int capacity, float loadFactor) constructor is used if we need to provide both the initial 
capacity and the load factor of the Map. Both the initial capacity and load factor should be greater than zero.
 The load factor should be less than one.

Using the constructor that takes access order flag
--------------------------------------------------
The LinkedHashMap(int capacity, float loadFactor, boolean accessOrder) accepts three
 arguments: the initial capacity, the load factor, and the accessOrder flag. If the accessOrder is false, the 
 elements will be stored in the order of insertion. If it is true, then the elements are stored in order of access.
 It means that the element that is accessed most recently is kept last.

Using the constructor that takes another Map
----------------------------------------------
This constructor creates an insertion-ordered LinkedHashMap instance with the same mappings as the specified map. 
The LinkedHashMap instance is created with a default load factor (0.75) and an initial capacity sufficient to hold
 the mappings in the specified map.

Inserting into a LinkedHashMap
-------------------------------
The LinkedHashMap class does not have a put() method, but since it extends the HashMap class, the put() method 
from the HashMap class is used. In the below example, we have created a LinkedHashMap in which few elements are
 inserted. On printing the elements, we can see that the elements were inserted as per the insertion order.

import java.util.LinkedHashMap;
import java.util.HashMap;

public class LinkedHashMapDemo {
    
    public static void main(String args[]) {
        
        HashMap<String, Integer> stocks = new LinkedHashMap<>();
        
        stocks.put("Apple", 123);
        stocks.put("BMW", 54);
        stocks.put("Google", 87);
        stocks.put("Microsoft", 232);
        stocks.put("Oracle", 76);
        
        System.out.println(stocks); 
    }
}
Output
-------
{Apple=123, BMW=54, Google=87, Microsoft=232, Oracle=76}

In the below example, we have created a LinkedHashMap with the access order flag as true. 
Now the elements that were accessed most recently will be kept at the last position.

import java.util.LinkedHashMap;
import java.util.HashMap;

public class LinkedHashMapDemo {
    
    public static void main(String args[]) {
        
        HashMap<String, Integer> stocks = new LinkedHashMap<>(16, 0.75f, true);
        
        stocks.put("Apple", 123);
        stocks.put("BMW", 54);
        stocks.put("Google", 87);
        stocks.put("Microsoft", 232);
        stocks.put("Oracle", 76);
        
        System.out.println(stocks);
        stocks.get("Google");
        stocks.get("BMW");
        
        System.out.println(stocks);
    }

}

Output
---------
{Apple=123, BMW=54, Google=87, Microsoft=232, Oracle=76}
{Apple=123, Microsoft=232, Oracle=76, Google=87, BMW=54}


LinkedHashMap: Internal Working
------------------------------
The internal workings of a LinkedHashMap are similar to the internal workings of HashMap with one major difference. In LinkedHashMap, each Entry maintains the record of the Entry that was inserted before it and after it.

If we look at the Entry class of LinkedHashMap, then we can see that it has two extra fields in comparison to 
the Entry class of HashMap. These extra fields are before and after. For a given Entry, the before field points
 to the Entry that was inserted prior to this Entry. The after field points to the Entry that was inserted after
  this Entry.

  static class Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after;
    Entry(int hash, K key, V value, Node<K,V> next) {
        super(hash, key, value, next);
        }
    }

    There are two additional fields in the LinkedHashMap namely head and tail. 
    The head points to the first node that was inserted in the Map and tail points to the last node that 
    was inserted in the Map.

Let’s take a step by step look at how elements are inserted in a LinkedHashMap.

Inserting the first element
--------------------------------
Let’s consider creating a LinkedHashMap that stores the student information. 
The key is the id of the student and the value is the name of the student.

We are inserting our first record, 123; “Roy” in LinkedHashMap on the tail.
 The following process will occur:

The hash of 123 will be calculated and based on the hash value, a bucket will be decided. 
Let’s say the bucket is 5.
An Entry object is created with the key as 123 and the value as Roy. The before and after fields are set to 
null as this is the first record.
Since there is no element in the LinkedHashMap, both the head and tail variables are null. Now both these 
variables will point towards the newly created Entry.

Inserting the second element
-----------------------------
Now we will insert the second record, 124; “Jay”, in the LinkedHashMap on the tail. 
The following process will happen:

The hash of 124 will be calculated and based on the hash value, a bucket will be decided.
 Let’s say the bucket is 2.
An Entry object is created with the key as 124 and the value as Jay. The before field is set to the previous
 Entry, and the after field is set to null.
The tail will now point to this entry, and the head will remain unchanged.

Inserting the third element
----------------------------
Now we will insert the third record, 125; “Alex”, in the LinkedHashMap on the tail. T
he following process will happen:

The hash of 125 will be calculated and based on the hash value, a bucket will be decided.
 Let’s say the bucket is 2 again.
An Entry object is created with the key as 125 and the value as Alex. The before field is set to the previous 
Entry, and the after field is set to null.
The tail will now point to this entry, and the head will remain unchanged.

Now it should be clear how a LinkedHashMap works. 
Basically, a doubly linked list is maintained that keeps track of the insertion order of the elements.


ConcurrentHashMap
------------------
In this lesson, we discussed how we can make our Map thread-safe by using the synchronizedMap()
 method of the Collections class. This method returns SynchronizedMap in which all the methods are synchronized.
  There are lots of differences between a ConcurrentHashMap and a SynchronizedMap, which we will discuss next.

Although all the basic operations such as insert, fetch, replace, and remove in a ConcurrentHashMap are similar 
to the HashMap. But we will discuss them again so that you are not confused about how to perform these operations
 in a ConcurrentHashMap.

Differences between a ConcurrentHashMap and SynchronizedMap
-------------------------------------------------------------
Let’s discuss some of the differences between a ConcurrentHashMap and a SynchronizedMap.

In a SynchronizedMap, the entire Map is locked. So every read/write operation needs to acquire a lock, which 
makes it very slow. On the other hand in a ConcurrentHashMap, only a segment of the Map is locked. Two parallel 
threads can access or update elements in a different segment, so it performs better.

SynchronizedMap returns Iterator, which fails fast on concurrent modification. ConcurrentHashMap doesn’t 
throw a ConcurrentModificationException if one thread tries to modify it while another is iterating over it.

ConcurrentHashMap does not allow null keys or null values while SynchronizedMap allows one null key.

Creating a ConcurrentHashMap
------------------------------
There are four different constructors available to create a ConcurrentHashMap in Java.

Using the no-arg constructor
---------------------------
The simplest way to create a ConcurrentHashMap is by using the no-arg constructor. 
This constructor creates a ConcurrentHashMap with an initial capacity of 16 and load factor of .75

Below is the code syntax to create a ConcurrentHashMap. It states that the key is a String
 type and the value is an Integer type.

ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
Using the constructor that takes initial capacity#
We can also provide the initial capacity while creating the ConcurrentHashMap. If we are already aware 
that our ConcurrentHashMap will contain more than 16 elements, then it is better to provide some initial 
capacity as it reduces the number of resizes. In this case, the default load factor (0.75) is also used.

Using the constructor that takes initial capacity and load factor#
We can also provide initial capacity with the load factor while creating the ConcurrentHashMap. If we don’t
 want frequent resizing, then we can set the load factor to a higher number.

Using the constructor that takes another Map as a parameter#
We can also create a ConcurrentHashMap using another Map by passing it to the constructor. The newly created 
ConcurrentHashMap will have the same size as that of the passed Map, whereas the load factor will default to 0.75

Using the constructor that takes initial capacity, load factor, and concurrency level as a parameter
[----------------------------------------------------------------------------------------------------]
This constructor was used prior to Java 8 and has been kept only for backward compatibility. 
The concurrency level field is no longer used after Java 8, as the internal implementation has been changed.

Inserting into a ConcurrentHashMap
------------------------------------
Let’s discuss all the methods that we can use to insert a key-value pair in a ConcurrentHashMap.

Using the put() method#
We can use the put(K key, V value) method to insert a key-value pair in the ConcurrentHashMap. 
If the key is not present, then a new key-value pair will be added. If the key is already present, then 
the value will be updated.

Using the putIfAbsent() method#
The putIfAbsent(K key, V value) method inserts a key-value pair only if it is not already present in the Map.
 If the key is already present, then its value will not be updated.

Using the putAll() method#
The putAll(Map<? extends K, ? extends V> m) method copies all of the mappings from the specified map to this map.
 These mappings will replace any mappings that this map had for any of the keys currently in the specified map.

The below example shows the working of ConcurrentHashMap.

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    
    public static void main(String args[]) {
        
        ConcurrentHashMap<String, Integer> stocks = new ConcurrentHashMap<>();
        
        stocks.put("Google", 123);
        stocks.put("Microsoft", 654);
        stocks.put("Apple", 345);
        stocks.put("Tesla", 999);
        
        System.out.println(stocks);
        
        // Since we are using putIfAbsent(), and Apple is already in the Map, the value will not be added.
        stocks.putIfAbsent("Apple", 1000);
        
        System.out.println(stocks);
    
    }

}
Output
----------
{Google=123, Apple=345, Tesla=999, Microsoft=654}
{Google=123, Apple=345, Tesla=999, Microsoft=654}


IdentityHashMap
-----------------
IdentityHashMap is another type of Map that implements Map, Serializable, and Cloneable interfaces and extends
 the AbstractMap class. The main feature of this map is that while storing elements, the equality of the keys 
 is checked on the basis of reference instead of the equals method. What this means is that if we have two 
 keys, key1 and key2, then key1 will be considered equal to key2 if key1 == key2. In other words, if both the
  keys reference the same object.

This means that IdentityHashMap intentionally violates Map’s general contract which mandates the use of the 
equals method when comparing objects. This class is designed for use only in rare cases wherein reference-equality
semantics are required.

Some of the features of IdentityHashMap are:

The IdentityHashMap stores the elements in random order.
The IdentityHashMap allows a single null key.
The IdentityHashMap is not thread-safe.
Difference between HashMap and IdentityHashMap#
Let’s discuss some of the differences between a HashMap and IdentityHashMap.

IdentityHashMap uses reference equality to compare keys and values while HashMap uses object equality to compare 
keys and values.
IdentityHashMap does not use the hashCode() method. Instead it uses System.identityHashCode() to find the bucket
 location.
IdentityHashMap does not require keys to be immutable as it does not rely on the equals() and hashCode() methods. 
To safely store the object in HashMap, keys must be immutable.
The default initial capacity of HashMap is 16; whereas, for IdentityHashMap, it is 32.
These are the major differences between a HashMap and IdentityHashMap. 
All the operations such as create, add, fetch, remove, etc in an IdentityHashMap are the same as 
these operations in hashMap, so we won’t be discussing it here again. We will be looking at an example
 to understand the difference in how HashMap and IdentityHashMap run.

First, let’s create an Employee class that overrides both the equals() and the hashCode() method.

public class Employee {

    int empId;
    String empName;

    public Employee(int empId, String empName) {
        super();
        this.empId = empId;
        this.empName = empName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + empId;
        result = prime * result + ((empName == null) ? 0 : empName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Employee other = (Employee) obj;
        if (empId != other.empId)
            return false;
        if (empName == null) {
            if (other.empName != null)
                return false;
        } else if (!empName.equals(other.empName))
            return false;
        return true;
    }

}

Now we will create two Employee objects with exactly the same data and will store them in an IdentityHashMap 
as well as in a HashMap. We will find out that an IdentityHashMap will store both the objects whereas the 
HashMap will have only one object, stored in it.

IdentitiyHashMapDemo.java
----------------------------
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    
    public static void main(String args[]) {
        
        Employee emp1 = new Employee(123, "Saurav");
        Employee emp2 = new Employee(123, "Saurav");
        
        
        Map<Employee, String> hashMap = new HashMap<>();
        hashMap.put(emp1, "emp1");
        hashMap.put(emp2, "emp2");
        
        
        Map<Employee, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(emp1, "emp1");
        identityHashMap.put(emp2, "emp2");
        
        System.out.println("The employee objects in HashMap are:");
        System.out.println(hashMap);

        System.out.println();
        System.out.println("The employee objects in IdentityHashMap are:");
        System.out.println(identityHashMap);
    }

}

Employee.java
-------------
public class Employee {

    int empId;
    String empName;

    public Employee(int empId, String empName) {
        super();
        this.empId = empId;
        this.empName = empName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + empId;
        result = prime * result + ((empName == null) ? 0 : empName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Employee other = (Employee) obj;
        if (empId != other.empId)
            return false;
        if (empName == null) {
            if (other.empName != null)
                return false;
        } else if (!empName.equals(other.empName))
            return false;
        return true;
    }

}

Output
--------
The employee objects in HashMap are:
{Employee@93301da6=emp2}

The employee objects in IdentityHashMap are:
{Employee@93301da6=emp2, Employee@93301da6=emp1}

EnumMap
------
The EnumMap is a special kind of Map in which the keys are only of the Enum type.
 Although it is possible to use the Enum type as a key in other Map implementations such as a HashMap or 
 TreeMap, but a separate Map implementation was created for performance reasons.

The EnumMap is highly efficient, and we will discuss more when we will look at how it works internally. 
Let’s look at some of the features of EnumMap.

EnumMap does not allow null keys, but it allows null values.
The keys are stored in their natural order. In the case of an Enum, the natural order of keys means the 
order where enum constant is declared inside Enum type.
The EnumMap is not synchronized.
All keys of each EnumMap instance must be keys of a single Enum type.
Iterators returned by the collection views are inconsistent. They will never throw 
ConcurrentModificationException, and they may or may not show the effects of any modifications to the map 
that occur while the iteration is in progress.
Java EnumMap implementation provides constant-time performance for the basic operations (like get and put).
Internal workings of an EnumMap#
When an EnumMap instance is created, it is mandatory to pass the type of Enum that will be stored in this EnumMap. 
When we create the instance, then two arrays, keyUniverse and vals, are initialized. The size of both these 
arrays is equal to the number of elements in the Enum. The keyUniverse array stores the elements of the Enum, and
 vals array stores the values corresponding to the keys. The ith element is the value to which universe[i] is 
 currently mapped, it’s null if it isn’t mapped to anything, or NULL if it’s mapped to null.

When an element is inserted into an EnumMap, the index of the element that is being inserted is calculated. 
Let’s say we have an Enum as shown below:

public enum FRUITS {
       APPLE, BANANA, ORANGE
}
If we try to store BANANA in the EnumMap, the index of BANANA is 1. So the value will be stored at vals[1].

Similarly, if we need to get a value for a key, then we will get the index of that key and then get the value
 using the vals[index] method.

As you can see, there is no need to calculate any hashcode in an EnumMap, and each bucket contains only one element.
 This makes it very efficient compared to a HashMap.

Creating an EnumMap#
There are three constructors available to create an instance of an EnumMap. Let’s discuss all three of them.

Constructor taking the key type as input#
There is no no-arg constructor in EnumMap because while creating an EnumMap, the type of the Enum that will 
be stored must be known. The reason is that based on the number of fields in the Enum, the array size is decided 
while. So, this constructor takes the type of Enum as input. The syntax of creating an EnumMap. So this constructor
    takes the type of Enum as input. The syntax of creating an EnumMap using this constructor is as seen below:

EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
Constructor taking another EnumMap as parameter#
When an EnumMap is created using another EnumMap, then an enum map is created with the same key type as the specified 
EnumMap, initially containing the same mappings (if any). The EnumMap that is passed as a parameter can be empty.

Constructor taking another Map as a parameter#
This creates an enum map initialized from the specified map. If the specified map is an EnumMap instance, this 
constructor behaves identically to the constructor discussed above. Otherwise, the specified map must contain 
at least one mapping (in order to determine the new enum map’s key type).

Since all other operations such as insert, fetch, update, etc., are the same as the other Map implementations, we
 will just look at an example here instead of discussing each of them again.

In the below example, we have created a DayOfWeek Enum that will be used to store the week’s day and how many hours
 a person worked on that day.

 import java.util.EnumMap;
import java.time.DayOfWeek;

public class EnumMapDemo {
    
    public static void main(String args[]) {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        
        // Putting records in EnumMap
        enumMap.put(DayOfWeek.MONDAY, 5);
        enumMap.put(DayOfWeek.WEDNESDAY, 23);
        
        // Fetching the value from MONDAY
        System.out.println(enumMap.get(DayOfWeek.MONDAY));
        
        // Removing MONDAY from the Map
        enumMap.remove(DayOfWeek.MONDAY);
    }
}

Output
-----
5

Searching an Array
--------------------
Arrays is a class in the java.utils package that contains various methods for manipulating 
arrays (such as sorting and searching). This class also contains a static factory that allows arrays to be 
seen as a list. The methods in this class throw a NullPointerException if the specified array reference is null.

Searching an element in an array
----------------------------------
The Arrays class provides the binarySearch() method to search for a particular element in an array.
 There are a lot of overloaded binarySearch() methods to handle all the primitive types. 
 Some of the important points to note about the binarySearch() method are:

The array that is passed to the method should be sorted. If the array is not sorted, then the result is undefined.

This method returns the index where the element is present in the array. If the element is not present in the 
array, then the index of the first element greater than the key is returned.

If the array contains multiple elements with the specified value, there is no guarantee which one will be found.

ClassCastException is thrown if the search key is not comparable to the elements of the array.

As the name suggests, the binarySearch() method uses the binary search algorithm to search for an element in
\ the array. It is far better than a linear search. The complexity of the linear search algorithm is O(n), whereas
the complexity of the binary search algorithm is O(log n).

The below example shows how we can use the binarySearch() method to search an element in an integer array.

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {
    
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int index = Arrays.binarySearch(numbers, 4);

        System.out.println("The index of element 4 in the array is " + index);

    }
}

Output
---------
The index of element 4 in the array is 3


It is possible that we may not need to search the entire array. In that case, we can provide 
the start and end index of the elements in the array that needs to be searched.

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {
    
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int index = Arrays.binarySearch(numbers, 5, 9, 4);

        System.out.println("The index of element 4 in the array is " + index);

        index = Arrays.binarySearch(numbers, 1, 5, 4);

        System.out.println("The index of element 4 in the array is " + index);

    }
}

Output
---------
The index of element 4 in the array is -6
The index of element 4 in the array is 3

Searching a custom class object in an array
---------------------------------------------
Let’s say we have created an Employee class and we have an array of Employee objects. 
We want to check if a particular Employee object is present in the array or not.

We will pass the employee array and the object that we need to search to the binarySearch() method as shown 
in the below example.

The below example will not compile because our Employee class does not implement the Comparable interface. 
For the search to be successful it is necessary that the objects we have stored in the array should be comparable.

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {
        Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
                new Employee(126, "Tom") };

        int index = Arrays.binarySearch(employees, new Employee(124, "Roy"));

        System.out.println("The index of employee in the array is " + index);

    }

}
Output
------------
ArraysDemo.java:6: error: cannot find symbol
        Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
        ^
  symbol:   class Employee
  location: class ArraysDemo
ArraysDemo.java:6: error: cannot find symbol
        Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
                                     ^
  symbol:   class Employee
  location: class ArraysDemo
ArraysDemo.java:6: error: cannot find symbol
        Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
                                                               ^
  symbol:   class Employee
  location: class ArraysDemo
ArraysDemo.java:6: error: cannot find symbol
        Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
                                                                                         ^
  symbol:   class Employee
  location: class ArraysDemo
ArraysDemo.java:7: error: cannot find symbol
                new Employee(126, "Tom") };
                    ^
  symbol:   class Employee
  location: class ArraysDemo
ArraysDemo.java:9: error: cannot find symbol
        int index = Arrays.binarySearch(employees, new Employee(124, "Roy"));
                                                       ^
  symbol:   class Employee
  location: class ArraysDemo
6 errors


We have two options to fix this issue. Either our class should implement the Comparable interface or we 
should pass a Comparator implementation while calling the binarySearch() method.

In the below example, we are passing the Comparator implementation while calling the binarySearch() method.

ArraysDemo.java
-----------------
import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {
        Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
                new Employee(126, "Tom") };

        int index = Arrays.binarySearch(employees, new Employee(124, "Roy"), (emp1, emp2) -> emp1.empId - emp2.empId);

        System.out.println("The index of employee object in the array is " + index);

    }

}

Employee.java
-------------
public class Employee {

    int empId;
    String empName;

    public Employee(int empId, String empName) {
        super();
        this.empId = empId;
        this.empName = empName;
    }

}

Output
-------
The index of employee object in the array is 1


Sorting an Array
-------------------
The Arrays class has a sort() method that is used to sort the arrays of objects and primitives. 
If we are sorting a primitive array, then quicksort is used. And if we are sorting an object array, then
 merge sort is used.

Although quicksort is faster in both cases, it is not a stable algorithm. Merge sort is a stable 
algorithm, so it is used in the case of sorting an object array. In the case of the primitive array, we
 don’t care about stability, so quicksort is used.

Stable sorting algorithms are algorithms that maintain the relative order of equal elements. For example, we 
have an array [1,4,6,8,6], which we need to sort. Now after sorting this array, the result is [1,4,6,6,8]. 
Although there are two sixes in the array, we don’t care which six came first in the sorted array. But in 
the case of an object array, the relative order of elements also matters. If two objects are the same in an 
object array, then their relative order should be the same in the sorted array.

The sort method has two variants:

1.sort(array) – sorts the full array into ascending order
2.sort(array, fromIndex, toIndex) – sorts only the elements from fromIndex to toIndex.

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {

        Integer[] numbers = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
        Arrays.sort(numbers);

        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}

Output
------
2 9 10 12 15 17 32 48 76 79 


Sorting an array in parallel
-------------------------------
In Java 8, a new method parallelSort() was introduced to sort the arrays parallelly. 
Unlike sort(), which sorts data sequentially using a single thread, parallelSort() uses a parallel sort-merge 
sorting algorithm. It breaks the array into sub-arrays that are themselves sorted and then merged.

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {

        Integer[] numbers = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
        Arrays.parallelSort(numbers);

        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}

Output
------
2 9 10 12 15 17 32 48 76 79 

This method uses the ForkJoin pool for executing parallel tasks. 
The array is sorted parallelly only when certain conditions are met. 
If the array size is less than or equal to 8192 or the processor has only one core, then the
 sequential dual-pivot Quicksort algorithm is used. Otherwise, it uses a parallel sort.

 Copying an Array
 -------------------
Lets discuss how we can create a copy of an array using the copyOf() method.

If we need to create copies of our array, then we can use the copyOf() method from the Arrays class. 
We need to provide the array that needs to be copied and the new array’s size as a parameter.

The below example shows how to create a copy of an array where the copied array size is the same as the
 original array. If the new array’s size is greater than the original array, then the remaining positions 
 are filled with zeros.

 import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] newArray = Arrays.copyOf(numbers, numbers.length);

        System.out.println("The copied array is: ");

        for (int i : newArray) {
            System.out.print(i + " ");
        }

        int[] newArrayBiggerSize = Arrays.copyOf(numbers, 20);
        System.out.println();
        System.out.println("The copied array is: ");

        for (int i : newArrayBiggerSize) {
            System.out.print(i + " ");
        }
    }
}

Output
----------
The copied array is: 
1 2 3 4 5 6 7 8 9 10 
The copied array is: 
1 2 3 4 5 6 7 8 9 10 0 0 0 0 0 0 0 0 0 0 

It is possible that we may only want to copy a part of our original array.
 In that case, we can use the copyOfRange() method. This method takes three arguments: the original 
 array, the from index (which is inclusive), and a to index (which is exclusive).

 import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int[] newArray = Arrays.copyOfRange(numbers, 0, 5);

        System.out.println("The copied array is: ");

        for (int i : newArray) {
            System.out.println(i);
        }
    }
}

Output
------
The copied array is: 
1
2
3
4
5

Have you ever wondered what would happen if we create a copy of an array that contains objects of a custom class?

If we change the object in the original array, will it be changed in the copied array?

Let’s try to answer these questions using an example. In the below example, we have created an 
array of two Employee objects. Then we created a copy of this array. We will see what happens when one of
 the Employee objects is changed in the original array.

 Employee.java
 ----------------
 public class Employee {

    int empId;
    String empName;

    public Employee(int empId, String empName) {
        super();
        this.empId = empId;
        this.empName = empName;
    }

}

ArraysDemo.java
------------------
import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {

        // Creating an Array of Employee objects.
        Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Ryan") };

        // Creating the copy of Array.
        Employee[] copiedArray = Arrays.copyOf(employees, 2);

        // Changing the name of first employee in original array.
        employees[0] = new Employee(123, "Changed Name");

        // Printing the name of first employee in original array.
        System.out.println(employees[0].empName);

        // Printing the name of first employee in copied array.
        System.out.println(copiedArray[0].empName);
    }
}
Output
=======
Changed Name
Jay
As we can see from the above program’s output, the name did not change in the copied array. 
This means that the copyOf() method creates a deep copy of objects instead of just changing the references.

Additional Operations
----------------------
Converting an Array into a List
--------------------------------
We can convert an array into a list using the asList() method. 
If any changes are made to the resulting list, then changes are propagated to the original array. 
The asList() method returns a fixed-size list, so it is not possible to add or remove elements from this list.

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String args[]) {

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        List<Integer> list = Arrays.asList(numbers);
        
        System.out.print(list);
    }
}
Output
---------
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Checking if two arrays are equal
---------------------------------
We can use the equals() method of the Arrays class to check if the two arrays are equal or not.
 Two arrays are considered equal if both have the same number of elements and all corresponding pairs of elements 
 in the two arrays are equal.

 import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {

        Integer[] numbers1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        boolean isEqual = Arrays.equals(numbers1, numbers2);
        
        
        System.out.print("Checking if two arrays are equal : " + isEqual);
    }
}
Output
-------
Checking if two arrays are equal : true

Filling an array with default value
-------------------------------------
Have you ever encountered a scenario where you need to initialize an array and then fill it with 
some default value?

If yes, then you might have iterated the array and filled each element with the default value. T
his task can be made simple using the fill() method of the Arrays class. This method takes an array and
 a default value as input. It then assigns the default value to each element of the array.

 import java.util.Arrays;

public class ArraysDemo {

    public static void main(String args[]) {

        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Arrays.fill(numbers, 20);

        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
Output
-------
20 20 20 20 20 20 20 20 20 20 

Finding the Min and Max element
---------------------------------
Finding the minimum element in a Collection
------------------------------------------
The min(Collection c) method can be used to find the minimum element in a Collection. 
The elements present in the Collection must implement the Comparable interface. 
If the elements do not implement the Comparable interface, we can use another overloaded 
method, min(Collection c, Comparator comp). This method takes a Comparator as an argument that is used
 to compare the elements. This method iterates over the entire collection; hence it requires time proportional
  to the size of the collection.

  import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        System.out.println("The minimum element in the List is: " + Collections.min(list));
    }
}

Finding the maximum element in a Collection
--------------------------------------------
The max(Collection c) method can be used to find the maximum element in a Collection. 
The elements present in the Collection must implement the Comparable interface. 
If the elements do not implement the Comparable interface, we can use another overloaded
 method max(Collection c, Comparator comp). This method takes a Comparator as an argument that is 
 used to compare the elements. This method iterates over the entire Collection; hence it requires time 
 proportional to the size of the Collection.

 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(29);
        list.add(75);

        System.out.println("The maximum element in the List is: " + Collections.max(list));
    }
}

Finding the frequency of elements in a Collection
-------------------------------------------------
There is a frequency(Collection c, object o) method that can be used to find the frequency of a given element
 in the Collection. This method iterates the entire Collection so the time complexity is proportional to the 
 size of the collection.

 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(12);
        list.add(9);
        list.add(76);
        list.add(9);
        list.add(75);

        System.out.println("Total number of times,9 is present in the List is: " + Collections.frequency(list, 9));
    }
}

Output
-------
Total number of times,9 is present in the List is: 3


Searching, Filing, and Copying Collection
------------------------------------------
Searching an element in a Collection
-======================================
The binarySearch(List list, T key) method searches the specified list for the specified object using the binary 
search algorithm. The elements added in the List must implement the Comparable interface, and the list must be 
sorted into ascending order before making this call. If it is not sorted, the results are undefined. If the list
 contains multiple elements equal to the specified object, there is no guarantee which one will be found.

If the elements added to our List do not implement the Comparable interface, then we can use another overloaded 
version of binarySearch(List list, T key, Comparator comp), which takes a Comparator for the input as well. 
The list must be sorted into ascending order according to the specified comparator.

If the element is not present in the list, then this method returns a position where the element can be inserted.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(12);
        list.add(34);
        list.add(54);
        list.add(66);
        list.add(76);

        System.out.println("The minimum element in the List is: " + Collections.binarySearch(list, new Integer(222)));
    }
}
Output
--------
The minimum element in the List is: -7


Copying a list into another list
---------------------------------
The copy(List dest, List src) method is used to copy all the elements from a source list to a destination list.
 If the size of the destination list is smaller than the source list, then IndexOutOfBoundsException is thrown. 
 After the operation, the index of each copied element in the destination list will be identical to its index in 
 the source list.

Let’s consider an example to understand this.

List dest = 10,20,30,40,50,60;
List src = 1,2,3;
Collections.copy(dest, src);
After doing the above operation, the dest list will become:

{1,2,3,40,50,60}
So the copy() method does not merge the elements of the two lists.
 It replaces the elements in the destination list from the elements in the source list.

 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(9);
        list1.add(12);
        list1.add(34);
        list1.add(54);
        list1.add(66);
        list1.add(76);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(90);
        list2.add(12);
        list2.add(98);
        list2.add(43);
        
        Collections.copy(list1, list2);

        System.out.println(list1);
    }
}

Output
--------
[90, 12, 98, 43, 66, 76]

Filling a list with a default value
-------------------------------------
The fill(List list, Object obj) method replaces all of the elements of the specified list with the specified
 element. This method is very useful if we want to reset our List to a default value.

 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {

    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(45);

        Collections.fill(list, 10);

        System.out.println(list);
    }
}
Output
-------
[10, 10]

Making Collections Unmodifiable
-------------------------------
Let’s say we have created a collection where we have added some important data. We want others to read 
this data, but they should not be allowed to modify the data in this Collection. The Collections class 
provides certain methods that can be used to make our Collection unmodifiable. These methods return a 
collection in which if someone tries to add or remove an element, then UnsupportedOperationException is thrown.

This feature is particularly useful if our Collection contains some sensitive data. We need to only give read 
access to our data, but we don’t want others to accidentally modify it.

Following is the list of methods available to make Collections unmodifiable:

1.unmodifiableList(List<? extends T> list)
2.unmodifiableSet(Set<? extends T> s)
3.unmodifiableMap(Map<? extends K, ? extends V> m)
4.unmodifiableCollection(Collection<? extends T> c)
5.unmodifiableSortedMap(SortedMap<K,? extends V> m)
6.unmodifiableSortedSet(SortedSet<T> s)
We will not look at examples of each of these methods, as they are essentially the same. 
We will only look at unmodifiableList().

Making ArrayList unmodifiable#
Any List implementation such as an ArrayList or LinkedList can be made unmodifiable by using the 
unmodifiableList(List list) method of the Collections class. If we try to add or remove elements from
 the returned list, then UnsupportedOperationException will be thrown as shown in the below example.

 import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableArrayList {
    
    public static void main(String args[]) {
        List<String> list = new ArrayList<String>();
        list.add("India");
        list.add("USA");
        list.add("Russia");
        
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        // This will throw exception because element can't be added to unmodifiable list.
        unmodifiableList.add("China");
    }
}

Output
--------
Exception in thread "main" java.lang.UnsupportedOperationException
    at java.util.Collections$UnmodifiableCollection.add(Collections.java:1057)
    at UnmodifiableArrayList.main(UnmodifiableArrayList.java:15)


Let’s discuss briefly how the unmodifiableList() method works. 
Basically, the Collections class has a static inner class called UnmodifiableList. 
When we call the unmodifiableList() method, a new instance of UnmodifiableList is returned. 
This class implements the List interface and overrides the operations like add and remove to throw
 UnsupportedOperationException.

Some snippets of the actual code are shown below for your understanding.

    static class UnmodifiableList<E> extends UnmodifiableCollection<E>
                                  implements List<E> {
        private static final long serialVersionUID = -283967356065247728L;

        final List<? extends E> list;

        UnmodifiableList(List<? extends E> list) {
            super(list);
            this.list = list;
        }

        public boolean equals(Object o) {return o == this || list.equals(o);}
        public int hashCode()           {return list.hashCode();}

        public E get(int index) {return list.get(index);}
        public E set(int index, E element) {
            throw new UnsupportedOperationException();
        }
        public void add(int index, E element) {
            throw new UnsupportedOperationException();
        }
        public E remove(int index) {
            throw new UnsupportedOperationException();
        }
        public int indexOf(Object o)            {return list.indexOf(o);}
        public int lastIndexOf(Object o)        {return list.lastIndexOf(o);}
        public boolean addAll(int index, Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void replaceAll(UnaryOperator<E> operator) {
            throw new UnsupportedOperationException();
        }
        @Override
        public void sort(Comparator<? super E> c) {
            throw new UnsupportedOperationException();
        }


        .
        .
        .
        .
                                  }

                                  Making Collections thread-safe
                                  --------------------------------
  Most of the collections discussed up until now, such as ArrayList, LinkedList, HashSet, HashMap, etc., 
  are not thread-safe. If two parallel threads modify any of these collections parallelly, the user can get 
  stale data or ConcurrentModificationException.

We can use thread-safe alternatives such as CopyOnWriteArrayList, ConcurrentHashMap, etc., but what
 if we don’t want to use these alternatives? What if we have already created an ArrayList, and now we want
  to make it thread-safe.

The Collections class provides us with the following methods that can be used to make our existing collection
 thread-safe.

synchronizedCollection(Collection<T> c)
synchronizedList(List<T> list)
synchronizedMap(Map<K,V> m)
synchronizedSet(Set<T> s)
synchronizedSortedMap(SortedMap<K,V> m)
synchronizedSortedSet(SortedSet<T> s)
Making an ArrayList thread-safe
---------------------------------
To make an ArrayList thread-safe we can use the synchronizedList() method. Let’s see how this method works 
internally. The Collections class contains a static inner class called SynchronizedList. The synchronizedList() 
method is called when the object of this class is returned. If you look at the implementation of this class 
below, then you can see that all the methods have been synchronized.

Since all the methods are synchronized, this makes it very slow. So, we should always try to use the 
thread-safe implementations instead of making a collection thread-safe using this method.          

    static class SynchronizedList<E>
        extends SynchronizedCollection<E>
        implements List<E> {
        private static final long serialVersionUID = -7754090372962971524L;

        final List<E> list;

        SynchronizedList(List<E> list) {
            super(list);
            this.list = list;
        }
        SynchronizedList(List<E> list, Object mutex) {
            super(list, mutex);
            this.list = list;
        }

        public boolean equals(Object o) {
            if (this == o)
                return true;
            synchronized (mutex) {return list.equals(o);}
        }
        public int hashCode() {
            synchronized (mutex) {return list.hashCode();}
        }

        public E get(int index) {
            synchronized (mutex) {return list.get(index);}
        }
        public E set(int index, E element) {
            synchronized (mutex) {return list.set(index, element);}
        }
        public void add(int index, E element) {
            synchronized (mutex) {list.add(index, element);}
        }
        public E remove(int index) {
            synchronized (mutex) {return list.remove(index);}
        }
        .
        .
        .
        }

                                        MULTI-THREADING
                                        ---------------
What good is concurrency?#
Understanding of how threading works and knowledge of concurrent programming principles exhibit maturity and technical depth of a candidate and can be an important differentiator in landing a higher leveling offer at a company. First, we have to understand why threading models exist and what good do they provide?

Threads like most computer science concepts arent physical objects. The closest tangible manifestation of threads can be seen in a debugger. The screen-shot below, shows the threads of our program suspended in the debugger.

Suspended threads in a debugger
Suspended threads in a debugger
The simplest example to think of a concurrent system is a single-processor machine running your favorite IDE. Say you edit one of your code files and click save, that clicking of the button will initiate a workflow which will cause bytes to be written out to the underlying physical disk. However, IO is an expensive operation, and the CPU will be idle while bytes are being written out to the disk.

Whilst IO takes place, the idle CPU could work on something useful and here is where threads come in - the IO thread is switched out and the UI thread gets scheduled on the CPU so that if you click elsewhere on the screen, your IDE is still responsive and does not appear hung or frozen.

Threads can give the illusion of multitasking even though at any given point in time the CPU is executing only one thread. Each thread gets a slice of time on the CPU and then gets switched out either because it initiates a task which requires waiting and not utilizing the CPU or it completes its time slot on the CPU. There are much more nuances and intricacies on how thread scheduling works but what we just described, forms the basis of it.

With advances in hardware technology, it is now common to have multi-core machines. Applications can take advantage of these architectures and have a dedicated CPU run each thread.

Benefits of Threads#
Higher throughput, though in some pathetic scenarios it is possible to have the overhead of context switching among threads steal away any throughput gains and result in worse performance than a single-threaded scenario. However such cases are unlikely and an exception, rather than the norm.

Responsive applications that give the illusion of multi-tasking.

Efficient utilization of resources. Note that thread creation is light-weight in comparison to spawning a brand new process. Web servers that use threads instead of creating new processes when fielding web requests, consume far fewer resources.

All other benefits of multi-threading are extensions of or indirect benefits of the above.

Performance Gains via Multi-Threading#
As a concrete example, consider the example code below. The task is to compute the sum of all the integers from 0 to Integer.MAX_VALUE. In the first scenario, we have a single thread doing the summation while in the second scenario we split the range into two parts and have one thread sum for each range. In the end, we add the two half sums to get the combined sum. We measure the time taken for each scenario and print it.

class Demonstration {
    public static void main( String args[] ) throws InterruptedException {
        SumUpExample.runTest();
    }
}

class SumUpExample {

    long startRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumUpExample(long startRange, long endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public void add() {

        for (long i = startRange; i <= endRange; i++) {
            counter += i;
        }
    }

    static public void twoThreads() throws InterruptedException {

        long start = System.currentTimeMillis();
        SumUpExample s1 = new SumUpExample(1, MAX_NUM / 2);
        SumUpExample s2 = new SumUpExample(1 + (MAX_NUM / 2), MAX_NUM);

        Thread t1 = new Thread(() -> {
            s1.add();
        });

        Thread t2 = new Thread(() -> {
            s2.add();
        });

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    static public void oneThread() {

        long start = System.currentTimeMillis();
        SumUpExample s = new SumUpExample(1, MAX_NUM );
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }


    public static void runTest() throws InterruptedException {

        oneThread();
        twoThreads();

    }
}

Output
-----------
Single thread final count = 2305843008139952128 took 2076
Two threads final count = 2305843008139952128 took 1395


In my run, I see the two threads scenario run within 652 milliseconds whereas the single thread scenario runs in 886 milliseconds. You may observe different numbers but the time taken by two threads would always be less than the time taken by a single thread. The performance gains can be many folds depending on the availability of multiple CPUs and the nature of the problem being solved. However, there will always be problems that don't yield well to a multi-threaded approach and may very well be solved efficiently using a single thread.

Problems with Threads#
However, as it is said, there's no free lunch in life. The premium for using threads manifests in the following forms:

Usually very hard to find bugs, some that may only rear head in production environments
Higher cost of code maintenance since the code inherently becomes harder to reason about
Increased utilization of system resources. Creation of each thread consumes additional memory, CPU cycles for book-keeping and waste of time in context switches.
Programs may experience slowdown as coordination amongst threads comes at a price. Acquiring and releasing locks adds to program execution time. Threads fighting over acquiring locks cause lock contention.
With this backdrop lets delve into more details of concurrent programming about which you are likely to be quizzed in an interview.

Program vs Process vs Thread
-------------------------------
Program#
========
A program is a set of instructions and associated data that resides on the disk and is loaded by the 
operating system to perform some task. An executable file or a python script file are examples of programs. 
In order to run a program, the operating system's kernel is first asked to create a new process, which is an'
 environment in which a program executes.

Process#
========
A process is a program in execution. A process is an execution environment that consists of instructions, 
user-data, and system-data segments, as well as lots of other resources such as CPU, memory, address-space,
 disk and network I/O acquired at runtime. A program can have several copies of it running at the same time but
 a process necessarily belongs to only one program.

Thread#
========
Thread is the smallest unit of execution in a process. A thread simply executes instructions serially. 
A process can have multiple threads running as part of it. Usually, there would be some state associated with
 the process that is shared among all the threads and in turn each thread would have some state private to itself.
  The globally shared state amongst the threads of a process is visible and accessible to all the threads, and 
  special attention needs to be paid when any thread tries to read or write to this global shared state. 
  There are several constructs offered by various programming languages to guard and discipline the access to
this global state, which we will go into further detail in upcoming lessons.

Caveats#
Note a program or a process are often used interchangeably but most of the times the intent is to refer to a process.

There's also the concept of "multiprocessing" systems, where multiple processes get scheduled on more than one CPU. Usually, this requires hardware support where a single system comes with multiple cores or the execution takes place in a cluster of machines. Processes don't share any resources amongst themselves whereas threads of a process can share the resources allocated to that particular process, including memory address space. However, languages do provide facilities to enable inter-process communication.



Counter Program#
Below is an example highlighting how multi-threading necessitates caution when accessing shared data amongst threads. Incorrect synchronization between threads can lead to wildly varying program outputs depending on in which order threads get executed.

Consider the below snippet of code

1. int counter = 0;
2.
3. void incrementCounter() {
4.   counter++;
5. }
The increment on line 4 is likely to be decompiled into the following steps on a computer:

Read the value of the variable counter from the register where it is stored
Add one to the value just read
Store the newly computed value back to the register
The innocuous looking statement on line 4 is really a three step process!

Now imagine if we have two threads trying to execute the same function incrementCounter then one of the ways the execution of the two threads can take place is as follows:

Lets call one thread as T1 and the other as T2. Say the counter value is equal to 7.

T1 is currently scheduled on the CPU and enters the function. It performs step A i.e. reads the value of the variable from the register, which is 7.

The operating system decides to context switch T1 and bring in T2.

T2 gets scheduled and luckily gets to complete all the three steps A, B and C before getting switched out for T1. It reads the value 7, adds one to it and stores 8 back.

T1 comes back and since its state was saved by the operating system, it still has the stale value of 7 that it read before being context switched. It doesn't know that behind its back the value of the variable has been updated. It unfortunately thinks the value is still 7, adds one to it and overwrites the existing 8 with its own computed 8. If the threads executed serially the final value would have been 9.

The problems should be apparent to the astute reader. Without properly guarding access to mutable variables or data-structures, threads can cause hard to find to bugs.

Since the execution of the threads can't be predicted and is entirely up to the operating system, we can't make any assumptions about the order in which threads get scheduled and executed.

Thread unsafe class#
Take a minute to go through the following program. It increments a counter and decrements it an equal number of times. The final value of the counter should be zero, however, if you run the program enough times, you'll sometimes get the correct zero value, and at others, you'll get a non-zero value. We sleep the threads to give them a chance to run in a non-deterministic order.

import java.util.Random;

class DemoThreadUnsafe {

    // We'll use this to randomly sleep our threads
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String args[]) throws InterruptedException {

        // create object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // setup thread1 to increment the badCounter 200 times
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.increment();
                    DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
                }
            }
        });

        // setup thread2 to decrement the badCounter 200 times
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrement();
                    DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
                }
            }
        });

        // run both threads
        thread1.start();
        thread2.start();

        // wait for t1 and t2 to complete.
        thread1.join();
        thread2.join();

        // print final value of counter
        badCounter.printFinalCounterValue();
    }

    public static void sleepRandomlyForLessThan10Secs() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }
}

class ThreadUnsafeCounter {

    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    void printFinalCounterValue() {
        System.out.println("counter is: " + count);
    }
}

Output
2.22s
counter is: 0


Concurrency vs Parallelism
---------------------------
Introduction#
Concurrency and Parallelism are often confused to refer to the ability of a system to run multiple distinct programs at the same time. Though the two terms are somewhat related yet they mean very different things. To clarify the concept, we'll borrow a juggler from a circus to use as an analogy. Consider the juggler to be a machine and the balls he juggles as processes.

Serial Execution#
When programs are serially executed, they are scheduled one at a time on the CPU. Once a task gets completed, the next one gets a chance to run. Each task is run from the beginning to the end without interruption. The analogy for serial execution is a circus juggler who can only juggle one ball at a time. Definitely not very entertaining!

Concurrency#
A concurrent program is one that can be decomposed into constituent parts and each part can be executed out of order or in partial order without affecting the final outcome. A system capable of running several distinct programs or more than one independent unit of the same program in overlapping time intervals is called a concurrent system. The execution of two programs or units of the same program may not happen simultaneously.

A concurrent system can have two programs in progress at the same time where progress doesn't imply execution. One program can be suspended while the other executes. Both programs are able to make progress as their execution is interleaved. In concurrent systems, the goal is to maximize throughput and minimize latency. For example, a browser running on a single core machine has to be responsive to user clicks but also be able to render HTML on screen as quickly as possible. Concurrent systems achieve lower latency and higher throughput when programs running on the system require frequent network or disk I/O.

The classic example of a concurrent system is that of an operating system running on a single core machine. Such an operating system is concurrent but not parallel. It can only process one task at any given point in time but all the tasks being managed by the operating system appear to make progress because the operating system is designed for concurrency. Each task gets a slice of the CPU time to execute and move forward.

Going back to our circus analogy, a concurrent juggler is one who can juggle several balls at the same time. However, at any one point in time, he can only have a single ball in his hand while the rest are in flight. Each ball gets a time slice during which it lands in the juggler's hand and then is thrown back up. A concurrent system is in a similar sense juggling several processes at the same time.

Parallelism#
A parallel system is one which necessarily has the ability to execute multiple programs at the same time. Usually, this capability is aided by hardware in the form of multicore processors on individual machines or as computing clusters where several machines are hooked up to solve independent pieces of a problem simultaneously. Remember an individual problem has to be concurrent in nature, that is portions of it can be worked on independently without affecting the final outcome before it can be executed in parallel.

In parallel systems the emphasis is on increasing throughput and optimizing usage of hardware resources. The goal is to extract out as much computation speedup as possible. Example problems include matrix multiplication, 3D rendering, data analysis, and particle simulation.

Revisiting our juggler analogy, a parallel system would map to at least two or more jugglers juggling one or more balls. In the case of an operating system, if it runs on a machine with say four CPUs then the operating system can execute four tasks at the same time, making execution parallel. Either a single (large) problem can be executed in parallel or distinct programs can be executed in parallel on a system supporting parallel execution.

Concurrency vs Parallelism#
From the above discussion it should be apparent that a concurrent system need not be parallel, whereas a parallel system is indeed concurrent. Additionally, a system can be both concurrent and parallel e.g. a multitasking operating system running on a multicore machine.

Concurrency is about dealing with lots of things at once. Parallelism is about doing lots of things at once. Last but not the least, you'll find literature describing concurrency as a property of a program or a system whereas parallelism as a runtime behaviour of executing multiple tasks.

We end the lesson with an analogy, frequently quoted in online literature, of customers waiting in two queues to buy coffee. Single-processor concurrency is akin to alternatively serving customers from the two queues but with a single coffee machine, while parallelism is similar to serving each customer queue with a dedicated coffee machine.



Cooperative Multitasking vs Preemptive Multitasking
--------------------------------------------------------
Introduction#
A system can achieve concurrency by employing one of the following multitasking models:

Preemptive Multitasking

Cooperative Multitasking

Preemptive Multitasking#
In preemptive multitasking, the operating system preempts a program to allow another waiting task to run on the CPU. Programs or threads can't decide how long for or when they can use the CPU. The operating system’s scheduler decides which thread or program gets to use the CPU next and for how much time. Furthermore, scheduling of programs or threads on the CPU isn’t predictable. A thread or program once taken off of the CPU by the scheduler can't determine when it will get on the CPU next. As a consequence, if a malicious program initiates an infinite loop, it only hurts itself without affecting other programs or threads. Lastly, the programmer isn't burdened to decide when to give up control back to the CPU in code.

Cooperative Multitasking#
Cooperative Multitasking involves well-behaved programs to voluntarily give up control back to the scheduler so that another program can run. A program or thread may give up control after a period of time has expired or if it becomes idle or logically blocked. The operating system’s scheduler has no say in how long a program or thread runs for. A malicious program can bring the entire system to a halt by busy waiting or running an infinite loop and not giving up control. The process scheduler for an operating system implementing cooperative multitasking is called a cooperative scheduler. As the name implies, the participating programs or threads are required to cooperate to make the scheduling scheme work.

Cooperative vs Preemptive#
Early versions of both Windows and Mac OS used cooperative multitasking. Later on preemptive multitasking was introduced in Windows NT 3.1 and in Mac OS X. However, preemptive multitasking has always been a core feature of Unix based systems.

Synchronous vs Asynchronous
----------------------------
Synchronous#
Synchronous execution refers to line-by-line execution of code. If a function is invoked, the program execution waits until the function call is completed. Synchronous execution blocks at each method call before proceeding to the next line of code. A program executes in the same sequence as the code in the source code file. Synchronous execution is synonymous to serial execution.

Asynchronous#
Asynchronous (or async) execution refers to execution that doesn't block when invoking subroutines. Or if you prefer the more fancy Wikipedia definition: Asynchronous programming is a means of parallel programming in which a unit of work runs separately from the main application thread and notifies the calling thread of its completion, failure or progress. An asynchronous program doesn’t wait for a task to complete and can move on to the next task.

In contrast to synchronous execution, asynchronous execution doesn't necessarily execute code line by line, that is instructions may not run in the sequence they appear in the code. Async execution can invoke a method and move onto the next line of code without waiting for the invoked function to complete or receive its result. Usually, such methods return an entity sometimes called a future or promise that is a representation of an in-progress computation. The program can query for the status of the computation via the returned future or promise and retrieve the result once completed. Another pattern is to pass a callback function to the asynchronous function call which is invoked with the results when the asynchronous function is done processing. Asynchronous programming is an excellent choice for applications that do extensive network or disk I/O and spend most of their time waiting. As an example, Javascript enables concurrency using AJAX library's asynchronous method calls. In non-threaded environments, asynchronous programming provides an alternative to threads in order to achieve concurrency and fall under the cooperative multitasking model.

Asynchronous programming support in Java has become a lot more robust starting with Java 8, however, the topic is out of scope for this course so we only mention it in passing.

I/O Bound vs CPU Bound
---------------------
I/O Bound vs CPU Bound#
We write programs to solve problems. Programs utilize various resources of the computer systems on which they run. For instance a program running on your machine will broadly require:

CPU Time

Memory

Networking Resources

Disk Storage

Depending on what a program does, it can require heavier use of one or more resources. For instance, a program that loads gigabytes of data from storage into main memory would hog the main memory of the machine it runs on. Another can be writing several gigabytes to permanent storage, requiring abnormally high disk i/o.

CPU Bound#
Programs which are compute-intensive i.e. program execution requires very high utilization of the CPU (close to 100%) are called CPU bound programs. Such programs primarily depend on improving CPU speed to decrease program completion time. This could include programs such as data crunching, image processing, matrix multiplication etc.

If a CPU bound program is provided a more powerful CPU it can potentially complete faster. Eventually, there is a limit on how powerful a single CPU can be. At this point, the recourse is to harness the computing power of multiple CPUs and structure your program code in a way that can take advantage of the multiple CPU units available. Say we are trying to sum up the first 1 million natural numbers. A single-threaded program would sum in a single loop from 1 to 1000000. To cut down on execution time, we can create two threads and divide the range into two halves. The first thread sums the numbers from 1 to 500000 and the second sums the numbers from 500001 to 1000000. If there are two processors available on the machine, then each thread can independently run on a single CPU in parallel. In the end, we sum the results from the two threads to get the final result. Theoretically, the multithreaded program should finish in half the time that it takes for the single-threaded program. However, there will be a slight overhead of creating the two threads and merging the results from the two threads.

Multithreaded programs can improve performance in cases where the problem lends itself to being divided into smaller pieces that different threads can work on independently. This may not always be true though.

I/O Bound#
I/O bound programs are the opposite of CPU bound programs. Such programs spend most of their time waiting for input or output operations to complete while the CPU sits idle. I/O operations can consist of operations that write or read from main memory or network interfaces. Because the CPU and main memory are physically separate a data bus exists between the two to transfer bits to and fro. Similarly, data needs to be moved between network interfaces and CPU/memory. Even though the physical distances are tiny, the time taken to move the data across is big enough for several thousand CPU cycles to go waste. This is why I/O bound programs would show relatively lower CPU utilization than CPU bound programs.

Caveats#
Both types of programs can benefit from concurrent architectures. If a program is CPU bound we can increase the number of processors and structure our program to spawn multiple threads that individually run on a dedicated or shared CPU. For I/O bound programs, it makes sense to have a thread give up CPU control if it is waiting for an I/O operation to complete so that another thread can get scheduled on the CPU and utilize CPU cycles. Different programming languages come with varying support for multithreading. For instance, Javascript is single-threaded, Java provides full-blown multithreading and Python is sort of multithreaded as it can only have a single thread in running state because of its global interpreter lock (GIL) limitation. However, all three languages support asynchronous programming models which is another way for programs to be concurrent (but not parallel).

For completeness we should mention that there are also memory-bound programs that depend on the amount of memory available to speed up execution.

Throughput vs Latency
-----------------------
Throughput#
Throughput is defined as the rate of doing work or how much work gets done per unit of time. If you are an Instagram user, you could define throughput as the number of images your phone or browser downloads per unit of time.

Latency#
Latency is defined as the time required to complete a task or produce a result. Latency is also referred to as response time. The time it takes for a web browser to download Instagram images from the internet is the latency for downloading the images.

Throughput vs Latency#
The two terms are more frequently used when describing networking links and have more precise meanings in that domain. In the context of concurrency, throughput can be thought of as time taken to execute a program or computation. For instance, imagine a program that is given hundreds of files containing integers and asked to sum up all the numbers. Since addition is commutative each file can be worked on in parallel. In a single-threaded environment, each file will be sequentially processed but in a concurrent system, several threads can work in parallel on distinct files. Of course, there will be some overhead to manage the state including already processed files. However, such a program will complete the task much faster than a single thread. The performance difference will become more and more apparent as the number of input files increases. The throughput in this example can be defined as the number of files processed by the program in a minute. And latency can be defined as the total time taken to completely process all the files. As you observe in a multithreaded implementation throughput will go up and latency will go down. More work gets done in less amount of time. In general, the two have an inverse relationship.

Critical Sections & Race Conditions
----------------------------------
A program is a set of instructions being executed, and multiple threads of a program can be executing different sections of the program code. However, caution should be exercised when threads of the same program attempt to execute the same portion of code as explained in the following paragraphs.

Critical Section#
Critical section is any piece of code that has the possibility of being executed concurrently by more than one thread of the application and exposes any shared data or resources used by the application for access.

Race Condition#
Race conditions happen when threads run through critical sections without thread synchronization. The threads "race" through the critical section to write or read shared resources and depending on the order in which threads finish the "race", the program output changes. In a race condition, threads access shared resources or program variables that might be worked on by other threads at the same time causing the application data to be inconsistent.

As an example consider a thread that tests for a state/condition, called a predicate, and then based on the condition takes subsequent action. This sequence is called test-then-act. The pitfall here is that the state can be mutated by the second thread just after the test by the first thread and before the first thread takes action based on the test. A different thread changes the predicate in between the test and act. In this case, action by the first thread is not justified since the predicate doesn't hold when the action is executed.

Consider the snippet below. We have two threads working on the same variable randInt. The modifier thread perpetually updates the value of randInt in a loop while the printer thread prints the value of randInt only if randInt is divisible by 5. If you let this program run, you'll notice some values get printed even though they aren't divisible by 5 demonstrating a thread unsafe version of test-then-act.

Example Thread Race#
The below program spawns two threads. One thread prints the value of a shared variable whenever the shared variable is divisible by 5. A race condition happens when the printer thread executes a test-then-act if clause, which checks if the shared variable is divisible by 5 but before the thread can print the variable out, its value is changed by the modifier thread. Some of the printed values aren't divisible by 5 which verifies the existence of a race condition in the code.

import java.util.*;

class Demonstration {

    public static void main(String args[]) throws InterruptedException {
          RaceCondition.runTest();
    }
}

class RaceCondition {

    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {

        int i = 1000000;
        while (i != 0) {
            if (randInt % 5 == 0) {
                if (randInt % 5 != 0)
                  System.out.println(randInt);
            }
            i--;
        }
    }

    void modifier() {

        int i = 1000000;
        while (i != 0) {
            randInt = random.nextInt(1000);
            i--;
        }
    }

    public static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });

        
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
Output
-------
231
249
473
448
354
238
899
519
469



Even though the if condition on line 19 makes a check for a value which is divisible by 5 and only then prints randInt. It is just after the if check and before the print statement i.e. in-between lines 19 and 21, that the value of randInt is modified by the modifier thread! This is what constitutes a race condition.

For the impatient, the fix is presented below where we guard the read and write of the randInt variable using the RaceCondition object as the monitor. 
Don't fret if the solution doesn't make sense for now, it would, once we cover various topics in the lessons ahead.
import java.util.*;

class Demonstration {

    public static void main(String args[]) throws InterruptedException {
          RaceCondition.runTest();
    }
}

class RaceCondition {

    int randInt;
    Random random = new Random(System.currentTimeMillis());

    void printer() {

        int i = 1000000;
        while (i != 0) {
            synchronized(this) {
              if (randInt % 5 == 0) {
                  if (randInt % 5 != 0)
                    System.out.println(randInt);
              }
            }
            i--;
        }
    }

    void modifier() {

        int i = 1000000;
        while (i != 0) {
            synchronized(this) {
              randInt = random.nextInt(1000);
              i--;
            }
        }
    }

    public static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });

        
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

Deadlocks, Liveness & Reentrant Locks
-------------------------------------
Logical follies committed in multithreaded code, while trying to avoid race conditions and guarding critical sections, can lead to a host of subtle and hard to find bugs and side-effects. Some of these incorrect usage patterns have their names and are discussed below.

DeadLock#
Deadlocks occur when two or more threads aren't able to make any progress because the resource required by the first thread is held by the second and the resource required by the second thread is held by the first.

Liveness#
Ability of a program or an application to execute in a timely manner is called liveness. If a program experiences a deadlock then it's not exhibiting liveness.

Live-Lock#
A live-lock occurs when two threads continuously react in response to the actions by the other thread without making any real progress. The best analogy is to think of two persons trying to cross each other in a hallway. John moves to the left to let Arun pass, and Arun moves to his right to let John pass. Both block each other now. John sees he's blocking Arun again and moves to his right and Arun moves to his left seeing he's blocking John. They never cross each other and keep blocking each other. This scenario is an example of a livelock. A process seems to be running and not deadlocked but in reality, isn't making any progress.

Starvation#
Other than a deadlock, an application thread can also experience starvation, when it never gets CPU time or access to shared resources. Other greedy threads continuously hog shared system resources not letting the starving thread make any progress.

Deadlock Example#
void increment(){
 
  acquire MUTEX_A
  acquire MUTEX_B
    // do work here
  release MUTEX_B
  release MUTEX_A
    
}


void decrement(){
  
  acquire MUTEX_B
  acquire MUTEX_A
    // do work here
  release MUTEX_A
  release MUTEX_B
    
}

The above code can potentially result in a deadlock. Note that deadlock may not always happen, but for certain execution sequences, deadlock can occur. Consider the below execution sequence that ends up in a deadlock:

T1 enters function increment

T1 acquires MUTEX_A

T1 gets context switched by the operating system

T2 enters function decrement

T2 acquires MUTEX_B

both threads are blocked now
Thread T2 can't make progress as it requires MUTEX_A which is being held by T1. Now when T1 wakes up, it can't make progress as it requires MUTEX_B and that is being held up by T2. This is a classic text-book example of a deadlock.

You can come back to the examples presented below as they require an understanding of the synchronized keyword that we cover in later sections. Or you can just run the examples and observe the output for now to get a high-level overview of the concepts we discussed in this lesson.

If you run the code snippet below, you'll see that the statements for acquiring locks: lock1 and lock2 print out but there's no progress after that and the execution times out. In this scenario, the deadlock occurs because the locks are being acquired in a nested fashion.

class Demonstration {

    public static void main(String args[]) {
        Deadlock deadlock = new Deadlock();
        try {
            deadlock.runTest();
        } catch (InterruptedException ie) {
        }
    }
}

class Deadlock {

    private int counter = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    Runnable incrementer = new Runnable() {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    incrementCounter();
                    System.out.println("Incrementing " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    };

    Runnable decrementer = new Runnable() {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    decrementCounter();
                    System.out.println("Decrementing " + i);
                }
            } catch (InterruptedException ie) {
            }

        }
    };

    public void runTest() throws InterruptedException {

        Thread thread1 = new Thread(incrementer);
        Thread thread2 = new Thread(decrementer);

        thread1.start();
        // sleep to make sure thread 1 gets a chance to acquire lock1
        Thread.sleep(100);
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Done : " + counter);
    }

    void incrementCounter() throws InterruptedException {
        synchronized (lock1) {
            System.out.println("Acquired lock1");
            Thread.sleep(100);

            synchronized (lock2) {
                counter++;
            }
        }
    }

    void decrementCounter() throws InterruptedException {
        synchronized (lock2) {
            System.out.println("Acquired lock2");
            
            Thread.sleep(100);
            synchronized (lock1) {
                counter--;
            }
        }
    }
}


Output
30.44s
Acquired lock1
Acquired lock2

Execution Timed Out!

Reentrant Lock#
Re-entrant locks allow for re-locking or re-entering of a synchronization lock. This can be best explained with an example. Consider the NonReentrant class below.

Take a minute to read the code and assure yourself that any object of this class if locked twice in succession would result in a deadlock. The same thread gets blocked on itself, and the program is unable to make any further progress. If you click run, the execution would time-out.

If a synchronization primitive doesn't allow reacquisition of itself by a thread that has already acquired it, then such a thread would block as soon as it attempts to reacquire the primitive a second time.

class Demonstration {

    public static void main(String args[]) throws Exception {
        NonReentrantLock nreLock = new NonReentrantLock();

        // First locking would be successful
        nreLock.lock();
        System.out.println("Acquired first lock");
      
        // Second locking results in a self deadlock 
        System.out.println("Trying to acquire second lock");      
        nreLock.lock();
        System.out.println("Acquired second lock");
    }
}

class NonReentrantLock {

    boolean isLocked;

    public NonReentrantLock() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {

        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}


Setting-up Threads
---------------------
Creating Threads#
To use threads, we need to first create them. In the Java language framework, there are multiple ways of setting up threads.

Runnable Interface#
When we create a thread, we need to provide the created thread code to execute, or in other words we need to tell the thread what task to execute. The code can be provided as an object of a class that implements the Runnable interface. As the name implies, the interface forces the implementing class to provide a run method which in turn is invoked by the thread when it starts.

The runnable interface is the basic abstraction to represent a logical task in Java.

class Demonstration {
    public static void main( String args[] ) {
        Thread t = new Thread(new Runnable() {

            public void run() {
                System.out.println("Say Hello");
            }
        });
        t.start();
    }
}

Output
--------
Say Hello


We defined an anonymous class inside the Thread class’s constructor and an instance of it is instantiated and passed into the Thread object. Personally, I feel anonymous classes decrease readability and would prefer to create a separate class implementing the Runnable interface. An instance of the implementing class can then be passed into the Thread object’s constructor. Let’s see how that could have been done.

class Demonstration {
    public static void main( String args[] ) {
        
        ExecuteMe executeMe = new ExecuteMe();
        Thread t = new Thread(executeMe);
        t.start();
    }
}

class ExecuteMe implements Runnable {
 
  public void run() {
    System.out.println("Say Hello");
  }
  
}
Output
---------
Say Hello
Subclassing Thread class#
The second way to set up threads is to subclass the Thread class itself as shown below.
class Demonstration {
    public static void main( String args[] ) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        executeMe.join();
      
    }
}

class ExecuteMe extends Thread {
  
  @Override
  public void run() {
    System.out.println("I ran after extending Thread class");
  }
  
}
Output
--------
I ran after extending Thread class

The con of the second approach is that one is forced to extend the Thread class which limits code’s flexibility. Passing in an object of a class implementing the Runnable interface may be a better choice in most cases.


Basic Thread Handling
-------------------
Joining Threads#
A thread is always created by another thread except for the main application thread. Study the following code snippet. The innerThread is created by the thread which executes the main method. You may wonder what happens to the innerThread if the main thread finishes execution before the innerThread is done?
class Demonstration {
    public static void main( String args[] ) throws InterruptedException {
        
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.setDaemon(true);
        innerThread.start();
    }
}

class ExecuteMe implements Runnable {
 
  public void run() {
    while (true) {
      System.out.println("Say Hello over and over again.");
      try {
        Thread.sleep(500);
      } catch (InterruptedException ie) {
        // swallow interrupted exception
      }
    }
  }
}
        Thread innerThread = new Thread(executeMe);
        innerThread.start();
        innerThread.join();
If we didn’t execute join on innerThread and let the main thread continue after innerThread was spawned then the innerThread may get killed by the JVM upon main thread’s completion.

Daemon Threads#
A daemon thread runs in the background but as soon as the main application thread exits, all daemon threads are killed by the JVM. A thread can be marked daemon as follows:

innerThread.setDaemon(true);
Note that in case a spawned thread isn’t marked as a daemon then even if the main thread finishes execution, JVM will wait for the spawned thread to finish before tearing down the process.

Sleeping Threads#
A thread can be made dormant for a specified period using the sleep method. However, be wary to not use sleep as a means for coordination among threads. It is a common newbie mistake. Java language framework offers other constructs for thread synchronization that’ll be discussed later.
class SleepThreadExample {
    public static void main( String args[] ) throws Exception {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.start();
        innerThread.join();
        System.out.println("Main thread exiting.");
    }
    static class ExecuteMe implements Runnable {

        public void run() {
            System.out.println("Hello. innerThread going to sleep");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                // swallow interrupted exception
            }
        }
    }
}
Output
-------
Hello. innerThread going to sleep
Main thread exiting.

In the above example, the innerThread is made to sleep for 1 second and from the output of the program, one can see that main thread exits only after innerThread is done processing. If we remove the join statement on line-6, then the main thread may print its statement before innerThread is done executing.

Interrupting Threads#
In the previous code snippets, we wrapped the calls to join and sleep in try/catch blocks. Imagine a situation where if a rogue thread sleeps forever or goes into an infinite loop, it can prevent the spawning thread from moving ahead because of the join call. Java allows us to force such a misbehaved thread to come to its senses by interrupting it. An example appears below.

If you execute the above code, you’ll see no output. That is because the main thread exits right after starting the innerThread. Once it exits, the JVM also kills the spawned thread. On line 6 we mark the innerThread thread as a daemon thread, which we’ll talk about shortly, and is responsible for innerThread being killed as soon as the main thread completes execution. Do bear in mind, that if the main thread context switches just after executing Line 7, we may see some output from the innerThread, till the main thread is context switched back in and exits.

If we want the main thread to wait for the innerThread to finish before proceeding forward, we can direct the main thread to suspend its execution by calling <code join method on the innerThread object right after we start the innerThread. The change would look like the following.

class HelloWorld {
    public static void main( String args[] ) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread innerThread = new Thread(executeMe);
        innerThread.start();

        // Interrupt innerThread after waiting for 5 seconds
        System.out.println("Main thread sleeping at " + +System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        innerThread.interrupt();
        System.out.println("Main thread exiting at " + +System.currentTimeMillis() / 1000);
    }
  
    static class ExecuteMe implements Runnable {

        public void run() {
            try {
                // sleep for a thousand minutes
                System.out.println("innerThread goes to sleep at " + System.currentTimeMillis() / 1000);
                Thread.sleep(1000 * 1000);
            } catch (InterruptedException ie) {
                System.out.println("innerThread interrupted at " + +System.currentTimeMillis() / 1000);
            }
        }
    }  
  
}
Output
-------
Main thread sleeping at 1655031932
innerThread goes to sleep at 1655031932
Main thread exiting at 1655031937


Executor Framework
-------------------
reating and running individual threads for small applications is acceptable however if you are writing an enterprise-grade application with several dozen threads then you'll likely need to offload thread management in your application to library classes which free a developer from worrying about thread house-keeping.

Task#
A task is a logical unit of work. Usually, a task should be independent of other tasks so that it can be completed by a single thread. A task can be represented by an object of a class implementing the Runnable interface. We can consider HTTP requests being fielded by a web-server as tasks that need to be processed. A database server handling client queries can similarly be thought of as independent tasks.

Executor Framework#
In Java, the primary abstraction for executing logical tasks units is the Executor framework and not the Thread class. The classes in the Executor framework separate out:

Task Submission
Task Execution
The framework allows us to specify different policies for task execution. Java offers three interfaces, which classes can implement to manage thread lifecycle. These are:

Executor Interface
ExecutorService
ScheduledExecutorService
The Executor interface forms the basis for the asynchronous task execution framework in Java.

You don't need to create your own executor class as Java's java.util.concurrent package offers several types of executors that are suitable for different scenarios. However, as an example, we create a dumb executor which implements the Executor Interface.

import java.util.concurrent.Executor;
class ThreadExecutorExample {
    
  public static void main( String args[] ) {
     DumbExecutor myExecutor = new DumbExecutor();
     MyTask myTask = new MyTask();
     myExecutor.execute(myTask);        
  }
   
  static class DumbExecutor implements Executor {
    // Takes in a runnable interface object
    public void execute(Runnable runnable) {
      Thread newThread = new Thread(runnable);
      newThread.start();
    }
  }
  
  static class MyTask implements Runnable {
    public void run() {      
      System.out.println("Mytask is running now ...");
    } 
  }
  
}

Output
---------
Mytask is running now ...

The Executor requires implementing classes to define a method execute(Runnable runnable) which takes in an object of interface Runnable. Fortunately, we don't need to define complex executors as Java already provides several that we'll explore in following chapters.

Executor Implementations
-----------------------

Executors are based on consumer-producer patterns. The tasks we produce for processing are consumed by threads. To better our understanding of how threads behave, imagine you are hired by a hedge fund on Wall Street and you are asked to design a method that can process client purchase orders as soon as possible. Let's see what are the possible ways to design this method.

Sequential Approach#
The method simply accepts an order and tries to execute it. The method blocks other requests till it has completed processing the current request.

 void receiveAndExecuteClientOrders() {

        while (true) {
            Order order = waitForNextOrder();
            order.execute();
        }
    }
You'll write the above code if you have never worked with concurrency. It sequentially processes each buy order and will not be responsive or have acceptable throughput.

Unbounded Thread Approach#
A newbie would fix the code above like so:

    void receiveAndExecuteClientOrdersBetter() {

        while (true) {
            final Order order = waitForNextOrder();

            Thread thread = new Thread(new Runnable() {

                public void run() {
                    order.execute();
                }
            });
            
            thread.start();
        }
    }
The above approach is an improvement over the sequential approach. The program now accepts an order and spawns off a thread to handle the order execution. The problem, however, is that now the application spawns off an unlimited number of threads. Creating threads without bound is not a wise approach for the following reasons:

Thread creation and teardown isn't for free.
Active threads consume memory even if they are idle. If there are less number of processors than threads then several of them will sit idle tying up memory.
There is usually a limit imposed by JVM and the underlying OS on the number of threads that can be created.
Note that the above improvement may still make the application unresponsive. Imagine if several hundred requests are received between the time it takes for the method to receive an order request and spawn off a thread to deal with the request. In such a scenario, the method will end up with a growing backlog of requests and may cause the program to crash.

The next lesson introduces Threadpools which mitigate several of the issues we discussed here.
innerThread interrupted at 1655031937


Thread Pools
-------------

Thread Pools#
Thread pools in Java are implementations of the Executor interface or any of its sub-interfaces. Thread pools allow us to decouple task submission and execution. We have the option of exposing an executor's configuration while deploying an application or switching one executor for another seamlessly.

A thread pool consists of homogenous worker threads that are assigned to execute tasks. Once a worker thread finishes a task, it is returned to the pool. Usually, thread pools are bound to a queue from which tasks are dequeued for execution by worker threads.

A thread pool can be tuned for the size of the threads it holds. A thread pool may also replace a thread if it dies of an unexpected exception. Using a thread pool immediately alleviates from the ails of manual creation of threads.

There's no latency when a request is received and processed by a thread because no time is lost in creating a thread.

The system will not go out of memory because threads are not created without any limits

Fine tuning the thread pool will allow us to control the throughput of the system. We can have enough threads to keep all processors busy but not so many as to overwhelm the system.

The application will degrade gracefully if the system is under load.

Below is the updated version of the stock order method using a thread pool.

    void receiveAndExecuteClientOrdersBest() {

        int expectedConcurrentOrders = 100;
        Executor executor = Executors.newFixedThreadPool(expectedConcurrentOrders);

        while (true) {
            final Order order = waitForNextOrder();

            executor.execute(new Runnable() {

                public void run() {
                    order.execute();
                }
            });
        }
    }
In the above code we have used the factory method exposed by the Executors class to get an instance of a thread pool. We discuss the different type of thread pools available in Java in the next section.

Types of Thread Pools
----------------------
Java has preconfigured thread pool implementations that can be instantiated using the factory methods of the Executors class. The important ones are listed below:

newFixedThreadPool: This type of pool has a fixed number of threads and any number of tasks can be submitted for execution. Once a thead finishes a task, it can reused to execute another task from the queue.

newSingleThreadExecutor: This executor uses a single worker thread to take tasks off of queue and execute them. If the thread dies unexpectedly, then the executor will replace it with a new one.

newCachedThreadPool: This pool will create new threads as required and use older ones when they become available. However, it'll terminate threads that remain idle for a certain configurable period of time to conserve memory. This pool can be a good choice for short-lived asynchronous tasks.

newScheduledThreadPool: This pool can be used to execute tasks periodically or after a delay.

There is also another kind of pool which we'll only mention in passing as it's not widely used: ForkJoinPool. A prefconfigured version of it can be instantiated using the factory method Executors.newWorkStealingPool(). These pools are used for tasks which fork into smaller subtasks and then join results once the subtasks are finished to give an uber result. It's essentially the divide and conquer paradigm applied to tasks.

Using thread pools we are able to control the order in which a task is executed, the thread in which a task is executed, the maximum number of tasks that can be executed concurrently, maximum number of tasks that can be queued for execution, the selection criteria for rejecting tasks when the system is overloaded and finally actions to take before or after execution of tasks.

Executor Lifecycle#
An executor has the following stages in its lify-cycle:

Running

Shutting Down

Terminated

As mentioned earlier, JVM can't exit unless all non-daemon thread have terminated. Executors can be made to shutdown either abruptly or gracefully. When doing the former, the executor attempts to cancel all tasks in progress and doesn't work on any enqueued ones, whereas when doing the latter, the executor gives a chance for tasks already in execution to complete but also completes the enqueued tasks. If shutdown is initiated then the executor will refuse to accept new tasks and if any are submitted, they can be handled by providing a RejectedExecutionHandler.

An Example: Timer vs ScheduledThreadPool
---------------------------------------------
As an example, we'll compare and contrast using a timer and a pool to schedule periodic or delayed threads.

Timer#
The achilles' heel of the Timer class is its use of a single thread to execute submitted tasks. Timer has a single worker thread that attempts to execute all user submitted tasks. Issues with this approach are detailed below:

If a task misbehaves and never terminates, all other tasks would not be executed

If a task takes too long to execute, it can block timely execution of other tasks. Say two tasks are submitted and the first is scheduled to execute after 100ms and the second is scheduled to execute after 500ms. Now if the first task takes 5 minutes to execute then the second task would get delayed by 5 minutes rather than the intended 500ms.

In the above example, if the second task is scheduled to run periodically after every 500ms, then when it finally gets a chance to run after 5 minutes, it'll run for all the times it missed its turns, one after the other, without any delay between consecutive runs.

import java.util.Timer;
import java.util.TimerTask;

class Demonstration {
    public static void main( String args[] ) throws Exception {
        Timer timer = new Timer();
        TimerTask badTask = new TimerTask() {

            @Override
            public void run() {

                // run forever
                while (true)
                    ;

            }
        };

        TimerTask goodTask = new TimerTask() {

            @Override
            public void run() {

                System.out.println("Hello I am a well-behaved task");

            }
        };

        timer.schedule(badTask, 100);
        timer.schedule(goodTask, 500);

        // By three seconds, both tasks are expected to have launched
        Thread.sleep(3000);
    }
}
--------------
Bad Use of Timer


Below is another example of Timer's shortcoming. We schedule a task which throws a runtime exception and ends up killing the lone worker thread Timer possess. The subsequent submission of a task reports the timer is canceled when in fact the previously submitted task crashed the Timer.

import java.util.Timer;
import java.util.TimerTask;

class Demonstration {
    public static void main( String args[] ) throws Exception{
        
        Timer timer = new Timer();
        TimerTask badTask = new TimerTask() {

            @Override
            public void run() {
                throw new RuntimeException("Something Bad Happened");
            }
        };

        TimerTask goodTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Hello I am a well-behaved task");
            }
        };

        timer.schedule(badTask, 10);
        Thread.sleep(500);
        timer.schedule(goodTask, 10);
    }
}

Output
2.11s
Exception in thread "Timer-0" java.lang.RuntimeException: Something Bad Happened
    at Demonstration$1.run(main.java:12)
    at java.util.TimerThread.mainLoop(Timer.java:555)
    at java.util.TimerThread.run(Timer.java:505)
Exception in thread "main" java.lang.IllegalStateException: Timer already cancelled.
    at java.util.Timer.sched(Timer.java:397)
    at java.util.Timer.schedule(Timer.java:193)
    at Demonstration.main(main.java:26)

    Callable Interface
    ------------------

    Callable Interface#
In the previous sections we used the Runnable interface as the abstraction for tasks that were submitted to the executor service. The Runnable interface's sole run method doesn't return a value, which is a handicap for tasks that don't want to write results to global or shared datastructures. The interface Callable allows such tasks to return results. Let's see the definition of the interface first.

public interface Callable<V> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    V call() throws Exception;
}
Note the interface also allows a task to throw an exception. A task goes through the various stages of its life which include the following:

created

submitted

started

completed

Let's say we want to compute the sum of numbers from 1 to n. Our task should accept an integer n and ' 
spit out the sum. Below are two ways to implement our task.

    class SumTask implements Callable<Integer> {

        int n;

        public SumTask(int n) {
            this.n = n;
        }

        public Integer call() throws Exception {

            if (n <= 0)
                return 0;

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            
            return sum;
        }
    }

Or we could take advantage of the anonymous class feature in the Java language to declare our task like so:

      final int n = 10
      Callable<Integer> sumTask = new Callable<Integer>() {
        
          public Integer call() throws Exception {
              int sum = 0;
              for (int i = 1; i <= n; i++)
                sum += i;
              return sum;
          }
      };
Now we know how to represent our tasks using the Callable interface. In the next section 
we'll explore the Future interface which will help us manage a task's lifecycle as well as retrieve
 results from it.


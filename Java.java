

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

---------------------------------------------------------------------------

										Design Patterns
									    ===============
*Design patterns are general reusable solutions to commonly occurring problems in software design. 

*In software engineering, a design pattern is a general repeatable solution to a commonly occurring 
problem in software design. 

*A design pattern isn't a finished design that can be transformed directly into code. 
It is a description or template for how to solve a problem that can be used in many different situations.

Design patterns can be broadly categorized into three main types:

a. Creational Patterns:
-----------------------
1.Singleton Pattern
2.Factory Method Pattern
3.Abstract Factory Pattern
4.Builder Pattern
5.Prototype Pattern

b. Structural Patterns:
-----------------------
1.Adapter Pattern
3.Bridge Pattern
3.Composite Pattern
4.Decorator Pattern
5.Facade Pattern
6.Flyweight Pattern
7.Proxy Pattern

c .Behavioral Patterns:
----------------------

1.Observer Pattern
2.Strategy Pattern
3.Command Pattern
4.Template Method Pattern
5.Iterator Pattern
6.State Pattern
7.Chain of Responsibility Pattern
8.Visitor Pattern
9.Mediator Pattern
10.Interpreter Pattern
11.Memento Pattern

Till now these are the main design patterns.
====================================================================================================================
In addition to these main types, there are also other types of patterns that are sometimes mentioned:

Concurrency Patterns:
---------------------

Producer-Consumer Pattern
Read-Write Lock Pattern
Thread Pool Pattern

Architectural Patterns:
-----------------------
Model-View-Controller (MVC) Pattern
Model-View-Presenter (MVP) Pattern
Model-View-ViewModel (MVVM) Pattern
Layered Architecture Pattern
Repository Pattern
Dependency Injection Pattern
Event-Driven Architecture Pattern

Enterprise Patterns:
----------------------

Data Access Object (DAO) Pattern
Service Locator Pattern
Business Delegate Pattern
Front Controller Pattern
Value Object Pattern





Strategy Pattern:-
__________________
# Define a family of algorithms, encapsulate each one, and make them interchangeable.

# Strategy lets the algorithm vary independently from the clients that use it. 

# The Strategy Design Pattern is a behavioral design pattern in Java that allows you to 
define a family of algorithms, encapsulate each algorithm as a separate class, and make them 
interchangeable at runtime.

# It enables the client to select the algorithm dynamically, without being tightly coupled to the 
 specific implementation.

Here's how the Strategy Design Pattern works:

Define the Strategy interface:
------------------------------
 Create an interface that declares the common methods for all the concrete 
strategy classes. This interface represents the strategies or algorithms that can be used interchangeably.

Implement the concrete strategies:
-----------------------------------
 Implement the strategy interface with different concrete classes, each 
representing a specific algorithm or strategy.

Use composition to associate the strategy:
-------------------------------------------
 In the context class (client class), include a reference to the 
strategy interface. This allows the context class to use different strategies interchangeably.

Client interaction:
-------------------
The client interacts with the context class through its interface, without knowing the specific 
strategy implementation used. The client can dynamically switch between different strategies based on the requirements.

Here's a simplified example in Java to illustrate the Strategy Design Pattern:
=================================================================================
// Step 1: Define the Strategy interface
interface SortingStrategy {
    void sort(int[] array);
}

// Step 2: Implement the concrete strategies
class BubbleSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        // Perform bubble sort algorithm
        System.out.println("Sorting using bubble sort strategy");
    }
}

class QuickSortStrategy implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        // Perform quick sort algorithm
        System.out.println("Sorting using quick sort strategy");
    }
}

// Step 3: Use composition to associate the strategy
class Sorter {
    private SortingStrategy strategy;

    public Sorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortArray(int[] array) {
        strategy.sort(array);
    }
}

// Step 4: Client interaction
public class Main {
    public static void main(String[] args) {
        int[] array = { 5, 2, 7, 1, 4 };

        Sorter sorter = new Sorter(new BubbleSortStrategy());
        sorter.sortArray(array); // Output: Sorting using bubble sort strategy

        sorter.setStrategy(new QuickSortStrategy());
        sorter.sortArray(array); // Output: Sorting using quick sort strategy
    }
}
========================================================================================
In this example, we have a SortingStrategy interface that defines a sort method. 
The BubbleSortStrategy and QuickSortStrategy classes implement this interface and 
provide their own sorting algorithms.

The Sorter class represents the context and holds a reference to the 
SortingStrategy interface. It has a sortArray method that delegates the sorting operation 
to the strategy object.

The client can create a Sorter object with an initial strategy (e.g., BubbleSortStrategy), and 
later it can dynamically switch the strategy by calling the setStrategy method. 
The client interacts with the Sorter object, without being aware of the specific sorting 
algorithm being used.

Overall, the Strategy Design Pattern promotes code reusability, flexibility, and easy 
extensibility by encapsulating algorithms and allowing them to be selected dynamically at runtime.
**************************************************************************************************
The Strategy Design Pattern is a versatile pattern that can be applied in various scenarios where different
algorithms or strategies need to be interchangeable.s
Here are a few examples of where the Strategy pattern can be useful:

Sorting Algorithms: In an application that requires sorting functionality, such as a collection of data, 
the Strategy pattern can be used to implement different sorting algorithms like bubble sort, merge sort, 
quick sort, etc. Each algorithm can be encapsulated in a separate strategy class, and the client can 
dynamically choose the desired sorting strategy.

File Compression: When working with file compression, different compression algorithms like ZIP, GZIP, or
 RAR can be implemented as separate strategies. The client can select the compression algorithm to be used
  based on factors like file type, size, or desired compression ratio.

Payment Gateways: In a payment processing system, different payment gateway 
providers (e.g., PayPal, Stripe, Braintree) can be implemented as separate strategies. 
The client can select the appropriate payment gateway strategy based on factors like 
user preferences or availability.

Image Filters: In an image processing application, various filters like grayscale, sepia, 
or blur can be implemented as separate strategies. The client can select the desired filter 
strategy to apply to an image dynamically.

Travel Planning: In a travel planning application, different strategies can be used to calculate 
the optimal route based on factors like cost, time, or scenic routes. Each strategy can represent 
a different route-finding algorithm, and the client can choose the strategy that suits their preferences.

========================================================================================
***Thus, whenever we have multiple ways of achieving our goal and we want to keep the  |
flexibility of choosing either one of them, we generally use stratey design pattern.   |
========================================================================================




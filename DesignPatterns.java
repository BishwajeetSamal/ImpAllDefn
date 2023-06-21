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
2.Factory Design Pattern
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

*************************************************************************************************************
*************************************************************************************************************
Factory Design Pattern :-
________________________
# The Factory Design Pattern is a creational design pattern in Java that provides 
an interface for creating objects without specifying their exact classes.

# It encapsulates the object creation logic within a separate factory class, which 
is responsible for creating and returning instances of various related classes.

# It provides a way to delegate the responsibility of object creation to a separate factory class.

In simpler terms, imagine you want to create objects of different types, such as 
Engineer, Doctor, and Teacher, but you don't want the client code to directly instantiate these objects. 
Instead, you want a factory class to handle the object creation based on certain criteria or parameters

Here an example of implementing the Factory Design Pattern using the Engineer, Doctor, and Teacher scenario:
=================================================================================================================
1.Create the Product Interface:
--------------------------------
public interface Profession {
    void introduce();
}

2.Implement the Concrete Products:
-----------------------------------
public class Engineer implements Profession {
    @Override
    public void introduce() {
        System.out.println("I am an engineer.");
    }
}

public class Doctor implements Profession {
    @Override
    public void introduce() {
        System.out.println("I am a doctor.");
    }
}

public class Teacher implements Profession {
    @Override
    public void introduce() {
        System.out.println("I am a teacher.");
    }
}

3.Implement the Factory:
-------------------------
public class ProfessionFactory {
    public Profession createProfession(String professionType) {
        if (professionType.equalsIgnoreCase("engineer")) {
            return new Engineer();
        } else if (professionType.equalsIgnoreCase("doctor")) {
            return new Doctor();
        } else if (professionType.equalsIgnoreCase("teacher")) {
            return new Teacher();
        }
        return null;
    }
}

4.Client Interaction:
---------------------
public class Main {
    public static void main(String[] args) {
        ProfessionFactory factory = new ProfessionFactory();

        Profession engineer = factory.createProfession("engineer");
        engineer.introduce(); // Output: I am an engineer.

        Profession doctor = factory.createProfession("doctor");
        doctor.introduce(); // Output: I am a doctor.

        Profession teacher = factory.createProfession("teacher");
        teacher.introduce(); // Output: I am a teacher.
    }
}
=====================================================================================================
In this example, we have the Profession interface, which defines the common introduce() method for
all concrete professions. The Engineer, Doctor, and Teacher classes implement this interface and 
provide their own implementations of the introduce() method.

The ProfessionFactory class is responsible for creating instances of the concrete professions. 
It provides a createProfession() method that takes a parameter specifying the type of profession to create. 
Based on the parameter, the factory returns an instance of the corresponding concrete profession.

The client code interacts with the ProfessionFactory and creates instances of different professions without 
knowing the specific implementation details of the concrete professions.

Here's an example of an application scenario where the Factory Design Pattern can be applied:
Let's say you are developing an e-commerce application that sells various types of products such as 
electronics, clothing, and furniture. 
Each product category has its own set of attributes and behavior. 
As the application grows, you anticipate the addition of new product categories in the future.
In this case, you can use the Factory Design Pattern to handle the creation of different product objects based 
on the category. The factory class will encapsulate the creation logic and provide a centralized way to 
instantiate the appropriate product objects.

Here's how the Factory Design Pattern can be applied in this scenario:

Define the Product interface or abstract class:
-----------------------------------------------
public interface Product {
    void displayInfo();
}
Implement the Concrete Products:
---------------------------------
public class Electronics implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is an electronics product.");
        // Additional implementation specific to electronics category
    }
}

public class Clothing implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is a clothing product.");
        // Additional implementation specific to clothing category
    }
}

public class Furniture implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is a furniture product.");
        // Additional implementation specific to furniture category
    }
}

// Additional product classes for other categories

Implement the Product Factory:
------------------------------
public class ProductFactory {
    public static Product createProduct(String category) {
        if (category.equalsIgnoreCase("electronics")) {
            return new Electronics();
        } else if (category.equalsIgnoreCase("clothing")) {
            return new Clothing();
        } else if (category.equalsIgnoreCase("furniture")) {
            return new Furniture();
        }
        return null;
    }
}

Client Interaction:
-------------------
public class Main {
    public static void main(String[] args) {
        // ... Application logic ...

        String category = "electronics"; // Example: Category received from user input

        // Create the product object based on the category using the factory
        Product product = ProductFactory.createProduct(category);

        // Display the product information
        if (product != null) {
            product.displayInfo();
        } else {
            System.out.println("Invalid category.");
        }
    }
}

In this example, the Product interface defines the common behavior that all products should have
Each product category, such as Electronics, Clothing, and Furniture, implements this interface and provides 
its own implementation of the displayInfo() method.

The ProductFactory class serves as the factory responsible for creating the product objects. It provides a 
static method, createProduct(), that takes the category as a parameter and returns the corresponding product 
object based on the category.

In the client code, you can receive the product category from user input or any other source. 
Then, using the ProductFactory, you create the specific product object based on the category and 
call the displayInfo() method to show the relevant information about the product.


*************************************************************************************************************
*************************************************************************************************************
Abstract Factory Desing Pattern:-
__________________________________
The Abstract Factory Design Pattern is a creational design pattern that provides an interface for creating
 families of related or dependent objects without specifying their concrete classes.

It allows you to create objects that are part of a specific group or family, without needing to know the exact type
 of each object.

In simpler terms, imagine you are running a pizza restaurant and you offer different types of pizzas such as 
Margherita, Pepperoni, and Veggie.

Each pizza type consists of multiple components like the dough, sauce, cheese, and toppings. 
Now, instead of directly creating each pizza component separately, the Abstract Factory pattern helps you create
 entire families of pizza components together.

The Abstract Factory pattern involves the following key components:

Abstract Factory: This is an interface or abstract class that declares methods for creating the different pizza components.
It defines a common set of creation methods for each component, such as createDough(), createSauce(), createCheese(), and 
createToppings().

Concrete Factories: These are classes that implement the Abstract Factory interface and provide specific implementations 
of the creation methods for each pizza component. For example, you can have a MargheritaFactory, PepperoniFactory, and 
VeggieFactory, each responsible for creating the components specific to their pizza type.

Abstract Products: These are interfaces or abstract classes that represent the different pizza components, such as 
Dough, Sauce, Cheese, and Toppings. Each abstract product defines a common set of methods that the concrete products 
must implement.

Concrete Products: These are classes that implement the Abstract Products and provide specific implementations for 
each pizza component. For example, you can have ThinCrustDough, MarinaraSauce, MozzarellaCheese, and various topping classes.


Lets take an example of Doctor, Teacher, Engineer, TraineeTeacher etc..

Define the Abstract Professional and Trainee interfaces:
---------------------------------------------------------
public interface Professional {
    void introduce();
}

public interface Trainee extends Professional {
    void attendTraining();
}

Implement the Concrete Professionals:
-------------------------------------
public class Teacher implements Professional {
    @Override
    public void introduce() {
        System.out.println("I am a teacher.");
    }
}

public class Doctor implements Professional {
    @Override
    public void introduce() {
        System.out.println("I am a doctor.");
    }
}

public class Engineer implements Professional {
    @Override
    public void introduce() {
        System.out.println("I am an engineer.");
    }
}

public class TraineeTeacher implements Trainee {
    @Override
    public void introduce() {
        System.out.println("I am a trainee teacher.");
    }

    @Override
    public void attendTraining() {
        System.out.println("Attending teaching training.");
    }
}

public class TraineeDoctor implements Trainee {
    @Override
    public void introduce() {
        System.out.println("I am a trainee doctor.");
    }

    @Override
    public void attendTraining() {
        System.out.println("Attending medical training.");
    }
}

Implement the Abstract Factory:
-------------------------------
public interface ProfessionalFactory {
    Professional createProfessional();
    Trainee createTrainee();
}

public class ConcreteProfessionalFactory implements ProfessionalFactory {
    @Override
    public Professional createProfessional(String profession) {
        switch (profession.toLowerCase()) {
            case "teacher":
                return new Teacher();
            case "doctor":
                return new Doctor();
            case "engineer":
                return new Engineer();
            default:
                return null;
        }
    }

    @Override
    public Trainee createTrainee(String profession) {
        switch (profession.toLowerCase()) {
            case "teacher":
                return new TraineeTeacher();
            case "doctor":
                return new TraineeDoctor();
            default:
                return null;
        }
    }
}

Client Interaction:
-------------------
public class Main {
    public static void main(String[] args) {
        ProfessionalFactory factory = new ConcreteProfessionalFactory();

        // Creating professionals
        Professional teacher = factory.createProfessional("teacher");
        teacher.introduce(); // Output: I am a teacher.

        Professional doctor = factory.createProfessional("doctor");
        doctor.introduce(); // Output: I am a doctor.

        Professional engineer = factory.createProfessional("engineer");
        engineer.introduce(); // Output: I am an engineer.

        // Creating trainees
        Trainee traineeTeacher = factory.createTrainee("teacher");
        traineeTeacher.introduce(); // Output: I am a trainee teacher.
        traineeTeacher.attendTraining(); // Output: Attending teaching training.

        Trainee traineeDoctor = factory.createTrainee("doctor");
        traineeDoctor.introduce(); // Output: I am a trainee doctor.
        traineeDoctor.attendTraining(); // Output: Attending medical training.
    }
}

In this example, the Professional interface defines the common behavior for all professionals, while 
the Trainee interface extends the Professional interface and adds the behavior specific to trainees.

The concrete professional classes (Teacher, Doctor, Engineer) and concrete trainee classes 
(TraineeTeacher, TraineeDoctor) implement the respective interfaces and provide their specific implementations.

The ProfessionalFactory interface declares the factory methods createProfessional() and createTrainee() 
to create instances of professionals and trainees, respectively.

*************************************************************************************************************
*************************************************************************************************************

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

*************************************************************************************************************
*************************************************************************************************************


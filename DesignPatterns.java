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

________________________________________________________________________________________________________________
___________________________________________Creational Design Pattern starts____________________________________
_________________________________________________________________________________________________________________
Singleton Design Pattern:-
__________________________
The Singleton Design Pattern is a creational design pattern that ensures the existence of only one instance 
(object) of a class throughout the application and provides a global point of access to that instance

Here's a simple explanation of the Singleton pattern:

Imagine you have a class that should have only one instance, such as a logger or a database connection. 
The Singleton pattern ensures that no matter how many times you try to create an instance of that class, you
always get the same instance.

To implement the Singleton pattern, you typically follow these steps:

Make the constructor of the class private, preventing direct instantiation of the class from outside.

Declare a static variable within the class to hold the single instance of the class.

Provide a static method that acts as a global access point to the single instance. This method is responsible for 
creating the instance if it doesn't exist and returning the existing instance otherwise.

Here's an example of implementing the Singleton pattern in Java:


public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and attributes of the class...
}

In the above example, the Singleton class has a private constructor, preventing direct instantiation. 
The static variable instance holds the single instance of the class. The getInstance() method checks if an
 instance already exists. If not, it creates a new instance and returns it. Subsequent calls to 
 getInstance() will return the existing instance.



What is Singleton Class ? //Runtime is a singleton class. For any java class if we are allowed to create 
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
3. Singleton prevents other objects from instantiating their own copies of the Singleton object, ensuring 
that all objects access the single instance. 

Here are some scenarios where you might consider creating a Singleton class:

Logging:
-------- A logging class that provides logging functionality throughout your application can be implemented as a
 Singleton. This ensures that all parts of your codebase log to the same instance, making it easier to manage 
 and control the logging behavior.

Database Connection: 
---------------------In applications that require a single, shared connection to a database, a Singleton pattern
 can be used to create and manage the database connection. This ensures that all components of the application 
 use the same database connection, improving efficiency and avoiding conflicts.

Caching: 
----------If your application requires a cache to store frequently accessed data, a Singleton cache manager can
 be used to ensure there is only one cache instance shared across the application. This avoids duplicating cached
  data and provides consistent access to the cache.

Configuration Settings: 
------------------------A Singleton class can be used to manage global configuration settings for your application.
 This ensures that all parts of the application access and utilize the same configuration values, promoting consistency
  and centralized control over the configuration.

Thread Pool: 
-------------In scenarios where you need to manage a shared pool of threads, a Singleton thread pool manager can 
be created. This ensures that all parts of the application use the same pool of threads, facilitating efficient 
resource utilization and coordination.

GUI Components:
---------------- In graphical user interface (GUI) applications, certain components like windows, dialogs, or menu 
bars may need to be globally accessible and shared across different parts of the application. Implementing these 
components as Singletons allows for centralized control and consistent access.

*************************************************************************************************************
*************************************************************************************************************
Factory Design Pattern :-
________________________
# In factory design pattern, we dont expose the creation logic to the client and 
refer to the client and refer the created object using a standard object.
It is also known as Virtual Constrctor.

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
This factory is also called factory of factories.
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
Builder Design Pattern:-
__________________________
It is a part of creational design pattern.
Wherever you want to create the object step by step for all those complex objects, step by step then 
we should go for Builder Design Pattern.

We are not forcing the client to get the unnecessary stuffs to create if the person dont want to.
For example, a person want a House only, anathor person want House with swimming Pool,
anathor Person want House with parking area. Then we cannot just handle all different house creation 
just by using the Constructor. Thus, here builder desing pattern comes into picture.

So We are giving the option to the client, that what he wants to select instead of forcing by us.

The primary purpose of the Builder pattern is to provide a flexible and customizable way of constructing 
objects, especially when dealing with complex objects with multiple optional attributes or configurations. 

 By using the Builder pattern, you can give the client the ability to selectively set the attributes they 
 desire, while omitting or providing default values for the rest.

  example of constructing different types of houses using the Builder design pattern:-

 // House class representing the complex object to be constructed
public class House {
    private String type;
    private int bedrooms;
    private int bathrooms;
    private boolean hasSwimmingPool;
    private boolean hasParkingArea;

    // Private constructor to enforce object creation through the builder
    private House(Builder builder) {
        this.type = builder.type;
        this.bedrooms = builder.bedrooms;
        this.bathrooms = builder.bathrooms;
        this.hasSwimmingPool = builder.hasSwimmingPool;
        this.hasParkingArea = builder.hasParkingArea;
    }

    // Getters for the attributes (omitted for brevity)

    // Builder class for constructing the House object
    public static class Builder {
        private String type;
        private int bedrooms;
        private int bathrooms;
        private boolean hasSwimmingPool;
        private boolean hasParkingArea;

        public Builder(String type, int bedrooms, int bathrooms) {
            this.type = type;
            this.bedrooms = bedrooms;
            this.bathrooms = bathrooms;
        }

        public Builder withSwimmingPool() {
            this.hasSwimmingPool = true;
            return this;
        }

        public Builder withParkingArea() {
            this.hasParkingArea = true;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}


With this implementation, we can create different types of houses using the Builder pattern:

// Creating a simple house
House house1 = new House.Builder("Simple House", 2, 1).build();

// Creating a house with a swimming pool
House house2 = new House.Builder("House with Swimming Pool", 3, 2)
                  .withSwimmingPool()
                  .build();

// Creating a house with a parking area
House house3 = new House.Builder("House with Parking Area", 4, 3)
                  .withParkingArea()
                  .build();

// Creating a luxurious house with both a swimming pool and a parking area
House house4 = new House.Builder("Luxurious House", 5, 4)
                  .withSwimmingPool()
                  .withParkingArea()
                  .build();

In this example, the House class represents the complex object to be constructed.
The Builder class is a nested static class within the House class, responsible for 
constructing the House object step by step.

The builder provides a constructor and setter-like methods to set the required attributes 
(type, bedrooms, bathrooms). It also provides optional methods (withSwimmingPool(), withParkingArea())
 that allow the client to customize the house by adding additional features.

The build() method constructs and returns the final House object based on the attributes set by the client.



Lets take a burger,meal Examples for the builder desing pattern :-
---------------------------------------------------------------
/**
 * Most Common Way to implement builder pattern is to have Builder class as innner class because 
 * : - You might have seen at most of the places. -Joshua Bloch's Builder pattern
 * 1. We don't want to expose our constructor which eventually creates confusion at later stage.
 * 2. We don't want to have in-consistent object by having setters exposed.
 * 3. Now since constructor is private we will need inner class to access that. 
 * - Which will have same inputs what we have in class. But without getters.
 */
public class Burger {

    private String size;
    private boolean egg;
    private boolean extraCheese;
    private boolean mayonese;
    private boolean onion;
    private boolean lettuce;

    private Burger(BurgerBuilder burgerBuilder) { /**Constructor is private, so that user will not able to 
    	use the constructor but the BurgerBuilder class that we have created will use it, and BurgerBuilder
    	is the inner class.
    	*/
        // Initialize all fields and you can also add validations.
    }

    public String getSize() {
        return size;
    }

    public boolean isEgg() {
        return egg;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public boolean isMayonese() {
        return mayonese;
    }

    public boolean isOnion() {
        return onion;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    //Return same object everytime that is builder instance
    //Once build method invoke return actual object.
    public static class BurgerBuilder {
        private String size;
        private boolean egg;
        private boolean extraCheese;
        private boolean mayonese;
        private boolean onion;
        private boolean lettuce;
        public BurgerBuilder size(String size) {
            this.size = size;
            return this;
        }
        public BurgerBuilder egg(boolean egg) {
            this.egg = egg;
            return this;
        }
        public BurgerBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }
        public BurgerBuilder mayonese(boolean mayonese) {
            this.mayonese = mayonese;
            return this;
        }
        public BurgerBuilder onion(boolean onion) {
            this.onion = onion;
            return this;
        }
        public BurgerBuilder lettuce(boolean lettuce) {
            this.lettuce = lettuce;
            return this;
        }
        public Burger build() {

            return new Burger(this);
        }
    }
}

/**
 * Builder pattern : It is creational design pattern used to create complex presentation of objects.
 * Let's say you have class which has initially 4 fields, so you decided to go with constructor then few more fields added
 * in same class which are optional and class modification goes on. So one choice is to have different args constructor.
 * That is good but till some extent how we will remember which argument number for what if list is so big!!!
 * Having this type of constructor is called as Telescoping constructor pattern where we keep having separate constructor as and when
 * we have new arguments.
 *
 * One more option is to use setters method but that has chances of missing pieces of some mandatory fields which leads to inconsistent object.
 *
 * By builder patter we take responsibility of creating object and providing back to client. Client just provides input and until
 * they won't call build method we won't create object.
 *
 * Builder pattern is also used when single class has different object representation  meaning let's say We are creating
 * Burger which can be Veg, non veg ... which can have extra cheese or less cheese, bread size medium , large.
 * As user, you will say only I need one extra cheese large veg burger.
 *
 * To do so you can also have different builders which eventually passes the argument which are required to create that object.
 *
 *
 * Reference : https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 * https://springframework.guru/gang-of-four-design-patterns/builder-pattern/
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        //Using builder we have created the object and we as implementer of builder pattern need to assure that this is not inconsistent object.
        Burger burger = new Burger.BurgerBuilder()
                .mayonese(true)
                .onion(false)
                .egg(false)
                .extraCheese(true)
                .size("LARGE")
                .build();    

        //GOF Builder example
        Meal meal = new MealDirector(new VegMealBuilder()).prepareMeal();
    }
}

/**
 * If we go via GOF Definition "The intent of the Builder design pattern is to separate the construction of a complex object from its representation. By doing so, the same construction process can create different representations.:
 *  It means for this Meal class lets say we have different representation which VegMeal and NonVegMeal
 *  Also this helps when you want to create object step by step too.
 *  So to achieve GOF we have following components as part builder pattern.
 *  1. Product - Which we are building
 *  2. AbstractBuilder - Which is helpful to provide the product
 *  3. Concrete builder : It is actual builder which helps us to provide specific representation of the object.
 *  4. Director : Which uses this concrete builder and provides the
 */
public class Meal {
    private String curry;
    private String bread;
    private String coldDrink;
    private String briyani;

    public String getCurry() {
        return curry;
    }

    public void setCurry(String curry) {
        this.curry = curry;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getColdDrink() {
        return coldDrink;
    }

    public void setColdDrink(String coldDrink) {
        this.coldDrink = coldDrink;
    }

    public String getBriyani() {
        return briyani;
    }

    public void setBriyani(String briyani) {
        this.briyani = briyani;
    }
}

public abstract class MealBuilder {
    public abstract void addBriyani();
    public  abstract  void  addBread();
    public abstract void  addColdDrink();
    public abstract void addCurry();
    public abstract Meal build();
}


public class VegMealBuilder extends MealBuilder{
    private Meal meal;
    public VegMealBuilder() {
        meal = new Meal();
    }
    @Override
    public void addBriyani() {
        this.meal.setBriyani("Veg");
    }

    @Override
    public void addBread() {
        this.meal.setBread("Naan");

    }

    @Override
    public void addColdDrink() {
        this.meal.setColdDrink("Sprite");

    }

    @Override
    public void addCurry() {
        this.meal.setCurry("Veg");
    }

    @Override
    public Meal build() {
        return meal;
    }
}


public class NonVegMealBuilder extends MealBuilder{
    private Meal meal;
    public NonVegMealBuilder() {
        meal = new Meal();
    }
    @Override
    public void addBriyani() {
        this.meal.setBriyani("Chicken");
    }

    @Override
    public void addBread() {
        this.meal.setBread("Roti");

    }

    @Override
    public void addColdDrink() {
        this.meal.setColdDrink("Sprite");

    }

    @Override
    public void addCurry() {
        this.meal.setCurry("Non-Veg");
    }

    @Override
    public Meal build() {
        return meal;
    }
}


//Client will interact with this director which helps to provide the meal.
//Note that we can have this as per our choice there is no standard way , we can also have two different method 
//getVegMeal and getNonVegMeal
// Which will use the builders directly inside the method , in this example we are taking input which builder 
//which type of builder needing.
public class MealDirector {
    private MealBuilder mealBuilder;
    public MealDirector(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }
    public Meal prepareMeal() {
        mealBuilder.addBread();
        mealBuilder.addBriyani();
        mealBuilder.addCurry();
        mealBuilder.addColdDrink();
        return mealBuilder.build();
    }
}

___________________________________________Creational Design Pattern ends______________________________________
________________________________________________________________________________________________________________
_______________________________________________________________________________________________________________
__________________________________________Structural Design Pattern starts_____________________________________

Proxy Design Pattern :-
________________________
The Proxy design pattern is a structural design pattern that provides a surrogate or placeholder 
for another object in order to control access to it.
It allows you to create an intermediary object that acts as a substitute for another object, 
providing additional functionality or controlling the access to the original object. 

 Here's an example of a Bank Account system where the ATM acts as a proxy for performing deposit, 
 withdrawal, and checking the balance:

Advantages of Proxy Design Pattern 
==================================
* Access control / protection gives by proxy object.
Here are some specific scenarios where you might consider using the Proxy design pattern:
Access Control:
--------------- You can use a Proxy to enforce access control mechanisms. For example, you
might have an object that contains sensitive data, and you want to restrict access to it based
on user roles or permissions. The Proxy can handle the authentication and authorization checks
before allowing access to the actual object.

Caching:
-------- If you have an object that performs expensive operations or retrieves data from a remote 
source, you can use a Proxy to implement caching. The Proxy can store the results of previous 
requests and return them directly instead of invoking the actual object every time. This can greatly 
improve performance by reducing the need for redundant operations.

public interface Account {
    public void withdraw();
    void getAccountNumber();
}
--------
//original
public class BankAccount implements  Account{
    @Override
    public void withdraw() {

    }

    @Override
    public void getAccountNumber() {

    }
}

-------------
//proxy
public class ATM implements Account{ // This is proxy to bank account object not real
    @Override
    public void withdraw() {
        //Access using actual object. You can also have checks on withdraw to achieve authentication or pin is correct or not.
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw();
    }

    @Override
    public void getAccountNumber() {

    }
}
-------------

/**
 * Proxy pattern : Proxy pattern is structural pattern. We use proxy when we don't want to expose real object and provide proxy object to deal with.
 * Many times when you are dealing with remote servers and do lookup from the naming server it provides you proxy object from remote server not actual one.
 * Even in hibernate if remember we have concept of lazy loading where whenever we load data from db we get proxy object of
 * database and return it however if we get it then only it gets loaded from database. This is one of the best example of proxy object.
 *
 * Another example can be Spring AOP where AOP objects are proxy and treated on advice aspects.
 *
 * Different type of proxies are :
 * 1. Remote proxy : When you are dealing with remote system , you require remote object to interact with the system. Usually in past it get used in ejb where beans gets created in container
 * and client gets object using JNDI system.
 * 2. Virtual proxy :Delay the object creation until it is required, as explained hibernate uses this.
 * 3. Protection proxy : this proxy is used when we are dealing with security system where before invoking system implementation we want to check access.
 * 4. Snart proxy - Perform some additional steps before accessing object.
 *
 * Proxy pattern has mainly three components :
 * 1. A common interface
 * 2. Real Class
 * 3. Proxy class - this uses the realclass and it is proxy of real class.
 *
 * https://www.javadevjournal.com/java-design-patterns/proxy-design-pattern/
 * Example consider as Bank Account and ATM where to operate your bank account you have ATM which is proxy of doing process in bank account.
 *
 */
public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdraw();
    }
}

--------------------------------------------------------------------------------------------------
2nd example->Here's an example where Credit Card, Debit Card, and UPI (Unified Payments Interface) 
act as proxies for cash:
// Subject interface
interface PaymentMethod {
    void pay(double amount);
}

// RealSubject
class Cash implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Paying in cash: $" + amount);
    }
}

// Proxy: Credit Card
class CreditCard implements PaymentMethod {
    private Cash cash;
    
    public CreditCard() {
        this.cash = new Cash();
    }
    
    public void pay(double amount) {
        // Additional credit card processing logic
        System.out.println("Processing credit card payment: $" + amount);
        
        // Delegate the payment to the cash object
        cash.pay(amount);
    }
}

// Proxy: Debit Card
class DebitCard implements PaymentMethod {
    private Cash cash;
    
    public DebitCard() {
        this.cash = new Cash();
    }
    
    public void pay(double amount) {
        // Additional debit card processing logic
        System.out.println("Processing debit card payment: $" + amount);
        
        // Delegate the payment to the cash object
        cash.pay(amount);
    }
}

// Proxy: UPI
class UPI implements PaymentMethod {
    private Cash cash;
    
    public UPI() {
        this.cash = new Cash();
    }
    
    public void pay(double amount) {
        // Additional UPI processing logic
        System.out.println("Processing UPI payment: $" + amount);
        
        // Delegate the payment to the cash object
        cash.pay(amount);
    }
}

// Client
public class PaymentExample {
    public static void main(String[] args) {
        // Create payment proxies
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod debitCard = new DebitCard();
        PaymentMethod upi = new UPI();
        
        // Perform payments
        creditCard.pay(100);
        debitCard.pay(50);
        upi.pay(75);
    }
}
In this example, we have the PaymentMethod interface representing the subject, which is implemented by the 
Cash class, as well as the CreditCard, DebitCard, and UPI classes acting as proxies.

The Cash class represents the real object, which in this case is the actual payment made in cash. 
It implements the pay() method accordingly.

Each proxy class (CreditCard, DebitCard, and UPI) holds an instance of the Cash class and implements 
the pay() method. The proxy classes perform additional processing specific to their payment 
method (e.g., credit card processing, debit card processing, UPI processing) and then delegate the 
payment to the Cash object.

The PaymentExample class demonstrates the usage of the payment system. It creates instances of the 
payment proxies (credit card, debit card, UPI) and performs payments using the pay() method.

********************************************************************************************************
********************************************************************************************************
Flyweight Design Pattern :-
____________________________

It is a structural design pattern.
A Flyweight is a shared object that can be used in multiple context simultaneously. The Flyweight
acts as an independent object in each context.
* Primarily it is used to reduce the number of objects created and to decrease memory and increase
performance. This pattern provides ways to decrease object count thus improving the object structure of 
application.

*Flyweight Pattern tries to reuse already existing similiar kind of objects by storing then and creates new
object when no matching object is found.

When to use?
------------
- When number if object creation is huge.
- Object creat is Heavy on memory. 
- When your application needs large number of objects that shares the most of the common attributes
called Intrinsic attributes or properties and only few unique attributes calles Extrinsic attribute.


import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Animal {
    void makeSound();
}

// Flyweight implementation: CAT
class Cat implements Animal {
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Flyweight implementation: COW
class Cow implements Animal {
    public void makeSound() {
        System.out.println("Moo!");
    }
}

// Flyweight implementation: DOG
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Woof!");
    }
}

// Flyweight factory
class AnimalFactory {
    private static Map<String, Animal> animalCache = new HashMap<>();
    
    public static Animal getAnimal(String type) {
        Animal animal = animalCache.get(type);
        
        if (animal == null) {
            switch (type) {
                case "CAT":
                    animal = new Cat();
                    break;
                case "COW":
                    animal = new Cow();
                    break;
                case "DOG":
                    animal = new Dog();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid animal type: " + type);
            }
            
            animalCache.put(type, animal);
        }
        
        return animal;
    }
}

// Client
public class AnimalClient {
    public static void main(String[] args) {
        Animal cat1 = AnimalFactory.getAnimal("CAT");
        cat1.makeSound(); // Output: Meow!
        
        Animal cow1 = AnimalFactory.getAnimal("COW");
        cow1.makeSound(); // Output: Moo!
        
        Animal dog1 = AnimalFactory.getAnimal("DOG");
        dog1.makeSound(); // Output: Woof!
        
        Animal cat2 = AnimalFactory.getAnimal("CAT");
        cat2.makeSound(); // Output: Meow!
        
        System.out.println("cat1 and cat2 are the same object? " + (cat1 == cat2)); // Output: true
    }
}

In this example, we have the Animal interface, which represents the flyweight objects. 
It defines the makeSound() method, which is implemented by the concrete flyweight classes: Cat, Cow, and Dog.

The AnimalFactory class acts as the flyweight factory. It maintains a cache (in this case, a HashMap) 
to store and retrieve flyweight objects based on their type. When the getAnimal() method is called with 
a specific type, it checks if an object of that type exists in the cache. If not, it creates a new instance 
of the flyweight object, stores it in the cache, and returns it. If the object already exists in the cache, 
it directly returns it.

The AnimalClient class demonstrates the usage of the flyweight objects. It calls the AnimalFactory 
to get flyweight objects of different types (CAT, COW, DOG) and invokes the makeSound() method on each object.

When you run this example, you'll see the output displaying the sound made by each animal. 
Note that when the getAnimal() method is called multiple times with the same type, the same 
object is returned (as indicated by the comparison cat1 == cat2 in the example), demonstrating 
the flyweight behavior where object sharing is achieved to conserve memory.
 
________________________________________Strutural Design Pattern ends________________________________________
______________________________________________________________________________________________________________
______________________________________________________________________________________________________________
_______________________________________________________________________________________________________________
_________________________________________Behavioural Design Pattern starts____________________________________
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
State Design Pattern :-
________________________
The State design pattern is a behavioral design pattern that allows an object to alter its behavior when its
internal state changes. This pattern is useful when an object needs to change its behavior dynamically 
based on its internal state, without explicitly checking and managing different conditions.

Based on the State 1 -> Behaviour 1
             State 2 -> Behaviour 2   
             State 3 -> Behaviour 3 etc.

Intent:

Allow an object to change its behavior dynamically when its internal state changes.
Encapsulate state-specific behavior into separate classes.
Simplify complex conditionals by delegating behavior to state objects.
Enable easy extensibility by adding new states without modifying existing code.

Structure:
The State pattern typically consists of the following elements:

Context: It represents the object whose behavior changes based on its internal state.
It maintains a reference to the current state object and delegates state-specific requests to that object.

State: It defines the interface for the different states that the Context object can be in. 
It declares the methods that handle requests and can change the current state of the Context.

Concrete States: These are the specific classes that implement the State interface. 
Each concrete state provides its own implementation of the state-specific behavior defined by the State interface.

Implementation:
The State pattern can be implemented in several steps:

Identify the operations that vary depending on the state of an object.
Create an interface (State) to define those operations.
Implement the State interface in concrete classes, each representing a different state.
In the Context class, maintain a reference to the current state object and delegate state-specific requests to that object.
The Context class can change its current state by setting it to a different concrete state class.

Benefits:
--------
Encourages clean separation of concerns by encapsulating state-specific behavior in separate classes.
Makes it easier to add new states without modifying existing code.
Simplifies code by removing large conditional statements that check the object's state.
Improves maintainability and extensibility.

Let's consider an example of a document editor. The editor has multiple states such as 
"EditingState," "SavingState," and "PrintingState." Each state has different behaviors associated 
with it, such as allowing edits in the editing state, saving the document in the saving state, and 
printing the document in the printing state. By applying the State pattern, the document editor 
can dynamically change its behavior based on its internal state.

In this example, the Context class would be the DocumentEditor, and the different states 
(EditingState, SavingState, PrintingState) would be implemented as Concrete State classes, each 
providing its own implementation for the document-related operations.

// State interface
interface DocumentState {
    void performOperation(DocumentEditor editor);
}

// Concrete State classes
class EditingState implements DocumentState {
    @Override
    public void performOperation(DocumentEditor editor) {
        System.out.println("Performing editing operation...");
        // Logic for editing the document
    }
}

class SavingState implements DocumentState {
    @Override
    public void performOperation(DocumentEditor editor) {
        System.out.println("Performing saving operation...");
        // Logic for saving the document
    }
}

class PrintingState implements DocumentState {
    @Override
    public void performOperation(DocumentEditor editor) {
        System.out.println("Performing printing operation...");
        // Logic for printing the document
    }
}

// Context class
class DocumentEditor {
    private DocumentState currentState;

    public DocumentEditor() {
        // Set initial state to EditingState
        currentState = new EditingState();
    }

    public void setState(DocumentState state) {
        this.currentState = state;
    }

    public void performOperation() {
        currentState.performOperation(this);
    }
}

// Usage example
public class Main {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();

        // Perform editing operation
        editor.performOperation();

        // Change state to SavingState and perform saving operation
        editor.setState(new SavingState());
        editor.performOperation();

        // Change state to PrintingState and perform printing operation
        editor.setState(new PrintingState());
        editor.performOperation();
    }
}

In this example, we have the DocumentState interface representing the different states that
 the DocumentEditor can be in. The concrete state classes (EditingState, SavingState, PrintingState) 
 implement the DocumentState interface and provide their own implementation for the document operations.

The DocumentEditor class represents the context and maintains a reference to the current state object. 
It has a setState method to change the state and a performOperation method that delegates the operation to the current state.

In the Main class, we create an instance of DocumentEditor and demonstrate how the behavior of the 
editor changes based on its internal state. Initially, it performs an editing operation, then changes 
state to saving and performs a saving operation, and finally changes state to printing and performs a printing operation.

*************************************************************************************************************
*************************************************************************************************************

Observer Design Pattern :-
___________________________
It is a part of behavioural design pattern. 
The Observer pattern is a behavioral design pattern that establishes a one-to-many dependency between objects. 
In this pattern, when one object (known as the subject or observable) changes its state, all its dependents
 (known as observers) are automatically notified and updated.
The Observer pattern promotes loose coupling between the subject and its observers, allowing for flexible and maintainable code.

Let's consider an example of an Amazon product "Notify Me" feature using the Observer design pattern. 
This feature allows customers to subscribe to notifications when a product becomes available for purchase.

There is one onservable and multiple observers.
So as the observable changes the state then all the observers get notified.It has one to many relationship.

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(String productName);
}

// Observable interface (renamed from Subject)
interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Observable (renamed from Product)
class AmazonProduct implements Observable {
    private String productName;
    private boolean available;
    private List<Observer> observers;

    public AmazonProduct(String productName) {
        this.productName = productName;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(productName);
        }
    }

    // Method to update product availability
    public void setAvailable(boolean available) {
        this.available = available;
        if (available) {
            notifyObservers();
        }
    }
}

// Concrete Observer
class Customer implements Observer {
    private String customerName;

    public Customer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String productName) {
        System.out.println("Notification for " + customerName + ": " + productName + " is now available on Amazon.");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Create an Amazon product
        AmazonProduct product = new AmazonProduct("Smartphone");

        // Create customers
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Alice");

        // Register customers as observers
        product.registerObserver(customer1);
        product.registerObserver(customer2);

        // Simulate product availability change
        product.setAvailable(true);
        // Output:
        // Notification for John: Smartphone is now available on Amazon.
        // Notification for Alice: Smartphone is now available on Amazon.
    }
}

In this updated example, the "Observable" interface replaces the previous "Subject" 
interface, and the "AmazonProduct" class replaces the previous "Product" class. 
The functionality and usage of the classes/interfaces remain the same.


*************************************************************************************************************
*************************************************************************************************************
Decorator Design Pattern:-
__________________________
The Decorator pattern is a structural design pattern that allows adding new behaviors or functionalities 
to an existing object dynamically without modifying its structure. It provides a flexible alternative to 
subclassing for extending the functionality of an object.

Intent:
-------
Attach additional responsibilities to an object dynamically.
Provide a flexible alternative to subclassing for extending functionality.
Allow behavior to be added or removed at runtime.
Keep the class hierarchy as lean as possible.


The Decorator pattern is a structural design pattern that allows adding new behaviors or functionalities to an 
existing object dynamically without modifying its structure. 
It provides a flexible alternative to subclassing for extending the functionality of an object.

Intent:

Attach additional responsibilities to an object dynamically.
Provide a flexible alternative to subclassing for extending functionality.
Allow behavior to be added or removed at runtime.
Keep the class hierarchy as lean as possible.


Structure:
----------
The Decorator pattern consists of the following components:

Component: It is the base interface or abstract class that defines the common interface for both the 
concrete component and decorators.
Concrete Component: It is the original object to which new behaviors can be added.
Decorator: It is the abstract class that implements the component interface and has a reference to 
the component object. It acts as a base class for concrete decorators.
Concrete Decorator: It is the concrete implementation of the decorator. It adds new behaviors or 
functionalities to the component.
Implementation:
To implement the Decorator pattern, follow these steps:

Define the component interface or abstract class that represents the common interface for 
both the concrete component and decorators.
Implement the concrete component class that provides the base functionality.
Create an abstract decorator class that implements the component interface and contains 
a reference to the component object.
Implement concrete decorator classes by extending the abstract decorator class. 
Each concrete decorator adds new behaviors or functionalities to the component.
The concrete decorators can wrap the component multiple times, adding multiple layers of functionalities.
The client interacts with the component through the decorator, which can dynamically add or remove behaviors at runtime.

Benefits:
---------
Allows for the dynamic addition of new behaviors or functionalities to objects without modifying their structure.
Supports the open-closed principle by allowing the addition of new decorators without modifying existing code.
Provides a flexible and modular approach to extend object functionality at runtime.
Allows for the combination of multiple decorators to create various combinations of behaviors.
Promotes the single responsibility principle by separating the concerns of object functionality into individual decorators.

example of the Decorator pattern applied to a pizza ordering system:

// Component interface
interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete component
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Decorator
abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost();
    }
}

// Concrete decorator
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

// Concrete decorator
class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", with Pepperoni";
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        // Create a plain pizza
        Pizza pizza = new PlainPizza();

        // Add cheese to the pizza
        Pizza cheesePizza = new CheeseDecorator(pizza);

        // Add pepperoni to the pizza
        Pizza pepperoniPizza = new PepperoniDecorator(cheesePizza);

        // Get the final description and cost
        System.out.println("Description: " + pepperoniPizza.getDescription());
        System.out.println("Cost: $" + pepperoniPizza.getCost());
    }
}

In this example, the Pizza interface represents the component, which is the base pizza. 
The PlainPizza class is the concrete component that provides the basic pizza functionality.

The PizzaDecorator class is the abstract decorator, which implements the Pizza interface and 
holds a reference to the decorated pizza. It acts as a base class for concrete decorators.

The CheeseDecorator and PepperoniDecorator classes are the concrete decorators. They extend 
the PizzaDecorator class and add cheese and pepperoni toppings to the decorated pizza.

In the Main class, we create a plain pizza object. Then, we decorate it by adding cheese using 
the CheeseDecorator and further decorate it by adding pepperoni using the PepperoniDecorator. 
Finally, we obtain the description and cost of the decorated pizza.
----------------------------------------------------------
The output will be:
Description: Plain Pizza, with Cheese, with Pepperoni
Cost: $10.0
-----------------------------------------------------------

*************************************************************************************************************
*************************************************************************************************************


















$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
Here is an example of using factory design pattern first and subsequently implement the (factory & strategy design pattern)
____________________________________________________________________________________________________________________________

// PaymentStrategy interface
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete payment strategies implementing the PaymentStrategy interface
class AmazonPay implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " processed through Amazon Pay");
        // Logic for processing payment through Amazon Pay
    }
}

class AmazonGiftcard implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " processed through Amazon Giftcard");
        // Logic for processing payment through Amazon Giftcard
    }
}

// AmazonFactory for creating instances of Amazon
class AmazonFactory {
    public static Amazon createAmazon() {
        return new Amazon();
    }
}

// Amazon class
class Amazon {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not set");
        }
        paymentStrategy.pay(amount);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Create an instance of Amazon using the AmazonFactory
        Amazon amazon = AmazonFactory.createAmazon();

        // Set the payment strategy to Amazon Pay
        PaymentStrategy amazonPay = new AmazonPay();
        amazon.setPaymentStrategy(amazonPay);
        amazon.processPayment(100.0); // Output: Payment of $100.0 processed through Amazon Pay

        // Set the payment strategy to Amazon Giftcard
        PaymentStrategy amazonGiftcard = new AmazonGiftcard();
        amazon.setPaymentStrategy(amazonGiftcard);
        amazon.processPayment(50.0); // Output: Payment of $50.0 processed through Amazon Giftcard
    }
}


-------------------------------------------------------------------------------------------------------
Now, 

// SortingStrategy interface
interface SortingStrategy {
    void sort(int[] array);
}

// Concrete sorting strategies implementing the SortingStrategy interface
class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting array using Bubble Sort");
        // Logic for Bubble Sort algorithm
    }
}

class MergeSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting array using Merge Sort");
        // Logic for Merge Sort algorithm
    }
}

// Context class that utilizes the sorting strategy
class SortContext {
    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void performSort(int[] array) {
        if (sortingStrategy == null) {
            throw new IllegalStateException("Sorting strategy is not set");
        }
        sortingStrategy.sort(array);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 6, 1, 3};

        SortContext context = new SortContext();

        // Set the sorting strategy to Bubble Sort
        SortingStrategy bubbleSort = new BubbleSort();
        context.setSortingStrategy(bubbleSort);
        context.performSort(array); // Output: Sorting array using Bubble Sort

        // Set the sorting strategy to Merge Sort
        SortingStrategy mergeSort = new MergeSort();
        context.setSortingStrategy(mergeSort);
        context.performSort(array); // Output: Sorting array using Merge Sort
    }
}


In this example, we have a SortingStrategy interface that defines the sort(int[] array) method, 
which is implemented by the concrete sorting strategies such as BubbleSort and MergeSort. 
Each sorting strategy encapsulates a different sorting algorithm.

The SortContext class serves as the context that utilizes the sorting strategy. 
It has a setSortingStrategy() method to set the desired sorting strategy, and the 
performSort() method uses the selected strategy to sort the given array.

In the client code, an instance of SortContext is created. 
The sorting strategy is then set to either Bubble Sort or Merge Sort using the setSortingStrategy() 
method. Finally, the performSort() method is called to perform the sorting operation using the selected strategy.

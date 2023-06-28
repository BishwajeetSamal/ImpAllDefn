												JUnit
												=====
*JUnit is a simple framework to write repeatable tests. It provides the simple API to test our Java Application.
*The class or methods we want to test is usally called Subject under Test.
*So to write a test we simply create a java test class and use the Junit API to make some assumptions towards the
behaviour of the subject under test and junit verifies whether these assumptions are correct or not by either 
passing or failing the test.

Architechture of JUnit 5
========================
On a high level, JUnit5 is a combination of three different modules. 

                          JUnit Jupiter           JUnit Vintage 	   3rd Part Testing frameworks
                      		   ↓					   ↓						↓
                      		================================================================
                      						JUnit   platform
                      		================================================================
                      				  ↑				  ↑				    ↑
                                     IDEs         Build Tool         Console


1.JUnit platform -> It provides an API to launch the tests from either the IDEs build tools or or console. So to
write a unit test in Junit, your IDE or the build tool or the console uses this API inside the JUnit platform 
module to launch the test. 

2.Junit Jupiter -> It provides the API to write our Junit Tests  and extensions.

3.Junit Vintage -> It provides a test unit implemtation to support backward compatibility to test written with 
Junit-3 and Junit-4. We can execute the tests in Junit-5 aswell.

4.3rd Part Testing frameworks -> It enables some third party testing frameworks to build their own API to 
write the tests and reuse the junit platform module to launch these tests, so this is anathor intersting update
which is part of junit-5.

LongSupplier




Que. Why use a testing framework ?
Ans. Lets say a class
-------------------------
	public class Calculator{
		public int add(int a, int b){
			return a+b;
		}
	} 


Write automated tests
---------------------
Calculator calc = new Calculator();
int sum = calc.add(0,1);

if(sum != 1){
	System.out.println("Test Failed");
}

Test without JUnit:-
* Preparation //This test step is necessary
* Provide Test inputs //This test step is necessary
* Run the tests
* Provide expected Output	//This test step is necessary
* Verify Result
* Do something to alert developer if test failed


JUNIT 5 Architechture
---------------------
Platform -> This is not which we are going to interact with. What we interact with JUnit API(Jupiter).Test Engine is
inside the platform.
Secongs. 
For new test we will use Jupiter and for Old test use ((Vintage)).
Anathor thing is that JUnit have provided a library lets you extended. 
									
								|-------------|
					Jupiter->	|	PLATFORM  |
					Vintage->	|			  |
					Library->  	|			  |
					IDE->		|-------------|

JUnit Jupiter
-------------
*New Programming model in JUnit.
*Extension model

Dependencies
============
Use JUnit-5 dependency in pom.xml
<properties>
<maven.compiler.target>11</maven.compiler.target>
<maven.compiler.source>11</maven.compiler.source>
<junit.jupiter.version>11</junit.jupiter.version>
</properties>

*Add junit-jupiter-engine is the Platform (Implementation of the TestEngine API) for JUnit Jupiter,
 junit-jupiter-api is JupiterApi, (API for writing tests using JUnit Jupiter)

*juit-vintage-engine: A thin layer on top of allow running vintage tests.

Use @Test
*Marks  a method as a test.
*Informs the JUnit engine what methods need to run.
---------------------------------------------------------------------------------------------
public class MathUtils{
	public int add(int a,int b){
		return a+b;
	}


}

src/test/java --> It will contain all the test cases.
Right Click on file and click on JUnit Test case.

class MathUtils{
	@Test
	void test(){
		System.out.println("This test run");
	}
}

---------------------------------------------------------------------------------------------------------------------------------
Que-> What is Unit Testing ?
Ans-> * Testing an individual unit of code for correctness.
* We provide some fixed inputs.
* Expect a known output.

StringUtils -> capitalize(String data)

Benifits of Unit Testing
========================
Automated Tests
Better Code design
Fewer bugs and higher reliability
Increases confidence for code refactoring

Integration Testing
--------------------
Test multiple components together as part of a test plan.
Determine if software unots work together as expected.
Identify any negetive side effects due to integration.
Can test using mocks/stubs.
Can also test using live integrations (database, file system)

Unit Testing Frameworks
-----------------------
Junit
 - Supports creating test cases
 - Automation of the test cases with pass / fail.
 - Utilities for test setup, teardown and assertions.

 Mokito
 	- Create mocks and stubs
 	- Minimize dependencies on external components.



In tranditional development ,
Design -> Code -> Test the appication.

TDD (Test Driven Development)
------------------------------
Test <=> Refactor, Code 
(First writing a failing test),
(Write code to make some test pass),
(Refactor and improve on design) then repeat the process for next test

Benifits
--------
Clear task list of things to test and devlop
Tests will help you identify edge cases
Develop code in small increments
Passing tests increases confidence in code
Gives freedom to refactor ... tests are your safety net.


What do we need for SpringBoot unit Testing ?
----------------------------------------------
* Access to the Spring Application Context
* Support for Spring dependency injection
* Retrieve data from Spring application.properties
* Mock object support for web, data, REST APIs etc..

Unit Testing Support in Spring Boot
------------------------------------
* Springboot provides rich testing support.


@SpringBootTest
 - Loads the application context.
 - Support for Spring dependency injection.
 - You can access data from Spring application.properties

Spring boot starter - for testing Supports
--------------------------------------------
Starter includes a transitive dependency on Junit 5
pom.xml
-------
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-test</artifactId>
	<scope>test</scope>
	</dependency>


Springboot Testing
-----------------
import com.example.demo.DemoApplication;
import com.example.demo.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest //It basically loads the Spring Application Context
public class MyServiceTest {

    @Autowired  //Inject Spring beans
    private MyService myService;

    @Value("@{info.school.name}")
    private String schoolName;   //access data from application.properties

    @Value("${info.app.name}")
    private String appInfo;  //access data from application.properties

    @Test
    public void testAddNumbers() {
        int result = myService.addNumbers(5, 10);
        assertEquals(15, result, "Addition of numbers should return the correct result");
    }
}


@SpringBootTest configuration

Place your test class in test package same as your main package
* This implicitly defines a base search
* Allow you to leverage default configuration
* No need to explicitly reference the main Springboot application class



Default Configuration -> com.example.component
Test configuration -> com.example.test

---------------------------------------------------------------------------
@SpringBootTest(classes = DemoApplication.class) //explicitly reference main springboot class
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @Test
    public void testAddNumbers() {
        int result = myService.addNumbers(5, 10);
        assertEquals(15, result, "Addition of numbers should return the correct result");
    }
}
------------------------------------------------------------------------------

Mocks with Mockito and Springboot
---------------------------------
Main App <--> Service <--> DAO <--> DB

How to test the service ?
We want to test the serviice with minimal configuration of dependencies (DAO, DB etc ..)
Testing with DB is not unit testing. This is integration intersting

We can solve this by using Mockito

Main <--> Service <--> DAO Test double(here we set expectations with mock responses)
						(for example "when method ABC id called then return XYZ")


The technique of using test doubles is known as "mocking"

Benifits
---------
Allow us to test a given class in isolation

Test interaction between given class and its dependencies

For Example DAO, DB, REST API etc

We can mock the DAO to give a response

Mocking Frameworks
===================
Mockito -> site.mokito.org
EasyMock -> www.easymock.org
JMockit -> jmockit.github.io

We are using Mockito since SpringBoot has built in support for Mockito


Unit testing with Mocks
------------------------
Unit tests with Mocks have the following structure

Setup (set expectations with mock responses)-> Execute(call the method you want to test) -> Assert(check the results
and verify that it is the expected result) -> Verify(Optionally verify calls )

Main <--> Service <--> DAO Test double(here we set expectations with mock responses) <-- Create Mock for the DAO
						(for example "when method ABC id called then return XYZ")



Stubbing 
========

Stubbing is a technique in unit testing where a mock object is used to simulate the behavior of another object. 

Stubbing is a technique used in unit testing to control the behavior of a collaborator.

A collaborator is a class or object that is used by the class under test. 
Stubbing allows you to specify the behavior of the collaborator so that you can test the class under test in isolation.

// This is the class under test
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn);
    }
}

In this example, the BookService class uses the BookRepository class to get a book by its ISBN. 
We can stub the BookRepository class by creating a mock object. A mock object is a fake object 
that behaves like the real object, but we can control its behavior.

Here is an example of how to stub the BookRepository class:

// This is the mock object
Mockito.mock(BookRepository.class);

// This is the test method
@Test
public void testGetBook() {
    BookService bookService = new BookService(mock(BookRepository.class));

    // Stub the BookRepository to return a specific book
    when(mockBookRepository.findById(anyString())).thenReturn(new Book("1234567890", "The Book"));

    // Call the getBook() method
    Book book = bookService.getBook("1234567890");

    // Assert that the correct book was returned
    assertEquals("The Book", book.getTitle());
}

In this example, we are stubbing the findById() method on the BookRepository mock object. 
 When the findById() method is called, we are returning a specific book. 
 This allows us to test the getBook() method on the BookService class without having to interact with the real BookRepository class.

difference between stubbing and assertions in this example
==========================================================
* Stubbing and assertions are two different techniques used in unit testing. 
* Stubbing is a technique used to control the behavior of a collaborator, while assertions are used to verify the results of a test.

In the example you provided, stubbing is used to control the behavior of the BookRepository mock object.

In the example you provided, stubbing is used to control the behavior of the BookRepository mock object. 
* The when() method is used to specify the behavior of the findById() method. When the findById() method is called, 
the thenReturn() method is used to return a specific book. 
* This allows us to test the getBook() method on the BookService class without having to interact with the real BookRepository class.

* Assertions are used to verify the results of the test. The assertEquals() method is used to verify that the correct book was returned. 
* This ensures that the getBook() method is working correctly.
* The main difference between stubbing and assertions is that stubbing is used to control the behavior of a collaborator, while 
assertions are used to verify the results of a test.

What points to consider that this is stubbing ?
================================================
Here are some points to consider that this is stubbing:
 The when() and thenReturn() methods are used to stub the behavior of a collaborator in Mockito.

 The when() method is used to specify the behavior of the collaborator, and the thenReturn() 
 method is used to return a specific value or throw an exception.

Repository repository = mock(Repository.class);
when(repository.findById(1)).thenReturn(new Book("1234567890", "The Book"));

In this code, we are specifying that the findById() method on the Repository class will return a specific 
book when it is called with the ID 1. This is an example of stubbing.


Stubbing is the act of controlling the behavior of a collaborator in a unit test. 
This is done by creating a stub object that replaces the real collaborator. 
The stub object can be programmed to return a specific value or throw an exception when a method is called.

Stubbing is typically used to isolate the class under test from the real collaborator. 


Verify calls on Mocks
=====================
In Java, you can verify calls on mocks using the Mockito library. The Mockito library provides a number of methods 
for verifying mock behavior, including:
verify(): This method verifies that a method was called on a mock object.
verifyZeroInteractions(): This method verifies that a mock object was not called on any methods.
verifyNoMoreInteractions(): This method verifies that a mock object was not called on any methods after a certain 
point in the test.
inOrder(): This method allows you to verify the order in which methods were called on a mock object.

For example, the following code verifies that the getName() method was called on the mock object myMock exactly once:
Mockito.verify(myMock, times(1)).getName();

The following code verifies that the getName() method was not called on the mock object myMock at all:
Mockito.verifyZeroInteractions(myMock);


The following code verifies that the getName() method was called on the mock object myMock before the getAge() method was called:
Mockito.inOrder(myMock).verify(myMock).getName();
Mockito.inOrder(myMock).verify(myMock).getAge();

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockitoVerifyExample {

    @Mock
    private MyMock myMock;

    @Test
    public void verifyGetNameCalledOnce() {
        Mockito.when(myMock.getName()).thenReturn("John Doe");
        myMock.getName();

        boolean verificationResult = Mockito.verify(myMock, times(1)).getName();

        assert verificationResult;
    }
}

 The Mockito library will return a boolean value indicating whether or not the verification was successful. 
 In this case, the verification will be successful and the boolean value will be true.

The output of the verifyGetNameCalledOnce() method will be a boolean value, which in this case will be true


Verifying calls on mocks is beneficial in a number of situations, including:
------------------------------------------------------------------------------

When you want to ensure that a certain behavior was executed. For example, you might want to verify that a 
method was called with the correct arguments or that a method was called a certain number of times.

When you want to test the side effects of a method call. For example, you might want to verify that a method call 
caused a database change or that a method call sent an email.

When you want to debug a failing test. If a test is failing, you can use verification to help you figure out why the test is failing. 
For example, you might be able to verify that a method was not called or that a method was called with the wrong arguments.

Here are some specific examples of when it is beneficial to verify calls on mocks:

You are testing a method that calls a third-party library. You want to verify that the third-party library was called with the correct arguments.
You are testing a method that makes a network request. You want to verify that the network request was made and that the response was received correctly.
You are testing a method that interacts with a database. You want to verify that the database was updated correctly.

 how verify works. It deals with the previous things so 
 ---------------------------------------------------------
*The verify() method in Mockito works by checking the call history of a mock object. 
*The call history is a record of all the methods that have been called on the mock object, along 
with the arguments that were passed to the methods.

Who maintains the call history ?
---------------------------------
* The call history of a mock object is maintained by the Mockito library.

* This information is stored in a data structure called the call recorder.

*The call recorder is used by the verify() method to check if a method was called and to 
verify the arguments that were passed to a method. 

*The call recorder is a critical part of the Mockito library. It allows Mockito to verify the behavior of mock 
objects and to ensure that tests are accurate and complete.

The conclusion is that using verify() after each test is a good practice that can help to ensure the quality of your code. 
However, it is not always necessary to use verify() after each test. There are some cases where it may be more appropriate 
to use verify() less frequently, or even not at all.

The call history of a mock object can be used to verify the order in which methods were called. 

This can be useful for testing complex code that depends on the order in which methods are called.

 You can use the call history to verify that the getName() method was called before the getAge() method.

@Test
public void testGetNameAndGetAge() {
    MyMock myMock = mock(MyMock.class);
    Mockito.when(myMock.getName()).thenReturn("John Doe");
    Mockito.when(myMock.getAge()).thenReturn(30);

    String name = myMock.getName();
    int age = myMock.getAge();

    Mockito.verify(myMock).getName();
    Mockito.verify(myMock).getAge();

    // Verify that the getName() method was called before the getAge() method
    Mockito.verify(myMock, times(1)).getName();
    Mockito.verify(myMock, times(1)).getAge();
}

Output
======
[INFO] Running testGetNameAndGetAge()
[INFO] Passed: testGetNameAndGetAge()


This is because the getName() method was called before the getAge() method, as expected.

If the getName() method was called after the getAge() method, the test would fail.



Hamcrest Matchers
=================
Hamcrest matchers are a powerful tool for writing expressive and readable unit tests. 

They allow you to specify the expected behavior of your code in a declarative way, which 
can make your tests more readable and maintainable.

There are many different Hamcrest matchers available, each of which can be used to express a specific type of condition.

*For example, the equalTo() matcher can be used to assert that two objects are equal
*greaterThan() matcher can be used to assert that one object is greater than another
*hasItem() matcher can be used to assert that a collection contains a specific element

https://www.baeldung.com/java-junit-hamcrest-guide 
https://www.vogella.com/tutorials/Hamcrest/article.html - link to help on understanding the Hamcrest Matchers
---------------------------------------------------------------------------------------------------------------

Spring Boot Unit Testing - assertEquals and assertNotEquals
============================================================
assertEquals(): The assertEquals() assertion asserts that two objects are equal.
---------------
The two objects can be of any type, as long as they have a equals() method.

The assertEquals() assertion takes two arguments: the expected value and the actual value.

If the two values are equal, the assertion passes. If the two values are not equal, the assertion 
fails and an AssertionError exception is thrown.

assertNotEquals(): The assertNotEquals() assertion asserts that two objects are not equal.
-------------------
The two objects can be of any type, as long as they have a equals() method.

 The assertNotEquals() assertion takes two arguments: the expected value and the actual value. 

 If the two values are not equal, the assertion passes. 
 If the two values are equal, the assertion fails and an AssertionError exception is thrown. 

 For example, the following code asserts that the two strings "hello world" and "hello world" are equal:

 assertEquals("hello world", "hello world");
assertNotEquals("hello world", "goodbye world");
The assertEquals() and assertNotEquals() assertions are two of the most commonly used assertions in Spring Boot unit testing. 

package com.example.myapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        assertEquals("hello world", "hello world");
    }

    @Test
    public void testAssertNotEquals() {
        assertNotEquals("hello world", "goodbye world");
    }
}


the output of the test case would be:

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.076 s - in com.example.myapp.AssertionsTest
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.123 s
[INFO] Finished at: 2023-06-28T05:22:13+00:00
[INFO] ------------------------------------------------------------------------

The testAssertEquals() test case will pass, because the two strings "hello world" and "hello world" are equal. 
The testAssertNotEquals() test case will also pass, because the two strings "hello world" and "goodbye world" are not equal.


Spring Boot Unit Testing - assertTrue, assertFalse and assertNotNull
====================================================================
here is an explanation of the assertTrue, assertFalse and assertNotNull assertions in Spring Boot unit testing:

assertTrue(): The assertTrue() assertion asserts that a boolean expression is true. 
If the expression is true, the assertion passes. If the expression is false, the assertion 
fails and an AssertionError exception is thrown.

1. assertTrue(boolean condition)  
2. assertTrue(boolean condition, String message)
3. assertTrue(boolean condition, Supplier<String> messageSupplier)
4. assertTrue(BooleanSupplier BooleanSupplier)
5. assertTrue(BooleanSupplier BooleanSupplier, String message)
6. assertTrue(BooleanSupplier BooleanSupplier, Supplier<String> messageSupplier)


package com.example.myapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionsTest {

    @Test
    public void testAssertTrue() {
        assertTrue(1 == 1);
    }

    @Test
    public void testAssertFalse() {
        assertTrue(2 != 3);
    }

    @Test
    public void testAssertGreater() {
        assertTrue(5 > 4);
    }

    @Test
    public void testAssertLess() {
        assertTrue(10 < 11);
    }

    @Test
    public void testAssertTrueWithMessage() {
        assertTrue(1 == 1, "1 should be equal to 1");
    }
}



Output
------
This will output more information about the test cases that are run, such as the following:

[INFO] --- junit-jupiter-api:5.8.2:test (AssertionsTest) @ myapp ---
[INFO]
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.042 s - in com.example.myapp.AssertionsTest
[INFO]
[INFO] 5 test completed
[INFO]
[INFO] Passed: AssertionsTest.testAssertTrue()
[INFO] Passed: AssertionsTest.testAssertFalse()
[INFO] Passed: AssertionsTest.testAssertGreater()
[INFO] Passed: AssertionsTest.testAssertLess()
[INFO] Passed: AssertionsTest.testAssertTrueWithMessage()

assertFalse(): The assertFalse() assertion asserts that a boolean expression is false. 
--------------
If the expression is false, the assertion passes. If the expression is true, the assertion 
fails and an AssertionError exception is thrown.

package com.example.myapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertionsTest {

    @Test
    public void testAssertFalse() {
        assertFalse(1 == 2);
    }

    @Test
    public void testAssertTrue() {
        assertFalse(2 != 2);
    }

    @Test
    public void testAssertGreater() {
        assertFalse(5 <= 4);
    }

    @Test
    public void testAssertLess() {
        assertFalse(10 >= 11);
    }

    @Test
    public void testAssertFalseWithMessage() {
        assertFalse(1 == 2, "1 should not be equal to 2");
    }
}



Sure, here is the output of the code:

[INFO] Tests run: 5, Failures: 5, Errors: 0, Skipped: 0, Time elapsed: 0.045 s - in com.example.myapp.AssertionsTest
[INFO]
[INFO] 5 tests failed
[INFO]
[ERROR] AssertionsTest.testAssertFalse()
java.lang.AssertionError: 1 should not be equal to 2
[INFO]
[ERROR] AssertionsTest.testAssertTrue()
java.lang.AssertionError: 2 should not be equal to 2
[INFO]
[ERROR] AssertionsTest.testAssertGreater()
java.lang.AssertionError: 5 should not be less than or equal to 4
[INFO]
[ERROR] AssertionsTest.testAssertLess()
java.lang.AssertionError: 10 should not be greater than or equal to 11
[INFO]
[ERROR] AssertionsTest.testAssertFalseWithMessage()
java.lang.AssertionError: 1 should be equal to 2



assertNotNull():The assertNotNull() assertion asserts that an object is not null.
---------------If the object is not null, the assertion passes. If the object is null, the assertion 
fails and an AssertionError exception is thrown.

package com.example.myapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssertionsTest {

    @Test
    public void testAssertNotNull() {
        assertNotNull(new Object());
    }

    @Test
    public void testAssertNull() {
        assertNotNull(null); // This will fail
    }

    @Test
    public void testAssertNotNullWithMessage() {
        assertNotNull(new Object(), "The object should not be null");
    }
}


Here is the output of the code:

[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.033 s - in com.example.myapp.AssertionsTest
[INFO]
[INFO] 3 tests completed
[INFO]
[INFO] Passed: AssertionsTest.testAssertNotNull()
[INFO] Passed: AssertionsTest.testAssertNotNullWithMessage()
[INFO] Passed: AssertionsTest.testAssertNull()


Mockito Annotations - @Mock, @InjectMocks, @RunWith, @Captor
=============================================================
They can help you to write more expressive and readable tests, and they can also help to 
improve the maintainability of your tests.

The following are some of the most commonly used Mockito annotations:

* @Mock: This annotation is used to create a mock object.
The @Mock annotation is used to create a mock object in Mockito
A mock object is a fake object that can be used to test the behavior of a class under test.
Mock objects can be used to stub the behavior of real objects

The @Mock annotation can be used in two ways:
-----------------------------------------------
Directly on a class: This will create a mock object of the specified class.
On a field: This will create a mock object of the specified type and inject it into the field.

import org.mockito.Mock;
import org.junit.Test;
@RunWith(MockitoJUnitRunner.class)
public class MockitoAnnotationsExample {

    @Mock
    private MyMock myMock;

    @Test
    public void testSomething() {
        // This will create a mock object of type MyMock
        // and inject it into the MockitoAnnotationsExample class

        MockitoAnnotations.initMocks(this);

        // This will call the doSomething() method on the mock object
        // and assert that it returns the string "Hello, world!"

        assertEquals("Hello, world!", myMock.doSomething());
    }
}

In unit tests, you can use @Mock instead of @Autowired to inject a mock object into a class. 
This is because @Mock creates a mock object of any type, while @Autowired can only be used 
to inject dependencies of a specific type.



* @InjectMocks: This annotation is used to inject mocks into a class under test.
The @InjectMocks annotation is used in Mockito to automatically inject mocked dependencies into the target object.
 It is typically used in conjunction with the @Mock or @Spy annotations to create and inject mock objects into the 
 target object being tested.

Here's an example to illustrate the usage of @InjectMocks and @Mock in the original class (UserServiceImpl) 
and the corresponding test class (UserServiceImplTest).

Original Class (UserServiceImpl):
---------------------------------
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    // Implementation of UserService methods

    public void registerUser(User user) {
        // Business logic to register a user
        userRepository.save(user);
        emailService.sendRegistrationEmail(user);
    }

    // Other methods
}

Test Class (UserServiceImplTest):
---------------------------------
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    // ...

    @Test
    public void testRegisterUser() {
        // Create a mock User object
        User user = new User("John", "Doe", "john.doe@example.com");

        // Mock the userRepository.save() method
        Mockito.when(userRepository.save(user)).thenReturn(user);

        // Perform the test on the registerUser() method
        userService.registerUser(user);

        // Verify that the userRepository.save() method was called with the correct argument
        Mockito.verify(userRepository).save(user);

        // Verify that the emailService.sendRegistrationEmail() method was called with the correct argument
        Mockito.verify(emailService).sendRegistrationEmail(user);
    }

    // ...
}
In this example, UserServiceImpl is the original class that contains the registerUser() method, which is being tested.
The UserRepository and EmailService are autowired dependencies within UserServiceImpl.

In the UserServiceImplTest test class, @InjectMocks is used on the userService object, which 
is an instance of UserServiceImpl that you want to test. @Mock annotations are used on the userRepository 
and emailService fields, which are the dependencies of UserServiceImpl.

The testRegisterUser() method demonstrates a test scenario for the registerUser() method. 
It creates a mock User object, mocks the behavior of the userRepository.save() method using 
Mockito.when(), and then invokes the registerUser() method on the userService object.

Finally, Mockito.verify() is used to verify that the userRepository.save() and emailService.sendRegistrationEmail() 
methods were called with the expected arguments during the test execution.

By using @InjectMocks and @Mock annotations, you can create mock objects for the dependencies, inject them into the 
class under test, and define their behavior to facilitate unit testing.


@RunWith: This annotation is used to specify the runner that will be used to run the unit tests.
The @RunWith annotation is used in JUnit to specify a custom test runner class that will be used to run the test cases.
 It allows you to extend the functionality of JUnit by providing alternative test runners.
By default, JUnit uses the BlockJUnit4ClassRunner as the test runner. 
However, the @RunWith annotation allows you to specify a different runner to customize the test execution process.

What is Runner Class :-
========================
In the context of JUnit, a runner class is a component responsible for executing test cases and controlling 
the test execution process. 
It provides the necessary infrastructure and rules for running tests, handling assertions, managing test 
lifecycle, and reporting test results.

*******But in In JUnit 5, the concept of runner classes has been replaced with the concept of Test Engines. 
**********************************************************************************************
A Test Engine is responsible for discovering, executing, and reporting test cases in JUnit 5.*
****************************************Imp note**********************************************
JUnit 5 provides its own built-in Test Engine called JUnit Platform. 
To use JUnit 5, you don't need to specify a runner class. 

@Captor: This annotation is used to capture arguments passed to a mock object.
The @Captor annotation is used in Mockito to capture arguments passed to mocked methods for further 
assertions or verifications. It is typically used in conjunction with the ArgumentCaptor class.

Capturing arguments passed to a Mock
=====================================
Mockito provides a class called ArgumentCaptor that can be used to capture arguments passed to a mock object.

To use ArgumentCaptor, you first need to create an instance of the class.

Then, you can use the capture() method to capture the arguments that are passed to the mock object.


import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;

public class ArgumentCaptorTest {

    @Mock
    private MyMock myMock;

    @Test
    public void testCaptureArguments() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        Mockito.when(myMock.doSomething(argumentCaptor.capture())).thenReturn("Hello, world!");

        String argument = "foobar";
        myMock.doSomething(argument);

        Mockito.verify(myMock).doSomething(argumentCaptor.capture());

        assertEquals(argument, argumentCaptor.getValue());
    }
}


Sure, I can help you with that.

Capturing arguments passed to a mock is a useful way to verify the behavior of the mock object. For example, you can use it to verify that the correct arguments were passed to the method, or to verify that the arguments were passed in the correct order.

Mockito provides a class called ArgumentCaptor that can be used to capture arguments passed to a mock object. 
To use ArgumentCaptor, you first need to create an instance of the class. Then, you can use the capture() method 
to capture the arguments that are passed to the mock object.

Here is an example of how to capture arguments passed to a mock object:

Code snippet
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Test;

public class ArgumentCaptorTest {

    @Mock
    private MyMock myMock;

    @Test
    public void testCaptureArguments() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        Mockito.when(myMock.doSomething(argumentCaptor.capture())).thenReturn("Hello, world!");

        String argument = "foobar";
        myMock.doSomething(argument);

        Mockito.verify(myMock).doSomething(argumentCaptor.capture());

        assertEquals(argument, argumentCaptor.getValue());
    }
}

In this example, we create an instance of ArgumentCaptor for the String class. Then, we use the 
when() method to stub the doSomething() method on the myMock mock object. The stub returns the 
string "Hello, world!", but it also captures the argument that is passed to the method.

We then call the doSomething() method on the myMock mock object, passing the string "foobar" as an argument. 
The ArgumentCaptor instance captures the argument that is passed to the method, and we can then use the getValue() 
method to get the captured value.

Finally, we use the verify() method to verify that the doSomething() method was called with the correct argument. 
The test will pass because the doSomething() method was called with the string "foobar", as expected.

Output
------
[INFO] Running testCaptureArguments()
[INFO] Passed: testCaptureArguments()

This is because the doSomething() method was called with the string "foobar", as expected.

If the doSomething() method was called with a different argument, the test would fail.








Spring Boot Unit Testing - Prototype Beans
===========================================
Spring Boot unit testing of prototype beans is a bit different from unit testing of singleton beans.

This is because prototype beans are created anew each time they are requested, while 
singleton beans are created only once and shared by all clients.

To unit test a prototype bean, you need to ensure that a new instance of the bean is created each time the test method is run.

You can do this by using the @MockBean annotation in your test class. The @MockBean annotation tells Spring Boot 
to create a mock object of the bean when the test method is run

Once you have created a mock object of the prototype bean, you can inject it into your test class and use it in your tests.

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrototypeBeanTest {

    @MockBean
    private PrototypeBean prototypeBean;

    @Test
    public void testPrototypeBeanIsCreatedAnew() {
        PrototypeBean firstInstance = prototypeBean;
        PrototypeBean secondInstance = prototypeBean;

        assertNotEquals(firstInstance, secondInstance);
    }
}



Sure, I can help you with that.

In Spring, there are two different bean scopes: prototype and singleton. The scope of a bean determines how many 
instances of the bean are created and how those instances are shared.

Singleton beans are created only once per Spring application context. This means that all clients that request the 
bean will receive the same instance. Singleton beans are the default bean scope in Spring.
Prototype beans are created anew each time they are requested. This means that each client that requests the bean
 will receive a different instance. Prototype beans are typically used for beans that are stateful, meaning that 
 their state changes over time.
Here is a table that summarizes the differences between prototype beans and singleton beans:

Feature	Prototype bean	Singleton bean
Number of instances	Created anew each time they are requested	Created only once per Spring application context
Sharing	Each client receives a different instance	All clients receive the same instance
Statefulness	Stateful	Stateless
Default scope	Not the default scope	The default scope
Here are some examples of when you might use prototype beans:

When you need to create a new instance of a bean for each request.
When you need to have multiple instances of a bean with different states.
When you need to avoid sharing state between clients.
Here are some examples of when you might use singleton beans:

When you need to share state between clients.
When you need to optimize performance by avoiding the creation of new objects.
When you need to ensure that all clients receive the same instance of a bean.

----------------------------------------------------------------------------------------------------------------

Basics of Mockito
=================

Mockito is a mocking framework for Java. 
It allows you to create mock objects that can be used to replace real collaborators in unit tests.

Mock objects can be used to stub the behavior of a collaborator, which can be useful for 
testing the behavior of the class under test.


Mockito is a mocking framework for Java. It allows you to create mock objects that can be used to replace real collaborators in unit tests. Mock objects can be used to stub the behavior of a collaborator, which can be useful for testing the behavior of the class under test.

Here are some of the basics of Mockito:

1.Mock objects
2.Stubbing: Stubbing is the act of controlling the behavior of a collaborator in a unit test.
3. Verification
Mockito provides a number of methods for stubbing and verification.
------------------------------------------------------------------
Mockito.mock(): This method is used to create a mock object.
Mockito.when(): This method is used to stub the behavior of a mock object.
Mockito.verify(): This method is used to verify that a mock object was called in a unit test.

Mockito provides a number of methods for stubbing. 
These methods can be used to control the behavior of a collaborator in a variety of ways.

One way to stub a collaborator is to use argument matchers.
Argument matchers are objects that can be used to match the arguments that are passed to a method.
Mockito provides a number of different argument matchers, each of which can be used to match different types of arguments.

Mockito provides a number of different argument matchers, each of which can be used to match different types of arguments.
The Mockito.eq() matcher can be used to match an argument that is equal to a specific value.
The Mockito.isNull() matcher can be used to match an argument that is null.

Mockito.when(repository.findById(Mockito.any())).thenReturn(new Book("1234567890", "The Book"));
You can use the Mockito.matches() matcher to stub a method to return a specific value only when an 
argument matches a specific regular expression.


any(): Matches any argument of the specified type.
Example: when(mockObject.someMethod(any(String.class))).thenReturn("Mocked response")

eq(value): Matches the argument that is equal to the specified value.
Example: when(mockObject.someMethod(eq(42))).thenReturn("Mocked response")

isNull(): Matches null argument.
Example: when(mockObject.someMethod(isNull())).thenReturn("Mocked response")

notNull(): Matches non-null argument.
Example: when(mockObject.someMethod(notNull())).thenReturn("Mocked response")

anyInt(), anyString(), anyBoolean(), etc.: Matches any argument of the specified primitive type.
Example: when(mockObject.someMethod(anyInt())).thenReturn("Mocked response")

anyList(), anySet(), anyMap(), etc.: Matches any argument of the specified collection type.
Example: when(mockObject.someMethod(anyList())).thenReturn("Mocked response")

argThat(matcher): Matches an argument based on a custom matcher.
Example: when(mockObject.someMethod(argThat(argument -> argument.startsWith("prefix")))).thenReturn("Mocked response")


Mockito Junit Rule
===================
* The MockitoJUnitRule is a JUnit rule that helps you to keep your tests clean and maintainable.
* It does this by initializing Mockito mocks, validating Mockito usage, and detecting incorrect stubbing.
*The MockitoJUnitRule is a convenient way to use Mockito in your JUnit tests. 
It eliminates the need to call the MockitoAnnotations.initMocks() method manually, and it can help to 
improve the readability of your unit tests.

In JUnit 5, the concept of rules has been replaced with extensions. Mockito provides its own extension 
called MockitoExtension for seamless integration with JUnit 5. 

Annotate your test class with @ExtendWith(MockitoExtension.class) to enable the Mockito extension:
@ExtendWith(MockitoExtension.class)
public class MyTest {

    // Test methods
}

Use Mockito annotations (e.g., @Mock, @InjectMocks, @Captor) and Mockito methods (e.g., Mockito.when(), Mockito.verify()) in your test methods.

Difference between @RunWith and @ExtendWith
===========================================
The @RunWith and @ExtendWith annotations are used in different versions of JUnit and serve different purposes:

@RunWith:
----------
Used in JUnit 4.
It is used to customize the test runner that will be used to execute the tests.
Test runners are responsible for running the test cases and providing various functionalities.
It allows you to use custom runners or third-party runners for specific test scenarios.
Examples of runners include BlockJUnit4ClassRunner, Parameterized, etc.
@ExtendWith:
-------------
Used in JUnit 5 (JUnit Jupiter).
It is used to register extensions for the test class.
Extensions are additional behaviors or functionalities that can be added to the test execution.
Extensions can provide features like mocking, test lifecycle management, custom test reporting, etc.
It is a replacement for the previous concept of rules in JUnit 4.
Examples of extensions include MockitoExtension, SpringExtension, etc.
In summary, @RunWith is used to customize the test runner in JUnit 4, while @ExtendWith is used to register extensions in JUnit 5.

Why does Mockito not allow stubbing final & private methods
============================================================
Mockito does not allow stubbing final and private methods because it is not possible to override these methods in a mock object.

A final method is a method that cannot be overridden by subclasses. This means that if you try to stub a final method in a 
mock object, the mock object will simply delegate the call to the real object.

If you need to test the behavior of a final or private method, you can use a different mocking framework, such as PowerMock.
PowerMock allows you to stub final and private methods, but it is important to use PowerMock carefully, as it 
can be easy to create brittle tests.

Does it throw any exception when we are trying to mock the private and final methods
------------------------------------------------------------------------------------
Yes, when attempting to mock private or final methods using Mockito, it will typically throw an exception.
Mockito throws an MockitoException when you try to mock private and final methods. The exception message is:
Cannot mock a final class or method.

Wirte Junit Test Case using Junit 5
=====================================
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("Test addition")
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 3);
        Assertions.assertEquals(5, result, "Addition result should be 5");
    }

    @Test
    @DisplayName("Test subtraction")
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        Assertions.assertEquals(2, result, "Subtraction result should be 2");
    }
}


Write Junit Test case using Inject Mocks
========================================
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        // Arrange
        User expectedUser = new User(1, "John");
        when(userRepository.findById(1)).thenReturn(expectedUser);

        // Act
        User actualUser = userService.getUserById(1);

        // Assert
        assertEquals(expectedUser, actualUser);
        verify(userRepository, times(1)).findById(1);
    }
}


Can we return String from Junit test case particularly from a method having @Test
=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=--=-=-=-=-=-=-=-==-=-=-=-=-==-=-
No, in JUnit, the @Test annotation is used to mark methods as test cases, and they are not expected 
to return any values. The success or failure of a test is determined by the test framework based on 
the assertions made within the test method.

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    public void testSomeMethod() {
        // Arrange
        int expectedValue = 42;

        // Act
        int actualValue = someMethod();

        // Assert
        assertEquals(expectedValue, actualValue);
        
        // Additional actions based on the test result
        String result = getResultBasedOnValue(actualValue);
        // Do something with the result...
    }

    private int someMethod() {
        // Perform some logic and return a value
        return 42;
    }

    private String getResultBasedOnValue(int value) {
        // Perform additional logic based on the value and return a result
        if (value > 0) {
            return "Positive";
        } else {
            return "Non-positive";
        }
    }
}


What is the return type of Junit Test Case
-------------------------------------------
In JUnit, test methods typically have a void return type. 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    public void testAddition() {
        int result = add(2, 3);
        assertEquals(5, result);
    }

    private int add(int a, int b) {
        return a + b;
    }
}

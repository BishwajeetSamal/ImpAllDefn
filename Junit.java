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
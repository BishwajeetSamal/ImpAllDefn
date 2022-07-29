												JUnit
												=====
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
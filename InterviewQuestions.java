
JAVA INTERVIEW QUESTIONS
---------------------------------------------------------------------------------------
Que 1. Can main method be overloaded and Override ?
Ans1. (1).The main method can be overloaded but cannot be overridden in Java.
(2).The main is a static method and the static method cannot be overridden in Java.
(3).Overloading takes place at compile time and overriding takes place at runtime.
-----------------------------------------------------------------------------------|
/**																				   |
 * Java Program to show that you can overload main method in JAVA   			   |
 * but you cannot override main method.											   |
 * 																				   |													   |				
 */																				   |
public class Helloworld {														   |
																				   |
    /**																		       |	
     * Standard main method, JVM will only call this method	                       |
     * even if you provided multiple overloaded version.	                       |
     * 																			   |
     */																			   |
    public static void main(String[] args) {						               |
        System.out.println("Inside main(String[] args) method ....");              |
       																			   |
    }																			   |
    																			   |
    /**																			   |
     * An overloaded main method which accepts Integer[] instead of                |
     * String[] as argument. 													   |															   |
     */																	       	   |		
    public static void main(Integer[] args){                              		   |
        System.out.println("Inside main(Integer[] args) method ....");			   |
    }																			   |
    																			   |
    																			   |
    /**																			   |
     * Another overloaded main method which accepts Double[] instead of 		   |
     * String[] as argument. 													   |																   |
     */																			   |
    public static void main(Double[] args){										   |
        System.out.println("Inside main(Double[] args) method ....");			   |
    }																			   |
    																			   |
}																				   |			
																				   |
Output																			   |
Inside main(String[] args) method ....	It will work for String args.			   |	
---------------------------------------------------------------------------------------

Que 2. Why we need to use Getters and Setters ?
Ans2. (1).A setter updates the value of a variable, while a getter reads the value of a variable.
(2). for accessing the variables outside a class without getters/setters, we have to mark those as public, protected, or default.
Thus,we are losing control over the data and compromising the fundamental OOP principle – encapsulation.
(3). Since anyone can change the non-private fields from outside the class directly, we cannot achieve immutability.
(4).  If you make a field public, it means you provide direct access to the caller. Then, the caller can do anything with your 
field, either knowingly or unknowingly. 
But, if you provide a getter/setter, you provide them indirect access while taking full control.
(5).etters/setters, we create a provision to add any validation method in the future, currently, there is no 
validation, but if anything
oes wrong in the future we just add validation logic in the setter.

Que3 . What is the Difference Between == and .equals() Method in Java ?
Ans3. 1. The main difference between is [.equals() is a method and == operator ].
2. We can use == operators for reference comparison (address comparison) and .equals() method for content comparison.
In simple words, == checks if both objects point to the same memory location whereas .equals() evaluates to the comparison 
of values in the objects.

|---------------------------------------------------------------------------|	
|													   						|
|	public class Test {														|
    public static void main(String[] args)
    {
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
 
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true
    }
}											
|																		    |
|	  												                        |
|---------------------------------------------------------------------------|
Explanation: Here, we create two objects, namely s1 and s2. 

Both s1 and s2 refer to same objects.
When we use the == operator for s1 and s2 comparison, the result is true as both have the same addresses in the string constant pool.
Using equals, the result is true because it’s only comparing the values given in s1 and s2.

-------------------------------------------
Que 4. What is Singleton Class ? //Runtime is a singleton class. For any java class if we are allowed to create 
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
    |private static Test t = new Test(); //This approach is wrong by using new keyword because constructor is private.
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
3. Singleton prevents other objects from instantiating their own copies of the Singleton object, ensuring that all objects access the single instance. 

Que5.Difference between string stringbuffer and stringbuilder ?
//Strings are one of the most popular classes used while programming in Java by developers. 
//But, since Strings are immutable, Java came up with two utility classes: StringBuilder and StringBuffer 
//to make the String manipulations easy.
Ans5. Java provides three classes to represent a sequence of characters: String, StringBuffer, and 
StringBuilder.
1. String is immutable whereas StringBuffer and StringBuilder are mutable classes.
2. StringBuffer is thread-safe and synchronized whereas StringBuilder is not. It means two threads cannot call the methods of StringBuffer simultaneously.
3. StringBuffer is less efficient than StringBuilder and StringBuilder is faster than StringBuffer. 
4. StringBuffer was introduced in Java 1.0 
5. String concatenation operator (+) internally uses StringBuffer or StringBuilder class.

Que6. String pool in Java?
Ans 6.  1.String Pool in Java is a pool of Strings which is stored in Java Heap Memory. String Pool is a storage area in Java heap.
2. It is also known as String Intern Pool or String Constant Pool.
3.By default, it is empty and privately maintained by the Java String class.
4.Whenever we create a string the string object occupies some space in the heap memory. Creating 
a number of strings may increase the cost and memory too which may reduce the performance also.
5.The JVM performs some steps during the initialization of string literals that increase the performance and decrease the memory load. To decrease the number of String objects 
created in the JVM the String class keeps a pool of strings.

Que7. What is thread-safe in Java ?
Ans7 . As we know Java has a feature, Multithreading, which is a process of running multiple threads 
simultaneously. When multiple threads are working on the same data, and the value of our data is changing, that
 scenario is not thread-safe and we will get inconsistent results. When a thread is already working on an 
 object and preventing another thread on working on the same object, this process is called Thread-Safety.

 How to achieve Thread Safety
There are four ways to achieve Thread Safety in Java. These are:

1. Using Synchronization -Synchronization is the process of allowing only one thread at a time to complete the particular task.
2. Using Volatile Keyword.
3. Using Atomic Variable.
4. Using Final Keyword.-Final Variables are also thread-safe in java because once assigned some reference of an object It cannot point to reference of another object. 

Que8. Difference between final, finally and finalize ?
Ans8. The final, finally, and finalize are keywords in Java that are used in exception handling.
------------------------------------------------------------ 
1. final(lowercase) is a reserved keyword in java.
	Use with variables ,methodsa nd class.We cannot change value after the first initialization.
	final int a=10;
	a=a+20; //error -----//cannot change value
	* final method cannot be override but can overloaded.
	*private, static, final // we can overload but cannot be overrided.
	* If the class is final then we will not able to inherit that.
	--------------------------------------------------------
	2. finally
	It is a block i.e.
	finally{

	}

	Use it with either try or try_catch block.
	try{}finally{}   
	//or
	try{}catch(){}finally{}
	It is used to realease the resource or we write the cleanup code.
If i do not want to use finally then just terminate the program.
We can do it by using // System.exit(0); 
	---------------------------------------------------------------
	3. finalize(){}
	It is a method .Finalize() is the method of Object class. Perform clean-up activities and minimize memory leaks.
	* It is executed just before Garbage Collector.
	Any resource that is open it can be closed by using finalize() method.
	----------------------------------------------------------------------------------
	----------------------------------------------------------------------------------
	





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
    private static Test t = null;
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


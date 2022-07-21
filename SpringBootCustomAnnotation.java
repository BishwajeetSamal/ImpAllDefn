											🔥🔥SpringBoot Annotations🔥🔥
											==============================

spring.main.log-startup-info to false in application.properties for not showing the logs info.
This will also turn off logging of the application’s active profiles.

Annotation Type Target @Target({ElementType.ANNOTATION_TYPE})
=============================================================
package java.lang.annotation;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE})
public @interface Target {
   ElementType[] value();
}	

Here ANNOTATION_TYPE comes from,
package java.lang.annotation;

public enum ElementType {
   TYPE,
   FIELD,
   METHOD,
   PARAMETER,
   CONSTRUCTOR,
   LOCAL_VARIABLE,
   ANNOTATION_TYPE,
   PACKAGE,
   TYPE_PARAMETER,
   TYPE_USE;
}



If @Target({ElementType.TYPE}) 

{ElementType.TYPE}--// This Annotation will be available for class,Interface and Enum
{ElementType.METHOD}---//Now we can use this annotation for method as well.
{ElementType.FIELD}---//We can use this annotation for Field as well.


//This informs that at what level the annotation will be available. At Source or At Class or At Runtime. 
@Retention(----)
1.In Java, annotations are used to attach meta-data to a program element such as a class, method, instances, etc
2.Some annotations are used to annotate other annotations.
3.These types of annotations are known as meta-annotations. 
4.@Retention is also a meta-annotation that comes with some retention policies.
5.There are three types of retention policies: SOURCE, CLASS, and RUNTIME.

RetentionPolicy.SOURCE: The annotations annotated using the SOURCE retention policy are discarded at runtime.
-----------------------
RetentionPolicy.CLASS: The annotations annotated using the CLASS retention policy are recorded in the .class file 
----------------------
but are discarded during runtime. 
RetentionPolicy.RUNTIME: The annotations annotated using the RUNTIME retention policy are retained during runtime 
------------------------
and can be accessed in our program during runtime.
--------------------------------------------****************************-----------------------------------------

@Override, @Deprecated are marker interface

***************************************************************************************************************
|========================|
|Write Custom Annotations|
|========================|

@Target({ElementType.Type,Element.Type.METHOD}) //If we use "ElementType.Type" then applicable for class,
//interface,enum and if we want for method then use "Element.Type.METHOD" 
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{      //multi valued Annotation
	int myValue() default 0;
	String name() default "Bishwajeet";
	String city() default "Jajpur"
}


@interface MyAnno{      //multi valued Annotation
	int myValue() default 0;
}

@interface MyAnno{} //marker interface 
--------------------------
Now we can use as a annotation, in java
@MyAnno //if we use like this, then default value get used
@MyAnno(myValue=369,name="Samal",city="Puri") //we will be able to provide the value
public class Demo{

}


MainExample.java
-----------------
class MainExample{
	public static void main(String []args){
		Demo d = new Demo();
		Class c = d.getClass(); //to get the class. this will give class type object.
		//getClass() is the method of Object class. This method returns the runtime class of this object.
		System.out.println(c.getName()); //The getName() method of java.lang.Class class is used to get the 
		//name of this entity.  This entity can be a class, an array, an interface, etc. This method returns the name of the entity as a String.

		MyAnno an = (MyAnno) c.getAnnotation(MyAnno.class); //getAnnotation Method return Annotation 
		//type thats why we need to TypeCast.
		System.out.println(an.myValue());
		System.out.println(an.name());
		System.out.println(an.city());
	}
}


Output
------
example.Demo

369
Samal
Puri 

*******************************************************************************************


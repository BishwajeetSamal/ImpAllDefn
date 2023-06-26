											🔥🔥SpringBoot Annotations🔥🔥
											==============================

How Springboot Autoconfiguratio works internally ?
==================================================
+------------------------------------------------------+
|                  Classpath Scanning                   |
+------------------------------------------------------+
|                   Main Application                    |
|                                                      |
|  @EnableAutoConfiguration                            |
|                                                      |
|  +---------------------------------------------+    |
|  |               Classpath Scanning             |    |
|  |                                             |    |
|  |  +------------------+   +----------------+  |    |
|  |  |    Class 1       |   |    Class 2     |  |    |
|  |  |  (Auto-Config)   |   |  (Auto-Config) |  |    |
|  |  +------------------+   +----------------+  |    |
|  |                                             |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  |          Auto-Configuration Process          |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  | @AutoConfigurationPackage                   |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  | @Import(AutoConfigurationImportSelector)     |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  | AutoConfigurationImportSelector              |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  | EnableAutoConfigurationMetadata              |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  |     Condition Evaluation                     |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  | Load Auto-Configuration Classes              |    |
|  +---------------------------------------------+    |
|                                                      |
|  +---------------------------------------------+    |
|  |     Bean Creation and Configuration          |    |
|  +---------------------------------------------+    |
|                                                      |
+------------------------------------------------------+

What is classpath in springboot ? 
----------------------------------
In Spring Boot, the classpath refers to the set of directories and JAR files that contain the 
compiled classes and resources used by the application. It is an essential component for the 
runtime environment to locate and load the required classes and resources.

The classpath in Spring Boot includes the following:
Application Classes: The compiled classes of your Spring Boot application, including the main 
application class, controller classes, service classes, and other custom classes.

Dependencies: The JAR files of the libraries and dependencies defined in your application's build 
configuration (e.g., Maven or Gradle). These JAR files contain the compiled classes and resources 
of the dependencies.

Resources: The non-Java resources, such as configuration files (e.g., application.properties or 
application.yml), static files (e.g., HTML, CSS, or JavaScript), and other resource files 
required by your application

The classpath is managed by the build system (e.g., Maven or Gradle) based on the project 
configuration. When you build and package your Spring Boot application, the necessary classes 
and resources are included in the resulting artifact (e.g., JAR file).

During runtime, Spring Boot uses the classpath to locate and load components, such as 
auto-configurations, bean definitions, and application properties. It scans the classpath to 
find annotated classes, configuration files, and other resources needed to initialize and 
configure the application.


 The auto-configuration process is not explicitly visible in code as it is a behind-the-scenes
  mechanism of Spring Boot. However, I can explain how it works conceptually:

Classpath Scanning: Spring Boot scans the classpath for classes and libraries available in the 
project. It identifies the relevant classes and libraries that could potentially provide 
auto-configuration.

Condition Evaluation: Spring Boot evaluates certain conditions to determine whether an 
auto-configuration should be applied or not. Conditions can be based on the presence of 
specific classes, properties, or the state of the environment.

Load Auto-Configuration Classes: Based on the conditions, Spring Boot loads the 
auto-configuration classes from the identified libraries and classes. These 
auto-configuration classes contain configuration logic and bean definitions for various components.

Bean Creation and Configuration: Spring Boot creates and configures beans based on the 
auto-configuration classes. It sets up the necessary infrastructure components, such as 
data sources, transaction managers, web servers, and more, based on the detected dependencies 
and configurations.

The above steps happen automatically when you use the @EnableAutoConfiguration annotation 
in your Spring Boot application. Spring Boot internally performs the necessary operations 
to trigger the auto-configuration process and apply the relevant configurations.

Please note that the specific auto-configuration classes and the order in which they are 
applied may vary depending on the project's dependencies and configurations. Spring Boot 
provides a wide range of auto-configuration classes that cover common use cases, making 
it easier to bootstrap and configure your application without extensive manual configuration.

In Spring Boot, the classpath plays a crucial role in the auto-configuration process. 
**The classpath is where the Spring Boot application looks for classes, resources, 
and auto-configuration metadata files.
**When Spring Boot starts up, it scans the classpath to identify classes annotated with 
specific annotations like @Configuration and @EnableAutoConfiguration. It also looks for 
spring.factories files on the classpath, which contain the mapping of auto-configuration 
classes to their corresponding configuration classes.

Thus,

1.Spring Boot auto-configuration works by scanning the classpath for dependencies
2.then using a set of conditions to determine which beans should be auto-configured.
3.The conditions are based on the presence of certain classes, the existence of certain 
properties, and other factors.
4.When Spring Boot starts up, it first looks for the @EnableAutoConfiguration annotation. 
5.This annotation tells Spring Boot to enable auto-configuration.
6.If the annotation is not present, then auto-configuration will not be used.
7.Once auto-configuration is enabled, Spring Boot will scan the classpath for 
classes that are annotated with the @Configuration annotation.These classes are 
considered to be auto-configuration classes.
8.Each auto-configuration class contains a set of @Bean methods. 
These methods are responsible for creating the beans that are auto-configured.
9.The @Bean methods are annotated with conditions that determine whether or not they should be executed.

For example, the following @Bean method is annotated with the @ConditionalOnClass condition. 
This condition means that the @Bean method will only be executed if the HikariCP class is 
present on the classpath.

@Bean
@ConditionalOnClass(HikariCP.class)
public HikariDataSource dataSource() {
  return new HikariDataSource();
}

Once all of the auto-configuration classes have been scanned, Spring Boot
 will create the beans that are auto-configured. These beans will be added to
  the Spring context and will be available to be used by the application.
--------------------------------------------------------------------------------------------
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


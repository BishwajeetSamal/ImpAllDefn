By Daily Code Buffer Springboot

IOC-> Its to give the control to framework. We doesnot need to take the control ourself. We doesnot need to
create all objects and many more in our application.

Like if we have created suppose 1000 of classes and we are creating and destroying the objects of these \
classes.
And for garbage collection, its a tedious job.
So everything we donnot need to do. So we are giving the control to the Framework. To do this spring allows
the dependency injection.

Dependency injection -> Give the dependency of different classes to the different classes. Suppose one class 
needs the object of other class then we will give control to spring to add those particular dependency.

It is easy to work with the ORMs

SpringBoot is the layer to the JAVA for creating the web applications. 

Spring will create all the beans load or in container. There are two interface available i.e.
BeanFactory and ApplicationContext. So we dont need to create the object and get those particular
object.
ApplicationContext context = new ClassPathXmlApplicationContext("path of spring.xml file");
context.getBean(Doctor.class);
In spring.xml ,
<beans>
<bean id="doctor" class="demo.Doctor"></bean>
</beans>
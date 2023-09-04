											Springboot Profiles
											===================
 How do you segregate your environment specific properties in SpringBoot ?
 -------------------------------------------------------------------------
 Ans -> Springboot profiles provide a way to segregate parts of your application configuration and make it
 only available in certain environments.

 Example -> how to configure different databases at runtime based on the specific environment by their
 respective profiles.
 As the DB connection is better to be kept in a property file, it remains external to the application
 and can be changed.

* When it comes to our local dev, testing, prod environments, we might have different dbs for example
use oracle in prod, Postgres for dev. etc.

* Suppose one application is calling anathor application. The prod version of Application A must connect to
prod version of Application B.
Hence the prod url of Application B will be configured in A.Same for QA environment etc.

Springboot -- by default ---- provides just one property file. (application.properties)
 
* So, how will we segregate the properties based on the environment ?

* The solution would be to create more property files and add the "profile" name as the suffix and 
configure Springboot to pick the  appropriate properties based on the profile. 

For Example:-
-------------
*application-dev.properties
*application-test.properties
*application-prod.properties

* The application.properties will remain as a master properties file, but id we override any key in the 
profile-specific file, the later will gain precedence.

Default property file ( GO to )->  src/main/resources -> application.properties

You can rename the application.properties as "application-default.properties", it works the same.

How to pick specific profile like DEV in springboot ?
-----------------------------------------------------
* Spring only acts on a profile if it's activated. 
* The default profile is always active
* Springboot loads all the properties in application.properties into the default profile. We could rename
the configuration file to application-default.properties and it would work the same.

* The profile is a fallback property file. This means that if a property is defined in the default profile, but 
not in the foo profile, the property value will be populated from the default profile. This si very handy for
defining default values that are valid across all profiles.

* To activate other profiles than the default profile, we have to let Spring know which profiles we want to activate.

* spring.profiles.active = dev


In application.properties
-------------------------
spring.properties.active = dev


________________________________________________________________________________________________
The best way to use in VM arguments.
* -Dspring.profiles.active=prod,dev

In common properties are there in both then last one will override - here dev will override.
_________________________________________________________________________________________________

Anathor important scenario
--------------------------
 Lets say a component want a property which is in prod application.properties.
But I dont want to put it as prod. I dont want to make any db connections to prod.

I just want to point to dev but still want to have one property which is available in prod only.
How I will I make sure to perform that that prod specific property would be picked up without any "BeanCreationException".

If in my application certain properties I want to use but it is not present in my dev properties file.
Then it will throw "BeanCreationException"
Then I would use the property file to get the specific property without going to the actual prod and make db con.

To solve this problem, then we need to use an annotation called @PropertySource("application-prod.properties").
to that class,

@Component
@PropertySource("application-prod.properties")
public class ProfileDemo{
	@Value("${message}")
	String message;

	@Value("${prodSpecificKey}")
	String prodSpecificMessage;

	...
}

* The @PropertySource is a convenient annotation for including PropertySource to Spring's environment and allowing to inject
via @Value into the class attributes.

* This annotation is used with @Configuration Classes. Spring @PropertySource annotation is repetable, means you can have
multiple @PropertySource on a Configuration class. This feature is available if you are using Java 8 or higher version.


This was when java 8 was not introduced (this is depricated since java 8)
---------------------------------------
@Configuration
@PropertySources({
	@PropertySource("classpath:config.properties")
	@PropertySource("classpath:db.properties")
})

After java 7, like java 8 and onwards
-------------------------------------
@Configuration
@PropertySource("classpath:config.properties")
@PropertySource("classpath:db.properties")


@Profile Annotation
===================

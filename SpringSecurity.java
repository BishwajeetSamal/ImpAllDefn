									🔥🔥Spring / Springboot Security🔥🔥
									====================================
Introduction
------------
Springboot Security Secure our own web application by default and further we can customize as per need.
We just need to add the spring boot start security dependency in our application.
It will secure our application.

Important Terms
===============
*Authentication (Who you are ?)
----------------
The identity of users are checked for providing the access to the system. User is verified and validating that users 
are whom they claim to be.

*Authorization/Access control (What you are allowed to do ?)
-----------------------------
Giving the user permission to access a specific resource or function.

What are filters used for in Java?
----------------------------------
The Java Servlet specification version 2.3 introduces a new component type, called a filter.

==============================================================================================================
Spring Security has a series of servlet filters.
When client invokes the spring application the request goes to the series of filters and to a servlet.
One of the common method is called public void doFilter(). This accepts request and response as input and also we 
able to code / login like exception handing or can check request and send to other filter from that filter layer.  

The client sends the request the application and spring creates a filter chain which contains the filters and the 
servlet that should process the request based on the path of the request url which client has sent.

*API path which need to be authenticated are routed to a certain security filter chain by the "DeligatingFilterProxy".
DeligatingFilterProxy, its job is to deligate these API request to a security filter chain and there are 
various kinds of Security filter available. 

*************************************************************************************************************
SO, DeligatingFilterProxy -> SecurityFilterChain -> Authentication Filter <=> 								|
{(Authentication Manager <-> ProviderManager) && Security Context(Authentication Principal + Authorities)}	|
			↓																								|
 Authentication Manager<=> Authentication Provider ->UserDetailsService <-> UserDetails <=> User (DB).		|
*************************************************************************************************************

1.Class DelegatingFilterProxy
-------------------------------
Delegation means hand over the responsibility for a particular task to another class or method.
DelegatingFilterProxy() -> Create a new DelegatingFilterProxy.
DelegatingFilterProxy is a class in Springs Web module.It provides features for making HTTP calls pass 
through filters before reaching the actual destination. 

2.Interface SecurityFilterChain
-------------------------------
Some of the common security filter chain 
1*.UserNamePasswordAuthenticationFilter
2*.BasicAuthenticationFilter
3*.Oauth2LoginAuthenticationFilter etc..

3.Authentication Filter
-----------------------
This authentication filter can be any of those, can be UserNamePasswordAuthenticationFilter or BasicAuthenticationFilter.
Defines a filter chain which is capable of being matched against an HttpServletRequest. in order to 
decide whether it applies to that request.
Used to configure a FilterChainProxy.

*HttpServletRequest
HttpServletRequest is an interface and extends the ServletRequest interface.
================================================================================================================

Servlet technology is used to create a web application (resides at server side and generates a dynamic web page).
*Filter (It helps for the preprocessing)
-------
1.A filter is an object that is invoked at the preprocessing or postprocessing of a request.
2.Spring security takes the help of filter before accessing the API to controller/servlet.
3.It has the methods like "doFilter()".
4.As the client try to request to the server then prior to the processing the request goes to the filter because 
we already configure accordingly. If request goes well then further processing will be  done else it will through 
the response to the client.
5.The servlet filter is pluggable, i.e. its entry is defined in web.xml or pom.xml. if we remove the entry of filter
from file, filter will be removed automatically and do not need to change the servlet.

Client<->Filter <=> Servlet

Usage of Filter
---------------
*Authentication and Authorization of request for resources.
*Formatting of request body or header before sending it to servlet.
*Compressing the response data sent to the client.
*Alter response by adding some cookies, header information etc.
*Input validation etc.

Filter API
-----------
*Filter Interface -> I will need to make a class and add the Filter Interface to make a filter. It contains 
init(), doFilter(), destroy().These are the lifecycles methods.
doFiter() is the most important method.
doFilter has two parts in which a part works for preprocessing and  other for postprocessing.


*FilterChain Interface ->It gives us power to forward the request or to other resource or servlet.
*FilterConfig -> We can bring any values from web.xml
*

Spring security works over here.

Filter forward the request to the -> Authentication Manager -> then to Authentication Provider -> will call the 
Authenticate and this will take the help of the UserDetail Service and then it will validate the User.
If User get validated then It will give the request back to the filter for proceding further.

We can use over here 
-------------------------------------------------
<dependency>
<groupId>org.springframework.boot</groupId>
<artifact>spring-boot-starter-security</artifact>
</dependency>
-------------------------------------------------
By using this dependency, it will help by doing AutoConfiguration. 
By default form based Authentication will applied. Then we can customized as per need.

How Spring Security works
=========================
1.Request get catched by the filter prior to request resource. It will intercept (stop on the way) the request.
Filter dont have the power to authenticate. It will create the authentication object and just store the basic infor-
mation. 
2.It will forward the request to the Authentication Manager.
3.This Authentication Manager is an interface and calls the authenticate(Authentication auth) and passed to 
the Authentication.
4.This Authentication is an Interface. Represents the token for an authentication request or for an authenticated 
principal once the request has been processed by the AuthenticationManager.authenticate(Authentication) method.
5.Once the request has been authenticated, the Authentication will usually be stored in a thread-local 
SecurityContext managed by the SecurityContextHolder by the authentication mechanism which is being used.
*****************************************************************************
The main strategy interface for authentication is AuthenticationManager, which has only one method:

public interface AuthenticationManager {

  Authentication authenticate(Authentication authentication)
    throws AuthenticationException;
}

* AuthenticationManager
--------------------------
1.When user tries to access an application, the http request is intercepted by filter/filter chain. 
2.Using the Authentication Object created the filter will then call the authenticate method 
 of the Authentication Manager. The Authentication Manager is only a interface and actual implementation of the 
 authenticate method is provided by the ProviderManager.
                                             3. The ProviderManager has a list of AuthenticationProviders i.e There 
 can be various types of authentication providers which will be handled by ProviderManager because Authentication
 Manager not able to decide to which Authentication Provider should i select.
 4.Now Authentication Manager will take help of UserDetailsService.

"public interface UserDetailsService"
Core interface which loads user-specific data.
 5.It is used throughout the framework as a user DAO and is the strategy used by the DaoAuthenticationProvider.
Basically UserDetailsService contains that method which loads data from the database."loadUserByUsername​(java.lang.String username)"
Locates the user based on the username.
Parameters:
username - the username identifying the user whose data is required.
Returns:
a fully populated user record (never null).
Now Authentication Provider will call our authenticate() method.

authenticate() method
---------------------
1.Authentication authenticate​(Authentication authentication) throws AuthenticationException.
2.Attempts to authenticate the passed Authentication object, returning a fully populated Authentication 
object (including granted authorities) if successful.

6.Now in that fully populated Authentication object, Authentication Provider sets the property called 
authenticated=true and return a valid authentication object.
7.Then Provider Manager sends that object to the Filter.
8.Now that valid authentication object get stored in SecurityContext.

*****************************************************************************
-------------------------------
AuthenticationProvider - The AuthenicationProvider is an interface with an authenticate and a supports method. 
It has various implementations like CasAuthenticationProvider or DaoAuthenticationProvider. Depending on the 
implementation an appropriate AuthenicationProvider implementation is used. It is in the AuthenticationProvider 
implementation authenticate method where all the actual authentication takes place.
-------------------------------

























===============================================================================================================


*************************************************************************************************************
SO, DeligatingFilterProxy -> SecurityFilterChain -> Authentication Filter <=> 								|
{(Authentication Manager <-> ProviderManager) && Security Context(Authentication Principal + Authorities)}	|
			↓																								|
 Authentication Manager<=> Authentication Provider ->UserDetailsService <-> UserDetails <=> User (DB).		|
*************************************************************************************************************

It will extract my servlet request and it will convert that request to authentication object.
Now this Authentication Object contain userName and  password as a principal object and also it contains on 
credential object.
But filter dont know how to authenticate it i.e filter does not contain any logic for authentication a request.

Thats why filter will deligate the authentication request to one more component that is called Authentication 
Manager. 

Now this Authentication Manager takes the authentication object as argument and it will call the 
authenticate(Authentication auth) method. But Authentication Manager dont know how to authenticate a request. 
So the Authentication Manager will deligate the request to one more component that is Authentication Provider.

Now Spring framework provided multiple Authentication Provider based on Authentication Mechanism.

Lets take an example the 1st Authentication Provider know how to authenticate based on Token.
And 2nd Authentication Provider knows how to authenticate based on UserName and Password.
And 3rd Authentication Provider knows how to handle the LDAP server or OAuth.

It is difficult for Authentication Manager to identify who is the appropriate authenticate provider and to whom it
can redirect the request.
So direclty not able to deligate the request to the Authentication Provider. So the responsibility maintained by 
ProviderManager after requesting by the Authentication Manager.

Now Provider Manager checks for each and every Authentication Provider calling the support method.
Lets assume Provider Manager goes to 1st Authentication Provider and it return false becsause the operation is
appropriate for the AuthenticationZ Provider. Then goes to the second Authentication Provider and again it will 
check the support method. If it will support this kind of Authentication Mechanism it will return true else false
and it return false because it does not support.
Now Provider Manager goes to the 3rd one and it return true because this allows to Authenticate by UserName and 
Password. 
Now Request will deligate to the 3rd Authentication Provider.

Now this Authentication Provider will invoke authenticate() method but to authenticate a request Authentication 
Provider should have information about the UserDetails object because without it how it will check whether username 
and password is valid or not. We need to compare. Either we can compare with database or inMemory case.
So to load the user object from external resource Authentication Provider will take the help from anathor
component that is called UserDetailsService.
Now this UserDetailsService will go to the external resource like database or cache, based on your UserName it will
load the details User detail object and it will return back to the Authentication Provider.
But if there is no user exist with given username, it will through the Exception like BadCredetialObject.
Now Authentication Provider will authenticate it and it will return the valid authentication object to Provider
Manager.
Now Provider Manager will return same valid authentication object to the Filter.
Now Filter will store the valid authentication object to security context.

SecurityContextHolder.getContext().setAuthentication(authentication);

Once your authentication object sets to your security context then your request will redirect to your server side 
application.
So this is how spring security work behind the scene.



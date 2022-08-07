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

*Authorization
--------------
Giving the user permission to access a specific resource or function.

*Filter (It helps for the preprocessing)
-------
1.A filter is an object that is invoked at the preprocessing or postprocessing of a request.
2.Spring security takes the help of filter before accessing the API to controller/servlet.
3.It has the methods like "do()" and "filter()".
4.As the client try to request to the server then prior to the processing the request goes to the filter because 
we already configure accordingly. If request goes well then further processing will be  done else it will through 
the response to the client.

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


authenticate() method
---------------------
1.Authentication authenticate​(Authentication authentication) throws AuthenticationException.
2.Attempts to authenticate the passed Authentication object, returning a fully populated Authentication 
object (including granted authorities) if successful.

 ------------------------------
 AuthenticationManager - When user tries to access an application, the http request is intercepted by 
 filter/filter chain. Using the Authentication Object created the filter will then call the authenticate method 
 of the Authentication Manager. The Authentication Manager is only a interface and actual implementation of the 
 authenticate method is provided by the ProviderManager.The ProviderManager has a list of AuthenticationProviders.
  From its authenticate method it calls the authenticate method of the appropriate AuthenticateProvider.
   In response it gets the Principal Authentication Object if the authentication is successful.
-------------------------------
AuthenticationProvider - The AuthenicationProvider is an interface with an authenticate and a supports method. 
It has various implementations like CasAuthenticationProvider or DaoAuthenticationProvider. Depending on the 
implementation an appropriate AuthenicationProvider implementation is used. It is in the AuthenticationProvider 
implementation authenticate method where all the actual authentication takes place.
-------------------------------


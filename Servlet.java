													Servlet
													========
Servlet is basically a JAVA program that runs particularly inside JVM.
Servlet technology is used to create a web application (resides at server side and generates a dynamic web page).
Before Servlet, CGI (Common Gateway Interface) scripting language was common as a server-side programming language. 

Web Container can be like JBoss, Glass Fish, Tomcat, IBM Web Sphere.
While client request to the server for a page as a response then in the server, we have a component called 
Helper Application (Web Container). In this Web Container we have Servlet. Servlet is basically a Java file
which can take the request from the client and sends the response back like a page.

Lets say Tomcat is the web container, so request goes to the Tomcat and that request is for the abc.htm
But I don't have the page called abc.htm .
So we need to build that page. So that request goes to the servlet. To do that Inside the container we have a file
called Deployment Descriptor (web.xml).
Lets say In our Tomcat there are 50-60 servlets. So every request maps with each servlet.
It can be happen that multiple request can access the same servlet. Everything need to be configured in a file called
deployment discriptor and this file is web.xml.

So mapping of the request will be done by the web.xml.
In this file basically have:
<servlet> and the <servlet-mapping>
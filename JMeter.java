

* It is opensource software.
* It is purely java based to perform the load test. We can measure the performance of the application.


Lets say we have many ecommerce applications
1. Amazon
2. Flipkart
3. Myntra
4. Walmart

Flipkart has a sale yearly called (**THE BIG BILLION DAYS). All the customers eagerly waits for that day.
So in that time period million or billions of customers hits the application to purchase commodities.

In this scenario, the application should be capable to handle those requests/concurrent requests.

Now how they will verify application performace
------------------------------------------------
So here they might need a proper test plan.
There are n number of tools available in market. (JMeter is the tool here).



* Download jmeter.
* sh jmeter.sh (As it will run, it will create a GUI page for us.)

Jmeter options -> Look & Feel -> System

1st step is testPlan. 
Name the test plan(spring boot performance test).

Start the springboot project.
Right Click on Test Plan -> Add -> Threads (Users) -> Thread Group -> In this page fill 
No of Threads: 1
Ramp-up period: 1
Loop-count:1

Then,

Right Click on Test Plan -> Add -> Sampler -> HTTP Request -> In this page fill 
fill protocol,
Name: HTTP GET Request
Server Name or IP: localhost
Port Number:9191
HTTP Request:Get
Path: /products

To view the response you must add one Listener

Right Click on Test Plan -> Add -> Listener -> View Result's Tree -> In this page fill 


Save icon at the Home bar, click on it to Save.
Save as by giving file name (spring boot crud performane test.jmx)

Go to HTTP GET Request on the left pane, now tun your endpoint by click on Run icon, then check the View Result Tree.
SAMPLE RESULT
===============
Here Thread Name:
Sample Start
Load Time: 172 //for fetching 5000 records, no of ms that server took to serve the request. Time taken by the server to take time to fully server the request. 
Connect Time: 37
Latency:164 //no of milliseconds that elapsed between when jMeter send the request and when an initial response was received from API
Size in Bytes:
Sent Bytes:
Headers size in Bytes:
Sample Count:
Error Count:
Data type:
Response Code:200
Response Message:

HTTPSampleResult fields:
ContentType:application/json
DataEncoding: null

Also we can see Request and Response Data

Similiarly for PUT, POST we can create HTTP Request in same way.
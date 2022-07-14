https://www.9xflix.tk/
https://sflix.to/
https://steamunlocked.net/26-forza-horizon-5-free-download/




Techvalens software system pvt ltd
Mr. Anurag Agarwal
Mr. Harshit Bansal
Team Size - 60 + members 
Mr. Himanshu Joshi
Location Indore WFO
techvalens.com
14 Years*/
/*
fcm 
google mail service
ocr 
aws mail service

biggest challange


hello, my name is keshav vyas from indore madyapradesh.
currently m having 3+ years of experience in techvalens software system pvt ltd
so my primary skill set are java spring boot jpa and my secondary skills are reactjs and javascript 
a have also used aws for deployment purpose some times
coming to my projects
my most recent project is macjine legder


1. MarkUs(mobile for user and web for admin)********************************************
    
  university project 
  admin will upload question paper and answers sheet
  we will use ocr for scanning the question sheet 
  make name using algorithm
  save in local and upload in s3 bucket
  user will scan paper 
  same algo will be used to create name and search in database
  or we can upload the fields manually
  
  7 fields are there
    exam 
    exam board
    level
    month
    paper
    subject
    year

  Ocr was challanging 
  Google ocr 

MYPART___--__--__--__--__--__--__--__--__--__--


2.COMMUNICATOR(microservice)***************************************************************
  
  Microservice
  support system
  group and solo chat via web socket
  fcm for push notification
  google mail service for mailing 

  Challange
    Web sockets calls and woring of web socket
    and live communication


MYPART___--__--__--__--__--__--__--__--__--__--
      group chat
      solo chat 
      file sharing 
      using s3 bucket.




multithreading 
aws ses mail service
forecatsing
usermodule 
hosted on aws in 
payment integration

3.MACHINE LEDGER(web based)******************************************************************
  Account management system.
  Saas based application xero as based application 
  register 
  add xero organization 
  fetch details from xero 
  use this for forecasting
  make accurate forecast
  mail server
  creating mail server 
  sending to everyone 
  communication on one place
  ocr for invoice scanning 
  
  challange
      multithreading
      forecasting

  making calculation on basis of type of invoice 
  tax cauculation 
  salary calculation 
  that to weekly 3 weekly 
  monthly 
  quaterly
  anually

  implementing the logic as difficult
  hit and trail was used


2 types of invoices
complete (bnai he or payment bhi complete h)
draft (bnai he pr payment nahi hua h)

can be completed 

xero 
 95 to 100 percentage accuracy
 excel for doc is used.



ExecutorService
fetchAllARInvoices
fetchAllAROverpayments
fetchAllARCreditNotes
fetchAllAPInvoices
fetchAllAPCreditNotes
calculateAveragePaymentDaysForCustomers




MYPART___--__--__--__--__--__--__--__--__--__--





4. vomvos****************************************************************************************
  
  social networking application
  web based
  media sharing and social networking
  user can register and upload content 

  normal user can become creator
  creator can charge for his content
  and he will earn form his subscribers

  for becoming creator he need to fill a form of all the details 

  also we have provided safe and unsafe mode for below 18 and above 18 users 

  chatting and other features are also implemented

  both forntend and backend
  
  challange 
     communicator integration 
     post management
     infinite scroll 
     managing last post on time basis


MYPART___--__--__--__--__--__--__--__--__--__--
  Login page
   and
  than after login page 
   and 
  user profile


i

















FCM for PUSHNOTIFICATIONS
      Open fcm 
      Create account on it
      create proect here 
      same project is required to configure on every device 
      like in android ios and springboot 
      here on fcm console select your project
      goto the project settings
      here details can be given everywhere on android and ...
      now go to service accout and click on java
      and generate private key
      download this file in your system(json)
      now create spring boot application
      add firebase admin dependency
      now we need to copy the file in src main resource(the key file)
      set file in properties path also as configuration class
      
      create models - for notification and status and message  
      
      title message topic token
      create service classes
      now create object of FireBaseOptions using the configuration file
      Message message = here create an object with setting all the properties of message
      at the end 
        return FirebaseMessaging.getInstance().sendAsync(message).get();
      topic is not getting used here

               

               val message = Message.builder()
    .setNotification(Notification.builder()
        .setTitle("From Wayne's Talk")
        .setBody("Hello Wayns's Talk")
        .build())
    .putData("payload1", "data1")
    .putData("payload2", "data2")
    .setToken(fcmToken)
    .build()
FirebaseMessaging.getInstance().send(message)



val message = MulticastMessage.builder()
    .setNotification(Notification.builder()
        .setTitle("From Wayne's Talk")
        .setBody("Hello Wayns's Talk")
        .build())
    .putData("payload1", "data1")
    .putData("payload2", "data2")
    .addAllTokens(arrayListOf(fcmToken1, fcmToken2))
    .build()
FirebaseMessaging.getInstance().sendMulticast(message)



























1.
  Its a saas based application which uses xero as its base application.
  frist the user registers in machine ledger and adds his xero organization here
  after this all the information like employees customers invoices salaries 
  incomings and outgoings , account detais are fetched in our system 
  here we are using all these details for forecasting purpose like we can calculate 
  state for a particular time by calculatin all the outgoings and incomings.
  also we have used aws mail server to create the mail on adding the organization
  this mail is updated to all the customesr and suppliers and the employess 
  so that all the communication to the company can be done throuh this mail 
  we have implemented ocr also for scanning the invoices to extract the necessary details.
	
	key learnings from this project was that how we impelment a saas based application 
  also and also i have used multithreading for fetcing the data from xero to our system
  so this was also quite challenging.
  also forecasting was challenging beacause the forecast must be accurate in thi case as 
  this may affect the company alot.


2.
  Before this i worked on communicator so basically communicator is a microservice
  this is being used as a support system in multiple projects of the company
  this provides the facility for chatting between thr users via websockets.
  here the feature of solo as well as group chat is also provided 
  also we have implemented fcm for notificaton purpose and we have used google mail service for mailing system.
  apart from this we have used aws ses for text messeges.

	key learnings from this project was to implement web socket for communication purpose..
  
	


3.
  i have also worked on marks 



  key learnings


4. 
  coming to the first project of my carrear it was vomvos 
  this is a social networking based application. here after registration
  user can upload various contents like images videos and documents.
  this application is developed in a way that it works as a media sharing
  platform and social networking website on the same time
  also users can earn subcribers from his content and then he can 
  earn money through these subscribers.
  also the application provides two different modes i.e. safe and unsafe mode 
  in which user can get content accordingly.
  chatting feature is also provided like any other social networking website. 
  this was my first project and i have worked on both front end as well as backend 
  of this project.


  key learnings





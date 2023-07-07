											SOLID PRINCIPLES
											=================
* SOLID principles are an object-oriented approach that are applied to software structure design. 
* It is conceptualized by Robert C. Martin
* SOLID is an acronym for five object-oriented design principles that help to create better software. The principles are:

Single responsibility principle: A class should have only one responsibility.
Open-closed principle: A class should be open for extension, but closed for modification.
Liskov substitution principle: Derived classes must be substitutable for their base classes.
Interface segregation principle: Clients should not be forced to depend on methods they do not use.
Dependency inversion principle: Depend upon abstractions, not concretions.

The SOLID principles are a set of guidelines that can help you to write better code. By following these principles, you can create code that is 
more maintainable, extensible, and reusable.

Single Responsibility Principle

:  The single responsibility principle (SRP) is a software design principle that states that 
---------------------------------every class should have only one reason to change. This means that a class 
should only have one responsibility.

This principle states that “a class should have only one reason to change” which means every class 
should have a single responsibility or single job or single purpose

Lets say we have BankService class and all the methods are inside the class.

The principle can be well understood with an example. 
Imagine there is a class called BankService which performs following operations.

Withdraw
Deposit
Print Pass Book
Get Loan Info
Send OTP

package com.solid.srp;


public class BankService {

    public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }

    public void printPassbook() {
        //update transaction info in passbook
    }
    
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }

    public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }

}

For example look into getLoanInterestInfo() method , now bank service provide only info for Personal 
Loan , Home Loan and car loan let’s say in future bank people want to provide some other loan feature like 
gold loan and study loan then again you need to modify this class implementation right ?

similarly you can consider sendOTP() method , let’s assume BankService support send OTP medium as a 
email but in future they might want to introduced send OTP medium as Phone then again you need to change its implementation

it doesn’t follow single responsibility principle because this class has to many responsible or task to perform

o achieve the goal of the single responsibility principle, we should implement a separate class that performs a 
single functionality only.

For Example , we can move Print related code snippet to Printer Service

public class PrinterService{
 public void printPassbook() {
        //update transaction info in passbook
    }
}

Similarly Loan related job

public class LoanService{
public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }
}

similarly OTP related Job

public class NotificationService{
public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
}

Now if you observe Each class have single Responsibility to perform their task .which is exactly SRP says
================================================================================================================

Open-closed Principle
---------------------
This principle states that “software entities (classes, modules, functions, etc.) should be open for 
extension, but closed for modification” which means you should be able to extend a class behavior, without modifying it.
which means you should be able to extend a class behavior, without modifying it.

let’s understand this principle with an example .let’s consider the same Notification service which we just created .

public class NotificationService{
public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
            //use JavaMailSenderAPI
        }
    }
}

Here as discussed earlier if you want to introduced send OTP via mobile Phone or WhatsApp number then you 
need to modify source code in Notification Service right ?

Here What OCP says , It open for Extension but close for modification hence its not recommended to modify 
Notification Service for each OTP Feature , it will violate OCP

You can design something like below

public interface NotificationService{
public void sendOTP(String medium);
public void sendTransactionNotification(String medium);
}

EmailNotification implementation

public class EmailNotification implements NotificationService{
public void sendOTP(String medium){
// write Logic using JavaEmail api
}
public void sendTransactionNotification(String medium){
}
}

Mobile Notification implementation

public class MobileNotification implements NotificationService{
public void sendOTP(String medium){
// write Logic using Twilio SMS API
}
public void sendTransactionNotification(String medium){
}
}
similarly you can add implementation for WhatsApp notification service

public class WhatsAppNotification implements NotificationService{
public void sendOTP(String medium){
// write Logic using whatsapp API
}
public void sendTransactionNotification(String medium){
}
}


Liskov substitution Principle (LSP)
-----------------------------------
This principle states that “Derived or child classes must be substitutable for their base or parent classes”.

In other words, if class A is a subtype of class B, then we should be able to replace B with A without interrupting 
the behavior of the program.

Let’s consider I have an abstract class called SocialMedia , who supported all social media activity for user to 
entertain them like below

package com.solid.srp;

public abstract class SocialMedia {
    
    public abstract  void chatWithFriend();
    
    public abstract void publishPost(Object post);
    
    public abstract  void sendPhotosAndVideos();
    
    public abstract  void groupVideoCall(String... users);
}

Social media can have multiple implementation or can have multiple child like Facebook, 
WhatsApp ,instagram and Twitter etc..

now let’s assume Facebook want to use this features or functionality .

package com.solid.srp;

public class Facebook extends SocialMedia {

    public void chatWithFriend() {
        //logic  
    }

    public void publishPost(Object post) {
        //logic  
    }

    public void sendPhotosAndVideos() {
        //logic  
    }

    public void groupVideoCall(String... users) {
        //logic  
    }
}

Now let’s discuss WhatsApp class


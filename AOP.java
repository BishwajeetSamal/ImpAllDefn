														AOP (Aspect Oriented Programming)
														=================================

AOP is a Programming paradigm aiming to segregate cross-cutting functionalities, such as logging, from 
business ligoc in an application.

*Springboot application mainly divided into three Layers:

1. Web Layer for exposing the services using RESTFul web services.
2. Business layer to havle business Logic.
3. Data Layer for data persistent logic.

* Each layer is having different responsibility and there are some common aspects which gets apply
to all layers. e.g Logging, Security, Validation etc.
Common aspectes are also called as cross-cutting concerns.

* Spring AOP has interceptors which can intercept application and its methods.

What is a cross-cutting concerns ?
----------------------------------
Cross-cutting concerns are separate from the primary functionality of the application and are more related to the 
infrastructure, architecture, or auxiliary features that support the core business logic. Some common examples of 
cross-cutting concerns include:

Logging: Adding log statements to track the flow and behavior of the application can involve changes in multiple 
parts of the codebase.

Security: Implementing security features like authentication, authorization, and encryption often requires changes 
across various components.

Error Handling: Dealing with errors and exceptions might involve adding error-handling code throughout the application.

Caching: Implementing caching mechanisms for performance optimization can affect multiple parts of the codebase.

Monitoring and Metrics: Integrating tools for monitoring application health and collecting performance metrics can require 
changes in various modules.

Transaction Management: Handling database transactions consistently throughout the application can be a cross-cutting concern.

Localization: Adding support for multiple languages and locales may involve modifications across different parts of the code.

Concurrency and Threading: Managing concurrent execution and threading safely can impact various areas of the code.

Auditing and Compliance: Implementing auditing or compliance features often requires modifications across different 
parts of the application to track user actions and changes.

Configuration Management: Changing configurations and settings may require updates in different parts of the codebase.

Due to their nature, cross-cutting concerns can lead to code duplication, reduced maintainability, and decreased modularity. 
To address these challenges, various design patterns and techniques have been developed. One common approach is to use 
aspects or aspect-oriented programming (AOP), where cross-cutting concerns are modularized and separated from the main 
business logic.

* Aspect
  ------
 Aspect is a class in which we define Pointcuts and Advices.

* Advice
 -------
Its the behavior that addresses system-wide concerns(logging, security checks etc..).
This behaviour is represented by a method to be executed at a JoinPoint.
This behaviour can be executed Before, After or Around the JoinPoint according to the Advice type.

* PointCut
 --------
A pointcut is an expression that defines at what JoinPoints a given Advice should be applied.

* JoinPoint
 -----------
 Simply put, a joinpoint is a point in the execution flow of a method whereas an Aspect(new Behaviour)
can be plugged in.






Let's do the Logging as a seperate aspect.
------------------------------------------
AOP gives you a way to segregate your Logging feature from your Business Logic, all your controller logic.

We have a controller class named as EmployeeController.java
------------------------------------------------------------

class EmployeeController{
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all")
	public ResponseEntity<?> fetchAllEmployee(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmps(),HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee e) throws Exception{
		return new ResponseEntity<Employee>(employeeService.aaddEmployee(e),HttpStatus.OK);
	}
}

We also have a service class example named as EmployeeService.java
-------------------------------------------------------------------
@Service
public class EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmps(){
		return employeeRepository.findAll();
	}


	public Employee addEmployee(Employee e) throws Exception{
		if(e.getName().length > 5)
			throw Exception("sorry reduce the size of your name")
			return employeeRepository.save();
	}
}



Create an AOP folder.
Lets say EmployeeAspect.java
		--------------------
		@Aspect
		@Component
		public class EmployeeAspect{
			//This is Pointcut expression.
			@Before(value = "execution(* fully_qualified_controller_class_name.Controller_class_name.*(..)")//On which controller you 
			//want to perform and then provide the controller name and then * means to all methods of Controller
			// (..) used for any number of parameters allowed. And this becomes the Pointcut expression.

			// Ques-> What is Pointcut expression.
		//Ans -> Before executing any method of that "controller" with any number of arguments, then do what has been written 
			//according to Pointcut as mentioned above here.

			public void beforeAdvice(JoinPoint joinPoint){
		// this join point will be the place where this pointcut executes. Ponitcut will execute on Methods of controller.
			// the join point is the logic where your advice is implemented and how do you tell where it has to 
			//be implemented, using this "@Before(value = "execution(* fully_qualified_controller_class_name.Controller_class_name.*(..)")"
			//pointcut expression.
			//this pointcut expression is going to cut through your business logics method and implemented that 
			//Advice method before or After it. 
				System.out.println("Request to controller layer "+joinPoint.getSignature()+ "started at "+ new Date());
			}


	
			@After(value = "execution(* fully_qualified_controller_class_name.Controller_class_name.*(..)")
			public void afterAdvice(JoinPoint joinPoint){
				System.out.println("Request to controller layer "+joinPoint.getSignature()+ "ended at "+ new Date());
			}

			
			@After(value = "execution(* fully_qualified_service_class_name.Service_class_name.*(..)")
			public void beforeAdviceForService(JoinPoint joinPoint){
				System.out.println("Request to service layer "+joinPoint.getSignature()+ "ended at "+ new Date());
			}

			
			@After(value = "execution(* fully_qualified_service_class_name.Service_class_name.*(..)")
			public void afterAdviceForService(JoinPoint joinPoint){
				System.out.println("Request to service layer "+joinPoint.getSignature()+ "ended at "+ new Date());
			}

			@AfterReturning(value = "execution(* fully_qualified_service_class_name.Service_class_name.*(..)", returning ="employee" )
			public void afterReturningAdviceForAddEmpService(JoinPoint joinPoint, Employee employee){
				System.out.println("Business logic to save an employee ran succesfully and employee is saved with id "+ employee.getId());
			}


			@AfterThrowing(value = "execution(* fully_qualified_service_class_name.Service_class_name.addEmployee(..)",throwing = "exception")
			public void afterThrowingAdviceForAddEmpService(JoinPoint joinPoint, Exception e){
				System.out.println("Business logic to save an employee threw an exception"+ e.getMessage());
			}

			@Around(value = "execution(* fully_qualified_service_class_name.Service_class_name.addEmployee(..)")
			public void aroundAdviceForAddEmpService(ProceedingJoinPoint proceedingJoinPoint){
				System.out.println("Inside Around Advice in Aspect : Business logic to save employee started at "+new Date());
				try{
					proceedingJoinPoint.proceed();
				}catch(Throwable e){
					throw new RuntimeException(e);
				}
			}

			//we can also return the Object, whatever we want to return
			@Around(value = "execution(* fully_qualified_service_class_name.Service_class_name.addEmployee(..)")
			public void aroundAdviceForAddEmpService(ProceedingJoinPoint proceedingJoinPoint){
				System.out.println("Inside Around Advice in Aspect : Business logic to save employee started at "+new Date());
				try{

					Employee emp = (Employee) proceedingJoinPoint.proceed(); // its return Object type, thats why we need to 
					//typecast over here.
					return emp;
				}catch(Throwable e){
					throw new RuntimeException(e);
				}
			}
		}

All the methods inside the Aspect becomes the "Advice".
Here, fetchAllEmployee, addEmployee are JoinPoint.

joinPoint.getSignature() will provide me the method name.

As you run the program and hit the request. Then before it, it will go to the Pointcut matched with the JoinPoint
and execute it first then go to controller and then to service respectively.

**ASPECT can have multiple cross cutting concerns like Logging, Security, Caching Maintenance etc can be created as a 
seperate Aspect.

@Before -> Advice that executes before a join point, but which does not have the ability to prevent to prevent
execution flow proceeding to the join point (unless it throws an exception).

@AfterReturning: Advice to be executed after a join point completes normally.

@AfterThrowing: Advice to be executed if a method exits by throwing an exception.

@After: Advce to be executed regardless of the means by which a join point exits (normal or exceptional return).
________________________________________________________________
**Note-> @After is called just next by @AfterReturning same in  |
@After is executed after the execution of @AfterThrowing 		|
________________________________________________________________|

@Around:
-------
* Advice that surrounds a join point such as a method invocation. The first parameter of the advice method must be of 
type ProceedingJoinPoint.

* Within the body of the advice, calling proceed() on the ProceedingJoinPoint causes the underlying method to execute.

*The proceed method may also be called passing in an Object[] - the values in the array will be used as the
arguments to the method execution when it proceeds.

* The value returned by the aroung advice will be return value seen by the caller of the method.

*A simple caching aspect for example could return a value from a cache if it has one, and invoke procced() if it does not.

* Note that proceed may be invoked once, many times, or not at all within the body of the around advice, all of these are 
quite legal.




Introduction
------------
Go language is created at google by these three developers.
1.Robert Griesemer
2.Rob Pike
3.Ken Thompson

*It is statically typed language.
*Community Support
*Simplicity
*Faster compile time
*Garbage Collection
*Builtin Concurrency
*Standard Libraries
Developer get fast compilation as compared to other languages because other programming languages have like 
Inheritance etc.
*Go compiler handles the Garbage Collection automatically.

------------------------------------------------------------------------
Resources
----------
1. golang.org
cmd -> go env //to check for the environment. One of the important one is GOPATH=C:/Users/../..
GOPATH defines where your go is installed and where all your libraries will be installed when you are doing (go get).

Suppose a new package is installed, it will get stored to the mentioned path by GOPATH.

Create your project in your Go Workspace.

GO WORKSPACE

	-bin
	-src
		-github.com
			bishwajeet
				-project_1
					*project_files
				-project_2
					*project_files
-pkg


Variables  //In go if you have defined a variable then you have to use it otherwise it will through a compile time err.
----------
var i int
i = 12
fmt.Println(i)

//or we can write like this 
var i int = 12
fmt.Println(i)

//or we can write like this 
var i = 12 //It will automatically fetch the type by the value
fmt.Println(i)

//or we can write like this 
 i := 12
fmt.Println(i)

Now if you want to see, what type of variable, then 

fmt.Printf("%v, %T\n"i,i)


----------
Now, 

var i = 34

func main(){
	var i = 12
	fmt.Printf("%v, %T\n",i i)  
}
//Here both the variables defined. One is having global scope and one is having local scope. So this is allowed.
//If the function dont have local varibale then it will print the value of global variable if available.

// If I defined the variable with lowercase having global scope then this variable is allowed in the package.
// If I defined the variable with UpperCase having global scope then this variable is allowed outside the package also.
-------------------------------------------------------------------------------------------------------------------
func main(){
	var i = 12 
	var j float32 = i //compiler will through the error
	var j float32 = float32(i) // this is correct one, by type casting
	fmt.Printf("%v, %T\n",i i)  
}

//If we dont intialize the varibale then by default it will assign (Zero) 0.

---------------------------------------------------------------------------------------------------------------------
suppose we are initilizing 
var j float32 = 3.4
k:= 3.4 //it will default give the type float64, default it will provide upper level type if we dont mention.

Lets now check for String

var foo = i //not allowed
var foo = string(i) // whenever we tried to convert an integer values to string then we are getting the ASCII code
//and whatever string is available to that ASCII code, that we will get. 
But if I want here 12 as string, then we need to use strconv package over here.

var foo string = strconv.Itoa(i)

-------------------------------------------------------------------------------------------------------------------

var bar bool = true

------------------------------------------------------------------------------------------------------------------

Primitive Types
----------------
func main()
{
	var i int = 12
	var foo = true
	fmt.Printf("%v  %T", foo, foo)
}


For intergers we have many types
----------------------------------
uint8			unsigned 8-bit integers (0 to 255)

uint16			unsigned 16-bit integers (0 to 65535)

uint32			unsigned 32-bit integers (0 to 4294967295)

uint64			unsigned 64-bit integers (0 to 18446744073709551615)

int8			signed 8-bit integers (-128 to 127)

int16			signed 16-bit integers (-32768 to 32767)

int32			signed 32-bit integers (-2147483648 to 2147483647)			

int64      		signed 64-bit integers (-9223372036854775808 to 9223372036854775807)


func main(){
	var	i int8 = 1 
	var j int16 = i // not allowed
	var j int16 = int16(i) //allowed
}

We also have complex type
-------------------------
complex64
complex128

var i complex64 = 1+2i //are of float type. value will be of float32
var i complex128 = 1+2i //are of float type. va;ue wil be of float64

We also have the complex() method.
var i complex64 = complex(2, 4)

--------------------------------------------------------------------------------------------------------------
Constants
---------
Constant are very similiar to varibales, the only difference is if you assign a value you will not able to change it.

const i int = 12 //If we dont use it, then compiler won't thrrows an error.

func main(){
	const i int = 12
	const j float32 = 3.14
	const k string = "This is const"
	const l bool = true
}

Now there is a special type of constant.

Innumerated Constant
----------------------
 const incr1  = iota
 const incr2  = iota
 const incr3  = iota

 const(
 	i = iota
 	j = iota
 	k = iota	 	  
 ) 

 func main(){
 	fmt.Println(i) //0
 	fmt.Println(j) //1
 	fmt.Println(k)  //2

 	The vlaue is increased within the block of constant.
 }
----------------------------------
const(
 	i = iota
 	j 
 	k 	 	  
 )

 func main(){
 	fmt.Println(i) //0
 	fmt.Println(j) //1
 	fmt.Println(k)  //2

 	The vlaue is increased within the block of constant.
 }
------------------------------
const(
 	i = iota
 	_   //to skip the value
 	_
 	j 
 	k 	 	  
 )

 func main(){
 	fmt.Println(i) //0
 	fmt.Println(j) //3
 	fmt.Println(k)  //4

 	The vlaue is increased within the block of constant.
 }

------------------------------------------------------------------------------------------------------------------
Arrays
------
Array is a collection of similiar types of data types.

func main(){
	var amounts [3] int = [3]int {10,20,30}
	amt := [3]int{10,20,30}
	fmt.Printf("Amount: %v" amounts) //[10 20 30]
	fmt.Printf("Amount: %v" amt) //[10 20 30]
	fmt.Printf("Length: %v" len(amt)) //3
}

   amt := [...]int{10,20,30,30,40,50}// If we dont give the size but we give the values in time of initialization

  *To copy all the values from one array to anathor array
  a := amounts //same element as amounts array contain

  *If I want the same address want to provide so that the variable name can access the same array then we will use
  a: = &amounts //It will not copy all the elements rather it will provide or assign the address of that array to this.


  func main(){
  	a := [...]int{1,2,3,4,5,6,7,8,9,10}
  	b := a[:] //Slicing Operator, It will copy the entire data of a to b
  	c := a[2:] // It will copy the elements from the 2nd position
  	d := a[:5] // It will copy the elements from beginning to 4th i.e (5-1) position
  	e = a[2:7] // It will copy the elements from the 2nd position to 6th i.e (7-1) position
  }

MultiDimentional Array
----------------------
func main(){
	var identityMatrix = [3][3]int = [3][3]{
		[3]int{1, 0, 0},
		[3]int{0, 1, 0},
		[3]int{0, 0, 1}
	}
	fmt.Println(identityMatrix) // [[1 0 0] [0 1 0] [0 0 1]]
	fmt.Println(identityMatrix[0][0]) // 1
	fmt.Println(identityMatrix[1][2])  = 7

}

-------------------------------------------------------------------------------------------------------------
Slices
-------
Slices work differently than array.
Slices have its internal structure as array, It will point to that particular array.
So if you copying the data then it will pass the location of it.
func main(){
	var a []int = []int{1,2,3}
	var b []int = a  // It will not copy the data but it will store the pointer location of variable a
	fmt.Println(a) //1,2,3
	}

//We also can get the length of slices
fmt.Println(len(a)) //3
fmt.Println(cap(a)) //3
fmt.Println(b)//[1 2 3]

There is also a make() function, through this we can make a slice

var a []int = make([]int, 3, 10)

Lets create the slice

func main(){
	var a []int = []int{1, 2, 3}
	var b []int = append(a, 5)
	var c []int = append(a[1:], 5)
	var d []int = append(b, a...)
	fmt.Println(a) //[1 2 3]
	fmt.Println(b)//[1 2 3 5]
	fmt.Println(b)//[2 3 5]
	fmt.Println(c)//[1 2 3 5 1 2 3]
	}

------------------------------------------------------------------------------------------------------------------
Maps
----
func main(){
	shoppingCart := make(map[string]int)
	shoppingCart = map[String]int{
		"Keyboard": 100,
		"Mouse": 	50,
		"Laptop":	1000,
	}
	fmt.Println(shoppingCart) // map[Keyboard:100 Laptop:1000 Mouse:50]	
	fmt.Println(shoppingCart["Keyboard"]) //100
	shoppingCart["Laptop"] = 1500
	fmt.Println(shoppingCart["Laptop"]) //1500
	fmt.Println(shoppingCart["Mobile"]) //0 but here is no key as Mobile here.
}

Lets use comma Ok syntax here
----------------------------
func main(){
	shoppingCart := make(map[string]int)
	shoppingCart = map[String]int{
		"Keyboard": 100,
		"Mouse": 	50,
		"Laptop":	1000,
	}
	
	fmt.Println(shoppingCart) // map[Keyboard:100 Laptop:1000 Mouse:50]	
	fmt.Println(shoppingCart["Keyboard"]) //100
	shoppingCart["Laptop"] = 1500
	fmt.Println(shoppingCart["Laptop"]) //1500
	fmt.Println(shoppingCart["Mobile"]) //0 but here is no key as Mobile here.

	cart := shoppingCart["Mobile"]
	fmt.Println(cart) //here value is 0

	//Lets use , operator
	cart, ok := shoppingCart["Mobile"]
	fmt.Println(cart,ok) //here value is 0, false

	cart, ok := shoppingCart["Laptop"]
	fmt.Println(cart,ok) //here value is 1500, true

	//Suppose If dont want to use cart, but want to check for true or false using second variable , ok. then use _
	
	_, ok := shoppingCart["Laptop"]
	fmt.Println(cart,ok) // true	

	//Now we will check, how to copy the data
	sc := shoppingCart //this will pass the pointer location, so any change in this map will also make change 
	//in the previous one.
	fmt.Println(sc) //map[Keyboard:100 Laptop:1500 Monitor:1200 Mouse:50]	

	//Now to delete the data, delete() function is here where need to pass map and the key, you want to delete
	delete(shoppingCart, "Monitor")
	fmt.Println(shoppingCart)  //map[Keyboard:100 Laptop:1500 Mouse:50]
}


--------------------------------------------------------------------------------------------------------------
Structs
-------
Structs is a collection of diffrent types of data types.

package main 

//Student Struct
type Student struct{
	Name 		string
	RollNo 		int
	Subjects 	[]string
}


func main(){
	student1 := Student{
		name: "Bishwajeet Samal",
		rollNo: 5,
		subjects: []string{
			"Maths",
			"Physics",
			"Chemistry",
		},
	}
	fmt.Println(student1) //{Bishwajeet Samal 5 [Maths Physics Chemistry]}
	fmt.Println(student1.name) //Bishwajeet Samal
	fmt.Println(student1.subjects) //[Maths Physics Chemistry]
	fmt.Println(student1.subjects[0]) //Maths
}


----------------------------------------------------------------------------------------------------------
Embedding in struct
-------------------
Go supports composition relationship in structs. It doesnot has a Inheritance relationship.
Thus, here it doesnot follow is-a relationship. But use has-a relationship.

package main

//Processor struct
type Processor struct{
	ProcessorName		string
	cores				int 

}

//Memory struct
type Memory struct{
	memoryCapacity 		int
	memoryType			string
}

//Computer struct
type Computer struct{
	Processor
	Memory
	price int
}


func main(){
	computer := Computer{}
	computer.price = 50000
	computer.ProcessorName = "Intel i5"
	computer.cores = 6
	computer.memoryCapacity = 8
	computer.memoryType = "DDR4"

	computer1 := Computer{
		Processor:Processor{
		ProcessorName: "Intel i7",
		cores:			8,
	},
	Memory: Memory{
		memoryCapacity: 16,
		memoryType:  "DDR4"
	},
	price: 70000,

}
	fmt.Println(computer) // {{Intel i5 6} {8 DDR4} 50000}
	fmt.Println(computer1) // {{Intel i7 8} {16 DDR4} 70000}


}

-------------------------------------------------------------------------------------------------------------
If and Switch statements (Control Flow)
---------------------------------------
package main

import "fmt"

func main(){
	shoppingCart := make(map[string]int)
	shoppingCart = map[String]int{
		"Keyboard": 100,
		"Mouse": 	50,
		"Laptop":	1000,
	}

	shoppingCart["Monitor"] = 1200

	if true{
		fmt.Println("This is simple if statement !")
	} //This is simple if statement !

	if i:=2; i==2{
		fmt.Println("This is simple if statement !")
	}
	//This is simple if statement !

	if _,ok := shoppingCart["Monitor"]; ok{
		fmt.Println("Item Exist in the Shopping cart")
	}
//Here we will get the output  -> Item Exist in the Shopping cart

	if i:=2; i==3{
		fmt.Println("This is simple if statement !")
	}else{
		fmt.Println("This is simple else statement !")
	}
	//This is simple else statement !


	if i:=2; i==3{
		fmt.Println("This is simple if statement !")
	}else if i==2{
		fmt.Println("This is simple else if statement !")
	}else{
		fmt.Println("This is simple else statement !")
	}
//This is simple else if statement !


	i:= 10
	j:=20

	if i > 0 && j > 0 {
		fmt.Println("i,j is greater than 0")
	}

	if i > 0 || j > 0 {
		fmt.Println("i,j is greater than 0")
	}

	if i == 0 || j > 0 {
		fmt.Println("i,j is greater than 0")
	}
}



switch (In golang we dont need to use the "break" statement. It will handled implicitly.But if we want to 
handle by ourself, that is also possible to use "break" statement.) 
------

package main 

func main(){
	switch 2 {
	case 1:
		fmt.Println("This is 1")

	case 2:
		fmt.Println("This is 2")

	default:
		fmt.Println("This is default")
	}
}
------------------


func main(){
	switch 2 {
	case 1,3,5,7,9:
		fmt.Println("This is Odd")

	case 2,4,6,8:
		fmt.Println("This is ")

	default:
		fmt.Println("This is default")
	}
}
------------

func main(){
	i := 2 + 3
	switch  {
	case i > 0:
		fmt.Println("This is 1")

	case i < 5:
		fmt.Println("This is 2")

	default:
		fmt.Println("This is default")
	}
}

-----------------
Type Switch in Go Language
---------------------------
func main(){
	var i interface{} = 5  

	switch i.(type){
	case int:
		fmt.Println("This is int type")
	}
	case float64:
		fmt.Println("This is float64 type")

	case string:
		fmt.Println("This is string type")

	default:
		fmt.Println("This is default")
} 
//This is int type
---------------------------

func main(){
	var i interface{} = 5.3 

	switch i.(type){
	case int:
		fmt.Println("This is int type")
	}
	case float64:
		fmt.Println("This is float64 type")

	case string:
		fmt.Println("This is string type")

	default:
		fmt.Println("This is default")
} 
//This is float64 type

---------------------------
func main(){
	var i interface{} = "5.3" 

	switch i.(type){
	case int:
		fmt.Println("This is int type")
	}
	case float64:
		fmt.Println("This is float64 type")

	case string:
		fmt.Println("This is string type")

	default:
		fmt.Println("This is default")
} 
//This is string type


fallthrough (It will continue to the next case statement)
-----------
func main(){

	switch 1{
	case int:
		fmt.Println("This is int type")
		fallthrough
	}
	case float64:
		fmt.Println("This is float64 type")

	case string:
		fmt.Println("This is string type")

	default:
		fmt.Println("This is default")
} 
//This is int type
//This is float64 type

--------------------------------------------------------------------------------------------------------------
Loops
------
func main(){
	for i := 0; i < 5; i++ {
		fmt.Println(i)
	}
}
//0
//1
//2
//3
//4
-------------------------------
func main(){
	for i , j := 0; i < 5; i, j= i+1, j+1 {
		fmt.Println(i, j)
	}
}
//0 0
//1 1
//2 2
//3 3 
//4 4
------------------------------
If I want to print outside the for loop, inside the main method, then
func main(){
	i , j := 0
	for ; i < 5; i, j= i+1, j+1 {
		fmt.Println(i, j)
	}
	fmt.Println(i,j)
}
//0 0
//1 1
//2 2
//3 3 
//4 4
//5 5

*We can write it like this also
func main(){
	i , j := 0
	i < 5 {
		fmt.Println(i, j)
		i, j= i+1, j+1
	}
	fmt.Println(i,j)
}
//0 0
//1 1
//2 2
//3 3 
//4 4
//5 5

Now, lets see with break and continue statement
-----------------------------------------------
func main(){
	i , j := 0, 0
	for i < 10 {
		fmt.Println(i, j)
		i, j= i+1, j+1

	if i == 6 && j == 6
		break
	}
	fmt.Println(i,j)
}
//0 0
//1 1
//2 2
//3 3 
//4 4
//5 5
//6 6

func main(){
	i , j := 0, 0
	for {
		fmt.Println(i, j)
		i, j= i+1, j+1

	if i == 6 && j == 6
		break
	}
	fmt.Println(i,j)
}
//0 0
//1 1
//2 2
//3 3 
//4 4
//5 5
//6 6

func main(){
	i , j := 0, 0
	for i<10{
		if i == 6 && j == 6
		continue
	}
		fmt.Println(i, j)
		i, j= i+1, j+1

	
	fmt.Println(i,j)
}
//0 0
//1 1
//2 2
//3 3 
//4 4
//5 5

package main

func main(){
	for i:=0;i<5;i++{
		for j:=0;j<5;j++{
			fmt.Println(i*j);
		}
	}
}
// 0 0 0 0 0 0 1 2 3 4 0 2 4 6 8 0 3 6 9 12 0 4 8  12 16


func main(){
	for i:=0;i<5;i++{
		for j:=0;j<5;j++{

			if (i*j == 0){
				continue
			}
			fmt.Println(i*j);
		}
	}
}
// 1 2 3 4 2 4 6 8 3 6 9 12 4 8 12 16


func main(){
	a := []int{1, 2, 3, 4, 5, 6, 7}
	for k,v := range a{
		fmt.Println(k,v)
	}
}
//0  1
//1  2
//2  3
//3  4
//4  5
//5  6
//6  7


func main(){
	a := []int{1, 2, 3, 4, 5, 6, 7}
	for _,v := range a{
		fmt.Println(v)
	}
}
//1
//2
//3 
//4 
//5 
//6
//7

func main(){
	shoppingCart = map[String]int{
		"Keyboard": 100,
		"Mouse": 	50,
		"Laptop":	1000,
	}

	shoppingCart["Laptop"] = 1500
	shoppingCart["Monitor"] = 1200

	for k,v := range shoppingCart{
		fmt.Println(k,  v)
	}
}
//Keyboard   100
//Mouse	     50
//Laptop     1500
//Monitor    1200

func main(){
	shoppingCart = map[String]int{
		"Keyboard": 100,
		"Mouse": 	50,
		"Laptop":	1000,
	}

	shoppingCart["Laptop"] = 1500
	shoppingCart["Monitor"] = 1200

	for k,v := range shoppingCart{
		fmt.Println(k)
	}
}
//Keyboard  
//Mouse	    
//Laptop    
//Monitor   
---------------------------------------------------------------------------------------
Defer, Panic and Recover
------------------------
Defer
-----
Defer means you are defering any of the statement to be executed at that particular
moment. That particular statement will executed at the end of that method before
returning the value.


package main 

func main(){
	fmt.Println(1)
	fmt.Println(2)
	fmt.Println(3)
}
//1
//2
//3

func main(){
	fmt.Println(1)
	defer fmt.Println(2)
	fmt.Println(3)
}
//1
//3
//2

func main(){
	defer fmt.Println(1)
	defer fmt.Println(2)
	defer fmt.Println(3)
}
//3
//2
//1

I most cases, golanguage defers are used to free the resources you have created.
Lets take an example,
=============================================================================
func main(){
	f := createFile("defer.txt")
	defer closeFile(f)
	writeFile(f)
}

func createFile(p string) *os.File {
	fmt.Println("creating")
	f, err := os.Create(p)
	if err!=nil {
		panic(err)
	} 
	return f
}

func writeFile(f *os.File){
	fmt.Println("writing")
	fmt.Fprintln(f, "data")
}

func closeFile(f *os.File){
	fmt.Println("closing")
	err := f.Close();

	if err!=nil {
		f.Fprintf(os.Stderr, "error: %v\n", err)
		os.Exit(1)
	}
}	
//creating
//writing 
//closing
================================================================================
panic
-----
*Panic means panicking the application that means something went wrong and golang is not
able to handle that and its not able to recover it. Hence it will through an exception.

*Panic is used send the signal to the compiler that is an unrecoverable condition.

=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*

How Rest APIs works with golang. We will solve all the details into the database.
So we will use the go-orm (gorm) using mux. 

Creating Golang REST API with MUX and GORM
============================================
Package gorilla/mux -> we will use to create http request which cerate our Restful APIs.
So will install the gorilla mux and also the GORM.

1. install gorilla mux -> go get -u github.com/gorilla/mux
2.install gorm -> go get -u gorm.io/gorm 
3. istall postgres -> go get -u gorm.io/driver/postgres 
4. create main.go file (run as administrator vscode due to permission issue (*if occured))
5.create a method that initialize the router

Note : - if this problem (go: cannot determine module path for source directory 
	C:\Program Files\Go\src\projects\CRUDRESTAPI (outside GOPATH, module path must be specified)) occurs then, 
*******************************************************************************************************
	Open the command prompt or terminal.
Navigate to the C:\Program Files\Go\src\projects\CRUDRESTAPI directory using the cd command.
Run the following command to initialize a module with a specific module path:
go mod init example.com/myproject
Replace example.com/myproject with your desired module path. It's recommended to use a valid domain 
name followed by the project name.

After running the command, Go will create a go.mod file in the current directory, and the module
 will be initialized with the specified module path. You should be able to use Go module commands 
 such as go mod tidy without encountering the previous error.

 **Note: If you're working with an existing Go project and it already has a go.mod file, you can 
 simply navigate to the project directory and run go mod tidy to synchronize the dependencies based 
 on the existing module configuration.
 ********************************************************************************************************

 * create Methods, and define the gorm,struct now

 *once we have defined the struct then we have to send and receive data in form of JSON when we are working with REST APIs
type User struct {
	gorm.Model        //now this strut will be treated as model
	FirstName  string `json:"firstname"`
	LastName   string `json:"lastname"`
	Email      string `json:"email"`
} //Now we need to use the struct in our ORM object, so that we can use that model to save or get the data from the db

Once the model is created then go ahead to initialize the database.
Now we will create one method to initialize the db and we will enable the automigration (means gorm will check with the db, 
it will check that will this is available or not), if not then it will create the table. If its already available then
it won't create the table.





Interview Questions 
====================
Que1. What is statically typed language, like golang is?

Ans->A statically typed language is a programming language in which the type of a variable is known at compile time.
This means that the compiler can check the types of variables and expressions to ensure that they are compatible.
This can help to prevent errors at runtime.
Some examples of statically typed languages include:

C
C++
Java
Go
Haskell
Pascal

In contrast, a dynamically typed language is a programming language in which the type of a variable is not known at compile time. 
This means that the compiler cannot check the types of variables and expressions, and errors may not be detected until runtime.

Some examples of dynamically typed languages include:

Python
JavaScript
Ruby
PHP
Perl
===============================================================================================

Origin and Evolution of Go
---------------------------
Introduction
Also known as Golang, Go is a programming language designed by Robert Griesemer, Rob Pike, 
and Ken Thompson. It is an open-source programming language that makes it easy to build simple, 
reliable, and efficient software solutions. Go is a statically typed and compiled programming 
language. Statically typed means that variable types are explicitly declared and thus are 
determined at compile time. Whereas, by compiled language we mean a language that translates 
source code to machine code before execution


History
=======
Go’s year of genesis was 2007 at Google, and it was publicly launched in 2009 with a fully 
open-source BSD-style license released for the Linux and Mac OS platforms. 
The first Windows-port was announced on November 22 of the same year. Go 1.0 
(the first production-ready version) was released in March 2012. Since 2012, 
Go has grown from version 1.1 to 1.12 (March 2019), and work for Go 2.0 is underway!

The below figure shows the Go development timeline starting from its genesis to the year 2019.

Languages that influenced Go
Go belongs to the C-family, like C++, Java, and C#, and is inspired by many other languages created and used by its designers. The resemblance with the syntax of C language was maintained to gain an advantage of familiarity among developers. However, compared to C/C++, the syntax is made more incisive (concise). Additionally, Go has the features of a dynamic language, so Python and Ruby programmers feel more comfortable with it. The following figure shows some of the influences on the Go programming language:


Why a new language?
Following are the reasons that led to the development of Go:

Evolving with computing landscape
Need for faster software development
Need for efficiency and ease of programming
Let’s discuss each need one by one.

svg viewer

Evolving with computing landscape
Programming languages like C/C++ did not evolve with the computing landscape, so there is a need for a new systems language, appropriate for the needs of our computing era.

Need for faster software development
In contrast to computing power, software development has not become considerably faster or more successful (considering the number of failed projects), whereas applications still grow in size. Therefore, a new low-level language was needed, equipped with higher concepts.

Need for efficiency and ease of programming
Before Go, a developer had to choose between fast execution but slow and inefficient building (like C++) or efficient compilation but not so fast execution (like .NET or Java), or ease of programming but slower execution (like dynamic languages such as Python, Ruby or JavaScript). Go is an attempt to combine all the three wishes: efficient and fast compilation, fast execution, and ease of programming.

Targets of Go
The main target of Golang’s design was to combine the efficacy, speed, and safety of a statically typed and compiled language with the ease of programming of a dynamic language to make programming more fun again.

Some other targets that Go was meant to meet were:

Support for network communication, concurrency, and parallelization
Support for excellent building speed
Support for memory management
svg viewer

Support for network communication, concurrency, and parallelization
To get the most out of distributed and multi-core machines excellent support for networked-communication, concurrency, and parallelization. Golang was expected to achieve this target for internal use in Google, and this target is achieved through the concepts of goroutines. Don’t worry if you do not have an idea about goroutines. We’ll cover them in Chapter 12 of this course. It is undoubtedly a great stronghold of Go as compared to other programming languages keeping in mind the importance of multicore and multiprocessor computers and the minimal support for them in existing programming languages.

Support for excellent building speed
There was a growing concern to improve the building speed (compilation and linking to produce machine code) of C++ projects, which are heavily used in Google’s infrastructure. This concern gave birth to the idea of developing the Go programming language. In particular, dependency management is a very important part of software development today. The “header files” of languages caused considerable overhead leading in order to build times of hours for the biggest projects. Developers felt the need for clean dependency analysis and fast compilation, which Go language provides with its package model.

The entire Go standard library compiles in less than 20 seconds. Typical projects compile in half a second. This lightning-fast compiling process is even faster than C or Fortran, making compilation a non-issue. Until now, this was regarded as one of the great benefits of using dynamic languages for development because the long compile/link step of C++ could be skipped. However, with Go, this is no longer an issue! Compilation times are negligible, and we have the same productivity as in the development cycle of a scripting or dynamic language. In addition to this, the execution speed of the native code is comparable to C/C++.

Support for memory management
Because memory problems (memory leaks) are a long-time problem of C++, Go’s designers decided that memory management should not be the responsibility of a developer. So although Go executes native code, it runs in a small runtime, which takes care of an efficient and fast garbage collection. Go also has a built-in runtime reflection capability.

Characteristics of Go
This lesson discusses the aspects that make Go a successful language in the programming world.

We'll cover the following

Features of Go
Uses of Go
Used as a system programming language
Used as a general programming language
Used as an internal support
Beware of the trap
Guiding design principles
Features of Go
Go is essentially an imperative (procedural, structural) language, built with concurrency in mind. It is not truly object-oriented like Java and C++ because it doesn’t have the concepts of classes and inheritance. However, it does have a concepts of interfaces, with which much of the polymorphism can be implemented. Go has a clear and expressive type-system, but it is lightweight and without hierarchy. So in this respect, it could be called a hybrid language.

svg viewer

Some features of modern OOP languages were intentionally left out. Because, object orientation was too heavy often leading to cumbersome development constructing big type-hierarchies, and so not compliant with the speed goal of the language. As per the decision made by the Go-team, the following OOP features are missing from Golang. Although, some of them might still be implemented in its future versions.

To simplify the design, no function or operator overloading was added.
Implicit conversions were excluded to avoid the many bugs and confusion arising from this in languages like C/C++.
No classes and type inheritance is supported in Golang.
Golang does not support variant types. However, almost the same functionality is realized through interfaces.
Dynamic code loading and dynamic libraries are excluded.
Generics are not included (introduced in Go 1.18).
Exceptions are not included (although recover/panic often goes in that direction).
Assertions are not included.
Immutable (unable to change) variables are excluded.
A discussion around these features by the Go-team itself can be found in the Go FAQ.

Golang is a functional language, meaning that functions are the basic building blocks, and their use is very versatile. There is more information on functions in Golang in Chapter 4.

Go is statically typed, making it a safe language that compiles to native code and has a very efficient execution. It is also strongly typed, which means according to the principle keep things explicit. Implicit type conversions (also called castings or coercions) are not allowed. An important thing to note is that Go does have some features of dynamically typed languages (using var keyword). That’s why Go also appeals to programmers who left Java and the .Net world for Python, Ruby, PHP, and JavaScript.

Last but not least, Go has support for cross-compilation, for example, developing and compiling on a Linux-machine for an application that will execute on Windows. It is one of the first programming languages that can use UTF-8 not only in strings but also in program code. Go is truly an international language because Go source-files are also in UTF-8.

Uses of Go
There are many uses of Go. Following are some main uses of this language:

Used as a system programming language
Used as a general programming language
Used as an internal support
Used as a system programming language
Go was originally conceived as a systems programming language for the heavy server-centric (Google) world of web servers, storage architecture, and the like. For certain domains like high performance distributed systems, Go has already proven to be a more productive language than most others. Golang shines in and makes massive concurrency and event-processing easy. So it should be a good fit for the game server and IoT (Internet of Things) development.

Used as a general programming language
Go is also a general programming language, useful for solving text-processing problems, making frontends, or even scripting-like applications. However, Go is not suited for real-time software because of the garbage collection and automatic memory allocation.

Used as an internal support
Go is being used for some time internally in Google for heavy-duty distributed applications, e.g., parts of Google Maps run on Go.

Before moving any further, if you are interested in exploring some interesting real-life usage of Golang in other organizations around the world, click here. The web also brings you a lot of Go success stories.

Beware of the trap
If you come to Go and have a background in other contemporary (mostly class or inheritance-oriented languages like Java, C#, Objective C, Python, or Ruby), then beware! You can fall in the trap of trying to program in Go as you did in your previous language. However, Go is built on a different model. So if you decide to move code from language X to Golang, you will most likely produce non-idiomatic code that works poorly overall.

You have to start over by thinking in Go. If you take a higher point of view and start analyzing the problem from within the Go mindset, often a different approach suggests itself, which leads to an elegant and idiomatic Go solution.

svg viewer

Guiding design principles
Go tries to reduce typing, clutter, and complexity in coding through a minimal amount of keywords (25). This, together with the clean, regular, and concise syntax, enhances the compilation speed because the keywords can be parsed without a symbol table as its grammar is LALR(1).

These aspects reduce the number of code lines necessary, even when compared with a language like Java. Additionally, Go has a minimalist approach: there tends to be only one way of getting things done, so reading other people’s code is generally pretty easy, and we all know the code’s readability is of the utmost importance in software engineering.

The design concepts of the language are orthogonal because they don’t stand in each other’s way, and they don’t add up complexity to one another.

Golang is completely defined by an explicit specification that can be found here; it is not defined by an implementation as is Ruby, for example. An explicit language specification was required for implementing the two different compilers gc and gccgo, and this in itself was a great help in clarifying the specification.



Filenames, Keywords and Identifiers
=====================================
This lesson describes what a basic Go program usually comprises of.

We'll cover the following

Filename
Keyword
Identifiers
Blank identifier
Anonymous
The basic structure of a Go program
Filename
Go source code is stored in .go files. Their filenames consist of lowercase-letters, like educative.go. If the name consists of multiple parts, they are separated by underscores ‘_’, like educative_platform.go. Filenames cannot contain spaces or any other special characters. A source file contains code lines whose length has no intrinsic limits.

Keyword
A reserved word, with a special meaning in a programming language, is called a keyword. Below is the set of 25 keywords, or reserved words, used in Go-code:

Keywords
Keywords
Identifiers
An identifier is a name assigned by the user to a program element like a variable, a function, a template, and a struct, etc. Nearly all things in Go-code have a name or an identifier. Like all other languages in the C-family, Go is case-sensitive. Valid identifiers begin with a letter (a letter is every letter in Unicode UTF-8) or _ and are followed by 0 or more letters or Unicode digits, like X56, group1, _x23, i, and өԑ12.

The following are NOT valid identifiers:

1ab because it starts with a digit
case because it is a keyword in Go
a+b because operators are not allowed
Apart from the keywords, Go has a set of 36 predeclared identifiers which contain the names of elementary types and some basic built-in functions (see Chapter 4); all these will be explained further in the next chapters:

Predeclared Identifiers
Predeclared Identifiers
Blank identifier
The _ itself is a special identifier, called the blank identifier. Like any other identifier, _ can be used in declarations or variable assignments (and any type can be assigned to it). However, its value is discarded, so it can no longer be used in the code that follows. We will demonstrate its use later in the course.

Anonymous
Sometimes it is possible that even functions have no name because it is not really necessary at that point in the code and not having a name even enhances flexibility. Such functions are called anonymous. We will demonstrate their use later in the course.

The basic structure of a Go program
Programs consist of keywords, constants, variables, operators, types and functions. It is also important to know the delimiter and punctuation characters that are a part of Golang.

The following delimiters are used in a Go program:

Parentheses ()
Braces {}
Brackets []
The following punctuation characters are used in a Go program:

.
,
;
:
...
The code is structured in statements. A statement doesn’t need to end with a ; (like it is imposed on the C-family of languages). The Go compiler automatically inserts semicolons at the end of statements. However, if multiple statements are written on one line (a practice which is not encouraged for readability reasons), they must be separated by ;.

That’s it about the basic structure and elements of Golang. In the next lesson, we’ll see a basic component of the Go program.


Import Functionality
=====================
This lesson introduces a basic component of Go program, i.e., packages.

We'll cover the following

Packages
Package dependencies
Import keyword
Visibility
Visibility rule
Packages
A library, module, or namespace in any other language is called a package. Packages are a way to structure code. A program is constructed as a package which may use facilities from other packages. A package is often abbreviated as ‘pkg’.

Every Go file belongs to only one package whereas one package can comprise many different Go files. Hence, the filename(s) and the package name are generally not the same. The package to which the code-file belongs must be indicated on the first line. A package name is written in lowercase letters. For example, if your code-file belongs to a package called main, do the following:

1
package main
A standalone executable belongs to main. Each Go application contains one main.

An application can consist of different packages. But even if you use only package main, you don’t have to stuff all code in 1 big file. You can make a number of smaller files, each having package main as the 1st line of code. If you compile a source file with a package name other than main, e.g., pack1, the object file is stored in pack1.a.

Package dependencies
To build a program, the packages, and the files within them must be compiled in the correct order. Package dependencies determine the order in which to build the packages. Within a package, the source files must all be compiled together. The package is compiled as a unit, and by convention, each directory contains one package. If a package is changed and recompiled, all the client programs that use this package must be recompiled too!

Import keyword
A Go program is created by linking set of packages together, with the import keyword. For example, if you want to import a package say fmt, then you do:

12
package main
import "fmt"
import "fmt" tells Go that this program needs functions, or other elements from the package fmt, which implements a functionality for formatted IO. The package names are enclosed within " "(double quotes).

Import loads the public declarations from the compiled package; it does not insert the source code. If multiple packages are needed, they can each be imported by a separate statement. For example, if you want to import two packages, fmt and os in one code file, there are some following ways to do so:

import "fmt"
import "os"
or you can do:

import "fmt"; import "os"
Go has provided us with a shorter and more elegant way of importing multiple packages known as factoring the keyword. It is stated as:

import (
  "fmt"
  "os"
)
Factoring means calling a keyword once on multiple instances. You may have noticed that we imported two packages using a single import keyword. It is also applicable to keywords like const, var, and type.

Visibility
Packages contain all other code objects apart from the blank identifier (_). Also, identifiers of code-objects in a package have to be unique which means that there can be no naming conflicts. However, the same identifier can be used in different packages. The package name qualifies a package to be different.

Visibility rule
Packages expose their code objects to code outside of the package according to the following rule enforced by the compiler:

When the identifier (of a constant, variable, type, function, struct field, …) starts with an uppercase letter, like, Group1, then the ‘object’ with this identifier is visible in code outside the package (thus available to client-programs, or ‘importers’ of the package), and it is said to be exported (like public identifiers/variables in OO languages). Identifiers that start with a lowercase letter are not visible outside the package, but they are visible and usable in the whole package (like private identifiers/variables).

Note: Capital letters can come from the entire Unicode-range, like Greek; not only ASCII letters are allowed.

Importing a package gives access only to the exported objects in that package. Suppose we have an instance of a variable or a function called Object (starts with O so it is exported) in a package pack1. When pack1 is imported in the current package, Object can be called with the usual dot-notation from OO-languages:

pack1.Object
Packages also serve as namespaces and can help us avoid name-conflicts. For example, variables with the same name in two packages are differentiated by their package name, like pack1.Object and pack2.Object.

A package can also be given another name called an alias. If you name a package then its alias will be used throughout the code, rather than its original name. For example:

import fm "fmt"
Now in the code, whenever you want to use fmt, use its alias:fm (not fmt).

Note: Go has a motto known as “No unnecessary code!”. So importing a package which is not used in the rest of the code is a build-error.


Overview of Functions
-----------------------
This lesson explains how to write a simple function in Go.

We'll cover the following

Functions
Hello World 🌍
Comments
Naming things in Go
Functions
The simplest function declaration has the format:

func functionName()
Between the mandatory parentheses ( ) no, one, or more parameters (separated by ,) can be given as input to the function. After the name of each parameter variable must come its type.

The main function as a starting point is required (usually the first function), otherwise the build-error: undefined: main.main occurs. The main function has no parameters and no return type (in contrary to the C-family) otherwise, you get the build-error: func main must have no arguments and no return values. When the program executes, after initializations the first function called (the entry-point of the application) will be the main.main() (like in C). The program exits immediately and successfully when main.main returns.

The code or body in functions is enclosed between braces { }. The first { must be on the same line as the declaration otherwise you get the error: syntax error: unexpected semicolon or newline before { ). The last } is positioned after the function-code in the column beneath the function. The syntax is as follows:

func func_Name(param1 type1, param2 type2, ...){
  ...
}
If the function is returning an object of type type1, we follow the syntax as:

func func_Name(param1 type1, param2 type2, ...) type1 {
  ...
}
or:

func func_Name(param1 type1, param2 type2, ...) ret1 type1 {
  ...
}
where ret1 is a variable of type type1 to be returned. So a general function returning multiple variables looks like:

func func_Name(param1 type1, param2 type2, ...) (ret1 type1, ret2 type2, ...) {
...
}
Smaller functions can be written on one line like:

func Sum(a, b int) int { return a + b }
Let’s create the main function now as an entry point.

12345
package main
import "fmt"

func main(){
}
The main structure of a Go program is ready. How about making it capable of doing something?

Hello World 🌍
1234567
package main // making package for standalone executable
import "fmt" // importing a package   

func main() { // making an entry point 
    // printing using fmt functionality
    fmt.Println("Hello World")
} // exiting the program

Run

Save

Reset
Hello World
BINGO! We just made our first Go program using the components above. At line 1, we make a package main and then import package fmt to get the functionality of formatted IO at line 2. At line 4, we make a main function to add an entry point, and at line 6, we print Hello World with fmt.Println("Hello World"). This function Println from the fmt package takes a parameter and prints it on the screen.

Comments
Explanation of source code added to a program as a text note is called a comment. Comments are un-compilable. They are just for the understanding of the user. In Go, a one-line comment starts with //. A multi-line or block-comment starts with /* and ends with */, where nesting is not allowed. You can see we had added comments (the sentences in green) to the above program.

Run the following program and see the magic.

12345
package main
import "fmt" // Package implementing formatted I/O.
func main() {
    fmt.Printf("Καλημέρα κόσμε; or こんにちは 世界\n")
}

Run

Save

Reset
Go an International Language
This illustrates the international character of Go by printing Καλημέρα κόσμε; or こんにちは 世界.

Naming things in Go
Clean, readable code and simplicity are major goals of Go development. Therefore, the names of things in Go should be short, concise, and evocative. Long names with mixed caps and underscores which are often seen e.g., in Java or Python code, sometimes hinder readability. Names should not contain an indication of the package. A method or function which returns an object is named as a noun, no Get… is needed. To change an object, use SetName. If necessary, Go uses MixedCaps or mixedCaps rather than underscores to write multiword names.

-----------------------------------------------------------------
Overview of Data Types
This lesson tells us about the type of data that Go can handle.

We'll cover the following

Types
Conversions
Types
Variables contain data, and data can be of different data types or types for short. Go is a statically typed language. It means the compiler must know the types of all the variables, either because they were explicitly indicated, or because the compiler can infer the type from the code context. A type defines the set of values and the set of operations that can take place on those values. Here is an overview of some categories of types:

Types	Examples
elementary (or primitive)	int, float, bool, string
structured (or composite)	struct, array, slice, map, channel
interfaces	They describe the behavior of a type.
A structured type, which has no real value (yet), has the value nil, which is also the default value for these types. To declare a variable, var keyword is used as:

var var1 type1
var1 is the variable name, and type1 is the type of var1.

Functions can also be of a certain type. The (return) type of function is the type of variable which is returned by it. This type is written after the function name and its optional parameter-list, like:

func FunctionName (a typea, b typeb) typeFunc
So, you can see that typeFunc is the (return) type of the function, FunctionName. The returned variable var1 of type typeFunc appears somewhere in the function in the statement as:

return var1
A function can have more than one return variables. In this case, the return-types are separated by comma(s) and surrounded by ( ), like:

func FunctionName (a typea, b typeb) (t1 type1, t2 type2)
Two variables are returned with type type1 and type2 respectively. For such a case, the return statement takes the form:

return var1, var2
We can also have user-defined data types (our own data types), which we’ll study in detail in Chapter 8. But, it is possible to have an alias for data types similar to what we have for packages. For example, to create an alias for an integer type you can do:

type IZ int
Now to declare an integer variable, we have to use an alias like:

var a IZ = 5
If you have more than one type to define, you can use the factored keyword form, as in:

type (
  IZ int
  FZ float32
  STR string
)
In the above code, we create IZ, FZ, STR as an alias for int, float32, and string respectively.

Conversions
Sometimes a value needs to be converted into a value of another type called type-casting. Go does not allow implicit conversion, which means Go never does such a conversion by itself. The conversion must be done explicitly as valueOfTypeB = typeB(valueOfTypeA). How about writing a program on type-casting and observing the result? Let’s get started.

12345678
package main
import "fmt"

func main(){
    var number float32 = 5.2         // Declared a floating point variable
    fmt.Println(number)              // Printing the value of variable
    fmt.Println(int(number))         // Printing the type-casted result
}

Run

Save

Reset
Type Casting
At line 5 we declare a floating-point variable called number, and print the value in the next line. Then at line 7 we print the type-casted value by converting the value to int type using int(number). You can see that the value 5.2 becomes 5 after type-casting.

------------------------------------------------------------------------------------------------

Constants

Introduction
A value that cannot be changed by the program is called a constant. This data can only be of type boolean, number (integer, float, or complex) or string.

Explicit and implicit typing
In Go, a constant can be defined using the keyword const as:

const identifier [type] = value
Here, identifier is the name, and type is the type of constant. Following is an example of a declaration:

const PI = 3.14159
You may have noticed that we didn’t specify the type of constant PI here. It’s perfectly fine because the type specifier [type] is optional because the compiler can implicitly derive the type from the value. Let’s look at another example of implicit typing:

const B = "hello"
The compiler knows that the constant B is a string by looking at its value. However, you can also write the above declaration with explicit typing as:

const B string = "hello"
Remark: There is a convention to name constant identifiers with all uppercase letters, e.g., const INCHTOCM = 2.54. This improves readability.

Typed and untyped constants
Constants declared through explicit typing are called typed constants, and constants declared through implicit typing are called untyped constants. A value derived from an untyped constant becomes typed when it is used within a context that requires a typed value. For example:

var n int  
f(n + 5)   // untyped numeric constant "5" becomes typed as int, because n was int.
Compilation
Constants must be evaluated at compile-time. A const can be defined as a calculation, but all the values necessary for the calculation must be available at compile time. See the case below:

const C1 = 2/3 //okay
Here, the value of c1 was available at compile time. But the following will give an error:

const C2 = getNumber() //not okay
Because the function getNumber() can’t provide the value at compile-time. A constant’s value should be known at compile time according to the design principles where the function’s value is computed at run time. So, it will give the build error: getNumber() used as value.

Overflow
Numeric constants have no size or sign. They can be of arbitrarily high precision and do not overflow:

const Ln2= 0.693147180559945309417232121458\
176568075500134360255254120680009
const Log2E= 1/Ln2 // this is a precise reciprocal
const BILLION = 1e9 // float constant
const HARD_EIGHT = (1 << 100) >> 97
We used \ (backslash) in declaring constant Ln2. It can be used as a continuation character in a constant.

Multiple assignments
The assignments made in one single assignment statement are called multiple assignments. Go allows different ways of multiple assignments. Let’s start with a simple example:

const BEEF, TWO, C = "meat", 2, "veg"
As you can see, we made 3 constants. All of them are untyped constants. Let’s look at another method where all the constants are named first, and then their values are written if needed. For example:

const MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY int= 1, 2, 3, 4, 5, 6
As you can see, the constants, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY and SATURDAY are typed constants because their type (int) is mentioned explicitly, and they have the values 1, 2, 3, 4, 5 and 6 respectively.

Enumerations
Listing of all elements of a set is called enumeration. Constants can be used for enumerations. For example:

const (
  UNKNOWN = 0
  FEMALE = 1
  MALE = 2
)
UNKNOWN, FEMALE and MALE are now aliases for 0, 1 and 2. Interestingly value iota can be used to enumerate the values. Let’s enumerate the above example with iota:

const (
  UNKNOWN = iota
  FEMALE = iota
  MALE = iota
)
The first use of iota gives 0. Whenever iota is used again on a new line, its value is incremented by 1; so UNKNOWN gets 0, FEMALE gets 1 and MALE gets 2. Remember that a new const block or declaration initializes iota back to 0. The above notation can be shortened, making no difference as:

const (
  UNKNOWN = iota
  FEMALE
  MALE
)
You can give enumeration a type name. For example, FEMALE, MALE and UNKNOWN are categories of Gender. Let’s give them Gender as the type name:

type Gender int
const (
  UNKNOWN Gender = iota
  FEMALE
  MALE
)

---------------------------------------------------------------------------------------

Variables

Introduction
A value that can be changed by a program during execution is called a variable. The general form for declaring a variable uses the keyword var as:

var identifier type 
Here, identifier is the name of the variable, and type is the type of the variable. As discussed earlier in this chapter, type is written after the identifier of the variable, contrary to most older programming languages. When a variable is declared, memory in Go is initialized, which means it contains the default zero or null value depending upon its type automatically. For example, 0 for int, 0.0 for float, false for bool, empty string ("") for string, nil for pointer, zero-ed struct, and so on.

Run the following program to see how declaring a variable works.

123456789
package main
import "fmt"

func main(){
    var number int          // Declaring  an integer variable 
    fmt.Println(number)     // Printing its value
    var decision bool       // Declaring a boolean variable
    fmt.Println(decision)   // Printing its value
}

Run

Save

Reset
Declaring a Variable
You can see that in the above code, we declare a variable number of type int at line 5. As memory is initialized, the default value for number is printed at line 6, which is 0. Similarly, a variable decision of type bool at line 7 is declared, and false is printed as its value at line 8.

Remark: The naming of identifiers for variables follows the camelCasing rules (start with a small letter, and every new part of the word starts with a capital letter). But if the variable has to be exported, it must start with a capital letter, as discussed earlier in this chapter.

Assigning values
Giving a value to a variable is called assigning a value. A variable is assigned a value using the assignment operator(=) at compile time. But of course, a value can also be computed or changed during runtime. Declaration and assignment (initialization) can be combined in the general format:

var identifier type = value
Here, value can be a value of type type, or can even be a variable of type type or can also be an expression.

Run the following program to see how the assignment operator works on variables.

123456789
package main
import "fmt"

func main(){
    var number int = 5          // Declaring and initializing  an integer variable 
    fmt.Println(number)          // Printing its value
    var decision bool = true     // Declaring a initializing a boolean variable
    fmt.Println(decision)        // Printing its value
}

Run

Save

Reset
Declaring & Initializing a Variable
You can see that in the above code, we declared a variable number of type int at line 5, and initialized it with the value of 5. Similarly, a variable decision of type bool at line 7 was declared and initialized with true. These initialized values are printed later on by line 6 and line 8 respectively.

Go-compiler is intelligent enough to derive the type of a variable from its value dynamically, also called automatic type inference at runtime, so omitting the type of a variable is also a correct syntax. Let’s see a program on automatic type inference.

123456789
package main
import "fmt"

func main(){
    var number = 5          // Declaring and initializing an integer variable without stating its type
    fmt.Println(number)     // Printing its value
    var decision = true     // Declaring and initializing a boolean variable without stating its type
    fmt.Println(decision)   // Printing its value
}

Run

Save

Reset
Automatic Type Inference
You can see that we just declared variable number at line 5 and decision at line 8, without stating their types explicitly. The compiler infers type by itself, and the result is the same as the previous program. 5 and true are printed.

Short form with := assignment operator
With the type omitted, the keyword var is pretty superfluous in line 5 and line 7 of the above program. So we can also write it as:

number := 5 // line 5
decision := true // line 7
Again the types of number and decision (int and bool) are inferred by the compiler. This is the preferred form, but it can only be used inside functions, not in package scope. This operator (:=) effectively makes a new variable; it is also called an initializing declaration.

If after the lines above in the same code block, we declare :

number:= 20
This is not allowed. The compiler gives the error: no new variables on the left side of :=". However, number = 20 is okay because then the same variable only gets a new value.

Note: If a variable named v is used but not declared, it will give a compiler error: undefined: v. And, if v was declared as a local variable but not used, then the compiler will give the error: v declared and not used.

====================================================================================
Scope of Variables
Scope of a variable
A variable of any type is only known in a certain range of a program, called its scope. In a programming language, there are two main types of scopes:

Global scope
Local scope
Global scope
The scope of the variables declared outside of any function (in other words at the top level) is called global scope. Global scope is also known as package scope because the variables with such scope are visible and available in all source files of a package.

Local scope
The scope of the variables declared inside a function is called local scope. They are only known in that function; the same goes for parameters and return variables of a function.

In simple words, mostly, you can think of a scope as the code block ( surrounded by { } ) in which the variable is declared. Run the following program to visualize the concept of scope.

123456789101112
package main
import "fmt"

var number int = 5          // number declared outside (global scope)

func main(){
    var decision bool =  true // decision declared inside function(local scope)
    fmt.Println("Original Value of number: ",number)
    number = 10               // reassigning the number
    fmt.Println("New Value of number: ",number)


Run

Save

Reset
Scope of Variables
Let’s first discuss the number variable. It’s declared outside any function. So it has a global scope. It can be accessed and changed anywhere inside a code. We declare and initialize number with value 5 at line 4. At line 8, the value is printed, and we see 5 as an output. Then in the next line, we reassign: number=10, it changes the value of number to 10. Now when we print its value on line 10 answer is 10.

Although identifiers have to be unique, an identifier declared in a block may be redeclared in an inner block, but then the redeclared variable takes priority and shadows the outer variable with the same name; if used, care must be taken to avoid subtle errors.

Printing
We have been using the Println function from the fmt package so far, to print output to console. This package provides us another function, Printf, that prints the output on console but has a different format. It generally uses a format-string as its first argument:

func Printf(format string, list of variables to be printed)
This format string can contain one or more format-specifiers. Some common format specifiers are:

%d specifies format for integral values.
%s specifies format for string values.
%v specifies the general default format.
How about modifying the above code by using Printf now?

123456789101112
package main
import "fmt"

var number int = 5          // number declared outside (global scope)

func main(){
    var decision bool =  true // decision declared inside function (local scope)
    fmt.Printf("Original Value of number: %d\n",number)
    number = 10               // reassigning the number
    fmt.Printf("New Value of number: %d\n",number)


Run

Save

Reset
Printf Function
As you can see at line 8 and line 10, we use format specifier %d because number is an integer, where \n means to print a newline at the end. At line 11, we use %t, as a format specifier for booleans.

Value types and reference types
Memory in a computer is used in programs as an enormous number of boxes (that’s how we will draw them), called words. All words have the same length of 32 bits (4 bytes) or 64 bits (8 bytes), according to the processor and the operating system, and are identified by their memory address (represented as a hexadecimal number). All variables of elementary (primitive) types like int, float, bool, string, etc., are value types, which means they point directly to their value contained in memory as:

Value Type

Value Type
When assigning with =, the value of a value type assigns to another variable. For example, if we do j = i, a copy of the original value i is made in memory:

Assignment of Value Type

Assignment of Value Type
The address of the word where a variable is stored is its memory address. Variables of value type are contained in a stack memory.

The actual value of the address will differ from machine to machine and even on different executions of the same program as each machine could have a different memory layout and also the location where it is allocated could be different.

More complex data which needs several words are usually treated as reference types. Look at the figure below:

Reference Type

Reference Type
A reference type variable r1 contains the address of the memory location where the value of r1 is stored (or at least the 1st word of it). This address which is called a pointer is also contained in a word. The different words a reference type points to could be sequential memory addresses (the memory layout is said to be contiguous), which is the most efficient storage for computation; or the words could be spread around, each pointing to the next. To assign a reference type only address is copied:

Reference Type and Assignment

Reference Type and Assignment
When assigning r2 = r1, only the reference (the address) is copied. If the value of r1 is modified, all references of that value (like r1 and r2) then point to the modified content. The values that are referenced are usually stored in the heap, which is garbage collected and which is much larger memory space than a stack.

================================================
The if-else Construct

ntroduction
Until now, we have seen that a Go program starts executing in main() and sequentially executes the statements in that function. However, we often want to execute certain statements only if a condition is met, which means we want to make decisions in our code. For this, Go provides the following conditional or branching structures:

The if-else construct
The switch-case construct
The select construct
Repeating one or more statements (a task) can be done with the iterative or looping structure:

for (range) construct
Some other keywords like break and continue can also alter the behavior of the loop. There is also a return keyword to leave a body of statements and a goto keyword to jump the execution to a label in the code. Go entirely omits the parentheses ( and ) around conditions in if, switch and for-loops, creating less visual clutter than in Java, C++ or C#.

The if-else Construct
The if tests a conditional statement. That statement can be logical or boolean. If the statement evaluates to true, the body of statements between { } after the if is executed, and if it is false, these statements are ignored and the statement following the if after } is executed.

if condition {
    // do something
}
if structrure

if structrure
In a 2nd variant, an else, with a body of statements surrounded by { }, is appended, which is executed when the condition is false. It means we have two exclusive branches, and only one of them is executed:

if condition {
// do something
} else {
// do something else
}
if  and else structrure

if and else structrure
In a 3rd variant, another if condition can be placed after the else, so we have 3 exclusive branches:

if condition1 {
    // do something
} else if condition2 {
    // do something else
} else {
    // catch-all or default
}
The number of else if branches is in principle, not limited, but for readability reasons, the use of else if should not be exaggerated. When using this form, place the condition which is most likely true first.

one else-if along with if and else structrure

one else-if along with if and else structrure
The { } braces are mandatory even when there is only one statement in the body (some people do not like this, but it is consistent and follows mainstream software engineering principles). The { after the if and else must be on the same line. The else if and else keywords must be on the same line as the closing } of the previous part of the structure. Both of these rules are mandatory for the compiler. This is in-valid Go code:

if x {
}
else { // INVALID
}
Note that every branch is indented with 4 (or 8) spaces or 1 tab and that the closing } is vertically aligned with the if; this is enforced by applying gofmt (a default formatting tool for Go). The condition can also be composite, using the logical operators &&,||, and ! with the use of the parentheses () to enforce precedence or improve readability.

Moreover, the parentheses () around the conditions are not needed. However, for complex conditions, they may be used to make the code clearer. A possible application is the testing of different values of a variable and executing different statements in each case.

As a first example, let’s test whether an integer is even or odd:

package main
import "fmt"

func main() {
    n := 42
    // Use of control strcuture if and else to check whether number is even or not
    if n % 2 == 0 {
        fmt.Printf("The value is even\n")
    } else {
        fmt.Printf("The value is odd\n")
    }
}

Output
0.83s
The value is even

In the above code, we declare a variable n at line 5. Now, there are only two cases whether a number is even or odd. So we’ll use the 2nd variant of the if-else structure. We make a condition at line 7 that if n%2==0, which will be only true if n is even. If it is true then, we’ll print The value is even. Otherwise, if the condition is false the control will transfer to the else structure without even executing line 8. Then line 10 will be executed and The value is odd will be printed.

The conditional statement after the if is a boolean expression, but it can also be a boolean value, as in the following example:

package main
import "fmt"

func main() {
    bool1 := true
    // condition as a boolean value itself
    if bool1 {
        fmt.Printf("The value is true\n")
    } else {
        fmt.Printf("The value is false\n")
    }
}

In the above code, we declare a boolean variable bool1 and initialize it with true at line 5. At line 7, we make the condition if bool. Note that it is not necessary to test: if bool1 == true, because bool1 is already a boolean value. For this program, control will always transfer to the if structure as bool1 is true, and The value is true will be printed on the screen.

For special cases, note that you could write something like:

if true {
    fmt.Printf("I'm always executing this branch");
}
Here, the code block in the {} is always executed, so this is not very useful. Inversely you could write:

if false {
    fmt.Printf("I will never execute this code!")
}
Now, the code block in the {} will never be executed. It is almost always better to test for true or positive conditions, but it is possible to test for the reverse with ! (not):

if !bool1 // or if !(condition)
In the last case, the ( ) around the condition are often necessary, for example:

if !(var1 == var2)
which can be rewritten as the shorter:

if var1 != var2
The idiom in Go-code omits the else clause when the if ends in a break, continue, goto or return statement. For example, when an even value is to be returned from the code, you would write:

if n % 2 == 0 {
    return n
}
fmt.Printf("Continuing with an odd value\n")
When returning different values x and y whether or not a condition is true, use the following pattern:

if condition {
    return x
}
    return y
Here is an example:

if n % 2 == 0 {
    return n // return even value
}
return (n + 1) // return odd value
The structure of if can start with an initialization statement (in which a value is given to a variable). This takes the form (the ; after the initialization is mandatory):

if initialization; condition {
    // do something
}
For example, instead of:

val := 10
if val > max {
    // do something
}
you can write:

if val := 10; val > max {
// do something
}
But remember, the val variable will only be accessible within the statements of if, else-if and else block. If you try to access val anywhere else in the program, it will give the compiler error: undefined: val. This initialization during the if statement can be put to use even more, as the following code snippet shows:

if value := process(data); value > max {
    ...
}
The result of a function process() can be retrieved in the if, and action is taken according to the value.

Here is another complete example using variants of the if construct:


package main
import "fmt"

func main() {
    var first int = 10
    var cond int
    if first <= 0 {
        fmt.Printf("first is less than or equal to 0\n")
    } else if first > 0 && first < 5 {
        fmt.Printf("first is between 0 and 5\n")
    } else {
        fmt.Printf("first is 5 or greater\n")
    }
    if cond = 5; cond > 10 {
        fmt.Printf("cond is greater than 10\n")
    } else {
        fmt.Printf("cond is not greater than 10\n")
    }
}

Output
0.78s
first is 5 or greater
cond is not greater than 10

In the above code, we declare two integer variables first and cond. At line7, we make a condition if first <=0. If it is true for the value of first, line 8 will be executed, and then control will go to line 14.

If false, control will transfer from line 7 to line 9 directly. There, we make another condition using else if, i.e., else if first > 0 && first < 5. If this condition is true, then control will transfer to line 10 and then directly to line 14. Otherwise, control will be transferred directly to line 11 from line 9.

At line 11 is the else structure. Within the else structure, line 12 will be executed. After executing statements within else, control will come to line 14. If the condition at line 14 is true, then line 15 will be executed. Otherwise, line 17 within else structure.

Look at the condition on line 14: if cond =5; cond > 10. We are initializing cond at the time of condition.

Below is the illustration that shows the transfer of control throughout the above program.

========================================================================
Testing for Errors on Functions

Testing support
Sometimes, functions in Go are defined so that they return two results. One is the value and the other is the status of the execution. For example, the function will return a value and true in case of successful execution. Whereas, it will return a value (probably nil) and false in case of an unsuccessful execution.

Instead of true and false, an error-variable can be returned. In the case of successful execution, the error is nil. Otherwise, it contains the error information. It is then obvious to test the execution with an if statement because of its notation; this is often called the comma, ok pattern.

svg viewer

Consider the following example:

v, ok = sample_function(parameter)
Here, the comma, ok pattern is being followed. The value goes to v, and the ok parameter holds the status of the error during the execution. If there would be no error, then sample_function will return true to ok otherwise, it will return an error value.

Tracking error in a function
In the previous chapter while converting to and from a string, the function strconv.Atoi converts a string to an integer. There, we discarded a possible error-condition with:

 anInt, _ = strconv.Atoi(origStr)
If origStr cannot be converted to an integer, the function returns 0 for anInt, and the_absorbs the error, and the program continues to run.

A program should test for every occurring error and behave accordingly by, at least informing the user (or world) of the error-condition and returning from the function or even halting the program.

Let’s write another program to implement testing for errors.

1234567891011121314151617181920
package main
import (
"fmt"
"strconv"
)

func main() {
    var orig string = "ABC"
    var an int
    var err error


Run

Save

Reset
String Conversion with Error Testing
In the above code, at line 9 and line 10, we declare two variables an for value and err for error information. Then, we call the function strconv.Atoi for string orig. At line 14, we make a condition if err != nil. If this condition is true it means there was an error during the execution of the function, and due to the return statement, the program will terminate. If the condition is false, then line 18 and the rest of the code will be executed. In this case, the program will terminate with an error display message because orig isn’t an integer.

We could also have used the form of return which returns a variable like return err. In this case, the calling function can examine the error err.

value, err := pack1.Function1(param1)
if err != nil {
    fmt.Printf("An error occurred in pack1.Function1 with parameter %v", param1)
    return err
}
// normal case, continue execution:
In the above program, it was main() executing so the program stops. If we do want the program to stop in case of an error, we can use the function Exit from package os instead of return:

if err != nil {
    fmt.Printf("Program stopping with error %v", err)
    os.Exit(1)
}
Look at the following code where we tried to open a file:

f, err := os.Open(fname)
if err != nil {
    return err
}
doSomething(f) // In case of no error, the file f is passed to a function doSomething
Sometimes, the above idiom is repeated a number of times in succession. No else branch is written. If there is no error-condition, the code simply continues execution after the if { }.

Remark: More information on os package can be found here.
=======================================================================================

The switch-case Construct

Introduction
In the last two lessons, we studied the if-else construct. There is another control structure known as the switch-case structure.

The keyword switch is used instead of long if statements that compare a variable to different values. The switch statement is a multiway branch statement that provides an easy way to transfer flow of execution to different parts of code based on the value. The following figure explains the basic structure of the switch-case construct.

Switch Case Construct

Switch Case Construct
switch statement with values
Compared to the C and Java languages, switch in Go is considerably more flexible. It takes the general form:

switch var1 {
case val1:
...
case val2:
...
default:
...
}
Where var1 is a variable which can be of any type, and val1, val2, … are possible values of var1. These don’t need to be constants or integers, but they must have the same type, or expressions evaluating to that type. The opening { has to be on the same line as the switch. The ellipses ... here means that after the case statement, multiple statements can follow without being surrounded by { }, but braces are allowed.

When there is only 1 statement: it can be placed on the same line as case ... :. The last statement, in any case, can also be a return with or without an expression. When the case statements end with a return statement, there also has to be a return statement after the } of the switch.

More than one value can be tested in a case. For this, the values are presented in a comma-separated list like:

case val1, val2, val3:
Each case-branch is exclusive. They are tried first to last. We should place the most probable values first, to save the time of computation. The first branch that is correct is executed, and then the switch statement is complete.

Compare the following two cases:

switch i {
case 0: //empty case body, nothing is executed when i==0
case 1:
    f() // f is not called when i==0!
}
And:

switch i {
case 0: fallthrough
case 1:
    f() // f is now also called when i==0!
}

In the first case, if i has the value 0, no code will be executed because case 0 has no code body, and the switch terminates immediately. To obtain the same behavior in C, you need to add a break after case 0. If, on the other hand, you explicitly want to execute the code from case 1, when i has the value 0, you need to add the keyword fallthrough at the end of the case 0 branch. This is illustrated in the second case. With fallthrough, all the remaining case branches are executed until a branch is encountered, which does not contain a fallthrough.

Fallthrough can also be used in a hierarchy of cases where at each level something has to be done in addition to the code already executed in the higher cases, and a default action also has to be executed. The (optional) default branch is executed when no value is found to match var1 with; it resembles the else clause in if-else statements. It can appear anywhere in the switch (even as the first branch), but it is best written as the last branch.

Let’s write a simple program to see how the switch statement works.

package main
import "fmt"

func main() {
    var num1 int = 100
    // Adding switch on num1
    switch num1 {
        case 98, 99:        // first case: num1 = 98 or 99
            fmt.Println("It's equal to 98")
        case 100:           // second case: num1 = 100
            fmt.Println("It's equal to 100")
        default:            // optional/ default case
            fmt.Println("It's not equal to 98 or 100")
    }
}

Output
0.82s
It's equal to 100

In the above code:

We declare a variable num1 and give a value 100 to it. Now we use a switch statement against num1 value, which means different cases will be written on num1. We made a total of 3 cases, including the default case.

The first case is for two values: 98 and 99. If this case is true, then line 9 will be executed. If not, then control will be transferred directly to line 10 for the second case.

The second case is for the value of 100. If this case is true, then line 11 will be executed. If not, then control will be transferred directly to line 12 for the third case.

The third case is the default case. If none of the above cases are executed, then this case will be true in any case, and line 13 will be executed.

For the above program, the second case: case 100 is true, and It’s equal to 100 will be printed on the screen.

switch statement with conditions
In this form of the switch statement, no variable is required (this is, in fact, a switch true), and the cases can test different conditions. The first true condition is executed. It looks very much like if-else chaining and offers a more readable syntax if there are many branches. The syntax is as follows:

switch {
case condition1:
...
case condition2:
...
default:
...
}
For example:

switch {
case i < 0:
    f1() // function call
case i == 0:
    f2() // function call
case i > 0:
    f3() // function call
}
Any type that supports the equality comparison operator, such as ints, strings or pointers, can be used in these conditions. Look at the following program to see how switch works with conditions instead of values.

package main
import "fmt"

func main() {
    var num1 int = 100
    switch {
        case num1 < 0:
            fmt.Println("Number is negative")

        case num1 > 0 && num1 < 10:
            fmt.Println("Number is between 0 and 10")

        default:
            fmt.Println("Number is 10 or greater")
    }
}

Output
2.36s
Number is 10 or greater

In the above code, we declare a variable num1 and give it a value 100. We can use a switch statement without any value, which means different cases will be based on conditions. We made a total of three cases, including the default case.

The first case is for numbers less than 0: case num1 < 0:. If this case is true, then line 8 will be executed. If not, then control will be transferred directly to line 10 for the second case.

The second case is for the condition: case num1 > 0 && num1 < 10: If this case is true, then line 11 will be executed. If not, then control will be transferred directly to line 13 for the third case.

The third case is the default case. If none of the above cases are executed, then this case will be true in any case, and line 14 will be executed. For the above program, the third(default) case is true, and Number is 10 or greater will be printed on the screen.

Initialization within the switch statement
A switch can also contain an initialization statement, like the if construct:

switch initialization; {
case val1:
...
case val2:
...
default:
...
}
After writing the switch keyword, we can do initialization and add a ; at the end:

switch a, b := x[i], y[j]; {
case a < b: t = -1
case a == b: t = 0
case a > b: t = 1
}
Here, a and b are retrieved in the parallel initialization, and the cases are conditions. According to the above code, a is equal to x[i] and b is equal to y[j]. Let’s write a program that covers the concept of initialization within a switch statement.

package main
import "fmt"

func main() {
    // initialization within switch block
    switch num1 := 100;{
        case num1 < 0:
            fmt.Println("Number is negative")

        case num1 > 0 && num1 < 10:
            fmt.Println("Number is between 0 and 10")

        default:
            fmt.Println("Number is 10 or greater")
    }
}

It is the same program we wrote previously, but with a little modification. Can you notice the difference? Previously, we declared num1 separately. But now, we declare the variable in the switch block. Notice line 6 where we declare and initialize num1 in the same line as switch: switch num1 := 100;. The rest of the program is the same and will produce the same output

======================================================================================
Maps
=====

Declaration and Initialization
-------------------------------
This lesson describes the important concepts regarding maps, i.e., how to use, declare and initialize them.

Introduction
Maps are a special kind of data structure: an unordered collection of pairs of items, where one element of the pair is the key, and the other element, associated with the key, is the data or the value. Hence they are also called associative arrays or dictionaries. They are ideal for looking up values, and given the key, the corresponding value can be retrieved very quickly. This structure exists in many other programming languages under other names such as Dictionary (dict in Python), hash, HashTable and so on.

Concept
A map is a reference type and declared in general as:

var map1 map[keytype]valuetype
For example:

var map1 map[string]int
(A space is allowed between [keytype] and valuetype, but gofmt removes it.)

The length of the map doesn’t have to be known at the declaration, which means a map can grow dynamically. The value of an uninitialized map is nil. The key type can be any type for which the operations == and != are defined, like string, int, and float. For arrays and structs, Go defines the equality operations, provided that they are composed of elements for which these operations are defined using element-by-element comparison. So arrays, structs, pointers, and interface types can be used as key type, but slices cannot because equality is not defined for them. The value type can be any type.

Maps are cheap to pass to a function because only a reference is passed (so 4 bytes on a 32-bit machine, 8 bytes on a 64-bit machine, no matter how much data they hold). Looking up a value in a map by key is fast, much faster than a linear search, but still around 100x slower than direct indexing in an array or slice. So, if performance is very important try to solve the problem with slices.

If key1 is a key value of map map1, then map1[key1] is the value associated with key1, just like the array-index notation (an array could be considered as a simple form of a map, where the keys are integers starting from 0). The value associated with key1 can be set to (or if already present changed to) val1 through the assignment:

map1[key1] = val1
The assignment:

v:= map1[key1]
stores the value in v corresponding to key1. If key1 is not present in the map, then v becomes the zero-value for the value type of map1.

As usual len(map1) gives the number of pairs in the map, which can grow or diminish because pairs may be added or removed during runtime.

Maps are reference types, as memory is allocated with the make function. Initialization of a map is done like:

var map1 map[keytype]valuetype = make(map[keytype]valuetype)
or shorter with:

map1 := make(map[keytype]valuetype)
Run the following program to see how maps are made in Go.


package main
import "fmt"

func main() {
  mapLit := map[string]int{"one": 1, "two": 2}   // making map & adding key-value pair
  var mapAssigned map[string]int
  mapCreated := make(map[string]float32)        // making map with make()
  mapAssigned = mapLit
  mapCreated["key1"] = 4.5      // creating key-value pair for map
  mapCreated["key2"] = 3.14159
  mapAssigned["two"] = 3        // changing value of already existing key
  fmt.Printf("Map literal at \"one\" is: %d\n", mapLit["one"])
  fmt.Printf("Map created at \"key2\" is: %f\n", mapCreated["key2"])
  fmt.Printf("Map assigned at \"two\" is: %d\n", mapAssigned["two"])
  fmt.Printf("Map literal at \"ten\" is: %d\n", mapLit["ten"])
}


In the code above, in main at line 5, we make a map mapLit and add key value pairs to it. The declaration of mapLit shows that its keys will be of string type and the values associated with its keys will be of int type. You can see we make two keys named one and two. The values associated with one is 1 and with two is 2.

Similarly, at line 6, we make a map mapAssigned. The declaration of mapAssigned shows that its keys will also be of string type and the values associated with its keys will be of int type too. In the next line, we assign values to mapLit.

At line 7, we create a map mapCreated using the make function, which is equivalent to mapCreated := map[string]float{}. The declaration of mapCreated shows that its keys will be of string type and the values associated with its keys will be of float32 type. Then in the next line, we assign mapAssigned with the map of mapLit, which means that mapLit and mapAssigned now possess the same pairs.

At line 9 and line 10, we are making key-value pairs (each pair line by line) for mapCreated. At line 9 we create key key1 and give the value 4.5 to it. At line 10 we create the key key2 and give the value 3.14159 to it. Now at line 11, we are changing the value associated with the key of mapAssigned, already present before. We are giving the key two a new value of 3.

Now, from line 12 to line 15, we are printing certain values to verify the maps’ behaviors. At line 12, we are printing the value associated with key one of mapLit which is 1. In the next line, we are printing the value associated with key key2 of mapCreated, which is 3.14159. At line 14, we are printing the value associated with key two of mapLit, which is 3 (because of reference, as the value changes at line 11). In the last line, we are trying to print the value associated with the key ten of mapLit, which doesn’t even exist. So 0 will be printed because mapLit contains int value types, and the default value for an integer is 0.

Note: Don’t use new, always use make with maps.

If you by mistake allocate a reference object with new(), you receive a pointer to a nil reference, equivalent to declaring an uninitialized variable and taking its address:

mapCreated := new(map[string]float)
Then we get in the statement:

mapCreated["key1"] = 4.5
the compiler error: invalid operation: mapCreated["key1"] (index of type *map[string] float).

To demonstrate that the value can be any type, here is an example of a map that has a func() int as its value:


package main
import "fmt"

func main() {
  mf := map[int]func() int{ // key type int, and value type func()int
    1: func() int { return 10 },
    2: func() int { return 20 },
    5: func() int { return 50 },
  }
  fmt.Println(mf)
}

Output
1.12s
map[1:0x4011c0 2:0x4011d0 5:0x4011e0]

In the code above, in main at line 5, we make a map mf. The declaration of mf shows that its keys will be of int type and the values associated with its keys will be of func() int type. From line 6 to line 8, we are making key-value pairs for mf. At line 6 we create a key 1 (of type int) and give the value: func() int { return 10 } ( a function returning 10) to it. At line 7, we create the key 2 (of type int) and give the value: func() int { return 20 } ( a function returning 20) to it. At line 8, we create key 5 (of type int) and give the value: func() int { return 50 } ( a function returning 50) to it. On printing the map at line 10, you’ll notice that int type keys are mapped to the address of the functions which are assigned to them.

Map capacity
Unlike arrays, maps grow dynamically to accommodate new key-values that are added; they have no fixed or maximum size. However, you can optionally indicate an initial capacity cap for the map, as in:

make(map[keytype]valuetype, cap)
For example:

map2 := make(map[string]float, 100)
When the map has grown to its capacity, and a new key-value is added, then the size of the map will automatically increase by 1. So for large maps or maps that grow a lot, it is better for performance to specify an initial capacity; even if this is only known approximately. If you don’t specify the initial capacity, a default capacity of 8 bytes is taken (on a 64-bit machine). Here is a more concrete example of a map. Map the name of a musical note to its frequency in Hz:

noteFrequency := map[string]float32{
"C0": 16.35, "D0": 18.35, "E0": 20.60, "F0": 21.83, "G0": 24.50, "A0": 27.50, "B0": 30.87, "A4": 440}
In the above snippet, noteFrequency is a map. The declaration of noteFrequency shows that its keys will be of string type and values associated with its keys will be of float32 type. The initialization is done along with the declaration. For example, the C0 key is given value 16.35, the D0 key is given value 18.35 and so on.

Slices as map values
When a key has only one associated value, the value can be a primitive type. What if a key is associated with many values? For example, when we have to work with all the processes on a Unix-machine where a parent process as key (process-id pid is an int value) can have many child processes (represented as a slice of ints with their pid’s as items). This can be elegantly solved by defining the value type as a [ ]int or a slice of another type. Here are some examples defining such maps:

mp1 := make(map[int][]int)
mp2 := make(map[int]*[]int)

Existence of Key-Value Item
============================
This lesson focuses on two major concepts: how to find a value associated with a key and how to delete a key-value pair from a map.

Testing the existence of a key
We saw in the previous lesson that val1 = map1[key1] returns the value val1 associated with key1. If key1 does not exist in the map, val1 becomes the zero-value for the value’s type, but this is ambiguous. Now we can’t distinguish between this case or the case where key1 does exist and its value is the zero-value! In order to test this, we can use the following comma ok form:

val1, isPresent = map1[key1]
The variable isPresent will contain a Boolean value. If key1 exists in map1, val1 will contain the value for key1, and isPresent will be true. If key1 does not exist in map1, val1 will contain the zero-value for its type, and isPresent will be false.

If you just want to check for the presence of a key and don’t care about its value, you could write:

_, ok := map1[key1] // ok == true if key1 is present, false otherwise
Or combined with an if:

if _, ok := map1[key1]; ok {
  // ...
}
Deleting an element with a key
==============================
This is done with:

delete(map1, key1)
When key1 does not exist, this statement doesn’t produce an error.

Both the techniques are implemented in the following program.

12345678910111213141516171819202122232425262728293031

package main
import "fmt"

func main() {
  var value int
  var isPresent bool
  map1 := make(map[string]int)
  map1["New Delhi"] = 55
  map1["Beijing"] = 20
  map1["Washington"] = 25
  value, isPresent = map1["Beijing"]  // checking existence of a key

  if isPresent {
    fmt.Printf("The value of \"Beijing\" in map1 is: %d\n", value)
  } else {
    fmt.Println("map1 does not contain Beijing")
  }
  value, isPresent = map1["Paris"]   // chekcing existence of a key
  fmt.Printf("Is \"Paris\" in map1 ?: %t\n", isPresent)
  fmt.Printf("Value is: %d\n", value)

  // delete an item:
  delete(map1, "Washington")
  value, isPresent = map1["Washington"] // checking existence of a key

  if isPresent {
    fmt.Printf("The value of \"Washington\" in map1 is: %d\n", value)
  } else {
    fmt.Println("map1 does not contain Washington")
  }
}

Output
0.79s
The value of "Beijing" in map1 is: 20
Is "Paris" in map1 ?: false
Value is: 0
map1 does not contain Washington

In the above code, in main at line 7, we made a map map1. The declaration of map1 shows that its keys will be of string type and values associated with its keys will be of int type. Now to check the presence of a key in this map, we made two variables: value of type int (at line 5) to get the value associated with that key and isPresent of type bool (at line 6) to check whether that key exists or not.

From line 8 to 10, we are making key-value pairs (each pair line by line) for map1. At line 8, we create a key New Delhi and give the value 55 to it. At line 9, we create a key Beijing and give the value 20 to it. At line 10, we create a key Washington and give the value 25 to it.

Now at line 11, we are checking the existence of the key Beijing in map1 as: value, isPresent = map1["Beijing"]. We know that Beijing does exist in map1 so value will get 20, and isPresent will become true, causing the condition at line 13 to become true. Consequently, The value of “Beijing” in map1 is: 20 will be printed on the screen. Now at line 18, we are checking the existence of the key Paris in map1 as: value, isPresent = map1["Paris"]. We know that Paris does not exist in map1 so value will get 0, and isPresent will become false, causing line 19 to print Is “Paris” in map1 ?: false. Line 20 will print Value is: 0.

At line 23, we are deleting a key Washington from map1. The execution of this line doesn’t tell whether the key was deleted or not. So in the next line, we are verifying the existence of Washington in map1 as: value, isPresent = map1["Washington"]. We know that Washington does not exist in map1 anymore after deletion, so value will get 0, and isPresent will become false, causing the condition at line 26 to become false. The control will transfer to line 28, and map1 does not contain Washington will be printed on the screen.


The for range Construct
------------------------

Explanation
The following construct can also be applied to maps:

for key, value := range map1 {
  ...
}
The key is the key of the map, and the value is the value for the key. They are local variables only known in the body of the for statement. If you are only interested in the values, use the form:

for _, value := range map1 {
  fmt.Printf("Value is: %d\n", value)
}
To get only the keys, you can use:

for key := range map1 {
  fmt.Printf("Key is: %d\n", key)
}
The order in which elements are visited when iterating over a map using a for range statement is unpredictable, even if the same loop is run multiple times with the same map. The first element in a map iteration is chosen at random. This behavior allows the map implementation to ensure better map balancing. Your code should not assume that the elements are visited in any particular order.

Implementation
Here is an example of a program that uses a for loop on a map.

package main
import "fmt"

func main() {
  map1 := make(map[int]float32)
  map1[1] = 1.0
  map1[2] = 2.0
  map1[3] = 3.0
  map1[4] = 4.0
  // for range 
  for key, value := range map1 {
    fmt.Printf("key is: %d - value is: %f\n", key, value)
  }
}

Output
0.75s
key is: 1 - value is: 1.000000
key is: 2 - value is: 2.000000
key is: 3 - value is: 3.000000
key is: 4 - value is: 4.000000

In the code above, in main, at line 5, we make a map map1. The declaration of map1 shows that its keys will be of int type and values associated with its keys will be of float32 type. From line 6 to line 9, we are making key-value pairs (each pair line by line) for map1. At line 6, we create a key 1 and give the value 1.0 to it. At line 7, we create a key 2 and give the value 2.0 to it. At line 8, we create a key 3 and give the value 3.0 to it. At line 9, we create a key 4 and give the value 4.0 to it. Now, we have a for loop at line 11. It’s reading all the key-value pairs from map1 and printing a key-value pair in each iteration. The order of output may change every time you run the program.

We see that a map is not key-ordered, neither is it sorted on the values. It is even safe to delete pairs from a map while iterating over the map like:

package main
import "fmt"

func main() {
  map1 := make(map[int]float32)
  map1[1] = 1.0
  map1[2] = 2.0
  map1[3] = 3.0
  map1[4] = 4.0
  
  for key := range map1 {
    if key > 3 {
      delete(map1, key)   // deleting keys greater than and equal to 4
    }
  }
  // printing the modified map
  for key, value := range map1 {
    fmt.Printf("key is: %d - value is: %f\n", key, value)
  }
}

Output
0.97s
key is: 1 - value is: 1.000000
key is: 2 - value is: 2.000000
key is: 3 - value is: 3.000000

In the code above, in main at line 5, we made a map map1. The declaration of map1 shows that its keys will be of int type and values associated with its keys will be of float32 type. From line 6 to line 9, we are making key-value pairs (each pair line by line) for map1. At line 6, we create a key 1 and give the value 1.0 to it. At line 7, we created a key 2 and gave the value 2.0 to it. At line 8, we create a key 3 and give the value 3.0 to it. At line 9, we create a key 4 and give the value 4.0 to it.

Now we have a for loop at line 11. It’s reading all the key-value pairs from map1 and deleting the key-value pairs for which the key is greater than 3 using the delete function.

Then again, we have a for loop at line 17 that is printing modified map1.

A Slice of Maps
===============

Explanation
Suppose we want to make a slice of maps. We must use make() two times, first for the slice, then for each of the map-elements of the slice. To access a specific key-value pair from a map, you have to use an iterator to specify which map from the slice of maps is required.

For example, if we have a slice of maps called maps, and we want to set a value v with key 1 from map i, we’ll do something as follows:

maps[i][1] = v
Simply writing maps[1] = v won’t work, because it will initialize map-variables, and will be lost on the next iteration.

Look at the following implementation of how to make a slice of maps in Go.

package main
import (
"fmt"
)

func main() {

  // Version A:
  items := make([]map[int]int, 5)
  for i := range items {
    items[i] = make(map[int]int, 1) 
    items[i][1] = 2 // This 'item' data will not be lost on the next iteration
  }
  fmt.Printf("Version A: Value of items: %v\n", items)


  // Version B: NOT GOOD!

  items2 := make([]map[int]int, 5)
  for _, item := range items2 {
    item = make(map[int]int, 1) // item is only a copy of the slice element.
    item[1] = 2 // This 'item' will be lost on the next iteration.
  }
  fmt.Printf("Version B: Value of items: %v\n", items2)
}

Output
0.96s
Version A: Value of items: [map[1:2] map[1:2] map[1:2] map[1:2] map[1:2]]
Version B: Value of items: [map[] map[] map[] map[] map[]]

In the code above, in main at line 9, we make a slice of maps: items := make([]map[int]int, 5). The declaration of items shows that it contains 5 maps. For each map, its keys will be of int type and the values associated with its keys will also be of int type. Now, there is a for loop at line 10, which iterates through all 5 places and places a map with the key 1( at line 11). For every map, the value 2 is assigned with the key 1( at line 12) as: item[i][1] = 2.

Now let’s try a separate version. In the code above, in main at line 19, we make a slice of maps as: items2 := make([]map[int]int, 5). The declaration of items2 shows that it contains 5 maps. For each map, its keys will be of int type and values associated with its keys will also be of int type. Now, there is a for loop at line 20, which iterates through all 5 places and places a map with the key 1( at line 21). For every map, the value 2 is assigned with the key 1(at line 22) as :item[1] = 2. The value will be lost in the next iteration because item is the copy of the slice; proper indexing is required as done in Version 1 at line 12

Sorting and Inverting a Map
============================

Sorting a map
By default, a map is not sorted, not even on the value of its keys. If you want a sorted map, copy the keys (or values) to a slice, sort the slice (using the sort package), and print out the keys and/or values using the for-range on the slice. This is illustrated in the following program:

package main
import (
    "fmt"
    "sort"
)

var (
    barVal = map[string]int{"alpha": 34, "bravo": 56, "charlie": 23, "delta": 87,
    "echo": 56, "foxtrot": 12, "golf": 34, "hotel": 16, "indio": 87, "juliet": 65, "kilo":
    43, "lima": 98}
)

func main() {
    fmt.Println("unsorted:")
    for k, v := range barVal {
        fmt.Printf("key: %v, value: %v / ", k, v)   // read random keys
    }
    keys := make([]string, len(barVal))     // storing all keys in separate slice
    i := 0
    for k := range barVal {
        keys[i] = k
        i++
    }
    sort.Strings(keys)  // sorting the keys slice
    fmt.Println()
    fmt.Println("\nsorted:")
    for _, k := range keys {
        fmt.Printf("key: %v, value: %v / ", k, barVal[k])   // reading key from keys and value from barVal
    }
}

Output
0.85s
unsorted:
key: delta, value: 87 / key: echo, value: 56 / key: foxtrot, value: 12 / key: golf, value: 34 / key: indio, value: 87 / key: juliet, value: 65 / key: alpha, value: 34 / key: charlie, value: 23 / key: kilo, value: 43 / key: lima, value: 98 / key: bravo, value: 56 / key: hotel, value: 16 / 

sorted:
key: alpha, value: 34 / key: bravo, value: 56 / key: charlie, value: 23 / key: delta, value: 87 / key: echo, value: 56 / key: foxtrot, value: 12 / key: golf, value: 34 / key: hotel, value: 16 / key: indio, value: 87 / key: juliet, value: 65 / key: kilo, value: 43 / key: lima, value: 98 / 

In the code above, outside main at line 4, we import sort package to perform sorting, and at line 7, we make a map barVal. The declaration of barVal shows that its keys will be of string type and values associated with its keys will be of int type. The initialization is done at the same line. For example, the key alpha gets value 34, bravo get 56, charlie gets 23 and so on.

In main, we have a for-loop at line 15. This loop prints a key and the value associated with each key in every iteration, until all key-value pairs are not printed. The output of this for loop will be unsorted, as maps’ keys are read randomly.

Now at line 18, we make a slice of string keys of length equal to barVal's length ( total number of keys in barVel). Then we make the for loop at line 20 that reads keys from barVel in random order and stores them one by one in keys ( at line 21). By the end of for loop, all keys will be present in the keys slice. There is a great chance that the keys from barVal will not be read in sorted (alphabetical) order and will be stored in the keys slice. So at line 24, we perform in-place sorting on the strings present in keys using: sort.Strings(keys).

Again we have a for-loop at line 27. This loop prints a key and the value associated with each key in every iteration until all key-value pairs are not printed. It reads the key from keys and store it in k. Then read the value from barVal as: barVal[k].The output of this for loop will be sorted, as barVal's keys are read from keys slice (containing sorted strings).

Inverting a map
================
Inverting a map we mean switching the values and keys. If the value type of a map is acceptable as a key type and the map values are unique, this can be done easily. Look at the following program to see how a map can be inverted.

package main
import (
"fmt"
)

var (
barVal = map[string]int{"alpha": 34, "bravo": 56, "charlie": 23, "delta": 87,
"echo": 56, "foxtrot": 12, "golf": 34, "hotel": 16, "indio": 87, "juliet": 65, "kilo": 43,
"lima": 98}
)

func main() {
  invMap := make(map[int]string, len(barVal)) // interchanging types of keys and values
  for k, v := range barVal {
    invMap[v] = k   // key becomes value and value becomes key
  }
  fmt.Println("inverted:")
  for k, v := range invMap {
    fmt.Printf("key: %v, value: %v / ", k, v)
  }
}
Output
0.77s
inverted:
key: 65, value: juliet / key: 56, value: echo / key: 12, value: foxtrot / key: 43, value: kilo / key: 98, value: lima / key: 87, value: delta / key: 34, value: golf / key: 23, value: charlie / key: 16, value: hotel / 

In the above code, outside main at line 6, we make a map barVal. The declaration of barVal shows that its keys will be of string type and values associated with its keys will be of int type. The initialization is done at the same line. For example, the key alpha gets value 34, bravo get 56, charlie gets 23 and so on.

In main, at line 13, we make a map invMap. The declaration of invMap shows that its keys will be of int type and values associated with its keys will be of string type. The length of invMap is the same as barVal, and the map invMap is the inverse of barVal. That is why the type of keys and values are interchanged between them.

Then we have the for loop at line 14, where we read barVal key in k and value for each k in v for each iteration. To invert a map, the key becomes value and the value becomes key. This means that invMap[v]=k( see line 15) will serve the purpose. As v was the value associated to k key of barVal, to invert the map k should be the value associated with v key of invMap. Again we have a for-loop at line 18. This loop prints a key and the value associated with each key in every iteration until all key-value pairs are not printed.

Because keys must be unique, the code goes wrong when the original value items are not unique. In that case, no error occurs, but the inverted map will not contain all pairs from the original map. One solution is to carefully test for uniqueness and using a multi-valued map. In this case, use a map of type map[int][]string.

Look at the following code, and see how uniqueness is tested.

package main
import (
"fmt"
)

var (
barVal = map[string]int{"alpha": 34, "bravo": 56, "charlie": 23, "delta": 87,
"echo": 56, "foxtrot": 12, "golf": 34, "hotel": 16, "indio": 87, "juliet": 65, "kilo": 43,
"lima": 98}
)

func main() {
  invMap := make(map[int][]string, len(barVal)) // interchanging types of keys and values
  for k,v := range barVal{
     var a [1]string // making an array to hold values for a key in invMap
     a[0]=k // placing key into array before passing directly into invMap
    _, isPresent := invMap[v] // checking existence
    if isPresent{ // if already present
      invMap[v] = append(invMap[v],",") // add comma before adding another value
    }
    invMap[v] = append(invMap[v],a[0])   // key becomes value and value becomes key
  }
  fmt.Println("inverted:")
  for k, v := range invMap {
    fmt.Printf("key: %v, value: %v / ", k, v)
  }
}

Output
0.81s
inverted:
key: 98, value: [lima] / key: 23, value: [charlie] / key: 12, value: [foxtrot] / key: 16, value: [hotel] / key: 65, value: [juliet] / key: 34, value: [alpha , golf] / key: 56, value: [bravo , echo] / key: 87, value: [delta , indio] / key: 43, value: [kilo] / 


Overview of the Standard Library
================================
Introduction
The Go-distribution contains over 250 standard built-in packages for common functionality, like fmt, os, … , designated as the standard library written in the Go language itself (besides some low-level routines). See the documentation here. The API in all packages (included package os) is the same for all systems (Windows, Linux, …); the only package that is different for each system is syscall. In the examples and exercises throughout the course, we use the packages of the standard library.

svg viewer

Common packages
Here we will discuss the general purpose of a number of common packages grouped by function; we will not go into detail about their inner structure.

unsafe: contains commands to step out of the Go type-safety which is not needed in normal programs. It can be useful when interfacing with C/C++.
os: gives a platform-independent interface to operating-system functionality. Its design is Unix-like. It hides the differences between various operating systems to give a consistent view of files and other OS-objects.
os/exec: gives the possibility to run external OS commands and programs.
syscall: this is the low-level, external package, which provides a primitive interface to the underlying OS’s calls.
archive/tar and /zip – compress: contains functionality for (de)compressing files.
fmt: contains functionality for formatted input-output.
io: provides basic input-output functionality, mostly as a wrapper around os-functions.
bufio: wraps around io to give buffered input-output functionality.
path/filepath: contains routines for manipulating filename paths targeted at the OS used.
flag: contains functionality to work with command-line arguments.
strings: contains functions for manipulating and processing strings.
strconv: converts strings to basic data types.
unicode: contains special functions for Unicode characters.
regexp: provides sophisticated pattern-searching functionalities for strings.
bytes: contains functions for the manipulation of byte slices.
index/suffixarray: contains methods for very fast searching in strings.
math: contains the basic mathematical constants and functions.
math/cmplx: methods for manipulating complex numbers.
math/rand: contains pseudo-random number generators.
sort: contains functionality for sorting arrays and user-defined collections.
math/big: contains multi-precision arithmetic methods for working with arbitrarily large integers and rational numbers.
container: contains sub-packages that implement containers for manipulating collections, for example:
list: for working with doubly-linked lists.
ring: for working with circular lists.
time: contains basic functionalities for working with times and dates.
log: contains functionalities for logging information in a running program. We’ll use it throughout examples in the following chapters.
encoding/json: implements the functions for reading/decoding as well as writing/encoding data in JSON format.
encoding/xml: this is a simple XML 1.0 parser for examples of JSON and XML.
text/template: use this package to make data-driven templates that can generate textual output mixed with data, like HTML.
net: contains basic functions for working with network data.
http: contains functionality for parsing HTTP requests/replies, provides an extensible HTTP server and a basic client.
html: this is a parser for HTML5.
crypto – encoding – hash - ...: these form a multitude of packages for encrypting and decrypting data.
runtime: contains operations for interacting with the Go-runtime, such as the garbage collection and goroutines.
reflect: implements runtime introspection, allowing a program to manipulate variables with arbitrary types.

The regexp Package
===================
Overview
Package regexp implements regular expression search. For information about regular expressions and their syntax, visit this page.

Explanation#

package main
import (
  "fmt"
  "regexp"
  "strconv"
)

func main() {
  searchIn := "John: 2578.34 William: 4567.23 Steve: 5632.18" // string to search
  pat := "[0-9]+.[0-9]+" // pattern search in searchIn

  f := func (s string) string {
    v, _ := strconv.ParseFloat(s, 32)
    return strconv.FormatFloat(v * 2, 'f', 2, 32)
  }
  if ok, _ := regexp.Match(pat, []byte(searchIn)); ok {
    fmt.Println("Match found!")
  }
  re, _ := regexp.Compile(pat)

  str := re.ReplaceAllString(searchIn, "##.#") // replace pat with "##.#"
  fmt.Println(str)
  // using a function
  str2 := re.ReplaceAllStringFunc(searchIn, f)
  fmt.Println(str2)
}

Output
1.18s
Match found!
John: ##.# William: ##.# Steve: ##.#
John: 5156.68 William: 9134.46 Steve: 11264.36


In the code above, outside main at line 4, we import the package regexp. We want to search a string pattern pat (declared in main at line 10) in a string searchIn ( declared in main at line 9). At line 12, we have a function f. It is taking a string s, formatting it in float32, and returning the formatted string.

Testing if the pattern occurs is easy, use the function Match as: ok, _ := regexp.Match(pat,[]byte(searchIn)) (see line 16); where ok will be true or false. If ok is true, it means the match was found, so Match found! will be printed on the screen.

For more functionalities, you must first make a (pointer to a) Regexp object from the pattern; this is done through the Compile function (see line 19). Then we have at our disposal a whole number of Match, Find and Replace functions. At line 21, we replace the strings of pattern pat in searchIn with ##.#, and store the updated string in str. In the next line, we are printing str to see how ReplaceAllString of the package regexp works.

At line 24, we are again replacing some part of string searchIn, but this time through function f. We store the result in str2. This means str2 will be a formatted string in float32. In the next line, we are printing str to see the changes.

The Compile function also returns an error, which we have safely ignored here because we have entered the pattern ourselves and know that it is a valid regular expression. Should the expression be entered by the user or taken from a data source, it is necessary to check this parsing error.

In this example, we could also have used the function MustCompile, which is like Compile but panics (stopping the program with an error message when the pattern is not a valid regular expression.

Locking and the sync Package
=============================
A major problem
In more complex programs, different parts of the application may execute simultaneously (or concurrently as this is technically called), usually by executing each part of the program in a different thread of the operating system. When these different parts share and work with the same variables, problems are likely to occur. The order in which these shared variables are updated cannot be predicted, and hence, their values are also unpredictable! This is commonly called a race condition. The threads race for the updates of the variables. This is, of course, intolerable in a correct program, so how do we solve this issue?

The classic approach is to let only one thread at a time change the shared variable: the code in which the variable is changed (called the critical section) is locked when a thread starts executing, so no other thread can start with it. Only when the executing thread has finished the section, an unlock occurs so that another thread can access it.

svg viewer

In particular, the map type does not contain any internal locking to achieve this effect (this is left out for performance reasons); it is said that the map type is not thread-safe. So, concurrent accesses to a shared map data structure can corrupt the data of a map.

Solution provided by Go
In Go, this kind of locking is realized with the Mutex variable of the sync package. Here, the sync stands for synchronized, meaning that the threads are synchronized to update the variable(s) in an orderly fashion. A sync.Mutex is a mutual exclusion lock, which means it serves to guard the entrance to the critical section of the code so that only one thread can enter the critical section at one time. If Info is a shared memory variable which must be guarded, then a typical technique is to include a mutex in it, like:

import "sync"
type Info struct {
  mu sync.Mutex
  // ... other fields, e.g.:
  Str string
}
A function that has to change this variable could be written like:

func Update(info *Info) {
  info.mu.Lock()
  // critical section:
  info.Str = // new value
  // end critical section
  info.mu.Unlock()
}
An example of its usefulness is a shared buffer, which has to be locked before updating the SyncedBuffer:

type SyncedBuffer struct{
  lock sync.Mutex
  buffer bytes.Buffer
}
The sync package also has an RWMutex: a lock that allows many reader threads using RLock() but only one writer thread. If Lock() is used, the section is locked for writing as with the normal Mutex. It also contains a handy function once.Do(call), where once is a variable of type Once, which guarantees that the function call will only be invoked one time regardless of how many once.Do(call)(s) there are.

For relatively simple situations using locking through the sync package (so that only one thread at a time can access the variable or the map) will remedy this problem. If this slows down the program too much or causes other problems, the solution must be rethought with goroutines and channels in mind: this is the technology proposed by Go for writing concurrent applications. 


Web apps in Go
++++++++++++++
===============

It’s impossible to not interact with web apps in today’s world. We have apps on our phones, and we use them on our laptops through a browser. They are used in all walks of life, from checking the time on waking up to keeping track of our health, ordering food and groceries, getting to the office, and finally coming home and enjoying our favorite shows on streaming platforms. This course will introduce us to how these apps are actually developed, how we are able to interact with them, and what it takes to keep them running. And we will do this in one of the most efficient languages out there: Go.

Course overview
This course is a beginner’s guide to Go concepts that concern the backend development of an app. It is structured as follows.

At the start, we’ll look at the main concepts of HTTP and the basics of Go. We’ll also learn what makes Go such a popular choice for modern software.


svg viewer

Next, we’ll start building our app from scratch. This involves setting up the environment, structuring the app, and managing dependencies with Go modules. We'll briefly look at the many frameworks available in Go. Then, we'll pick Gin to write an HTTP server that is capable of handling requests efficiently and serving HTML.

No software should be released before it's thoroughly tested. So, we will discuss how we can write unit tests around functions, even ones that involve web server components, and make sure we release bug-free and resilient software. We will also cover table-driven tests, which are a more structured way of writing unit tests.

Since easy, stress-free deployment is the key to maintaining and improving an app, we’ll learn about containers and how they make managing apps super easy. This will include building an image for our Go app, running it, and managing the app's configuration. We will also see how we can leverage Docker Compose for local development. After that, we will build Docker images for our app. Docker images are small in size and quick to build.

And finally, we'll conclude the course by discussing the good practices that make an app easy to debug, analyze, and understand. Business logic alone is not enough to write a good piece of software. It should be easily debuggable. Keeping that in mind, we will see how we can add useful logs to the app to make a note of critical functionalities and errors. We will see how log levels and structured logging make sifting easier.

What is HTTP and an HTTP Web App?
=================================
In a world where smartphones and computers are so common, the internet is an essential and unavoidable tool. When we hear about the internet, we usually think of a network of websites serving content to users. This content may be:

Read-only, like Wikipedia.

Interactive, like a social networking website.

Interactive websites are actually web applications with a complex backend and a user-friendly interface.

So what’s a web application (or web app)?

What are web apps?
===================

A web app is a piece of software hosted on a remote server. It can be run in a web browser.

For anyone who has ever used the internet, it's almost impossible to not interact with a web app. Here are some well-known examples:

Social media apps like Facebook, Twitter, Instagram.

Video platforms like YouTube.

E-commerce websites like Amazon.

Streaming platforms like Netflix.

Now all these examples also have corresponding mobile apps. These may run on mobile devices instead of a browser, and the way the client interacts in these may differ. However, once the request reaches the server, they are most likely served by the same backend.

So, what does a web app consist of?

In order to work, a web app needs:

A client to send requests to the app over the network.

A server to service these requests. It may also use a persistence layer to store the data.

A predefined and uniform mode of interaction to communicate between the client and the server.

Client and server are pretty self-explanatory, but what about mode of interaction?

By the mode of interaction, we mean that the server needs to know how the client is sending the request, including details about the port and the protocol it's using. And it needs to know what information is being sent and how to interpret it to generate an appropriate response.

The interpretation part is done via application programming interfaces, or APIs. Let's see how.

Application programming interfaces (APIs)
Most web applications we see today consist of a bunch of application programming interfaces (APIs). These APIs are either directly exposed or used by other software to build on top of these. It's virtually impossible for anyone using the internet to not have used APIs. They are everywhere—even loading this page meant we hit a bunch of APIs on the server.

In simple terms, APIs are contracts that the client uses to access and modify resources on the server. In other words, a client communicates with the server by creating requests as defined by the API contract, and the server responds to these requests with a format that's also dictated by the API contract.

Some of the advantages of using APIs are:

It has a layer of abstraction. This means that the client doesn't need to know or care about the inner working of the server.

It has a tightly defined format. This adds a layer of security to the communication by ensuring that only absolutely necessary information is exchanged. For example, we don't need to provide personal details like a phone number when we're only browsing a website for news. 

So, if APIs only define the format, then how are the actual requests sent over the network? This is done via a little protocol you might have heard of: HTTP.

What is HTTP?
Hypertext Transfer Protocol (HTTP) is an application-layer protocol for transmitting hypermedia documents, such as HTML.

Most web addresses are prepended by either “http” or “https,” which is a more secure version of the HTTP protocol. It forms the backbone of client-server communication on the web.

A client sends an HTTP request to a server. The server then sends back an HTTP response.

HTTP Request
A typical request contains quite a bit of data, which can be broadly classified into two things:

Request header

Request body

Request header
Request headers have information about the request that will help the server process it. Request headers contain the following:

HTTP methods, of which the most common are:

GET: This is used to get information about some source.

POST: This is typically used to send some information to the server, like when submitting a form.

Host address/URL: This is the address of the server or the web app to which the request is being sent.

Cookies: These can be used for session management or storing some other useful metadata.

Content type: This is the format in which the body is sent, like JSON and XML.

Request body
The request body is used to send additional data to the server and is optional. POST requests typically use a body.

HTTP response
After receiving the HTTP request from the client, the server sends an HTTP response, which also has the following important fields:

Response header: This is used to pass additional information from the server to the client, like if the content type of the response is JSON or XML.

Response body: This is, again, an optional field and is used to return the resource information the client asked for.

Status code  
A status code is used to indicate if a request was successful or not. If it's unsuccessful, the status code also gives the reason for it.

That was just a very brief introduction to how web communication happens. It covered a lot of the basics, albeit at a very high level.

Why Create an App in Go?
========================

Learn about the features of Go that make it the top choice for creating microservices in high-traffic environments.

Why Go?
There are plenty of coding languages out there, so why should one choose Go?

Well, it depends on the use case. But in most scenarios, Go is a compelling choice because of the following reasons:

It's a statically typed, compiled language, so there are no syntax error traps to worry about.

It's very simple to learn. Anyone familiar with C will feel right at home.

It has clear, uncomplicated syntax and terminology, unlike some other modern languages.

All this makes it super easy for a developer to ramp up and start writing and maintaining applications in Go in no time.

Ease of use aside, Go also supports a bunch of useful little features.

What features does Go support?
Besides featuring an adorable gopher for a mascot, Go is a power-packed language with lots of critical features. Let’s discuss some of these in detail below.


svg viewer

Compact executable
Go compiles the entire code, including dependencies, into one simple, easy-to-handle executable file. The compilation process is fast compared to most languages, saving a lot of time and resources for the build machine. Additionally, this executable file is quite lightweight and small in size, making it quite easy to distribute and deploy.

Garbage collection
Go is a garbage-collected language. This helps in keeping the memory footprint low and running the code as efficiently as possible. We also don't need to worry about dangling pointers, which have been known to wreak havoc in languages like C and C++.

Built-in testing
Go has built-in library support for unit testing, which helps in writing bug-free code. So, all we need to do is include the testing package, and we can start writing unit tests for our code in the same package.

Concurrency
Go was built for concurrency. It uses goroutines and channels to create concurrent code. And communication between the goroutines happens via channels.

An interesting question to consider is whether goroutines are like threads.

Loosely, yes. They can be thought of as lightweight threads. They're lightweight because each of them takes only 2KB to 8KB of memory, depending on the Go version. So we can spin hundreds of thousands of them without any problem, making the application highly concurrent.

Concurrency in Go is a vast topic. However, we we won't be using it in our simple project in this course, so we won't look at it any further.

Easy to manage dependencies
Go has some great package managers, but the advent of Go modules takes it to a whole different level. They're built in and super easy to use, and they automate a lot of downloading and keeping track of dependencies.

We'll look into this in more detail in the first module.

How well does Go support a web app?
It's clear that if the goal is to have highly performant, super scalable, easy to maintain, and easy to build backends, Go is the way to go!

But what about when we want to build a web app? We know that Go is used in some of the most popular applications today. We'll look at some of these in the next lesson. But back to the original question: What makes it such a compelling choice for building web apps?

In addition to all of the things mentioned above, it's due to the great support Go has for web servers.

Built-in HTTP package
Go provides a built-in HTTP package, which can be used in both client and server implementations.

The client library allows us to:

Create web requests using various HTTP methods.

Have better control over HTTP client headers.

Control compression in requests.

Add settings for connection keep-alive.

Similarly, the server library is quite easy to implement. In fact, we can do it in as few as three lines! We won't get into any code at this stage.

Many choices for web frameworks
While the net package is great for a basic app, Go has a ton of third-party web frameworks, like Gorilla Mux and Gin.

These are feature-rich frameworks, providing many essential but out-of-the-box solutions, like routing, middleware, serialization, and parsing URLs for query and path parameters. We'll look at some of these in detail in the first module, where we will try to implement a web server.

Rich support for the storage layer
Most real-world applications have a persistent layer. Go has support for most major databases and caches. It has robust client libraries to interface with databases, such as MySQL, PostgreSQL, MongoDB, and distributed caches, like Redis and ElasticSearch.

There are also several third-party ORM libraries out there to interface with the databases, GORM being one of the most popular ones.

Integration with cloud platforms
Go has integration with all the major cloud infrastructure companies, like AWS, GCP, and Azure.

The software development kits (SDKs) for the platforms above are easy to use and well maintained. This allows us to integrate and run our applications on the cloud, taking advantage of the multiple useful services they offer, like S3, GCS buckets, DynamoDB, and so on.

Ease of use with Docker
Containerizing an application is not optional these days. Doing so has a lot of benefits, the biggest ones among these being portability and ease of distribution.

Using Docker with Go has never been easier. All we need to do is import the official Docker Go image to start running our application in it. This is also something we'll cover in the subsequent modules.

Templating libraries
If an application involves sending output to the outside world, Go's templating libraries are a blessing. Whether the application is serving a web page, sending out emails, or just serving simple HTML files, the templating package supports all of it.

We can use these libraries to standardize sending data in a structured way in the client browser. This avoids writing a lot of extra code while also getting benefits like data sanitization.

Conclusion
The above points give a clear idea of what makes Go a special language and why it's chosen by some of the biggest players in tech to build fast and efficient applications. If you're unconvinced of its advantages over older languages, we encourage you to go ahead and write a little program in Go, and we guarantee that you'll be able to see the difference for yourself!

Some Popular Go Projects
=========================

Go's popularity is increasing by the day. It's the third most popular language on GitHub, going by the stars. It's only natural that more and more companies are using it to build their highly scalable software.

Let's take a look at some of the well-known real-world applications that heavily use Go.

Google
Go was created at Google. So it's no surprise that they use it heavily in projects like Google Earth and YouTube.


svg viewer

Kubernetes: A container orchestration system
Most modern tech companies either use Kubernetes or want to use it. It’s a powerful system written in Go and is used to deploy, maintain, and monitor applications with ease.


svg viewer

SoundCloud: A music-sharing platform
Low compilation time and static typing in Go gave SoundCloud the ability to perform static analysis, and its simplicity significantly improved the pace of development.


svg viewer

Uber: A ride-sharing app
Uber started using Go for their geofencing due to its high performance and concurrency. Encouraged by the results, many other services have adopted it.


svg viewer

Dropbox: A cloud service
Dropbox is used by millions of users to store and share content. It not only uses Go for its efficiency but has also contributed to Go by building several libraries in it.


svg viewer

SendGrid: A cloud-based email service
SendGrid is an email delivery and marketing service. It can be used to notify the customers of an event like an outage or a failure in the workflow. It is also used for marketing purposes, like sending offers and invoices to users. The developers of SendGrid chose Go to build these services, which needed to be asynchronous, concurrent, very efficient, and easily maintainable.


svg viewer

Twitch: A live-streaming service
Due to Go’s simplicity, readability, and efficiency, Twitch uses it to serve its users live-streamed content with low latency and high quality.


Quick Recall of Go Concepts
===========================
Due to its easy-to-use syntax, lightweight executable, and high performance, Go would be a great choice to build the backend of any application.

For those who have not used Go in a while, we'll go over a few of the key concepts at lightning-fast speed. We won't be touching concurrency.

Variables
A variable is a means to store a value. It could be a string, a number (int, float), or something a little more complicated, like an array, a map, or a struct. In case you forgot how those work in Go, don’t worry! We’ll go over them soon enough.

Variables can be declared and defined in two ways.

var a int
The line above declares a variable a of type int.

var a = 10
The line above declares a variable a and assigns it the value 10.

a := 10
This is a shorthand way of declaring and defining a variable. One thing to keep in mind is that this notation works only for local variables.

Arrays and slices
Both arrays and slices in Go represent a collection of similar items, but they have a few subtle differences.

Arrays
Like in most languages, an array in Go is a collection of the same kind of elements. The index of elements starts with 
0
0
 and ends with 
�
�
�
�
�
ℎ
−
1
length−1
, where length is the size of the array. One thing to keep in mind is that arrays in Go need to have a definite length, which must be defined beforehand.

12345678
package main

import "fmt"

func main() {
  numbers := [2]int{1, 2}
  fmt.Println("Array ", numbers)
}

Run

Save

Reset
Array in Go
In line 6 in the code snippet above, we declare the array numbers of length 2. We also add two elements to it, numbers 1 and 2.

When we run the code, the array is printed.

So far, so good. But what happens if we try to append elements to an array? Let's try it out! The code below tries to append another element, the number 3, to the array:

package main

import "fmt"

func main() {
  numbers := [2]int{1, 2}
  fmt.Println("Array ", numbers)
  numbers = append(numbers, 3)
}

# command-line-arguments
./main.go:8:20: first argument to append must be a slice; have numbers (variable of type [2]int)

Running the code above throws the following error: first argument to append must be a slice; have numbers (variable of type [2]int).

This shows that arrays in Go are static and we can't append elements to them.

But what if we want to use an array of flexible size, something to which we can append elements? This is a fairly common use case in web applications. For this, Go has something called a slice.

Slices
A slice is just like an array, but it has no limit on size

package main

import "fmt"

func main() {
  numbers := []int{1,2}
  fmt.Println("Slice ", numbers)
}

Output
0.79s
Slice  [1 2]

In line 6 in the code snippet above, we define a slice of int called numbers. Note that it again has two elements, numbers 1 and 2, but no size is defined. On running the code, the output looks exactly like that of an array.

Let's try appending another element to it. We are doing this in line 8 in the code snippet below:

package main

import "fmt"

func main() {
  numbers := []int{1,2}
  fmt.Println("Slice ", numbers)
  numbers = append(numbers, 3)
  fmt.Println("New Slice ", numbers)
}


Output
1.16s
Slice  [1 2]
New Slice  [1 2 3]

On running the code, no errors are thrown, and the newly printed slice has the new element 3.

Functions
A function is a block of code that does something. It has a name, can accept variables as arguments, and can even return some values.

package main

import "fmt"

func prependHelloToString(input string) string {
    return "Hello " + input
}

func main() {
  fmt.Println("Final string - ", prependHelloToString("Tom"))
}

Output
0.88s
Final string -  Hello Tom

The code above defines a function prependHelloToString in line 5. The function takes a string called input as an argument and returns another string. In line 9, we can see that main is also a function.

Maps
A map, also called a dictionary in some languages, is a store of key-value pairs. A map with string keys and int values is represented as map[string]int. Note that maps in Go are initialized to nil by default and have to be instantiated using make, like in line 6 below.

Another way to declare and define a map is by using pre-added elements, as can be seen in line 7 below.

package main

import "fmt"

func main() {
  emptyMap := make(map[string]int)
  mapWithElements := map[string]int{"a" : 1, "b" : 2}
  fmt.Println("Maps - map1 ", emptyMap, " and map2 ", mapWithElements)
}

Output
1.01s
Maps - map1  map[]  and map2  map[a:1 b:2]

Structs
A struct is a custom data type. There is no concept of class in Go, and structs are used to define any custom data structure. The below struct Coffee has fields Name of type string and Size of type int.

package main

import "fmt"

type Coffee struct {
  Name string
  Size int
}

func main() {
  latte := Coffee{Name: "Latte", Size: 3}
  fmt.Println("Coffee instance ", latte)
}

Output
0.64s
Coffee instance  {Latte 3}


Packages
Packages are like namespaces for files and folders. They are usually logically combined with code that does something specific. A package is declared at the top of the .go file with the keyword package. In the examples we have used above, line 1 has always referenced the name of the package main .

Let's try to add a package named coffeeshop, with the Coffee struct discussed above:

package coffeeshop

type Coffee struct {
  Name string
  Size string
}

One thing to keep in mind is that the name of the package must be the same as the name of the folder it's being defined in.

Now, to use these packages, all we need to do is import them, as seen in lines 3–6 below. Then we can type the package name to call any function in it. Let's see this with an example:

package main

import (
    "fmt"
    "strconv"
)

func main() {
    var s string = "123"
    var num int
    num, _ = strconv.Atoi(s)

    fmt.Printf("Converting string %s to number %d", s, num)
  
}

Output
0.86s
Converting string 123 to number 123


In the code snippet above, we are using Go's built-in package named strconv to extract an int out of a string variable named s and store it in variable num.

To do this, we import the strconv package in line 5 and then use its function Atoi to convert the string variable s into an int in line 11.

This is then printed in line 13. Go ahead and click the “Run” button to give it a go.

Build and Run a Basic Go Program
=================================

After that quick recap of some commonly used concepts of Go, let's try to use what we've learned so far. We'll put together a small Go program.

Let's start with a simple “Hello World” program.

Note: If you're already familiar with building small programs in Go, feel free to skip this lesson.

Writing “Hello World” in Go

package main
import "fmt"

func main() {
    fmt.Printf("Hello World")
}

Hello World


Let's try to understand what's going on in the code above:

Line 1: We declare a package called main, which is the namespace where the code in the file lies. This namespace is typically used for the main function, which we'll get into in a bit.

Line 2: We then import the built-in fmt package. As we have already seen in the previous lesson, it's used for I/O formatting in Go.

Line 4: We declare the main function. The main function is a special function and serves as the point of entry when the code is executed. It doesn't take any arguments and is automatically run by Go when the code is run using commands like go run.

Line 5: We print the string Hello World by passing it as an argument to the Printf function of the fmt package.

Finding all odd numbers in a list using Go 
Let's try to do something a bit more complex and try to find out all the odd numbers from an array of integers using Go.

We'll implement a function called findAllOddNumbers.

This will use some of the Go concepts we learned earlier. It will take an array of integers and return all the odd numbers in it.

package main
import "fmt"

func main() {
    numbers := []int{1, 2, 3, 4, 5}
    fmt.Printf("Printing all odd numbers ", findAllOddNumbers(numbers))
}

func findAllOddNumbers(numbers []int) []int {
  result := []int{}
  for _, num := range numbers {
    if num % 2 != 0 {
      result = append(result, num)
    }
  }
  return result
}


Output
1.27s
Printing all odd numbers %!(EXTRA []int=[1 3 5])

In the above piece of code:

Line 9: We define the function findAllOddNumbers, which takes a slice of int as input and returns another slice of int.

Line 10: We declare an empty slice called result. This is where we'll store the final result.

Lines 12–14: We iterate over a slice. We use the keyword range, which returns the index of the element and the actual element in the array. Since we don't need an index for our use case here, we store it in _. In Go, this is a way to ignore a variable if we don't need it. We store the actual number in the variable num.

Things are pretty simple after that:

In line 12, we check if the number is odd. And if it is, we store it in a slice, result, in line 13. This slice is then returned in line 16.

The function is called from main, and the return value is printed in line 6. The output, as expected, has all the odd elements [1, 3, 5] .

Executing the code
Now that we understand the little code snippet above, let's see what happens when the Run" button is clicked in the above code widget.

When we press the “Run” button, it builds the code using go build main.go. 
This produces an executable. This executable then runs to execute the code. 
But there is something else going on under the hood. To understand that, copy the code 
snippet above into a file and try to execute it in a terminal.

One simple way to execute the code is:

"go run main.go"

This compiles the source code and runs the executable. However, we won't be able to see any executable file because it doesn't generate one explicitly.

But what if we want to distribute the executable? For that, we can use the following command:

"go build"

This command generates an executable containing the code and all of its dependencies.

The resulting file has the same name as the folder it's in. To give it a specific name, use the -o flag.

"go build -o <choose a name>"

We may see the following error on building the code:

go: go.mod file not found in current directory or any parent directory; see ‘go help modules’


Environment Setup and Scaffolding
=================================

In order to build a web app, or any software for that matter, we must go through a few stages:

Requirement gathering: This stage entails figuring out what we want to build.

Designing: This includes designing the various components of the app, including the APIs and the databases.

Scaffolding: This involves writing the boilerplate code.

Development: This is the part where we start writing the business logic of the app.

There are other stages, like testing and releasing, but we won't focus on them here.
-----------------------------------------------------------------
Requirement gathering -> Designing -> Scaffoldidng -> Development
------------------------------------------------------------------

Tools required to build an app
We'll use ready-to-run code widgets in this course. Check the appendix if you want to set up the development environment for Go on your machine.

Scaffolding the app
So let's start building our web app. The first step is gathering the requirements for the app.

What are we trying to build?
We'll try to build a very simple backend for a coffee shop website.

Let's jot down the APIs we might need to build this app:

See the menu, i.e., list the types of coffee available, the sizes they are available in, and their prices.

Add items to carts.

Place an order.

Create a user profile complete with delivery address and contact information.

Use the user profile to send custom offers to users.

The above is by no means a comprehensive list. You can try to think of some other features that we might add.

Freezing the requirements
Building all the functionalities above is complex and requires persistent data stores. The actual website will also need a frontend part that handles form submissions and sends requests to the backend.

Our goal here is to learn how to create HTTP endpoints in the backend and Dockerize them for easy distribution. So, to avoid taking on too much and straying from our goal, we'll start with just the first functionality: listing the menu of the coffee shop on the website and displaying it.

Writing some code
Now that we are clear on the requirements, let's start creating our app.

We'll create a folder called coffeeshop in the user's home folder. It doesn't have to be the home folder, but that's the one we're using. Thanks to Go modules, we can now locate our project anywhere we wish. Don't worry if that sounded confusing. We'll discuss it in detail in the next lesson.

For now, let's use the following command:

"mkdir coffeeshop

This is the directory where all of our web app code will reside. It's called the project root folder.

Inside the project root folder, we'll add our first piece of code, a file named coffee.go with the following code:


package coffee

var coffees = map[string]float32{"Latte":2.5, "Cappuccino": 2.75, "Flat White": 2.25} 

func GetCoffees() map[string]float32 {
	return coffees
}

The project structure now looks like this:

coffeeshop
|__ coffee.go 


Executing the code
Let's try to execute the code and see what happens.

go run .

Just go ahead and hit the “Run” button, which runs the command above under the hood.

package coffee

var coffees = map[string]float32{"Latte":2.5, "Cappuccino": 2.75, "Flat White": 2.25} 

func GetCoffees() map[string]float32 {
	return coffees
}

go: go.mod file not found in current directory or any parent directory; see 'go help modules'

The program doesn't run. Instead, we get the following error:

go: go.mod file not found in current directory or any parent directory; see ‘go help modules’

Package Management and Go Modules
=================================
What are Go modules?
A module is a collection of packages that are released, versioned, and distributed together. In simple words, a Go module is a built-in dependency management system. It automates the downloads and updates of the package dependencies and even removes the ones no longer being used. It’s supported by Go 1.13 onward and manages third-party dependencies as well as local packages. 

So, what did we do before Go 1.13?

History of Go's dependency management
Go is a very new language, so its history isn't that long. But it's essential to have a look at it to understand why certain things happen the way they do in Go.

Package or dependency management is a nightmare in some languages, while others fare better. It's often the cause of a lot of bugs and frustration! It's especially annoying for someone who is new to the language and finds out that the error they spent the last three days debugging was actually due to a mismatched dependency.

So let's start at the very beginning!

The go get command
There was no proper dependency management system in Go before v1.11. The only way to fetch the dependencies was to use the command go get .

go get full_path_of_dependency_package


It would download the dependency code from its master repo and put the files into $GOPATH. The $GOPATH folder was supposed to be the project root folder where all the source code, along with the dependency files, would reside.

This was extremely inconvenient and full of bugs. There was no versioning of dependencies. This meant that any major change in a dependency package would most likely break the code since go get would always fetch from the master dependency codebase.

Glide
Glide was a package management tool that tried to resolve some of the shortcomings discussed above. It was a third-party tool, but it had the concept of versioned dependencies!

With this tool, we would need to write a glide.yaml file, which would have all the dependencies of a package listed along with their version. These versions would be frozen using a lock file called glide.lock and could be later installed using glide install. This meant that the build could be reproduced since we could trust that the dependency version being downloaded is the one we chose.

Go 1.15 introduced the concept of vendoring, which Glide supported. Vendoring is the process of keeping local copies of dependencies in a vendor folder. It's a standard feature in Go 1.6 onward but had to be explicitly enabled earlier.

Vendoring alleviated the $GOPATH problem a bit since the dependency files no longer need to be only in $GOPATH.

This was a drastic improvement over go get, but there was still the hassle of writing a YAML file, which could be error prone.

Dep
Dep was another package manager that improved things a bit.

With Dep, we didn't need to create any additional configuration files to manage dependencies. It came with a handy set of commands that would take care of it for us. For example, dep init would autogenerate two files—Gopkg.toml and Gopkg.lock. Executing this command would cause Dep to scan through the codebase and write the dependencies along with their version in the toml file. These would then be locked in Gopkg.lock. To change a version, we would need to edit the toml file and run dep ensure to freeze it.

This improved things a bit. But Dep still required the projects to be located in $GOPATH, adding inflexibility and more complexity, especially for beginners. Developers needed to understand how to set up a project environment properly and how the compiler handled the dependency resolution. In addition, it still needed to be installed explicitly. Versioning packages also were not officially supported by Go yet.

Dep was deprecated in 2020 in favor of Go modules.

So, how do Go modules solve some of these problems? We'll look at this in the next section.

Go modules are better
Any professional code is usually divided into multiple logical components called packages. We need a system to manage these packages in a fuss-free way so that the software can be released as smoothly as possible.

A module usually consists of one project with a collection of packages. Some of the advantages of managing dependencies using Go are as follows:

In the past, the source code of Go projects had to reside in $GOPATH. But with Go modules, we can put it in any directory of our choice.

Go modules keep track of third-party libraries being imported by the program, like MySQL or Redis client libraries. Modules support versioned dependencies.

Once initialized, Go modules automatically check for dependencies when the code is being built, run, or tested.

It’s much easier to use and maintain the explicit versions of each import in go.mod and go.sum files. We'll learn more about these in the next section.

They come built-in with Go, so unlike previous dependency management tools, Go modules require no additional installation.

They support vendoring, which means that Go modules are also able to put the dependencies to a /vendor directory.

Under the hood
Go modules use two files to function and keep track of dependencies:

go.mod

It specifies the project name, which we need in order to import a project or individual packages.

It also has a list of dependencies for the project and the minimum required versions of these dependencies.

go.sum

It lists down the checksum of all the dependencies along with their version.

It includes both direct and indirect dependencies.

Both these files will be located at the project root. But how are these files created or written? Go has some pretty handy commands to use Go modules, fetch dependencies, and keep them up to date.


How to Use Go Modules in a REST App
===================================
Learn how modules work by using them to manage dependencies in the coffee shop app

Earlier, in the “Environment Setup and Scaffolding” lesson, we created the coffee.go file for our coffee shop.

package coffee

var coffees = map[string]float32{"Latte":2.5, "Cappuccino": 2.75, "Flat White": 2.25} 

func GetCoffees() map[string]float32 {
	return coffees
}

At that time, executing the go run or go build commands via the “Run” button threw the following error:

go: go.mod file not found in current directory or any parent directory; see ‘go help modules


Popping the hood on go.mod
===========================
coffeeshop
|__ go.mod
|__ coffee
    |__ coffee.go

    educative coffeeshop % cat go.mod 

    module coffeeshop

go 1.18


In the code above:

Line 1 has the keyword module followed by the name of the module, coffeeshop. We passed this as part of go mod init in an earlier lesson. This line tells Go to resolve any reference to coffeeshop in paths in import statements to the current project directory.

Line 3 states the Go version used for this project, which is 1.18 in our case.

Since we have just one folder, coffee, in our project root and one file, coffee.go, inside it, go.mod is limited in content right now. More content will get added to it as we add more code with external dependencies.

We'll try doing this in the next lesson.

Third-party libraries
The code above reads a map of coffees and prints it. But is it a good idea to keep the list of coffees in the main code?

Ideally, no. Any changes in the list will require the Go code to be built again and the service to be redeployed.

To avoid that, let's keep it in a separate config file. We'll create a file called config.json in the project root with the following code:

{
   "coffeelist":[
      {
         "name":"Latte",
         "price":3
      },
      {
         "name":"cappuccino",
         "price":2.5
      }
   ]
}


So this JSON file has a key called coffeelist with a list as its value. It's a list of JSON objects, each with a string field, i.e., name, and a float field, i.e., price, like this:

{
   "name":"Latte",
   "price":3
}


Let's also modify coffee.go to accommodate these changes. Since the menu of the coffee shop now resides in a JSON file outside of the source code, we'll need to figure out a way to read it.

Viper is the perfect package for this use case. It's a third-party library that can read environment variables and files in formats JSON, XML, etc. We'll use it to read the config file as follows:
package coffee

import (
"fmt"
"github.com/spf13/viper"
)
//var coffees = map[string]float32{"Latte":2.5, "Cappuccino": 2.75, "Flat White": 2.25} 

type CoffeeDetails struct {
	Name string 
	Price float32 
}

type CoffeeList struct {
	List []CoffeeDetails 
}

var Coffees CoffeeList

func GetCoffees() (*CoffeeList, error) {
	viper.AddConfigPath(".")   
	err := viper.ReadInConfig()            
	if err != nil { 
		fmt.Println("fatal error config file: %w", err)
		return nil, err
	}
	
	err = viper.Unmarshal(&Coffees)
	if err != nil {
		return nil, err
	}
	
	return &Coffees, nil
}

Let's try to understand this code.

In line 9, we first create a struct called CoffeeDetails. It has a structure similar to that of the JSON objects in the list, i.e., a string field called name and a float32 field called price.

Similarly, in line 14, we have a struct called CoffeeList to get the actual list. It essentially holds List, which is a slice of the CoffeeDetails struct.

In line 21, we use viper.AddConfigPath to look for config files.

If a config file is found, Viper reads it in line 22. What follows is some pretty standard error handling.

In line 28, we unmarshal the read config into Coffees, which is a variable of type CoffeeList declared in line 18. We return as a pointer in line 33.

Now that we have a third-party dependency, we need to use Go modules to fetch it. This can be done by executing the following command in the project root:

go mod tidy 

On executing the command above, we can see a lot of packages being downloaded, including Viper. This is the Go module fetching it.

go: finding module for package github.com/spf13/viper
go: found github.com/spf13/viper in github.com/spf13/viper v1.12.0


Adding Business Logic to the App
=================================
Add business logic to the app and learn to call functions that belong to a package.

So far, we have some code in our project in a package called coffee. But how can we execute it? Like most languages, the execution point of entry in Go is the main function (except when we use init as the execution of entry).

Adding the main function

Let's add a main.go function.

package main

import (
        "fmt"
        "coffeeshop/coffee"
)
func main() {
        fmt.Println("Printing the list of coffees available in the CoffeeShop ")
        coffees, err := coffee.GetCoffees()
        for _, element := range coffees.List {
                result := fmt.Sprintf("%s for $%v", element.Name, element.Price)
                fmt.Println(result)
        }
}

Quite a few things are going on in this file. Let's go over it line by line.

In line 1, we declare a package main for the file.

In line 3, we start an import block. The first one is fmt, which is used to format the string in line 11 and then print the output in line 12.

There's nothing new in this so far. But line 5 is really interesting. Here, we import the package coffeeshop/coffee, which we defined in an earlier lesson. We are able to import code from that package this way since we initialized a module for our project, coffeeshop.

We use this package in line 9 to call the GetCoffees function, and it returns a list of the types of coffee available along with their prices.

This list of information is printed in line 12.

Executing the code
Let's try to run the code to see if it works. We'll run the code using go run like this:

go run main.go

Printing the list of coffees available in the CoffeeShop 
Latte for $2.5
Cappuccino for $2.75
Flat White for $2.25


Awesome! We organized our project into modules and packages, imported these packages, and ran the code using the main function.

Hit the “Run” button in the widget below to see the code's execution:

Some more functionalities
Let's add a few more functionalities to our app. What if someone wants to search for a particular kind of coffee? We'll add a very simple function called IsCoffeeAvailable in the coffee package.

package coffee

import (
"fmt"
"github.com/spf13/viper"
)
//var coffees = map[string]float32{"Latte":2.5, "Cappuccino": 2.75, "Flat White": 2.25} 

type CoffeeDetails struct {
	Name string 
	Price float32 
}

type CoffeeList struct {
	List []CoffeeDetails 
}

var Coffees CoffeeList

func GetCoffees() (*CoffeeList, error) {
	viper.AddConfigPath(".")               
	err := viper.ReadInConfig() 
	if err != nil { 
		fmt.Println("fatal error config file: %w", err)
		return nil, err
	}
	
	err = viper.Unmarshal(&Coffees)
	if err != nil { return nil, err }
	return &Coffees, nil
}

func IsCoffeeAvailable(coffeetype string) bool {
        for _, element := range Coffees.List {
                if element.Name == coffeetype {
                result := fmt.Sprintf("%s for $%v", element.Name, element.Price)
                fmt.Println(result)
                return true
                }
        }
        return false

}

In the playground above, we define IsCoffeeAvailable in line 33. It takes a string, coffeetype, iterates over the slice Coffees.List, and tries to find a match for the name. If a match is found, it returns true. Otherwise, it returns false.

Normally, a search doesn't work this way. However, since our goal here is not to build a sophisticated search app, this will do for now.

Let's call this from the main function in main.go like this:
package main

import (
        "fmt"
        "coffeeshop/coffee"
)
func main() {
        coffees, err := coffee.GetCoffees()
        if err != nil {
		fmt.Println("Error while getting coffeelist ", err)
		return
	}

	fmt.Println("Printing the list of coffees available in the CoffeeShop...")
        for _, element := range coffees.List {
                result := fmt.Sprintf("%s for $%v", element.Name, element.Price)
                fmt.Println(result)
        }

        fmt.Println("Is Latte Available? ", coffee.IsCoffeeAvailable("Latte"))
}


A Little About Go Web Frameworks
===============================

Why do we need web frameworks?
To build a web app, an HTTP service in our case, the first thing we need is a web framework.

Well, technically, that's not 100% true. We can work without web frameworks and build a service by just using the internal libraries in Go, but there's no need of reinventing the wheel when we have web frameworks that can take care of most of the stuff for us.

The benefits of using web frameworks are briefly summarized here:

They take care of a lot of boilerplate code.

They speed up the development process by providing a lot of out-of-the-box solutions.

They help reduce maintenance overheads.

All this allows companies to focus on and build solutions for the unique problem they are trying to solve.

Some popular frameworks
==========================

Go has a wide range of frameworks to choose from. Let's explore some of these.

Gin
Gin is the most popular framework in Go right now, especially if you want to write microservices.

Here are some of its salient features.

It’s easy to install and use.
It’s highly performant due to its low memory footprint.
It provides a rich set of functions to read incoming requests and frame the response in an appropriate format, including when it returns errors.
It provides good support for middleware.



Gorilla Mux
Gorilla Mux offers an excellent request router that can match and dispatch requests based on URL host, path, path prefix, and even header and query parameters. It can even process nested routes and direct the request to the appropriate handlers.

Gorilla Mux also has great support for middleware and can handle cross-origin or CORS requests.




Beego
Beego is more of an MVC-style web framework and adheres to some of the classic paradigms of web development. It's a feature-packed framework and favors a modular code structure, which is great for large enterprise applications. It also has ORM support to access data and manage sessions, which comes in handy.

Iris
Iris may be familiar if you've worked with web frameworks of Node.js. It's a very simple framework with great support for third-party libraries, making it very easy to extend functionalities with one's packages. It also supports the MVC architecture and has features like session management, WebSockets, dependency, and injection.

Martini
Martini looks quite similar to Gin in terms of syntax. It's very lightweight with support for all basic things like middleware, exception handling, and routing. The downside of being lightweight is that it has a limited feature set and often needs add-ons.

Which one should we use?
The list above is by no means an exhaustive one. There are plenty of other great web frameworks available in Go. We should pick one that best suits our needs. This can depend on the size of the application, the features we need, the kind of performance we are looking for, and how comfortable the developers are with the framework.

Since we are building a very simple application, we could have used any one of them. But using a very heavy one that has features we don't need would be an overkill for our task. Let's go with Gin for our web app because of all the benefits it provides us.


Creating an HTTP Server Using Gin
=================================
What is an HTTP server?
HTTP is the protocol that's used to serve most of the content on the web. There are a few components involved in this process:

Client: This is the software that's used to access services made available by the server, such as the web browser.

Server: This is a piece of software that can process HTTP requests and return a response.

Endpoint or API Endpoint: This is the path exposed by the server to perform a specific operation on the resource being served.

Handler: These are usually the functions used to handle calls directed to an endpoint.

Let's try to write a simple server in Go that receives a ping request and sends back a response to its caller.

Creating an HTTP server without any framework
We'll start with a very simple request, which doesn't involve processing any query or path parameter. For this, we'll directly use Go's built-in net/http package. This package provides a basic server and client implementation.

In the below code snippet, we have tried to implement a ping endpoint for our server:

package main

import (
"net/http"
"fmt"
"io"
)

func main() {
	http.HandleFunc("/ping", ping)
	
	fmt.Println("Starting the server at port 8081")
	err := http.ListenAndServe(":8081", nil)
	if err != nil {
		fmt.Println("Error while starting the server ", err)
	}
}

func ping(w http.ResponseWriter, r *http.Request) {
	fmt.Println("Got a ping")
	io.WriteString(w, "Welcome to the Coffeeshop!\n")
}

Let's see what's happening above:

In line 10, we use the HandleFunc function to define our endpoint. It takes the first argument as the endpoint, which is "\ping", and the second argument as the handler function, ping.

The handler function ping is defined in line 19. All handler functions have two arguments.

The first is http.ResponseWriter. The responseWriter interface has a write method, which is used by the net/http package to form a response. It then sends this response back to the connection.

The second is http.Request. When a request hits an endpoint, the net/http package marshals it into an object of type http.Request. This can be used to access information like query parameters and request body.

Our ping function is pretty simple: in line 20, it prints that it received a request and writes back a response in line 21 using the responseWriter object named w.

Back in the main function, we start our server at line 13. Once started, it will listen on port 8081 for any incoming requests.

On running this code, the server starts locally, prints "Starting the server at port 8081" on the terminal, and waits for requests on localhost:8081 .

Testing it
In order to test the code above, we need to send requests to the server with the endpoint URLs. This can be done with a tool like a cURL quite easily. If we use the same system, the command to hit the ping endpoint would be:

curl http://localhost:8081/ping


This request will hit the server, and the server will forward it to the ping function. We should see the following in the same terminal:
Welcome to the coffeeshop!

On the terminal where the server is running, the following would be printed:

Got a ping

This is great, but can writing a web server using Gin make it any easier? Let's give it a shot.

Creating an HTTP server with Gin
The same server can be written using Gin in the following way

package main

import (
"fmt"
"net/http"
"github.com/gin-gonic/gin"
)

func main() {
	r := gin.Default()
	r.GET("/ping", ping)
	fmt.Println("Starting the server at port 8081")
	r.Run(":8081") 
}

func ping(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{
			"message": "Welcome to the Coffeeshop!",
	})
}

This looks much more concise than using net/http, but what's actually going on here? Let's try to understand it.

In line 10, we call gin.Default. As the name indicates, it creates a router with default middleware for logging and recovery.

Then in line 11, router object r accepts GET requests on endpoint /ping and directs them to the handler function ping.

Line 12 has a message to be printed to the console.

In line 13, the server starts listening for requests. The default port is 8080, but since we have given 8081 as input, that's where the server listens.

Then, in line 16, we define a handler function, ping. All handlers in Gin take a Gin context object as an argument. This object is used to pass around variables and manage flow in the scope of a single request to the server. It contains all the request details, and we can write the response to it.

Line 17 is where the response is sent back via the gin.Context object. We send http.StatusOK as the status code, meaning the request was successful, followed by a message string. The command c.JSON will make sure the response is sent back in JSON format.

We've now written our first endpoint, which is a very simple ping function. But this was like writing a “Hello World” program! Let's add some handlers that can actually serve some of the functions we wrote about before. We have already written a function that lists all the types of coffee available in our coffee shop.

Here's how we'll add handlers for the getCoffee function of the coffee package:

Search in directory...
/
coffee
.gitignore
config.json
go.mod
go.sum

package main

import (
"net/http"
"github.com/gin-gonic/gin"
"coffeeshop/coffee"
)

func main() {
	r := gin.Default()
	r.GET("/ping", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{
			"message": "Welcome to the Coffeeshop!",
		})
	})
	r.GET("/coffee", getCoffee)
	r.Run(":8081") 
}

func getCoffee(c *gin.Context) {
	coffeelist, _ := coffee.GetCoffees()
	c.String(http.StatusOK, " %s", coffeelist)
}

In the above playground:

In line 16, we add a GET endpoint named /coffee with its handler function getCoffee.

In line 20, we define getCoffee. The signature is standard to a Gin handler function. Here, respond with status 200 (StatusOk) and returning the coffeelist as a string.

And that's it! We now have an endpoint that, when called, will return the coffee shop menu! Go ahead and press the “Run” button in the widget above to hit both endpoints and see the output. First, it prints the output of the /ping endpoint and then that of /coffee. Although the formatting leaves something to be desired, our endpoints are now doing what's expected.


Adding a User Interface for This App
====================================
Most web apps usually have an interface that the user can interact with. This interface consists of a bunch of files that are responsible for:

Framing and sending the appropriate requests to the server.

Receiving a response from the user and displaying it in a user-friendly way.

The most straightforward way to write these files is in HTML. So let's try to build this interface for our coffee shop web app.

Creating a home page for the app
The home page of an app is where the user first lands. Since creating beautiful web pages is not our focus here, we'll create a basic home page using the following HTML in a file called index.html.

<!DOCTYPE html>
<html>
     <head>
          <title>The Coffeeshop</title>
     </head>
     <body>
          Welcome to the Shop!
     </body>
</html>


We'll put this file in a folder called templates. This folder is also where we'll put any other HTML we write. The overall project structure now becomes:

coffeeshop
|__ go.mod
|__ go.sum
|__ config.json
|__ coffee
    |__ coffee.go
|__ templates
    |__ index.html

    Now let's look at how we can make sure this file is served when a user lands on the home page.

It's quite simple actually! We'll define an endpoint /home in our web server and a corresponding handler function, like this:
import (
"fmt"
"net/http"
"github.com/gin-gonic/gin"
)

func main() {
	r := gin.Default()
	r.LoadHTMLGlob("templates/*.html")
	r.GET("/home", func(c *gin.Context) {
        c.HTML(http.StatusOK, "index.html", nil)
    })
	fmt.Println("Starting the server...")
	r.Run(":8081") 
}


Let's get into what we are doing in the code above:

In line 8, we initialize a Gin router that has the built-in functionality to handle and serve static files.

In line 9, we load all the HTML files from the specified location. In our case, all the HTML files are in the templates folder, represented by templates/*html.

In line 10, we have the GET endpoint /home with an inline function as the handler. It's a simple function, defined in line 11. It renders index.html and returns http.StatusOk in the response. The third argument, which is nil here, is meant for providing arguments to the HTML file being served. We'll look into this in detail in the next section of this lesson.

Finally, in line 14, we start the server. Since no port is specified, it runs on the standard HTTP port 8081.

The code snippet below shows all these changes along with what we have in our coffee shop app so far. Press the “Run” button below to start the server at port 8081:

Serving index.html
Let's test what we have so far in a real browser. We'll start the server by running the code in main.go above using go run main.go.

To hit the server endpoints on a local machine, open a browser window and enter localhost:8081/home.


Unit Testing in Go
==================
It is vital to test any new code we add if we want to avoid releasing buggy code and then deal with the headache of debugging and fixing it in a time crunch. Some of the issues this can lead to can be disastrous, and if they result in data loss, it could even lead to losing customers.

There are many kinds of tests we can use to cover our app. One of them is unit tests.

What is unit testing?
Unit tests are generally the first kind of test written for code. They are great for enabling test-driven development (TDD).

Some of the things that make unit tests great are:

Unit tests are written at a very granular level, mostly per function.

They help us make sure that the code is behaving exactly how we want.

They can be run without a lot of supporting code.

They are super fast. Most unit tests can complete within a few seconds.

Unit tests help catch bugs early on in the development process.

They also help avoid regression due to any new changes or refactoring.

Unit testing in Go
Go recognizes the importance of unit testing. Therefore, it offers a built-in package called testing, which is super easy to use and doesn't take long to learn.

Let's take a simple example to see how it works.

Unit testing with a simple example
Let's try to unit test the code snippet given below. In the code:

We have a function AddTwoNumbers in line 11, which takes two integers as inputs and returns their sum.

We call the AddTwoNumbers function from the main function in line 7.

The result is printed in line 8.

Go ahead and click the “Run” button below to run this program!

package main
import "fmt"

func main() {
    a := 1
    b := 2
    result := AddTwoNumbers(a, b)
    fmt.Printf("Adding %d and %d returns %d", a, b, result)
}

func AddTwoNumbers(a , b int) int {
    return a + b
}

Output
0.93s
Adding 1 and 2 returns 3


As expected, it returns the correct sum of the two numbers.

It seems easy enough to test this code by simply running the entire program, but what if AddTwoNumbers is part of a very large codebase? Or, what if more functionality is added to it later? Unit testing would come in handy in those cases to make sure the code works as intended.

So, let's try to unit test the function AddTwoNumbers.

Naming test files and functions in Go
Go follows a very simple convention for the test files. They need to be in the same package as the functions they're testing, and they need to end with _test.go.

package main

import "testing"

func TestAddTwoNumbers(t *testing.T) {
    input1, input2 := 2, 3
    expected := 5
    output := AddTwoNumbers(input1, input2)
    
    if output != expected {
        t.Errorf("Expected '%d', but got '%d'", expected, output)
    }
}

Let's look at the above code:

Since the test file is in the same directory as the code it's testing, it will have the same package name as the code. In our case, it will be main, as seen in line 1 above.

We import the testing package in line 3.

Line 5 is where the actual testing starts. The test function has to follow a few conventions. One is that its name should start with Test , followed by the function it's testing. In our case, this becomes TestAddTwoNumbers. Another convention is that it should take a pointer to testing.T as an argument and usually return nothing.

Inside the function, we initialize the puts for AddTwoNumbers in line 6 and the expected result in line 7.

In line 8, we simply call AddTwoNumbers and store the output.

Now, we need to verify if this output is the correct result. In line 10, we compare the obtained output with the expected output. If they don't match, we raise an error using the t.Errorf function of the testing package in line 11. If an error is raised, the test fails.

Running tests
Now that we have some unit tests in place, let's try to run them.

Click the “Run” button in the widget below to execute the test:


As we can see, all the tests pass without any issues. But what's really going on when we hit the “Run” button? How are the tests getting executed?

Luckily, Go allows us to run all the unit tests with a single command. There are a few ways to execute them:

We can execute the unit tests from inside the directory where the test files are located:

go test
To get a detailed result of what tests were run and what their results were, we can add a -v flag as follows:

go test -v
We can also execute the unit tests from the root folder or any other subfolder. Executing the following command will run all the tests in all the files, ending with _test.go inside that folder recursively.

go test -v ./...
It will print the following output:

=== RUN   TestAddTwoNumbers
--- PASS: TestAddTwoNumbers (0.00s)
PASS
ok      example 0.154s
For the output shown above, main.go and main_test.go reside in a folder called example:

In line 1, the output prints the test names that are running.

Lines 2–3 display the results of those tests.

Line 4 has the name of the folder these tests and their results reside in.

Table-driven tests
Normally, if we are writing unit tests, we want to check for more than one combination of inputs.

This can be easily done by adding a few additional sets of inputs and checking them against an expected output, as we did earlier. In other words, we can do this by basically repeating lines 6–12 in main_test.go again and again. But that would lead to too many lines of code and may become difficult to read.

Go offers a neater way to do this in the form of table-driven tests, which we can see in the code below:


package main

import "testing"

func TestAddTwoNumbers(t *testing.T) {
    type Testcase struct {
        input1 int
        input2 int
        expected int
    }

    cases := []Testcase{
        {1, 2, 3},
        {3, -5, -2},
        {-4, -6, -10},
    }

    for _, tc := range cases {
        got := AddTwoNumbers(tc.input1, tc.input2)
        if tc.expected != got {
            t.Errorf("Expected '%d', but got '%d'", tc.expected, got)
        }
    }
}

In the code above:

We define the struct Testcase in line 6 inside our test function. This will store the inputs we want to give AddTwoNumbers and the result we expect.

We then initialize a list of Testcase in line 12 with all the possible combinations to test.

Line 18 simply iterates over these inputs, checks the result, and fails the test if they don't match.

We then run these just like we did earlier, using go test -v ./.... Press the “Run” button below to see it in action:


A few more words on unit testing#
So, we saw how easy it is to write and test the Go code. Note that test files are not included in the final executable when the code is built, which is one of the reasons it's so lightweight. And since all the tests can be executed with a single go test -v ./... command, running unit tests is super easy to automate. Simply run the command via a script or in a CI step of the build and release pipeline, and you are done!
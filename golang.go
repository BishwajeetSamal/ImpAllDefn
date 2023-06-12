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
Slices work differently then array.
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







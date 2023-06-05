To Print - use print("Bishwajeet Samal!") ##cannot use Print(" dsad") because it is case sensitive

We can write in Pycharm

Variables
----------
name = "Bishwajeet Samal"
age = 22
print(name)
print(age)

name ="Mamta manjari Samal"
print(name)

Four Major type of Variables
--------------------------
name = "bishwajeet" //String
age = 22 //int
price = 120.11 //float
is_adult = True or False //boolean but not (true or false), case sensitive

To take the input
------------------
name = input("What is your name? ")
print("Hello "+ name) ## print the name assigned by the user (taking the input)
old_age = input("Enter your old age ?") ## Here it take the input as String but we dont want to take it as String. 
//but we want it as int.
int(old_age) //converted to int from string
new_age = old_age+2
print(new_age)

We can convert to other datatype
float() -> Float
str() -> String
boolean() -> Boolean
print(float(18)) -> output as 18.0


first = input("Enter first number: ")
second = inut("Enter Second number: ")

sum = int(first)+int(second)
print("the sum is: "str(sum)) ##if we want to print the sum with integer then we need to change the int to String to
##print it

String
-------
name = "Bishwajeet"
//we can change with many functions provided by the python
print(name.upper()) ##change to Upper case
print(name.lower()) ##name to lowercase
print(name.find('s')) ##it will find the character inside string and return the index //thus return, 2
print("bishwa") // return -1
print(name.replace("Bishwa",Satya))  ## prints the Satyajeet
print('B' in name) ##searches "B" inside name, return true or false


Arithmetic operator
--------------------
print(5+2)
print(5-2)
print(5*2)
print(5/2)
print(5//2) ## removes the decimal part
print(5%2) ## gives remainder
print(5**2) ## 5 to the power 2, return 25

Shorcuts
--------
i=5
i = 5+2 // we can write in shorter way like, i+=2, same for Sub (i-=2), i*=2

result = 2+3*5 ##it follows the rule in python, then it will result 30

Comments
--------
#here is the comment 

Comparsion operator
-------------------
print(3>2) #true
print(3<2) #false
print(3>=2) #true
print(3==2) #false
print(3!=3) #false


Logical Opearators
------------------
There are 3 Opearators
1. OR operator -> print(2>3 or 2>1) //true
2. AND operator -> print(2>3 and 2>1) // true
3. Not operator -> print(not 2>3) //true

If-else statement
------------------
age = 19

if age>=18:
	print("You are an adult")
	print("You can vote")
elif age<18 and age>3:
	print("You are in School")
else:
	print("You are a child")

Range
-----
Range means that we can go from one value to other

numbers = range(5) # 0,1,2,3,4
print(numbers) # prints range(0,4)


Loop
----
while loop
----------
i = 1
while i < 5:

print(i)
i = i + 1 # prints from 1 to 5

----------------------------------
i = 1
while i < 5:

print(i * "*")
i = i + 1 #prints the triangle
-----------------------------------
for Loop
--------
for i in range(5):
	print(item) #0 1 2 3 4 5


---------------------------------
List Datatype
-------------
marks = [95,98,97]  # it is a list
print(marks)
print(marks[0])
print(marks[-1]) # strats printing from back side

print(marks[0:2]) # print  95 98

for score in marks:
	print(score)

List Operations
________________
marks.append(99)

print(marks) # 95,98,97,99

marks.insert(0 (90)) # insert the element 90 in oth  index

print(99 in marks) # checks 99 is available in marks or not, then according to that we will get true or false

print(len(marks)) # length of marks

break and continue
------------------
 students = ["ram","shyam","radha","radhika"] #wants to print till radha
 for student in students:
 	if student == "radha"
 	break;
 	print(student) # it will print ram shyam

 //Now we want to ignore the name then we can write 
 for student in students:
 	if student == "shyam"
 	continue;
 	print(student) # ram radha radhika

 tuple
 -----
 It is like list but immutable.
 marks = (20,30,40,50,60) or  marks = 20,30,40,50,60

Opeations on tuple
------------------
print(marks.count(95)) #0
print(marks.index(20)) #0 this is index

Set //unique values
---
marks = {20,30,40,50}


Dictionary (We store the data in key-value pairs)
----------
marks = {"english":95, "chemistry":98}

print(marks[chemistry]) # prints, 98

marks["physics"] = 97;
print(marks)

marks["physics"] = 90
print(marks) # it will print the data

information = {"Bishwajeet":"Mamta"}

Functions
---------
1. Inbuilt functions
2. Module Functions
3. User defined functions





 
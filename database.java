🔥🔥Java JDBC
==============
1.JDBC stands for Java Database Connectivity. It is a part of JavaSE (Java Standard Edition). 
2.JDBC is a technology and an API which is used to connect Java Application with database.
3.The JDBC API defines interfaces and classes for writing database applications in java making database connections.
|-------------------------------------------------------------------------------------------------------|
|Java Application----->JDBC API-----> JDBC Driver Manager----->(Driver-->Oracle Database,               |
|   Driver--->Mysql Database,Driver--->Postgres Database)                                               |
|-------------------------------------------------------------------------------------------------------|

JDBC COMPONENTS
----------------
* A JDBC driver is a software component enabling a Java application to interact with the database.
--->Driver handles the communications with the database server (like Oracle).
--->You will interact with the driver objects very rarely.
--->Instead you use DriverManager objects, which manages objects with this type.
--->It also abstracts the detail associated with working with Driver objects.

DriverManager manages a list of database drivers.

---It matches the connection requests from the java application with the proper database driver using 
communication sub-protocol.
---The first driver that recognizes a certain sub-protocol under JDBC will be used to establish a database
connection.

After the DriverManager works complete then  connection work starts.
 ---> Connection interface has all methods for contacting a database.
 ---The connection object represents communication context, i.e. all communication with database is through
 connection object only.

PREPARED STATEMENTS
--------------------
--->Prepared statement is an interface for represnting SQL statements.
---A SQL statement is precompiled and stored in a PreparedStatement object.
---This object can then be used to efficiently execute this statement multiple times.

RESULT SET
------------
--->ResultSet is an interface to represent a database table.
---These objects hold data retrieved from a database after you execute an SQL query using Statement objects.
---It acts as an iterator to allow you to move through its data.

STEPS FOR CONNECTION
*********************
1. Loading Driver
------------------
~~>A program can also explicitly load JDBC drivers at any time.
 ~~>For Example,the my.sql.Driver is loaded with the following statement:
   ~~>Class.forName("my.sql.driver");

2. Establishing Connection
-----------------------------
~~>When getConnection is called the DriverManager will attempt to locate a suitable driver from amongst loaded at 
initialization and those loaded explicitly.
~~>DriverManager.getConnection(url,user,password)
Note -- Here url means database url //like "jdbc:oracle:thin:@localhost:1521:XE"
~~>getConnection method returns Connection object on success otherwise null. 

3.Preparing Statements
-----------------------
*Connection object has a method to prepare a statement(SQL STATEMENT).
* ps=con.prepareStatement(query_string);
*prepareStatement method returns object of PreparedStatement.

4. Executing Statements
------------------------
*PreparedStatement has several methods to execute query.
--execute() //return bool (true or false)
--executeQuery() //For Select Query, it return resultSet . It can be null if emplty. 
--executeUpdate()//For Select Query, it return resultSet  

5.Getting Results
------------------
ResultSet object can be obtained as a returned object by executeQuery() method of PreparedStatement.
--ResultSet object when not null or not empty, can be iterate over that object and get results.

6.Closing Database Connection
------------------------------
* Connection object has a method called close() to close the connection.
*con.close()
*******************************************Theory Close************************************************************

import from java.sql.*; //This is the package for the SQL. 

												              JPA(JAVA PERSISTENCE API)
											           -----------------------------------
1.JPA is a specification .
2.ORM stands for Object-Relational Mapping (ORM) is a programming technique for converting data between relational 
databases and object oriented programming languages such as Java, C#, etc.
It is capable to handle various database operations easily such as inserting, updating, deleting etc.
				|JAVA OBJECT ---> ORM ---> Database|
				-------------------------------------
In our projects there will be many objects. ORM will perform placing our objects and stored in our DB or vice-versa 
that is it can bring data from database in form of ,Objects.
Principle
-----------***
The JPA is all about creating Objects which can map to the Database objects. The application will use JPA 
specification to push or retrieve an object from the database, and underlying JPA implementations will take care 
of the low-level SQL queries. That is called Object Relational Mapping (ORM). 

What is Spring Data JPA, if not a JPA Implementation?
Speaking precisely, Spring Data JPA is an add-on for JPA. It provides a framework that works with JPA and provides
 a complete abstraction over the Data Access Layer.
 Spring Data JPA brings in the concept of JPA Repositories.

JPA is a specification of java, which is used to access manage and persist data between 
java object and Relational DataBase. It is considered as a standard approach for ORM.
It does not perform operation by itself. Thus require implementation.
It is defined in javax.persistence package.
                 -----------------
Specification:-
--------------
In general Specification means a document that describes what the software will do and how it
will be expected to perform.

Persistence simply means to Store Permanently.
In JAVA we work with Objects and try to store Objects values into database(RDBMS mostly).
JPA provides implementation for Object Relation Mapping(ORM) ,so that we can directly store Object into Database as a new Tuple.
Object, in JPA, are converted to Entity for mapping it to the Table in Database.
So Persisting an Entity means Permanently Storing Object(Entity) into Database.


Storage Engine:-
----------------
A database engine (or storage engine) is the underlying software component that a database management system (DBMS)
 uses to create, read, update and delete (CRUD) data from a database.

 												DBMS - Indexing
 												----------------
 1. We know that data is stored in the form of records. Every record has a key field, which helps it to be 
 recognized uniquely.
 2.Indexing is a data structure technique to efficiently retrieve records from the database files based on some 
 attributes on which the indexing has been done. 
 Indexing is defined based on its indexing attributes. Indexing can be of the following types −






 											          ~||~ { SQL(Structured Query Language) } ~||~
 												             --------------------------------
 Que -->What is SQL?
SQL is Structured Query Language, which is a computer language for storing, manipulating and retrieving data in a 
relational database.

SQL is the standard language for a relational database system. All the Relational Database Management Systems (RDMS)
like MySQL, MS Access, Oracle, and SQL Server use SQL as their standard database language.
--------------------------------------------------------------------------------------------------------------------
Que-->A brief history of SQL
SQL was initially developed by IBM in the early 1970s. The initial version, called SEQUEL 
(Structured English Query Language), was designed to manipulate and retrieve data stored in IBM’s quasi-relational 
database management system, System R. Then, in the late 1970s, Relational Software Inc., which is now Oracle 
Corporation, introduced the first commercially available implementation of SQL, Oracle V2 for VAX computers.
-------------------------------------------------------------------------------------------------------------------
Que->>Why SQL?
SQL is widely popular because it can

Create the database and table structures.

Perform basic data management chores (add, delete and modify).

Perform complex queries to transform raw data into useful information.
---------------------------------------------------------------------------------------------------------------------
SQL Commands#
--------------
The standard SQL commands to interact with relational databases are CREATE, SELECT, INSERT, UPDATE, DELETE, and DROP. 
These commands can be classified into the following groups based on their nature:
DDL - Data Definition Language
-------------------------------
CREATE	------>Creates a new table, a view of a table, or other objects in the database.
ALTER	------>Modifies an existing database object, such as a table.
DROP	------>Deletes an entire table, a view of a table or other objects in the database.
TRUNCATE-----> Truncate the table.Truncate operations drop and re-create the table, which is much faster 
than deleting rows one by one, particularly for large tables. It cannot be rolled back.

DML - Data Manipulation Language
----------------------------------
SELECT	Retrieves certain records from one or more tables.
INSERT	Creates a record.
UPDATE	Modifies records.
DELETE	Deletes records.

DCL(Data Control Language):  It contains commands which are required to deal with the user permissions and
---------------------------   controls of the database system.

E.g., GRANT and REVOKE.

TCL(Transaction Control Language):  It contains commands which are required to deal with the transaction of the database.
----------------------------------
E.g., COMMIT, ROLLBACK, and SAVEPOINT.

ACID -- Atomicity,Consistent,Isolated,Durable

Atomicity: This property reflects the concept of either executing the whole query or executing nothing at all, which
 implies that if an update occurs in a database then that update should either be reflected in the whole database
  or should not be reflected at all.

  Consistency: This property ensures that the data remains consistent before and after a transaction in a database.

  Isolation: This property ensures that each transaction is occurring independently of the others. This implies that 
  the state of an ongoing transaction doesn’t affect the state of another ongoing transaction.

Durability: This property ensures that the data is not lost in cases of a system failure or restart and is present 
in the same state as it was before the system failure or restart.

--------------------------------------------------------------------------------------------------------------------
SQL Data Types and Operators
---------------------------
A SQL data type is an attribute that specifies the type of data of any object. You can specify the data type of 
each column in the table based on your requirements.
Exact Numeric Data Types
-----------------------
DataType                           |                    Ranges From                    |    To           
--------------------------------------------------------------------------------------------------------------
int	                               |                    -2,147,483,648                 | 2,147,483,647
--------------------------------------------------------------------------------------------------------------
bigint                             |     -9,223,372,036,854,775,808                    |9,223,372,036,854,775,807
------------------------------------------------------------------------------------------------------------------
smallint	                       |       -32,768	                                   |  32,767
------------------------------------------------------------------------------------------------------------------
etc

SQL comparison operators
-------------------------
Assume ‘variable a’ holds 10 and ‘variable b’ holds 20.

Operator	                   |         Description	            |             Example
------------------------------------------------------------------------------------------------------------------
    =                          | Checks if the values of two        |
                               | operands are equal or not, if      |             (a = b) is not true
                               | yes then condition becomes true    |
                               
------------------------------------------------------------------------------------------------------------------
                               |                                    |
------------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------------------

Constraints
===========
1.Primary key
2.Foreign key
3.Check
4.Unique
5.default
6.Not Null


NOT NULL - Ensures that a column cannot have a NULL value
UNIQUE - Ensures that all values in a column are different
PRIMARY KEY - A combination of a NOT NULL and UNIQUE. Uniquely identifies each row in a table
FOREIGN KEY - Prevents actions that would destroy links between tables
CHECK - Ensures that the values in a column satisfies a specific condition
DEFAULT - Sets a default value for a column if no value is specified
CREATE INDEX - Used to create and retrieve data from the database very quickly

SQL Injection
-------------
SQL injection is a code injection technique that might destroy your database.

SQL injection is one of the most common web hacking techniques.

SQL injection is the placement of malicious code in SQL statements, via web page input.
SELECT * FROM Users WHERE UserId = 105 OR 1=1;
SELECT UserId, Name, Password FROM Users WHERE UserId = 105 or 1=1;
SELECT * FROM Users WHERE Name ="" or ""="" AND Pass ="" or ""=""
SELECT * FROM Users WHERE UserId = 105; DROP TABLE Suppliers;
JOINS
=====

JOIN operations
---------------
A JOIN clause is used to combine rows from two or more tables, based on a related column between them.
The JOIN operations, which are among the possible TableExpressions in a FROM clause, perform joins between two 
tables.
TableExpression
---------------
A TableExpression specifies a table, view, or function in a FROM clause. It is the source from which a 
SelectExpression selects a result.

SelectExpression
----------------
A SelectExpression is the basic SELECT-FROM-WHERE construct used to build a table value based on filtering and 
projecting values from other tables.

FROM clause
-----------
The FROM clause is a mandatory clause in a SelectExpression. It specifies the tables (TableExpression) from which 
the other clauses of the query can access columns for use in expressions.



1.Cross JOIN
2.Natural JOIN
3.Conditional JOIN
4.Equi JOIN
5.Self JOIN
6.Outer JOIN->Left,Right,Full
7.Inner JOIN->The INNER JOIN keyword selects records that have matching values in both tables.
------*******************
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;
-------****************

Left Join/Left Outer Join-> The LEFT JOIN keyword returns all records from the left table (table1), and the
 matching records from the right table (table2). The result is 0 records from the right side, if there is no match.
----------*****************
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY Customers.CustomerName;
----------****************

RIGHT JOIN/RIGHT Outer JOIN -> The RIGHT JOIN keyword returns all records from the right table (table2), and the 
matching records from the left table (table1). The result is 0 records from the left side, if there is no match.
---------****************
SELECT Orders.OrderID, Employees.LastName, Employees.FirstName
FROM Orders
RIGHT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
ORDER BY Orders.OrderID;
---------****************

Full Outer Join
---------------
The FULL OUTER JOIN keyword returns all records when there is a match in left (table1) or right (table2) table 
records.
--------------****************
SELECT Customers.CustomerName, Orders.OrderID
FROM Customers
FULL OUTER JOIN Orders ON Customers.CustomerID=Orders.CustomerID
ORDER BY Customers.CustomerName;
---------------**************

Self Join
---------
A self join is a regular join, but the table is joined with itself.

SQL SELECT DISTINCT Statement
-----------------------------
The SELECT DISTINCT statement is used to return only distinct (different) values.

The SQL AND, OR and NOT Operators
---------------------------------
The WHERE clause can be combined with AND, OR, and NOT operators.
The AND and OR operators are used to filter records based on more than one condition:

The AND operator displays a record if all the conditions separated by AND are TRUE.
The OR operator displays a record if any of the conditions separated by OR is TRUE.

The NOT operator displays a record if the condition(s) is NOT TRUE.

The SQL ORDER BY Keyword
-------------------------
The ORDER BY keyword is used to sort the result-set in ascending or descending order.
SELECT column1, column2, ...
FROM table_name
ORDER BY column1, column2, ... ASC|DESC;

The SQL INSERT INTO Statement
------------------------------
The INSERT INTO statement is used to insert new records in a table.
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);


The SQL UPDATE Statement
------------------------
The UPDATE statement is used to modify the existing records in a table.
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;


The SQL DELETE Statement
------------------------
The DELETE statement is used to delete existing records in a table.
DELETE FROM table_name WHERE condition;

The SQL SELECT TOP Clause
--------------------------
The SELECT TOP clause is used to specify the number of records to return.
SELECT column_name(s)
FROM table_name
WHERE condition
LIMIT number;

SELECT * FROM Customers
LIMIT 3;

SQL Wildcard Characters
------------------------
A wildcard character is used to substitute one or more characters in a string.
Wildcard characters are used with the LIKE operator. The LIKE operator is used in a WHERE clause to search for 
a specified pattern in a column.

* Represents zero or more characters
? Represents a single character
[]  Represents any single character within the brackets
! Represents any character not in the brackets
- Represents any single character within the specified range
# Represents any single numeric character

SELECT * FROM Customers
WHERE City LIKE '[bsp]%';

SELECT * FROM Customers
WHERE City LIKE '[a-c]%';

SELECT * FROM Customers
WHERE City LIKE '[!bsp]%';

SELECT * FROM Customers
WHERE City NOT LIKE '[bsp]%';

The SQL IN Operator
-------------------
The IN operator allows you to specify multiple values in a WHERE clause.
The IN operator is a shorthand for multiple OR conditions.

SELECT column_name(s)
FROM table_name
WHERE column_name IN (value1, value2, ...);

SELECT * FROM Customers
WHERE Country IN ('Germany', 'France', 'UK');

The SQL BETWEEN Operator
------------------------
The BETWEEN operator selects values within a given range. The values can be numbers, text, or dates.
The BETWEEN operator is inclusive: begin and end values are included. 

SELECT column_name(s)
FROM table_name
WHERE column_name BETWEEN value1 AND value2;

SELECT * FROM Products
WHERE Price BETWEEN 10 AND 20;

The SQL GROUP BY Statement
--------------------------
The GROUP BY statement groups rows that have the same values into summary rows, like find the number of customers 
in each country.

The GROUP BY statement is often used with aggregate functions (COUNT(), MAX(), MIN(), SUM(), AVG()) to group 
the result-set by one or more columns.

SELECT column_name(s)
FROM table_name
WHERE condition
GROUP BY column_name(s)
ORDER BY column_name(s);

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country;

SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
ORDER BY COUNT(CustomerID) DESC;

What is a Stored Procedure?
---------------------------
A stored procedure is a prepared SQL code that you can save, so the code can be reused over and over again.
So if you have an SQL query that you write over and over again, save it as a stored procedure, and then just 
call it to execute it.

You can also pass parameters to a stored procedure, so that the stored procedure can act based on the parameter
value(s) that is passed.

CREATE PROCEDURE procedure_name
AS
sql_statement
GO;

Execute a Stored Procedure
EXEC procedure_name;
----------------------------------------
CREATE PROCEDURE SelectAllCustomers
AS
SELECT * FROM Customers
GO;

EXEC SelectAllCustomers;
-----------------------------------------

CREATE PROCEDURE SelectAllCustomers @City nvarchar(30)
AS
SELECT * FROM Customers WHERE City = @City
GO;

EXEC SelectAllCustomers @City = 'London';

SQL Comments
------------
Comments are used to explain sections of SQL statements, or to prevent execution of SQL statements.

Single Line Comments
Single line comments start with --.

--Select all:
SELECT * FROM Customers;


SELECT * FROM Customers -- WHERE City='Berlin';

Multi-line Comments
ulti-line comments start with /* and end with */.

Any text between /* and */ will be ignored.

SQL Operators
---------------
SQL Arithmetic Operators
Operator 
+ Add 
- Subtract  
* Multiply  
/ Divide  
% Modulo

SQL Bitwise Operators
Operator  
& Bitwise AND
| Bitwise OR
^ Bitwise exclusive OR

SQL Comparison Operators
Operator  
= Equal to  
> Greater than  
< Less than 
>=  Greater than or equal to  
<=  Less than or equal to 
<>  Not equal to

SQL Compound Operators
Operator  Description
+=  Add equals
-=  Subtract equals
*=  Multiply equals
/=  Divide equals
%=  Modulo equals
&=  Bitwise AND equals
^-= Bitwise exclusive equals
|*= Bitwise OR equals


SQL Logical Operators
Operator 
ALL     ->  TRUE if all of the subquery values meet the condition 
AND     ->  TRUE if all the conditions separated by AND is TRUE 
ANY     ->  TRUE if any of the subquery values meet the condition 
BETWEEN ->  TRUE if the operand is within the range of comparisons  
EXISTS  ->  TRUE if the subquery returns one or more records  
IN      ->  TRUE if the operand is equal to one of a list of expressions  
LIKE    ->  TRUE if the operand matches a pattern 
NOT     ->  Displays a record if the condition(s) is NOT TRUE 
OR      ->  TRUE if any of the conditions separated by OR is TRUE 
SOME    ->  TRUE if any of the subquery values meet the condition




MySQL String Functions
--------------------------
Function  Description
ASCII -------------Returns the ASCII value for the specific character
CHAR_LENGTH ---------------Returns the length of a string (in characters)
CHARACTER_LENGTH  ---------Returns the length of a string (in characters)
CONCAT  -------------Adds two or more expressions together
CONCAT_WS --------Adds two or more expressions together with a separator
FIELD -------------Returns the index position of a value in a list of values
FIND_IN_SET--------Returns the position of a string within a list of strings
FORMAT  ---------------------Formats a number to a format like "#,###,###.##", rounded to a specified number of decimal places
INSERT  ----------------------Inserts a string within a string at the specified position and for a certain number of characters
INSTR ----------------------Returns the position of the first occurrence of a string in another string
LCASE ----------Converts a string to lower-case
LEFT  -----------Extracts a number of characters from a string (starting from left)
LENGTH --------- Returns the length of a string (in bytes)
LOCATE ----------- Returns the position of the first occurrence of a substring in a string
LOWER ------Converts a string to lower-case
LPAD  --------Left-pads a string with another string, to a certain length
LTRIM -------Removes leading spaces from a string
MID -------Extracts a substring from a string (starting at any position)
POSITION -------- Returns the position of the first occurrence of a substring in a string
REPEAT  -------Repeats a string as many times as specified
REPLACE ------Replaces all occurrences of a substring within a string, with a new substring
REVERSE ---------Reverses a string and returns the result
RIGHT --------Extracts a number of characters from a string (starting from right)
RPAD  ------Right-pads a string with another string, to a certain length
RTRIM ---------Removes trailing spaces from a string
SPACE ---------Returns a string of the specified number of space characters
STRCMP -------- Compares two strings
SUBSTR  -------Extracts a substring from a string (starting at any position)
SUBSTRING --------Extracts a substring from a string (starting at any position)
SUBSTRING_INDEX ---------Returns a substring of a string before a specified number of delimiter occurs
TRIM  ------Removes leading and trailing spaces from a string
UCASE -------Converts a string to upper-case
UPPER --------Converts a string to upper-case
Java JDBC
=========
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






 											  {	SQL(Structured Query Language) }
 												------------------------------
 Que -->What is SQL?
SQL is Structured Query Language, which is a computer language for storing, manipulating and retrieving data in a 
relational database.

SQL is the standard language for a relational database system. All the Relational Database Management Systems (RDMS)
ike MySQL, MS Access, Oracle, and SQL Server use SQL as their standard database language.
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
The standard SQL commands to interact with relational databases are CREATE, SELECT, INSERT, UPDATE, DELETE, and DROP. 
These commands can be classified into the following groups based on their nature:
DDL - Data Definition Language
-------------------------------
CREATE	------>Creates a new table, a view of a table, or other objects in the database.
ALTER	------>Modifies an existing database object, such as a table.
DROP	------>Deletes an entire table, a view of a table or other objects in the database.

DML - Data Manipulation Language
----------------------------------
SELECT	Retrieves certain records from one or more tables.
INSERT	Creates a record.
UPDATE	Modifies records.
DELETE	Deletes records.

DCL(Data Control Language):  It contains commands which are required to deal with the user permissions and controls of the database system.
E.g., GRANT and REVOKE.

TCL(Transaction Control Language):  It contains commands which are required to deal with the transaction of the database.
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

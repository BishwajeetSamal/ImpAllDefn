JOINS
======
Basically we need to joins multiple tables in a single query, you would be able to fetch the data you want. This
where we need to use joins.
1. Inner Join / Join
---------------------
like :- Select e.emp_name, d.dept_name 
from employee e
join department d ON e.dept_id = d.dept_id;
//Here matching will happen upon the given condition 

2. Left Join
-------------
Left Join = Inner Join + all remaining records from Left table 

3. Right Join
--------------
Right Join = Inner Join + all remaining records from Right table 


Full Outer JOIN / Outer Join
-----------------------------
Full outer join = Inner join + all remaining records from Left table
                             + all remaining records from Right table

Select e.emp_id, d.dept_name from employee e 
full join department d on d.dept_id = e.dept_id;

CROSS Join
----------



Video Link -> "https://www.youtube.com/watch?v=Ww71knvhQ-s" and you can 
download the scripts you want to run, link is -> 
"https://techtfq.com/video/sql-window-function-part1-sql-queries-tutorial"
_____________________________________________________________________
*********************************************************************

Window Function (It also known as analytical function)
---------------
*In PostgreSQL, a window function is a type of function that performs calculations across a set of rows that
 are related to the current row. These functions are executed in conjunction with the OVER clause and allow you
  to perform calculations and aggregations over a specified window or frame of rows.

*Window functions in PostgreSQL offer advanced analytical capabilities and provide a way to calculate values that
 are based on a specific partition or order within the result set.


//Que -> To find the max salary from an employee table ?
======================================================
Ans -> Select max(salary) as max_salary from employee;
________________________________________________________

//#. Lets we want to extract max salary earned by an employee in each department then I can use or extract by 
//using GroupBy clause
Select dept_name, max(salary) as max_salary 
from employee
group by dept_name;
________________________________________________________
//#. Lets suppose I want to extraxt the max salary in each department but along with the other details as well.
//Then we will not get the result by just using Group By clause or aggregate functions then we can do,
====================================================================================================
Select e.*, max(salary) over() as max_salary
from employee
group by dept_name;  //for every record it has same value of max_salary
//Here we are using max(salary) but also with over() clause thus, sql will not treat max as aggregate function.
//It will treat it as like window function. 
//over() is basically used to specify sql to create a window of records. So if I dont specify any column inside over()
// so what happend is sql will cerate one window for all the records in this result set.
_________________________________________________________

Lets say if I want to extract the max salary corresponding to each depqrtment, then we can use called 
partition by.
=====================================================================================================

Select e.*, max(salary) over(partition by dept_name) as max_salary
from employee
group by dept_name; 
//Here it will give the max_salary according to each department name.

____________________________________________________________

1. ROW_NUMBER
==============
It just going to assign a unique value to each record of the table
like 
Select e.*, row_number() over() as rn 
from employee e; 
//For every record in the table we will get the unique identifier.
//Here sql will treat as one window and for the whole window assing a row number.

Lets say we want to assign a  number based on the department name then, 
we can do same like 
-----------------------------------------------------------------------
|Select e.*, row_number() over(partition by dept_name) as rn           |
|from employee e; // It will assign according to the department name.  |
-----------------------------------------------------------------------

//So what is the use of these functions, so lets say we have  a requirement of where I want to fetch the first two (2)
//employees that joined the comapany in each department.
=====================================================================================================================
So we can have a sloution, where the employees have joined previously have lower id then who joined later.

Select e.*, row_number() over(partition by dept_name order by emp_id) as rn 
from employee e; // Now the data is sorted as per the employee Id.

Now to get the first two employees from each department

Select * from (Select e.*, row_number() over(partition by dept_name order by emp_id) as rn 
from employee e) as x
where x.rn<3; //Here we get the result.

2. RANK()
==========
//fetch the top 3 employees in each department earning the max salary.
=======================================================================
So we need to do rank() based on their salaries and then we need to fetch the top 3 employees from each of the 
department.
To achieve these kind of results, the best way to query is using the rank() window function.

Select e.*,
rank() over(partition by dept_name order by salary desc) as rnk 
 from employee; 

 //Whenever we are using rank() then it will give same rank for the duplicate values. But for every duplicate record 
//its going to skip a value. It uses the same rank but for very next record which is not duplicate, it going to 
 //skip a value and assign the value.

 //Now If I want to fetch the top 3 salaries  then we can do it by using a sub-query,
 Select * from (Select e.*,
rank() over(partition by dept_name order by salary desc) as rnk 
 from employee) x 
 where x.rnk < 4;

 3. DENSE_RANK()
 ================
It is almost very similiar to rank, and there is just one difference, it will not skip the value. Whereas rank 
skip the value for every duplicate value.


Select * from (Select e.*,
dense_rank() over(partition by dept_name order by salary desc) as Dense_rnk 
 from employee) x 
 where x.rnk < 4;

4. LEAD AND LAG
================
//Arequirement where you want to check if the salary of the current employee is higher, or lower than the 
//previous employee then we can use the lag() function.
---------------------------------------------------------------------------------------------------------
Select e.*,
lag(salary) over(partition by dept_name order by emp_id) as prev_emp_salary 
from employee e; 
// if no previous record found then it will return "null"
//It basically the records from the previous rows.


We can provide arguments as well

Select e.*,
lag(salary,2,0) over(partition by dept_name order by emp_id) as prev_emp_salary 
from employee e; 
//Here inside lag, 2 is the value (how many rows prior I want to check ), so for 2 it going to check 2 records
//previous to the current record. Last argument like here 0, this is the default value, if there is no record
//then it will assign 0 instead of null.

Now almost simiiliar to these LEAD,
Lead is basically the rows that are following the current record.

Select e.*,
lag(salary) over(partition by dept_name order by emp_id) as prev_emp_salary 
lead(salary) over(partition by dept_name order by emp_id) as next_emp_salary 
from employee e; 
//Lead will check for the next salary.

Lets we have  a requirement to (--fetch a query to display id the salary of an employee is higher, lower 
	then we need to display the Lower or Higher) as text.

	Select e.*,
lag(salary) over(partition by dept_name order by emp_id) as prev_emp_salary,
case when e.salary > lag(salary) over(partition by dept_name order by emp_id) then 'Higher than previous employee'
	 when e.salary < lag(salary) over(partition by dept_name order by emp_id) then 'Lower than previous employee'
	 when e.salary = lag(salary) over(partition by dept_name order by emp_id) then 'Same as previous employee'
	 end sal_range
from employee e; 
//It will output accrding the comparision.

==========================================================================================================
SQL - Structured Query Language

Oracle
Mysql
Postgresql
IBM DB2
SQLite
MariaDB
Teradata
Hive


With clause (CTE -> Common Table Expression) or (SubQuery Factoring)
====================================================================
with clause should comeup before the main query

---------------------------------------------
with alias (list of column names) as (query)
---------------------------------------------

//Fetch the employees who earn more than average salary of all employees

with average_salary (avg_sal) as 
        (select avg(salary) from employee)

Select * from employee e, average_salary av 
where e.salary > av.avg_sal;

here the first query will be performed is with clause query then main query will going to execute.
We can cast decimal to int by using 
      select cast(avg(salary) as int) from employee  



//Find stires who's sales where better than the average sales accross all stores
=================================================================================
We need to find 
1. The total sales per each store -- Total_Sales

2. Find the average sales with respect to  all the stores. -- Avg_Sales

3. Find the stores where Total_Sales > Avg_Sales of all the stores.


Select * from sales;






SubQueries
==========
Subquery is an sql query which is placed inside anathor subquery.

Different types of SubQueries
----------------------------
3 types of SubQueries

1. Scalar Subquery
2. Multiple row Subquery
3. Correlated Subquery


1. Scalar Subquery
-------------------
Scalar Subquery is a Subquery which will always return just one row and one column.


2. Multiple row Subquery
------------------------
Multiple Subquery is a Subquery which will always return more than one row.
--multiple row Subquery
--subquery which returns multiple column and multiple row
--subquery which returns one column and multiple rows.


Correlated SubQuery (Syncronized Query)
=======================================
* It is a subquery that uses values from outer query.
* Top to Down Approach (Outer Query to Inner Query executes)
* There is a outer query and inner query.

How it executes ?
------------------
In a query, Outer query 1st row will get compared with all the rows of inner query.


Find the nth salary from the sql
================================
        ______________________________________________________________________________
        |Select id, salary from Emp e1 where N-1 = (Select count(distinct salary)    |
        |from Emp e2 where e2.salary > e1.salary)                                    |
        |____________________________________________________________________________|





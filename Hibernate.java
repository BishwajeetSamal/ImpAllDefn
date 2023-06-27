												Hibernate
												=========
Hibernate is an ORM framework.

Why Hibernate ?
===============
* Hibernate eliminates all the boiler-plate (means extensive coding which is required for
JDBC connection to the Databases. So many times we need to write the same kind of coding frequently some time.)
So that we just focus on the logic part rather than writing repetitve code and for connection.
* It supports HQL which is more object oriented.
* It provides transaction management implicitly but in JDBC we have to manage the transaction manually.
* Hibernate throws JDBCException or HibernateException which are the unchecked exceptions, so
  we dont need to worry about handling using try and catch.
* Hibernate supports caching for bettern performance.


Important Interface used in Hibernate
=====================================
*SessionFactory (org.hibernate.SessionFactory) - Instance of this is used to retrieve Session objects for
the database operations. We need to initialize that once and can cache it to reuse it again and again.
Its like one SessionFactory object per database connection.
Like One for Mysql, one for oracle.

* Session (org.hibernate.Session)  - Its factory for transaction, it's used for connecting appication with
persistent store like hibernate framework /DB. It is used to get a physicall connection with the database.
It also provides methods for CRUD oprations.
* Transaction (org.hibernate.Tranaction) - This specifies single / atomic units of work.

                                                (OR)
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
SessionFactory: The SessionFactory interface is responsible for creating and managing Hibernate sessions. 
It is typically created during the application's initialization and serves as a factory for obtaining Session instances.

Session: The Session interface represents a single unit of work and provides methods for performing database operations. 
It acts as a gateway for interacting with the database, executing queries, managing transactions, and persisting or 
retrieving objects.

Transaction: The Transaction interface represents a database transaction and provides methods for controlling transaction 
boundaries, such as starting, committing, or rolling back a transaction. It allows you to group multiple database 
operations into a single atomic unit of work.

Query: The Query interface is used for executing queries against the database. It supports both HQL (Hibernate Query Language)
and native SQL queries. You can set query parameters, specify result ordering and pagination, and retrieve the query results.

Criteria: The Criteria interface provides a programmatic and type-safe way to create queries using a fluent API. 
It allows you to build queries dynamically by applying various criteria and conditions to filter and fetch objects 
from the database.

Configuration: The Configuration interface is used to configure and bootstrap Hibernate. It provides methods 
for setting up the database connection, specifying entity mappings, configuring caching options, and other 
Hibernate-specific settings. It is typically used to build a SessionFactory instance.

SessionFactoryBuilder: The SessionFactoryBuilder interface provides a way to build a SessionFactory from a 
Configuration object. It allows you to customize and fine-tune the configuration before building the 
SessionFactory instance.
---------------------------------------------------------------------------------------------------------------
SessionFactory is the parent and from this we can get the Session object.
Once we get the Session object then we can get the Transaction object.

code 
-----
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExample {
    public static void main(String[] args) {
        // Create a Configuration object and configure it
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Build the SessionFactory using the SessionFactoryBuilder
        SessionFactoryBuilder sessionFactoryBuilder = configuration.buildSessionFactoryBuilder();
        SessionFactory sessionFactory = sessionFactoryBuilder.build();

        // Open a session
        Session session = sessionFactory.openSession(); // now we can create a physical connection to the db

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        try {
            // Perform database operations
            // ...

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // Handle exceptions and rollback the transaction if necessary
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        // Close the SessionFactory
        sessionFactory.close();
    }
}


Commonly use hibernate annotations
-----------------------------------
*@Entity->use to mark any class as Entity.
*@Table->use to change the table details.
*@Id->use to mark column as id(primary key)
*@GeneratedValue->hibernate will automatically generate values for that using an internal sequence. Therefore,
we don't have to set manually.
*@GeneratedValue(strategy= GenerationValue.IDENTITY), need to provide the strategy for auto increment. 
*@Column ->Can be used to specify column mappings. For Example, to change the column name in the associated 
table in database.
*@Transient->This tells hibernate not to save the field.
*@Temporal->@Temporal over a date field tells hibernate the format in which the date needs to be saved.
*@Lob->@Lob tells hibernate that this is a large object, not a simple object.(BLOB, CLOB etc.)
@Access -> The @Access annotation in Hibernate is used to control the access type for the persistent properties of an entity. 
It allows you to specify whether Hibernate should access the properties directly (using fields) or through getter/setter methods.


Hibernate Configuration File
============================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/mydatabase</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">password</property>
        
        <!-- Hibernate dialect for the database -->
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        
        <!-- Mapping files -->
        <mapping class="com.example.User"/>
        
        <!-- Enable Hibernate's automatic session context management -->
        <property name="current_session_context_class">thread</property>
        
        <!-- Enable the second-level cache (optional) -->
        <property name="hibernate.cache.use_second_level_cache">true</property>
        <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
        
        <!-- Enable Hibernate's automatic SQL generation -->
        <property name="hibernate.hbm2ddl.auto">update</property>
    </session-factory>
</hibernate-configuration>


What is the hibernate.cfg.xml -> The hibernate.cfg.xml file is the configuration file used in Hibernate 
to provide essential settings and properties for the Hibernate framework. It contains information about 
the database connection, mapping files, caching, and other Hibernate-specific configurations.

If I want to use Oracle db instead of Mysql then I need to create anathor Session-Factory in Hibernate Configuration.

Here's an example of complete code showing how to configure Hibernate for Oracle and MySQL
 databases using separate configuration files:

"hibernate.cfg.xml"
====================
 <?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
    "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <!-- Oracle configuration -->
        <mapping resource="oracle.cfg.xml"/>
        
        <!-- MySQL configuration -->
        <mapping resource="mysql.cfg.xml"/>
        
        <!-- Other Hibernate configurations -->
    </session-factory>
</hibernate-configuration>

oracle.cfg.xml:
================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <!-- Oracle-specific configurations -->
    <property name="hibernate.dialect">org.hibernate.dialect.OracleDialect</property>
    <property name="hibernate.connection.driver_class">oracle.jdbc.driver.OracleDriver</property>
    <property name="hibernate.connection.url">jdbc:oracle:thin:@localhost:1521:xe</property>
    <property name="hibernate.connection.username">your_oracle_username</property>
    <property name="hibernate.connection.password">your_oracle_password</property>
    <!-- Entity mappings for Oracle database -->
    <mapping class="com.example.entity.OracleEntity"/>
</hibernate-mapping>


mysql.cfg.xml:
==============
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <!-- MySQL-specific configurations -->
    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/db_name</property>
    <property name="hibernate.connection.username">your_mysql_username</property>
    <property name="hibernate.connection.password">your_mysql_password</property>
    <!-- Entity mappings for MySQL database -->
    <mapping class="com.example.entity.MySQLEntity"/>
</hibernate-mapping>
In this example, the main hibernate.cfg.xml file includes the session-factory element, which references 
the separate configuration files oracle.cfg.xml and mysql.cfg.xml for Oracle and MySQL databases, respectively. 
Each of the database-specific configuration files contains the dialect, driver class, connection URL, 
credentials, and entity mappings specific to that database.

Make sure to replace the placeholders (your_oracle_username, your_oracle_password, your_mysql_username, 
	your_mysql_password, and db_name) with the actual values for your Oracle and MySQL databases.

You would also need to define the entity classes (OracleEntity and MySQLEntity) and their corresponding 
mappings in the respective configuration files.

By configuring Hibernate in this way, you can have separate configurations for each database and manage 
them independently.

To use the Hibernate configuration for Oracle or MySQL, you can create a SessionFactory by loading the 
appropriate configuration file.
Here's an example of how to use the Oracle configuration:

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OracleSessionFactoryProvider {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("oracle.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

And here's an example of how to use the MySQL configuration:

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySQLSessionFactoryProvider {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("mysql.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

In both cases, the getSessionFactory() method loads the corresponding configuration file 
(oracle.cfg.xml or mysql.cfg.xml) using the configure() method of the Configuration class. 
It then builds and returns a SessionFactory instance.

You can call the getSessionFactory() method whenever you need to obtain a SessionFactory for a 
specific database. Make sure to handle any exceptions that may occur during the configuration loading 
and session factory creation.

Once you have the SessionFactory, you can use it to create Session instances to perform database operations.
=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*s
(OR) you can use multiple databases simultaneously in Hibernate. 
----------------------------------------------------------------
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryProvider {
    private static SessionFactory oracleSessionFactory;
    private static SessionFactory mysqlSessionFactory;

    public static SessionFactory getOracleSessionFactory() {
        if (oracleSessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("oracle.cfg.xml");
                oracleSessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return oracleSessionFactory;
    }

    public static SessionFactory getMySQLSessionFactory() {
        if (mysqlSessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("mysql.cfg.xml");
                mysqlSessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mysqlSessionFactory;
    }
}
In this example, we have created two separate methods getOracleSessionFactory() and getMySQLSessionFactory() 
that return SessionFactory instances for Oracle and MySQL databases respectively.

You can then use these methods to obtain the desired SessionFactory based on the database you want to interact with. 
For example:

SessionFactory oracleSessionFactory = HibernateSessionFactoryProvider.getOracleSessionFactory();
SessionFactory mysqlSessionFactory = HibernateSessionFactoryProvider.getMySQLSessionFactory();

// Use the session factories to create sessions and perform database operations
Session oracleSession = oracleSessionFactory.openSession();
Session mysqlSession = mysqlSessionFactory.openSession();

// Perform database operations using the sessions
// ...

// Remember to close the sessions and session factories when done
oracleSession.close();
mysqlSession.close();
=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
By using separate SessionFactory instances, you can interact with multiple databases simultaneously 
in your Hibernate application.

What are hibernate Mapping file
===============================
This is second important anathor file in hibernate. Now we map table to objects.
Conventionally it is named as - (class_name.hbm.xml)

In Hibernate, a mapping file is used to define the mapping between Java objects (entities) and database tables. 
It specifies how the fields and relationships of an entity class are mapped to the corresponding columns and 
tables in the database.

Here's an example of a Hibernate mapping file:
<!-- Employee.hbm.xml -->
<hibernate-mapping>
    <class name="com.example.Employee" table="employees">
        <id name="id" type="long">
            <column name="id" />
            <generator class="native" />
        </id>
        <property name="firstName" type="string">
            <column name="first_name" length="50" />
        </property>
        <property name="lastName" type="string">
            <column name="last_name" length="50" />
        </property>
        <property name="salary" type="double">
            <column name="salary" />
        </property>
    </class>
</hibernate-mapping>


// Employee.java
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private double salary;

    // getters and setters

    // ...
}

In this example, the Employee class represents an employee entity with properties such as id, firstName, 
lastName, and salary. Hibernate will map these properties to the corresponding columns in the database table.

Note that the actual mapping between the Employee class and the database table is defined in the Hibernate 
mapping file (Employee.hbm.xml in the previous example). The mapping file specifies how each property of 
the Employee class should be mapped to the database columns.

You can add additional methods and behaviors to the Employee class as per your application requirements. 
The mapping file (Employee.hbm.xml) will define how the object-relational mapping is performed, allowing 
Hibernate to perform CRUD (Create, Read, Update, Delete) operations on the corresponding database table.

Steps to create sample App of Hibernate
---------------------------------------
1. Create the Persistent POJO Eg Employee -> 2. Create the Mapping file -> 3. Create the configuration file -> 
4. class for retrieving or storing the persistent POJO -> 5. Run the application to see results


Here's a directory structure for a sample Hibernate application:
-----------------------------------------------------------------
- src
  - main
    - java
      - com
        - example
          - model
            - Employee.java
          - dao
            - EmployeeDAO.java
          - util
            - HibernateUtil.java
    - resources
      - hibernate.cfg.xml
      - com
        - example
          - model
            - Employee.hbm.xml
  - test
    - java
      (test classes if applicable)
- pom.xml (Maven project configuration file)

Here's an example of the contents of the mapping file Employee.hbm.xml:
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-mapping PUBLIC
    "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
    "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
<hibernate-mapping>
    <class name="com.example.model.Employee" table="employees">
        <id name="id" column="id" type="int">
            <generator class="native" />
        </id>
        <property name="firstName" column="first_name" type="string" />
        <property name="lastName" column="last_name" type="string" />
        <property name="email" column="email" type="string" />
        <property name="salary" column="salary" type="double" />
    </class>
</hibernate-mapping>


In this directory structure:

The src/main/java directory contains the Java source code for the application.

The com.example.model package contains the persistent POJO classes, such as Employee.java.
The com.example.dao package contains the DAO (Data Access Object) classes, such as EmployeeDAO.java, 
responsible for interacting with the database.
The com.example.util package contains utility classes, such as HibernateUtil.java, for Hibernate 
configuration and session management.
The src/main/resources directory contains the configuration files for Hibernate.

The hibernate.cfg.xml file is the main Hibernate configuration file, specifying the database connection 
details, dialect, and other Hibernate properties.
The com.example.model package inside the resources directory contains the Hibernate mapping files 
(e.g., Employee.hbm.xml) that define the mapping between the Java classes and the database tables.
The src/test/java directory can contain any test classes if you're implementing unit tests for your application.

The pom.xml file is the Maven project configuration file, if you're using Maven as your build tool.


According to above structure, the code can be like this:-

HibernateUtil.java
-------------------
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create a Hibernate Configuration instance
            Configuration configuration = new Configuration();

            // Load the Hibernate configuration file
            configuration.configure("hibernate.cfg.xml");

            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Handle any exceptions
            System.err.println("Failed to initialize Hibernate SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close the SessionFactory when your application shuts down
        getSessionFactory().close();
    }
}

Employee.java:
--------------
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // Constructors, getters, setters, and other methods
}

EmployeeDAO.java:
------------------
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.Employee;
import com.example.util.HibernateUtil;

public class EmployeeDAO {

    public void save(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public Employee findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

      public void update(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

     public void delete(Employee employee) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Other CRUD operations and methods
}

EmployeeServiceImpl.java
-------------------------
package com.example.service;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl() {
        // Initialize the employeeDAO object
        this.employeeDAO = new EmployeeDAO();
    }

    @Override
    public void saveEmployee(Employee employee) {
        // Delegate the save operation to the employeeDAO
        employeeDAO.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        // Delegate the get operation to the employeeDAO
        return employeeDAO.getById(id);
    }

    // Implement other methods from the EmployeeService interface
}



Ques-> Difference between openSession and getCurrentSession ?
==============================================================
In Hibernate, openSession() and getCurrentSession() are two methods used to obtain a session object 
for interacting with the database. However, they differ in how they manage the lifecycle of the session.

openSession(): This method is used to create a new session every time it is invoked.
You are responsible for managing the opening and closing of the session yourself.

SessionFactory sessionFactory = // obtain the SessionFactory
Session session = sessionFactory.openSession();
// perform database operations using the session
session.close(); // explicitly close the session


getCurrentSession(): This method is used in a context where sessions are managed by Hibernate's 
built-in session context management. It returns the current session associated with the current 
transaction or creates a new session if one doesn't exist. 

SessionFactory sessionFactory = // obtain the SessionFactory
Session session = sessionFactory.getCurrentSession();
// perform database operations using the session
// no need to explicitly close the session

The choice between openSession() and getCurrentSession() depends on the specific 
requirements of your application and the environment you are working with. 

difference between Session get and load method
==============================================
In Hibernate, both the get() and load() methods are used to retrieve an object from the 
database based on its identifier. However, they have some differences in behavior:

session.get(): (Eager Loading is a design pattern in which data initialization occurs on the spot.)
--------------
Returns the object or null if the object with the given identifier is not found.
It immediately hits the database and fetches the object from the database.
If the object is already associated with the session, it returns the object from the 
session-level cache.
If the object is not found in the session-level cache, it issues a select query to the 
database to fetch the object.

Session session = sessionFactory.openSession();
Employee employee = session.get(Employee.class, 1L);
session.close();


session.load():(Lazy Loading is a design pattern that we use to defer initialization of an object as long as it's possible.)
---------------
Returns a "proxy" object that acts as a placeholder for the requested object.
It doesn't immediately hit the database. Instead, it creates a proxy object with the 
given identifier.
The actual object is loaded from the database only when you access its properties or 
call a method on it.
If the object is not found in the database, a ObjectNotFoundException is thrown when 
you access the object.

Session session = sessionFactory.openSession();
Employee employee = session.load(Employee.class, 1L);
System.out.println(employee.getName()); // Actual object is loaded here
session.close();


In summary, the main differences between get() and load() are:

get() returns the actual object or null, while load() returns a proxy object.
get() immediately hits the database, while load() defers the database query until the 
object is accessed.
get() is suitable when you need to check for the existence of an object or when you 
want to work with a detached object.
load() is useful when you expect the object to exist in the database and you want to lazily 
load it.


Ques-> Difference between Lazy Loading and Eager Loading ?
===========================================================
The first thing that we should discuss here is what lazy loading and eager loading are:

Eager Loading is a design pattern in which data initialization occurs on the spot.
Lazy Loading is a design pattern that we use to defer initialization of an object as long 
as it's possible.
Let's see how this works.

First, we'll look at the UserLazy class:
@Entity
@Table(name = "USER")
public class UserLazy implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long userId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<OrderDetail> orderDetail = new HashSet();

    // standard setters and getters
    // also override equals and hashcode

}

Next, we'll see the OrderDetail class:

@Entity
@Table (name = "USER_ORDER")
public class OrderDetail implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name="ORDER_ID")
    private Long orderId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private UserLazy user;

    // standard setters and getters
    // also override equals and hashcode

}

One User can have multiple OrderDetails. In eager loading strategy, if we load the 
User data, it will also load up all orders associated with it and will store it in a memory.

But when we enable lazy loading, if we pull up a UserLazy, OrderDetail data won't 
be initialized and loaded into a memory until we make an explicit call to it.

fetch = FetchType.LAZY
fetch = FetchType.EAGER

Hibernate caching Types
=======================
1. First Level Cache
2. Second Level Cache
3. Query Level Cache

Why Caching ?
-------------
Caching is a technique use to make our application faster and improves the performance.
If we have the data in our cache then we dont to hit the data.
So the basic idea of caching is to reduce the number of database queries.

By default first level cache is enabled and there is no way to disable it. But hibernate
provides methods through which we can delete selected objects from the cache or clear the
cache completely.

Any object cached in a session  will not be visible to other sessions  and when the 
session is closed, all the cached objects will be lost.

Now, here comes a concept called Second Level Cache
----------------------------------------------------
Hibernate Second Level Cache is disabled by default but we can enable it through
configuration.
Currently EHCache and Infinspan provides implementation for Hibernate Second Level cache
we can use them.

Configure Hibernate Second Level Cache using EHCache
-----------------------------------------------------
1. Add hibernate-ehcache dependency in your maven project.
	<dependecny>
		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-ehcache</artifactId>
	<dependecny>

2.Configure Hibernate to use Ehcache: Update your Hibernate configuration file 
(hibernate.cfg.xml) to enable the use of Ehcache as the second-level cache provider. 
Add the following properties:

<property name="hibernate.cache.use_second_level_cache">true</property>
<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
<property name="hibernate.cache.use_query_cache">true</property>

Configure Ehcache: Create an Ehcache configuration file (ehcache.xml) in your classpath 
and define the cache configurations. Here's an example configuration:
<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
    updateCheck="false" monitoring="autodetect"
    dynamicConfig="true">

    <diskStore path="java.io.tmpdir/ehcache" />
    //compulsory configuration in this ehcache configuration
    <defaultCache
        maxElementsInMemory="10000"
        eternal="false"
        timeToIdleSeconds="120"
        timeToLiveSeconds="120"
        overflowToDisk="true"
        diskPersistent="false"
        diskExpiryThreadIntervalSeconds="120" />
	//properties
    <cache
        name="com.example.Employee"
        maxElementsInMemory="500"
        eternal="false"
        timeToIdleSeconds="180"
        timeToLiveSeconds="300" />
        
    <!-- Define additional caches here -->

</ehcache>
Use Caching Annotations: In your entity classes, annotate the entities or collections 
that you want to cache with appropriate caching annotations, such as @Cacheable, @Cache, 
and @CacheConcurrencyStrategy.
With these configurations in place, Hibernate will utilize Ehcache as the second-level 
cache provider, and the specified entities or collections will be cached according 
to the defined cache settings in ehcache.xml.


Now show me the code for springboot 
------------------------------------
To configure Ehcache in a Spring Boot application, you can follow these steps:

Add Dependencies: Include the necessary dependencies in your project's pom.xml file.
<!-- Spring Boot Starter Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Ehcache -->
<dependency>
    <groupId>org.ehcache</groupId>
    <artifactId>ehcache</artifactId>
</dependency>

<!-- Hibernate Ehcache -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-ehcache</artifactId>
</dependency>


Configure Hibernate with Ehcache: Open the application.properties file and add the following 
Hibernate and Ehcache configuration properties:

# Hibernate Properties
spring.jpa.properties.hibernate.cache.use_second_level_cache=true
spring.jpa.properties.hibernate.cache.region.factory_class=org.hibernate.cache.ehcache.EhCacheRegionFactory
spring.jpa.properties.hibernate.cache.use_query_cache=true

# Ehcache Configuration
spring.cache.ehcache.config=classpath:ehcache.xml
Create Ehcache Configuration File: Create a file named ehcache.xml in the src/main/resources 
directory. You can customize the cache configurations based on your requirements. 
Here's an example:

<ehcache xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:noNamespaceSchemaLocation="http://ehcache.org/ehcache.xsd"
    updateCheck="false" monitoring="autodetect"
    dynamicConfig="true">

    <defaultCache
        maxEntriesLocalHeap="10000"
        eternal="false"
        timeToIdleSeconds="120"
        timeToLiveSeconds="120"
        overflowToDisk="true"
        diskPersistent="false"
        diskExpiryThreadIntervalSeconds="120" />

    <cache
        name="com.example.Employee"
        maxEntriesLocalHeap="500"
        eternal="false"
        timeToIdleSeconds="180"
        timeToLiveSeconds="300" />
        
    <!-- Define additional caches here -->

</ehcache>
Enable Caching in Spring Boot: In your Spring Boot application's 
main class, annotate it with @EnableCaching to enable caching support.

@SpringBootApplication
@EnableCaching
public class YourApplication {
    public static void main(String[] args) {
        SpringApplication.run(YourApplication.class, args);
    }
}

Use Caching Annotations: In your service or repository classes, annotate the methods 
that you want to cache with appropriate caching annotations, such as 
@Cacheable, @CacheEvict, and @CachePut.

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Cacheable("employees")
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    @CacheEvict(value = "employees", allEntries = true)
    public void clearEmployeeCache() {
        // Method to clear the employee cache
    }
    
    // Other methods...
}

With these configurations in place, Spring Boot will use Ehcache as the caching 
provider, and the specified methods will be cached according to the defined cache 
settings in ehcache.xml.

Note -> Query Level Cache always used conjunction with Second Level Cache, not 
with First Level Cache.

Ques-> How can we see Hibernate generated SQL on console ?
-----------------------------------------------------------
To generate the SQL command generated at the backend we need to add following
property:-

<property name ="show_sql">true</property> 

or in springboot
spring.jpa.show-sql = true


Entity Life cycle in hibernate with diagram
-------------------------------------------
             +----------------------------------+
             |                                  |
             |          Transient State         |
             |                                  |
             +----------------------------------+
                        |       |       |
                        |       |       |
                       save  persist  saveOrUpdate
                        |       |       |
                        v       v       v
             +----------------------------------+
             |                                  |
             |         Persistent State         |
             |                                  |
             +----------------------------------+
                        |       |       |
                        |       |       |
                      update  delete  evict
                        |       |       |
                        v       v       v
             +----------------------------------+
             |                                  |
             |         Detached State           |
             |                                  |
             +----------------------------------+
                        |       |       |
                        |       |       |
                      merge   lock  refresh
                        |       |       |
                        v       v       v
             +----------------------------------+
             |                                  |
             |          Removed State           |
             |                                  |
             +----------------------------------+

Transient State:
================
Entities are newly created using the new keyword.
They are not associated with any Hibernate session.
Changes made to entities in this state are not automatically synchronized with the database.

Persistent State:
=================
Entities enter the persistent state when they are associated with a Hibernate session using 
methods like save, persist, or update.
They are now managed by the Hibernate session and changes made to them will be tracked and 
synchronized with the database during the session's flush or commit.
Entities in this state can be retrieved, modified, and persisted.

Detached State:
===============
Entities become detached when the Hibernate session is closed or when they are explicitly 
detached using the evict or clear methods.
Detached entities are no longer actively managed by the Hibernate session.
Changes made to detached entities are not automatically synchronized with the database 
unless they are reattached to a session.

Removed State:
==============
Entities enter the removed state when they are marked for removal using the delete or 
remove methods.
The removal is not immediately reflected in the database but is queued for deletion.
Entities in this state will be deleted from the database during the session's flush or commit.


The entity life cycle states in Hibernate are managed internally by the Hibernate framework, so 
you don't need to write specific code to handle these states explicitly. Hibernate takes care 
of transitioning the entities between the different states based on the operations you perform.

**In a Spring Boot project with Spring Data JPA, Hibernate is used as the underlying JPA provider.
 The SessionFactory and Session objects are part of the Hibernate API, but you don't need to 
 explicitly work with them when using Spring Data JPA.


When you define a JPA repository interface and extend it with JpaRepository or one of its 
subinterfaces, such as CrudRepository or PagingAndSortingRepository, Spring Data JPA 
automatically generates the necessary implementation at runtime. 
This implementation includes the usage of Hibernate for interacting with the database.

Dependencies: As mentioned earlier, you have included the spring-boot-starter-data-jpa 
dependency, which internally includes the Hibernate ORM dependency.

Configuration: In your application.properties or application.yml file, you have set the 
spring.jpa.hibernate.ddl-auto property to a value like update or create, which is 
specific to Hibernate. This property configures the schema generation behavior of Hibernate.

Logging: Hibernate logs can be enabled to provide detailed information about the SQL 
statements executed and other Hibernate-specific operations. You can configure the 
logging level for Hibernate-related classes to see the log messages.


By leveraging Spring Data JPA, you can benefit from the power and features of Hibernate 
without explicitly dealing with the SessionFactory and Session objects. 
Spring Data JPA handles the session management and provides a more convenient and 
consistent API for working with the database.


 Starter jpa makes use of Hibernate in our springboot project right ? 
 We dont need to create the session and close it.
 -----------------------------------------------------------------------
Yes, that's correct. The spring-boot-starter-data-jpa dependency in your Spring Boot 
project includes Hibernate as the default JPA provider. 
You don't need to manually create a SessionFactory or manage the Session objects.

Spring Data JPA, combined with Hibernate as the underlying JPA provider, simplifies the 
database access and handles the session management for you. It abstracts away the low-level 
details of working with the SessionFactory and Session objects.

When you define a JPA repository interface and extend it with JpaRepository or its 
subinterfaces, Spring Data JPA automatically generates the implementation at runtime. 
This generated implementation uses Hibernate to perform the database operations. 
It manages the session and transaction handling behind the scenes.

You can focus on defining your repository interfaces and the corresponding methods to 
interact with the database. Spring Data JPA takes care of providing the necessary 
infrastructure, including Hibernate, to execute the queries and manage the entities.

So, you don't need to worry about creating and closing sessions when using Spring Data JPA 
with Hibernate in your Spring Boot project. It simplifies the development process and allows 
you to focus on writing business logic while leveraging the power of Hibernate for persistence 
operations.


+---------------------------------------------------------------+
|                         Spring Boot App                        |
+---------------------------------------------------------------+
| - Entry point for the application                              |
| - Configures and initializes the Spring context                |
| - Orchestrates the application flow                            |
| - Manages application-level concerns                           |
+---------------------------------------------------------------+
                                      |
                                      | REST API
                                      |
+---------------------------------------------------------------+
|                          Spring MVC Layer                      |
+---------------------------------------------------------------+
| - Handles incoming requests and routes them to appropriate     |
|   controllers                                                  |
| - Implements MVC (Model-View-Controller) architecture          |
| - Provides request handling, response generation, and          |
|   rendering of views                                           |
| - Supports request mapping, request validation, and            |
|   middleware functionality                                     |
+---------------------------------------------------------------+
                                      |
                                      | JPA Repository
                                      |
+---------------------------------------------------------------+
|                        JPA Layer (Entities)                    |
+---------------------------------------------------------------+
| - Contains entity classes that represent database tables       |
| - Defines entity relationships and attributes                  |
| - Maps entities to database tables using JPA annotations       |
| - Provides object-oriented representation of data              |
| - Supports CRUD (Create, Read, Update, Delete) operations      |
| - Implements business logic and validation                     |
+---------------------------------------------------------------+
                                      |
                                      | Hibernate SessionFactory
                                      |
+---------------------------------------------------------------+
|                     Hibernate ORM Framework                    |
+---------------------------------------------------------------+
| - Object-Relational Mapping (ORM) framework                    |
| - Manages persistence of entities                              |
| - Translates Java objects to database records and vice versa   |
| - Provides caching, lazy loading, and transaction management   |
| - Executes queries and updates against the database            |
+---------------------------------------------------------------+
                                      |
                                      | Transaction Management
                                      |
+---------------------------------------------------------------+
|                          Spring Transaction                    |
+---------------------------------------------------------------+
| - Manages transactions and provides declarative transaction    |
|   management                                                   |
| - Supports transaction demarcation, propagation, and           |
|   isolation                                                    |
| - Coordinates transactional behavior across multiple           |
|   resources                                                    |
| - Integrates with JPA, Hibernate, and other persistence        |
|   frameworks                                                   |
+---------------------------------------------------------------+
                                      |
                                      | JDBC Connection Pool
                                      |
+---------------------------------------------------------------+
|                 JDBC Connection Pooling Library                |
+---------------------------------------------------------------+
| - Manages and maintains a pool of database connections         |
| - Provides efficient reuse of connections                      |
| - Improves performance by eliminating connection overhead      |
| - Manages connection lifecycle and pooling                     |
+---------------------------------------------------------------+
                                      |
                                      | JDBC Connection
                                      |
+---------------------------------------------------------------+
|                         JDBC Driver                            |
+---------------------------------------------------------------+
| - Provides the interface for connecting to the database        |
| - Implements the JDBC API                                      |
| - Handles the communication between the application and        |
|   the database                                                 |
| - Executes SQL statements and retrieves results                |
| - Manages connection, transaction, and result sets             |
+---------------------------------------------------------------+
                                      |
                                      | Relational Database
                                      |
+---------------------------------------------------------------+
|               Relational Database Management System            |
+---------------------------------------------------------------+
| - Software that manages and interacts with the database        |
| - Provides storage and retrieval of structured data            |
| - Ensures data integrity, security, and scalability            |
| - Executes queries and performs database operations            |
| - Manages transactions and concurrency control                 |
+---------------------------------------------------------------+




+---------------------------------------------------------------+
|                         Spring Boot App                        |
+---------------------------------------------------------------+
| - Entry point for the application                              |
| - Configures and initializes the Spring context                |
| - Orchestrates the application flow                            |
| - Manages application-level concerns                           |
+---------------------------------------------------------------+
                                      |
                                      | REST API
                                      |
+---------------------------------------------------------------+
|                          Spring MVC Layer                      |
+---------------------------------------------------------------+
| - Handles incoming requests and routes them to appropriate     |
|   controllers                                                  |
| - Implements MVC (Model-View-Controller) architecture          |
| - Provides request handling, response generation, and          |
|   rendering of views                                           |
| - Supports request mapping, request validation, and            |
|   middleware functionality                                     |
+---------------------------------------------------------------+
                                      |
                                      | JPA Repository
                                      |
+---------------------------------------------------------------+
|                        JPA Layer (Entities)                    |
+---------------------------------------------------------------+
| - Contains entity classes that represent database tables       |
| - Defines entity relationships and attributes                  |
| - Maps entities to database tables using JPA annotations       |
| - Provides object-oriented representation of data              |
| - Supports CRUD (Create, Read, Update, Delete) operations      |
| - Implements business logic and validation                     |
+---------------------------------------------------------------+
                                      |
                                      | Hibernate SessionFactory
                                      |
+---------------------------------------------------------------+
|                     Hibernate ORM Framework                    |
+---------------------------------------------------------------+
| - Object-Relational Mapping (ORM) framework                    |
| - Manages persistence of entities                              |
| - Translates Java objects to database records and vice versa   |
| - Provides caching, lazy loading, and transaction management   |
| - Executes queries and updates against the database            |
+---------------------------------------------------------------+
                                      |
                                      | JDBC Connection Pool
                                      |
+---------------------------------------------------------------+
|                 JDBC Connection Pooling Library                 |
+---------------------------------------------------------------+
| - Manages and maintains a pool of database connections          |
| - Provides efficient reuse of connections                       |
| - Improves performance by eliminating connection overhead       |
| - Manages connection lifecycle and pooling                      |
+---------------------------------------------------------------+
                                      |
                                      | JDBC Connection
                                      |
+---------------------------------------------------------------+
|                         JDBC Driver                            |
+---------------------------------------------------------------+
| - Provides the interface for connecting to the database        |
| - Implements the JDBC API                                      |
| - Handles the communication between the application and        |
|   the database                                                 |
| - Executes SQL statements and retrieves results                |
| - Manages connection, transaction, and result sets             |
+---------------------------------------------------------------+
                                      |
                                      | Relational Database
                                      |
+---------------------------------------------------------------+
|               Relational Database Management System            |
+---------------------------------------------------------------+
| - Software that manages and interacts with the database        |
| - Provides storage and retrieval of structured data            |
| - Ensures data integrity, security, and scalability            |
| - Executes queries and performs database operations            |
| - Manages transactions and concurrency control                 |
+---------------------------------------------------------------+


Hibernate connection pooling
============================
In a Spring Boot project, you can configure connection pooling for Hibernate by following these steps:
Add Dependencies: Include the necessary dependencies in your projects build configuration 
file, such as pom.xml for Maven or build.gradle for Gradle. You will need the appropriate 
connection pool library and the Hibernate dependencies. For example, if you're using 
HikariCP as the connection pool provider, add the following dependencies to your pom.xml file:

<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
</dependency>
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
</dependency>


Configure Application Properties: Open your application.properties or application.yml file and 
provide the necessary database connection details. For example:

spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=root
spring.datasource.password=secret
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
//Connection pool settings
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.maximum-pool-size=10


Enable Auto-configuration: By default, Spring Boot enables auto-configuration for 
database-related beans, including the connection pool. Ensure that you have the 
@SpringBootApplication annotation on your main class or a configuration class. For example:

@SpringBootApplication
public class MyAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
    }
}
Additional Configuration (optional): If you want to customize the connection pool 
settings, you can create a configuration class with the @Configuration annotation. 
Use the @Bean annotation to define a DataSource bean and configure the connection pool 
properties. For example, using HikariCP:

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String dataSourceUsername;

    @Value("${spring.datasource.password}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dataSourceUrl);
        config.setUsername(dataSourceUsername);
        config.setPassword(dataSourcePassword);
        // Set other connection pool properties

        return new HikariDataSource(config);
    }
}
That's it! Spring Boot will automatically configure the connection pooling for 
Hibernate based on the provided properties and dependencies

Can we write HQL or JPQL in springboot
=======================================
Yes, you can write HQL (Hibernate Query Language) or 
JPQL (Java Persistence Query Language) queries in Spring Boot 
applications that use Hibernate as the ORM (Object-Relational Mapping) framework.

To write HQL or JPQL queries in Spring Boot, you need to follow these steps:
1.Ensure that you have configured Hibernate as the JPA provider in your Spring Boot project. 
This typically involves adding the necessary dependencies and configuring the database 
connection details in the application.properties or application.yml file.

2.Define your entity classes that represent the database tables or views. 
Annotate these classes with JPA annotations such as @Entity, @Table, and @Column to map them 
to the corresponding database schema.

3.Use the EntityManager or JpaRepository provided by Spring Data JPA to execute HQL or 
JPQL queries. Here's an example:
@Repository
public class UserRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findUsersWithName(String name) {
        String queryString = "SELECT u FROM User u WHERE u.name = :name";
        TypedQuery<User> query = entityManager.createQuery(queryString, User.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}

In the above example, we define a UserRepository class that uses the EntityManager 
to execute a JPQL query to find users with a specific name.

You can also use the @Query annotation provided by Spring Data JPA to define HQL or 
JPQL queries directly in your repository interfaces. Here's an example:

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersByAgeGreaterThan(@Param("age") int age);
}
In this case, the findUsersByAgeGreaterThan method is annotated with @Query and provides the HQL/JPQL query directly.

By using HQL or JPQL, you can perform advanced querying operations on your entities, including 
filtering, sorting, joining, and aggregating data from your database.



The findById() method is not a JPQL or HQL query. 
It is a method provided by the Spring Data JPA repository interface. 
The findById() method takes a primary key as input and returns the entity object 
associated with that primary key.
It is a convenient method provided by JPA repositories to perform a simple 
lookup based on the primary key value.

Under the hood, the JPA provider (e.g., Hibernate) translates the findById() method 
into an appropriate SQL query based on the entity class and the primary key value provided. 
The generated SQL query is specific to the underlying database and is not directly related to 
JPQL or HQL.

JPQL and HQL are used for more complex queries that involve filtering, joining, and projecting 
data from multiple entities. They are typically written as string-based queries and allow for 
more expressive and flexible querying capabilities.

In summary, findById() is a method provided by JPA and does not fall strictly under JPQL or HQL. 
It is a simplified mechanism for retrieving entities by their primary key, without the need to 
write explicit query statements.

 here is how you would write the findById() method in JPQL and HQL:
 JPQL
 ====
 SELECT e
FROM Entity e
WHERE e.id = :id


HQL
===
SELECT e
FROM Entity e
WHERE e.id = {id}


Here are examples of how you can write HQL, JPQL, and native queries for the 
findByFirstNameAndAge() scenario:
HQL Query:
-----------
String hqlQuery = "FROM EntityName e WHERE e.firstName = :firstName AND e.age = :age";
List<EntityName> result = entityManager.createQuery(hqlQuery, EntityName.class)
    .setParameter("firstName", firstName)
    .setParameter("age", age)
    .getResultList();


JPQL Query (similar to HQL):
----------------------------
    String jpqlQuery = "SELECT e FROM EntityName e WHERE e.firstName = :firstName AND e.age = :age";
List<EntityName> result = entityManager.createQuery(jpqlQuery, EntityName.class)
    .setParameter("firstName", firstName)
    .setParameter("age", age)
    .getResultList();


Native SQL Query:
------------------
String nativeQuery = "SELECT * FROM table_name WHERE first_name = :firstName AND age = :age";
List<Object[]> result = entityManager.createNativeQuery(nativeQuery)
    .setParameter("firstName", firstName)
    .setParameter("age", age)
    .getResultList();


Spring Data JPA repository interface
--------------------------------------

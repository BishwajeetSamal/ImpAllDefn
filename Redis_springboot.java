To use Redis in springboot, we need to use the dependency.
 (spring-web, lombok, spring data redis)
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		

Here we will work with Jedis client.

<dependency>
			<groupId>redis.clients</groupId>
			<artifactId>jedis</artifactId>
			<version>3.3.0</version>
		</dependency>


-------------------------------------------------------------
We need to add, server.port = port_no

Need to create the packages like (Model, Repository, Service, Controller, Config)



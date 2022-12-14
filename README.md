#  Filter_app
___
## :bulb: ***Project description***

    Simple version of Web-application. Allow get data from database by regex.

## :scroll: ***Project structure***

    The project has an N-Tier Architecture.

+ *Dao*
+ *Service*
+ *Controller*

## :books: ***Technologies***

+ *Java 11*
+ *MySql*
+ *Maven*
+ *Stream API*
+ *Hibernate*
+ *Spring WEB*
+ *Spring Boot*
+ *Spring Boot Jpa*
+ *Spring Boot testing*
+ *Lombok*
+ *REST*
+ *SOLID principles*

## :desktop_computer: ***Quickstart***

1. Fork this repository
2. Copy link of project
3. Create new project from Version Control
4. Set the necessary parameters in application.properties
```java
    spring.datasource.url=YOUR_DATABASE_URL
    spring.datasource.driverClassName=YOUR_DRIVER
    spring.datasource.username=YOUR_LOGIN
    spring.datasource.password=YOUR_PASSWORD
```

5. Run project
6. Try to use your filter. Example request :

https://localhost:8080//shop/product?nameFilter=YOUR_REGEX

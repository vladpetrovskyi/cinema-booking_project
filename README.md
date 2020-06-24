# Ticket booking service
![Header Image](src/main/resources/picture_main.jpg)
# Table of Contents
[Project purpose](#purpose)<br>
[Available functions](#available_functions)<br>
[Project structure](#structure)<br>
[For developer](#developer-start)<br>
[Authors](#authors)
# <a name="purpose"></a>Project purpose

This is a template for creating a fully working movie ticket booking service with a basic interface.

# <a name="avvailable_functions"></a>Available Functions
For **all** users:
 
* view all available cinema halls movies, movie sessions, orders;
* get user by email;
* registration;
* log in;
* log out.

<hr>

For users with a **USER role only**: 
* add movie sessions to user's shopping cart;
* view shopping cart by user's ID;
* complete order.

<hr>

For users with an **ADMIN role only**:
* add movie, movie session, cinema hall.

# <a name="structure"></a>Project Structure
* Java 11
* Apache Maven 4.0.0
* Hibernate 5.4.15
* Hibernate Validator 6.1.5
* Spring Framework, WebMVC 5.2.6
* Spring Security 5.3.3
* MySQL 8.0.20
* log4j2 2.13
* Servlet API 4.0.1
* Jackson Databind 2.11
* Apache Maven Checkstyle Plugin 3.1.1
* Lombok 1.18.12


# <a name="developer-start"></a>For developer
To run this project you need to have installed:

* Java 11+
* Tomcat
* MySQL (Optional)

<hr>

This project is **RESTful and MVC-based** and thus has:

* DAO layer; 
* Service layer;
* Controllers;
* DTOs.

<hr>

_Launch guide:_

1. Open the project in your IDE.
2. Add it as maven project.
3. Configure Tomcat:
    * add an artifact;
    * add SDK 11.0.3.
4. Add SDK 11.0.3 in project structure.
5. Change a path at **/cinema-booking-project/src/main/resources/log4j2.xml** on line 7. It has to reach your logFile.
6. Run the project.
7. After you launch this project: 
    * By default, there is one user with the USER role (email = "user@cinema.net", password = "user1") 
and one with an ADMIN role (login = "admin@cinema.net", password = "admin"). You can change these at **/cinema-booking-project/src/main/java/com/cinema/controllers/InjectDataController.java**

<hr>

To work with **MySQL** you need to*:

At /cinema-booking-project/src/main/resources/db.properties use URL, username and password for your DB to create a Connection.

*_This project uses MySQL by default_


# <a name="authors"></a>Authors
[Vlad Petrovskyi](https://github.com/vladpetrovskyi)
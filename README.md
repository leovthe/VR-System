Vehicle Requisition System

A full-stack web-based Vehicle Requisition System built using Java Spring Boot and MySQL.
The system automates vehicle booking, approval workflows, and role-based access control within an organization.

Features
Role-based access control (Admin, HR, Driver, Department Head, Employee)
Vehicle requisition submission and approval workflow
Secure authentication and login system
Email notifications for requests (if enabled in configuration)
Anomaly detection for invalid or suspicious requests
Admin dashboard for managing users and vehicles
MySQL database integration
MVC architecture using Spring Boot
Tech Stack
Java (Spring Boot)
Spring Security
Spring Data JPA
Hibernate
MySQL
HTML, CSS, JavaScript
Project Structure
Controller Layer – Handles HTTP requests (Admin, Employee, HR, Driver)
Service Layer – Business logic implementation
Repository Layer – Database access using JPA
Entity Layer – Database models
Templates – Frontend views (HTML pages)

How to Run the Project
1. Clone the repository
git clone https://github.com/leovthe/VR-System.git
2. Create MySQL database
CREATE DATABASE vr_system;
3. Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/vr_system
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
4. Run the project
mvn spring-boot:run
Important Note

MySQL must be installed and running locally for the application to work.
This project is a development version and can be extended to cloud deployment in the future.

Author

Bevan Paweni

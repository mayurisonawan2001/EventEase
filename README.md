EventEase
Overview
EventEase is a backend application built with Java and Spring Boot that manages event listings, ticket bookings, and user registrations. It provides RESTful APIs for seamless interaction between users and the system, including generating and validating unique booking codes for secure check-ins.

Technologies Used
Java 17+
Spring Boot
Spring Data JPA (Hibernate)
MySQL
REST API
Maven
Postman (for API testing)

Features
Manage event creation and listings
Allow users to book tickets for events
Generate unique booking codes for each ticket
Validate booking codes for secure check-ins
Designed with scalability and maintainability in mind

Project Setup
Prerequisites
Java 17 or above
MySQL database server
Maven
Postman (optional, for API testing)

Installation Steps
Clone the repository

git clone https://github.com/yourusername/eventease.git
cd eventease
Create the MySQL database

CREATE DATABASE eventease_db;
Configure database credentials
Update src/main/resources/application.properties with your MySQL username and password:

properties
spring.datasource.username=your_mysql_username  
spring.datasource.password=your_mysql_password
Build the project

mvn clean install
Run the application

mvn spring-boot:run
The application will start on http://localhost:8080

API Endpoints
Endpoint	Method	Description	Request Body / Params
/api/events	GET	List all events	None
/api/events	POST	Create a new event	JSON body with event details
/api/bookings/book	POST	Book a ticket for an event	Query params: userId, eventId
/api/bookings/validate	GET	Validate a booking code	Query param: code (booking code)

Sample JSON for Creating an Event
{
  "title": "Tech Conference 2025",
  "location": "New York",
  "dateTime": "2025-06-15T10:00:00",
  "totalTickets": 100
}
Testing the APIs
Use Postman or any other API client to test the above endpoints. Make sure your application is running on localhost:8080.

Contributing
Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

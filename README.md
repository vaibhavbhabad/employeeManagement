# Employee Management System

This is a Java Spring Boot project that implements a RESTful API for performing CRUD (Create, Read, Update, Delete) operations on an employee database using MySQL. It provides a backend service for managing employee records and exposes endpoints for interacting with the database.

## Technologies Used

- **Java**: The core programming language used in the Spring Boot application.

- **Spring Boot**: A Java-based framework used to create the RESTful API and manage the application.

- **MySQL**: The relational database management system used to store and retrieve employee data.

- **Postman**: A popular API client used for testing and documenting the API endpoints.

## Features

- **Create Employee**: Create a new employee record with details such as name, email, and department.

- **Read Employee**: Retrieve employee information based on the employee ID or other search criteria.

- **Update Employee**: Update employee details, including name, email, and department.

- **Delete Employee**: Delete an employee record from the database.

## Exception Handling

This project has robust exception handling in place to ensure a smooth user experience. Exceptions like "Data Not Found" and "ID Not Found" have been effectively handled, and appropriate error responses are provided to the user.

## Response Structure

To make responses more convenient for users, the API utilizes a function called `ResponseStructure`. This function structures the responses for all API endpoints, ensuring consistent and user-friendly output.

## Getting Started

### Prerequisites

To set up and run this project, you'll need the following:

- Java Development Kit (JDK)
- Spring Boot
- MySQL
- Postman

### Installation

1. Clone this repository to your local machine.

2. Set up the MySQL database and configure the connection details in the application properties.

3. Build and run the Spring Boot application.

4. Use Postman or any other API client to test the CRUD operations.

## API Endpoints

- **Create Employee**: `POST /api/employees`
- **Read Employee by ID**: `GET /api/employee/{id}`
- **Read Employee by Email**: `GET /api/employee/{id}`
- **Read Employee by Phone**: `GET /api/employee/{id}`
- **Read Employee by Salary**: `GET /api/employees/{id}`
- **Read All Employee**: `GET /api/employees`
- **Update Employee by ID**: `PUT /api/employee/{id}`
- **Delete Employee by ID**: `DELETE /api/employee/{id}`

For detailed API documentation, refer to the Postman collection provided in this repository.

## Contributions

Contributions to this project are welcome. Feel free to open issues or create pull requests to improve the functionality or add new features.
---

**Author:** Vaibhav Bhabad

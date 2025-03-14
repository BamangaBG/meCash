# meCash Wallet API

## Overview
The meCash API allows users to perform various operations such as creating an account, logging in, depositing and withdrawing money, transferring funds between users, viewing account balance, and checking transaction history. This application is built using Java and Spring Boot with a focus on scalability and security.

---

## Features
- User Registration and Login
- Deposit Money
- Withdraw Money
- Transfer Funds Between Users
- View Account Balance
- View Transaction History
- Secure API with JWT Authentication

---

## Technology Stack
- **Programming Language**: Java
- **Framework**: Spring Boot
- **ORM**: JPA/Hibernate
- **Database**: MySQL
- **Testing**: JUnit, Postman
- **Version Control**: Git

---

## Prerequisites
Ensure the following tools are installed on your system:
- Java (version 11 or higher)
- Maven (version 3.6 or higher)
- MySQL
- An IDE (e.g., IntelliJ IDEA, or VS Code)

---

## Getting Started

### Clone the Repository
```bash
git clone <https://github.com/BamangaBG/meCash>
cd meCash
```

### Configure the Database
1. Install and start MySQL.
2. Create a database named `meCash`:
   ```sql
   CREATE DATABASE meCash;
   ```
3. Update the database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/multicurrency_wallet
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

---

## Build and Run the Application

### Build the Application
Use Maven to build the project:
```bash
mvn clean install
```

### Run the Application
Start the application using:
```bash
mvn spring-boot:run
```
By default, the application runs on `http://localhost:8080`.

---

## API Endpoints
| Endpoint                        | Method | Description                    |
|---------------------------------|--------|--------------------------------|
| `/api/users`                    | POST   | Register a new user            |
| `/api/auth/login`               | POST   | Log in and retrieve a JWT      |
| `/api/accounts`                 | POST   | Create a new currency account  |
| `/api/accounts/{id}/deposit`    | POST   | Deposit money into an account  |
| `/api/accounts/{id}/withdraw`   | POST   | Withdraw money from an account |
| `/api/transactions/transfer`    | POST   | Transfer money to another user |
| `/api/accounts/{id}/balance`    | GET    | View account balance           |
| `/api/accounts/{id}/transactions`| GET   | Display transaction history    |

---

## Testing the Application

### Unit and Integration Tests
Run all tests using Maven:
```bash
mvn test
```

### API Testing
1. Import the API endpoints into a tool like [Postman](https://www.postman.com/) or [JUnit](https://junit.org/junit5/).
2. Test each endpoint:
    - Start with `/api/auth/login` to retrieve a JWT.
    - Use the JWT in the `Authorization` header for protected endpoints.

Example `Authorization` header:
```plaintext
Authorization: Bearer <your-jwt-token>
```

---

## Deployment

### Package the Application
Build a JAR file using:
```bash
mvn package
```

### Run the JAR File
Execute the JAR file:
```bash
java -jar target/meCash-api-1.0.0.jar
```

---

## Notes
- Ensure you use environment variables or a secrets manager for storing sensitive information like database credentials and JWT secret keys.

---

## Contributing
Feel free to fork this repository and submit pull requests for any enhancements or bug fixes.

---

## License
This project is licensed under the MIT License.
```

# Secuirty_Microservices

## 🎯 What This Project Does

**Secure microservices architecture with authentication service and protected loan management system.**

### Core Functionality:
- 🔐 **Authentication Service**: User login and validation
- 💰 **Loan Management**: Secure loan request and approval system
- 🔒 **Authorization**: Token-based access control
- 📨 **Message Queue**: Event-driven communication between services
- 🛡️ **Security Layer**: Protected endpoints with user verification

## 🛠️ Technology Stack

- **Spring Boot**: Microservice framework
- **Spring Security**: Authentication and authorization
- **JPA/Hibernate**: Database persistence
- **RabbitMQ**: Message queue for inter-service communication
- **RestTemplate**: Service-to-service communication
- **H2/MySQL**: Database storage

## 📚 Learning Objectives

### Microservices Security
- **Authentication**: Centralized user authentication service
- **Authorization**: Token-based access control across services
- **Service-to-Service Security**: Secure inter-service communication
- **Security Patterns**: Authentication gateway and protected resources

### Event-Driven Architecture
- **Message Queues**: Asynchronous communication patterns
- **Event Handling**: User registration events and notifications
- **Decoupled Services**: Loose coupling through messaging

---

## 📂 Services

<details>
<summary>🔐 Secuirty</summary>

**Authentication and user management service**

- **What it does**: Handles user registration, login validation, and sends user events via message queue
- **Code implementation**: LoginController with user validation and registration
- **API endpoints**: GET /login (validate user with Authorization header), POST /login (register new user)
- **Security**: Uses username as Authorization header for validation
- **Messaging**: Sends UserDTO events to message queue on user registration

</details>

<details>
<summary>💰 Loan</summary>

**Secure loan management system with user verification**

- **What it does**: Manages loan requests and approvals with mandatory user authentication
- **Code implementation**: Protected controllers with VerfiedUser authentication check
- **Security layer**: Every endpoint calls VerfiedUser.checkValideUser() before processing
- **API endpoints**: 
  - LoanRequest: GET, POST, DELETE /loanRequest (all require Authorization header)
  - LoanApproved: GET, POST, DELETE /loanApproved (all require Authorization header)
- **Inter-service call**: Uses RestTemplate to validate users against Security service
- **Message handling**: Listens to user registration events from Security service

</details>
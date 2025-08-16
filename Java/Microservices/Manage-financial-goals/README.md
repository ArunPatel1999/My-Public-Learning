# Manage-financial-goals

## 🎯 What This Project Does

**Financial goal management system with microservices architecture for tracking savings and achieving financial targets.**

### Core Functionality:
- 💰 **Goal Management**: Create and track financial goals
- 🏦 **Micro Savings**: Record small savings towards goals
- 👥 **User Management**: Handle user accounts and profiles
- 🌐 **API Gateway**: Single entry point for all services
- 🔍 **Service Discovery**: Eureka-based service registration

## 🛠️ Technology Stack

- **Spring Boot**: Microservice framework
- **Spring Cloud**: Microservices ecosystem
- **JPA/Hibernate**: Database persistence
- **Eureka**: Service discovery
- **API Gateway**: Request routing
- **MySQL/H2**: Database storage

## 📚 Learning Objectives

### Financial Domain Modeling
- **Goal Tracking**: Financial goal lifecycle management
- **Savings Accumulation**: Micro-saving patterns and aggregation
- **User Financial Data**: Personal finance data modeling

### Microservices Architecture
- **Domain-Driven Design**: Service boundaries based on business domains
- **Data Consistency**: Managing data across multiple services
- **Service Communication**: Inter-service API calls and data sharing

---

## 📂 Services

<details>
<summary>💰 Goals</summary>

**Financial goal management with savings tracking**

- **What it does**: Manages financial goals, tracks progress, handles savings additions
- **Code implementation**: GoalsController with CRUD operations, savings accumulation logic
- **API endpoints**: GET /api/goals/{id}, GET /api/goals/getByUserId/{userId}, POST /api/goals, PUT /api/goals/savingAdd/goalId/{id}/amount/{amount}/text/{text}
- **Database**: Goals entity with userId, goalTitle, amount, totalMicroSaving, goalCompleted status

</details>

<details>
<summary>🏦 MicroSaving</summary>

**Individual savings transaction management**

- **What it does**: Records and manages individual saving transactions linked to goals
- **Code implementation**: MicroSavingController with savings CRUD operations
- **API endpoints**: GET /api/saving/{id}, GET /api/saving/getByGoalId/{goalId}, POST /api/saving
- **Database**: MicroSaving entity tracking individual saving amounts per goal

</details>

<details>
<summary>👥 UserService</summary>

**User account and profile management**

- **What it does**: Manages user accounts, authentication, and profile information
- **Code implementation**: UserController with user CRUD operations, phone number lookup
- **API endpoints**: GET /api/user, GET /api/user/{id}, GET /api/user/getByNumber/{number}, POST /api/user, DELETE /api/user/{id}
- **Database**: User entity with personal information and contact details

</details>

<details>
<summary>🌐 Api_Getwaya</summary>

**API Gateway for request routing and load balancing**

- **What it does**: Routes requests to appropriate microservices, handles cross-cutting concerns
- **Code implementation**: Spring Cloud Gateway configuration
- **Features**: Request routing, load balancing, service discovery integration

</details>

<details>
<summary>🔍 EurekaServer</summary>

**Service discovery and registration server**

- **What it does**: Central registry for all microservices to register and discover each other
- **Code implementation**: Netflix Eureka Server setup
- **Features**: Service health monitoring, dynamic service discovery, load balancing

</details>
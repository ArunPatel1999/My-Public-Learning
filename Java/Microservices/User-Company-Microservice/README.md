# User-Company-Microservice

## 🎯 What This Project Does

**User and company management system with MongoDB integration and auto-incrementing primary key generation.**

### Core Functionality:
- 👥 **User Management**: CRUD operations for user data
- 🏢 **Company Management**: Company operations with employee relationships
- 🔑 **Primary Key Service**: Auto-incrementing ID generation for MongoDB
- 🌐 **API Gateway**: Request routing and load balancing
- 🔍 **Service Discovery**: Eureka-based service registration

## 🛠️ Technology Stack

- **Spring Boot**: Microservice framework
- **MongoDB**: NoSQL document database
- **Spring Data MongoDB**: Database integration
- **Eureka**: Service discovery
- **API Gateway**: Request routing
- **Lombok**: Code generation

## 📚 Learning Objectives

### NoSQL Database Design
- **Document Storage**: MongoDB document modeling
- **Database References**: @DBRef relationships between collections
- **Auto-increment IDs**: Custom primary key generation for MongoDB
- **Collection Management**: Multiple collections in microservices

### Microservices Data Patterns
- **Database per Service**: Each service owns its data
- **Shared Primary Key Service**: Centralized ID generation
- **Data Relationships**: Cross-service data references

---

## 📂 Services

<details>
<summary>👥 UserReletedData</summary>

**User management service with MongoDB storage**

- **What it does**: Manages user profiles and personal information
- **Code implementation**: UserController with full CRUD operations
- **API endpoints**: GET /api/user, GET /api/user/{id}, POST /api/user, PUT /api/user/{id}, DELETE /api/user/{id}
- **Database**: MongoDB User document with id, name, email, number fields
- **Features**: Complete user lifecycle management

</details>

<details>
<summary>🏢 Company</summary>

**Company management with employee relationships**

- **What it does**: Manages companies and their employee associations
- **Code implementation**: CompanyController with company-employee relationship management
- **API endpoints**: 
  - Basic CRUD: GET, POST, PUT, DELETE /api/company
  - Employee management: PUT /api/company/addUser/{id}/{userId}, DELETE /api/company/{id}/{userId}
- **Database**: MongoDB Company document with @DBRef to User collection
- **Features**: Add/remove employees, company profile management

</details>

<details>
<summary>🔑 PrimerKeyTable</summary>

**Auto-incrementing primary key generation service**

- **What it does**: Provides sequential ID generation for MongoDB collections
- **Code implementation**: PrimeryController with table-based ID generation
- **API endpoint**: GET /api/primery/{tableName} - returns next available ID
- **Database**: MongoDB Primery document tracking next ID per table/collection
- **Logic**: Increments and returns sequential IDs, creates new counter if table doesn't exist

</details>

<details>
<summary>🌐 Api_Getwaya</summary>

**API Gateway for request routing**

- **What it does**: Routes requests to appropriate microservices
- **Code implementation**: Spring Cloud Gateway configuration
- **Features**: Load balancing, service discovery integration, request routing

</details>

<details>
<summary>🔍 Eureka_Server</summary>

**Service discovery and registration server**

- **What it does**: Central registry for all microservices
- **Code implementation**: Netflix Eureka Server setup
- **Features**: Service health monitoring, dynamic service discovery, load balancing

</details>
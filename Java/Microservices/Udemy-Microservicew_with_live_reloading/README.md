# Udemy-Microservicew_with_live_reloading

## 🎯 What This Project Does

**Advanced microservices architecture with live configuration reloading, security, and fault tolerance patterns.**

### Core Functionality:
- 👥 **User Management**: Secure user registration and profile management
- 📸 **Album Service**: Photo album management with user associations
- 🔐 **JWT Security**: Token-based authentication and authorization
- 🔄 **Live Configuration**: Real-time configuration updates without restart
- 🛡️ **Circuit Breaker**: Fault tolerance with Feign client fallbacks
- 🔒 **Encrypted Properties**: Secure configuration with encryption

## 🛠️ Technology Stack

- **Spring Boot**: Microservice framework
- **Spring Cloud Config**: Centralized configuration with live reload
- **Spring Security**: JWT authentication and authorization
- **Feign Client**: Declarative REST client with circuit breaker
- **Zuul Gateway**: API gateway and routing
- **Eureka**: Service discovery
- **Spring Cloud Bus**: Configuration change propagation
- **Encryption**: Configuration encryption/decryption

## 🌟 Advanced Features

### 🔄 Live Configuration Reloading
- **Real-time Updates**: Configuration changes without service restart
- **Centralized Management**: All configs managed from ConfigrationServer
- **Environment-specific**: Different configs per environment
- **Encrypted Values**: Sensitive data encrypted with {cipher} prefix

### 🛡️ Advanced Security
- **JWT Authentication**: Stateless token-based security
- **Custom Auth Filter**: AuthencationFilter for request processing
- **Encrypted Secrets**: JWT secrets and passwords encrypted in config
- **Service-to-Service Security**: Secure inter-service communication

### 🔧 Fault Tolerance
- **Feign Circuit Breaker**: Automatic fallback when services are down
- **Fallback Factory**: Custom error handling and logging
- **Graceful Degradation**: Service continues with limited functionality

## 📚 Learning Objectives

### Advanced Microservices Patterns
- **Configuration Management**: Externalized, encrypted, live-reloadable configs
- **Security Architecture**: JWT-based authentication across services
- **Fault Tolerance**: Circuit breaker and fallback patterns
- **Service Communication**: Feign clients with error handling

### Production-Ready Features
- **Live Reloading**: Zero-downtime configuration updates
- **Security Best Practices**: Encrypted secrets and JWT tokens
- **Monitoring & Logging**: Comprehensive logging and error tracking
- **Docker Support**: Containerization with dockerfile

---

## 📂 Services

<details>
<summary>👥 UserService</summary>

**Secure user management with JWT authentication and live configuration**

- **What it does**: Handles user registration, authentication, and profile management with album integration
- **Code implementation**: 
  - UserController with JWT security integration
  - Custom AuthencationFilter for request processing
  - Feign client for album service communication with circuit breaker
- **API endpoints**: 
  - GET /users/check (health check with port and config values)
  - POST /users (user registration)
  - GET /users/getByUserId/{userId} (user profile with albums)
- **Advanced features**:
  - **Live Config**: Reads expration.date from config server (changes from 5 to 10 without restart)
  - **JWT Security**: Custom authentication filter and Spring Security configuration
  - **Circuit Breaker**: FeignClientAlbemApiCall with fallback factory for album service failures
  - **Error Handling**: Custom exception handling and logging

</details>

<details>
<summary>📸 PhotoAppApiAlbums</summary>

**Album management service with comprehensive logging and Docker support**

- **What it does**: Manages photo albums associated with users
- **Code implementation**: 
  - AlbumsController with detailed logging and response handling
  - ModelMapper for entity-to-DTO conversion
  - Comprehensive error handling and validation
- **API endpoints**: GET /users/{id}/albums (get user's albums with JSON/XML support)
- **Advanced features**:
  - **Docker Ready**: Includes dockerfile for containerization
  - **Detailed Logging**: Logger integration with request/response tracking
  - **Multiple Response Formats**: JSON and XML support
  - **Type Safety**: TypeToken for generic list mapping

</details>

<details>
<summary>⚙️ ConfigrationServer</summary>

**Centralized configuration server with encryption and live reload**

- **What it does**: Serves encrypted configurations to all microservices with live reload capability
- **Code implementation**: Spring Cloud Config Server with encryption support
- **Advanced features**:
  - **Live Reload**: Configuration changes propagated without service restart
  - **Encryption Support**: Handles {cipher} encrypted values for sensitive data
  - **Environment Profiles**: Different configurations per environment
  - **Git Integration**: Configuration stored in version control

</details>

<details>
<summary>🏦 AccountService</summary>

**Account management service with configuration integration**

- **What it does**: Handles account-related operations with centralized configuration
- **Code implementation**: Account management with config server integration
- **Features**: Live configuration updates, service discovery integration

</details>

<details>
<summary>🌐 Zuul</summary>

**API Gateway with advanced routing and security**

- **What it does**: Routes requests, handles cross-cutting concerns, and provides single entry point
- **Code implementation**: Zuul gateway with custom filters and routing rules
- **Advanced features**:
  - **Security Integration**: JWT token validation at gateway level
  - **Load Balancing**: Intelligent request distribution
  - **Request Filtering**: Custom pre/post filters for logging and security

</details>

<details>
<summary>🔍 EurekaServer</summary>

**Service discovery with security and monitoring**

- **What it does**: Service registry with enhanced security and monitoring capabilities
- **Code implementation**: Eureka server with password protection and IP preference
- **Advanced features**:
  - **Secured Registry**: Password-protected Eureka server
  - **IP Preference**: eureka.instance.prefer-ip-address=true for better networking
  - **Health Monitoring**: Advanced health checks and service monitoring

</details>
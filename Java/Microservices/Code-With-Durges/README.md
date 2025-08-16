# Code-With-Durges

## 🎯 What This Project Does

**Complete microservices architecture implementation with Spring Boot and Spring Cloud components.**

### Core Functionality:
- 🌐 **API Gateway**: Single entry point for all microservices
- 🔍 **Service Discovery**: Eureka server for service registration
- ⚙️ **Configuration Management**: Centralized configuration server
- 👥 **Business Services**: User and Contact management services
- 📊 **Circuit Breaker**: Hystrix dashboard for fault tolerance

## 🛠️ Technology Stack

- **Spring Boot**: Microservice framework
- **Spring Cloud**: Microservices ecosystem
- **Eureka**: Service discovery
- **Hystrix**: Circuit breaker pattern
- **API Gateway**: Request routing
- **Config Server**: External configuration

## 📚 Learning Objectives

### Microservices Architecture
- **Service Decomposition**: Breaking monolith into services
- **Service Communication**: Inter-service communication patterns
- **Distributed Systems**: Handling distributed system challenges

### Spring Cloud Components
- **Service Discovery**: Dynamic service registration and lookup
- **Configuration Management**: Externalized configuration
- **Circuit Breaker**: Fault tolerance and resilience patterns
- **API Gateway**: Request routing and load balancing

---

## 📂 Services

<details>
<summary>🌐 ApiGetwaya</summary>

**API Gateway with circuit breaker fallback endpoints**

- **What it does**: Routes requests to microservices, provides fallback when services are down
- **Code implementation**: DownController with /userDown and /contactDown fallback endpoints
- **Features**: Gateway routing, Hystrix circuit breaker, Eureka client integration

</details>

<details>
<summary>⚙️ Configration-Serever</summary>

**Centralized configuration server for all microservices**

- **What it does**: Serves external configuration files to other services
- **Code implementation**: Spring Cloud Config Server setup
- **Features**: Environment-specific configs, dynamic configuration refresh

</details>

<details>
<summary>👤 ContactService</summary>

**Contact management with user-based filtering**

- **What it does**: Manages contacts linked to specific users
- **Code implementation**: ContactController with CRUD operations, filters contacts by userId
- **API endpoints**: GET /contact (all), GET /contact/{userId}, POST /contact/{userId}, DELETE /contact/{number}

</details>

<details>
<summary>🔍 EurekaServer</summary>

**Service discovery server for microservice registration**

- **What it does**: Central registry where all services register and discover each other
- **Code implementation**: Netflix Eureka Server configuration
- **Features**: Service health monitoring, load balancing, service lookup

</details>

<details>
<summary>📊 Hystrix-Dashboard</summary>

**Circuit breaker monitoring dashboard**

- **What it does**: Visualizes circuit breaker metrics and service health
- **Code implementation**: Hystrix Dashboard setup for monitoring ApiGetwaya
- **Features**: Real-time metrics, circuit breaker status, failure rate monitoring

</details>

<details>
<summary>👥 UserService</summary>

**User management with inter-service communication**

- **What it does**: Manages users and fetches their contacts from ContactService
- **Code implementation**: UserController with RestTemplate calling ContactService via service name
- **API endpoints**: GET /user (with contacts), GET /user/getAll (users only), GET /user/{id}, POST /user, DELETE /user/{id}
- **Inter-service call**: Uses RestTemplate to call "http://contact/contact/{id}" through Eureka

</details>
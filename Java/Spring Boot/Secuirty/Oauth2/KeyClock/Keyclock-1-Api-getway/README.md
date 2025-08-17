# Keyclock-1-Api-getway

> **🚪 Keycloak API Gateway**: Spring Cloud Gateway with Eureka service discovery and load balancing for Keycloak-secured microservices.

## 🎯 Key API Gateway Operations Implemented

**In this project, I performed the following operations:**

1) **Spring Cloud Gateway** - Reactive API gateway implementation
2) **Eureka Service Discovery** - Dynamic service registration and discovery
3) **Load Balancing** - Automatic load balancing with lb:// protocol
4) **Route Configuration** - Path and method-based request routing
5) **Header Management** - Cookie removal for stateless API calls
6) **Service Registration** - Gateway registration with Eureka server
7) **Dynamic Routing** - Service discovery-based routing to backend services

## 🎯 What This Project Does

**Reactive API gateway that routes requests to Keycloak-secured microservices using service discovery and load balancing.**

### Core Functionality:
- 🚪 **API Gateway**: Centralized entry point for microservices
- 🔍 **Service Discovery**: Eureka client for dynamic service location
- ⚖️ **Load Balancing**: Automatic load balancing across service instances
- 🛣️ **Request Routing**: Path and method-based routing configuration
- 🔧 **Header Processing**: Request header manipulation and filtering
- 📡 **Service Registration**: Gateway itself registered as Eureka client

## 🛠️ Technology Stack

- **Spring Cloud Gateway**: Reactive API gateway framework
- **Netflix Eureka**: Service discovery and registration
- **Spring Boot**: Application framework with cloud integration
- **Load Balancer**: Client-side load balancing with Ribbon
- **Reactive Programming**: Non-blocking request processing
- **Microservices Architecture**: Distributed system integration

## 📚 Learning Objectives

### API Gateway Patterns
- **Centralized Routing**: Single entry point for multiple services
- **Service Discovery**: Dynamic service location and routing
- **Load Balancing**: Distributing requests across service instances
- **Request Processing**: Header manipulation and filtering

### Microservices Integration
- **Service Registration**: Gateway registration with discovery server
- **Dynamic Routing**: Service discovery-based request routing
- **Scalability**: Horizontal scaling with multiple service instances
- **Fault Tolerance**: Service discovery for resilient routing

---

## 📂 Core Components

<details>
<summary>🚪 Keyclock1ApiGetwayApplication</summary>

**Main application class with Eureka client configuration**

- **What it does**: Configures Spring Cloud Gateway as Eureka client for service discovery
- **Code implementation**: 
  - **Spring Boot Application**: `@SpringBootApplication` for auto-configuration
  - **Eureka Client**: `@EnableEurekaClient` for service discovery integration
  - **Gateway Bootstrap**: Main application entry point for API gateway
- **Integration features**:
  - **Service Discovery**: Registers with Eureka server for service location
  - **Client Registration**: Gateway itself becomes discoverable service
  - **Cloud Integration**: Full Spring Cloud ecosystem integration
  - **Reactive Gateway**: Non-blocking request processing

</details>

<details>
<summary>⚙️ Application Properties Configuration</summary>

**Comprehensive gateway and service discovery configuration**

- **What it does**: Configures gateway routing, Eureka integration, and service discovery
- **Configuration sections**:
  - **Server Configuration**: `server.port=8081` for gateway port
  - **Eureka Integration**: Service registration and discovery settings
  - **Gateway Routing**: Route definitions for backend services
  - **Load Balancing**: Service discovery-based load balancing
- **Eureka configuration**:
  - **Service Name**: `spring.application.name=api-getwaya`
  - **Instance ID**: Unique instance identification with random value
  - **Eureka Server**: `eureka.client.serviceUrl.defaultZone=http://localhost:8010/eureka`
  - **IP Preference**: `eureka.instance.prefer-ip-address=true` for container environments
- **Gateway routes**:
  - **Route 1 (/check)**: `lb://resourse-server` with GET method predicate
  - **Route 2 (/jwt)**: `lb://resourse-server` with GET method predicate
  - **Load Balancing**: `lb://` protocol for service discovery-based routing
  - **Header Filtering**: `RemoveRequestHeader=cookie` for stateless API calls
- **Route features**:
  - **Path Predicates**: `Path=/check` and `Path=/jwt` for request matching
  - **Method Predicates**: `Method=GET` for HTTP method filtering
  - **Service Discovery**: `lb://resourse-server` resolves to actual service instances
  - **Cookie Removal**: Removes cookies for stateless backend communication

</details>

## 🌟 API Gateway Features

### 🚪 Centralized Routing
- **Single Entry Point**: All client requests go through gateway
- **Path-Based Routing**: Routes requests based on URL paths
- **Method Filtering**: HTTP method-specific routing rules
- **Service Abstraction**: Clients don't need to know backend service locations

### 🔍 Service Discovery Integration
- **Eureka Client**: Registers with Eureka server for service discovery
- **Dynamic Resolution**: `lb://resourse-server` resolves to actual service instances
- **Health Monitoring**: Eureka tracks service health and availability
- **Automatic Failover**: Routes to healthy service instances only

### ⚖️ Load Balancing
- **Client-Side Load Balancing**: Gateway distributes requests across instances
- **Service Instance Discovery**: Automatically discovers available service instances
- **Health-Based Routing**: Routes only to healthy service instances
- **Scalability**: Supports horizontal scaling of backend services

### 🔧 Request Processing
- **Header Management**: Removes cookies for stateless backend communication
- **Request Transformation**: Can modify requests before forwarding
- **Response Processing**: Can modify responses before returning to client
- **Filter Chain**: Supports custom filters for request/response processing

## 🚀 Gateway Flow
1. **Client Request**: Client sends request to gateway (port 8081)
2. **Route Matching**: Gateway matches request path and method to configured routes
3. **Service Discovery**: Gateway queries Eureka for `resourse-server` instances
4. **Load Balancing**: Gateway selects healthy service instance
5. **Request Processing**: Removes cookies and processes headers
6. **Service Call**: Forwards request to selected backend service instance
7. **Response Processing**: Processes response from backend service
8. **Client Response**: Returns processed response to client

## 📡 Route Configuration
- **Route ID**: `anyname` and `jwt` for route identification
- **Target Service**: `lb://resourse-server` for load-balanced routing
- **Path Predicates**: `/check` and `/jwt` path matching
- **Method Predicates**: `GET` method filtering
- **Filters**: `RemoveRequestHeader=cookie` for stateless communication

## 🔧 Service Discovery
- **Eureka Server**: `http://localhost:8010/eureka` for service registry
- **Service Name**: `api-getwaya` for gateway identification
- **Instance ID**: Unique instance identification with random value
- **IP Address**: Prefers IP address for container environments

## 🌐 Microservices Architecture
- **Gateway Pattern**: Centralized entry point for distributed services
- **Service Registry**: Eureka server for service discovery
- **Backend Services**: `resourse-server` instances behind gateway
- **Client Abstraction**: Clients interact only with gateway, not individual services
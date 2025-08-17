# keyclock-1-Netflix-Descovery

> **🔍 Netflix Eureka Discovery Server**: Service registry and discovery server for Keycloak-secured microservices architecture.

## 🎯 Key Service Discovery Operations Implemented

**In this project, I performed the following operations:**

1) **Eureka Server Setup** - Netflix Eureka service registry implementation
2) **Service Registration** - Central registry for microservice instances
3) **Service Discovery** - Dynamic service location and health monitoring
4) **Standalone Configuration** - Self-contained discovery server setup
5) **Health Monitoring** - Automatic service health checking and management
6) **Load Balancing Support** - Service instance information for client-side load balancing
7) **Logging Configuration** - Optimized logging for production environments

## 🎯 What This Project Does

**Central service registry that enables dynamic service discovery and registration for distributed Keycloak-secured microservices.**

### Core Functionality:
- 🔍 **Service Registry**: Central repository for all microservice instances
- 📡 **Service Discovery**: Dynamic service location and resolution
- 💓 **Health Monitoring**: Automatic service health checking and status tracking
- ⚖️ **Load Balancing**: Provides service instance information for load balancing
- 🔧 **Self-Management**: Standalone server that doesn't register with itself
- 📊 **Web Dashboard**: Built-in web interface for service monitoring

## 🛠️ Technology Stack

- **Netflix Eureka Server**: Service discovery and registration server
- **Spring Cloud Netflix**: Netflix OSS integration with Spring Boot
- **Spring Boot**: Application framework with cloud integration
- **Service Registry Pattern**: Centralized service location management
- **Health Checking**: Automatic service health monitoring
- **Web Dashboard**: Built-in monitoring and management interface

## 📚 Learning Objectives

### Service Discovery Patterns
- **Service Registry**: Central repository for service instances
- **Service Registration**: How services register themselves
- **Service Discovery**: How clients find and connect to services
- **Health Management**: Monitoring and managing service health

### Microservices Architecture
- **Distributed Systems**: Managing multiple service instances
- **Service Communication**: Enabling inter-service communication
- **Fault Tolerance**: Handling service failures and recovery
- **Scalability**: Supporting dynamic scaling of services

---

## 📂 Core Components

<details>
<summary>🔍 Keyclock1NetflixDescoveryApplication</summary>

**Main Eureka server application with service registry configuration**

- **What it does**: Configures and starts Netflix Eureka server for service discovery
- **Code implementation**: 
  - **Eureka Server**: `@EnableEurekaServer` annotation enables Eureka server functionality
  - **Spring Boot**: `@SpringBootApplication` for auto-configuration
  - **Service Registry**: Provides central registry for all microservices
- **Server features**:
  - **Service Registration**: Accepts service registration from clients
  - **Service Discovery**: Provides service location information to clients
  - **Health Monitoring**: Tracks service health and availability
  - **Web Dashboard**: Built-in web interface for monitoring services
- **Configuration**:
  - **Standalone Mode**: Server doesn't register with itself
  - **Registry Management**: Manages service instance registry
  - **Client Communication**: Handles registration and discovery requests

</details>

<details>
<summary>⚙️ Application Properties Configuration</summary>

**Eureka server configuration for standalone operation**

- **What it does**: Configures Eureka server for optimal standalone operation
- **Configuration sections**:
  - **Server Configuration**: `server.port=8010` for Eureka server port
  - **Eureka Instance**: IP preference and instance configuration
  - **Eureka Client**: Standalone server configuration
  - **Logging Configuration**: Optimized logging for production
- **Eureka server settings**:
  - **Port Configuration**: `server.port=8010` for service registry access
  - **IP Preference**: `eureka.instance.prefer-ip-address=true` for container environments
  - **Self Registration**: `eureka.client.registerWithEureka=false` - server doesn't register with itself
  - **Registry Fetching**: `eureka.client.fetchRegistry=false` - server doesn't fetch from other registries
- **Logging optimization**:
  - **Eureka Logging**: `logging.level.com.netflix.eureka=OFF` reduces verbose logging
  - **Discovery Logging**: `logging.level.com.netflix.discovery=OFF` minimizes discovery logs
  - **Performance**: Reduces log noise for better performance monitoring

</details>

<details>
<summary>🚀 Bootstrap Properties</summary>

**Application bootstrap configuration for service identification**

- **What it does**: Configures application name for service identification
- **Configuration**:
  - **Application Name**: `spring.application.name=Netflix-Eureka`
  - **Service Identity**: Identifies the Eureka server in distributed system
  - **Bootstrap Phase**: Loaded before main application configuration
- **Bootstrap features**:
  - **Early Configuration**: Loaded during application bootstrap phase
  - **Service Naming**: Provides consistent service identification
  - **Cloud Integration**: Enables proper Spring Cloud integration

</details>

## 🌟 Eureka Server Features

### 🔍 Service Registry
- **Central Repository**: Single source of truth for all service instances
- **Dynamic Registration**: Services register themselves at startup
- **Instance Management**: Tracks service instances and their metadata
- **Service Catalog**: Maintains comprehensive service directory

### 📡 Service Discovery
- **Client Queries**: Clients query server for service locations
- **Instance Information**: Provides service host, port, and metadata
- **Load Balancing**: Supplies instance list for client-side load balancing
- **Real-time Updates**: Clients receive updates when services change

### 💓 Health Monitoring
- **Heartbeat Mechanism**: Services send periodic heartbeats to server
- **Health Status**: Tracks UP, DOWN, and OUT_OF_SERVICE states
- **Automatic Cleanup**: Removes unhealthy instances from registry
- **Failure Detection**: Detects and handles service failures

### 🔧 Management Features
- **Web Dashboard**: Built-in web interface at `http://localhost:8010`
- **REST API**: RESTful endpoints for programmatic access
- **Metrics**: Service registration and discovery metrics
- **Configuration**: Runtime configuration and management

## 🚀 Service Discovery Flow
1. **Server Startup**: Eureka server starts on port 8010
2. **Service Registration**: Microservices register with Eureka server
3. **Health Monitoring**: Services send periodic heartbeats
4. **Client Discovery**: Clients query Eureka for service locations
5. **Instance Selection**: Clients select service instances for communication
6. **Health Updates**: Server updates service health status
7. **Registry Cleanup**: Server removes unhealthy service instances

## 📊 Web Dashboard
- **Service Registry**: View all registered services and instances
- **Instance Details**: Service health, metadata, and status information
- **System Information**: Eureka server configuration and statistics
- **Environment**: Application environment and configuration details

## 🔧 Configuration Benefits
- **Standalone Operation**: Self-contained discovery server
- **Production Ready**: Optimized logging and performance settings
- **Container Friendly**: IP address preference for containerized environments
- **Minimal Overhead**: Reduced logging for better performance

## 🌐 Microservices Integration
- **API Gateway**: Gateway registers and discovers backend services
- **Resource Servers**: Keycloak-secured services register for discovery
- **OAuth2 Clients**: Web applications discover services through registry
- **Load Balancing**: Enables client-side load balancing across instances

## 📡 Default Endpoints
- **Eureka Dashboard**: `http://localhost:8010` - Web interface
- **Service Registry**: `http://localhost:8010/eureka/apps` - REST API
- **Instance Info**: `http://localhost:8010/eureka/apps/{service-name}` - Service details
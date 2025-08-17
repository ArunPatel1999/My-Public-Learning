# Basic-Secuirty

> **🔐 Spring Security Fundamentals**: Basic Spring Security implementation with HTTP Basic authentication and in-memory user management.

## 🎯 Key Security Operations Implemented

**In this project, I performed the following operations:**

1) **HTTP Basic Authentication** - Simple username/password authentication
2) **In-Memory User Store** - Hardcoded users with roles
3) **Password Encoding** - BCrypt password hashing
4) **Role-Based Access** - USER and ADMIN role configuration
5) **Method Security** - @EnableGlobalMethodSecurity for method-level protection
6) **Security Configuration** - Custom WebSecurityConfigurerAdapter setup

## 🎯 What This Project Does

**Fundamental Spring Security setup demonstrating basic authentication patterns and user management.**

### Core Functionality:
- 🔐 **HTTP Basic Auth**: Simple browser-based authentication
- 👥 **In-Memory Users**: Hardcoded user credentials for testing
- 🔒 **Password Encoding**: BCrypt encryption for secure password storage
- 🎭 **Role Management**: USER and ADMIN role assignments
- 🛡️ **Method Security**: Annotation-based method protection
- ⚙️ **Security Config**: Custom security configuration setup

## 🛠️ Technology Stack

- **Spring Security**: Authentication and authorization framework
- **Spring Boot**: Application framework with security auto-configuration
- **BCryptPasswordEncoder**: Password hashing and encoding
- **HTTP Basic Authentication**: Simple authentication mechanism
- **In-Memory Authentication**: Testing-focused user store

## 📚 Learning Objectives

### Spring Security Fundamentals
- **Authentication vs Authorization**: Understanding security concepts
- **Security Configuration**: WebSecurityConfigurerAdapter patterns
- **Password Management**: Secure password encoding practices
- **Role-Based Security**: User roles and permissions

### Basic Security Patterns
- **HTTP Basic Auth**: Browser-based authentication flow
- **In-Memory Users**: Simple user management for development
- **Method Security**: Protecting individual methods
- **Security Annotations**: Declarative security configuration

---

## 📂 Core Components

<details>
<summary>🔐 MyBasicSecuirtyConfig</summary>

**Core Spring Security configuration with basic authentication setup**

- **What it does**: Configures HTTP Basic authentication with in-memory users and BCrypt encoding
- **Code implementation**: 
  - **HTTP Security**: `http.authorizeRequests().anyRequest().authenticated().and().httpBasic()`
  - **In-Memory Users**: `auth.inMemoryAuthentication().withUser("test1").password().roles("USER")`
  - **Password Encoding**: `BCryptPasswordEncoder` for secure password hashing
  - **Method Security**: `@EnableGlobalMethodSecurity(prePostEnabled = true)`
- **Security features**:
  - **Authentication Required**: All requests require authentication
  - **Two Test Users**: test1 (USER role) and test2 (ADMIN role)
  - **BCrypt Encoding**: Secure password storage with salt
  - **Global Method Security**: Enable @PreAuthorize and @PostAuthorize
- **Configuration highlights**:
  - **WebSecurityConfigurerAdapter**: Legacy security configuration approach
  - **Role Assignment**: Simple role-based access control
  - **Password Encoder Bean**: Centralized password encoding service

</details>

<details>
<summary>🎮 NormalController</summary>

**Simple controller demonstrating protected endpoints**

- **What it does**: Provides basic endpoint that requires authentication
- **Code implementation**: 
  - **GET Mapping**: `@GetMapping` for root path "/"
  - **String Response**: Returns simple "Test" string
  - **Protected Access**: Requires authentication due to security configuration
- **Security behavior**:
  - **Authentication Required**: HTTP Basic auth prompt in browser
  - **Role Access**: Accessible by both USER and ADMIN roles
  - **Simple Response**: Basic string return for testing purposes

</details>

## 🌟 Security Features

### 🔐 Authentication Mechanisms
- **HTTP Basic**: Browser-based username/password authentication
- **In-Memory Store**: Hardcoded users for development and testing
- **Password Encoding**: BCrypt with salt for secure password storage
- **Session Management**: Default Spring Security session handling

### 🎭 Authorization Patterns
- **Role-Based Access**: USER and ADMIN role differentiation
- **Method Security**: Annotation-based method protection capability
- **Global Security**: All endpoints protected by default
- **Flexible Configuration**: Easy to extend with additional roles

### ⚙️ Configuration Benefits
- **Simple Setup**: Minimal configuration for basic security
- **Development Friendly**: In-memory users for easy testing
- **Production Ready**: BCrypt encoding suitable for production
- **Extensible**: Foundation for more complex security requirements

## 🚀 Security Flow
1. **Request**: User accesses protected endpoint
2. **Authentication**: HTTP Basic auth prompt appears
3. **Credentials**: User enters username/password (test1/test1 or test2/test2)
4. **Validation**: Spring Security validates against in-memory users
5. **Authorization**: Role-based access granted
6. **Response**: Protected resource returned to authenticated user
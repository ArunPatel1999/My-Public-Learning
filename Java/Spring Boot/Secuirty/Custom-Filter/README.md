# Custom-Filter

> **🔧 Custom Authentication Filter**: Advanced Spring Security implementation with custom filters, authentication providers, and header-based authentication.

## 🎯 Key Custom Filter Operations Implemented

**In this project, I performed the following operations:**

1) **Custom Authentication Filter** - Header-based authentication filter
2) **Custom Authentication Provider** - Property-based authentication logic
3) **Custom Authentication Object** - Extended UsernamePasswordAuthenticationToken
4) **Header-Based Security** - Authentication via HTTP headers
5) **Filter Chain Integration** - Custom filter in Spring Security chain
6) **Property-Based Keys** - Configuration-driven security keys
7) **Error Handling** - Custom 403 error responses for invalid authentication

## 🎯 What This Project Does

**Advanced Spring Security implementation with custom authentication mechanisms using HTTP headers and configuration-based security keys.**

### Core Functionality:
- 🔧 **Custom Filter**: Header-based authentication filter implementation
- 🔑 **Header Authentication**: Security via "key" HTTP header
- ⚙️ **Custom Provider**: Property-based authentication provider
- 🛡️ **Custom Authentication**: Extended authentication object
- 📝 **Configuration-Driven**: Security keys from application properties
- 🔄 **Filter Integration**: Custom filter in Spring Security chain

## 🛠️ Technology Stack

- **Spring Security**: Custom filter and authentication framework
- **OncePerRequestFilter**: Custom filter base class
- **AuthenticationProvider**: Custom authentication logic
- **AuthenticationManager**: Authentication management
- **UsernamePasswordAuthenticationToken**: Extended authentication object
- **@Value**: Property injection for security configuration

## 📚 Learning Objectives

### Custom Authentication Patterns
- **Custom Filters**: Building specialized authentication filters
- **Authentication Providers**: Custom authentication logic implementation
- **Filter Chain Integration**: Positioning custom filters in security chain
- **Header-Based Auth**: Alternative authentication mechanisms

### Advanced Security Architecture
- **Authentication Objects**: Custom authentication token implementation
- **Provider Patterns**: AuthenticationProvider interface implementation
- **Configuration Security**: Property-based security configuration
- **Error Handling**: Custom error responses for authentication failures

---

## 📂 Core Components

<details>
<summary>🔧 MyCustomFilter</summary>

**Custom authentication filter for header-based authentication**

- **What it does**: Intercepts requests to authenticate users via HTTP headers
- **Code implementation**: 
  - **OncePerRequestFilter**: Ensures filter runs once per request
  - **Header Extraction**: `request.getHeader("key")` for authentication key
  - **Authentication Manager**: Uses AuthenticationManager for authentication
  - **Security Context**: Sets authentication in SecurityContextHolder
- **Filter operations**:
  - **Header Processing**: Extracts "key" header from HTTP request
  - **Authentication Creation**: Creates MyCustomAuthentication object
  - **Manager Integration**: Uses AuthenticationManager.authenticate()
  - **Context Setting**: Sets authenticated user in security context
- **Error handling**:
  - **Invalid Key**: Returns 403 "Key Not GOOD" for failed authentication
  - **Missing Key**: Returns 403 "Key Not Found" for missing header
  - **Exception Handling**: Catches and handles authentication exceptions
  - **Filter Chain**: Continues processing only for authenticated requests

</details>

<details>
<summary>🔑 CustomeAuthPovider</summary>

**Custom authentication provider with property-based validation**

- **What it does**: Validates authentication using configuration-based security key
- **Code implementation**: 
  - **AuthenticationProvider Interface**: Implements Spring Security provider contract
  - **Property Injection**: `@Value("${my.key}")` for security key configuration
  - **Key Validation**: Compares header key with configured security key
  - **Authentication Support**: Supports MyCustomAuthentication objects
- **Provider features**:
  - **Configuration-Driven**: Security key from application.properties
  - **Simple Validation**: String comparison for authentication
  - **Type Support**: Supports only MyCustomAuthentication class
  - **Return Logic**: Returns authenticated token or null
- **Authentication flow**:
  - **Key Comparison**: Compares request key with configured key
  - **Success Response**: Returns authenticated MyCustomAuthentication
  - **Failure Response**: Returns null for invalid keys
  - **Type Checking**: Validates authentication object type

</details>

<details>
<summary>🛡️ MyCustomAuthentication</summary>

**Custom authentication object extending UsernamePasswordAuthenticationToken**

- **What it does**: Represents custom authentication with header-based credentials
- **Code implementation**: 
  - **Token Extension**: Extends UsernamePasswordAuthenticationToken
  - **Constructor Overloading**: Multiple constructors for different scenarios
  - **Authority Support**: Handles GrantedAuthority collections
  - **Serialization**: Implements serializable for session storage
- **Authentication structure**:
  - **Principal**: User identifier (header key value)
  - **Credentials**: Authentication credentials (null in this case)
  - **Authorities**: User permissions and roles
  - **Inheritance**: Leverages Spring Security token functionality
- **Usage patterns**:
  - **Filter Creation**: Created by MyCustomFilter with header value
  - **Provider Processing**: Processed by CustomeAuthPovider
  - **Context Storage**: Stored in SecurityContextHolder
  - **Authority Management**: Supports role-based access control

</details>

<details>
<summary>⚙️ Configration</summary>

**Spring Security configuration with custom filter and provider integration**

- **What it does**: Configures Spring Security with custom authentication components
- **Code implementation**: 
  - **WebSecurityConfigurerAdapter**: Legacy security configuration
  - **Filter Integration**: `addFilterAt(myCustomFilter, BasicAuthenticationFilter.class)`
  - **Provider Registration**: `auth.authenticationProvider(customeAuthPovider)`
  - **AuthenticationManager Bean**: Exposes AuthenticationManager as bean
- **Configuration features**:
  - **Filter Positioning**: Places custom filter at BasicAuthenticationFilter position
  - **Provider Chain**: Registers custom authentication provider
  - **Permit All**: Allows all requests (authentication handled by filter)
  - **Manager Exposure**: Makes AuthenticationManager available for injection
- **Security setup**:
  - **Custom Components**: Integrates all custom security components
  - **Filter Chain**: Positions filter in appropriate security chain location
  - **Provider Chain**: Adds custom provider to authentication chain
  - **Bean Management**: Proper Spring bean configuration

</details>

## 🌟 Advanced Security Features

### 🔧 Custom Authentication Flow
- **Header-Based Auth**: Authentication via HTTP "key" header
- **Filter Processing**: Custom filter intercepts and processes requests
- **Provider Validation**: Custom provider validates against configuration
- **Context Management**: Proper security context handling

### 🔑 Configuration-Driven Security
- **Property-Based Keys**: Security keys from application.properties
- **Flexible Configuration**: Easy key management and rotation
- **Environment-Specific**: Different keys per environment
- **Centralized Management**: Single configuration point for security

### 🛡️ Custom Components Integration
- **Filter Chain**: Seamless integration with Spring Security filters
- **Provider Chain**: Custom provider in authentication chain
- **Authentication Objects**: Custom token implementation
- **Error Handling**: Proper error responses and exception management

### ⚙️ Architecture Benefits
- **Extensible Design**: Easy to extend with additional authentication logic
- **Testable Components**: Isolated components for unit testing
- **Configuration Flexibility**: Property-driven security configuration
- **Spring Integration**: Full Spring Security framework integration

## 🚀 Authentication Flow
1. **Request**: Client sends request with "key" header
2. **Filter Interception**: MyCustomFilter intercepts request
3. **Header Extraction**: Filter extracts "key" header value
4. **Authentication Creation**: Creates MyCustomAuthentication object
5. **Provider Processing**: CustomeAuthPovider validates key against configuration
6. **Key Validation**: Compares header key with ${my.key} property
7. **Authentication Result**: Returns authenticated token or null
8. **Context Setting**: Sets authentication in SecurityContextHolder
9. **Request Processing**: Continues to controller or returns 403 error
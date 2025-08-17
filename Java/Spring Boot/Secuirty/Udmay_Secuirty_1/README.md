# Udmay_Secuirty_1

> **📚 Advanced Security Patterns**: Comprehensive Spring Security implementation demonstrating multiple authentication providers, custom filters, and password encoding strategies.

## 🎯 Key Advanced Security Operations Implemented

**In this project, I performed the following operations:**

1) **Custom Authentication Provider** - Hardcoded credential validation
2) **Custom Filter Integration** - Request/response logging filter
3) **HTTP Method Security** - Method-specific endpoint protection
4) **Public API Endpoints** - Selective endpoint access without authentication
5) **Multiple Password Encoders** - BCrypt, PBKDF2, SCrypt comparison
6) **Delegating Password Encoder** - Multi-algorithm password encoding
7) **Filter Chain Positioning** - Custom filter before BasicAuthenticationFilter

## 🎯 What This Project Does

**Comprehensive Spring Security implementation showcasing advanced authentication patterns, custom filters, and multiple password encoding strategies.**

### Core Functionality:
- 📚 **Advanced Authentication**: Custom provider with hardcoded credentials
- 🔍 **Custom Filtering**: Request/response logging and processing
- 🔐 **Password Strategies**: Multiple password encoding algorithms
- 🌐 **Selective Security**: Public and protected endpoint configuration
- ⚙️ **Filter Positioning**: Strategic filter placement in security chain
- 🛡️ **Method Security**: HTTP method-specific access control

## 🛠️ Technology Stack

- **Spring Security**: Advanced security framework features
- **Custom AuthenticationProvider**: Hardcoded authentication logic
- **OncePerRequestFilter**: Custom request/response processing
- **Multiple Password Encoders**: BCrypt, PBKDF2, SCrypt
- **DelegatingPasswordEncoder**: Multi-algorithm password encoding
- **HTTP Method Security**: Method-specific endpoint protection

## 📚 Learning Objectives

### Advanced Security Patterns
- **Custom Providers**: Specialized authentication logic implementation
- **Filter Integration**: Custom filter positioning and processing
- **Password Security**: Multiple encoding algorithm comparison
- **Selective Protection**: Mixed public and protected endpoint configuration

### Enterprise Security Features
- **Authentication Strategies**: Various authentication approaches
- **Filter Chain Management**: Strategic filter positioning
- **Password Management**: Advanced password encoding strategies
- **Access Control**: Fine-grained endpoint protection

---

## 📂 Core Components

<details>
<summary>📚 MyAuthenticationProvider</summary>

**Custom authentication provider with hardcoded credentials and exception handling**

- **What it does**: Implements custom authentication logic with specific username/password validation
- **Code implementation**: 
  - **AuthenticationProvider Interface**: Custom authentication logic implementation
  - **Hardcoded Credentials**: Username "admin" with password "admin1"
  - **Exception Handling**: BadCredentialsException for invalid credentials
  - **Token Creation**: UsernamePasswordAuthenticationToken with empty authorities
- **Authentication features**:
  - **Simple Validation**: Direct string comparison for credentials
  - **Exception Management**: Proper BadCredentialsException throwing
  - **Token Support**: UsernamePasswordAuthenticationToken support only
  - **Authority Management**: Empty authorities list for authenticated users
- **Security logic**:
  - **Username Check**: Validates "admin" username exactly
  - **Password Check**: Validates "admin1" password exactly
  - **Success Response**: Returns authenticated token with credentials
  - **Failure Response**: Throws BadCredentialsException with message
- **Provider characteristics**:
  - **Type Support**: Supports UsernamePasswordAuthenticationToken only
  - **Hardcoded Logic**: Fixed credentials for demonstration purposes
  - **Exception Handling**: Proper authentication exception management

</details>

<details>
<summary>🔍 MyFilter</summary>

**Custom logging filter for request/response processing**

- **What it does**: Logs request processing with before and after messages
- **Code implementation**: 
  - **OncePerRequestFilter**: Ensures filter runs once per request
  - **Before Processing**: Logs "after" message before request processing
  - **After Processing**: Logs "before" message after request processing
  - **Filter Chain**: Continues request processing through filter chain
- **Filter operations**:
  - **Request Logging**: Logs when request enters filter
  - **Response Logging**: Logs when request exits filter
  - **Chain Continuation**: Proper filter chain processing
  - **Simple Implementation**: Basic logging for demonstration
- **Positioning**:
  - **Before BasicAuth**: Positioned before BasicAuthenticationFilter
  - **Early Processing**: Runs early in filter chain
  - **Request Tracking**: Tracks request flow through security chain

</details>

<details>
<summary>⚙️ MyConfig</summary>

**Comprehensive security configuration with custom components and selective protection**

- **What it does**: Configures Spring Security with custom provider, filter, and selective endpoint protection
- **Code implementation**: 
  - **Custom Provider**: `auth.authenticationProvider(myAuthenticationProvider)`
  - **HTTP Basic Auth**: `http.httpBasic()` for authentication method
  - **Selective Security**: `mvcMatchers(HttpMethod.GET, "/openApi/{data}").permitAll()`
  - **Filter Integration**: `addFilterBefore(new MyFilter(), BasicAuthenticationFilter.class)`
- **Security configuration**:
  - **Authentication Provider**: Custom provider instead of default
  - **Public Endpoints**: `/openApi/{data}` accessible without authentication
  - **Protected Resources**: All other endpoints require authentication
  - **Filter Chain**: Custom filter positioned before basic authentication
- **Advanced features**:
  - **Method-Specific**: GET method specific public access
  - **Path Variables**: Dynamic path variable support in security rules
  - **Filter Positioning**: Strategic filter placement in security chain
  - **Commented Alternatives**: Shows in-memory user configuration alternative

</details>

<details>
<summary>🎮 MyController</summary>

**Controller demonstrating protected endpoints and password encoding examples**

- **What it does**: Provides various endpoints including protected resources and password encoding demonstrations
- **Code implementation**: 
  - **Protected Endpoints**: `/hii` and `/bay` require authentication
  - **Public Endpoint**: `/openApi/{data}` accessible without authentication
  - **Password Demo**: `/password` shows multiple encoding algorithms
  - **Encoder Comparison**: BCrypt, PBKDF2, SCrypt encoding examples
- **Endpoint features**:
  - **Authentication Required**: Most endpoints require valid credentials
  - **Public Access**: OpenAPI endpoint demonstrates public access
  - **Password Examples**: Demonstrates various password encoding strategies
  - **Delegating Encoder**: Shows multi-algorithm password encoding
- **Password encoding demonstration**:
  - **BCryptPasswordEncoder**: Standard BCrypt password hashing
  - **Pbkdf2PasswordEncoder**: PBKDF2 password hashing algorithm
  - **SCryptPasswordEncoder**: SCrypt password hashing algorithm
  - **DelegatingPasswordEncoder**: Multi-algorithm password encoder with algorithm selection

</details>

## 🌟 Advanced Security Features

### 📚 Authentication Strategies
- **Custom Provider**: Hardcoded authentication for specific use cases
- **Exception Handling**: Proper BadCredentialsException management
- **Token Management**: UsernamePasswordAuthenticationToken creation
- **Provider Chain**: Integration with Spring Security provider chain

### 🔍 Filter Management
- **Custom Filters**: Request/response logging and processing
- **Filter Positioning**: Strategic placement in security filter chain
- **Chain Processing**: Proper filter chain continuation
- **Request Tracking**: Monitor request flow through security layers

### 🔐 Password Security
- **Multiple Algorithms**: BCrypt, PBKDF2, SCrypt comparison
- **Delegating Encoder**: Multi-algorithm password encoding strategy
- **Algorithm Selection**: Flexible password encoding algorithm choice
- **Security Comparison**: Different encoding algorithm characteristics

### 🌐 Selective Protection
- **Method-Specific Security**: HTTP method-based access control
- **Public Endpoints**: Selective public access configuration
- **Path Variables**: Dynamic path variable support in security rules
- **Mixed Security**: Combination of public and protected resources

## 🚀 Security Flow
1. **Request**: Client sends request to application
2. **Custom Filter**: MyFilter logs "after" and processes request
3. **Authentication**: Spring Security checks if authentication required
4. **Provider Processing**: MyAuthenticationProvider validates credentials
5. **Credential Check**: Validates "admin"/"admin1" credentials
6. **Token Creation**: Creates authenticated token on success
7. **Authorization**: Checks endpoint access permissions
8. **Controller**: Processes request in MyController
9. **Response**: MyFilter logs "before" and returns response
10. **Password Demo**: `/password` endpoint demonstrates encoding algorithms
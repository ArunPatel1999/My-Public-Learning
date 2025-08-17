# Custome-Auth-provider

> **👤 Custom Authentication Provider**: Advanced Spring Security implementation with custom AuthenticationProvider and UserDetailsService integration.

## 🎯 Key Authentication Provider Operations Implemented

**In this project, I performed the following operations:**

1) **Custom Authentication Provider** - Custom authentication logic implementation
2) **UserDetailsService Integration** - User loading and validation
3) **Password Encoding** - BCrypt password validation
4) **In-Memory User Management** - Programmatic user creation
5) **Authentication Support** - UsernamePasswordAuthenticationToken support
6) **Custom Authentication Logic** - Manual password verification
7) **Provider Chain Integration** - Custom provider in authentication chain

## 🎯 What This Project Does

**Advanced Spring Security implementation with custom authentication provider that handles user loading and password validation manually.**

### Core Functionality:
- 👤 **Custom Provider**: Manual authentication logic implementation
- 🔐 **Password Validation**: BCrypt password encoding and verification
- 👥 **User Management**: In-memory user details service
- 🔑 **Token Support**: UsernamePasswordAuthenticationToken handling
- ⚙️ **Provider Chain**: Integration with Spring Security provider chain
- 🛡️ **Manual Authentication**: Custom authentication flow control

## 🛠️ Technology Stack

- **Spring Security**: Authentication provider framework
- **AuthenticationProvider**: Custom authentication logic interface
- **UserDetailsService**: User loading and management
- **BCryptPasswordEncoder**: Password hashing and validation
- **InMemoryUserDetailsManager**: In-memory user storage
- **UsernamePasswordAuthenticationToken**: Standard authentication token

## 📚 Learning Objectives

### Authentication Provider Patterns
- **Custom Providers**: Building specialized authentication logic
- **Provider Chain**: Integration with Spring Security provider chain
- **User Loading**: UserDetailsService integration patterns
- **Password Validation**: Manual password verification techniques

### Advanced Security Architecture
- **Authentication Flow**: Custom authentication processing
- **Provider Support**: Authentication type support implementation
- **User Management**: Programmatic user creation and management
- **Security Integration**: Seamless Spring Security integration

---

## 📂 Core Components

<details>
<summary>👤 MyAuthProvieder</summary>

**Custom authentication provider with manual user validation**

- **What it does**: Implements custom authentication logic with UserDetailsService and password validation
- **Code implementation**: 
  - **AuthenticationProvider Interface**: Implements Spring Security provider contract
  - **User Loading**: `userDetailsService.loadUserByUsername()` for user retrieval
  - **Password Validation**: `passwordEncoder.matches()` for password verification
  - **Token Creation**: Creates UsernamePasswordAuthenticationToken on success
- **Authentication logic**:
  - **User Retrieval**: Loads user details from UserDetailsService
  - **Null Check**: Validates user existence before password check
  - **Password Match**: Compares provided password with stored hash
  - **Token Generation**: Creates authenticated token on successful validation
- **Provider features**:
  - **Manual Control**: Full control over authentication process
  - **Custom Logic**: Ability to add custom authentication rules
  - **Integration**: Works with existing UserDetailsService implementations
  - **Type Support**: Supports UsernamePasswordAuthenticationToken only
- **Authentication flow**:
  - **Username Extraction**: Gets username from authentication object
  - **User Loading**: Retrieves user from UserDetailsService
  - **Password Verification**: Validates password using encoder
  - **Success Response**: Returns authenticated token or null

</details>

<details>
<summary>⚙️ SecirtyConfigration</summary>

**Security configuration with in-memory user management**

- **What it does**: Configures UserDetailsService and password encoding for authentication
- **Code implementation**: 
  - **UserDetailsService Bean**: Creates InMemoryUserDetailsManager
  - **User Creation**: `User.withUsername().password().authorities().build()`
  - **Password Encoding**: BCryptPasswordEncoder for secure password storage
  - **Authority Assignment**: Assigns "read" authority to test user
- **Configuration features**:
  - **In-Memory Storage**: InMemoryUserDetailsManager for user storage
  - **Programmatic Users**: Creates users via code rather than properties
  - **BCrypt Encoding**: Secure password hashing with salt
  - **Authority Management**: Role and authority assignment
- **User setup**:
  - **Test User**: Username "test1" with password "test1"
  - **Encoded Password**: BCrypt-encoded password storage
  - **Read Authority**: Single "read" authority assignment
  - **Builder Pattern**: Fluent user creation API
- **Bean management**:
  - **UserDetailsService**: Exposed as Spring bean for injection
  - **PasswordEncoder**: BCryptPasswordEncoder bean for password operations
  - **Configuration**: Centralized security configuration

</details>

<details>
<summary>🎮 Controller1</summary>

**Simple REST controller for testing authentication**

- **What it does**: Provides protected endpoint to test custom authentication
- **Code implementation**: 
  - **GET Mapping**: Simple GET endpoint returning test data
  - **Protected Resource**: Requires authentication via custom provider
  - **String Response**: Returns "My Data" for authenticated users
- **Testing features**:
  - **Authentication Test**: Validates custom provider functionality
  - **Simple Response**: Basic string response for verification
  - **Protected Access**: Requires valid authentication to access

</details>

## 🌟 Advanced Authentication Features

### 👤 Custom Provider Logic
- **Manual Authentication**: Full control over authentication process
- **User Integration**: Seamless UserDetailsService integration
- **Password Validation**: Custom password verification logic
- **Token Management**: Manual authentication token creation

### 🔐 Security Architecture
- **Provider Chain**: Integration with Spring Security provider chain
- **Type Support**: Specific authentication type support
- **User Loading**: Flexible user loading mechanisms
- **Password Security**: BCrypt encoding for secure password storage

### ⚙️ Configuration Benefits
- **Programmatic Setup**: Code-based user and security configuration
- **Bean Management**: Proper Spring bean configuration and injection
- **Flexible Users**: Easy user creation and management
- **Authority Control**: Fine-grained authority and role assignment

### 🛡️ Authentication Flow Control
- **Custom Logic**: Ability to add business rules to authentication
- **Error Handling**: Proper null handling and validation
- **Success Management**: Custom success response creation
- **Integration**: Works with existing Spring Security infrastructure

## 🚀 Authentication Flow
1. **Login Attempt**: User submits credentials via HTTP Basic or form
2. **Provider Selection**: Spring Security selects MyAuthProvieder
3. **User Loading**: Provider loads user via UserDetailsService
4. **User Validation**: Checks if user exists and is valid
5. **Password Verification**: Uses BCryptPasswordEncoder to verify password
6. **Token Creation**: Creates UsernamePasswordAuthenticationToken on success
7. **Authentication Success**: Sets authentication in security context
8. **Resource Access**: User can access protected Controller1 endpoint
9. **Failure Handling**: Returns null for failed authentication, triggering 401 response
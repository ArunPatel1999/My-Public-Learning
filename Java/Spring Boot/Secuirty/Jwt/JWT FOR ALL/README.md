# JWT FOR ALL

> **🔧 Universal JWT System**: Comprehensive JWT authentication supporting multiple user types with MongoDB integration and cross-origin support.

## 🎯 Key Universal JWT Operations Implemented

**In this project, I performed the following operations:**

1) **Multi-User Type Support** - TestA and TestB user entities with shared interface
2) **MongoDB Integration** - NoSQL database for user storage and management
3) **Cross-Origin Support** - CORS enabled for web and mobile clients
4) **Universal Authentication** - Single JWT system for multiple user types
5) **Registration Endpoints** - Multiple signup endpoints for different user types
6) **Exception Handling** - Custom exception management for authentication errors
7) **Interface-Based Design** - SameFields interface for user type abstraction

## 🎯 What This Project Does

**Universal JWT authentication system supporting multiple user types with MongoDB storage and comprehensive error handling.**

### Core Functionality:
- 🔧 **Multi-User Support**: Single JWT system for different user entity types
- 🗄️ **MongoDB Integration**: NoSQL database for flexible user data storage
- 🌐 **Cross-Origin Ready**: CORS support for web and mobile applications
- 🔐 **Universal Authentication**: Unified JWT token system across user types
- 📝 **Multiple Registration**: Different signup flows for various user types
- ⚠️ **Error Management**: Custom exception handling and error responses

## 🛠️ Technology Stack

- **JWT (JSON Web Tokens)**: Universal authentication tokens
- **MongoDB**: NoSQL database for user storage
- **Spring Data MongoDB**: MongoDB integration framework
- **CORS Support**: Cross-origin resource sharing
- **Custom Exceptions**: Application-specific error handling
- **Interface Design**: Shared user field abstraction

## 📚 Learning Objectives

### Universal Authentication
- **Multi-User Types**: Supporting different user entities with single JWT system
- **Interface Design**: Using interfaces for user type abstraction
- **MongoDB Integration**: NoSQL database patterns for user management
- **Cross-Platform Support**: CORS configuration for multiple client types

### Advanced JWT Patterns
- **Universal Token System**: Single JWT implementation for multiple user types
- **Database Integration**: Persistent user storage with MongoDB
- **Error Handling**: Custom exception management for authentication
- **API Design**: RESTful endpoints for universal authentication

---

## 📂 Core Components

<details>
<summary>🔧 JWTUtil</summary>

**Universal JWT utility supporting all user types**

- **What it does**: Provides JWT operations for any user type implementing SameFields interface
- **Code implementation**: 
  - **Token Generation**: `generateToken(UserDetails)` creates JWT for any user type
  - **Claims Extraction**: `extractUsername()`, `extractExpiration()` for token parsing
  - **Token Validation**: `validateToken()` verifies token integrity and expiration
  - **Universal Support**: Works with TestA, TestB, and any SameFields implementation
- **JWT features**:
  - **Secret Key**: "keeboApp" for token signing and verification
  - **Short Expiration**: 20 seconds for demonstration purposes
  - **HS256 Algorithm**: HMAC SHA-256 for token signing
  - **Claims Management**: Standard JWT claims with custom subject
- **Universal operations**:
  - **Type Agnostic**: Works with any user type implementing SameFields
  - **Consistent API**: Same JWT operations regardless of user entity type
  - **Flexible Validation**: Validates tokens for any authenticated user type

</details>

<details>
<summary>🛡️ AuthenticationFilter</summary>

**Universal authentication filter supporting all user types**

- **What it does**: Intercepts requests and validates JWT tokens for any user type
- **Code implementation**: 
  - **OncePerRequestFilter**: Ensures filter runs once per request
  - **Bearer Token**: Extracts token from "Authorization: Bearer <token>" header
  - **Universal Validation**: Validates tokens regardless of user entity type
  - **Error Headers**: Sets error headers for invalid or expired tokens
- **Filter operations**:
  - **Token Extraction**: Parses Authorization header for Bearer tokens
  - **User Loading**: Loads UserDetails for any user type via UserDetailsService
  - **Context Setting**: Sets Spring Security authentication context
  - **Error Handling**: Provides specific error messages in response headers
- **Universal support**:
  - **Multi-User Types**: Handles authentication for TestA, TestB, and future user types
  - **Consistent Processing**: Same authentication flow for all user types
  - **Error Management**: Unified error handling across user types

</details>

<details>
<summary>🎮 JWTController</summary>

**Universal REST controller supporting multiple user registration and authentication**

- **What it does**: Provides authentication and registration endpoints for all user types
- **Code implementation**: 
  - **Cross-Origin**: `@CrossOrigin` enables CORS for web and mobile clients
  - **Token Generation**: `/getToken` endpoint for universal authentication
  - **Multiple Registration**: `/signup` and `/signup1` for different user types
  - **Universal Service**: Delegates to JWTService for business logic
- **API endpoints**:
  - **POST /api/auth/getToken**: Universal login for any user type
  - **POST /api/auth/signup**: Registration for TestA user type
  - **POST /api/auth/signup1**: Registration for TestB user type
  - **GET /api/auth**: Test endpoint for authentication verification
- **Universal features**:
  - **Type-Specific Registration**: Different endpoints for different user types
  - **Unified Authentication**: Single login endpoint for all user types
  - **CORS Support**: Cross-origin requests from web and mobile applications
  - **Exception Handling**: Custom KeeboAppException for error management

</details>

<details>
<summary>🗄️ User Entities (TestA & TestB)</summary>

**Multiple user entity types with shared interface**

- **What it does**: Represents different user types with common authentication fields
- **Code implementation**: 
  - **MongoDB Documents**: `@Document` annotation for MongoDB storage
  - **SameFields Interface**: Shared interface for common authentication fields
  - **Type-Specific Fields**: Each user type has unique additional fields
  - **MongoDB Integration**: Spring Data MongoDB repositories for persistence
- **Entity features**:
  - **TestA**: User type with number, email, username, password, test fields
  - **TestB**: Alternative user type with different field structure
  - **SameFields**: Interface ensuring common fields across user types
  - **MongoDB Storage**: NoSQL document storage for flexible user data
- **Universal design**:
  - **Interface Abstraction**: SameFields interface enables universal JWT operations
  - **Type Flexibility**: Easy addition of new user types implementing SameFields
  - **Database Flexibility**: MongoDB allows different field structures per user type

</details>

## 🌟 Universal JWT Features

### 🔧 Multi-User Type Support
- **Interface Design**: SameFields interface for user type abstraction
- **Universal Authentication**: Single JWT system for multiple user entities
- **Type-Specific Registration**: Different signup flows for different user types
- **Flexible Architecture**: Easy addition of new user types

### 🗄️ MongoDB Integration
- **NoSQL Storage**: Flexible document storage for different user structures
- **Spring Data**: MongoDB repositories for type-safe database operations
- **Document Mapping**: Automatic mapping between Java objects and MongoDB documents
- **Scalable Storage**: NoSQL database for handling diverse user data

### 🌐 Cross-Platform Support
- **CORS Enabled**: Cross-origin resource sharing for web and mobile clients
- **RESTful API**: Standard REST endpoints for universal client support
- **JSON Communication**: JSON request/response for platform independence
- **Mobile Ready**: JWT tokens perfect for mobile application authentication

### ⚠️ Error Management
- **Custom Exceptions**: KeeboAppException for application-specific errors
- **Error Headers**: Specific error messages in HTTP response headers
- **Exception Handling**: Comprehensive error handling throughout application
- **User Feedback**: Clear error messages for authentication failures

## 🚀 Universal Authentication Flow
1. **User Registration**: Client registers via type-specific signup endpoint
2. **User Storage**: User data stored in MongoDB with type-specific structure
3. **Authentication Request**: Client sends credentials to universal /getToken endpoint
4. **User Validation**: System validates credentials regardless of user type
5. **JWT Generation**: Universal JWT token created for authenticated user
6. **Token Response**: Client receives JWT token for API access
7. **Request Authentication**: Client sends JWT in Authorization header
8. **Universal Validation**: Filter validates token regardless of original user type
9. **Resource Access**: Authenticated user accesses protected resources

## 📡 API Endpoints
- **POST /api/auth/getToken**: Universal authentication for all user types
- **POST /api/auth/signup**: TestA user registration
- **POST /api/auth/signup1**: TestB user registration
- **GET /api/auth**: Authentication test endpoint

## 🔧 Configuration Benefits
- **Universal Design**: Single JWT system supporting multiple user types
- **Scalable Architecture**: Easy addition of new user types
- **Cross-Platform**: CORS support for web and mobile applications
- **NoSQL Flexibility**: MongoDB for diverse user data structures
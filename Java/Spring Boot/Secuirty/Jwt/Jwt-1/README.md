# Jwt-1

> **🔑 JWT Authentication System**: Stateless authentication using JSON Web Tokens with custom filters and token management.

## 🎯 Key JWT Operations Implemented

**In this project, I performed the following operations:**

1) **JWT Token Generation** - Create access and refresh tokens
2) **Token Validation** - Verify token signature and expiration
3) **Custom JWT Filter** - Intercept requests and validate tokens
4) **Stateless Authentication** - No server-side session storage
5) **Bearer Token Support** - Authorization header token extraction
6) **Token Refresh** - Separate refresh token for extended sessions
7) **Claims Management** - Extract user information from tokens

## 🎯 What This Project Does

**Modern stateless authentication system using JWT tokens for secure API access without server-side sessions.**

### Core Functionality:
- 🔑 **JWT Token Generation**: Create signed tokens with user claims
- 🛡️ **Token Validation**: Verify token integrity and expiration
- 🔍 **Custom Filter**: Intercept and authenticate requests via tokens
- 📱 **Stateless Design**: No server-side session storage required
- 🔄 **Token Refresh**: Extended session management with refresh tokens
- 🎫 **Bearer Authentication**: Standard Authorization header support

## 🛠️ Technology Stack

- **JWT (JSON Web Tokens)**: Stateless authentication tokens
- **JJWT Library**: Java JWT implementation
- **Spring Security**: Security framework integration
- **OncePerRequestFilter**: Custom authentication filter
- **HMAC SHA-512**: Token signing algorithm
- **Bearer Token**: Standard token transmission format

## 📚 Learning Objectives

### JWT Fundamentals
- **Stateless Authentication**: Token-based vs session-based security
- **Token Structure**: Header, payload, and signature components
- **Claims Management**: Storing user information in tokens
- **Token Lifecycle**: Generation, validation, and expiration

### Advanced JWT Patterns
- **Custom Filters**: Request interception and token validation
- **Refresh Tokens**: Extended session management
- **Security Context**: Spring Security integration
- **Token Extraction**: Authorization header parsing

---

## 📂 Core Components

<details>
<summary>🔑 JWTUtility</summary>

**Comprehensive JWT token management service**

- **What it does**: Handles all JWT operations including generation, validation, and claims extraction
- **Code implementation**: 
  - **Token Generation**: `generateToken(UserDetails)` creates signed JWT tokens
  - **Refresh Tokens**: `generateRefrenseToken()` for extended sessions
  - **Claims Extraction**: `getUsernameFromToken()`, `getExpirationDateFromToken()`
  - **Token Validation**: `validateToken()` verifies signature and expiration
- **JWT features**:
  - **HMAC SHA-512**: Secure token signing with secret key
  - **Custom Expiration**: Access tokens (2 min) and refresh tokens (5 min)
  - **Claims Management**: Subject, issued date, and expiration claims
  - **Secret Key**: `MY@@TEST` for token signing and verification
- **Token operations**:
  - **Generation**: Creates tokens with user claims and expiration
  - **Parsing**: Extracts claims using JJWT parser
  - **Validation**: Checks username match and expiration status
  - **Refresh Logic**: Separate refresh token with extended expiration

</details>

<details>
<summary>🛡️ MyFilter</summary>

**Custom JWT authentication filter for request interception**

- **What it does**: Intercepts HTTP requests to validate JWT tokens and set security context
- **Code implementation**: 
  - **OncePerRequestFilter**: Ensures filter runs once per request
  - **Token Extraction**: `Authorization` header parsing with `Bearer ` prefix
  - **Token Validation**: JWT signature and expiration verification
  - **Security Context**: Sets authentication in Spring Security context
- **Filter operations**:
  - **Header Parsing**: Extracts token from `Authorization: Bearer <token>`
  - **Username Extraction**: Gets username from JWT claims
  - **User Loading**: Loads UserDetails for authentication
  - **Context Setting**: Creates UsernamePasswordAuthenticationToken
- **Security flow**:
  - **Request Interception**: Filter processes all incoming requests
  - **Token Validation**: Verifies JWT signature and expiration
  - **Authentication**: Sets Spring Security authentication context
  - **Request Continuation**: Passes request to next filter in chain

</details>

<details>
<summary>⚙️ SecuirtyConfigration</summary>

**Spring Security configuration for JWT-based authentication**

- **What it does**: Configures Spring Security to use JWT authentication instead of sessions
- **Code implementation**: 
  - **Stateless Sessions**: Disables session creation for JWT authentication
  - **Filter Integration**: Adds custom JWT filter to security chain
  - **Endpoint Security**: Configures public and protected endpoints
  - **CSRF Disabled**: Disables CSRF for stateless API authentication
- **Security configuration**:
  - **JWT Filter**: Custom filter for token validation
  - **Stateless Design**: No server-side session management
  - **Public Endpoints**: Login endpoints accessible without authentication
  - **Protected Resources**: All other endpoints require valid JWT

</details>

<details>
<summary>🎮 Controller & User</summary>

**API endpoints for authentication and protected resources**

- **What it does**: Provides login endpoint for token generation and protected resources
- **Code implementation**: 
  - **Login Endpoint**: Authenticates user and returns JWT tokens
  - **Protected Endpoints**: Requires valid JWT for access
  - **Token Response**: Returns both access and refresh tokens
  - **User Model**: Simple user representation for authentication
- **API features**:
  - **Authentication**: POST /login with credentials
  - **Token Generation**: Returns JWT access and refresh tokens
  - **Protected Access**: Secured endpoints requiring valid tokens
  - **Error Handling**: Proper error responses for invalid credentials

</details>

## 🌟 JWT Security Features

### 🔑 Token Management
- **Signed Tokens**: HMAC SHA-512 signature for token integrity
- **Custom Expiration**: Short-lived access tokens with refresh capability
- **Claims Security**: User information embedded in signed tokens
- **Secret Key Protection**: Server-side secret for token verification

### 🛡️ Stateless Authentication
- **No Sessions**: Eliminates server-side session storage
- **Scalable Design**: Tokens contain all necessary authentication information
- **Distributed Systems**: Tokens work across multiple server instances
- **Mobile Friendly**: Perfect for mobile app authentication

### 🔄 Token Lifecycle
- **Generation**: Create tokens on successful authentication
- **Transmission**: Bearer token in Authorization header
- **Validation**: Verify signature and expiration on each request
- **Refresh**: Extended sessions with refresh token mechanism

### 🔍 Security Benefits
- **Tamper Proof**: Signed tokens prevent unauthorized modification
- **Expiration Control**: Time-limited tokens reduce security risks
- **Stateless Security**: No server-side session vulnerabilities
- **Cross-Domain**: Tokens work across different domains and services

## 🚀 JWT Authentication Flow
1. **Login**: User submits credentials to `/login` endpoint
2. **Validation**: Server validates credentials against user store
3. **Token Generation**: JWTUtility creates signed access and refresh tokens
4. **Token Response**: Client receives JWT tokens in response
5. **Request Authentication**: Client sends token in `Authorization: Bearer <token>` header
6. **Filter Processing**: MyFilter extracts and validates token
7. **Security Context**: Valid token sets Spring Security authentication
8. **Resource Access**: Authenticated user accesses protected resources
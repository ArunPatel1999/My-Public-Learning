# Oauth2-Server-1

> **🔐 Multi-Grant OAuth2 Server**: OAuth2 authorization server supporting multiple grant types including password, client credentials, and authorization code flows.

## 🎯 Key OAuth2 Operations Implemented

**In this project, I performed the following operations:**

1) **Multiple Grant Types** - Password, client credentials, and authorization code flows
2) **Multi-Client Support** - Three different OAuth2 clients with different configurations
3) **Token Validation** - Authenticated token checking endpoint
4) **Access Token Validity** - Custom token expiration configuration
5) **Redirect URI Support** - Authorization code flow with redirect handling
6) **Form-Based Authentication** - Web form login for authorization code flow
7) **Client Secret Encoding** - BCrypt-encoded client secrets for security

## 🎯 What This Project Does

**Comprehensive OAuth2 authorization server supporting multiple grant types and client configurations for different use cases.**

### Core Functionality:
- 🔐 **Multi-Grant Support**: Password, client credentials, and authorization code flows
- 👥 **Multiple Clients**: Different client configurations for various scenarios
- 🎫 **Token Management**: Custom token validity and refresh token support
- 🌐 **Web Integration**: Form-based login for authorization code flow
- 🔒 **Security Configuration**: Authenticated token checking and client validation
- 🔄 **Refresh Tokens**: Long-lived token refresh capabilities

## 🛠️ Technology Stack

- **Spring Security OAuth2**: Multi-grant OAuth2 authorization server
- **BCryptPasswordEncoder**: Client and user password encoding
- **InMemoryUserDetailsManager**: User management for testing
- **Form-Based Authentication**: Web login for authorization code flow
- **AuthenticationManager**: Authentication management integration
- **Multiple Grant Types**: Password, client credentials, authorization code

## 📚 Learning Objectives

### OAuth2 Grant Types
- **Password Grant**: Direct user credential exchange for tokens
- **Client Credentials**: Service-to-service authentication
- **Authorization Code**: Web-based authorization with redirects
- **Refresh Tokens**: Token renewal mechanisms

### Multi-Client Architecture
- **Client Differentiation**: Different clients for different use cases
- **Grant Type Selection**: Appropriate grant type per client
- **Security Configuration**: Client-specific security settings
- **Redirect Handling**: Authorization code flow redirect management

---

## 📂 Core Components

<details>
<summary>🔐 MyOAuthServer</summary>

**Multi-grant OAuth2 authorization server with three client configurations**

- **What it does**: Configures OAuth2 server supporting multiple grant types and clients
- **Code implementation**: 
  - **Authorization Server**: `@EnableAuthorizationServer` with multiple client support
  - **Client 1 (page1)**: Password grant with refresh tokens and custom validity
  - **Client 2 (page2)**: Authorization code grant with redirect URI
  - **Client 3 (page3)**: Client credentials grant for service authentication
- **Grant type configurations**:
  - **Password Grant**: `grant_type=password&username=admin1&password=admin1&scope=read`
  - **Authorization Code**: `grant_type=authorization_code&code=861h8F&scope=read`
  - **Client Credentials**: Service-to-service authentication without user context
- **Client features**:
  - **page1**: 450000 seconds token validity, password + refresh_token grants
  - **page2**: Authorization code grant with redirect to `https://localhost:9090`
  - **page3**: Client credentials grant for automated service access
- **Security configuration**:
  - **Token Checking**: `checkTokenAccess("isAuthenticated()")` for token validation
  - **Password Encoding**: BCrypt-encoded client secrets
  - **Authentication Manager**: Integration with Spring Security authentication

</details>

<details>
<summary>🌐 MyWebSecuirty</summary>

**Web security configuration supporting form-based authentication**

- **What it does**: Configures web security with form login and user management
- **Code implementation**: 
  - **Form Login**: `http.formLogin()` for web-based authentication
  - **User Management**: InMemoryUserDetailsManager with test users
  - **Authentication Manager**: Exposed as bean for OAuth2 integration
  - **Password Encoding**: BCryptPasswordEncoder for secure password storage
- **User configuration**:
  - **admin1/admin1**: First test user with "read" authority
  - **admin2/admin2**: Second test user with "read" authority
  - **BCrypt Encoding**: Secure password storage with salt
  - **Authority Management**: Role-based access control
- **Web security**:
  - **Form Authentication**: Web form login for authorization code flow
  - **Protected Resources**: All requests require authentication
  - **Authentication Manager**: Available for OAuth2 server integration
  - **Password Security**: BCrypt password encoding throughout

</details>

## 🌟 OAuth2 Grant Type Features

### 🔐 Password Grant (page1)
- **Direct Authentication**: Username/password exchange for tokens
- **Refresh Tokens**: Long-lived refresh token support
- **Custom Validity**: 450000 seconds (125 hours) token lifetime
- **Use Case**: Mobile apps and trusted clients

### 🌐 Authorization Code Grant (page2)
- **Web-Based Flow**: Browser-based authorization with redirects
- **Redirect URI**: `https://localhost:9090` for callback handling
- **Form Login**: Web form authentication for user consent
- **Use Case**: Web applications and third-party integrations

### 🔧 Client Credentials Grant (page3)
- **Service Authentication**: Machine-to-machine authentication
- **No User Context**: Service-level access without user involvement
- **Automated Access**: Perfect for backend service integration
- **Use Case**: API-to-API communication and automated systems

## 🚀 OAuth2 Flows

### Password Grant Flow
1. **Client Request**: POST `/oauth/token?grant_type=password&username=admin1&password=admin1&scope=read`
2. **Basic Auth**: Client credentials (page1:page1) in Authorization header
3. **User Validation**: Server validates user credentials
4. **Token Generation**: Returns access and refresh tokens
5. **API Access**: Client uses access token for protected resources

### Authorization Code Flow
1. **Authorization Request**: GET `/oauth/authorize?client_id=page2&response_type=code&redirect_uri=https://localhost:9090`
2. **User Login**: User authenticates via form login
3. **Authorization Code**: Server redirects with authorization code
4. **Token Exchange**: POST `/oauth/token?grant_type=authorization_code&code=861h8F&scope=read`
5. **Access Token**: Client receives access token for API calls

### Client Credentials Flow
1. **Client Request**: POST `/oauth/token?grant_type=client_credentials&scope=read`
2. **Client Auth**: Basic authentication with page3:page3 credentials
3. **Service Token**: Server returns access token for service access
4. **API Access**: Service uses token for automated API calls

## 📡 API Endpoints
- **Token Endpoint**: `POST /oauth/token` - Generate tokens for all grant types
- **Authorization Endpoint**: `GET /oauth/authorize` - Authorization code flow initiation
- **Check Token**: `POST /oauth/check_token` - Validate token (requires authentication)

## 🔧 Client Configurations
- **page1**: Password + refresh token grants, 125-hour token validity
- **page2**: Authorization code grant with redirect URI
- **page3**: Client credentials grant for service authentication
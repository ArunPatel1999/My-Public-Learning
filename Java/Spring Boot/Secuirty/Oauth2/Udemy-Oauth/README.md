# Udemy-Oauth

> **🌐 OAuth2 Authorization Server**: Complete OAuth2 authorization server implementation with JWT tokens, keystore security, and client management.

## 🎯 Key OAuth2 Operations Implemented

**In this project, I performed the following operations:**

1) **OAuth2 Authorization Server** - Complete authorization server setup
2) **JWT Token Management** - JWT-based access and refresh tokens
3) **Keystore Security** - JKS keystore for token signing and verification
4) **Client Registration** - In-memory OAuth2 client configuration
5) **Grant Type Support** - Password and refresh_token grant types
6) **Scope Management** - Read and write scope configuration
7) **User Management** - In-memory user details service with roles

## 🎯 What This Project Does

**Full-featured OAuth2 authorization server with JWT token support, keystore-based security, and comprehensive client management.**

### Core Functionality:
- 🌐 **Authorization Server**: Complete OAuth2 authorization server implementation
- 🔑 **JWT Tokens**: Signed JWT access and refresh tokens
- 🔐 **Keystore Security**: JKS keystore for token signing and verification
- 👥 **Client Management**: OAuth2 client registration and configuration
- 🎫 **Grant Types**: Password and refresh token grant type support
- 🛡️ **Scope Control**: Fine-grained access scope management

## 🛠️ Technology Stack

- **Spring Security OAuth2**: OAuth2 authorization server framework
- **JWT (JSON Web Tokens)**: Stateless token implementation
- **JKS Keystore**: Java keystore for cryptographic operations
- **BCryptPasswordEncoder**: Password hashing for clients and users
- **InMemoryUserDetailsManager**: User management for testing
- **AuthorizationServerConfigurerAdapter**: OAuth2 server configuration

## 📚 Learning Objectives

### OAuth2 Fundamentals
- **Authorization Server**: OAuth2 server setup and configuration
- **Token Management**: JWT token generation and validation
- **Client Registration**: OAuth2 client configuration and management
- **Grant Types**: Different OAuth2 flow implementations

### Advanced Security Features
- **Keystore Integration**: Cryptographic key management
- **Token Signing**: JWT token signing and verification
- **Scope Management**: Access control through OAuth2 scopes
- **Refresh Tokens**: Long-lived token refresh mechanisms

---

## 📂 Core Components

<details>
<summary>🌐 AutoraztionServerConfi</summary>

**Complete OAuth2 authorization server configuration with JWT and keystore integration**

- **What it does**: Configures OAuth2 authorization server with JWT tokens and keystore-based security
- **Code implementation**: 
  - **Authorization Server**: `@EnableAuthorizationServer` with `AuthorizationServerConfigurerAdapter`
  - **JWT Token Store**: `JwtTokenStore` with `JwtAccessTokenConverter`
  - **Keystore Integration**: `KeyStoreKeyFactory` with "jwtiscool.jks" keystore
  - **Client Configuration**: In-memory client "app1" with password grant type
- **OAuth2 configuration**:
  - **Endpoints**: `tokenStore()`, `accessTokenConverter()`, `authenticationManager`
  - **Client Details**: Client ID "app1" with encoded secret and scopes
  - **Grant Types**: "password" and "refresh_token" support
  - **Resource ID**: "name" resource identifier for token validation
- **JWT features**:
  - **Token Store**: JwtTokenStore for stateless token management
  - **Access Token Converter**: JwtAccessTokenConverter for token creation
  - **Keystore Security**: KeyStoreKeyFactory for cryptographic operations
  - **Key Pair**: Public/private key pair for token signing and verification
- **Security configuration**:
  - **Token Key Access**: `permitAll()` for token key endpoint access
  - **Client Secret**: BCrypt-encoded client secret for security
  - **Scopes**: "read" and "writer" scopes for access control
  - **Resource Protection**: Resource ID for token-to-resource mapping

</details>

<details>
<summary>🔐 SecuirtyConfig</summary>

**Security configuration with user management and authentication setup**

- **What it does**: Configures Spring Security with user management and authentication for OAuth2
- **Code implementation**: 
  - **WebSecurityConfigurerAdapter**: Base security configuration
  - **AuthenticationManager Bean**: Exposed for OAuth2 integration
  - **UserDetailsService**: In-memory user management with roles
  - **Password Encoder**: BCryptPasswordEncoder for secure password storage
- **User management**:
  - **In-Memory Users**: InMemoryUserDetailsManager for testing
  - **User Roles**: "USER" and "ADMIN" authorities
  - **Password Encoding**: BCrypt-encoded passwords for security
  - **Test Users**: "user/user" and "admin/admin" credentials
- **Authentication setup**:
  - **Authentication Manager**: Exposed as bean for OAuth2 integration
  - **Password Security**: BCryptPasswordEncoder for password hashing
  - **User Details**: Proper user details service configuration
  - **Authority Management**: Role-based access control setup

</details>

## 🌟 OAuth2 Security Features

### 🌐 Authorization Server
- **Complete OAuth2 Server**: Full authorization server implementation
- **Token Endpoints**: `/oauth/token` for token generation
- **Client Management**: In-memory client registration and validation
- **Grant Type Support**: Password and refresh token flows

### 🔑 JWT Token Management
- **Stateless Tokens**: JWT tokens with embedded user information
- **Token Signing**: Cryptographic signing with keystore keys
- **Access Tokens**: Short-lived access tokens for API access
- **Refresh Tokens**: Long-lived tokens for token renewal

### 🔐 Keystore Security
- **JKS Keystore**: Java keystore for cryptographic operations
- **Key Pair Management**: Public/private key pair for token operations
- **Token Verification**: Cryptographic token signature verification
- **Security Standards**: Industry-standard cryptographic practices

### 🎫 Access Control
- **OAuth2 Scopes**: Fine-grained access control with scopes
- **Resource Protection**: Resource ID-based access control
- **Client Authorization**: Client-based access restrictions
- **User Authentication**: User credential validation for token generation

## 🚀 OAuth2 Flow
1. **Client Registration**: Client "app1" registered with authorization server
2. **User Authentication**: User provides credentials (user/user or admin/admin)
3. **Token Request**: Client requests token with user credentials
4. **Credential Validation**: Server validates user and client credentials
5. **JWT Generation**: Server creates signed JWT access and refresh tokens
6. **Token Response**: Client receives JWT tokens for API access
7. **API Access**: Client uses access token for protected resource access
8. **Token Refresh**: Client uses refresh token to obtain new access tokens
9. **Token Validation**: Resource servers validate JWT signature and claims

## 📡 API Endpoints
- **Token Endpoint**: `POST /oauth/token` - Generate access tokens
- **Token Key**: `GET /oauth/token_key` - Get public key for token verification
- **Check Token**: `POST /oauth/check_token` - Validate token (if enabled)

## 🔧 Configuration Files
- **Keystore**: `jwtiscool.jks` - Java keystore for token signing
- **Client Config**: In-memory client "app1" with password grant
- **User Config**: In-memory users with BCrypt-encoded passwords
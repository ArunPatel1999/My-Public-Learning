# keyclock-1-resourse-server

> **🔐 Keycloak Resource Server**: OAuth2 resource server with Keycloak integration, JWT token validation, and role-based access control.

## 🎯 Key Keycloak Operations Implemented

**In this project, I performed the following operations:**

1) **OAuth2 Resource Server** - JWT token validation and resource protection
2) **Keycloak Integration** - External identity provider integration
3) **Custom JWT Role Extraction** - Keycloak realm roles to Spring Security authorities
4) **Method-Level Security** - @PreAuthorize and @Secured annotations support
5) **Role-Based Access Control** - Fine-grained endpoint protection with roles
6) **Public Endpoint Configuration** - Selective public access without authentication
7) **JWT Authentication Converter** - Custom JWT to authorities mapping

## 🎯 What This Project Does

**OAuth2 resource server that validates Keycloak JWT tokens and enforces role-based access control with custom role extraction.**

### Core Functionality:
- 🔐 **Resource Server**: Validates JWT tokens from Keycloak authorization server
- 🎭 **Role Extraction**: Converts Keycloak realm roles to Spring Security authorities
- 🛡️ **Method Security**: Annotation-based method-level access control
- 🌐 **Selective Protection**: Mix of public and protected endpoints
- 🔑 **JWT Validation**: Automatic JWT signature and expiration validation
- ⚙️ **Custom Converter**: JWT claims to GrantedAuthority conversion

## 🛠️ Technology Stack

- **Spring Security OAuth2 Resource Server**: JWT token validation
- **Keycloak**: External OAuth2/OIDC identity provider
- **JWT Authentication Converter**: Custom token to authorities mapping
- **Method Security**: @PreAuthorize, @PostAuthorize, @Secured annotations
- **Spring Boot**: Application framework with OAuth2 auto-configuration
- **Role-Based Access Control**: Fine-grained permission management

## 📚 Learning Objectives

### OAuth2 Resource Server
- **JWT Validation**: Token signature and expiration verification
- **External Identity Provider**: Integration with Keycloak
- **Token Processing**: JWT claims extraction and validation
- **Resource Protection**: Securing endpoints with OAuth2 tokens

### Keycloak Integration
- **Realm Roles**: Keycloak role management and extraction
- **JWT Claims**: Understanding Keycloak JWT token structure
- **Authority Mapping**: Converting external roles to Spring Security authorities
- **Identity Federation**: External identity provider integration

---

## 📂 Core Components

<details>
<summary>🔐 WebSecuirtyConfigarution</summary>

**OAuth2 resource server configuration with custom JWT processing**

- **What it does**: Configures OAuth2 resource server with Keycloak JWT validation and custom role extraction
- **Code implementation**: 
  - **Method Security**: `@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)`
  - **JWT Resource Server**: `.oauth2ResourceServer().jwt()` configuration
  - **Custom Converter**: `JwtAuthenticationConverter` with `JwtGetRole` converter
  - **Role-Based Access**: `.hasRole("devloper")` for specific endpoint protection
- **Security configuration**:
  - **Public Endpoints**: `/data` endpoint accessible without authentication
  - **Role-Protected**: `/jwt` endpoint requires "devloper" role
  - **JWT Validation**: Automatic JWT signature and expiration validation
  - **Custom Authority**: JwtGetRole converter for Keycloak realm roles
- **Method security features**:
  - **@Secured**: Method-level security with role checking
  - **@PreAuthorize**: Expression-based method security
  - **@PostAuthorize**: Post-execution security checks
  - **Global Configuration**: Enabled for all controllers and services

</details>

<details>
<summary>🎭 JwtGetRole</summary>

**Custom JWT converter for Keycloak realm role extraction**

- **What it does**: Converts Keycloak JWT realm roles to Spring Security GrantedAuthority objects
- **Code implementation**: 
  - **Converter Interface**: `Converter<Jwt, Collection<GrantedAuthority>>`
  - **Realm Access**: `jwt.getClaimAsMap("realm_access")` for Keycloak roles
  - **Role Extraction**: Extracts roles from `realm_access.roles` array
  - **Authority Mapping**: Prefixes roles with "ROLE_" for Spring Security compatibility
- **Role processing**:
  - **Keycloak Structure**: Accesses `realm_access.roles` from JWT claims
  - **Null Safety**: Handles missing or empty realm_access claims
  - **Role Transformation**: Converts role strings to SimpleGrantedAuthority
  - **Spring Integration**: Compatible with Spring Security authority system
- **Authority creation**:
  - **Role Prefix**: Adds "ROLE_" prefix to match Spring Security conventions
  - **Stream Processing**: Uses Java 8 streams for role transformation
  - **Collection Return**: Returns Collection<GrantedAuthority> for security context
  - **Empty Handling**: Returns empty list when no roles found

</details>

<details>
<summary>🎮 FIrstController</summary>

**Protected resource controller demonstrating role-based access**

- **What it does**: Provides protected endpoints that require JWT authentication and specific roles
- **Code implementation**: 
  - **Protected Endpoints**: Requires valid JWT tokens for access
  - **Role Validation**: Uses roles extracted from Keycloak JWT tokens
  - **Method Security**: Can use @PreAuthorize, @Secured annotations
  - **Resource Access**: Returns protected data to authenticated users
- **Security behavior**:
  - **JWT Required**: All endpoints require valid JWT tokens
  - **Role Checking**: Validates user roles against endpoint requirements
  - **Authority Integration**: Uses authorities from JwtGetRole converter
  - **Access Control**: Fine-grained access based on Keycloak roles

</details>

## 🌟 Keycloak Integration Features

### 🔐 JWT Token Validation
- **Signature Verification**: Validates JWT signature against Keycloak public key
- **Expiration Checking**: Automatic token expiration validation
- **Issuer Validation**: Verifies token issuer matches Keycloak configuration
- **Audience Validation**: Ensures token is intended for this resource server

### 🎭 Role Management
- **Realm Roles**: Extracts roles from Keycloak realm_access claim
- **Authority Mapping**: Converts Keycloak roles to Spring Security authorities
- **Role Prefix**: Adds "ROLE_" prefix for Spring Security compatibility
- **Dynamic Roles**: Supports dynamic role assignment from Keycloak

### 🛡️ Access Control
- **Method Security**: @PreAuthorize, @PostAuthorize, @Secured support
- **Endpoint Security**: HTTP method and path-based access control
- **Role-Based**: Fine-grained access control using Keycloak roles
- **Public Access**: Selective public endpoints without authentication

### ⚙️ Configuration Benefits
- **External Identity**: Delegates authentication to Keycloak
- **Centralized Roles**: Role management in Keycloak admin console
- **Token Standards**: Standard JWT/OIDC token processing
- **Scalable Security**: Supports multiple resource servers with same identity provider

## 🚀 Authentication Flow
1. **User Login**: User authenticates with Keycloak authorization server
2. **Token Generation**: Keycloak generates JWT access token with realm roles
3. **API Request**: Client sends request with JWT token in Authorization header
4. **Token Validation**: Resource server validates JWT signature and expiration
5. **Role Extraction**: JwtGetRole extracts realm roles from JWT claims
6. **Authority Creation**: Converts roles to Spring Security GrantedAuthority objects
7. **Access Control**: Spring Security checks authorities against endpoint requirements
8. **Resource Access**: Authorized users access protected resources

## 📡 JWT Token Structure (Keycloak)
```json
{
  "realm_access": {
    "roles": ["devloper", "user", "admin"]
  },
  "sub": "user-id",
  "iss": "http://keycloak:8080/auth/realms/myrealm",
  "exp": 1640995200
}
```

## 🔧 Configuration Requirements
- **Keycloak Server**: Running Keycloak instance with configured realm
- **JWT Issuer**: Keycloak realm issuer URI in application properties
- **Public Key**: Keycloak public key for JWT signature validation
- **Client Configuration**: Resource server client in Keycloak
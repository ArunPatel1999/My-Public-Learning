# Jwt-1

<details>
<summary>Project Overview</summary>

This Spring Boot application demonstrates JWT (JSON Web Token) authentication implementation with access tokens and refresh tokens for secure API access.

</details>

<details>
<summary>JWT Implementation</summary>

**JWT Utility Service**
- Token generation with configurable expiration
- Access tokens: 2-minute expiration
- Refresh tokens: 5-minute expiration (starts after access token expires)
- HS512 algorithm for token signing
- Custom secret key for token security

**Token Features**
- Username extraction from tokens
- Expiration date validation
- Claims-based token structure
- Token validation against user details

</details>

<details>
<summary>Security Architecture</summary>

**Custom JWT Filter**
- OncePerRequestFilter implementation
- Authorization header processing
- Bearer token extraction and validation
- Security context authentication setup

**Authentication Flow**
1. Extract Bearer token from Authorization header
2. Parse username from JWT token
3. Load user details from UserService
4. Validate token against user details
5. Set authentication in SecurityContext

**Security Configuration**
- Custom security configuration
- JWT filter integration
- Protected endpoint configuration

</details>

<details>
<summary>Token Management</summary>

**Access Token**
- Short-lived (2 minutes)
- Used for API authentication
- Contains user claims and expiration

**Refresh Token**
- Longer-lived (5 minutes total, starts after access token)
- Used to obtain new access tokens
- Separate generation method

**Token Validation**
- Username matching verification
- Expiration date checking
- Signature validation with secret key

</details>

<details>
<summary>API Structure</summary>

**Controllers**
- Controller: Main API endpoints
- User: User-related operations
- Protected endpoints requiring JWT authentication

**Services**
- JWTUtility: Token generation and validation
- UserService: User details loading and management

**Configuration**
- MyFilter: JWT authentication filter
- SecurityConfiguration: Spring Security setup

</details>

<details>
<summary>Security Features</summary>

**Token Security**
- HS512 signature algorithm
- Custom secret key
- Expiration-based validation
- Bearer token format

**Authentication**
- Stateless JWT authentication
- No server-side session storage
- Token-based user identification

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot
- Spring Security
- JWT (io.jsonwebtoken)
- HS512 Algorithm
- Bearer Token Authentication

</details>
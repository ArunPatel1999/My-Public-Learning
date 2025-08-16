# Basic-Security

<details>
<summary>Project Overview</summary>

This Spring Boot application demonstrates basic Spring Security implementation with HTTP Basic Authentication and in-memory user management.

</details>

<details>
<summary>Security Configuration</summary>

**HTTP Basic Authentication**
- All requests require authentication
- Uses HTTP Basic Authentication mechanism
- Browser prompts for username/password
- Base64 encoded credentials in Authorization header

**In-Memory User Management**
- Two predefined users for testing
- User credentials stored in memory (not persistent)
- BCrypt password encoding for security

**Global Method Security**
- `@EnableGlobalMethodSecurity(prePostEnabled = true)`
- Enables method-level security annotations
- Supports @PreAuthorize and @PostAuthorize

</details>

<details>
<summary>User Accounts</summary>

**Test Users**
- **test1**: Password 'test1', Role 'USER'
- **test2**: Password 'test2', Role 'ADMIN'

**Password Encoding**
- BCryptPasswordEncoder for secure password hashing
- Passwords encrypted before storage
- Industry-standard password security

</details>

<details>
<summary>Security Features</summary>

**Authentication Requirements**
- All endpoints require authentication
- No public/anonymous access allowed
- Automatic redirect to login for unauthenticated requests

**Authorization**
- Role-based access control ready
- USER and ADMIN roles configured
- Method-level security enabled for fine-grained control

**CSRF Protection**
- CSRF protection enabled by default
- Can be disabled if needed (commented option available)

</details>

<details>
<summary>Controller Endpoints</summary>

**NormalController**
- GET `/` - Returns "Test" string
- Requires authentication to access
- Basic endpoint for testing security

**NormalController2**
- Additional controller for extended testing
- Same security requirements apply

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot
- Spring Security
- BCrypt Password Encoder
- HTTP Basic Authentication
- In-Memory Authentication

</details>
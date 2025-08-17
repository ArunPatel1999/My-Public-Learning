# CSRF-Secuirty

> **🛡️ CSRF Protection System**: Custom Cross-Site Request Forgery protection with custom token repository and validation filters.

## 🎯 Key CSRF Operations Implemented

**In this project, I performed the following operations:**

1) **Custom CSRF Token Repository** - Custom token generation and management
2) **CSRF Token Validation** - Request validation with custom tokens
3) **Custom CSRF Filter** - Token extraction and logging
4) **Form-Based Protection** - CSRF protection for form submissions
5) **Token Parameter Customization** - Custom token parameter names
6) **Filter Chain Integration** - Custom filter after CSRF filter
7) **Static Token Implementation** - Fixed token for testing purposes

## 🎯 What This Project Does

**Advanced CSRF protection implementation with custom token management and validation mechanisms.**

### Core Functionality:
- 🛡️ **CSRF Protection**: Prevents cross-site request forgery attacks
- 🔑 **Custom Token Repository**: Custom CSRF token generation and storage
- 🔍 **Token Validation**: Request validation with custom CSRF tokens
- 📝 **Form Protection**: Secure form submissions with token validation
- 🔧 **Custom Filters**: Additional CSRF token processing and logging
- ⚙️ **Configuration**: Flexible CSRF protection configuration

## 🛠️ Technology Stack

- **Spring Security**: CSRF protection framework
- **CsrfTokenRepository**: Custom token repository interface
- **OncePerRequestFilter**: Custom filter implementation
- **Form-Based Authentication**: Login forms with CSRF protection
- **DefaultCsrfToken**: Spring Security CSRF token implementation
- **Filter Chain**: Security filter integration

## 📚 Learning Objectives

### CSRF Protection Fundamentals
- **Attack Prevention**: Understanding CSRF attack vectors
- **Token-Based Protection**: CSRF token generation and validation
- **Custom Implementation**: Building custom CSRF protection mechanisms
- **Filter Integration**: Custom filters in Spring Security chain

### Advanced CSRF Patterns
- **Custom Repositories**: Implementing CsrfTokenRepository interface
- **Token Management**: Custom token generation and storage strategies
- **Filter Processing**: Request interception and token validation
- **Form Integration**: CSRF protection in web forms

---

## 📂 Core Components

<details>
<summary>🛡️ MyCustomeCSRF</summary>

**Custom CSRF token repository implementation**

- **What it does**: Implements custom CSRF token generation and management
- **Code implementation**: 
  - **CsrfTokenRepository Interface**: Implements Spring Security CSRF repository contract
  - **Token Generation**: `generateToken()` creates DefaultCsrfToken with custom parameters
  - **Static Token**: Fixed token "123456789ABC" for testing purposes
  - **Custom Parameters**: "X-CSRF-TOKEN" header and "_arun" parameter name
- **CSRF features**:
  - **Custom Token**: Static token for consistent testing
  - **Header Name**: "X-CSRF-TOKEN" for token transmission
  - **Parameter Name**: "_arun" for form parameter identification
  - **Repository Methods**: generateToken(), saveToken(), loadToken() implementations
- **Token structure**:
  - **Header Name**: X-CSRF-TOKEN for HTTP header transmission
  - **Parameter Name**: _arun for form field identification
  - **Token Value**: 123456789ABC static token for testing
  - **DefaultCsrfToken**: Spring Security token implementation

</details>

<details>
<summary>🔧 MyBasicSecuirtyConfig</summary>

**Security configuration with custom CSRF protection**

- **What it does**: Configures Spring Security with custom CSRF token repository and filters
- **Code implementation**: 
  - **CSRF Configuration**: `csrf.csrfTokenRepository(new MyCustomeCSRF())`
  - **Custom Filter**: `addFilterAfter(myCustomeCSRF, CsrfFilter.class)`
  - **Form Login**: Form-based authentication with CSRF protection
  - **In-Memory Users**: Test users with BCrypt password encoding
- **Security configuration**:
  - **CSRF Repository**: Custom token repository integration
  - **Filter Chain**: Custom filter after built-in CSRF filter
  - **Form Authentication**: Login forms with CSRF token validation
  - **User Management**: In-memory users for testing
- **Protection flow**:
  - **Token Generation**: Custom repository generates CSRF tokens
  - **Form Integration**: Tokens embedded in login and other forms
  - **Validation**: Spring Security validates tokens on form submission
  - **Custom Processing**: Additional filter processes tokens

</details>

<details>
<summary>🔍 MyCustomFilter</summary>

**Custom filter for CSRF token processing and logging**

- **What it does**: Processes CSRF tokens and provides logging for debugging
- **Code implementation**: 
  - **OncePerRequestFilter**: Ensures filter runs once per request
  - **Token Extraction**: `request.getAttribute("_arun")` gets CSRF token
  - **Token Logging**: Prints parameter name and token value
  - **Filter Chain**: Continues request processing after logging
- **Filter operations**:
  - **Token Access**: Retrieves CSRF token from request attributes
  - **Debug Logging**: Outputs token information for debugging
  - **Request Processing**: Continues filter chain execution
  - **Token Inspection**: Examines token structure and values
- **Debugging features**:
  - **Parameter Name**: Logs CSRF token parameter name
  - **Token Value**: Logs actual token value for verification
  - **Request Flow**: Tracks token presence in request processing
  - **Filter Position**: Runs after CSRF filter for token inspection

</details>

<details>
<summary>🎮 NormalController</summary>

**Controller with CSRF-protected endpoints**

- **What it does**: Provides GET and POST endpoints with CSRF protection
- **Code implementation**: 
  - **GET Endpoint**: `@GetMapping` for displaying forms
  - **POST Endpoint**: `@PostMapping("/save")` for form submissions
  - **CSRF Protection**: All POST requests require valid CSRF tokens
  - **Data Processing**: Handles form data with CSRF validation
- **Endpoint behavior**:
  - **GET Requests**: Display forms with embedded CSRF tokens
  - **POST Requests**: Validate CSRF tokens before processing
  - **Form Handling**: Process form data after CSRF validation
  - **Security Integration**: Automatic CSRF protection for state-changing operations

</details>

## 🌟 CSRF Security Features

### 🛡️ Attack Prevention
- **CSRF Protection**: Prevents unauthorized cross-site requests
- **Token Validation**: Validates tokens on all state-changing operations
- **Form Security**: Protects form submissions from CSRF attacks
- **Request Verification**: Ensures requests originate from legitimate sources

### 🔑 Custom Token Management
- **Custom Repository**: Implements CsrfTokenRepository for token control
- **Static Tokens**: Fixed tokens for testing and development
- **Parameter Customization**: Custom token parameter and header names
- **Token Generation**: Controlled token creation and management

### 🔍 Debug and Monitoring
- **Token Logging**: Debug output for token verification
- **Filter Processing**: Custom filter for token inspection
- **Request Tracking**: Monitor CSRF token flow through requests
- **Development Support**: Enhanced debugging for CSRF implementation

### ⚙️ Configuration Benefits
- **Flexible Setup**: Custom CSRF configuration options
- **Filter Integration**: Seamless integration with Spring Security filters
- **Form Integration**: Automatic token embedding in forms
- **Testing Support**: Static tokens for consistent testing

## 🚀 CSRF Protection Flow
1. **Form Request**: User requests form page (GET request)
2. **Token Generation**: MyCustomeCSRF generates CSRF token
3. **Token Embedding**: Spring Security embeds token in form
4. **Form Submission**: User submits form with CSRF token (POST request)
5. **Token Validation**: Spring Security validates CSRF token
6. **Custom Processing**: MyCustomFilter logs token information
7. **Request Processing**: Valid requests proceed to controller
8. **Attack Prevention**: Invalid tokens result in 403 Forbidden response
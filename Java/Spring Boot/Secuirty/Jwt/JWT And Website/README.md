# JWT And Website

> **🌐 JWT Web Integration**: Full-stack JWT authentication with web interface, REST API, and comprehensive user management system.

## 🎯 Key Web Integration Operations Implemented

**In this project, I performed the following operations:**

1) **Dual Interface Support** - Web UI and REST API with same JWT authentication
2) **Thymeleaf Integration** - Server-side templates with JWT authentication
3) **User Management System** - Complete CRUD operations via web and API
4) **Form-Based Authentication** - HTML forms with JWT token integration
5) **REST API Endpoints** - Full REST API with JWT protection
6) **Web Controller Pattern** - MVC pattern with redirect and flash attributes
7) **Unified User Service** - Single service layer for web and API operations

## 🎯 What This Project Does

**Full-stack web application combining JWT authentication with traditional web interface and modern REST API.**

### Core Functionality:
- 🌐 **Web Interface**: Thymeleaf templates with form-based user interaction
- 📡 **REST API**: Complete REST endpoints with JWT authentication
- 👤 **User Management**: Full CRUD operations via both web and API
- 🔐 **JWT Integration**: JWT authentication for both web and API access
- 📝 **Form Processing**: HTML forms with server-side processing
- 🔄 **Dual Access**: Same functionality accessible via web UI and REST API

## 🛠️ Technology Stack

- **Thymeleaf**: Server-side template engine for web UI
- **Spring MVC**: Web framework for form processing and redirects
- **JWT Authentication**: Token-based security for API access
- **REST Controllers**: RESTful API endpoints
- **Web Controllers**: Traditional MVC controllers for web pages
- **Flash Attributes**: User feedback via redirect attributes

## 📚 Learning Objectives

### Full-Stack Integration
- **Web and API**: Combining traditional web interface with modern REST API
- **JWT in Web**: Using JWT authentication in web applications
- **Template Integration**: Server-side templates with authentication
- **Dual Interface**: Same backend serving both web and API clients

### Web Development Patterns
- **MVC Pattern**: Model-View-Controller architecture
- **Form Processing**: HTML form handling and validation
- **Redirect Patterns**: Post-redirect-get pattern with flash attributes
- **Template Rendering**: Server-side template rendering with data binding

---

## 📂 Core Components

<details>
<summary>🌐 UserWebController</summary>

**MVC controller handling web interface and form processing**

- **What it does**: Manages web pages, form processing, and user interactions via HTML interface
- **Code implementation**: 
  - **Template Rendering**: Returns Thymeleaf template names for view rendering
  - **Form Processing**: `@PostMapping` for form submission handling
  - **Model Attributes**: Populates model with data for template rendering
  - **Redirect Handling**: Uses RedirectView with flash attributes for user feedback
- **Web endpoints**:
  - **GET /**: Login page rendering
  - **POST /login**: Form-based login processing
  - **GET /web**: User list and form page
  - **GET /web/{id}**: Edit user form with pre-populated data
  - **POST /**: User creation and update via form submission
  - **GET /delete/{id}**: User deletion with redirect feedback
- **MVC features**:
  - **Model Binding**: `@ModelAttribute User user` for form data binding
  - **Path Variables**: `@PathVariable Optional<Integer> id` for flexible routing
  - **Flash Attributes**: `redirectAttributes.addFlashAttribute()` for user messages
  - **Template Data**: Model population for Thymeleaf template rendering
- **User experience**:
  - **Form Validation**: Server-side form processing and validation
  - **User Feedback**: Flash messages for operation success/failure
  - **Navigation**: Proper redirects after form submissions
  - **Data Binding**: Automatic form data to object binding

</details>

<details>
<summary>📡 UserRestController</summary>

**REST API controller providing JSON-based user operations**

- **What it does**: Provides RESTful API endpoints for user management with JWT authentication
- **Code implementation**: 
  - **REST Endpoints**: Standard REST operations (GET, POST, PUT, DELETE)
  - **JSON Processing**: `@RequestBody` and automatic JSON response serialization
  - **Path Variables**: RESTful URL patterns for resource identification
  - **Service Integration**: Delegates to UserService for business logic
- **API endpoints**:
  - **GET /api/user**: Retrieve all users as JSON array
  - **GET /api/user/{id}**: Retrieve specific user by ID
  - **POST /api/user**: Create new user from JSON request body
  - **POST /api/user/{id}**: Update existing user with JSON data
  - **DELETE /api/user/{id}**: Delete user by ID
- **REST features**:
  - **JSON Communication**: Automatic JSON request/response handling
  - **HTTP Methods**: Proper HTTP method usage for different operations
  - **Resource Identification**: RESTful URL patterns with path variables
  - **Error Handling**: Exception propagation for proper HTTP status codes
- **API design**:
  - **Stateless**: JWT-based authentication for stateless API access
  - **Resource-Oriented**: RESTful resource design patterns
  - **Content Negotiation**: JSON content type handling
  - **Standard Responses**: Consistent JSON response format

</details>

<details>
<summary>📝 Login Template (Login.html)</summary>

**HTML form template for user authentication**

- **What it does**: Provides HTML form interface for user login with class-based authentication
- **Code implementation**: 
  - **HTML Form**: Standard HTML form with POST method
  - **Form Fields**: Class, username, and password input fields
  - **Form Action**: Posts to "/login" endpoint for processing
  - **Simple Design**: Basic HTML without styling for demonstration
- **Form features**:
  - **Class Field**: Additional "class" field for user type identification
  - **Username/Password**: Standard authentication credentials
  - **Form Submission**: POST method for secure credential transmission
  - **Server Processing**: Form data processed by UserWebController
- **Integration**:
  - **Thymeleaf Ready**: Template structure compatible with Thymeleaf processing
  - **MVC Integration**: Works with Spring MVC form processing
  - **Authentication Flow**: Integrates with JWT authentication system

</details>

<details>
<summary>👤 User Entity & Service</summary>

**User management with unified service layer for web and API**

- **What it does**: Provides user entity and service layer supporting both web and API operations
- **Code implementation**: 
  - **User Entity**: JPA entity with user fields and database mapping
  - **UserService**: Service interface defining user operations
  - **UserServiceImpl**: Service implementation with business logic
  - **UserRepository**: Data access layer for user persistence
- **Service operations**:
  - **CRUD Operations**: Create, read, update, delete user operations
  - **Unified Interface**: Same service methods used by web and API controllers
  - **Exception Handling**: Custom exceptions for error management
  - **Data Validation**: Business logic validation in service layer
- **Integration benefits**:
  - **Code Reuse**: Single service layer for multiple interfaces
  - **Consistency**: Same business logic for web and API operations
  - **Maintainability**: Centralized user management logic
  - **Testability**: Service layer can be tested independently

</details>

## 🌟 Full-Stack Integration Features

### 🌐 Dual Interface Support
- **Web Interface**: Traditional HTML forms with server-side processing
- **REST API**: Modern JSON-based API for programmatic access
- **Unified Backend**: Same service layer supporting both interfaces
- **JWT Authentication**: Token-based security for both web and API

### 📝 Web Development Patterns
- **MVC Architecture**: Clean separation of concerns with Spring MVC
- **Template Rendering**: Server-side template processing with Thymeleaf
- **Form Processing**: HTML form handling with data binding
- **Redirect Patterns**: Post-redirect-get pattern with user feedback

### 📡 API Development
- **RESTful Design**: Standard REST patterns and HTTP methods
- **JSON Communication**: Automatic JSON serialization/deserialization
- **Stateless Authentication**: JWT tokens for API access
- **Resource-Oriented**: RESTful URL patterns and resource identification

### 🔄 User Experience
- **Flash Messages**: User feedback via redirect attributes
- **Form Validation**: Server-side form processing and validation
- **Navigation**: Proper redirects and page flow
- **Data Binding**: Automatic form data to object mapping

## 🚀 Application Flow

### Web Interface Flow
1. **Login Page**: User accesses login form at root URL
2. **Form Submission**: User submits credentials via HTML form
3. **Authentication**: Server processes login and generates JWT
4. **User Management**: User accesses CRUD operations via web forms
5. **Form Processing**: Server processes forms and redirects with feedback
6. **Template Rendering**: Thymeleaf renders pages with user data

### API Flow
1. **Authentication**: Client authenticates via JWT endpoints
2. **Token Usage**: Client includes JWT in Authorization header
3. **API Requests**: Client makes REST API calls with JSON data
4. **Service Processing**: Same service layer processes requests
5. **JSON Response**: Server returns JSON responses
6. **Stateless Access**: No server-side session management

## 📡 Endpoints Summary
### Web Endpoints
- **GET /**: Login page
- **POST /login**: Form-based login
- **GET /web**: User management page
- **POST /**: User creation/update
- **GET /delete/{id}**: User deletion

### API Endpoints
- **GET /api/user**: Get all users
- **GET /api/user/{id}**: Get user by ID
- **POST /api/user**: Create user
- **POST /api/user/{id}**: Update user
- **DELETE /api/user/{id}**: Delete user

## 🔧 Integration Benefits
- **Code Reuse**: Single service layer for multiple interfaces
- **Flexibility**: Clients can choose web or API access
- **Consistency**: Same business logic across interfaces
- **Scalability**: API supports mobile and third-party integrations
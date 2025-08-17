# keyclock-thymleafe-oauth2

> **🌐 Keycloak OAuth2 Client**: Web application with Keycloak OAuth2 integration, token management, and external API calls using access tokens.

## 🎯 Key OAuth2 Client Operations Implemented

**In this project, I performed the following operations:**

1) **OAuth2 Client Integration** - Keycloak OAuth2/OIDC client configuration
2) **Token Management** - Access token and ID token extraction and usage
3) **External API Calls** - Using access tokens for protected resource access
4) **OIDC User Integration** - OpenID Connect user information handling
5) **Thymeleaf Template Integration** - Web UI with OAuth2 authentication
6) **RestTemplate Token Propagation** - Bearer token authentication for API calls
7) **OAuth2AuthorizedClient Service** - Token management and client service integration

## 🎯 What This Project Does

**Web application that integrates with Keycloak for OAuth2 authentication and uses access tokens to call external protected APIs.**

### Core Functionality:
- 🌐 **OAuth2 Client**: Complete OAuth2/OIDC client integration with Keycloak
- 🔑 **Token Management**: Access token and ID token extraction and usage
- 📡 **API Integration**: External API calls using OAuth2 access tokens
- 🎨 **Web Interface**: Thymeleaf templates with OAuth2 authentication
- 👤 **User Information**: OIDC user profile and token information display
- 🔄 **Token Propagation**: Automatic token forwarding to external services

## 🛠️ Technology Stack

- **Spring Security OAuth2 Client**: OAuth2/OIDC client implementation
- **Keycloak**: External OAuth2/OIDC identity provider
- **Thymeleaf**: Template engine for web UI
- **RestTemplate**: HTTP client for external API calls
- **OIDC (OpenID Connect)**: Identity layer on top of OAuth2
- **OAuth2AuthorizedClientService**: Token management service

## 📚 Learning Objectives

### OAuth2 Client Integration
- **Authorization Code Flow**: Web-based OAuth2 authorization flow
- **Token Management**: Access token and refresh token handling
- **OIDC Integration**: OpenID Connect user information processing
- **External API Calls**: Using OAuth2 tokens for API authentication

### Keycloak Integration
- **Client Configuration**: OAuth2 client setup in Keycloak
- **Token Extraction**: Access token and ID token retrieval
- **User Profile**: OIDC user information and claims processing
- **Token Propagation**: Forwarding tokens to external services

---

## 📂 Core Components

<details>
<summary>🌐 NormalControllere</summary>

**Main controller handling OAuth2 authentication and external API integration**

- **What it does**: Manages OAuth2 authentication flow and demonstrates token usage for external API calls
- **Code implementation**: 
  - **OAuth2 Integration**: `@AuthenticationPrincipal OidcUser` for user information
  - **Token Extraction**: `OAuth2AuthorizedClientService` for access token retrieval
  - **External API Calls**: `RestTemplate` with Bearer token authentication
  - **Thymeleaf Integration**: Model attributes for web UI display
- **Authentication features**:
  - **OIDC User**: `OidcUser principel` provides user profile information
  - **Token Service**: `OAuth2AuthorizedClientService` manages client tokens
  - **Security Context**: `SecurityContextHolder` for authentication details
  - **Token Extraction**: Access token and ID token retrieval from authorized client
- **API integration**:
  - **Bearer Authentication**: `headers.setBearerAuth(jwtToken)` for API calls
  - **RestTemplate**: HTTP client for external service communication
  - **Token Propagation**: Forwards OAuth2 access token to external APIs
  - **Response Handling**: Processes API responses and displays in UI
- **Web endpoints**:
  - **GET /**: Basic page without authentication
  - **GET /all**: Protected page with OAuth2 authentication and API calls
  - **Token Display**: Shows access token and ID token information
  - **API Data**: Displays data from external protected API

</details>

<details>
<summary>📡 RestControllete</summary>

**REST controller providing API endpoints for external consumption**

- **What it does**: Provides REST API endpoints that can be called by other services
- **Code implementation**: 
  - **REST Endpoint**: `@GetMapping("/getManyData")` for JSON data
  - **Mock Data**: Returns hardcoded JSON user data for demonstration
  - **API Response**: Structured JSON response with user information
- **API features**:
  - **JSON Response**: Returns structured user data in JSON format
  - **Mock Data**: Hardcoded user information for testing purposes
  - **REST Interface**: Standard REST API endpoint design
  - **External Access**: Can be called by other services with proper authentication

</details>

## 🌟 OAuth2 Client Features

### 🌐 Authorization Code Flow
- **Web-Based Authentication**: Browser-based OAuth2 authorization flow
- **Keycloak Integration**: Redirects to Keycloak for user authentication
- **Authorization Code**: Receives authorization code from Keycloak
- **Token Exchange**: Exchanges authorization code for access and ID tokens

### 🔑 Token Management
- **Access Token**: JWT access token for API authentication
- **ID Token**: OIDC ID token with user profile information
- **Token Extraction**: Retrieves tokens from OAuth2AuthorizedClientService
- **Token Usage**: Uses access tokens for external API authentication

### 📡 External API Integration
- **Bearer Authentication**: Uses access tokens in Authorization header
- **RestTemplate**: HTTP client for external service calls
- **Token Propagation**: Forwards OAuth2 tokens to downstream services
- **API Response**: Processes and displays external API responses

### 🎨 Web Interface
- **Thymeleaf Templates**: Server-side template rendering
- **OAuth2 Integration**: Authentication-aware web pages
- **User Information**: Displays OIDC user profile information
- **Token Display**: Shows access token and ID token details

## 🚀 OAuth2 Flow
1. **User Access**: User accesses protected web page
2. **Authentication Check**: Spring Security checks for authentication
3. **Keycloak Redirect**: Redirects to Keycloak for authentication
4. **User Login**: User authenticates with Keycloak
5. **Authorization Code**: Keycloak returns authorization code
6. **Token Exchange**: Application exchanges code for tokens
7. **Token Storage**: OAuth2AuthorizedClientService stores tokens
8. **API Calls**: Application uses access token for external API calls
9. **Response Display**: Web page displays user info and API data

## 📊 Token Information Display
- **Access Token**: JWT access token value and claims
- **ID Token**: OIDC ID token with user profile information
- **User Profile**: Username, email, roles from OIDC user
- **API Response**: Data retrieved from external protected API

## 🔧 Configuration Requirements
- **Keycloak Client**: OAuth2 client configured in Keycloak realm
- **Redirect URI**: Callback URL configured in Keycloak client
- **Client Credentials**: Client ID and secret for OAuth2 flow
- **Scope Configuration**: OpenID Connect scopes for user information

## 📡 External API Integration
- **Protected Resource**: Calls external API at `http://localhost:8081/check`
- **Bearer Token**: Uses OAuth2 access token for authentication
- **RestTemplate**: HTTP client with token propagation
- **Response Processing**: Displays API response in web interface
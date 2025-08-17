# KeyClock Integration Projects

## 🎯 What This Does

**Comprehensive Keycloak integration demonstrating OAuth2/OIDC patterns with microservices architecture, API gateway, and web applications.**

### Core Keycloak Technologies:
- 🔐 **Resource Server**: JWT token validation and role-based access control
- 🌐 **OAuth2 Client**: Web application with Keycloak authentication
- 🚪 **API Gateway**: Centralized authentication and routing
- 🔍 **Service Discovery**: Netflix Eureka with Keycloak integration

## 📋 Project Overview

| Project | Type | Key Technologies |
|---------|------|------------------|
| 🔐 [keyclock-1-resourse-server](keyclock-1-resourse-server/) | Resource Server | JWT validation, Role extraction, Method security |
| 🌐 [keyclock-thymleafe-oauth2](keyclock-thymleafe-oauth2/) | OAuth2 Client | Web authentication, Token management, API calls |
| 🚪 [Keyclock-1-Api-getway](Keyclock-1-Api-getway/) | API Gateway | Centralized auth, Request routing |
| 🔍 [keyclock-1-Netflix-Descovery](keyclock-1-Netflix-Descovery/) | Service Discovery | Eureka server, Service registration |

---

<details>
<summary>📂 Projects</summary>

- [🔐 keyclock-1-resourse-server](keyclock-1-resourse-server/)
	<details>
	<summary>OAuth2 resource server with Keycloak JWT validation</summary>

	- **What it does**: Validates Keycloak JWT tokens and enforces role-based access control
	- **Key operations**: OAuth2 resource server, Keycloak integration, custom JWT role extraction, method-level security, role-based access control, public endpoint configuration, JWT authentication converter
	- **Skills**: JWT validation, external identity provider, token processing, resource protection

	</details>

- [🌐 keyclock-thymleafe-oauth2](keyclock-thymleafe-oauth2/)
	<details>
	<summary>Web application with Keycloak OAuth2 client integration</summary>

	- **What it does**: Web application integrating with Keycloak for authentication and external API calls
	- **Key operations**: OAuth2 client integration, token management, external API calls, OIDC user integration, Thymeleaf template integration, RestTemplate token propagation, OAuth2AuthorizedClient service
	- **Skills**: Authorization code flow, token management, OIDC integration, external API calls

	</details>

- [🚪 Keyclock-1-Api-getway](Keyclock-1-Api-getway/)
	<details>
	<summary>API Gateway with Keycloak authentication</summary>

	- **What it does**: Centralized API gateway with Keycloak authentication and request routing
	- **Key tech**: Spring Cloud Gateway, Keycloak integration, Request routing, Authentication filters
	- **Skills**: API gateway patterns, centralized authentication, request routing, microservices security

	</details>

- [🔍 keyclock-1-Netflix-Descovery](keyclock-1-Netflix-Descovery/)
	<details>
	<summary>Netflix Eureka service discovery with Keycloak</summary>

	- **What it does**: Service discovery server for Keycloak-secured microservices
	- **Key tech**: Netflix Eureka, Service registration, Discovery server, Microservices architecture
	- **Skills**: Service discovery, microservices patterns, service registration, distributed systems

	</details>

</details>
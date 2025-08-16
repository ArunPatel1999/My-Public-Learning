# Microservices Tools

## 🎯 What This Does

**Essential microservices tools and patterns for building resilient and efficient distributed systems.**

### Core Tools:
- 🔗 **Feign Client**: Declarative REST client for service-to-service communication
- 🔄 **Retry Mechanism**: Automatic retry with backoff strategy for fault tolerance
- 🛠️ **Resilience Patterns**: Tools for building robust microservices

## 📋 Project Overview

| Tool | Description | Key Technologies |
|------|-------------|------------------|
| 🔗 [Feign-Client](Feign-Client/) | Declarative REST client | Spring Cloud OpenFeign, External API |
| 🔄 [Retry-RestControllere](Retry-RestControllere/) | Retry mechanism with backoff | Spring Retry, RestTemplate |

---

<details>
<summary>📂 Tools</summary>

- [🔗 Feign-Client](Feign-Client/)
	<details>
	<summary>Declarative REST client for external API calls</summary>

	**What it does**: Simplifies HTTP client calls with declarative interface
	
	- **Code implementation**: 
	  - CallFeignClient interface with @FeignClient annotation
	  - Direct mapping to JSONPlaceholder API endpoints
	  - MyController acts as proxy to external service
	- **API endpoints**: GET /, GET /{id}, POST / (all proxy to jsonplaceholder.typicode.com)
	- **External integration**: Calls https://jsonplaceholder.typicode.com/posts
	- **Features**: Type-safe REST calls, automatic serialization/deserialization
	- **Learning**: Service-to-service communication, external API integration

	</details>

- [🔄 Retry-RestControllere](Retry-RestControllere/)
	<details>
	<summary>Automatic retry mechanism with exponential backoff</summary>

	**What it does**: Implements retry pattern for handling transient failures
	
	- **Code implementation**: 
	  - MySerice with @Retryable annotation
	  - Exponential backoff strategy (multiplier = 2)
	  - Maximum 2 attempts on any Exception
	- **API endpoint**: GET / (triggers retry mechanism)
	- **Retry configuration**: maxAttempts=2, backoff multiplier=2
	- **Test scenario**: Intentionally throws NullPointerException to demonstrate retry
	- **Features**: Fault tolerance, exponential backoff, configurable retry attempts
	- **Learning**: Resilience patterns, handling transient failures, backoff strategies

	</details>

</details>

## 🛠️ Technology Stack

- **Spring Cloud OpenFeign**: Declarative REST client
- **Spring Retry**: Retry mechanism with backoff
- **RestTemplate**: HTTP client for external calls
- **Spring Boot**: Application framework

## 📚 Learning Objectives

### Microservices Communication
- **Declarative Clients**: Feign for type-safe service calls
- **External API Integration**: Consuming third-party REST APIs
- **Service Proxying**: Acting as gateway to external services

### Resilience Patterns
- **Retry Mechanism**: Automatic retry on failures
- **Exponential Backoff**: Progressive delay between retries
- **Fault Tolerance**: Handling transient network issues
- **Configuration-driven**: Customizable retry behavior
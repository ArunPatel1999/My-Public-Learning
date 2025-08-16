# First-Time-Mono-And-Flux

## 🎯 What This Project Does

**Comprehensive reactive programming learning project covering Mono, Flux operations, and WebClient integration.**

### Core Functionality:
- ⚡ **Reactive Streams**: Mono and Flux fundamentals with various operators
- 🔄 **Asynchronous Processing**: Parallel processing and schedulers
- 🛠️ **Transformation Operations**: Map, filter, flatMap, concatMap operations
- 🔗 **Combining Streams**: Concat, merge, zip operations
- ❌ **Error Handling**: Multiple error handling strategies
- 🌐 **WebClient**: Reactive HTTP client for external API calls
- 🔄 **Retry Mechanisms**: Advanced retry patterns with backoff

## 🛠️ Technology Stack

- **Project Reactor**: Mono and Flux reactive types
- **Spring WebFlux**: Reactive web framework
- **WebClient**: Non-blocking HTTP client
- **Schedulers**: Parallel and bounded elastic schedulers
- **Lombok**: Code generation
- **SLF4J**: Logging framework

## 📚 Learning Objectives

### Reactive Programming Fundamentals
- **Mono vs Flux**: Single value vs stream of values
- **Operators**: Transformation, filtering, and combining operations
- **Schedulers**: Thread management in reactive applications
- **Backpressure**: Handling data flow control

### Advanced Reactive Patterns
- **Error Handling**: Multiple strategies for fault tolerance
- **Retry Logic**: Exponential backoff and conditional retry
- **Parallel Processing**: CPU-intensive operations optimization
- **WebClient Integration**: Reactive HTTP communication

---

## 📂 Core Components

<details>
<summary>⚡ FirstMainClass</summary>

**Comprehensive Flux and Mono operations demonstration**

- **What it does**: Demonstrates all fundamental reactive operations with practical examples
- **Code implementation**: 
  - **Basic Operations**: fluxData(), monoData() - Creating reactive streams
  - **Transformations**: fluxMapData(), fluxFilterData() - Data transformation and filtering
  - **Async Processing**: fluxFlatMapDataASYC(), fluxFlatMapDataASYCParallel() - Parallel processing with schedulers
  - **Combining Streams**: fluxConcat(), fluxMerge(), fluxZip() - Stream combination patterns
  - **Error Handling**: onErrorReturn(), onErrorContinue(), onErrorMap() - Multiple error strategies
- **Key features**:
  - **Parallel Processing**: Uses Runtime.getRuntime().availableProcessors() for optimal parallelism
  - **Schedulers**: publishOn(Schedulers.boundedElastic()), runOn(Schedulers.parallel())
  - **Transformations**: transform() with UnaryOperator for reusable operations
  - **Error Recovery**: Comprehensive error handling with logging and fallbacks

</details>

<details>
<summary>📚 BookAndReviewService</summary>

**Real-world reactive service with advanced error handling and retry**

- **What it does**: Combines book information with reviews using reactive streams
- **Code implementation**: 
  - **Stream Combination**: flatMap() to combine BookInfo with Reviews
  - **Error Handling**: checkpoint() for debugging, onErrorMap() for custom exceptions
  - **Retry Logic**: Simple retry(3) and advanced retryWhen() with exponential backoff
- **Advanced features**:
  - **Checkpoints**: checkpoint("Error check pont") for debugging reactive chains
  - **Custom Exceptions**: BookException with detailed error context
  - **Retry Strategies**: Retry.backoff(3, Duration.ofMillis(500)) with filter conditions
  - **Logging**: @Slf4j integration for comprehensive error tracking

</details>

<details>
<summary>🌐 WebClientTesting</summary>

**Reactive HTTP client with full CRUD operations**

- **What it does**: Demonstrates WebClient for reactive HTTP communication
- **Code implementation**: 
  - **GET Operations**: retrieve() and exchangeToFlux() for different response handling
  - **POST/PUT**: Reactive body handling with Mono.just(user)
  - **Error Handling**: onErrorReturn() for graceful degradation
- **API endpoints**:
  - GET /webClient/retreve - Get all users reactively
  - GET /webClient/exchenge - Alternative exchange method
  - GET /webClient/retreve/{id} - Get user by ID with error fallback
  - POST /webClient/retreve/save - Create user reactively
  - PUT /webClient/retreve/update/{id} - Update user with error handling
  - DELETE /webClient/retreve/delete/{id} - Delete user
- **Key features**:
  - **Non-blocking**: All operations return Mono/Flux for async processing
  - **Error Recovery**: Fallback to empty User objects on errors
  - **Content Negotiation**: MediaType.APPLICATION_JSON handling

</details>

## 🌟 Advanced Features

### 🔄 Parallel Processing
- **CPU Optimization**: Automatic core detection and parallel flux processing
- **Scheduler Management**: Different schedulers for I/O vs CPU-bound operations
- **Backpressure Handling**: Proper flow control in high-throughput scenarios

### ❌ Comprehensive Error Handling
- **Multiple Strategies**: onErrorReturn, onErrorContinue, onErrorMap, doOnError
- **Retry Patterns**: Simple retry and advanced exponential backoff
- **Debugging Tools**: Checkpoint integration for reactive chain debugging

### 🌐 Reactive HTTP Integration
- **WebClient**: Modern reactive HTTP client replacing RestTemplate
- **Error Recovery**: Graceful degradation with fallback responses
- **Content Types**: JSON serialization/deserialization with reactive streams
# Recative-With-MongoDb-1

## 🎯 What This Project Does

**Reactive web application with MongoDB integration featuring hot streams, functional endpoints, and real-time data processing.**

### Core Functionality:
- 📊 **Reactive MongoDB**: Non-blocking database operations with Spring Data Reactive
- 🔥 **Hot Streams**: Real-time data streaming with MongoDB tailable cursors
- 🎯 **Functional Endpoints**: WebFlux functional routing alongside traditional controllers
- ⚡ **Stream Processing**: Continuous data insertion and real-time consumption
- 📡 **Capped Collections**: MongoDB capped collections for streaming data
- 🔄 **Dual API Styles**: Both annotation-based and functional programming models

## 🛠️ Technology Stack

- **Spring WebFlux**: Reactive web framework
- **Spring Data Reactive MongoDB**: Non-blocking MongoDB operations
- **MongoDB**: Document database with capped collections
- **Project Reactor**: Mono and Flux reactive types
- **Functional Endpoints**: RouterFunction-based API design
- **Lombok**: Code generation
- **SLF4J**: Logging framework

## 📚 Learning Objectives

### Reactive Database Integration
- **Non-blocking Operations**: Reactive MongoDB repository patterns
- **Stream Processing**: Real-time data consumption with @Tailable
- **Capped Collections**: MongoDB streaming data structures
- **Backpressure Handling**: Managing data flow in reactive streams

### WebFlux Programming Models
- **Annotation-based**: Traditional @RestController approach
- **Functional**: RouterFunction and HandlerFunction patterns
- **Hot vs Cold Streams**: Understanding stream temperature concepts
- **Error Handling**: Reactive error management strategies

---

## 📂 Core Components

<details>
<summary>👤 UserController_V1</summary>

**Traditional reactive REST controller with full CRUD operations**

- **What it does**: Provides reactive CRUD operations for User entities with MongoDB
- **Code implementation**: 
  - **GET Operations**: findAll() returns Flux<User>, findById() with error handling
  - **POST Operations**: save() single user, saveAll() for Flux<User> batch operations
  - **PUT Operations**: update() with flatMap for reactive updates
  - **DELETE Operations**: deleteById() with success response
- **API endpoints**:
  - GET /v1/user - Get all users (Flux<User>)
  - GET /v1/user/{id} - Get user by ID with APPLICATION_STREAM_JSON_VALUE
  - POST /v1/user - Create single user
  - POST /v1/user/saveAll - Batch create users from Flux
  - PUT /v1/user/{id} - Update user reactively
  - DELETE /v1/user/{id} - Delete user
- **Key features**:
  - **Error Handling**: switchIfEmpty(Mono.error(new DemoException()))
  - **Streaming Response**: MediaType.APPLICATION_STREAM_JSON_VALUE
  - **Reactive Updates**: flatMap for chaining operations

</details>

<details>
<summary>🔥 UserHotStreamController</summary>

**Hot stream controller for real-time data streaming**

- **What it does**: Manages continuous data streams using MongoDB tailable cursors
- **Code implementation**: 
  - **Hot Stream Consumption**: @Tailable query for continuous data flow
  - **Stream Ingestion**: Accepts Flux<UserHotStream> for continuous writes
  - **Content Negotiation**: application/stream+json for streaming data
- **API endpoints**:
  - GET /hotStream - Continuous stream of UserHotStream data
  - POST /hotStream - Accept continuous stream input
- **Advanced features**:
  - **@Tailable Cursor**: findUserHotStreamBy() for MongoDB change streams
  - **Hot Stream**: Real-time data emission without client request
  - **Streaming Content**: MediaType.APPLICATION_STREAM_JSON_VALUE

</details>

<details>
<summary>🎯 UserApiFuncation</summary>

**Functional programming approach to reactive endpoints**

- **What it does**: Implements WebFlux functional routing with ServerRequest/ServerResponse
- **Code implementation**: 
  - **Functional Handlers**: ServerRequest → Mono<ServerResponse> pattern
  - **Body Extraction**: serverRequest.bodyToMono(User.class)
  - **Response Building**: ServerResponse.ok().body() with reactive streams
- **Handler methods**:
  - getAll() - Functional equivalent of GET all users
  - getById() - Path variable extraction with reactive response
  - save() - Request body to Mono conversion and save
  - streamData() - Functional hot stream endpoint
- **Key features**:
  - **Functional Style**: No annotations, pure function composition
  - **Request Handling**: ServerRequest for path variables and body extraction
  - **Response Composition**: Fluent ServerResponse building
  - **Stream Integration**: Functional approach to hot streams

</details>

<details>
<summary>⚙️ UserHotStreamConfigration</summary>

**MongoDB capped collection setup and continuous data generation**

- **What it does**: Configures MongoDB for streaming and generates test data continuously
- **Code implementation**: 
  - **Capped Collection**: CollectionOptions.empty().maxDocuments(20).size(50000).capped()
  - **Data Generation**: Flux.interval(Duration.ofSeconds(1)) for periodic data creation
  - **Collection Management**: mongoTemplate.dropCollection() and createCollection()
- **Configuration features**:
  - **Profile-based**: @Profile("test") for environment-specific setup
  - **CommandLineRunner**: Automatic setup on application start
  - **Continuous Insertion**: Flux.interval() for timed data generation
  - **Capped Collection**: Limited size collection for streaming scenarios
- **Data Flow**: Creates UserHotStream every second with incremental data

</details>

## 🌟 Advanced Features

### 🔥 Hot Streams with MongoDB
- **@Tailable Cursors**: MongoDB change streams for real-time data
- **Capped Collections**: Fixed-size collections optimized for streaming
- **Continuous Data Flow**: Server-sent events without client polling
- **Backpressure Management**: Reactive streams handle flow control

### 🎯 Dual Programming Models
- **Annotation-based**: Traditional @RestController with reactive types
- **Functional**: RouterFunction with ServerRequest/ServerResponse
- **Flexibility**: Choose appropriate model per use case
- **Consistency**: Both models use same reactive repository layer

### ⚡ Real-time Data Processing
- **Stream Ingestion**: Accept continuous Flux<T> input streams
- **Live Data Generation**: Flux.interval() for periodic data creation
- **MongoDB Integration**: Reactive repository with streaming queries
- **Error Resilience**: Comprehensive error handling in reactive chains

### 📡 Content Negotiation
- **Streaming JSON**: APPLICATION_STREAM_JSON_VALUE for continuous data
- **Batch Operations**: Regular JSON for single operations
- **Content Types**: Proper media type handling for different scenarios
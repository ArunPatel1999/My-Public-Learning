# TWO-MONGO

## 🎯 What This Project Does

**Dual MongoDB integration demonstrating both Spring Data MongoDB and native MongoDB driver usage in a single application.**

### Core Functionality:
- 🔄 **Dual Database Access**: Spring Data MongoDB repository and native MongoDB driver
- 📊 **Data Synchronization**: Save data to both MongoDB instances simultaneously
- 🗄️ **Multiple Connections**: Different MongoDB connection strategies in one app
- 🔧 **Object Mapping**: Jackson-based object to document conversion
- 📅 **Timestamp Management**: Automatic date field population

## 🛠️ Technology Stack

- **Spring Boot**: Application framework
- **Spring Data MongoDB**: High-level MongoDB integration
- **MongoDB Native Driver**: Low-level MongoDB operations
- **Jackson ObjectMapper**: Object to Map conversion
- **DBCollection**: Legacy MongoDB collection operations
- **BasicDBObject**: Native MongoDB document creation

## 📚 Learning Objectives

### MongoDB Integration Patterns
- **Repository Pattern**: Spring Data MongoDB repository abstraction
- **Native Driver**: Direct MongoDB driver usage for custom operations
- **Dual Persistence**: Writing to multiple MongoDB instances
- **Connection Management**: Managing multiple MongoDB connections

### Data Mapping Strategies
- **Object Mapping**: Jackson-based object to Map conversion
- **Document Creation**: Native MongoDB document operations
- **Type Conversion**: Converting Java objects to MongoDB documents
- **Field Management**: Automatic timestamp and metadata handling

---

## 📂 Core Components

<details>
<summary>👤 UserController</summary>

**Simple REST controller for user data operations**

- **What it does**: Provides HTTP endpoint for user creation with dual persistence
- **Code implementation**: 
  - **POST Endpoint**: Single endpoint for user creation
  - **Service Integration**: Delegates to UserService for dual database operations
  - **Request Mapping**: `@RequestBody User user` for JSON to object conversion
- **API endpoint**: POST / - Create user with dual MongoDB persistence
- **Features**:
  - **Simple Interface**: Single endpoint for demonstration purposes
  - **Service Delegation**: Business logic handled in service layer
  - **JSON Processing**: Automatic request body to User object conversion

</details>

<details>
<summary>🔧 UserService</summary>

**Service layer implementing dual MongoDB persistence strategy**

- **What it does**: Saves user data to both Spring Data MongoDB and native MongoDB driver
- **Code implementation**: 
  - **Dual Persistence**: `userRepository.save(user)` and `dbCollection.save()`
  - **Object Mapping**: `ObjectMapper.convertValue()` for object to Map conversion
  - **Timestamp Management**: `user.setCreatedDate(new Date())` for automatic dating
  - **Native Operations**: `BasicDBObject(map)` for native MongoDB document creation
- **Persistence strategy**:
  - **Spring Data**: High-level repository-based persistence
  - **Native Driver**: Low-level collection-based operations
  - **Data Consistency**: Same data saved to both MongoDB instances
  - **Type Conversion**: Jackson TypeReference for Map conversion
- **Key features**:
  - **Constructor Injection**: `UserRepository` and `DB` dependency injection
  - **Object Transformation**: User object to Map<String, Object> conversion
  - **Dual Write**: Simultaneous write to both MongoDB approaches
  - **Date Management**: Automatic createdDate field population

</details>

<details>
<summary>📊 User Entity</summary>

**User data model with MongoDB document mapping**

- **What it does**: Represents user data structure for MongoDB storage
- **Code implementation**: 
  - **Spring Data**: Compatible with Spring Data MongoDB repositories
  - **Native Driver**: Convertible to BasicDBObject for native operations
  - **Date Field**: createdDate for timestamp tracking
- **Entity features**:
  - **Flexible Mapping**: Works with both Spring Data and native driver
  - **JSON Serialization**: Jackson-compatible for REST API operations
  - **Document Structure**: Suitable for MongoDB document storage

</details>

## 🌟 Advanced Features

### 🔄 Dual Persistence Strategy
- **Repository Layer**: Spring Data MongoDB for high-level operations
- **Native Driver**: Direct MongoDB driver for custom operations
- **Data Consistency**: Ensures data is saved to both approaches
- **Flexibility**: Demonstrates different MongoDB integration patterns

### 🗄️ Multiple Connection Management
- **Spring Data Connection**: Automatic connection management via Spring Boot
- **Native Driver Connection**: Manual DB connection configuration
- **Connection Pooling**: Efficient connection management for both approaches
- **Configuration**: Different connection strategies in single application

### 🔧 Object Transformation Pipeline
- **Jackson Integration**: ObjectMapper for type-safe conversions
- **TypeReference**: Generic type handling for Map conversion
- **BasicDBObject**: Native MongoDB document creation
- **Field Mapping**: Automatic field mapping between object and document

### 📅 Data Management
- **Automatic Timestamps**: createdDate field population on save
- **Metadata Handling**: Additional fields for document tracking
- **Type Safety**: Proper type conversion between Java and MongoDB
- **Schema Flexibility**: Dynamic document structure support

## 🚀 Use Cases

### Development Scenarios
- **Migration**: Transitioning from native driver to Spring Data
- **Performance Comparison**: Benchmarking different MongoDB approaches
- **Feature Testing**: Testing specific features of each approach
- **Learning**: Understanding different MongoDB integration patterns

### Production Considerations
- **Connection Efficiency**: Managing multiple connections properly
- **Data Consistency**: Ensuring data integrity across approaches
- **Error Handling**: Proper exception management for dual writes
- **Monitoring**: Tracking performance of different approaches
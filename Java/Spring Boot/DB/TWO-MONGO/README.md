# TWO-MONGO

<details>
<summary>Project Overview</summary>

This Spring Boot application demonstrates dual MongoDB integration approaches - using both Spring Data MongoDB and native MongoDB Java Driver simultaneously for the same data operations.

</details>

<details>
<summary>Dual MongoDB Integration</summary>

**Spring Data MongoDB**
- Uses MongoRepository for standard CRUD operations
- Automatic document mapping with @Document annotation
- Type-safe repository operations
- Built-in Spring Boot MongoDB starter integration

**Native MongoDB Driver**
- Direct MongoDB Java Driver (version 3.12.10) usage
- Manual DBCollection operations
- BasicDBObject for document manipulation
- Raw MongoDB operations alongside Spring Data

</details>

<details>
<summary>Architecture Components</summary>

**Entity Layer**
- User: MongoDB document entity with @Document annotation
- Fields: id, name, age, createdDate
- UserRepository: Spring Data MongoDB repository interface

**Service Layer**
- UserService: Implements dual save operations
- Saves data using both Spring Data and native driver
- Automatic timestamp addition (createdDate)
- ObjectMapper for entity to Map conversion

**Controller Layer**
- UserController: REST endpoint for user operations
- POST endpoint for creating users
- Returns saved user data

</details>

<details>
<summary>Key Features</summary>

**Dual Persistence Strategy**
- Same data saved using two different approaches
- Spring Data MongoDB for ease of use
- Native driver for direct MongoDB control
- Demonstrates different MongoDB integration patterns

**Data Transformation**
- Jackson ObjectMapper for entity to Map conversion
- BasicDBObject creation for native driver operations
- Automatic date field population

**MongoDB Configuration**
- Multiple MongoDB driver dependencies
- Both sync and async driver support
- Spring Boot DevTools for development

</details>

<details>
<summary>API Endpoints</summary>

**User Operations**
- POST `/` - Create new user with dual persistence
  - Saves via Spring Data MongoDB repository
  - Saves via native MongoDB driver
  - Returns Spring Data result

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot 2.5.6
- Spring Data MongoDB
- MongoDB Java Driver 3.12.10
- MongoDB Driver Sync
- Jackson ObjectMapper
- Maven

</details>
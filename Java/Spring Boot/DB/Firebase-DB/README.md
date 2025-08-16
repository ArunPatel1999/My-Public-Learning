# Firebase-DB

<details>
<summary>Project Overview</summary>

This Spring Boot application demonstrates integration with Firebase services, providing CRUD operations for both Firestore (NoSQL document database) and Firebase Realtime Database.

</details>

<details>
<summary>Firebase Services Integration</summary>

**Firestore Database**
- Document-based NoSQL database operations
- Structured data storage with collections and documents
- Asynchronous operations with ExecutionException handling

**Firebase Realtime Database**
- Real-time synchronization capabilities
- JSON tree structure data storage
- Node-based data organization

**Firebase Initialization**
- Automatic configuration using service account credentials
- Database URL configuration for Asia Southeast region
- PostConstruct initialization for Firebase app setup

</details>

<details>
<summary>API Endpoints</summary>

**Firestore Operations**
- GET `/firestore` - Retrieve all documents
- GET `/firestore/{id}` - Get document by ID
- POST `/firestore` - Create new document with JSON data
- DELETE `/firestore/{id}` - Delete document by ID

**Realtime Database Operations**
- GET `/realtime` - Get all data from realtime database
- GET `/realtime/{nodename}` - Get data from specific node
- POST `/realtime/{nodename}` - Save or update data in node
- DELETE `/realtime/{nodename}` - Delete data from node

</details>

<details>
<summary>Architecture Components</summary>

**Controllers**
- FirestoreController: Handles Firestore database operations
- RealTimeController: Manages Realtime Database operations

**Services**
- CRUDFirestore: Interface for Firestore operations
- CRUDRealTime: Interface for Realtime Database operations
- Service implementations in impl package

**Configuration**
- FBInitialize: Firebase app initialization and configuration
- Service account authentication setup

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot 2.5.5
- Firebase Admin SDK 8.1.0
- Google Cloud Firestore
- Firebase Realtime Database
- Maven

</details>
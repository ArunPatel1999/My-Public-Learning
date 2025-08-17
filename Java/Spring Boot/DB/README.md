# Database Integration Projects

## 🎯 What This Does

**Comprehensive database integration examples covering various databases, connection patterns, and common challenges in Spring Boot applications.**

### Core Technologies:
- 🔥 **Firebase Integration**: Firestore and Realtime Database with Spring Boot
- 🍃 **MongoDB Patterns**: Dual connection strategies and native driver usage
- 🗄️ **MySQL Solutions**: JPA relationship issues and circular reference fixes
- 🔍 **Elasticsearch**: Search engine integration and operations

## 📋 Project Overview

| Project | Database Type | Key Focus |
|---------|---------------|-----------|
| 🔥 [Firebase-DB](Firebase-DB/) | Firebase Cloud | Firestore & Realtime Database integration |
| 🍃 [TWO-MONGO](TWO-MONGO/) | MongoDB | Dual connection patterns |
| 🗄️ [Mysql-Biderctional-Infint-problem-solve](Mysql-Biderctional-Infint-problem-solve/) | MySQL | JPA circular reference fix |
| 🔍 [Elasticsearch First](Elasticsearch%20First/) | Elasticsearch | Search operations & indexing |

---

<details>
<summary>📂 Projects</summary>

- [🔥 Firebase-DB](Firebase-DB/)
	<details>
	<summary>Firebase cloud database integration with dual database support</summary>

	**Complete Firebase integration with Firestore and Realtime Database**
	
	- **What it covers**: Firebase SDK setup, service account auth, Firestore & Realtime DB operations
	- **Key tech**: Firebase Admin SDK, Google Credentials, Cloud Firestore, Realtime Database
	- **Skills**: Cloud database integration, NoSQL operations, real-time sync, authentication
	
	</details>

- [🍃 TWO-MONGO](TWO-MONGO/)
	<details>
	<summary>Dual MongoDB integration with repository and native driver patterns</summary>

	**Demonstrates both Spring Data MongoDB and native driver usage**
	
	- **What it covers**: Dual persistence, Spring Data repositories, native MongoDB driver, object mapping
	- **Key tech**: Spring Data MongoDB, MongoDB Native Driver, Jackson ObjectMapper, DBCollection
	- **Skills**: Multiple connection strategies, data synchronization, object transformation
	
	</details>

- [🗄️ Mysql-Biderctional-Infint-problem-solve](Mysql-Biderctional-Infint-problem-solve/)
	<details>
	<summary>JPA bidirectional relationship circular reference solution</summary>

	**Solves infinite recursion in JPA bidirectional relationships using Jackson annotations**
	
	- **What it covers**: JPA relationships, circular reference issues, JSON serialization fixes
	- **Key tech**: Spring Data JPA, Jackson @JsonIdentityInfo, OneToOne mapping, MySQL
	- **Skills**: JPA relationship management, JSON serialization, circular reference handling
	
	</details>

- [🔍 Elasticsearch First](Elasticsearch%20First/)
	<details>
	<summary>Elasticsearch integration with Spring Boot for search operations</summary>

	**Search engine integration with indexing and query operations**
	
	- **What it covers**: Elasticsearch setup, indexing, search queries, data operations
	- **Key tech**: Spring Data Elasticsearch, Elasticsearch Client, Index management
	- **Skills**: Search engine integration, full-text search, index operations, query building
	
	</details>

</details>
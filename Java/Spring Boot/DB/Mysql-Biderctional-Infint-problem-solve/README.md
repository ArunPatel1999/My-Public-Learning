# Mysql-Bidirectional-Infinite-Problem-Solve

<details>
<summary>Project Overview</summary>

This Spring Boot project demonstrates how to solve the infinite recursion problem that occurs with bidirectional JPA relationships when serializing entities to JSON.

</details>

<details>
<summary>Problem Statement</summary>

**Bidirectional Relationship Issue**
- User and Address entities have a bidirectional OneToOne relationship
- During JSON serialization, infinite recursion occurs
- User references Address, Address references User, creating endless loop
- Results in StackOverflowError during API responses

</details>

<details>
<summary>Solution Implementation</summary>

**JsonIdentityInfo Annotation**
- Uses `@JsonIdentityInfo` with `ObjectIdGenerators.PropertyGenerator.class`
- Identifies objects by their `id` property during serialization
- Prevents infinite recursion by referencing already serialized objects
- Replaces the need for `@JsonManagedReference` and `@JsonBackReference`

**Alternative Approaches (Commented)**
- `@JsonManagedReference` on User entity (forward reference)
- `@JsonBackReference` on Address entity (back reference)
- These annotations are commented out in favor of JsonIdentityInfo

</details>

<details>
<summary>Entity Structure</summary>

**User Entity**
- Fields: id, name, age
- OneToOne relationship with Address
- Cascade ALL operations to Address
- Uses JsonIdentityInfo for serialization

**Address Entity**
- Fields: id, address, pincode
- OneToOne relationship with User
- Cascade ALL operations to User
- Uses JsonIdentityInfo for serialization

**Repository Layer**
- UserRepository: JPA repository for User operations
- AddressRepository: JPA repository for Address operations

</details>

<details>
<summary>Key Features</summary>

**Bidirectional Mapping**
- Complete bidirectional navigation between entities
- Automatic cascade operations
- Proper foreign key relationships

**JSON Serialization**
- Infinite recursion prevention
- Clean JSON output without circular references
- Maintains object relationships in API responses

**JPA Configuration**
- Auto-generated primary keys
- Proper cascade configurations
- Entity relationship mapping

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot
- Spring Data JPA
- MySQL Database
- Jackson JSON (JsonIdentityInfo)
- Maven

</details>
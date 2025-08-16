# Spring-Batch-csv-to-db

<details>
<summary>Project Overview</summary>

This Spring Boot application demonstrates CSV file processing using Spring Batch, reading product data from a CSV file, transforming it, and storing it in a MySQL database.

</details>

<details>
<summary>Core Components</summary>

**CSV File Reader**
- Reads product data from `product.csv` file in classpath
- Maps CSV columns (id, name, price) to Product objects
- Uses FlatFileItemReader with DelimitedLineTokenizer
- Processes data in chunks of 3 records

**Data Processor**
- Transforms product data by adding 100 to the price
- Implements simple business logic transformation
- Uses lambda expression for processing

**Database Writer**
- Writes processed data to MySQL database
- Uses JdbcBatchItemWriter for batch database operations
- Inserts data into `product` table with columns: ID, NAME, PRICE

**Product Entity**
- Simple POJO representing product data
- Contains id, name, and price fields
- Used for data mapping between CSV and database

</details>

<details>
<summary>Database Configuration</summary>

**MySQL Connection**
- Database: `test`
- Host: `localhost:3306`
- Username: `pma`
- Driver: MySQL Connector/J

**Table Structure**
```sql
CREATE TABLE product (
    ID INT,
    NAME VARCHAR(255),
    PRICE DOUBLE
);
```

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot 2.5.4
- Spring Batch
- MySQL Database
- Maven

</details>
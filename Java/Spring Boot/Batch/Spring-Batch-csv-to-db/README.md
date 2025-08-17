# Spring-Batch-csv-to-db

## 🎯 What This Project Does

**Production-ready Spring Batch application for CSV to database ETL processing with data transformation and MySQL integration.**

### Core Functionality:
- 📄 **CSV Reading**: FlatFileItemReader for parsing CSV files with field mapping
- 🔄 **Data Transformation**: Price adjustment processing during ETL pipeline
- 🗄️ **Database Writing**: JdbcBatchItemWriter for efficient MySQL batch inserts
- 📊 **Chunk Processing**: Configurable batch size for optimal performance
- 🏗️ **ETL Pipeline**: Complete Extract-Transform-Load implementation

## 🛠️ Technology Stack

- **Spring Batch**: Enterprise batch processing framework
- **Spring Boot**: Application framework with auto-configuration
- **FlatFileItemReader**: CSV file parsing and field mapping
- **JdbcBatchItemWriter**: Database batch insert operations
- **MySQL**: Relational database for data storage
- **BeanWrapperFieldSetMapper**: Object mapping from CSV fields

## 📚 Learning Objectives

### ETL Processing Patterns
- **File-to-Database**: CSV parsing and database insertion pipeline
- **Data Transformation**: Business logic application during processing
- **Batch Optimization**: Chunk-based processing for performance
- **Error Handling**: Robust error management in production scenarios

### Spring Batch Advanced Features
- **File Processing**: Complex file parsing with field mapping
- **Database Integration**: JDBC-based batch writing operations
- **Configuration Management**: Production-ready batch configuration
- **Performance Tuning**: Chunk size optimization for throughput

---

## 📂 Core Components

<details>
<summary>📄 MyBatchConfigartion</summary>

**Complete ETL pipeline configuration with file reading and database writing**

- **What it does**: Configures end-to-end CSV to database processing pipeline
- **Code implementation**: 
  - **Job Configuration**: `JobBuilderFactory` with RunIdIncrementer for multiple executions
  - **Step Configuration**: `StepBuilderFactory` with chunk size 3 for batch processing
  - **Reader Setup**: FlatFileItemReader with CSV parsing and field mapping
  - **Writer Setup**: JdbcBatchItemWriter with MySQL batch insert operations
- **File Processing Configuration**:
  - **CSV Resource**: `ClassPathResource("product.csv")` for input file location
  - **Line Tokenizer**: `DelimitedLineTokenizer` with field names "id", "name", "price"
  - **Field Mapping**: `BeanWrapperFieldSetMapper<Product>` for object conversion
  - **Line Mapping**: `DefaultLineMapper` combining tokenizer and field mapper
- **Database Configuration**:
  - **Batch Writer**: `JdbcBatchItemWriter<Product>` for efficient database operations
  - **SQL Statement**: `INSERT INTO product (ID,NAME,PRICE) VALUES (:id, :name, :price)`
  - **Parameter Source**: `BeanPropertyItemSqlParameterSourceProvider` for object property mapping
  - **DataSource**: MySQL connection with DriverManagerDataSource

</details>

<details>
<summary>🔄 Processor (Lambda)</summary>

**Inline data transformation using lambda expression**

- **What it does**: Applies business logic transformation to product price
- **Code implementation**: 
  - **Lambda Processor**: `p -> { p.setPrice(p.getPrice()+100); return p; }`
  - **Price Adjustment**: Adds 100 to each product price during processing
  - **Object Modification**: Direct property manipulation on Product objects
- **Transformation features**:
  - **Inline Logic**: Concise lambda expression for simple transformations
  - **Business Rules**: Price markup application during ETL process
  - **Object Mutation**: Modifies existing object rather than creating new one
  - **Type Safety**: Generic `ItemProcessor<Product, Product>` ensures type consistency

</details>

<details>
<summary>📊 Product Entity</summary>

**Data model representing CSV structure and database schema**

- **What it does**: Defines data structure for CSV parsing and database mapping
- **Code implementation**: 
  - **Properties**: `int id`, `String name`, `double price` matching CSV columns
  - **Getters/Setters**: Standard JavaBean pattern for property access
  - **Field Mapping**: Property names match CSV column names for automatic mapping
- **Entity features**:
  - **CSV Compatibility**: Field names align with DelimitedLineTokenizer configuration
  - **Database Mapping**: Properties correspond to database table columns
  - **Type Safety**: Appropriate data types for each field (int, String, double)
  - **Bean Convention**: Standard getter/setter pattern for Spring integration

</details>

## 🌟 Advanced Features

### 📄 File Processing Pipeline
- **CSV Parsing**: Automatic field tokenization and type conversion
- **Field Mapping**: BeanWrapperFieldSetMapper for object creation
- **Resource Management**: ClassPathResource for file location abstraction
- **Error Handling**: Built-in parsing error management

### 🗄️ Database Integration
- **Batch Inserts**: JdbcBatchItemWriter for efficient database operations
- **Parameter Mapping**: Automatic object property to SQL parameter mapping
- **Transaction Management**: Spring-managed transactions for data consistency
- **Connection Pooling**: DataSource configuration for connection management

### ⚙️ Performance Optimization
- **Chunk Processing**: Configurable batch size (chunk=3) for memory efficiency
- **Batch Operations**: Multiple records processed in single database transaction
- **Resource Efficiency**: Streaming file processing without loading entire file
- **Memory Management**: Chunk-based processing prevents memory overflow

### 🔧 Production Configuration
- **MySQL Integration**: Production database connectivity
- **Error Recovery**: Built-in retry and skip mechanisms
- **Monitoring**: Job execution tracking and status reporting
- **Scalability**: Configurable chunk sizes for different data volumes

## 📈 ETL Flow
1. **Extract**: Read CSV file with FlatFileItemReader
2. **Transform**: Apply price adjustment with lambda processor
3. **Load**: Batch insert to MySQL with JdbcBatchItemWriter
4. **Monitor**: Track job execution and completion status
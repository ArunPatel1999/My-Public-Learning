# Spring Batch Projects

## 🎯 What This Does

**Enterprise batch processing implementations using Spring Batch for ETL operations and data processing pipelines.**

### Core Projects:
- 📊 **Basic Batch Processing**: Fundamental read-process-write patterns
- 📄 **CSV to Database ETL**: Production-ready file processing with database integration
- 🔄 **Data Transformation**: Business logic application during batch processing

## 📋 Project Overview

| Project | Description | Key Technologies |
|---------|-------------|------------------|
| 📊 [Spring-Batch](Spring-Batch/) | Basic batch processing fundamentals | ItemReader, ItemProcessor, ItemWriter |
| 📄 [Spring-Batch-csv-to-db](Spring-Batch-csv-to-db/) | CSV to MySQL ETL pipeline | FlatFileItemReader, JdbcBatchItemWriter |

---

<details>
<summary>📂 Projects</summary>

- [📊 Spring-Batch](Spring-Batch/)
	<details>
	<summary>Basic Spring Batch implementation with custom components</summary>

	- **What it does**: Demonstrates fundamental read-process-write pattern with array data
	- **Key tech**: ItemReader, ItemProcessor, ItemWriter, JobBuilderFactory
	- **Skills**: Batch fundamentals, component design, job configuration

	</details>

- [📄 Spring-Batch-csv-to-db](Spring-Batch-csv-to-db/)
	<details>
	<summary>Production ETL pipeline from CSV to MySQL database</summary>

	- **What it does**: Complete file-to-database processing with data transformation
	- **Key tech**: FlatFileItemReader, JdbcBatchItemWriter, MySQL, field mapping
	- **Skills**: ETL processing, file parsing, database integration, performance optimization

	</details>

</details>
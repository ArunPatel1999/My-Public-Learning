# Spring-Batch

<details>
<summary>Project Overview</summary>

This is a Spring Boot application demonstrating basic Spring Batch functionality with a simple ETL (Extract, Transform, Load) pipeline.

</details>

<details>
<summary>Core Components</summary>

**Batch Configuration**
- Configures a job with a single step that processes string data
- Uses chunk-oriented processing with chunk size of 1
- Implements the standard Reader-Processor-Writer pattern

**Reader Component**
- Reads from a hardcoded string array: ["aaa", "bbb", "cccc"]
- Implements ItemReader interface for batch processing
- Cycles through the data array sequentially

**Processor Component**
- Transforms input strings to uppercase
- Implements ItemProcessor interface
- Simple string transformation logic

**Writer Component**
- Outputs processed data to console
- Implements ItemWriter interface
- Displays the transformed data for verification

**Job Execution Listener**
- Monitors job execution lifecycle
- Provides hooks for job start/end events

</details>

<details>
<summary>Technologies Used</summary>

- Spring Boot 2.5.4
- Spring Batch
- Spring Data JPA
- H2 Database (in-memory)
- Maven

</details>
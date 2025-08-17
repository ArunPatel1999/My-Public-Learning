# Spring-Batch

## 🎯 What This Project Does

**Basic Spring Batch implementation demonstrating the fundamental Read-Process-Write pattern with custom components.**

### Core Functionality:
- 📖 **Custom Reader**: Array-based data reading with ItemReader interface
- ⚙️ **Data Processing**: String transformation using ItemProcessor
- ✍️ **Custom Writer**: Console output with ItemWriter interface
- 🔄 **Job Configuration**: Complete batch job setup with steps and listeners
- 📊 **Execution Tracking**: Job execution monitoring and lifecycle management

## 🛠️ Technology Stack

- **Spring Batch**: Batch processing framework
- **Spring Boot**: Application framework
- **ItemReader**: Data input abstraction
- **ItemProcessor**: Data transformation layer
- **ItemWriter**: Data output abstraction
- **JobBuilderFactory**: Job configuration builder
- **StepBuilderFactory**: Step configuration builder

## 📚 Learning Objectives

### Spring Batch Fundamentals
- **Read-Process-Write Pattern**: Core batch processing architecture
- **Job Configuration**: Defining jobs, steps, and execution flow
- **Component Integration**: Connecting readers, processors, and writers
- **Chunk Processing**: Batch processing in configurable chunks

### Batch Processing Concepts
- **Job Lifecycle**: Job execution, monitoring, and completion
- **Step Management**: Multi-step job configuration
- **Error Handling**: Batch processing error management
- **Performance Optimization**: Chunk-based processing for efficiency

---

## 📂 Core Components

<details>
<summary>📖 Reader</summary>

**Custom ItemReader implementation for array-based data input**

- **What it does**: Reads data from a predefined string array sequentially
- **Code implementation**: 
  - **ItemReader Interface**: Implements `ItemReader<String>` for type-safe reading
  - **Array Data Source**: `String[] data = {"aaa","bbb","cccc"}` as input source
  - **Sequential Reading**: Uses counter to track current position
  - **End Detection**: Returns null when all items are read to signal completion
- **Key features**:
  - **Stateful Reading**: Maintains internal counter for position tracking
  - **Null Termination**: Returns null to indicate end of data
  - **Reset Logic**: Counter resets to 0 after reaching end
  - **Exception Handling**: Implements required exception declarations

</details>

<details>
<summary>⚙️ Processer</summary>

**ItemProcessor implementation for data transformation**

- **What it does**: Transforms input strings to uppercase format
- **Code implementation**: 
  - **ItemProcessor Interface**: Implements `ItemProcessor<String, String>`
  - **Transformation Logic**: `item.toUpperCase()` for string conversion
  - **Pass-through Processing**: Simple one-to-one transformation
- **Processing features**:
  - **Type Safety**: Generic types ensure input/output type consistency
  - **Logging**: Console output for processing tracking
  - **Simple Transformation**: Demonstrates basic data manipulation
  - **Synchronous Processing**: Blocking transformation for each item

</details>

<details>
<summary>✍️ Writer</summary>

**ItemWriter implementation for console output**

- **What it does**: Outputs processed data to console for verification
- **Code implementation**: 
  - **ItemWriter Interface**: Implements `ItemWriter<String>` for batch writing
  - **List Processing**: Handles `List<? extends String>` for chunk-based writing
  - **Console Output**: `System.out.println()` for data display
- **Writing features**:
  - **Chunk-based**: Processes multiple items in single write operation
  - **Batch Efficiency**: Reduces I/O operations through batching
  - **Debug Output**: Shows processed data for verification
  - **Simple Implementation**: Console-based output for learning purposes

</details>

<details>
<summary>🔄 BatchConfigartion</summary>

**Spring Batch job and step configuration**

- **What it does**: Configures complete batch job with steps and execution flow
- **Code implementation**: 
  - **Job Configuration**: `JobBuilderFactory` for job creation with incrementer
  - **Step Configuration**: `StepBuilderFactory` for step setup with chunk size
  - **Component Wiring**: Connects reader, processor, and writer components
  - **Execution Listener**: `MyJobExecution` for job lifecycle monitoring
- **Configuration features**:
  - **Chunk Processing**: `.<String,String>chunk(1)` for single-item chunks
  - **RunIdIncrementer**: Automatic job instance creation for multiple runs
  - **Dependency Injection**: Constructor-based dependency injection
  - **Bean Management**: Spring-managed batch components

</details>

## 🌟 Key Features

### 📊 Batch Processing Pipeline
- **Read Phase**: Sequential data reading from array source
- **Process Phase**: String transformation (lowercase to uppercase)
- **Write Phase**: Console output of processed data
- **Chunk Management**: Configurable chunk size for processing efficiency

### 🔄 Job Execution Flow
1. **Job Start**: JobBuilderFactory creates job with incrementer
2. **Step Execution**: StepBuilderFactory configures processing step
3. **Component Chain**: Reader → Processor → Writer execution flow
4. **Completion**: Job listener handles execution completion

### ⚙️ Configuration Management
- **Spring Integration**: Full Spring Boot and Batch integration
- **Component Injection**: Automatic wiring of batch components
- **Execution Tracking**: Built-in job execution monitoring
- **Reusable Components**: Modular design for component reuse

### 📈 Learning Progression
- **Basic Concepts**: Simple read-process-write pattern
- **Component Design**: Custom implementation of batch interfaces
- **Configuration**: Spring-based job and step configuration
- **Execution Model**: Understanding batch processing lifecycle
# RxJava

## 🎯 What This Project Does

**Comprehensive RxJava reactive programming examples covering Observable patterns, operators, error handling, and stream processing.**

### Core Functionality:
- 📡 **Observable Creation**: Multiple ways to create reactive streams
- 🔥 **Hot vs Cold Streams**: Understanding stream temperature and behavior
- 🎯 **Reactive Types**: Single, Maybe, Completable for different use cases
- 🔧 **Operators**: Transformation, filtering, and utility operators
- ❌ **Error Handling**: Comprehensive error management strategies
- ⏱️ **Time-based Operations**: Interval, take, skip with time constraints

## 🛠️ Technology Stack

- **RxJava**: Reactive Extensions for Java
- **Observable**: Multi-value reactive streams
- **Single**: Single-value reactive type
- **Maybe**: Optional-value reactive type
- **Completable**: No-value completion signal
- **Gradle**: Build system

## 📚 Learning Objectives

### Reactive Programming Fundamentals
- **Observable Patterns**: Creating and consuming reactive streams
- **Stream Temperature**: Hot vs Cold observable behavior
- **Operator Composition**: Chaining operations for data transformation
- **Backpressure**: Managing data flow in reactive streams

### Advanced RxJava Concepts
- **Error Recovery**: Multiple error handling strategies
- **Time-based Processing**: Interval and time-constrained operations
- **Stream Filtering**: Distinct, take, skip operations
- **Reactive Types**: Choosing appropriate reactive containers

---

## 📂 Core Components

<details>
<summary>📡 ObservableMain1</summary>

**Observable creation patterns and basic stream operations**

- **What it does**: Demonstrates various ways to create Observable streams
- **Code implementation**: 
  - **Observable.just()**: Create from static values
  - **Observable.range()**: Create numeric sequences
  - **Observable.fromIterable()**: Create from collections
  - **Observable.create()**: Custom emitter-based creation
- **Creation patterns**:
  - Static values: `Observable.just(0,1,2,3,4,6,7,8,945,45)`
  - Ranges: `Observable.range(0,20)` for sequential numbers
  - Collections: `Observable.fromIterable(Arrays.asList(...))`
  - Custom: `Observable.create(emitter -> {...})` with manual emission
- **Key features**:
  - **Manual Control**: Custom emitter with onNext(), onComplete()
  - **Error Handling**: Complete subscriber with error and completion callbacks
  - **Resource Management**: .dispose() for subscription cleanup

</details>

<details>
<summary>🔥 HotAndCold1</summary>

**Hot vs Cold observable demonstration**

- **What it does**: Shows the difference between cold and hot observable behavior
- **Code implementation**: 
  - **Cold Observable**: `Observable.just(1,2,3,4,5)` - each subscriber gets full sequence
  - **Hot Observable**: `Observable.just(1,2,3,4,5).publish()` - shared emission
- **Stream behavior**:
  - **Cold**: Each subscription triggers new emission sequence
  - **Hot**: Single emission shared among all subscribers
  - **ConnectableObservable**: `.publish()` creates hot observable, `.connect()` starts emission
- **Key concepts**:
  - **Subscription Timing**: Cold starts on subscribe, hot needs connect()
  - **Data Sharing**: Hot streams share single data source
  - **Resource Efficiency**: Hot streams avoid duplicate work

</details>

<details>
<summary>🎯 Single_Maybe_Completed</summary>

**Specialized reactive types for different use cases**

- **What it does**: Demonstrates Single, Maybe, and Completable reactive types
- **Code implementation**: 
  - **Single**: `Single.just("Only One data")` - exactly one value
  - **Maybe**: `Maybe.just(1)` and `Maybe.empty()` - zero or one value
  - **Completable**: `Completable.fromSingle()` - completion signal only
- **Type characteristics**:
  - **Single**: Always emits exactly one value or error
  - **Maybe**: Emits zero or one value, then completes
  - **Completable**: Only signals completion or error, no values
- **Use cases**:
  - **Single**: API calls returning single result
  - **Maybe**: Optional operations that might return nothing
  - **Completable**: Fire-and-forget operations

</details>

<details>
<summary>🔧 Take_TakeWhile_Skip_SkipWhile</summary>

**Stream limiting and filtering operators**

- **What it does**: Demonstrates operators for controlling stream emission
- **Code implementation**: 
  - **take()**: `Observable.just(1,2,3,4,5).take(2)` - limit to first N items
  - **takeWhile()**: `.takeWhile(item -> item <= 3)` - take while condition true
  - **skip()**: `.skip(2)` - skip first N items
  - **skipWhile()**: `.skipWhile(item -> item <= 3)` - skip while condition true
- **Time-based operations**:
  - **take(time)**: `Observable.interval(300, TimeUnit.MILLISECONDS).take(2, TimeUnit.SECONDS)`
  - **skip(time)**: `.skip(2, TimeUnit.SECONDS)` for time-based skipping
- **Key features**:
  - **Count-based**: Limit by number of items
  - **Condition-based**: Limit by predicate evaluation
  - **Time-based**: Limit by duration with TimeUnit

</details>

<details>
<summary>🔍 Distinct_DistinctUntilChanged</summary>

**Duplicate filtering and uniqueness operators**

- **What it does**: Removes duplicates from streams with different strategies
- **Code implementation**: 
  - **distinct()**: `Observable.just(1,2,2,3,3,4,5,5).distinct()` - remove all duplicates
  - **distinctUntilChanged()**: `.distinctUntilChanged()` - remove consecutive duplicates
  - **Key selectors**: `.distinct(x -> x.length())` - uniqueness by custom key
- **Filtering strategies**:
  - **Global Distinct**: Remembers all seen values
  - **Consecutive Distinct**: Only compares with previous value
  - **Key-based**: Custom uniqueness criteria
- **Performance considerations**:
  - **Memory usage**: distinct() keeps all seen values
  - **Efficiency**: distinctUntilChanged() uses constant memory

</details>

<details>
<summary>❌ OnError</summary>

**Comprehensive error handling strategies**

- **What it does**: Demonstrates various error recovery and handling patterns
- **Code implementation**: 
  - **doOnError()**: `Observable.error().doOnError(error -> {...})` - side effect on error
  - **onErrorResumeNext()**: `.onErrorResumeNext(Observable.just(...))` - fallback stream
  - **onErrorReturn()**: `.onErrorReturn(error -> {...})` - fallback value with error context
  - **onErrorReturnItem()**: `.onErrorReturnItem("fallback")` - static fallback value
- **Error strategies**:
  - **Logging**: doOnError() for error logging without recovery
  - **Stream Replacement**: onErrorResumeNext() continues with different stream
  - **Value Replacement**: onErrorReturn() provides fallback based on error type
  - **Static Fallback**: onErrorReturnItem() for simple default values
- **Error handling patterns**:
  - **Type-based Recovery**: Different fallbacks for different exception types
  - **Graceful Degradation**: Continue operation with default values
  - **Error Transformation**: Convert errors to meaningful responses

</details>

## 🌟 Advanced Features

### 🔥 Stream Temperature Management
- **Cold Observables**: Each subscription gets independent emission
- **Hot Observables**: Shared emission across multiple subscribers
- **ConnectableObservable**: Manual control over hot stream activation
- **Resource Efficiency**: Hot streams prevent duplicate work

### ⏱️ Time-based Operations
- **Interval Streams**: `Observable.interval()` for periodic emission
- **Time Constraints**: take/skip with TimeUnit for duration-based control
- **Scheduling**: Built-in time management for reactive operations

### 🔧 Operator Composition
- **Fluent API**: Chain multiple operators for complex transformations
- **Functional Programming**: Lambda expressions for custom logic
- **Reusable Logic**: Key selectors for custom comparison criteria

### ❌ Robust Error Handling
- **Multiple Strategies**: Different approaches for different error scenarios
- **Error Context**: Access to original error for intelligent recovery
- **Graceful Degradation**: Continue operation despite failures
- **Type-safe Recovery**: Handle specific exception types appropriately
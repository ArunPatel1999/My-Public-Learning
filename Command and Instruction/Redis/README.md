# Redis - In-Memory Data Store

## 📋 Overview
Comprehensive Redis command reference for in-memory data structure operations, caching, and real-time applications.

## 📁 Contents

<details>
<summary>📄 Redis.txt - Complete Command Reference</summary>

### String Operations
Redis strings are the most basic Redis data type, capable of storing text, numbers, and binary data.

#### Basic String Commands
```redis
# Set and get string values
SET name "John"          # Set string value
GET name                 # Get string value
GETRANGE name 0 4        # Get substring from index 0 to 4
STRLEN name              # Get string length
```

#### Multiple Key Operations
```redis
# Work with multiple keys simultaneously
MSET name "John" age 25  # Set multiple key-value pairs
MGET name age            # Get multiple values at once
```

### Numeric Operations
Redis provides atomic operations for numeric values, making it perfect for counters and statistics.

#### Increment/Decrement Operations
```redis
# Basic increment/decrement
SET count 1
INCR count               # Increment by 1 (count becomes 2)
DECR count               # Decrement by 1 (count becomes 1)

# Custom increment/decrement
INCRBY count 24          # Increment by 24
DECRBY count 24          # Decrement by 24

# Float operations
INCRBYFLOAT count 1.1    # Increment by 1.1
DECRBYFLOAT count 1.1    # Decrement by 1.1
```

### Expiration & TTL Management
Redis allows you to set expiration times for keys, making it excellent for caching and session management.

#### Expiration Commands
```redis
# Set expiration
EXPIRE count 10          # Key expires in 10 seconds
TTL count                # Check remaining time to live
SETEX key 10 "value"     # Set key with value and 10-second expiration
```

### List Operations
Redis lists are ordered collections of strings, perfect for queues, stacks, and timelines.

#### Adding Elements
```redis
# Add elements to lists
LPUSH countries "India"  # Push to left side (beginning)
RPUSH countries "UK"     # Push to right side (end)
```

#### Removing Elements
```redis
# Remove elements from lists
LPOP countries           # Remove from left side
RPOP countries           # Remove from right side
```

#### Accessing List Data
```redis
# Access list elements
LRANGE countries 0 -1    # Get all elements (-1 means end)
LINDEX countries 0       # Get element at index 0
LLEN countries           # Get list length
```

#### Modifying Lists
```redis
# Modify list elements
LSET countries 5 "USA"   # Update element at index 5
LINSERT countries BEFORE "India" "UK"  # Insert before India
LINSERT countries AFTER "India" "UK"   # Insert after India

# Conditional operations
LPUSHX countries "AAAAA" # Push only if list exists
```

#### List Sorting
```redis
# Sort list elements
SORT countries ALPHA              # Sort strings alphabetically (ascending)
SORT countries DESC ALPHA         # Sort strings alphabetically (descending)
```

### General Commands
Essential commands for database management and key operations.

#### Key Management
```redis
# Key operations
KEYS *                   # Get all keys (use pattern for filtering)
KEYS user:*              # Get keys matching pattern
FLUSHALL                 # Delete all keys from all databases
DEL key1 key2            # Delete specific keys
EXISTS key               # Check if key exists
TYPE key                 # Get key data type
```

</details>

## 🚀 Quick Start Guide

### 1. Basic Operations
```bash
# Start Redis server
redis-server

# Connect with Redis CLI
redis-cli

# Test connection
PING
# Response: PONG
```

### 2. String Operations
```redis
# Store user information
SET user:1:name "John Doe"
SET user:1:email "john@example.com"
SET user:1:age 30

# Retrieve user information
GET user:1:name
MGET user:1:name user:1:email user:1:age
```

### 3. Counter Implementation
```redis
# Page view counter
SET page:home:views 0
INCR page:home:views        # Increment on each visit
GET page:home:views         # Get current count
```

### 4. Session Management
```redis
# Store session with expiration
SETEX session:abc123 3600 "user_data"  # Expires in 1 hour
TTL session:abc123                      # Check remaining time
```

## 🔧 Common Use Cases

### Caching
```redis
# Cache database query results
SET cache:user:123 '{"name":"John","email":"john@example.com"}' EX 300
GET cache:user:123
```

### Rate Limiting
```redis
# API rate limiting (10 requests per minute)
SET rate:user:123 1 EX 60
INCR rate:user:123
GET rate:user:123  # Check current count
```

### Real-time Analytics
```redis
# Track daily active users
SADD daily:users:2024-01-15 user:123
SADD daily:users:2024-01-15 user:456
SCARD daily:users:2024-01-15  # Count unique users
```

### Message Queues
```redis
# Simple job queue
LPUSH job:queue '{"task":"send_email","user_id":123}'
RPOP job:queue  # Process job from queue
```

## 📊 Data Types Overview

### Strings
- **Use Cases**: Caching, counters, session storage
- **Max Size**: 512MB per string
- **Operations**: GET, SET, INCR, DECR

### Lists
- **Use Cases**: Queues, stacks, activity feeds
- **Max Size**: 2^32 - 1 elements
- **Operations**: LPUSH, RPUSH, LPOP, RPOP

### Sets
- **Use Cases**: Unique items, tags, relationships
- **Operations**: SADD, SREM, SISMEMBER, SUNION

### Hashes
- **Use Cases**: Object storage, user profiles
- **Operations**: HSET, HGET, HMSET, HMGET

### Sorted Sets
- **Use Cases**: Leaderboards, rankings, time series
- **Operations**: ZADD, ZRANGE, ZRANK, ZSCORE

## 🛡️ Best Practices

### Performance Optimization
- Use appropriate data types for your use case
- Set expiration times for temporary data
- Use pipelining for multiple operations
- Monitor memory usage with INFO command

### Security
- Configure authentication with requirepass
- Use Redis ACLs for user management
- Disable dangerous commands in production
- Use SSL/TLS for network encryption

### Memory Management
- Set maxmemory policy for automatic eviction
- Use memory-efficient data structures
- Monitor memory usage and fragmentation
- Regular maintenance with BGSAVE

### Monitoring
```redis
# Check server information
INFO memory
INFO stats
INFO replication

# Monitor commands in real-time
MONITOR
```

## 📚 Learning Path

1. **Basic Commands**: Start with string operations and key management
2. **Data Types**: Learn lists, sets, hashes, and sorted sets
3. **Advanced Features**: Expiration, transactions, pub/sub
4. **Performance**: Optimization, monitoring, and scaling
5. **Production**: Security, backup, and high availability
6. **Integration**: Use with applications and frameworks
# Apache Kafka - Distributed Streaming Platform

## 📋 Overview
Comprehensive Kafka command reference, configuration examples, and Docker deployment setups for distributed streaming and messaging.

## 📁 Contents

<details>
<summary>📄 kafka.txt - Legacy Kafka Commands</summary>

### Classic Kafka Operations
- **Broker Management**: Start/stop Kafka brokers
- **Topic Operations**: Create, list, describe, and delete topics
- **Producer/Consumer**: Command-line producer and consumer tools
- **Partition Management**: Partition assignment and rebalancing
- **Offset Management**: Consumer group offset operations

### Legacy Configuration
- **Server Properties**: Traditional server.properties configuration
- **Consumer/Producer**: Legacy client configurations
- **Zookeeper Integration**: Zookeeper-dependent operations

</details>

<details>
<summary>📄 new kafka.txt - Modern Kafka Commands</summary>

### KRaft Mode Operations
- **Cluster Management**: KRaft (Kafka Raft) mode commands
- **Metadata Management**: Self-managed metadata without Zookeeper
- **Modern CLI**: Updated kafka-topics, kafka-console-producer/consumer
- **Performance**: Improved performance and simplified operations

### New Features
- **Exactly-Once Semantics**: Transactional messaging
- **Streams API**: Stream processing capabilities
- **Connect API**: Kafka Connect for data integration

</details>

<details>
<summary>📄 Properties.txt - Zookeeper Configuration</summary>

### Zookeeper Properties
- **Connection Settings**: Zookeeper connection strings and timeouts
- **Session Management**: Session timeout and heartbeat configurations
- **Ensemble Setup**: Multi-node Zookeeper cluster configuration
- **Security**: Authentication and authorization settings

### Integration Settings
- **Kafka-Zookeeper**: Coordination between Kafka and Zookeeper
- **Metadata Storage**: Topic and partition metadata management
- **Leader Election**: Broker leader election process

</details>

<details>
<summary>📄 Kafka Configuration.txt - Broker Properties</summary>

### Core Broker Settings
- **Network Configuration**: Listeners, advertised listeners, ports
- **Storage Configuration**: Log directories, retention policies
- **Replication**: Replication factor, ISR management
- **Performance Tuning**: Batch size, compression, memory settings

### Advanced Configuration
- **Security**: SSL/TLS, SASL authentication
- **Monitoring**: JMX metrics and monitoring setup
- **Resource Management**: Memory, CPU, and disk optimization

</details>

<details>
<summary>📁 Kafka Docker - Containerized Deployments</summary>

### Cluster Setup
- **Multi-Broker Cluster**: Docker Compose for Kafka cluster
- **Zookeeper Ensemble**: Coordinated Zookeeper setup
- **Network Configuration**: Inter-container communication
- **Volume Management**: Persistent data storage

### Compose Configurations
- **Development Setup**: Single-node development environment
- **Production Setup**: Multi-node production-ready cluster
- **Scaling**: Horizontal scaling configurations

### Custom Images
- **Dockerfile**: Custom Kafka image with specific configurations
- **Runner Scripts**: Startup and initialization scripts
- **Environment Variables**: Dynamic configuration management

### Security Configurations
#### SASL-Plain Authentication
- **Plain Text Authentication**: Username/password authentication
- **Client Configuration**: Producer/consumer authentication setup
- **Broker Configuration**: Server-side authentication settings

#### SASL-SSL Authentication
- **Certificate Management**: SSL certificate generation and management
- **Encrypted Communication**: End-to-end encryption setup
- **Mutual Authentication**: Client and server certificate validation
- **Key Store/Trust Store**: Certificate store management

</details>

## 🚀 Quick Start Guide

### 1. Traditional Kafka with Zookeeper
```bash
# Start Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start Kafka
bin/kafka-server-start.sh config/server.properties

# Create topic
bin/kafka-topics.sh --create --topic test --bootstrap-server localhost:9092
```

### 2. Modern KRaft Mode
```bash
# Generate cluster ID
bin/kafka-storage.sh random-uuid

# Format storage
bin/kafka-storage.sh format -t <uuid> -c config/kraft/server.properties

# Start Kafka
bin/kafka-server-start.sh config/kraft/server.properties
```

### 3. Docker Deployment
```bash
# Simple setup
docker-compose up -d

# With authentication
docker-compose -f docker-compose-sasl.yml up -d
```

## 🔧 Common Operations

### Topic Management
```bash
# Create topic with partitions and replication
kafka-topics.sh --create --topic my-topic --partitions 3 --replication-factor 2

# List topics
kafka-topics.sh --list --bootstrap-server localhost:9092

# Describe topic
kafka-topics.sh --describe --topic my-topic --bootstrap-server localhost:9092
```

### Producer/Consumer
```bash
# Console producer
kafka-console-producer.sh --topic my-topic --bootstrap-server localhost:9092

# Console consumer
kafka-console-consumer.sh --topic my-topic --from-beginning --bootstrap-server localhost:9092
```

### Consumer Groups
```bash
# List consumer groups
kafka-consumer-groups.sh --list --bootstrap-server localhost:9092

# Describe consumer group
kafka-consumer-groups.sh --describe --group my-group --bootstrap-server localhost:9092
```

## 🛡️ Security Setup

### SASL-Plain Configuration
```properties
# Server configuration
sasl.enabled.mechanisms=PLAIN
sasl.mechanism.inter.broker.protocol=PLAIN
security.inter.broker.protocol=SASL_PLAINTEXT
```

### SSL Configuration
```properties
# SSL settings
security.protocol=SSL
ssl.keystore.location=/path/to/keystore.jks
ssl.keystore.password=password
ssl.truststore.location=/path/to/truststore.jks
```

## 📚 Learning Path

1. **Start with**: Properties.txt for understanding Zookeeper integration
2. **Basic operations**: kafka.txt for traditional commands
3. **Modern approach**: new kafka.txt for KRaft mode
4. **Configuration**: Kafka Configuration.txt for tuning
5. **Containerization**: Docker setups for deployment
6. **Security**: SASL and SSL configurations for production
# ELK Stack - Elasticsearch, Logstash & Kibana

## 📋 Overview
Complete Elastic Stack configuration and setup guide with practical examples for log processing, monitoring, and data analysis.

## 📁 Contents

<details>
<summary>📄 Setup.txt - Elasticsearch Installation</summary>

### Local Setup Guide
- **Installation**: Step-by-step Elasticsearch local installation
- **Configuration**: Basic cluster and node configuration
- **Startup**: Service startup and verification commands
- **Troubleshooting**: Common setup issues and solutions

</details>

<details>
<summary>📄 ElasticsSearch.docx - Use Cases & Queries</summary>

### Query Examples
- **Search Queries**: Match, term, range, and boolean queries
- **Aggregations**: Bucket and metric aggregations
- **Mappings**: Index mapping and field configurations
- **Performance**: Query optimization and best practices

### Use Case Scenarios
- **Log Analysis**: Application and system log processing
- **Monitoring**: Real-time system monitoring setup
- **Analytics**: Business intelligence and data analytics

</details>

<details>
<summary>📁 FileBeat - Log Shipping</summary>

### Configuration Files
- **filebeat.yml**: Complete Filebeat configuration
  - Input sources (log files, directories)
  - Output destinations (Elasticsearch, Logstash)
  - Processors and filtering
  - Monitoring and logging settings

### Features
- **Log Harvesting**: Automatic log file discovery
- **Backpressure Handling**: Built-in flow control
- **Multiline Support**: Handle stack traces and multi-line logs

</details>

<details>
<summary>📁 HeartBeat - Uptime Monitoring</summary>

### Configuration Files
- **heartbeat.yml**: Main Heartbeat configuration
- **my_first.yml**: Demo monitoring configuration
- **http_dashboard.ndjson**: Pre-built Kibana dashboard

### Monitoring Types
- **HTTP/HTTPS**: Web service availability monitoring
- **TCP**: Port connectivity checks
- **ICMP**: Network ping monitoring

### Dashboard Features
- **Uptime Visualization**: Service availability charts
- **Alert Configuration**: Downtime notifications
- **Response Time Tracking**: Performance monitoring

</details>

<details>
<summary>📁 Logstash Configuration - Data Processing Pipeline</summary>

### Input Sources
- **CSV**: Process CSV files with custom schemas
- **JSON**: Handle JSON data with nested structures
- **Kafka**: Consume data from Kafka topics
- **MySQL**: Database change data capture
- **S3**: Process files from AWS S3 buckets
- **HTTP API**: REST API data ingestion
- **Log Files**: Application and system logs

### Processing & Filtering
- **Grok Filter**: Parse unstructured log data
  - Single pattern matching
  - Multi-pattern configurations
  - Custom pattern definitions
- **Data Transformation**: Field manipulation and enrichment
- **Conditional Processing**: Route data based on conditions

### Output Destinations
- **Elasticsearch**: Index processed data
- **File Output**: Write to local files
- **Multiple Outputs**: Fan-out to multiple destinations

### Example Configurations
- **CSV Processing**: `csv-schema-short-numerical.conf`
- **Grok Patterns**: `single_pattern.conf`, `multi_pattern.conf`
- **API Integration**: `http_api_call.conf`
- **Database Sync**: `mysql_to_elasticsearch_first.conf`

</details>

<details>
<summary>📄 Other Logstash Settings.txt - Testing & URLs</summary>

### Testing Resources
- **Test URLs**: Endpoints for configuration testing
- **Sample Data**: Test datasets for pipeline validation
- **Debugging**: Troubleshooting and logging configurations

</details>

## 🚀 Quick Start Guide

### 1. Setup Elasticsearch
```bash
# Start Elasticsearch
./bin/elasticsearch

# Verify installation
curl -X GET "localhost:9200/"
```

### 2. Configure Filebeat
```yaml
# Basic filebeat.yml
filebeat.inputs:
- type: log
  paths:
    - /var/log/*.log
output.elasticsearch:
  hosts: ["localhost:9200"]
```

### 3. Setup Logstash Pipeline
```bash
# Run with configuration
./bin/logstash -f /path/to/config.conf
```

### 4. Monitor with Heartbeat
```yaml
# Basic heartbeat.yml
heartbeat.monitors:
- type: http
  urls: ["http://localhost:9200"]
  schedule: '@every 10s'
```

## 🔧 Common Use Cases

### Log Processing Pipeline
1. **Filebeat** → Collect logs from multiple sources
2. **Logstash** → Parse, filter, and enrich data
3. **Elasticsearch** → Store and index processed data
4. **Kibana** → Visualize and analyze data

### Monitoring Stack
1. **Heartbeat** → Monitor service availability
2. **Metricbeat** → Collect system metrics
3. **Elasticsearch** → Store monitoring data
4. **Kibana** → Create monitoring dashboards

## 📚 Learning Path

1. **Start with**: Setup.txt for basic installation
2. **Learn queries**: ElasticsSearch.docx for search capabilities
3. **Ship logs**: FileBeat configuration and setup
4. **Process data**: Logstash pipeline configurations
5. **Monitor services**: HeartBeat uptime monitoring
6. **Advanced**: Custom grok patterns and complex pipelines
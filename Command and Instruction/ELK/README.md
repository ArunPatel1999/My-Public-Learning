# ELK - Elastic Stack 

```
In this folder, I am storing Elastic Stack-related commands.

1) Setup.txt  
   Contains instructions on how to set up Elasticsearch locally.

2) Elasticsearch.docx  
   Contains multiple use cases for Elasticsearch and explains which queries and configurations to use in different scenarios.

3) FileBeat Folder  
   Contains the `filebeat.yml` configuration file for Filebeat.

4) Heartbeat Folder  
   i) `heartbeat.yml`  
      Contains configuration related to Heartbeat.  
      
   ii) `http_dashboard.ndjson`  
      Contains configuration for the Heartbeat dashboard.
      
   iii) `my_first.yml`  
      Contains a demo configuration for Elasticsearch Heartbeat.

5) Logstash Configuration  
   Contains demo configurations for Logstash.  

   i) CSV  
      Explains how to load CSV file configuration and data.  
      
   ii) Grok Filter  
      The `grok_filter` is applied after loading data to perform filtering operations.  
      
   iii) Input Plugin  
      Contains API call-related configurations used to load data into Elasticsearch.  
      
   iv) JSON  
      Contains JSON-related data configurations and how to load JSON data into Elasticsearch.  
      
   v) Kafka  
      Used to consume data from Kafka topics.  
      
   vi) logsConfig  
      Demonstrates how to load logs into Elasticsearch.  
      
   vii) MySQL  
      Configurations related to MySQL operations, such as triggering new actions when data is added.  
      
   viii) S3  
      Contains S3 configurations and triggers for operations.

6) Other Logstash Settings.txt  
   Contains URLs for testing Logstash.

```
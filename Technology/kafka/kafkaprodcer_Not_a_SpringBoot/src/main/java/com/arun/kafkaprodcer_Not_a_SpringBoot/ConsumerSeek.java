package com.arun.kafkaprodcer_Not_a_SpringBoot;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerSeek {

	public static void main(String[] args) {
		
		Logger  log = LoggerFactory.getLogger(ConsumerSeek.class);
		
		Properties properties = new Properties();
    	properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    	properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); //like from begnning
		
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
	
		TopicPartition partition = new TopicPartition("new-topic-1", 0);
		
		consumer.assign(Arrays.asList(partition));
	
		consumer.seek(partition, 15L);
		int totalNumberOfLine = 5;
		boolean stopIndicater = true;
		int currentNumberOfLine = 0;
		
		while (stopIndicater) {
			ConsumerRecords<String, String> recode = consumer.poll(Duration.ofMillis(100));
			
			for (ConsumerRecord<String, String> reco : recode) {
				currentNumberOfLine++;
				log.info("key :"+reco.key()+ " , value : "+reco.value());
				log.info("Partition :"+reco.partition()+ " , Offset : "+reco.offset());
				if(currentNumberOfLine == totalNumberOfLine) {
					stopIndicater = false;
					break;}
			}
			
		}
    	log.info("out");
		
    	
	}
	
}

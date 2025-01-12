package com.arun.kafkaprodcer_Not_a_SpringBoot;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer {

	public static void main(String[] args) {
		
		Logger  log = LoggerFactory.getLogger(Consumer.class);
		
		Properties properties = new Properties();
    	properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    	properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "new-topic-1-second-group");
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); //like from begnning
		
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
		
		consumer.subscribe(Arrays.asList("new-topic-1"));
		
		while (true) {
			ConsumerRecords<String, String> recode = consumer.poll(Duration.ofMillis(100));
			
			for (ConsumerRecord<String, String> reco : recode) {
				log.info("key :"+reco.key()+ " , value : "+reco.value());
				log.info("Partition :"+reco.partition()+ " , Offset : "+reco.offset());
			}
			
		}
    	
		
    	
	}
	
}

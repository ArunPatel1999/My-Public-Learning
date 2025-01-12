package com.arun.kafkaprodcer_Not_a_SpringBoot;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer1 {
    public static void main( String[] args )    {
    	
    	
    	Properties properties = new Properties();
    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	
    	//===========Produce More Safte TO Data Lose===========
    	
    	properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
    	properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
    	properties.setProperty(ProducerConfig.RETRIES_CONFIG, ""+Integer.MAX_VALUE);
    	properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
    	
    	//================Comprsen ==============
    	properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
    	properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20"); //20ms
    	properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32*1024));
    	
    	KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
    	
    	Scanner input = new Scanner(System.in);
    	boolean stop =false;
    	
    	//===========Normal Send===================
    	
    	do {
    		System.out.print("Enter new Line else type 'exit' :");
    		String ms = input.nextLine();
    		
    		if(ms.equals("exit"))
    			stop =true;
    
        	producer.send(new ProducerRecord<>("new-topic-1", ms));
        	
		}while(!stop);
    	
    
    	producer.flush();
    	producer.close();
    	input.close();
    	
    }
}

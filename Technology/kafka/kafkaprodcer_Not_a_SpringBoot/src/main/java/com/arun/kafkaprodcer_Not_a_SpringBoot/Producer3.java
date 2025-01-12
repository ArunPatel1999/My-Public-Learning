package com.arun.kafkaprodcer_Not_a_SpringBoot;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer3 {
    public static void main( String[] args )    {
    	
    	Logger log = LoggerFactory.getLogger(Producer3.class);
    	
    	Properties properties = new Properties();
    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	
    	KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
    	
    	Scanner input = new Scanner(System.in);
    	boolean stop =false;
    
    	System.out.print("Send with key");
    	int i=0;
    	do {
    		System.out.print("Enter new Line else type 'exit' :");
    		String ms = input.nextLine();
    		
    		if(ms.equals("exit"))
    			stop =true;
    
        	producer.send(new ProducerRecord<>("new-topic-1", "id_"+(i++), ms), (metadata, exception) -> {
				if(exception == null) 
					System.out.println(metadata.topic()+" ,"+metadata.timestamp() +" ,"+ metadata.partition()+" ,"+metadata.offset());
				else 
					log.error(exception.getLocalizedMessage());
				
					
				});
        	
		}while(!stop);
    	
    	
    	producer.flush();
    	producer.close();
    	input.close();
    	
    }
}

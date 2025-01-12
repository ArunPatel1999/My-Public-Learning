package com.arun.kafkaprodcer_Not_a_SpringBoot;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class One implements Runnable {

	private Properties properties;
	private KafkaConsumer<String, String> consumer ;
	Logger  log = LoggerFactory.getLogger(One.class);
	private CountDownLatch latch ;
	
	public One(CountDownLatch latch) {
		super();
		properties = new Properties();
    	properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    	properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
    	properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "new-topic-1-third-group");
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); //like from begnning
		
		consumer = new KafkaConsumer<>(properties);
		this.latch = latch;
	}



	@Override
	public void run() {
		consumer.subscribe(Arrays.asList("new-topic-1"));
		try {
		while (true) {
			
			ConsumerRecords<String, String> recode = consumer.poll(Duration.ofMillis(100));
			
			for (ConsumerRecord<String, String> reco : recode) {
				log.info("key :"+reco.key()+ " , value : "+reco.value());
				log.info("Partition :"+reco.partition()+ " , Offset : "+reco.offset());
			}
			
		}}catch (WakeupException e) {
			log.info("reading exit time");
		}finally {
			consumer.close();
			latch.countDown();
		}
	}
	
	
	public void sutdown() {
		consumer.wakeup();
	}
	
}


public class ConsumerWithTread {

	public static void main(String[] args)  {
		Logger  log = LoggerFactory.getLogger(Consumer.class);
		CountDownLatch latrch = new CountDownLatch(1);
		One one = new One(latrch);
	
		Thread t = new Thread(one);
		t.start();
		
		Runtime.getRuntime().addShutdownHook(new Thread(() ->{ 
			log.info("caught shoutdown");
			one.sutdown();
		}));
		
		try {
			latrch.await();
		} catch (InterruptedException e) {
			log.error(e.getLocalizedMessage());
		}	finally {
			log.info("applocat closed");
		}
		
    	
	}
	
	
	
}

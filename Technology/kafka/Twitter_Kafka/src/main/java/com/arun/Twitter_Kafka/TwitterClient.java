package com.arun.Twitter_Kafka;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

public class TwitterClient {

	private String consumerKey;
	private String consumerSecret;
	private String token;
	private String secret;
	
	public static void main(String[] args) {
		new TwitterClient().run();
		
	}
	
	public void	run(){
		
		System.out.println("Start\n");
		
		BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>(1000);
		
		Client client = getClient(msgQueue);
		client.connect();
		
		KafkaProducer<String, String> producer = getProducer();
		
		while (!client.isDone()) {
			String msg = null;
			try {
				msg = msgQueue.poll(5, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
				client.stop();
			}
			if(msg != null) {
				System.out.println(msg);
				producer.send(new ProducerRecord<>("twitter-testing",  msg), (metadata, exception) -> {
					if(exception != null)  
						System.out.println("Somting Erfror on produce data");
				});
			}
		}
		
		System.out.println("\nApplication End.\n");
	}
	
	private Client getClient(BlockingQueue<String> msgQueue) {
		
		Hosts hosebirdHoster =  new HttpHosts(Constants.STREAM_HOST);
		StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
		
		List<String> trems = Lists.newArrayList("modi","khansir");
		hosebirdEndpoint.trackTerms(trems);
		
		Authentication hoseAuth = new OAuth1(consumerKey, consumerSecret, token, secret);
		
		return new ClientBuilder().name("Hosebird-Client-01").hosts(hosebirdHoster).authentication(hoseAuth).endpoint(hosebirdEndpoint).processor(new StringDelimitedProcessor(msgQueue)).build();
	}
	
	private KafkaProducer<String, String> getProducer(){
		Properties properties = new Properties();
    	properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
    	properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    	
    	properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
    	properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
    	properties.setProperty(ProducerConfig.RETRIES_CONFIG, ""+Integer.MAX_VALUE);
    	properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");
    	
    	properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
    	properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "20"); //20ms
    	properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32*1024));
    	
    	return new KafkaProducer<>(properties);
    }
}

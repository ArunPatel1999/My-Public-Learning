package com.arun.Kafka_ElsewticSerch;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.elasticsearch.action.bulk.BulkAction;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import com.google.gson.JsonParser;

public class App {

	private static RestHighLevelClient creatClient() {

		String hostName = "kafka-testing-6923819340.ap-southeast-2.bonsaisearch.net";
		String userName = "zx7NmQXYfh";
		String password = "7VgT5udnG4KMDJyYmvAe";

		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));
		RestClientBuilder builder = RestClient.builder(new HttpHost(hostName, 443, "https"))
				.setHttpClientConfigCallback(
						httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));
		return new RestHighLevelClient(builder);
	}

	private static KafkaConsumer<String, String> kafkaConsumer(String topic) {
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // like from begnning
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "kafka-elsetic-serch"); // use hear beracuse data not
																						// save duplicate in database
		properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false"); // user for manualy commit use for
																					// commit that way no duplicat
																					// stored in database
		properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10"); // fatch data 10 than 10 than 10

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
		consumer.subscribe(Arrays.asList(topic));
		return consumer;
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		RestHighLevelClient client = creatClient();

		KafkaConsumer<String, String> consumer = kafkaConsumer("twitter-testing");

		while (true) {
			ConsumerRecords<String, String> recode = consumer.poll(Duration.ofMillis(100));

			int z = recode.count();
			System.out.println("Recode Size : " + z);

			BulkRequest bulkAdd = new BulkRequest();

			for (ConsumerRecord<String, String> reco : recode) {
				try {
					IndexRequest indexRequest = new IndexRequest("twitter", "tweets", extractId(reco.value()))
							.source(reco.value(), XContentType.JSON);
					// IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
					// use for single inserting

					bulkAdd.add(indexRequest);
				} catch (Exception e) {
					System.out.println("Bad Data : " + reco.value());
				}
			}

			if (z > 0) {
				BulkResponse bulkResponse = client.bulk(bulkAdd, RequestOptions.DEFAULT);

				System.out.println("commiting commiting 10 data");
				consumer.commitSync();
				Thread.sleep(1000);
			}
		}

		// client.close();
	}

	private static JsonParser jsonParser = new JsonParser();

	private static String extractId(String value) {
		return jsonParser.parse(value).getAsJsonObject().get("id_str").getAsString();
	}
}

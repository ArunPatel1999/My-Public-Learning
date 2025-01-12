package com.arun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfigration {

	private String accessKey;
	private String secretKey;
	private String region;
	private String serviceEndpoint;
	
	public DynamoDBConfigration(@Value("${aws.accessKey}") String accessKey,@Value("${aws.secretKey}")  String secretKey,
			@Value("${aws.region}")  String region,@Value("${aws.serviceEndpoint}")  String serviceEndpoint) {
		super();
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.region = region;
		this.serviceEndpoint = serviceEndpoint;
	}

	@Bean
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(amazonDynamoDB());
	}

	@SuppressWarnings("static-access")
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClient.builder().standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(serviceEndpoint, region)
						)
				.withCredentials(
						new AWSStaticCredentialsProvider(
								new BasicAWSCredentials(accessKey, secretKey))
						).build();
	
				
	}
	
	
}

package com.arun.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.arun.entitys.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductController {

	private ObjectMapper objectMapper = new ObjectMapper();;
	private AmazonDynamoDB builder = AmazonDynamoDBClientBuilder.defaultClient();
	private DynamoDB db =	new DynamoDB(builder);
	private Table  table = db.getTable(System.getenv("PRODUCT_TABLE"));

	public APIGatewayProxyResponseEvent getAll() throws JsonProcessingException {
		
		ScanResult scanResult =	builder.scan(new ScanRequest().withTableName(System.getenv("PRODUCT_TABLE")));
		List<Product> products = scanResult.getItems().stream().map(data -> new Product(Integer.parseInt(data.get("id").getN()), data.get("name").getN(), Double.parseDouble(data.get("price").getN()), Double.parseDouble(data.get("quantity").getN()), data.get("status").getBOOL())).collect(Collectors.toList());
		return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody(objectMapper.writeValueAsString(products));
	}
	
	public APIGatewayProxyResponseEvent save(APIGatewayProxyRequestEvent request) throws JsonProcessingException {
		Product product = objectMapper.readValue(request.getBody(), Product.class);
		Item item = new Item().withPrimaryKey("id",product.getId())
					.withString("name", product.getName())
					.withDouble("price", product.getPrice())
					.withDouble("quantity", product.getQuantity())
					.withBoolean("status", product.isStatus());
		
		table.putItem(item);
		product.setStatus(true);
		return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody(objectMapper.writeValueAsString(product));
	}
	
	
	
	
}

package com.mtraders.demo.controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;
import com.mtraders.demo.entity.User;



@RestController
@RequestMapping("/api/rest")
public class StringToJsonConvter {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping("location")
	public Object getLocation() throws RestClientException, JSONException  {
		String date = getJsonData();
		
		return JsonPath.read(date, "$.rows[0]..elements[0].distance.value");
		
	}
	
	@GetMapping("/test")
	public List<Map<String, Object>> getData() throws JSONException, JsonProcessingException{
		List<Map<String, Object>> result = new LinkedList<>();
		
		Map<String, Object> map;
		
		String data = getSecondJson();
		
		JSONArray jsonArray = new JSONArray(data.substring(data.indexOf("data")+6, data.lastIndexOf("pagination")));
		
		for(int i=0; i<jsonArray.length();i++) {
			map = new LinkedHashMap<>();
			String newData =	jsonArray.get(0).toString();
			map.put("user_id", JsonPath.read(newData,"user_id"));
			map.put("user_name", JsonPath.read(newData,"user_name"));
			map.put("type", JsonPath.read(newData,"type"));
			map.put("thumbnail_url", JsonPath.read(newData,"thumbnail_url"));
			
			result.add(map);
		}
		return result;
	}
	
	
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return headers;
	}

	private String getJsonData() {
		return "{\r\n"
				+ "   \"destination_addresses\":[\r\n"
				+ "      \"111, Kamatghar, Bhiwandi, Maharashtra 421302, India\",\r\n"
				+ "      \"Temghar Rd, Themghar, Bhiwandi, Maharashtra 421308, India\"\r\n"
				+ "   ],\r\n"
				+ "   \"origin_addresses\":[\r\n"
				+ "      \"421302, Dhamankar Naka, Padma Nagar, Bhiwandi, Maharashtra 421302, India\"\r\n"
				+ "   ],\r\n"
				+ "   \"rows\":[\r\n"
				+ "      {\r\n"
				+ "         \"elements\":[\r\n"
				+ "            {\r\n"
				+ "               \"distance\":{\r\n"
				+ "                  \"text\":\"0.9 km\",\r\n"
				+ "                  \"value\":930\r\n"
				+ "               },\r\n"
				+ "               \"duration\":{\r\n"
				+ "                  \"text\":\"3 mins\",\r\n"
				+ "                  \"value\":203\r\n"
				+ "               },\r\n"
				+ "               \"status\":\"OK\"\r\n"
				+ "            },\r\n"
				+ "            {\r\n"
				+ "               \"distance\":{\r\n"
				+ "                  \"text\":\"4.6 km\",\r\n"
				+ "                  \"value\":4622\r\n"
				+ "               },\r\n"
				+ "               \"duration\":{\r\n"
				+ "                  \"text\":\"14 mins\",\r\n"
				+ "                  \"value\":861\r\n"
				+ "               },\r\n"
				+ "               \"status\":\"OK\"\r\n"
				+ "            }\r\n"
				+ "         ]\r\n"
				+ "      }\r\n"
				+ "   ],\r\n"
				+ "   \"status\":\"OK\"\r\n"
				+ "}";
	}
	
	public String getSecondJson() {
		return "{\r\n"
				+ "    \"data\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": \"\",\r\n"
				+ "            \"user_id\": \"\",\r\n"
				+ "            \"user_login\": \"southeymusic\",\r\n"
				+ "            \"user_name\": \"southeymusic\",\r\n"
				+ "            \"game_id\": \"ddsfd\",\r\n"
				+ "            \"game_name\": \"Music\",\r\n"
				+ "            \"type\": \"live\",\r\n"
				+ "            \"title\": \"Live Loops, Originals, Covers  !sl !presave !leuven\",\r\n"
				+ "            \"viewer_count\": 1341,\r\n"
				+ "            \"started_at\": \"2021-10-12T07:05:20Z\",\r\n"
				+ "            \"language\": \"en\",\r\n"
				+ "            \"thumbnail_url\": \"https://static-cdn.jtvnw.net/previews-ttv/live_user_southeymusic-{width}x{height}.jpg\",\r\n"
				+ "            \"tag_ids\": [\r\n"
				+ "                \"6ea6bca4-4712-\",\r\n"
				+ "                \"325f7a22--4ad7-be48-f464de0b89ce\",\r\n"
				+ "                \"22c54bdc--4612-9a9f-883b33b9f69d\",\r\n"
				+ "                \"8c1ada77--a1b0-a02dc65f28b4\",\r\n"
				+ "                \"e46ae70e--a2f79721d1f6\"\r\n"
				+ "            ],\r\n"
				+ "            \"is_mature\": false\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"pagination\": {}\r\n"
				+ "}";
	}
}

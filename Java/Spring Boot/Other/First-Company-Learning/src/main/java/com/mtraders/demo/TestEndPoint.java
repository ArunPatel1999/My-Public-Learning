package com.mtraders.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "testEnd")
public class TestEndPoint {

	private final Map<String, Feature> map = new ConcurrentHashMap<>();
	
	public TestEndPoint() {
		map.put("User",new Feature(true));
		map.put("Employee",new Feature(false));
		map.put("Last",new Feature(true));
	}
	
	@ReadOperation
	public Map<String, Feature> test() {
		return map;
	}
	
	@ReadOperation
	public Feature testLast(@Selector String name) {
		return map.get(name);
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Feature {
		private boolean status;
	}
			
}

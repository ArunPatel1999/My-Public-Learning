package com.enter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections4.map.HashedMap;

public class FlatMapAndMap {
	public static void main(String[] args) {
		
		Map<Integer, List<String>> map = new HashedMap<>();
		map.put(1, Arrays.asList("Test1", "Test1-2"));
		map.put(4, Arrays.asList("Test4", "Test4-5"));
		map.put(6, Arrays.asList("Test2", "Test2-2"));
		map.put(2, Arrays.asList("Test6", "Test6-2"));
		
		//all data as it is 
		List<Stream<String>> normalMap = map.values().stream().map(Collection::stream).collect(Collectors.toList());
		
		//all in single list 
	 	List<String> flatMap = map.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
	}
}

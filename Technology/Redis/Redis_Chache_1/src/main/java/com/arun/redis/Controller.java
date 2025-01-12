package com.arun.redis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CacheConfig(cacheNames = {"user"})
public class Controller {

	private List<User> list;
	
	public Controller() {
		list = Arrays.asList(
				new User(1, "First", "adreres 1", 12, LocalDate.now()),
				new User(2, "Second", "adreres 2", 25, LocalDate.now()),
				new User(3, "Third", "adreres 3", 46, LocalDate.now()),
				new User(4, "Fourt", "adreres 4", 10, LocalDate.now())
				);
	}



	@GetMapping
	@Cacheable("user")
	public List<User> getAll(){
		System.out.println("run all");
		return list;
	}
	
	@GetMapping("/{id}")
	@Cacheable(key = "#id")
	public User getById(@PathVariable  int id){
		System.out.println("get By Id "+id);
		return list.stream().filter(x -> x.getId()==id).collect(Collectors.toList()).get(0);
	}
	
	
	
}

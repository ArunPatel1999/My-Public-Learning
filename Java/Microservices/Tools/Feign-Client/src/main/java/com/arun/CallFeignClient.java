package com.arun;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "https://jsonplaceholder.typicode.com/posts", name = "POST")
public interface CallFeignClient {
	
	@GetMapping
	public List<Post> getAll();
	
	@GetMapping("/{id}")
	public Post getById(@PathVariable int id);

	@PostMapping
	public Post save(@RequestBody Post post);
}

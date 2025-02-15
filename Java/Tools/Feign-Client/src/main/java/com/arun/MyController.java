package com.arun;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	private CallFeignClient callFeignClient;
	
	@GetMapping
	public List<Post> getAll(){
		return callFeignClient.getAll();
	}
	
	@GetMapping("/{id}")
	public Post getById(@PathVariable int id) {
		return callFeignClient.getById(id);
	}
	
	@PostMapping
	public Post save(@RequestBody Post post) {
		return callFeignClient.save(post);
	}
}

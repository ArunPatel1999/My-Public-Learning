package com.arun.redis.serviceANDController;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arun.redis.entity.Product;

@RestController
public class ProductService {

	private RedisTemplate<String, Object> repository;

	public ProductService(RedisTemplate<String, Object> repository) {
		super();
		this.repository = repository;
	}
	
	
	@GetMapping
	public List<Object>  getAll() {
		return repository.opsForHash().values(Product.tableName);
	}
	
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		 repository.opsForHash().putIfAbsent(Product.tableName, product.getId(), product);
		 return product;
	}
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable int id) {
		return (Product)repository.opsForHash().get(Product.tableName, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		repository.opsForHash().delete(Product.tableName, id);
		return "Product Delete Succesfull";
	}
	
	
}

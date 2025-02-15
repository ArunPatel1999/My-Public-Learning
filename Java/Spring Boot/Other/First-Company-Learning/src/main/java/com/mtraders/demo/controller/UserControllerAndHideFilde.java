package com.mtraders.demo.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.api.client.util.Value;
import com.mtraders.demo.entity.User;
import com.mtraders.demo.service.UserMongoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/user")
public class UserControllerAndHideFilde {
	
	@Autowired
	private UserMongoService userData;
	
	
	@Value("${show.message}")
	private String message;
	

	@Operation(description = "this is get All",summary = "User For Fatching all User")
	@ApiResponses(value =  {
		@ApiResponse(responseCode = "200",
				description = "getAll Successfull",
				content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
		@ApiResponse(responseCode = "500",
		description = "getAll faild",
		content = @Content)
	})
	
	@GetMapping
	public ResponseEntity<Object> getAll() {
//		Optional<Set<String>> data =null;
//		if(data.isPresent())
//			return ResponseEntity.ok(filterData(data.get(), userData.getAll()));
//		else
			return ResponseEntity.ok(userData.getAll());
	}
	
	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return userData.getOne(id);
	}
	
	@PostMapping
	public String save(@Valid @RequestBody User user) {
		return userData.addUserWithoutImage(user);
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable int id,@RequestBody User user) {
		return userData.update(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deletString(@PathVariable int id) {
		return userData.delete(id);
	}
	
	private MappingJacksonValue filterData(Set<String> filde, Object data) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(filde);
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("USER", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(data);
		mappingJacksonValue.setFilters(filterProvider);
		return mappingJacksonValue;
	}
	
	
	
}

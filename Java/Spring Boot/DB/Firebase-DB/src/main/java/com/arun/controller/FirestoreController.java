package com.arun.controller;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.service.CRUDFirestore;

@RestController
@RequestMapping("/firestore")
public class FirestoreController {

	@Autowired
	private CRUDFirestore crudFirestore;
	
	@GetMapping
	public Object getAll() throws InterruptedException, ExecutionException {
		return  crudFirestore.getAll();
	}
	
	@GetMapping("/{id}")
	public Object getById(@PathVariable int id) throws InterruptedException, ExecutionException {
		return  crudFirestore.getById(id);
	}
	
	@PostMapping
	public String saveUserDetails(@RequestBody Map<String, Object> map) throws InterruptedException, ExecutionException {
		return crudFirestore.saveUserDetails(map);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) throws InterruptedException, ExecutionException {
		return crudFirestore.delete(id);
	}
	
}

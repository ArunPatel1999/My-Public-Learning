package com.company.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Company;
import com.company.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@GetMapping
	public List<Company> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Company getById(@PathVariable int id) throws Exception {
		return service.getById(id);
	}
	
	@PostMapping
	public Company save(@RequestBody Company user) {
		return service.save(user);
	}
	
	@PutMapping("/{id}")
	public Company updateUser(@PathVariable int id, @RequestBody Company userEdit) throws Exception {
		return service.edit(id, userEdit);
	}
	
	@PutMapping("addUser/{id}/{userId}")
	public Company addUser(@PathVariable int id, @PathVariable int userId) throws Exception {
		return service.addUser(id, userId);
	}
	
	@DeleteMapping("/{id}/{userId}")
	public Company removeUser(@PathVariable int id,@PathVariable int userId) throws Exception {
		return service.removeUser(id,userId);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteCompany(id);
	}
}

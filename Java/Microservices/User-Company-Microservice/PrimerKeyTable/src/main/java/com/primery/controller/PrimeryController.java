package com.primery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primery.entity.PrimerRepository;
import com.primery.entity.Primery;

@RestController
@RequestMapping("/api/primery")
public class PrimeryController {

	@Autowired
	private PrimerRepository repository;

	@GetMapping("/{tableName}")
	public int getLatestId(@PathVariable String tableName) {

		Primery primery = null;
		try {
			primery =	repository.findById(tableName).orElseThrow(() -> new Exception("Not Found"));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			primery = new Primery(tableName, 1);
		}

		primery.setId(primery.getId()+1);
		repository.save(primery);
		return primery.getId()-1;
	}

}

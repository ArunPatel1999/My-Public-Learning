package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.MicroSaving;
import com.demo.exception.CustomeException;
import com.demo.service.MicroSavingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/saving")
@AllArgsConstructor
public class MicroSavingController {

	private MicroSavingService microSavingService;
	
	
	@GetMapping("/{id}")
	public MicroSaving getById(@PathVariable long id) throws CustomeException {
		return microSavingService.getById(id);
	}
	
	@GetMapping("/getByGoalId/{goalId}")
	public List<MicroSaving> getByGoalId(@PathVariable int goalId) {
		return microSavingService.getByGoalId(goalId);
	}
	
	@PostMapping
	public MicroSaving save(@Valid @RequestBody MicroSaving microSaving) {
		return microSavingService.save(microSaving);
	}
	
}

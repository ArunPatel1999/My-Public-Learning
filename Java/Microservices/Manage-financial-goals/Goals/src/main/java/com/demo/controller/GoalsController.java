package com.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Goals;
import com.demo.exception.CustomeException;
import com.demo.service.GoalsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/goals")
@AllArgsConstructor
public class GoalsController {

	private GoalsService goalsService;
	
	@GetMapping("/{id}")
	public Goals getById(@PathVariable long id) throws CustomeException {
		return goalsService.getById(id);
	}
	
	@GetMapping("/getByUserId/{userId}")
	public List<Goals> getByUserId(@PathVariable int userId) {
		return goalsService.getByUserId(userId);
	}
	
	@GetMapping("/getFullDetailsOfGoals/goalId/{goalId}")
	public Map<String, Object> getFullDetailsOfGoals(@PathVariable int goalId) throws CustomeException {
		return goalsService.getFullDetailsOfGoals(goalId);
	}
	
	@PostMapping
	public Goals save(@Valid @RequestBody Goals goals) {
		return goalsService.save(goals);
	}
	
	@PutMapping("savingAdd/goalId/{id}/amount/{amount}/text/{text}")
	public boolean savingAdd(@PathVariable long id, @PathVariable double amount, @PathVariable String text) throws CustomeException{
		return goalsService.savingAdd(id, amount, text);
	}
	
	
}

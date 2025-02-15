package com.arun.lending.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.lending.VerfiedUser;
import com.arun.lending.entity.LoanApproved;
import com.arun.lending.entity.request.LoanApprovedGET;
import com.arun.lending.service.LoanApprovedService;

@RestController
@RequestMapping("/loanApproved")
public class LoanApprovedController {

	
	private LoanApprovedService loanApprovedService;
	private VerfiedUser verfiedUser;

	public LoanApprovedController(LoanApprovedService loanApprovedService, VerfiedUser verfiedUser) {
		super();
		this.loanApprovedService = loanApprovedService;
		this.verfiedUser = verfiedUser;
	}

	@GetMapping
	public List<LoanApproved> getAll(HttpServletRequest request) throws Exception{
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanApprovedService.getAll();
	}
	
	@GetMapping("/{id}")
	public LoanApproved getById(@PathVariable int id, HttpServletRequest request) throws Exception {
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanApprovedService.getById(id);
	}
	
	@PostMapping
	public LoanApproved save(@RequestBody LoanApprovedGET loanRequestGet, HttpServletRequest request) throws Exception {
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanApprovedService.save(loanRequestGet);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id, HttpServletRequest request) throws Exception {
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanApprovedService.deleteById(id);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> exceptionHandler(Exception e) {
		return ResponseEntity.status(404).body(e.getMessage());
	}
}

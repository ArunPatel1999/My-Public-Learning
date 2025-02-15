package com.arun.lending.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.lending.VerfiedUser;
import com.arun.lending.entity.LoanRequest;
import com.arun.lending.entity.request.LoanRequestGET;
import com.arun.lending.service.LoanRequestService;

@RestController
@RequestMapping("/loanRequest")
public class LoanRequestController {

	
	private LoanRequestService loanRequestService;
	private VerfiedUser verfiedUser;

	public LoanRequestController(LoanRequestService loanRequestService, VerfiedUser verfiedUser) {
		super();
		this.loanRequestService = loanRequestService;
		this.verfiedUser = verfiedUser;
	}

	@GetMapping
	public List<LoanRequest> getAll(HttpServletRequest request) throws Exception{
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanRequestService.getAll();
	}
	
	@GetMapping("/{id}")
	public LoanRequest getById(@PathVariable int id, HttpServletRequest request) throws Exception {
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanRequestService.getById(id);
	}
	
	@PostMapping
	public LoanRequest save(@RequestBody LoanRequestGET loanRequestGet, HttpServletRequest request) throws Exception {
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanRequestService.save(loanRequestGet);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id, HttpServletRequest request) throws Exception {
		verfiedUser.checkValideUser(request.getHeader("Authorization"));
		return loanRequestService.deleteById(id);
	}
}

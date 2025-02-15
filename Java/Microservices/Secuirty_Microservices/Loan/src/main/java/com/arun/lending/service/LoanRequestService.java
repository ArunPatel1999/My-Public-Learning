package com.arun.lending.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arun.lending.entity.LoanRequest;
import com.arun.lending.entity.User;
import com.arun.lending.entity.request.LoanRequestGET;
import com.arun.lending.repository.LoanRequestRepoitory;
import com.arun.lending.repository.UserRepository;

@Service
public class LoanRequestService {

	private LoanRequestRepoitory loanRequestRepoitory;
	private UserRepository userRepository;
	
	public LoanRequestService(LoanRequestRepoitory loanRequestRepoitory, UserRepository userRepository) {
		super();
		this.loanRequestRepoitory = loanRequestRepoitory;
		this.userRepository = userRepository;
	}


	public List<LoanRequest> getAll(){
		return loanRequestRepoitory.findAll();
	}
	
	public LoanRequest getById(int id) throws Exception {
		return loanRequestRepoitory.findById(id).orElseThrow(() -> new Exception("Loan Request Not Found"));
	}
	
	public LoanRequest save(LoanRequestGET requestGet) throws Exception  {
		User user =  userRepository.findById(requestGet.getUserId()).orElseThrow(() -> new Exception("User Not Found"));
		LoanRequest loanRequest = new LoanRequest(requestGet.getAmount(), requestGet.getDaysReturn(), requestGet.getIntersetRate(), new Date());
		loanRequest.setUser(user);
		return loanRequestRepoitory.save(loanRequest);
	}
	
	public String deleteById(int id) {
		loanRequestRepoitory.deleteById(id);
		return "delete successfull";
	}
	
}

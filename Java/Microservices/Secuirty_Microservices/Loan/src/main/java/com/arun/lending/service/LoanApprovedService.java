package com.arun.lending.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arun.lending.entity.LoanApproved;
import com.arun.lending.entity.User;
import com.arun.lending.entity.request.LoanApprovedGET;
import com.arun.lending.repository.LoanApprovedRepository;
import com.arun.lending.repository.UserRepository;

@Service
public class LoanApprovedService {

	private LoanApprovedRepository loanApprovedRepository;
	private UserRepository userRepository;
	
	public LoanApprovedService(LoanApprovedRepository loanApprovedRepository, UserRepository userRepository) {
		super();
		this.loanApprovedRepository = loanApprovedRepository;
		this.userRepository = userRepository;
	}
	
	public List<LoanApproved> getAll(){
		return loanApprovedRepository.findAll();
	}
	
	public LoanApproved getById(int id) throws Exception {
		return loanApprovedRepository.findById(id).orElseThrow(() -> new Exception("Loan Approved Not Found"));
	}
	
	public LoanApproved save(LoanApprovedGET loanApprovedGet) throws Exception {
		User user =  userRepository.findById(loanApprovedGet.getRequestUserId()).orElseThrow(() -> new Exception("User Not Found"));
		User mager =  userRepository.findById(loanApprovedGet.getAcceptUserId()).orElseThrow(() -> new Exception("Manger Not Found"));
		LoanApproved loanApproved = new LoanApproved(user, mager, loanApprovedGet.getAmount(), loanApprovedGet.getDaysReturn(), loanApprovedGet.getIntersetRate(), new Date());
		return loanApprovedRepository.save(loanApproved);
	}
	
	public String deleteById(int id) {
		loanApprovedRepository.deleteById(id);
		return "delete successfull";
	}
}

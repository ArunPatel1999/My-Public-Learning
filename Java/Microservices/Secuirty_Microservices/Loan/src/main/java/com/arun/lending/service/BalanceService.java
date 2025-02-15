package com.arun.lending.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.arun.lending.entity.Money;
import com.arun.lending.entity.User;
import com.arun.lending.repository.UserRepository;

@Service
public class BalanceService {

	private UserRepository usereRepository;

	public BalanceService(UserRepository usereRepository) {
		super();
		this.usereRepository = usereRepository;
	}
	
	@Transactional
	public void topUpBalance(Money money, String token) throws Exception {
		User user = findByUser(token);
		user.topUp(money);
	}

	
	public void widrawMoney(Money money, String token) throws Exception {
		User user = findByUser(token);
		user.withDraw(money);
	}
	
	private User findByUser(String token) throws Exception {
		return usereRepository.findById(token).orElseThrow(() -> new Exception("User Not Found"));
	}
}

package com.arun.lending.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.lending.entity.Money;
import com.arun.lending.service.BalanceService;

@RestController
@RequestMapping("/balance")
public class BalanceController {

	private BalanceService balanceService;

	public BalanceController(BalanceService balanceService) {
		super();
		this.balanceService = balanceService;
	}
	
	@PostMapping("/topup")
	public void topUp(@RequestBody Money money, @RequestHeader String authorization) throws Exception {
		balanceService.topUpBalance(money, authorization);
	}
	
	@PostMapping("/withdraw")
	public void withdraw(@RequestBody Money money, @RequestHeader String authorization) throws Exception {
		balanceService.widrawMoney(money, authorization);
	}
}

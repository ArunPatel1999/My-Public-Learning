package com.arun.lending.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.arun.lending.enums.Currency;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Money {

	@Id
	@GeneratedValue
	private int id;
	private Currency currency;
	private double amount;
	
	
	public Money add(Money money) {
		if(currency != money.getCurrency())
			throw new IllegalArgumentException();
		return new Money(currency, amount+money.getAmount());
	}
	
	
	public Money minus(Money money) {
		if(currency !=money.getCurrency() || amount < money.getAmount() )
			throw new IllegalArgumentException();
		return new Money(currency, amount-money.getAmount());
	}


	public Money(Currency currency, double amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}
	
}

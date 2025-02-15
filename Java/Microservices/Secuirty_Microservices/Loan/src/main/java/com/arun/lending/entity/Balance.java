package com.arun.lending.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;

import com.arun.lending.enums.Currency;

@Entity
public class Balance {

	@Id
	@GeneratedValue
	private int id;
	
	@ElementCollection
	@MapKeyClass(Currency.class)
	@OneToMany(cascade = CascadeType.ALL, targetEntity =  Money.class)
	private Map<Currency, Money> moneyMap = new LinkedHashMap<>();
	
	public void topUp(Money money) {
		if(moneyMap.get(money.getCurrency()) == null)
			moneyMap.put(money.getCurrency(), money);
		else
			moneyMap.put(money.getCurrency(), moneyMap.get(money.getCurrency()).add(money));
	}
	
	
	public void withdraw(Money money) {
		Money moneyInBalance = moneyMap.get(money.getCurrency());
		if(moneyInBalance == null)
			throw new IllegalStateException();
		else
			moneyMap.put(money.getCurrency(), moneyMap.get(money.getCurrency()).minus(money));
		}
	
}

package com.arun;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processer implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("Inside Processer ");
		return item.toUpperCase();
	}

}

package com.arun;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class Reader implements ItemReader<String> {

	private String[] data = {"aaa","bbb","cccc"};
	int count;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("inside reader");
		if(count < data.length)
			return data[count++];
		else
			count=0;
		return null;
	}

	
}

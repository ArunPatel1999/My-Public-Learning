package com.arun;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class Subscriber implements MessageListener {

	
	@Override
	public void onMessage(Message message, byte[] pattern) {
		System.out.println(message);
	}

}

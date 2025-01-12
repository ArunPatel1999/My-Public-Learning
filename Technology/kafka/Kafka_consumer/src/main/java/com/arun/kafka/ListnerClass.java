package com.arun.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ListnerClass {

	@KafkaListener(topics = "firstTest", groupId = "group_id")
	public void message(String message) {
		System.out.println("Producer : "+message);
	}

}

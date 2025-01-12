package com.arun.kafka.allInOne;

import java.util.Map;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduccer {

	private KafkaTemplate<String, String> template;
	private String topic;
	
	public KafkaProduccer(KafkaTemplate<String, String> template) {
		super();
		this.template = template;
		topic = "firstTest";
	}
	
	public void sendMeassge(Map<String, Object> message) {
		template.send(topic, message.toString());
	}

	
}

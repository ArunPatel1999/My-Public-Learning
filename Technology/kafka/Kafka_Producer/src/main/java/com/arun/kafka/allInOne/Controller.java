package com.arun.kafka.allInOne;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private KafkaProduccer kafkaProduccer;

	public Controller(KafkaProduccer kafkaProduccer) {
		super();
		this.kafkaProduccer = kafkaProduccer;
	}
	
	@PostMapping("send")
	public String send(@RequestBody Map<String, Object> map) {
		kafkaProduccer.sendMeassge(map);
		return "Message Send Succesful";
	}
	
	
}

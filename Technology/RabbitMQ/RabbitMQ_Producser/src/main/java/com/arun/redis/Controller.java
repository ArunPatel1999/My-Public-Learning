package com.arun.redis;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	
	
	private RabbitTemplate rabbitTemplate;
	
	public Controller(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}


	@PostMapping("/publisher")
	public String publis(@RequestBody Meaage meaage) {
		meaage.setDate(new Date());
		rabbitTemplate.convertAndSend(MQConfig.topicExchange, MQConfig.routingkey+".1", meaage);
		return "Meassege is publisg";
	}
	
}

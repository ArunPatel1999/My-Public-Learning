package com.arun.user.configaration;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.arun.user.UserDTO;
import com.google.gson.Gson;

@Component
public class MeassageSendEvent {


	private RabbitTemplate rabbitTemplate;
	private Gson gson;

	public MeassageSendEvent(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		gson= new Gson();
	}
	
	
	public boolean sendMessage(UserDTO user) {
		user.setPassword(null);
		rabbitTemplate.convertAndSend(MessageQConfigartion.TOPIC, "user.registered",gson.toJson(user));
		return true;
	}
	
	
	
}

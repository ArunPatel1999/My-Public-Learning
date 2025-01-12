package com.arun;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEntityController {

	private AmqpAdmin amqpAdmin;
	private RabbitTemplate rabbitTemplate;
	
	public TestEntityController(AmqpAdmin amqpAdmin, RabbitTemplate rabbitTemplate) {
		super();
		this.amqpAdmin = amqpAdmin;
		this.rabbitTemplate = rabbitTemplate;
	}



	@PostMapping
	public TestEntity send(@RequestBody TestEntity testEntity) {
		Queue queue = new Queue("CHATAPP", true);
		Binding binding = new Binding("CHATAPP", Binding.DestinationType.QUEUE, "test", "test."+testEntity.getRecvied(), null);
		amqpAdmin.declareQueue(queue);
		amqpAdmin.declareBinding(binding);
		rabbitTemplate.convertAndSend("test", "test."+testEntity.getRecvied(), testEntity);
		return testEntity;
	}
}

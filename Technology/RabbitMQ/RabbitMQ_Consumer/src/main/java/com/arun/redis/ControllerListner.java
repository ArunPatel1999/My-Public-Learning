package com.arun.redis;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerListner {

	@RabbitListener(queues = MQConfig.queue)
	public void readMesssage(Meaage message) {
		System.out.println(message);
	}
}

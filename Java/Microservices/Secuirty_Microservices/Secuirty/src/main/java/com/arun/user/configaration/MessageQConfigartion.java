package com.arun.user.configaration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class MessageQConfigartion {


	public static final String TOPIC =  "userRegisterTopic";
	public static final String QUEUE_NAME =  "user.registered";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME,false); //false delete queue after delete
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(TOPIC);
	}
	
	@Bean
	public ConnectionFactory ConnectionFactory() {
		return new ConnectionFactory();
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("user.#");
	}
	
	

}

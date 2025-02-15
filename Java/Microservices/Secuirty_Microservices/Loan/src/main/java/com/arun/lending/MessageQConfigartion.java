package com.arun.lending;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageQConfigartion {


	public static final String TOPIC =  "userRegisterTopic";
	public static final String QUEUE_NAME =  "user.registered.loan";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME,false); //false delete queue after delete
	}
	
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(TOPIC);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange topicExchange) {
		return BindingBuilder.bind(queue).to(topicExchange).with("user.#");
	}
	
	
	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
		SimpleMessageListenerContainer messageListener = new SimpleMessageListenerContainer();
		messageListener.setQueueNames(QUEUE_NAME);
		messageListener.setConnectionFactory(connectionFactory);
		messageListener.setMessageListener(messageListenerAdapter);
		return messageListener;
	}
	
	@Bean
	public MessageListenerAdapter userRegitserListner(UserRagistrationEventHandle registeration) {
		return new MessageListenerAdapter(registeration, "handleRegistration");
	}
	
	

}

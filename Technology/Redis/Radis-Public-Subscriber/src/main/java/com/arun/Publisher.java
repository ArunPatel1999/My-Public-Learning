package com.arun;

import java.util.Date;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

	private RedisTemplate<String, Object> redisTemplate;
	private ChannelTopic channelTopic;


	public Publisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
		this.redisTemplate = redisTemplate;
		this.channelTopic = channelTopic;
	}




	@PostMapping("/publish")
	public String publishDate(@RequestBody NormalEntity normalEntity) {
		normalEntity.setCreatedDate(new Date());
		redisTemplate.convertAndSend(channelTopic.getTopic(), normalEntity.toString());
		return "Published";
	}
	
}

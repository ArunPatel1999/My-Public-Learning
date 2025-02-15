package com.arun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MySerice {

	@Autowired
	private RestTemplate restTemplate;

	// backoff  wait for next
	@Retryable(value = Exception.class, maxAttempts = 2, backoff = @Backoff(multiplier = 2))
	public Object test() {
		System.out.println("run...");
		if(true)
			throw new NullPointerException();
		return restTemplate.getForEntity("http://httpbin.org/delay/1", Object.class);
	}
}

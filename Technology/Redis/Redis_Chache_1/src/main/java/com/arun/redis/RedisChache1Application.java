package com.arun.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisChache1Application {

	public static void main(String[] args) {
		SpringApplication.run(RedisChache1Application.class, args);
	}

}

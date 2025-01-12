package com.arun;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Controller {
	
	private ResourceLoader resourceLoader;

	public Controller(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}


	@GetMapping("/video/{name}")
	public Mono<Resource> getVideo(@PathVariable String name, @RequestHeader("Range") String range){
		System.out.println("Range => "+range);
		return Mono.fromSupplier(() -> resourceLoader.getResource("classpath:"+name));
		
	}
	
}

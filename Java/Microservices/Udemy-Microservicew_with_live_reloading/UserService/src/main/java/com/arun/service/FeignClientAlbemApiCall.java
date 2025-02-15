package com.arun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.arun.entity.AlbumEntity;

@FeignClient(name =  "ALBUMS-WS", fallbackFactory  = FeignClientAlbemApiCallFactory.class)
public interface FeignClientAlbemApiCall {

	@GetMapping("/users/{id}/albumss")
	public List<AlbumEntity> getAll(@PathVariable String id);
}


@Component
class FeignClientAlbemApiCallFactory implements FallbackFactory<FeignClientAlbemApiCall> {
	@Override
	public FeignClientAlbemApiCall create(Throwable cause) {
		return new FeignClientAlbemApiCallFallback(cause);
	}	
}


class FeignClientAlbemApiCallFallback implements FeignClientAlbemApiCall {
	private final Throwable cause;
	public FeignClientAlbemApiCallFallback(Throwable cause) {
		this.cause = cause;
	}
	
	@Override
	public List<AlbumEntity> getAll(String id) {
		System.out.println("getAll Call And error => "+cause.toString());
		return new ArrayList<>();
	}	
}

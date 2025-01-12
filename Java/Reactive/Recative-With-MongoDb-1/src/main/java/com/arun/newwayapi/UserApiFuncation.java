package com.arun.newwayapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.arun.entity.User;
import com.arun.entity.UserHotStream;
import com.arun.entity.UserHotStreamRepository;
import com.arun.entity.UserRepository;
import com.arun.exception.DemoException;

import reactor.core.publisher.Mono;

@Component
public class UserApiFuncation {

	@Autowired
	private UserRepository userRepository;
	
	public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
		return ServerResponse.ok().body(userRepository.findAll(), User.class );
	}

	public Mono<ServerResponse> getById(ServerRequest serverRequest) {
		Mono<User> data = userRepository.findById(serverRequest.pathVariable("id"));
		return ServerResponse.ok().body(data, User.class).switchIfEmpty(Mono.error(new DemoException(404, "Not Found"))).log();
	}
	
	
	public Mono<ServerResponse> save(ServerRequest serverRequest) {
		Mono<User> data = serverRequest.bodyToMono(User.class);
		return data.flatMap(x -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userRepository.save(x), User.class));
	}
	
	
	@Autowired private UserHotStreamRepository userHotStreamRepository;
	
	public Mono<ServerResponse> streamData(ServerRequest request) {
		System.out.println("====Call");
		return ServerResponse.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(userHotStreamRepository.findUserHotStreamBy(), UserHotStream.class).doOnNext(System.out::println).log("data =>");
	}
	
}

package com.arun.newwayapi;

import com.arun.exception.DemoException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SimpleDataClass {

	public Mono<ServerResponse> flux(ServerRequest serverRequest) {
		return ServerResponse.ok().body(Flux.range(0, 5), Integer.class );
	}

	public Mono<ServerResponse> mono(ServerRequest serverRequest) {
		return ServerResponse.ok().body(Mono.just(1), Integer.class );
	}
	
	public Mono<ServerResponse> geterror(ServerRequest serverRequest) {
		throw new DemoException(409,"Not run");
	}
}

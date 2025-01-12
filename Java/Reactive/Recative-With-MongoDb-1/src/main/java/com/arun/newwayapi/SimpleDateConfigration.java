package com.arun.newwayapi;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class SimpleDateConfigration {

	@Bean
	public RouterFunction<ServerResponse> route(SimpleDataClass simpleDataClass) {
		return RouterFunctions.route(GET("/simple/flux").and(accept(MediaType.APPLICATION_JSON)), simpleDataClass::flux)
				.andRoute(GET("/simple/mono").and(accept(MediaType.APPLICATION_JSON)), simpleDataClass::mono)
		.andRoute(GET("/simple/error").and(accept(MediaType.APPLICATION_JSON)), simpleDataClass::geterror);
	}

	@Bean
	public RouterFunction<ServerResponse> routeForUser(UserApiFuncation userApiFuncation) {
		return RouterFunctions.route(GET("/fun/user").and(accept(MediaType.APPLICATION_JSON)), userApiFuncation::getAll)
				.andRoute(GET("/fun/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userApiFuncation::getById)
				.andRoute(POST("/fun/user").and(accept(MediaType.APPLICATION_JSON)), userApiFuncation::save)
				.andRoute(GET("/fun/user/stream").and(accept(MediaType.APPLICATION_JSON)), userApiFuncation::streamData);
	}
}

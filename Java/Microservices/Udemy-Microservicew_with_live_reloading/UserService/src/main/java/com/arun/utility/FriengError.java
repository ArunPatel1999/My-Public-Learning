package com.arun.utility;

import org.springframework.stereotype.Component;

import com.arun.exception.DemoException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FriengError implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		System.out.println(methodKey+" == "+response);
		return new DemoException(response.status(), response.reason());
	}

}

package com.arun.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionInterceptor  {

	@ExceptionHandler(DemoException.class)
	public final ResponseEntity<Object> exceptionHandler(DemoException e) {
		log.error("error => {}",e.getLocalizedMessage());
		return ResponseEntity.status(e.getCode()).body(e.getMessage());
	}

}

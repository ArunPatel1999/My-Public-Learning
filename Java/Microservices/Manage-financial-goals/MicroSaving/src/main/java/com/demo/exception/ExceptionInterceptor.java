package com.demo.exception;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomeException.class)
	public final ResponseEntity<Object> handleAllExceptions(CustomeException e) {
		log.error(LocalDateTime.now() + "   |   CUSTOME_ERROR   |   " + e.getLocalizedMessage());
		return ResponseEntity.status(e.getCode()).body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> unhandleExceptions(Exception e) {
		e.printStackTrace();
		log.error(LocalDateTime.now() + "   |   SERVERE_ERROR   |   " + e.getLocalizedMessage());
		return ResponseEntity.status(500).body("Internal Server Error");
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> data = new LinkedList<>();
		ex.getAllErrors().forEach(x -> data.add(x.getDefaultMessage()));
		log.error(LocalDateTime.now() + "   |   VALIDATE_FAILDE   |   " + data);
		return ResponseEntity.status(400).body(data);
	}

}

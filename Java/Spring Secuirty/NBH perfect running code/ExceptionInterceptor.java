package com.chatapp.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler  implements AuthenticationEntryPoint  {

  @ExceptionHandler(ChatAppException.class)
  public final ResponseEntity<Object> handleAllExceptions(ChatAppException e) {
    return ResponseEntity.status(e.getCode()).body(e.getLocalizedMessage());
  }
  
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> unhandleExceptions(Exception e) {
	    return ResponseEntity.status(500).body(e.getLocalizedMessage());
  }
  
  @ExceptionHandler(InternalAuthenticationServiceException.class)
  public final ResponseEntity<Object> internalAuthenticationServiceException(InternalAuthenticationServiceException e) {
	  return ResponseEntity.status(401).body(e.getLocalizedMessage());
  }
  
  @ExceptionHandler(BadCredentialsException.class)
  public final ResponseEntity<Object> badCredentialsException(BadCredentialsException e) {
	  return ResponseEntity.status(401).body(e.getLocalizedMessage());
  }

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
		throws IOException, ServletException {
	    response.setStatus(401); 
		response.getWriter().append(response.getHeader("error"));
  }
 
 
@Override
protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
		HttpStatus status, WebRequest request) {
	return ResponseEntity.status(status).body(ex.getLocalizedMessage());
}
  
}

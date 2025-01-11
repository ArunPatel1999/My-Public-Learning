package com.demo.exception;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomeException extends Exception {

	private static final long serialVersionUID = 1L;
	private  List<String> errors = new ArrayList<>();
	private  int code = -1;
	private  String developerMessage;
	private  int errorCodeValue = -1;
	public static final  int SUCCESSFUL_REQUEST = 200;
	public static final int SUCCESS = 201;
	public static final int NO_CONTENT = 204;
	public static final int BAD_REQUEST = 400;
	public static final int UNAUTHORIZED = 401;
	public static final int FORBIDDEN = 403;
	public static final int NOT_FOUND = 404;
	public static final int NOT_ACCEPTABLE = 406;
	public static final int UNSUPPORTED_MEDIA_TYPE = 415;
	public static final int UNPROCESSABLE_ENTITY = 422;
	public static final int UNIQUE_KEY_CONSTRAINT_VIOLATION = 409;
	public static final int MULTIPLE_RECORDS_FOUND = 409;
	public static final int SERVER_ERROR = 500;
	
	public CustomeException() {}
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public int getErrorCodeValue() {
		return errorCodeValue;
	}

	public void setErrorCodeValue(int errorCodeValue) {
		this.errorCodeValue = errorCodeValue;
	}

	public CustomeException(Exception e) {
		super(e.getMessage());
	}

	public CustomeException(String message) {
		super(message);
	}

	public CustomeException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	
}

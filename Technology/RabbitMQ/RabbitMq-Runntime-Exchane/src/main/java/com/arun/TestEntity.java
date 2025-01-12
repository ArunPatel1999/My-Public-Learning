package com.arun;

import java.io.Serializable;

public class TestEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String send;
	private String recvied;
	private String message;
	
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
	public String getRecvied() {
		return recvied;
	}
	public void setRecvied(String recvied) {
		this.recvied = recvied;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

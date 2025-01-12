package com.arun.redis;

import java.util.Date;

public class Meaage {

	private int id;
	private String provider;
	private String meassge;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getMeassge() {
		return meassge;
	}
	public void setMeassge(String meassge) {
		this.meassge = meassge;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}

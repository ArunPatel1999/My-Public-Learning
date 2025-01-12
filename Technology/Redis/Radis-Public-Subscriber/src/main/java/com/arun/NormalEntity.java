package com.arun;

import java.util.Date;

public class NormalEntity {

	private int id;
	private String namme;
	private Date createdDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamme() {
		return namme;
	}
	public void setNamme(String namme) {
		this.namme = namme;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		return "NormalEntity [id=" + id + ", namme=" + namme + ", createdDate=" + createdDate + "]";
	}
	
}

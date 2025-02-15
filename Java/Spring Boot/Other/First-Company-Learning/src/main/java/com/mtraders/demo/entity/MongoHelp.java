package com.mtraders.demo.entity;


public class MongoHelp {
	
	private String tableName;
	private Class className;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Class getClassName() {
		return className;
	}
	public void setClassName(Class className) {
		this.className = className;
	}
	public MongoHelp(String tableName, Class className) {
		super();
		this.tableName = tableName;
		this.className = className;
	}
	public MongoHelp() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
}

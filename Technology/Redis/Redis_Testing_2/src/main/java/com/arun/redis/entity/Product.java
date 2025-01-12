package com.arun.redis.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("PRODUCT")
public class Product implements Serializable{

	/**
	 * 
	 */
	public static final String tableName = "PRODUCT";
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private double price;
	private int quty;
}

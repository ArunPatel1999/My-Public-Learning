package com.arun.redis;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
}

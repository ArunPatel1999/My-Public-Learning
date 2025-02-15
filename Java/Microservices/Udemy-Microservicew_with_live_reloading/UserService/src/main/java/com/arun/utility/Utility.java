package com.arun.utility;

import java.util.UUID;

public class Utility {

	public static String getId() {
		return UUID.randomUUID().toString();
	}
}

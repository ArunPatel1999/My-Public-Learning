package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {
	public static void main(String[] args) {

		
		cmd("zz");

	}

	private static void cmd(String ip) {
		try {

			Runtime r = Runtime.getRuntime();
			Process p = r.exec("cd C:\\Users\\Account\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\keebo-apis");
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}

			in.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
package com.arun;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FBInitialize {
	@PostConstruct
	public void initialize() {
		try {
			
			@SuppressWarnings("deprecation")
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(this.getClass().getResourceAsStream("/serviceaccount.json")))
					.setDatabaseUrl("https://fiorebasenewtesting-default-rtdb.asia-southeast1.firebasedatabase.app").build();
			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
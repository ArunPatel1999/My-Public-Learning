package com.mtraders.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidConfig.Priority;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@RestController
public class NotificationController {


	
	@GetMapping("/{token}/{title}/{body}")
	public String getAll(@PathVariable String token, @PathVariable String title,@PathVariable String body) {
		return pushNotification(token,title,body);
	}
	
	private String pushNotification(String token,String title,String body) {
		
			String response;
			try {
				@SuppressWarnings("deprecation")
				Message message = Message.builder()
						.setNotification(new Notification(title, body))
			            .setAndroidConfig(AndroidConfig.builder().setPriority(Priority.HIGH).build())
						.setToken(token)
						.build();
			
				response = FirebaseMessaging.getInstance().send(message);
			} catch (FirebaseMessagingException  | IllegalArgumentException e) {
				return "error from firebase - " + e.getLocalizedMessage();
			}
			return "Successfully sent message: " + response;
		
	}

	
}

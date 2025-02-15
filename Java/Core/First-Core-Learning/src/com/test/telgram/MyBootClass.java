package com.test.telgram;

import org.telegram.telegrambots.api.objects.Document;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MyBootClass extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {
	
		
		System.out.println(update.getMessage());
		Document d =update.getMessage().getDocument();
		SendMessage.sendToTelegramVideo(d);
		
//		Video video =	update.getMessage().getVideo();
//		String command = update.getMessage().getText();
//
//		SendMessage.sendToTelegramVideo(video);
		
//		if (command.equals("all")) {
//			SendMessage.sendToTelegram("All up date jhsdj \n love");
//		}
//
//		if (command.equals("down")) {
//			SendMessage.sendToTelegram("down zzzz 12345");
//		}
	}

	public String getBotUsername() {
		return "botname";
	}

	public String getBotToken() {
		return "bota_token";
	}
	


}

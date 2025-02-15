package com.test.telgram;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.telegram.telegrambots.api.objects.Document;


public class SendMessage {
	public static void sendToTelegram(String text) {
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

		// Add Telegram token (given Token is fake)
		String apiToken = "";

		// Add chatId (given chatId is fake)
		String chatId = "";

		try {

			urlString = String.format(urlString, apiToken, chatId, URLEncoder.encode(text, "UTF-8"));
			
			URL url = new URL(urlString);
			
			System.out.println(url);
			URLConnection conn = url.openConnection();
			new BufferedInputStream(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendToTelegramVideo(Document text) {
	
		
		String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&document=%s";

		// Add Telegram token (given Token is fake)
		String apiToken = "";

		// Add chatId (given chatId is fake)
		String chatId = "";

		try {

			
			urlString = String.format(urlString, apiToken, chatId, text.getFileId());
			
			
			URL url = new URL(urlString);
			
		//	Files.write(new File("D:\\Download\\a.mp4").toPath(), text.get);
			
			System.out.println("https://api.telegram.org/file/somthing/"+text.getFileId());
			URLConnection conn = url.openConnection();
			new BufferedInputStream(conn.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

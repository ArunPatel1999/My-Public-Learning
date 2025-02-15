package com.mtraders.demo.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;  

@RestController
@RequestMapping("/api/mail")
public class MailController {
	

	@GetMapping
	public String sendEmail() throws AddressException, MessagingException, IOException {
		sendMessageWithNewType();
		return "Email sent successfully ";   
	}
	

	@Autowired
	private JavaMailSender javaMailSender;
	
	private void sendMessageWithNewType() throws MessagingException {
		
		MimeMessage mim = javaMailSender.createMimeMessage();
		
		MimeMessageHelper message = new MimeMessageHelper(mim,true);
		
		message.setFrom("iaaasds.com");
		
		String[] emails = {"sdsds@.gmail.com","s1dsds@.gmail.com"}; 
		message.setTo(emails);
		message.setSubject("Testing New Email");
		message.setText("Let Start<br> Send new <b> Message</b>",true);
		
		//message.addAttachment("FileName", "FileDestination");
		
		
		javaMailSender.send(mim);
	}
	
	
	
	private void sendmail() throws AddressException, MessagingException, IOException {
		
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "25");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("username", "passsword");
		    	 }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("username", false));
		   
	//	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("email"));
		//   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("email"));
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("email"));
		   msg.setSubject("New Testing");
		   msg.setContent("<html>\r\n"
		   		+ "<head> \r\n"
		   		+ "<title> sssss</title>\r\n"
		   		+ "</head>\r\n"
		   		+ "<body> \r\n"
		   		+ "\r\n"
		   		+ "<p>I am normal</p>\r\n"
		   		+ "<p style=\"color:red;\">I am red</p>\r\n"
		   		+ "<p style=\"color:blue;\">I am blue</p>\r\n"
		   		+ "<p style=\"font-size:50px;\">I am big</p>\r\n"
		   		+ "</body>\r\n"
		   		+ "</html>", "text/html");
		   msg.setSentDate(new Date());
		 
		   
		  /*
		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("This isa extra line", "text/html");
		   
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   msg.setContent(multipart);
		   
		   */
		   
		   Transport.send(msg);
		  
		
		
	}
}

package com.helpingHands.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;
	
	private String urlDomain = "http://192.168.43.96:8080/";
	private String from = "noreply@helpinghands.com";
	
	public void sendHtmlEmail(String to,String subject,String body) {
		MimeMessage msg = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg,true);
	        helper.setTo(to);
	        helper.setFrom(from);
	        helper.setSubject(subject);
	        helper.setText(body, true);
	        
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	    javaMailSender.send(msg);
	}
	
	public void sendEmail(String to,String subject,String body) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(to);
	    mailMessage.setSubject(subject);
	    mailMessage.setText(body);

	    javaMailSender.send(mailMessage);
	}
	
	public void createAccountMail(String name,String email,String tokenValue) {
		String url = urlDomain + "confirm-account?token=" +tokenValue;
	    String subject = "Complete Registration!";
	    String body = MailPage.getConformationPage(name, url);

	    sendHtmlEmail(email, subject, body);
	}

	public void createResetPasswordMail(String email,String tokenValue) {
		String url = urlDomain + "reset-password?token="+tokenValue;
	    String subject = "Reset HelpingHands Password!";
	    String body = "to reset your account password, please click here : " + url;
	    
	    sendEmail(email, subject, body);
	}
}

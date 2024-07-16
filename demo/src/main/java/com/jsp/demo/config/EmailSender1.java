package com.jsp.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.jsp.demo.dto.User;
import com.jsp.demo.repo.UserRepo;


@Component
public class EmailSender1{
	@Autowired
	private JavaMailSender emailsender;
	
	@Autowired
	UserRepo repo;
	
	public void msgSend(String email) {
		User db = repo.findByEmail(email);
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("aarvindkosana@gmail.com");
		message.setTo(email);
		message.setSubject("hi welcome to our application");
		message.setText("data can be inserted in our database...!\n"+db);
		emailsender.send(message);
	}
}

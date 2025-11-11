package com.example.Biglots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.Biglots.Service.EmailService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class BiglotsApplication {
	
	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(BiglotsApplication.class, args);
		System.out.println("======== Application Started =======");
	}     
		/*@EventListener(ApplicationReadyEvent.class)
		 public void sendMail() throws MessagingException {
			emailService.sendEmail("rakeshnani722@gmail.com",
					"This is email body",
					"This is email subject");
			
		
			
			
		}*/
	

}

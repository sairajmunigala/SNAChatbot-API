package com.example.sna.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.sna.*"})
public class SnachatbotApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SnachatbotApplication.class, args);
		
	}

}

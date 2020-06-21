package com.example.sna.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sna.chatbot.dto.ChatbotRequestDTO;
import com.example.sna.chatbot.dto.ChatbotResponseDTO;
import com.example.sna.dialogflow.DialogFlowIntents;

@CrossOrigin
@RestController
public class SNABotController {
	
	@Autowired
	DialogFlowIntents dilogFlowIntents;

	@PostMapping("/getChatBotResponse")
	public ChatbotResponseDTO getChatbotResponse(@RequestBody ChatbotRequestDTO chatbotRequest){
		 return dilogFlowIntents.detectIntentTexts(chatbotRequest.getQuestion(), chatbotRequest.getSessionID());
	}
}

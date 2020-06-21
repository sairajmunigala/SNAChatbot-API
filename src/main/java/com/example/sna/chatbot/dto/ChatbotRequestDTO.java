package com.example.sna.chatbot.dto;

public class ChatbotRequestDTO {
	
	private String sessionID;
	
	private String question;

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}

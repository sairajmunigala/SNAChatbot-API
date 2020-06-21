package com.example.sna.chatbot.dto;

public enum Intent {

	INSTALL_SOFTWARE("InstallSoftware"), TECHNOLOGIES("Technologies"), SERVICE_TYPE("ServiceType"), IP_ADDRESS("IPAddress");
	
	private String intentName;
	    
    Intent(String intentName) {
    	this.intentName = intentName;
    }
    
    public String getIntentName() {
		return intentName;
	}
}

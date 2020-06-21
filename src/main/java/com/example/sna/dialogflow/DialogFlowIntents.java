package com.example.sna.dialogflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.cloud.dialogflow.v2.TextInput.Builder;

@Service
public class DialogFlowIntents {
	
	private static final Logger logger = LoggerFactory.getLogger(DialogFlowIntents.class);
	
	private String projectId = "snachatbot-rdynhe";

	public String detectIntentTexts(String text, String sessionId) {
			String result = "";
		    // Instantiates a client
		    try (SessionsClient sessionsClient = SessionsClient.create()) {
		      // Set the session name using the sessionId (UUID) and projectID (my-project-id)
		      SessionName session = SessionName.of(projectId, sessionId);

		      // Detect intents for each text input
	        // Set the text (hello) and language code (en-US) for the query
	        Builder textInput = TextInput.newBuilder().setText(text).setLanguageCode("en-US");

	        // Build the query with the TextInput
	        QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

	        // Performs the detect intent request
	        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);

	        // Display the query result
	        QueryResult queryResult = response.getQueryResult();

	        logger.info("query text :" + queryResult.getQueryText());
	        logger.info("Detected Intent: "+ queryResult.getIntent().getDisplayName() + "(confidence: )\n" +
	             queryResult.getIntentDetectionConfidence());
	        logger.info("Fulfillment Text: \n" + queryResult.getFulfillmentText());
	        result = queryResult.getFulfillmentText();
	      } catch (Exception e) {
			logger.error(e.getMessage());
	      }
		return result;    
	  }
}

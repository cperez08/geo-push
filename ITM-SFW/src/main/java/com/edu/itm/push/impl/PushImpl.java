package com.edu.itm.push.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.edu.itm.push.beans.PushGoogleBean;
import com.edu.itm.push.beans.PushGoogleBeanResponse;
import com.edu.itm.push.services.PushServices;

public class PushImpl implements PushServices {

	private static final String GOOGLE_URL = "https://android.googleapis.com/gcm/send";
	//private static final String GOOGLE_URL = "https://gcm-http.googleapis.com/gcm/send";
	private static final String GOOGLE_KEY = "Key=AIzaSyC6ntuoaidZ7jLK7zrnLNrAY3X9X1C77vc";
	
	
	public void sendMessage(PushGoogleBean googleBean) {

		try {
			
		JSONObject json = new JSONObject(googleBean);
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(GOOGLE_URL);

		StringEntity input = new StringEntity(json.toString());
		input.setContentType("application/json");
		postRequest.setHeader("Authorization",GOOGLE_KEY);
		postRequest.setEntity(input);
		

		HttpResponse response = httpClient.execute(postRequest);

		if (response.getStatusLine().getStatusCode() == 400) {
			System.out.println("THE PUSH ID IS INVALID ");
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}else if (response.getStatusLine().getStatusCode() != 200){
			
			System.out.println("UNEXPECTED ERROR SENDING MESSAGE");
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatusLine().getStatusCode());
		}else{

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(response.getEntity().getContent())));

		String output;
		StringBuffer totalOutput = new StringBuffer();
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			
			totalOutput.append(output);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		PushGoogleBeanResponse googleresponse = mapper.readValue(totalOutput.toString(), PushGoogleBeanResponse.class);
		
			if (googleresponse.getSuccess() > 0) {

				System.out.println("Message send success");

			} else {

				System.out.println("Error sending message "+googleresponse.getResults().get(0).getError());

			}

			}

		} catch (Exception ex) {

			System.out.println("GENERAL ERROR IN PROCESS");
			throw new RuntimeException("FAILED POST TO GOOGLE GCM : "
					+ ex);
		}
	}

}

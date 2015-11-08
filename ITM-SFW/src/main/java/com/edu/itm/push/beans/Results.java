package com.edu.itm.push.beans;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Results {
	
	@JsonIgnore
	private String message_id;
	@JsonIgnore
	private String error;
	
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	

}

package com.edu.itm.push.beans;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SenderAlertMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9117632499433345965L;
	
	private short action;
	private User userinfo;
	private double latitude;
	private double longitude;
	private String message;
	
	
	public short getAction() {
		return action;
	}
	public void setAction(short action) {
		this.action = action;
	}
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

package com.edu.itm.push.beans;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3258033285532164196L;
	
	private int userId;
	private String userNickname;
	private String userPassword;
	private int userProfile;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(int userProfile) {
		this.userProfile = userProfile;
	}
	
	
	
	

}

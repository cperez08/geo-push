package com.edu.itm.push.beans;

import java.io.Serializable;

public class Profile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4014286554106192353L;
	
	private int profileId;
	private int profileDesc;
	private String isActiveProfile;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public int getProfileDesc() {
		return profileDesc;
	}
	public void setProfileDesc(int profileDesc) {
		this.profileDesc = profileDesc;
	}
	public String getIsActiveProfile() {
		return isActiveProfile;
	}
	public void setIsActiveProfile(String isActiveProfile) {
		this.isActiveProfile = isActiveProfile;
	}
	
		
	

}

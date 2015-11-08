package com.edu.itm.push.beans;

import java.io.Serializable;

public class Device implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8748926794024596722L;
	private int deviceId;
	private int userDevice;
	private String pushId;
	private String activeDevice;
	
	
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getUserDevice() {
		return userDevice;
	}
	public void setUserDevice(int userDevice) {
		this.userDevice = userDevice;
	}
	public String getPushId() {
		return pushId;
	}
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}
	public String getActiveDevice() {
		return activeDevice;
	}
	public void setActiveDevice(String activeDevice) {
		this.activeDevice = activeDevice;
	}
	
	
	

}

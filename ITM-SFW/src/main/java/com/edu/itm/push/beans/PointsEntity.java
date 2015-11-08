package com.edu.itm.push.beans;

import java.io.Serializable;

public class PointsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8002340756644434485L;
	
	private int pointId;
	private double latitude;
	private double longitude;
	private int cityId;
	private int userId;
	
	public int getPointId() {
		return pointId;
	}
	public void setPointId(int pointId) {
		this.pointId = pointId;
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
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}

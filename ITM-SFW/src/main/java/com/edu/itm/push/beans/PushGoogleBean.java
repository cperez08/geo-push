package com.edu.itm.push.beans;

import java.io.Serializable;
import java.util.List;

public class PushGoogleBean implements Serializable{

	/**
	 * 
	 */
	
	public PushGoogleBean(){
		
		data = new Data();
		
	}
	
	
	private static final long serialVersionUID = -6549627812388395897L;
	
	private List<String> registration_ids;
	private Data data;
	
	public List<String> getRegistration_ids() {
		return registration_ids;
	}
	public void setRegistration_ids(List<String> registration_ids) {
		this.registration_ids = registration_ids;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
}

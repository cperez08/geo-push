package com.edu.itm.push.services;

public interface ErrorsDefines {
	
	public static final String STATUS_OK = "P000";
	public static final String STATUS_ERROR_PROFILE = "P001";
	public static final String STATUS_ERROR_USER_AND_PROFILE = "P002";
	public static final String STATUS_ERROR_AUTH = "P580";
	public static final String STATUS_GENERAL_ERROR = "P050";
	public static final String DESC_OK = "NO_ERROR";
	public static final String DESC_GENERAL_ERROR = "GENERAL ERROR";
	public static final String DESC_UNDEFINED_ERROR = "UNDEFINED ERROR";
	public static final String STATUS_NO_PROCESS = "P020";
	public static final String DESC_PROFILE_NO_DEFINED = "ERROR_NO_PROFILE";
	public static final String DESC_ERROR_AUTH = "ERROR_AUTH";
	public static final String STATUS_NO_DEVICES_FOUND = "NO DEVICES FOUND";
	public static final String DESC_NO_DEVICES_FOUND = "P404";
	
	public static final String STATUS_MESSAGE_SEND = "P100";
	public static final String DESC_NO_ERROR_MESSAGE = "SENT MESSAGE SUCCESS";
	
	public static final String DESC_NO_UPDATED_ROWS="UPDATE FAILED";
	public static final String STATUS_UPDATE_SEND = "P500";
	
	
	

}

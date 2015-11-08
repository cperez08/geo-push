package com.edu.itm.push.beans;

import java.io.Serializable;

public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2699494380613637879L;
	private int entityId;
	private String entityName;
	private int userxEntity;
	
	
	public int getEntityId() {
		return entityId;
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public int getUserxEntity() {
		return userxEntity;
	}
	public void setUserxEntity(int userxEntity) {
		this.userxEntity = userxEntity;
	}
	
	

}

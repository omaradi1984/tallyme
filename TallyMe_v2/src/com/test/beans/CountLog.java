package com.test.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class CountLog extends ArrayList<Count> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID internalId;
	/**
	 * @param internalId the internalId to set
	 */
	public void setInternalId(UUID internalId) {
		this.internalId = internalId;
	}

	private Date timeStamp;
	private String location;
	//private User user;

	
	public CountLog() {
		this.internalId = UUID.randomUUID();
		this.timeStamp = new Date();
		//this.setUser(new Guest());
	}
	
	public CountLog(int id, String location) {
		this.internalId = UUID.randomUUID();
		this.timeStamp = new Date();
		this.location = location;
		//this.setUser(new Guest());
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public UUID getInternalId() {
		return internalId;
	}
	
}

package com.test.beans;

import java.util.Date;
import java.util.UUID;

public class Count {

	private final UUID internalId; //auto-generated id
	private int id;
	private Date timeStamp;

	//Constructor
	public Count () {
		this.internalId = UUID.randomUUID();
		this.timeStamp = new Date();
	}
	
	public Count(int id) {
		this.internalId = UUID.randomUUID();
		this.id = id;
		this.timeStamp = new Date();
	}



	//Getters
	public UUID getInternalId() {
		return internalId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}

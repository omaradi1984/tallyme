package com.test.beans;

import java.util.UUID;

public class CorporateUserBuilder implements Builder {
	private UUID internalId;
	private String firstName;
	private int id;
	private String lastName;
	private String username;
	private String password;
	private String emailAddress;
	private String company;
	private String location;
		
	public CorporateUserBuilder() {
	}
	/**
	 * @param internalId the internalId to set
	 */
	@Override
	public Builder setInternalId(UUID internalId) {
		this.internalId = internalId;
		return this;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @param firstName the firstName to set
	 */
	@Override
	public Builder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	/**
	 * @param id the id to set
	 */
	@Override
	public Builder setId(int id) {
		this.id = id;
		return this;
	}
	/**
	 * @param lastName the lastName to set
	 */
	@Override
	public Builder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	/**
	 * @param username the username to set
	 */
	@Override
	public Builder setUsername(String username) {
		this.username = username;
		return this;
	}
	/**
	 * @param password the password to set
	 */
	@Override
	public Builder setPassword(String password) {
		this.password = password;
		return this;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	@Override
	public CorporateUserBuilder setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
	
	public CorporateUser createUser() {
		return new CorporateUser(firstName, lastName, username, password, emailAddress, company, location);
	}
	@Override
	public Builder reset() {
		// TODO Auto-generated method stub
		return null;
	}
}

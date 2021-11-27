package com.test.beans;

import java.util.UUID;

public class PublicUserBuilder implements Builder {
	private UUID internalId;
	private String firstName;
	private int id;
	private String lastName;
	private String username;
	private String password;
	private String emailAddress;
			
	public PublicUserBuilder() {
	}
	/**
	 * @param internalId the internalId to set
	 */
	@Override
	public PublicUserBuilder setInternalId(UUID internalId) {
		this.internalId = internalId;
		return this;
	}
	/**
	 * @param firstName the firstName to set
	 */
	@Override
	public PublicUserBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	/**
	 * @param id the id to set
	 */
	@Override
	public PublicUserBuilder setId(int id) {
		this.id = id;
		return this;
	}
	/**
	 * @param lastName the lastName to set
	 */
	@Override
	public PublicUserBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	/**
	 * @param username the username to set
	 */
	@Override
	public PublicUserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}
	/**
	 * @param password the password to set
	 */
	@Override
	public PublicUserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	@Override
	public PublicUserBuilder setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}
	
	public UserInterface createUser() {
		return new PublicUser(firstName, lastName, username, password, emailAddress);
	}
	@Override
	public PublicUserBuilder reset() {
		// TODO Auto-generated method stub
		return null;
	}
}

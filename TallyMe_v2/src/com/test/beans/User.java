package com.test.beans;

import java.util.UUID;

public abstract class User implements UserInterface {

	protected UUID internalId;
	protected String firstName;
	protected int id;
	protected String lastName;
	private String username;
	private String password;
	protected String emailAddress;
	
	public static Login login;
	
	public AdminRole role;

	/**
	 * @param internalId the internalId to set
	 */
	public void setInternalId(UUID internalId) {
		this.internalId = internalId;
	}

	/**
	 * @return the firstName
	 */
	
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the id
	 */
	
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the lastName
	 */
	
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	
	public String getUsername() {
		return PublicUser.login.getUsername();
	}

	
	public void setUsername(String username) {
		PublicUser.login.setUsername(username);
	}

	/**
	 * @return the password
	 */
	
	public String getPassword() {
		return PublicUser.login.getPassword();
	}

	/**
	 * @param password the password to set
	 */
	
	public void setPassword(String password) {
		PublicUser.login.setPassword(password);
	}

	/**
	 * @return the emailAddress
	 */
	
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the internalId
	 */
	
	public UUID getInternalId() {
		return internalId;
	}

}
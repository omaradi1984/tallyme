package com.test.beans;

import java.util.UUID;

public interface UserInterface {

	/**
	 * @param internalId the internalId to set
	 */
	void setInternalId(UUID internalId);

	/**
	 * @return the firstName
	 */
	String getFirstName();

	/**
	 * @param firstName the firstName to set
	 */
	void setFirstName(String firstName);

	/**
	 * @return the id
	 */
	int getId();

	/**
	 * @param id the id to set
	 */
	void setId(int id);

	/**
	 * @return the lastName
	 */
	String getLastName();

	/**
	 * @param lastName the lastName to set
	 */
	void setLastName(String lastName);

	/**
	 * @return the username
	 */
	String getUsername();

	void setUsername(String username);

	/**
	 * @return the password
	 */
	String getPassword();

	/**
	 * @param password the password to set
	 */
	void setPassword(String password);

	/**
	 * @return the emailAddress
	 */
	String getEmailAddress();

	/**
	 * @param emailAddress the emailAddress to set
	 */
	void setEmailAddress(String emailAddress);

	/**
	 * @return the internalId
	 */
	UUID getInternalId();

}
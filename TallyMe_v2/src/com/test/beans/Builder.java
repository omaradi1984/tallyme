package com.test.beans;

import java.util.UUID;

public interface Builder {

	/**
	 * @param internalId the internalId to set
	 */
	Builder setInternalId(UUID internalId);

	/**
	 * @param firstName the firstName to set
	 */
	Builder setFirstName(String firstName);

	/**
	 * @param id the id to set
	 */
	Builder setId(int id);

	/**
	 * @param lastName the lastName to set
	 */
	Builder setLastName(String lastName);

	/**
	 * @param username the username to set
	 */
	Builder setUsername(String username);

	/**
	 * @param password the password to set
	 */
	Builder setPassword(String password);

	/**
	 * @param emailAddress the emailAddress to set
	 */
	Builder setEmailAddress(String emailAddress);
	
	Builder reset();

}
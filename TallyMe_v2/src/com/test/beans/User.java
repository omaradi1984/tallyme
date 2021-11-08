package com.test.beans;

import java.util.UUID;

public class User {
	private UUID internalId;
	private String firstName;
	private int id;
	private String lastName;
	private String username;
	private String password;
	private String emailAddress;
	
	//Constructor
		public User() {
			this.internalId = UUID.randomUUID();
		}
		
		public User(int id, String firstName, String lastName, String username, String password, String emailAddress) {
			this.internalId = UUID.randomUUID();
			this.firstName = firstName;
			this.id = id;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
			this.emailAddress = emailAddress;
		}
		
		public User(String firstName, String lastName, String username, String password, String emailAddress) {
			this.internalId = UUID.randomUUID();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.password = password;
			this.emailAddress = emailAddress;
		}

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
			return username;
		}

		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
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

		public void Login() {
			
		}
		
		public void Logout() {
			
		}
}

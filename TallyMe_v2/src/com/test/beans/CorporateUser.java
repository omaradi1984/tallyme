package com.test.beans;

import java.util.UUID;

public class CorporateUser extends User {
	
	private String company;
	private String location;
	
	//Constructor
		public CorporateUser() {
			this.internalId = UUID.randomUUID();
		}
		
		public CorporateUser(String firstName, String lastName, String username, String password, String emailAddress, String company, String location) {
			this.internalId = UUID.randomUUID();
			this.firstName = firstName;
			this.lastName = lastName;
			CorporateUser.login = new Login(username, password);
			this.emailAddress = emailAddress;
			this.company = company;
			this.location = location;
		}

		/**
		 * @return the company
		 */
		public String getCompany() {
			return company;
		}

		/**
		 * @param company the company to set
		 */
		public void setCompany(String company) {
			this.company = company;
		}

		/**
		 * @return the location
		 */
		public String getLocation() {
			return location;
		}

		/**
		 * @param location the location to set
		 */
		public void setLocation(String location) {
			this.location = location;
		}
}

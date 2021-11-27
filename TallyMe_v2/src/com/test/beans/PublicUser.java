package com.test.beans;

import java.util.UUID;

public class PublicUser extends User {
	//Constructor
		public PublicUser() {
			super();
			this.internalId = UUID.randomUUID();
		}
		
		public PublicUser(String firstName, String lastName, String username, String password, String emailAddress) {
			super();
			this.internalId = UUID.randomUUID();
			this.firstName = firstName;
			this.lastName = lastName;
			PublicUser.login = new Login(username, password);
			this.emailAddress = emailAddress;
		}
}

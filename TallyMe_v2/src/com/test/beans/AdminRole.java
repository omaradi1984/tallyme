package com.test.beans;

public interface AdminRole {

	public UserInterface createUser();
	
	public void deleteUser(String emailAddress);
	
	public void readUser(String emailAddress);
	
	public void updateUser();
	
	public void deleteCount();
}

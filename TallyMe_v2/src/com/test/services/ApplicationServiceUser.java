package com.test.services;

import java.util.Map;
import java.util.UUID;

import com.test.beans.User;

public interface ApplicationServiceUser {
	
	public Map<UUID, User> readUsers();
	
	public User readUser(String id);
	
	public void createUser(User user);
	
	public void updateUser(User user);

    public void deleteUser(String id);

    public void createOrUpdateUser(User user);
    
    public boolean validateUser(String username, String password);
    
    public int registerUser(User user);
}

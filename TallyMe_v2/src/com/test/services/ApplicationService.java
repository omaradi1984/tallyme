package com.test.services;

import java.util.Map;
import java.util.UUID;

import com.test.beans.Count;
import com.test.beans.CountLog;
import com.test.beans.User;

public interface ApplicationService {
	
	public Map<UUID, User> readUsers();
	
	public User readUser(String id);
	
	public User readUser(String username, String password);
	
	public void createUser(User user);
	
	public void updateUser(User user);

    public void deleteUser(String id);

    public void createOrUpdateUser(User user);
    
    public boolean validateUser(String username, String password);
    
    public int registerUser(User user);
        
    public User getProfileDetails(String username);
    
    public void createCount(Count count, CountLog log);
    
    public int readCount(CountLog log);
    
    public void deleteCount(CountLog log);
    
    public void createCountLog(CountLog log, User user);
    
    public CountLog readCountLog(String id, String userId);
    
    public CountLog readCountLog(String id);
    
    public boolean validateCountLog(CountLog log, User user);
    
    public void deleteCountLog(String id);
    
}

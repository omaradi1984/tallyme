package com.test.services;

import java.util.Map;
import java.util.UUID;

import com.test.beans.Count;
import com.test.beans.CountLog;
import com.test.beans.PublicUser;
import com.test.beans.UserInterface;

public interface ApplicationService {
	
	public Map<UUID, PublicUser> readUsers();
	
	public UserInterface readUser(String id);
	
	public UserInterface readUser(String username, String password);
	
	public void createUser(PublicUser user);
	
	public void updateUser(PublicUser user);

    public void deleteUser(String id);

    public void createOrUpdateUser(PublicUser user);
    
    public boolean validateUser(String username, String password);
    
    public int registerUser(UserInterface user);
        
    public UserInterface getProfileDetails(String username);
    
    public void createCount(Count count, CountLog log);
    
    public int readCount(CountLog log);
    
    public void deleteCount(CountLog log);
    
    public void createCountLog(CountLog log, UserInterface user);
    
    public CountLog readCountLog(String id, String userId);
    
    public CountLog readCountLog(String id);
    
    public boolean validateCountLog(CountLog log, UserInterface user);
    
    public void deleteCountLog(String id);
    
}

package com.test.inmemory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.test.beans.User;
import com.test.services.ApplicationServiceUser;

public class ApplicationInMemoryUser implements ApplicationServiceUser {
	
	private Map<UUID, User> users;

	public ApplicationInMemoryUser() {
		this.users = new LinkedHashMap<UUID, User>();
	}

	@Override
	public Map<UUID, User> readUsers() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User readUser(String id) {
		// TODO Auto-generated method stub
		return users.get(UUID.fromString(id));
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		updateUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		users.put(user.getInternalId(), user);
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		users.remove(UUID.fromString(id));
	}

	@Override
	public void createOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		User localUser = readUser(user.getInternalId().toString());
        if (localUser == null) {
            createUser(user);
        } else {
            updateUser(user);
        }
	}

	@Override
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
}

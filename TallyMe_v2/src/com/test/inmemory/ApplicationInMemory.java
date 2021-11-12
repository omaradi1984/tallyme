package com.test.inmemory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.test.beans.Count;
import com.test.beans.CountLog;
import com.test.beans.User;
import com.test.dao.DBConnection;
import com.test.services.ApplicationService;

public class ApplicationInMemory implements ApplicationService {
	
	private Map<UUID, User> users;

	public ApplicationInMemory() {
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
		boolean isValidUser = false;
		try {

			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();

			// write the select query
			String sql = "select * from USER where username=? and password=?";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);

			// execute the statement and check whether user exists

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				isValidUser = true;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return isValidUser;
	}

	@Override
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		int rowsAffected = 0;

		try {
			// get the connection for the database
			Connection connection = DBConnection.getConnectionToDatabase();

			// write the insert query
			String insertQuery = "insert into USER values(?,?,?,?,?,?)";

			// set parameters with PreparedStatement
			java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getInternalId().toString());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getUsername());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmailAddress());
			// execute the statement
			rowsAffected = statement.executeUpdate();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rowsAffected;
	}

	@Override
	public User getProfileDetails(String username) {
		// TODO Auto-generated method stub
		User user = null;
			try {
				// get connection to database
				Connection connection = DBConnection.getConnectionToDatabase();

				// write select query to get profile details
				String sql = "select * from USER where username=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username);

				// execute query, get resultset and return User info
				ResultSet set = statement.executeQuery();
				while (set.next()) {
					user = new User();
					user.setFirstName(set.getString("FirstName"));
					user.setLastName(set.getString("LastName"));
					user.setUsername(set.getString("Username"));
					user.setPassword(set.getString("Password"));
					user.setEmailAddress(set.getString("EmailAddress"));

				}

			}

			catch (SQLException exception) {
				exception.printStackTrace();
			}
			return user;
	}

	@Override
	public void createCount(Count count, CountLog log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCount(CountLog log) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCountLog(CountLog log, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCountLog(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User readUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountLog readCountLog(String id, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountLog readCountLog(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateCountLog(CountLog log, User user) {
		// TODO Auto-generated method stub
		return false;
	}
}

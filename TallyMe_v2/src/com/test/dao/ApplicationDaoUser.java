package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.test.beans.Guest;
import com.test.beans.User;
import com.test.services.ApplicationServiceUser;

public class ApplicationDaoUser implements ApplicationServiceUser {

	@Override
	public Map<UUID, User> readUsers() {
		// TODO Auto-generated method stub
		User user = null;
		Map<UUID, User> users = new LinkedHashMap<UUID, User>();
		
		try {
			// get connection to database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write select query to get all the log
            String sql = "select * from USER;";
            PreparedStatement statement = connection.prepareStatement(sql);
         
            // execute query, get resultset and return User info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = new Guest();
                user.setInternalId(UUID.fromString(set.getString("UUID")));
            	user.setFirstName(set.getString("FirstName"));
                user.setLastName(set.getString("LastName"));
                user.setUsername(set.getString("Username"));
                user.setPassword(set.getString("Password"));
                user.setEmailAddress(set.getString("EmailAddress"));
                users.put(user.getInternalId(), user);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
		
		return users;
	}

	@Override
	public User readUser(String id) {
		// TODO Auto-generated method stub
		User user = null;
        try {
            // get connection to database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write select query to get the log
            String sql = "select * from USER where UUID=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
		
         // execute query, get resultset and return User info
            ResultSet set = statement.executeQuery();
            while (set.next()) {
            	user = new Guest();
            	user.setInternalId(UUID.fromString(set.getString("UUID")));
            	user.setFirstName(set.getString("FirstName"));
                user.setLastName(set.getString("LastName"));
                user.setUsername(set.getString("Username"));
                user.setPassword(set.getString("Password"));
                user.setEmailAddress(set.getString("EmailAddress"));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		try {
		// get connection to database
        Connection connection = DBConnection.getConnectionToDatabase();

        // write select query to get the user
        String sql = "insert into USER (uuid, FirstName, LastName, Username, Password, EmailAddress) values (?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getInternalId().toString());
		statement.setString(2, user.getFirstName());
		statement.setString(3, user.getLastName());
		statement.setString(4, user.getUsername());
		statement.setString(5, user.getPassword());
		statement.setString(6, user.getEmailAddress());

        // execute query, update resultset
        statement.execute();

	    } catch (SQLException exception) {
	        exception.printStackTrace();
	    } catch (Exception exception) {
	        exception.printStackTrace();
	    }
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		try {
            // get connection to database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write select query to get the log
            String sql = "update USER set FirstName=?, LastName=?, Username=?, Password=?, EmailAddress=?, where UUID=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getInternalId().toString());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getUsername());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmailAddress());

            // execute query, update resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		try {
            // get connection to database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write select query to get the log
            String sql = "delete from USER where UUID=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, UUID.fromString(id).toString());

            // execute query, delete resultset
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
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
	
	public boolean validateUser(String username, String password) {
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
	
	public int registerUser(User user) {
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

	public User getProfileDetails(String username) {
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

}

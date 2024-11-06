package com.jlcindia.bookstore.dao;

import com.jlcindia.bookstore.to.*;

public interface UserDAO 
{
	public int registerUser(User user);	
	public User verifyUser(String username, String password);
	public String getPassword(String email);
	public int changePassword(int userId,String newPassword); 
	public User getUserByUserId(int userId) ; 
	public int updateProfile(User user);
}

package com.jlcindia.bookstore.service;

import com.jlcindia.bookstore.to.User;

public interface UserService 
{
	public int registerUser(User user);
	public User verifyUser(String username, String password);
	public String getPassword(String email);
	public int changePassword(int userId,String newPassword); 
	public User getUserByUserId(int userId) ; 
	public int updateProfile(User user);
}

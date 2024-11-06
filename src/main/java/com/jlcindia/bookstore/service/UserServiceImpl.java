package com.jlcindia.bookstore.service;

import com.jlcindia.bookstore.dao.DAOFactory;
import com.jlcindia.bookstore.dao.UserDAO;
import com.jlcindia.bookstore.to.User;

public class UserServiceImpl implements UserService
{
	UserDAO userDAO = DAOFactory.getUserDAO();
	
	@Override
	public int registerUser(User user) 
	{
		System.out.println("-----Register User (UserService)-----");
		return userDAO.registerUser(user);
	}

	@Override
	public User verifyUser(String username, String password) 
	{
		System.out.println("-----Verify User (UserService)-----");
		return userDAO.verifyUser(username, password);
	}

	@Override
	public String getPassword(String email) 
	{
		System.out.println("-----Password Retreiving (UserService)-----");
		return userDAO.getPassword(email);
	}

	@Override
	public int changePassword(int userId, String newPassword) 
	{
		System.out.println("-----Password Update (UserService)-----");
		return userDAO.changePassword(userId, newPassword);
	}

	@Override
	public User getUserByUserId(int userId) 
	{
		System.out.println("-----User Retreiving (UserService)-----");
		return userDAO.getUserByUserId(userId);
	}

	@Override
	public int updateProfile(User user) 
	{
		System.out.println("-----Update User Profile (UserService)-----");
		return userDAO.updateProfile(user);
	}

}

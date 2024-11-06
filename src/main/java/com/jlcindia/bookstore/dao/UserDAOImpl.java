package com.jlcindia.bookstore.dao;

import com.jlcindia.bookstore.to.User;
import com.jlcindia.bookstore.util.HibernateTemplate;

public class UserDAOImpl implements UserDAO
{
	HibernateTemplate htm = new HibernateTemplate();
	@Override
	public int registerUser(User user) 
	{
		System.out.println("-----Registering User (UserDAO)-----");
		int id = htm.save(user);
		System.out.println("userId :"+id);
		return id;
	}
	
	@Override
	public User verifyUser(String username, String password) 
	{
		System.out.println("-----Verifying User (UserDAO)-------");
		User user = (User) htm.executeQuery("FROM User WHERE username LIKE ?0 AND password LIKE ?1", User.class, username, password);
		return user;
	}

	@Override
	public String getPassword(String email) 
	{
		System.out.println("-----Password Retreiving (UserDAO)-----");
		User user = (User) htm.executeQuery("FROM User WHERE email LIKE?0", User.class, email);
		String pw = user.getPassword();
		System.out.println("Password:"+pw);
		return pw;
	}

	@Override
	public int changePassword(int userId, String newPassword) 
	{
		System.out.println("-----Password Updating (UserDAO)-----");
		User user = htm.executeQuery("FROM User WHERE userId = ?0", User.class, userId);
		user.setPassword(newPassword);
		int upd = htm.update(user);
		return upd;
	}

	@Override
	public User getUserByUserId(int userId) {
		System.out.println("------User Retreiving (UserDAO)------");
		User user = (User) htm.load(User.class, userId);
		return user;
	}

	@Override
	public int updateProfile(User user) {
		System.out.println("------Update User Profile (UserDAO)-----");
		int updt = htm.update(user);
		return updt;
	}
}

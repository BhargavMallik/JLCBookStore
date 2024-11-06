package com.jlcindia.bookstore.dao;

public class DAOFactory 
{
	static UserDAO userDAO;
	static OrderDAO orderDAO;
	static BookDAO bookDAO;
	
	static
	{
		userDAO = new UserDAOImpl();
		orderDAO = new OrderDAOImpl();
		bookDAO = new BookDAOImpl();
	}
	
	public static UserDAO getUserDAO()
	{
		return userDAO;
	}
	
	public static OrderDAO getOrderDAO()
	{
		return orderDAO;
	}
	
	public static BookDAO getBookDAO()
	{
		return bookDAO;
	}
}

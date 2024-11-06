package com.jlcindia.bookstore.service;

public class ServiceFactory 
{
	static UserService userService;
	static BookService bookService;
	static OrderService orderService;
	
	static
	{
		userService = new UserServiceImpl();
		bookService = new BookServiceImpl();
		orderService = new OrderServiceImpl();
	}
	public static UserService getUserService()
	{
		return userService;
	}
	public static BookService getBookService()
	{
		return bookService;
	}
	public static OrderService getOrderService()
	{
		return orderService;
	}
}

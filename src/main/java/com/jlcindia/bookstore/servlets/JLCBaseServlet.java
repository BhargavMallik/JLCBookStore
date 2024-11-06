package com.jlcindia.bookstore.servlets;

import javax.servlet.http.HttpServlet;

import com.jlcindia.bookstore.service.BookService;
import com.jlcindia.bookstore.service.OrderService;
import com.jlcindia.bookstore.service.ServiceFactory;
import com.jlcindia.bookstore.service.UserService;

public abstract class JLCBaseServlet extends HttpServlet 
{ 
	static UserService userService;
	static BookService bookService;
	static OrderService orderService;
	
	static
	{
		userService = ServiceFactory.getUserService();
		bookService = ServiceFactory.getBookService();
		orderService = ServiceFactory.getOrderService();
	}
	
}
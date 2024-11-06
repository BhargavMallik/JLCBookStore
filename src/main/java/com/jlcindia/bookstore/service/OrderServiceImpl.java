package com.jlcindia.bookstore.service;

import java.util.List;

import com.jlcindia.bookstore.dao.DAOFactory;
import com.jlcindia.bookstore.dao.OrderDAO;
import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Order;

public class OrderServiceImpl implements OrderService
{
	OrderDAO orderDAO = DAOFactory.getOrderDAO();
	
	@Override
	public int placeOrder(int userId, List<String> bookNames) 
	{
		System.out.println("----Placing Order (OrderService)----");
		return orderDAO.placeOrder(userId, bookNames);
	}

	@Override
	public List<Order> getOrderHistory(int userId) 
	{
		System.out.println("----Order History Retreiving (OrderService)----");
		return orderDAO.getOrderHistory(userId);
	}
}

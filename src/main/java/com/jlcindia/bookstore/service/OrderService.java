package com.jlcindia.bookstore.service;

import java.util.List;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Order;

public interface OrderService 
{
	public int placeOrder(int userId, List<String> bookNames);
    List<Order> getOrderHistory(int userId);
}

package com.jlcindia.bookstore.dao;

import java.util.List;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Order;

public interface OrderDAO 
{
    int placeOrder(int userId, List<String> bookNames);
    List<Order> getOrderHistory(int userId);
}

package com.jlcindia.bookstore.dao;

import java.util.Date;
import java.util.List;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.to.Order;
import com.jlcindia.bookstore.util.HibernateTemplate;

public class OrderDAOImpl implements OrderDAO
{
	HibernateTemplate htm = new HibernateTemplate();
	BookDAO bookDAO = DAOFactory.getBookDAO();
	@Override
	public int placeOrder(int userId, List<String> bookNames) {
		System.out.println("----Placing Order (OrderDAO)----");

		Order order = new Order(userId, new Date());
		
		double totalAmount = 0.0;
		for (int i = 0; i < bookNames.size(); i++)
		{
			String bookName = bookNames.get(i);
			System.out.println("BookName :"+bookName);
			Book book = htm.executeQuery("FROM Book WHERE title Like ?0", Book.class, bookName);
			System.out.println("Book :"+book);
			int quantity = 1;
			if (book.getStock() < quantity) {
	            System.out.println("Insufficient stock for book: " + bookName);
	            return -1; // Indicate failure due to insufficient stock
	        }
			
			totalAmount += book.getPrice() * quantity;
			
			order.addOrderBook(book, quantity);
			
			// Update the book stock
	        book.setStock(book.getStock() - quantity);
	        htm.update(book); // Persist the stock change in the database
		}
		order.setTotalAmount(totalAmount);
		System.out.println("Order: "+order);
		
		int orderId = htm.save(order);
		System.out.println("OrderId: "+orderId);

		return orderId;
	}
	
	@Override
	public List<Order> getOrderHistory(int userId) 
	{
		System.out.println("----Order History Retreiving (OrderDAO)----");
		List<Order> orders = htm.executeQueryList("FROM Order WHERE userId = ?0", Order.class, userId);
		return orders;
	}
}

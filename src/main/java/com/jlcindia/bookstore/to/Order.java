package com.jlcindia.bookstore.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jlcindia.bookstore.util.HibernateTemplate;

@Entity
@Table(name="orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="urderId")
	private int userId;
	
	@Column(name="totalAmount")
	private double totalAmount;
	
	@Column(name="orderDate")
	private Date orderDate;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OrderBook> orderBooks = new HashSet<>();
	

	public Order() {}
	
	
	public Order(int userId, Date orderDate) {
		super();
		this.userId = userId;
		this.orderDate = orderDate;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Set<OrderBook> getOrderBooks() {
		return orderBooks;
	}

	public void setOrderBooks(Set<OrderBook> orderBooks) {
		this.orderBooks = orderBooks;
	}
	
	public void addOrderBook(Book book, int quantity) {
	    OrderBook orderBook = new OrderBook(this, book, quantity);
	    this.orderBooks.add(orderBook);
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", totalAmount=" + totalAmount + ", orderDate="
				+ orderDate + "]";
	}
	
	public List<String> getBookNames(int orderId) 
	{
		HibernateTemplate htm = new HibernateTemplate();
		System.out.println("----Books Retreiving by OrderId (Order)----");
		List<OrderBook> orderBooks = htm.executeQueryList("FROM OrderBook WHERE orderId = ?0", OrderBook.class, orderId);
		List<String> bookNames = new ArrayList<>();
		
		for (OrderBook orderbook : orderBooks)
		{
			Book book = orderbook.getBook();
			System.out.println("Book:"+book);
			bookNames.add(book.getTitle());
		}
		
		return bookNames;
	}
	
}

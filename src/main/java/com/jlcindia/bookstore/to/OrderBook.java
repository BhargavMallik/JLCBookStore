package com.jlcindia.bookstore.to;

import javax.persistence.*;

@Entity
@Table(name = "orderBooks")
public class OrderBook 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;
	
	
	private int quantity;
	
	public OrderBook() {}
	
	public OrderBook(Order order, Book book, int quantity) {
	    this.order = order;
	    this.book = book;
	    this.quantity = quantity;
	}

	
	public OrderBook(Book book, int quantity)
	{
		this.book = book;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderBook [id=" + id + ", order=" + order + ", book=" + book + ", quantity=" + quantity + "]";
	}

	
}

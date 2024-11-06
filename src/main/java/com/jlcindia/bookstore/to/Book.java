package com.jlcindia.bookstore.to;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookId")
    private int bookId;
	
	@Column(name="title")
    private String title;
	
	@Column(name="author")
    private String author;
	
	@Column(name="price")
    private double price;
	
	@Column(name="category")
    private String category;
	
	@Column(name="stock")
    private int stock;
	
	public Book() {}
    
	public Book(int bookId, String title, String author, double price, String category, int stock) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
		this.stock = stock;
	}

	public Book(int bookId, String title, String author, double price, String category) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}

	public Book(String bname, double price, int quantity) {
		this.title = bname;
		this.price = price;
		this.stock = quantity;
	}


	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", price=" + price + ", category="
				+ category + ", stock=" + stock + "]";
	}
	
	
}

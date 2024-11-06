package com.jlcindia.bookstore.dao;

import java.util.List;

import com.jlcindia.bookstore.to.Book;
import com.jlcindia.bookstore.util.HibernateTemplate;

public class BookDAOImpl implements BookDAO
{
	HibernateTemplate htm = new HibernateTemplate();

	@Override
	public List<Book> getBooksByCategory(String category) 
	{
		System.out.println("----Retreiving Books by Category (BookDAO)----");
		List<Book> books = (List<Book>) htm.executeQueryList("FROM Book WHERE category LIKE ?0", Book.class, category);
		return books;
	}

	@Override
	public List<Book> getAllBooks() {
		System.out.println("----Retreiving All Books (BookDAO)----");
		List<Book> books = (List<Book>) htm.executeQueryList("FROM Book", Book.class);
		return books;
	}

	@Override
	public Book getBookByTitle(String bookName) {
		System.out.println("----Retreiving Specific Book Details (BookDAO)-----");
		Book book = htm.executeQuery("FROM Book WHERE title LIKE ?0", Book.class, bookName);
		return book;
	}

	@Override
	public double getBookPriceByName(String bookName) {
		System.out.println("-----Retreiving Book Price by BookName (BookDAO) -----");
		Book book = htm.executeQuery("FROM Book WHERE title LIKE ?0", Book.class, bookName);
		return book.getPrice();
	}

}

package com.jlcindia.bookstore.service;

import java.util.List;

import com.jlcindia.bookstore.dao.BookDAO;
import com.jlcindia.bookstore.dao.DAOFactory;
import com.jlcindia.bookstore.to.Book;

public class BookServiceImpl implements BookService
{
	BookDAO bookDAO = DAOFactory.getBookDAO();	
	
	@Override
	public List<Book> getBooksByCategory(String category) {
		System.out.println("----Retreiving Books by Category (BookService)----");
		return bookDAO.getBooksByCategory(category);
	}

	@Override
	public List<Book> getAllBooks() {
		System.out.println("----Retreiving All Books (BookDAO)----");
		return bookDAO.getAllBooks();
	}

	@Override
	public Book getBookByTitle(String bookName) {
		System.out.println("----Retreiving Specific Book Details (BookDAO)-----");
		return bookDAO.getBookByTitle(bookName);
	}

	@Override
	public double getBookPriceByName(String bookName) {
		System.out.println("-----Retreiving Book Price by BookName (BookDAO) -----");
		return bookDAO.getBookPriceByName(bookName);
	}

}

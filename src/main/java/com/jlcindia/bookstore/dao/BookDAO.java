package com.jlcindia.bookstore.dao;

import java.util.List;

import com.jlcindia.bookstore.to.Book;

public interface BookDAO 
{
    List<Book> getBooksByCategory(String category);  
    List<Book> getAllBooks();
	Book getBookByTitle(String bookName);
	double getBookPriceByName(String bookName);
}

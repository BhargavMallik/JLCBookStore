package com.jlcindia.bookstore.service;

import java.util.List;

import com.jlcindia.bookstore.to.Book;

public interface BookService 
{
    List<Book> getBooksByCategory(String category);  
    List<Book> getAllBooks();
	Book getBookByTitle(String bookName);
	double getBookPriceByName(String bookName);
}

package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlcindia.bookstore.service.BookService;
import com.jlcindia.bookstore.service.BookServiceImpl;
import com.jlcindia.bookstore.to.Book;

@WebServlet(name = "searchBooks", urlPatterns = "/searchBooks.jlc") 
public class SearchBooksServlet extends JLCBaseServlet { 
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
        System.out.println("----SearchBooksServlet---"); 

        // 1. Collect Input Data 
        String cat = request.getParameter("category"); 
        System.out.println(cat); 

        // 2. Do Processing 
        HttpSession session = request.getSession(); 
        session.setAttribute("CAT", cat); 
        
        // Make Empty Cart Ready 
        List<String> mycart1 = (List<String>) session.getAttribute("MyCart"); 
        if (mycart1 == null) { 
            List<String> mycart = new ArrayList<>(); 
            session.setAttribute("MyCart", mycart); 
        } 
        
        String msg = ""; 
        String page = ""; 
        if (cat == null || cat.length() == 0) { 
            msg = "Please Select Category"; 
            request.setAttribute("MSG", msg); 
            page = "home.jsp"; 
        } else {
            // Fetch books from the database based on category
            List<Book> books = bookService.getBooksByCategory(cat);
            
            if (books.isEmpty()) {
                msg = "Sorry, No Books for " + cat; 
                request.setAttribute("MSG", msg); 
                page = "home.jsp"; 
            } else {
                session.setAttribute("BooksList", books); // Set the fetched books in the session
                page = "showBooks.jsp"; 
            }
        }
        
        // 3. Forward 
        RequestDispatcher rd = request.getRequestDispatcher(page); 
        rd.forward(request, response); 
    } 
}

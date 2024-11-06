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

import com.jlcindia.bookstore.to.Book;

@WebServlet(name = "addToCart", urlPatterns = "/addToCart.jlc")
public class AddToCartServlet extends JLCBaseServlet 
{
	@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
        System.out.println("----AddToCartServlet---");
        
        // 1. Collect Input Data
        String bname = request.getParameter("bname");
        String quantityStr = request.getParameter("quantity");
        
        // Validate the book name
        if (bname == null || bname.isEmpty()) {
            request.setAttribute("message", "Book name cannot be null or empty.");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            return; // Stop further processing
        }
        
     // Validate and parse quantity
        int quantity = 0;
        try {
            quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                throw new NumberFormatException("Quantity must be greater than zero.");
            }
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Invalid quantity: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
            return; // Stop further processing
        }
        
        
        // 2. Do Processing
        HttpSession session = request.getSession();
        List<Book> mycart = (List<Book>) session.getAttribute("MyCart");
        
        // If cart is null, initialize it
        if (mycart == null) {
            mycart = new ArrayList<>();
        }
        
        Book book = bookService.getBookByTitle(bname);
        // Create a new BookTO object and add it to the cart
        Book book1 = new Book(book.getBookId(), bname, book.getAuthor(), book.getPrice(), book.getCategory(), quantity); // Assuming BookTO has a constructor
        mycart.add(book1);
        
        // Set the updated cart in the session
        session.setAttribute("MyCart", mycart);
        
        // Debug: Print the updated cart contents
        System.out.println("Updated cart: " + mycart);
        
        // 3. Forward to show the cart page
        String page = "showBooks.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);

	}
}

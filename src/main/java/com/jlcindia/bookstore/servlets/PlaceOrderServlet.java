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

@WebServlet(name = "placeOrder", urlPatterns = "/placeOrder.jlc")
public class PlaceOrderServlet extends JLCBaseServlet
{
	 @Override
	    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	 {
	        System.out.println("----PlaceOrderServlet---");
	        
	        HttpSession session = request.getSession();
	        Integer userId = (Integer) session.getAttribute("userId");
	        List<Book> cartBooks = (List<Book>) session.getAttribute("MyCart");
	        
	        // Debugging prints
	        System.out.println("User ID: " + userId);
	        System.out.println("Cart Books: " + cartBooks);
	        
	        // Handle potential null userId
	        if (userId == null) {
	            request.setAttribute("message", "User ID is not set. Please log in.");
	            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
	            rd.forward(request, response);
	            return;
	        }
	        
	        // Handle potential null or empty cartBooks
	        if (cartBooks == null || cartBooks.isEmpty()) {
	            request.setAttribute("message", "Your cart is empty. Please add books to your cart.");
	            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
	            rd.forward(request, response);
	            return;
	        }
	        
	        List<String> bookNames = new ArrayList<>();
	        for (Book book : cartBooks)
	        {
	        	bookNames.add(book.getTitle());
	        }
	        
	        //Create Order object
	        int orderId = orderService.placeOrder(userId, bookNames);
	        System.out.println("OrderId : " +orderId);
	        
	        String message;
	        if (orderId > 0) {
	            message = "Order placed successfully!";
	            request.setAttribute("orderedBooks", cartBooks); // Pass cart books to the confirmation page
	            session.removeAttribute("MyCart"); // Clear the cart
	        } else {
	            message = "Failed to place the order. Please try again.";
	        }

	        request.setAttribute("message", message);
	        RequestDispatcher rd = request.getRequestDispatcher("orderConfirmation.jsp");
	        rd.forward(request, response);
	        
	 }
}

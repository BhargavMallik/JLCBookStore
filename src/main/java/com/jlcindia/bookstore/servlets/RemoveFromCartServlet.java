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

@WebServlet(name = "removeFromCart", urlPatterns = "/removeFromCart.jlc")
public class RemoveFromCartServlet extends JLCBaseServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("----RemoveFromCartServlet---");

        // 1. Collect Input Data
        String bname = request.getParameter("bname");
        System.out.println("Book to remove: " + bname);

        // 2. Do Processing
        String page = "showCart.jsp";

        HttpSession session = request.getSession();
        List<Book> mycart = (List<Book>) session.getAttribute("MyCart");

        // Initialize cart if it doesn't exist
        if (mycart == null) {
            mycart = new ArrayList<>();
            session.setAttribute("MyCart", mycart);
        }

        // Remove book from cart
        if (bname != null) {
            boolean removed = mycart.removeIf(book -> book.getTitle().equals(bname)); // Update this line to check by title
            session.setAttribute("MyCart", mycart);
            
            if (removed) {
                request.setAttribute("message", "Book removed successfully.");
                System.out.println("Removed: " + bname);
            } else {
                request.setAttribute("message", "Book not found in cart: " + bname);
            }
        }

        // 3. Forward
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }
}

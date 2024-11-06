package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlcindia.bookstore.service.OrderService;
import com.jlcindia.bookstore.service.OrderServiceImpl;
import com.jlcindia.bookstore.to.Order;

@WebServlet("/orderHistory.jlc")
public class OrderHistoryServlet extends JLCBaseServlet {
    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        
        if (userId != null) {
            // Fetch all orders for the user
            OrderService orderService = new OrderServiceImpl();
            List<Order> orderHistory = orderService.getOrderHistory(userId);
            
            // Set the order history in the request scope to be accessed in JSP
            request.setAttribute("orderHistory", orderHistory);
        }
        
        // Forward to orderHistory.jsp
        RequestDispatcher rd = request.getRequestDispatcher("orderHistory.jsp");
        rd.forward(request, response);
    }
    
}

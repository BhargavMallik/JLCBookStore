package com.jlcindia.bookstore.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlcindia.bookstore.to.User;


@WebServlet(name = "mylogin", urlPatterns = "/mylogin.jlc")
	
	public class LoginServlet extends JLCBaseServlet { 
		public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
			
			System.out.println("LoginServlet-service()"); 
			
			// 1.Collect the Input 
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			// 2.Process 
			User userTO = userService.verifyUser(username, password); 
			
			 
			
			String page = ""; 
			if (userTO != null) { 
				page = "home.jsp"; 
				HttpSession session = req.getSession(); 
				session.setAttribute("MyUserInfo", userTO);
				session.setAttribute("userId", userTO.getUserId());
			} else { 
				page = "login.jsp"; 
				String loginMsg = "Invalid Username or Password"; 
				req.setAttribute("LoginMsg", loginMsg); 
			} 
			
			// 3.Prepare to forward
			RequestDispatcher rd = req.getRequestDispatcher(page); 
			rd.forward(req, res); 
		} 
	}




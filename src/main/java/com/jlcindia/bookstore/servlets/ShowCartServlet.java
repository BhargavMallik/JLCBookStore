package com.jlcindia.bookstore.servlets;

import java.io.IOException; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

@WebServlet(name="showMyCart" , urlPatterns = "/showMyCart.jlc") 
public class ShowCartServlet extends HttpServlet
{ 
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{ 
		System.out.println("----ShowCartServlet---"); 

		//1. No Input data 
 

		//2.Do Processing 
		String page="showCart.jsp"; 
 
		//3.Forward 
		RequestDispatcher rd=request.getRequestDispatcher(page); 
		rd.forward(request, response); 
	} 
}
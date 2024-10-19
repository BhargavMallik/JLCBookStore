package com.jlcindia.bookstore.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlcindia.bookstore.to.UserTO;

public class UpdateProfileController extends JLCBaseController{ 
	
	public String process(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{ 
		
		System.out.println("UpdateProfileController-process()"); 
		
		
		String URI = req.getRequestURI(); 
		int updateStatus = 0; 
		String page = ""; 
		if (URI.endsWith("editProfile.jlc")) { 
			HttpSession session = req.getSession(false); 
			if (session == null) { 
				String msg = "Session Expired. Login Again"; 
				req.setAttribute("LoginMsg", msg); 
				page = "login.jsp"; 
			}
			else { 
				UserTO userTO = (UserTO) session.getAttribute("MyUserInfo"); 
				int userId = userTO.getUserId(); 
				UserTO myuserTO = userService.getUserByUserId(userId); 
				session.setAttribute("MyUserInfo", myuserTO); 
				page = "updateprofile.jsp"; 
			} 
		} else if (URI.endsWith("updateProfile.jlc")) { 
			String userId = req.getParameter("userId"); 
			String fullName = req.getParameter("fullName"); 
			String email = req.getParameter("email"); 
			String phone = req.getParameter("phone"); 
			String username = req.getParameter("username"); 
			
			UserTO userTO = new UserTO(); 
			userTO.setUserId(Integer.parseInt(userId)); 
			userTO.setFullName(fullName); 
			userTO.setEmail(email); 
			userTO.setPhone(Long.parseLong(phone)); 
			userTO.setUsername(username); 
			updateStatus = userService.updateProfile(userTO); 
			if (updateStatus==1) { 
				page = "updateprofilestatus.jsp"; 
				String upMsg = "Your Profile is updated Successfully"; 
				req.setAttribute("UpdateMsg", upMsg); 
			} else { 
				page = "updateprofile.jsp"; 
				String upMsg = "Something Wrong, Try again"; 
				req.setAttribute("UpdateMsg", upMsg);
			} 
		} 
		return page; 
	} 
}

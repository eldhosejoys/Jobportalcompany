package com.jobportal.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLogin() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		 if(username.equals("admin")&&password.equals("1234") ) {
			 HttpSession session=request.getSession(true);
				session.setAttribute("adminname", username);
			 response.sendRedirect("adminhome.jsp");
	        }
		 else {
	        	response.sendRedirect("adminLogin.jsp?message=Wrong Credentials");
	        }
	}

}

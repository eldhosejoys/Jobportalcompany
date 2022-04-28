package com.jobportal.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.jobportal.entities.JobProvider;
import com.jobportal.repos.JobProviderRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/jplogin")
public class JobProviderLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JobProviderLogin() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		JobProviderRepository repo = new JobProviderRepository();
		ArrayList<JobProvider> doesExist = (ArrayList<JobProvider>) repo.JobProviderlogin2(email,password);
		JobProvider provider=null;
	
			try {
			provider=doesExist.get(0);
			int jpid=provider.getId();
		
			session.setAttribute("jpemail",email);
			session.setAttribute("jpid",jpid);
			
			System.out.print(jpid);
			response.sendRedirect("jobproviderhome.jsp");
		}catch(Exception e) {
			response.sendRedirect("jobproviderlogin.jsp?message=Wrong Credentials");
		}		
		
	}

}

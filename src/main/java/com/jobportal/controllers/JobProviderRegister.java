package com.jobportal.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.jobportal.entities.JobProvider;
import com.jobportal.repos.JobProviderRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/jpregister")
public class JobProviderRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JobProviderRegister() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=false;
		
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String technology = request.getParameter("technology");
		String password = request.getParameter("password");
		
		JobProvider jobprovider=new JobProvider();
		jobprovider.setName(name);
		jobprovider.setLocation(location);
		jobprovider.setContact(contact);
		jobprovider.setEmail(email);
		jobprovider.setWebsite(website);
		jobprovider.setTechnology(technology);
		jobprovider.setPassword(password);
		
		JobProviderRepository jprepo =new JobProviderRepository();
		
		boolean jpstatus=jprepo.addJobProvider(jobprovider);
		
		if(jpstatus) {
			HttpSession session	= request.getSession(true);		
			session.setAttribute("jpemail",email);
			Integer id=jobprovider.getId();
			session.setAttribute("jpid",id);
			
			status=true;
			response.sendRedirect("jobproviderlogin.jsp");
		}
		else {
		response.sendRedirect("jobproviderregister.jsp?status="+status);
		}
	}

}

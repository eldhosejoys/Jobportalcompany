package com.jobportal.controllers;

import java.io.IOException;

import com.jobportal.entities.JobProvider;
import com.jobportal.repos.JobProviderRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editprovider")
public class EditJPProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditJPProfile() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String contact =request.getParameter("contact");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String technology = request.getParameter("technology");
		
		String pass=request.getParameter("pass");
		System.out.println(pass);
		JobProvider jp=new JobProvider();
		jp.setId(id);
		jp.setName(name);
		jp.setLocation(location);
		jp.setContact(contact);
		jp.setEmail(email);
		jp.setWebsite(website);
		jp.setTechnology(technology);
		
		jp.setPassword(pass);
		JobProviderRepository repo =new JobProviderRepository();
		
		boolean haserror=repo.updateJobProvider(jp);
		
		if(haserror) {
			response.sendRedirect("viewjobproviderprofile.jsp");
		}else {
		
		response.sendRedirect("editprovider.jsp?status=false&id="+id);
		}
	}

}

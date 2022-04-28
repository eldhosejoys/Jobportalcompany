package com.jobportal.controllers;

import java.io.IOException;

import com.jobportal.entities.JobSeeker;
import com.jobportal.repos.JobSeekerRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editseeker")
public class EditJSProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EditJSProfile() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		Integer age=Integer.parseInt(request.getParameter("age"));
		String dob=request.getParameter("dob");
		String pass=request.getParameter("password");
		System.out.println(pass);
		JobSeeker js=new JobSeeker();
		js.setId(id);
		js.setName(name);
		js.setAge(age);
		js.setContact(contact);
		js.setEmail(email);
	
		js.setDob(dob);
		js.setPassword(pass);
		JobSeekerRepository repo =new JobSeekerRepository();
		
		boolean haserror=repo.updateJobSeeker(js);
		
		if(haserror) {
			response.sendRedirect("viewjobseekerprofile.jsp");
		}else {
		
		response.sendRedirect("editseeker.jsp?status=false&id="+id);
		}
	}

}

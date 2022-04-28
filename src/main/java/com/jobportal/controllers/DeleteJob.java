package com.jobportal.controllers;

import java.io.IOException;

import com.jobportal.repos.JobsRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletejob")
public class DeleteJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteJob() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("id"));
        JobsRepository repo=new JobsRepository();
        repo.deleteJobs(id);
        response.sendRedirect("viewjobs.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package com.jobportal.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.jobportal.entities.Jobs;
import com.jobportal.repos.JobsRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addjobs")
public class AddJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddJobs() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session	= request.getSession(true);	
		if(session.getAttribute("jpid")=="") {
			response.sendRedirect("jobproviderlogin.jsp?status=false");
		}

		boolean status = false;
		Integer jpid= Integer.parseInt(request.getParameter("jpid"));
		String name=request.getParameter("name");
		Integer yop= Integer.parseInt(request.getParameter("yop"));
		String qualification=request.getParameter("qualification");
		String skills=request.getParameter("skills");
		

		Jobs jobs = new Jobs();
		jobs.setJpid(jpid);
		jobs.setName(name);
		jobs.setYop(yop);
		jobs.setQualification(qualification);
		jobs.setSkills(skills);
		

		JobsRepository jobsrepo = new JobsRepository();

		int jid=jobs.getId();
		
		boolean jobsstatus = jobsrepo.addJobs(jobs);
		if (jobsstatus) {
			status = true;
			response.sendRedirect("viewjobs.jsp");
		} else {
			response.sendRedirect("jobproviderhome.jsp?status=" + status);
		}
	}
	}



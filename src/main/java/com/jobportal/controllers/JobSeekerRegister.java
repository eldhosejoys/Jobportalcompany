package com.jobportal.controllers;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.jobportal.entities.JobSeeker;
import com.jobportal.entities.Resume;
import com.jobportal.repos.JobSeekerRepository;
import com.jobportal.repos.ResumeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/jsregister")
public class JobSeekerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JobSeekerRegister() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status=false;
		
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		
		JobSeeker jobseeker=new JobSeeker();
		jobseeker.setName(name);
		jobseeker.setAge(age);
		jobseeker.setDob(dob);
		jobseeker.setEmail(email);
		jobseeker.setContact(contact);
		jobseeker.setPassword(password);
		
		JobSeekerRepository jsrepo =new JobSeekerRepository();
		
		boolean jsstatus=jsrepo.addJobSeeker(jobseeker);
		
		if(jsstatus) {
			HttpSession session	= request.getSession(true);	

			//JobSeeker jobseekers=jsrepo.findJobSeekerByEmail(email);
			Integer id=jobseeker.getId();
			
		
			session.setAttribute("jsemail",email);
			session.setAttribute("jsid",id);
			
			Resume resume = new Resume();
			resume.setJsid(id);
			ResumeRepository resumerepo = new ResumeRepository();
			boolean resumestatus = resumerepo.addResume(resume);
			Resume resumes= new Resume();
			Integer id1=resume.getId();

			session.setAttribute("resumeid",id1);
			
			status=true;
			response.sendRedirect("addresume.jsp");
		}
		else {
		response.sendRedirect("jobseekerregister.jsp?status="+status);
		}
			
	}

}

package com.jobportal.controllers;

import java.io.IOException;

import com.jobportal.entities.ApplyJobs;
import com.jobportal.entities.JobSeeker;
import com.jobportal.entities.Resume;
import com.jobportal.repos.JobSeekerRepository;
import com.jobportal.repos.JobsRepository;
import com.jobportal.repos.ResumeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewlogin")
public class viewloginjobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public viewloginjobs() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);	
		Integer jsid =(Integer)session.getAttribute("jsid");

		String jname=request.getParameter("jname");
		String cgpa=request.getParameter("qualification");
		Integer yop=Integer.parseInt(request.getParameter("yop"));
		Integer jpid=Integer.parseInt(request.getParameter("jpid"));
		Integer jobsid=Integer.parseInt(request.getParameter("id"));
		
		
			
		if(session.getAttribute("jsid")==null){
			response.sendRedirect("jobseekerlogin.jsp");
		}
		else {
			JobSeekerRepository repo1= new JobSeekerRepository();
			JobSeeker js=repo1.findJobSeekerByid(jsid);
			String sname=js.getName();
			String email=js.getEmail();
			
			ResumeRepository repo2=new ResumeRepository();
			Resume rs=repo2.findResumeByjsid(jsid);
			int syop=rs.getYop();
			String scgpa=rs.getCgpa();
			String skill=rs.getSkills();
			
			ApplyJobs apply=new ApplyJobs();
			apply.setJsid(jsid);
			apply.setJpid(jpid);
			apply.setJobsid(jobsid);
			apply.setJname(jname);
			apply.setCgpa(cgpa);
			apply.setYop(yop);
			apply.setSname(sname);
			apply.setEmail(email);
			apply.setSyop(syop);
			apply.setScgpa(scgpa);
			apply.setSkills(skill);
		JobSeekerRepository repo = new JobSeekerRepository();
		boolean doesExist=repo.checkapply(jsid, jobsid);
		if (doesExist==true) {
			response.sendRedirect("viewalljobs.jsp?message=already applied!");
		} 
		else
		{
			JobsRepository job = new JobsRepository();
			boolean applystatus = job.addapplyJobs(apply);
			response.sendRedirect("viewalljobs.jsp?message=applied!");
		}}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

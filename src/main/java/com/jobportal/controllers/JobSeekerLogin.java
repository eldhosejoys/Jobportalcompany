package com.jobportal.controllers;

import java.io.IOException;
import java.util.ArrayList;

import com.jobportal.entities.JobSeeker;
import com.jobportal.entities.Resume;
import com.jobportal.repos.JobSeekerRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/jslogin")
public class JobSeekerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JobSeekerLogin() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		JobSeekerRepository repo = new JobSeekerRepository();
		ArrayList<JobSeeker> doesExist = (ArrayList<JobSeeker>) repo.JobSeekerlogin2(email,password);
		JobSeeker seeker=null;
		
			try {
			seeker=doesExist.get(0);
			int jsid=seeker.getId();
			
			Resume resume=new Resume();
			Integer resumeid=resume.getId();
			HttpSession session	= request.getSession(true);	
			session.setAttribute("jsemail",email);
			session.setAttribute("jsid",jsid);
			session.setAttribute("resumeid",resumeid);
			
			response.sendRedirect("jobseekerhome.jsp");
		}
			catch(Exception e ) {
				System.out.println(e);
			response.sendRedirect("jobseekerlogin.jsp?message=Wrong Credentials");
		}		
		
	}

}

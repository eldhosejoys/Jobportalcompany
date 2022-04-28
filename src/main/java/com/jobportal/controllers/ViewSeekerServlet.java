package com.jobportal.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.jobportal.entities.JobSeeker;
import com.jobportal.repos.JobSeekerRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/viewseeker")

public class ViewSeekerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewSeekerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobSeekerRepository repo = new JobSeekerRepository();
		
		ArrayList<JobSeeker> seekerlist = repo.listJS();
		JobSeeker js = null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<table>");
			out.println("<tr>");
				out.println("<th>" + "id" + "</th>");
				out.println("<th>" + "Name" + "</th>");
				out.println("<th>" + "Age" + "</th>");
				out.println("<th>" + "Contact" + "</th>");
				out.println("<th>" + "Dob" + "</th>");
				out.println("<th>" + "email" + "</th>");
			out.println("</tr>");
			
			for(int i = 0; i < seekerlist.size(); i++)
			{
				js = seekerlist.get(i);
				
				int rno = js.getId();
				String name = js.getName();
				int age = js.getAge();
				String contact=js.getContact();
				String dob=js.getDob();
				String email=js.getEmail();
				
				out.println("<tr>");
					out.println("<td>" + rno + "</td>");
					out.println("<td>" + name + "</td>");
					out.println("<td>" + age + "</td>");
					out.println("<td>" + contact + "</td>");
					out.println("<td>" + dob + "</td>");
					out.println("<td>" + email + "</td>");
				
					//out.println("<td><a href=\"deleteprov?jid=" + rno + "\">DELETE</a></td>");
				out.println("</tr>");
			}
		out.println("</table>");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

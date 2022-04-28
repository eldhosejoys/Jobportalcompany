package com.jobportal.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.jobportal.entities.JobProvider;
import com.jobportal.entities.Jobs;
import com.jobportal.repos.AdminRepository;
import com.jobportal.repos.JobProviderRepository;
import com.jobportal.repos.JobsRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteprov")
public class DeleteProvider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteProvider() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("jid"));
		AdminRepository repo = new AdminRepository();
		
		if(repo.deleteJobProvider(id)) {
		JobProviderRepository repo1 = new JobProviderRepository();
		ArrayList<JobProvider> providerlist = repo1.listJP();
		
		//JobsRepository repo1=new JobsRepository();
		//ArrayList<Jobs> joblist = repo1.listJob();
		
		JobProvider jp = null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<table>");
			out.println("<tr>");
				out.println("<th>" + "id" + "</th>");
				out.println("<th>" + "Name" + "</th>");
				out.println("<th>" + "location" + "</th>");
				out.println("<th>" + "Contact" + "</th>");
				out.println("<th>" + "website" + "</th>");
				out.println("<th>" + "email" + "</th>");
			out.println("</tr>");
			
			for(int i = 0; i < providerlist.size(); i++)
			{
				jp = providerlist.get(i);
				
				int rno = jp.getId();
				String name = jp.getName();
				String location = jp.getLocation();
				String contact=jp.getContact();
				String website=jp.getWebsite();
				String email=jp.getEmail();
				
				out.println("<tr>");
					out.println("<td>" + rno + "</td>");
					out.println("<td>" + name + "</td>");
					out.println("<td>" + location + "</td>");
					out.println("<td>" + contact + "</td>");
					out.println("<td>" + website + "</td>");
					out.println("<td>" + email + "</td>");
				
					//out.println("<td><a href=\"deleteprov?jid=" + rno + "\">DELETE</a></td>");
				out.println("</tr>");
			}
		out.println("</table>");
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<H1>" + "Some error occured!" + "</H1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

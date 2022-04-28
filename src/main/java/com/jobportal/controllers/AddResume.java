package com.jobportal.controllers;

import java.io.IOException;

import com.jobportal.entities.Resume;
import com.jobportal.repos.ResumeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/resume")
public class AddResume extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddResume() {
		super();
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession session	= request.getSession(true);	
		if(session.getAttribute("jsid")=="") {
			response.sendRedirect("jobseekerlogin.jsp?status=false");
		}
		
		boolean status = false;
		Integer jsid=(Integer) session.getAttribute("jsid");
		String stream=request.getParameter("stream");
		String skills=request.getParameter("skills");
		Integer yop= Integer.parseInt(request.getParameter("yop"));
		String college=request.getParameter("college");
		String cgpa=request.getParameter("cgpa");
		Integer experience= Integer.parseInt(request.getParameter("experience"));
		String projects=request.getParameter("projects");
		String languageknown=request.getParameter("languageknown");

		Resume resume = new Resume();
		resume.setJsid(jsid);
		resume.setStream(stream);
		resume.setSkills(skills);
		resume.setYop(yop);
		resume.setCollege(college);
		resume.setCgpa(cgpa);
		resume.setExperience(experience);
		resume.setProjects(projects);
		resume.setLanguageknown(languageknown);

		ResumeRepository resumerepo = new ResumeRepository();
		int id = (Integer) session.getAttribute("resumeid");
		resume.setId(id);
		
		boolean resumestatus = resumerepo.updateResume(resume);

		if (resumestatus) {
			status = true;
			response.sendRedirect("jobseekerlogin.jsp");
		} else {
			response.sendRedirect("jobseekerlogin.jsp?status=" + status);
		}
	}

}

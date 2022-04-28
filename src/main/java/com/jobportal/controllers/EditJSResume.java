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

@WebServlet("/editresume")
public class EditJSResume extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditJSResume() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		Integer jsid=(Integer)session.getAttribute("jsid");
		Integer id=Integer.parseInt(request.getParameter("id"));
		String cgpa = request.getParameter("cgpa");
		String college = request.getParameter("college");
		Integer experience =Integer.parseInt( request.getParameter("experience"));
		String language=request.getParameter("language");
		String project=request.getParameter("project");
		String skill=request.getParameter("skill");
		Integer yop=Integer.parseInt( request.getParameter("yop"));
		String Stream=request.getParameter("stream");
		Resume rs=new Resume();
		rs.setId(id);
		rs.setCgpa(cgpa);
		rs.setCollege(college);
		rs.setExperience(experience);
		rs.setLanguageknown(language);
		rs.setProjects(project);
		rs.setSkills(skill);
		rs.setYop(yop);
		rs.setStream(Stream);
		rs.setJsid(jsid);
		
		ResumeRepository repo =new ResumeRepository();
		
		boolean haserror=repo.updateResume(rs);
		
		if(haserror) {
			response.sendRedirect("viewjobseekerprofile.jsp");
		}else {
		
		response.sendRedirect("editresume.jsp?status=false&id="+id);
		}
	}

}

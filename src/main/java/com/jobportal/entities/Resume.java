package com.jobportal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="resume_tb")
public class Resume {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	private int jsid;
	private String stream;
	private String skills;
	private int yop;
	private String college;
	private String cgpa;
	private int experience;
	private String projects;
	private String languageknown;
	
	public Resume() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJsid() {
		return jsid;
	}

	public void setJsid(int jsid) {
		this.jsid = jsid;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCgpa() {
		return cgpa;
	}

	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getLanguageknown() {
		return languageknown;
	}

	public void setLanguageknown(String languageknown) {
		this.languageknown = languageknown;
	}
	
	
}

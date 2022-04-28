package com.jobportal.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="apply_tb")
public class ApplyJobs {

	public ApplyJobs() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int jsid;
	private int jpid;
	private int jobsid;
	private String jname;
	private String cgpa;
	private int yop;
	private String skills;
	private String sname;
	private String email;
	private int syop;
	private String scgpa;
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSyop() {
		return syop;
	}
	public void setSyop(int syop) {
		this.syop = syop;
	}
	public String getScgpa() {
		return scgpa;
	}
	public void setScgpa(String scgpa) {
		this.scgpa = scgpa;
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
	public int getJpid() {
		return jpid;
	}
	public void setJpid(int jpid) {
		this.jpid = jpid;
	}
	public int getJobsid() {
		return jobsid;
	}
	public void setJobsid(int jobsid) {
		this.jobsid = jobsid;
	}
	
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public int getYop() {
		return yop;
	}
	public void setYop(int yop) {
		this.yop = yop;
	}
	
}

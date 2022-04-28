package com.jobportal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jobs_tb")
public class Jobs {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int jpid;
	private String name;
	private int yop;
	private String qualification;
	private String skills;
	
	public Jobs() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJpid() {
		return jpid;
	}

	public void setJpid(int jpid) {
		this.jpid = jpid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYop() {
		return yop;
	}

	public void setYop(int yop) {
		this.yop = yop;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	
}

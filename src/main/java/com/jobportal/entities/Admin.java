package com.jobportal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="admin_tb")
public class Admin {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
		private String username;
		private String password;
		
		public Admin() {
			
		}
		  
		
}

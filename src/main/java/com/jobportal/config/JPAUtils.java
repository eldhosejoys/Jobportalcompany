package com.jobportal.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtils {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	
	public static void createEntityManager() {
		 emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		 em = emf.createEntityManager();
	}
	
	public static EntityManager getEntityManager() {	      
		   return em;
	}
	
	public static void close() {
		emf.close();
		em.close();
	}

}

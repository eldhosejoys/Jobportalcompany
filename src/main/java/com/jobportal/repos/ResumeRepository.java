package com.jobportal.repos;

import com.jobportal.entities.Resume;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ResumeRepository {

	public ResumeRepository() {
		
	}
	
	public boolean addResume(Resume resume) {
		
		boolean status=true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
			em.persist(resume);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}		
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return status;
		
	}
	
	
	public Resume findResumeByjsid(Integer id) {
		
		Resume resume=null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		resume = em.find(Resume.class, id);

		em.getTransaction().commit();

		em.close();
		emf.close();

		return resume;
	}
	
	public boolean updateResume(Resume updatedResume) {
		
		
		boolean status=true;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			em.merge(updatedResume);

		} catch (Exception e) {
			e.printStackTrace();
			status=false;
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

		return status;
	}

}

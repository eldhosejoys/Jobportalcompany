package com.jobportal.repos;

import java.util.ArrayList;
import java.util.List;

import com.jobportal.entities.ApplyJobs;
import com.jobportal.entities.Jobs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JobsRepository {
	
	public JobsRepository() {
		
	}
	
public boolean addJobs(Jobs jobs) {
		
		boolean status=true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
			em.persist(jobs);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}		
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return status;
		
	}
public boolean addapplyJobs(ApplyJobs jobs) {
	
	boolean status=true;
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	try {
		em.persist(jobs);
	}catch(Exception e) {
		e.printStackTrace();
		status=false;
	}		
	
	em.getTransaction().commit();		
	
	em.close();
	emf.close();
	
	return status;
	
}


@SuppressWarnings("unchecked")
public ArrayList<Jobs> listJob()
{
	ArrayList<Jobs> job = new ArrayList<>();
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	
	job = (ArrayList<Jobs>) em.createQuery("FROM Jobs").getResultList();	
	
	em.getTransaction().commit();		
	
	em.close();
	emf.close();
	
	return job;
	
}

	public Jobs findJobsById(Integer jpid) {
		
	    Jobs jobs=null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		jobs = em.find(Jobs.class, jpid);

		em.getTransaction().commit();

		em.close();
		emf.close();

		return jobs;
	}
    @SuppressWarnings("unchecked")
	public List<Jobs> listJobs(int jpid)
    {
        ArrayList<Jobs> jobs = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        jobs = (ArrayList<Jobs>) em.createQuery("FROM Jobs WHERE jpid=:id").setParameter("id", jpid).getResultList();

        em.getTransaction().commit();

        em.close();
        emf.close();

        return jobs;

    }
	public int deleteJobs(Integer id) {
	    int hasError = 1;

	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
	    EntityManager em = emf.createEntityManager();

	    em.getTransaction().begin();
	    Jobs s=em.find(Jobs.class,id);
	    try {

	        em.remove(s);
	    }catch(Exception e) {
	        e.printStackTrace();
	        hasError = 0;
	    }

	    em.getTransaction().commit();

	    em.close();
	    emf.close();

	    return hasError;
	}
	public boolean updateJobs(Jobs updatedJobs) {
		
		
		boolean status=true;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			em.merge(updatedJobs);

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

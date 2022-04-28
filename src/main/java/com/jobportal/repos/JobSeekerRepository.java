package com.jobportal.repos;


import java.util.ArrayList;
import java.util.List;

import com.jobportal.entities.ApplyJobs;
import com.jobportal.entities.JobSeeker;
import com.jobportal.entities.Jobs;
import com.jobportal.entities.Resume;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JobSeekerRepository {

	public JobSeekerRepository() {
		
	}
	

	@SuppressWarnings("unchecked")
	public List<JobSeeker> JobSeekerlogin2(String email, String password) {

		
		ArrayList<JobSeeker> doesExist = new ArrayList<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();

		doesExist = (ArrayList<JobSeeker>) em.createQuery("FROM JobSeeker WHERE email = :email AND password = :password")
					   .setParameter("email", email)
					   .setParameter("password", password)
					   .getResultList();
					   	

		em.getTransaction().commit();

		em.close();
		emf.close();

		return doesExist;
	}
	public boolean checkapply(int jsid, int jobsid) {

        boolean doesExist = false;


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
        
               em.getTransaction().begin();

                doesExist  = !em.createQuery("FROM ApplyJobs WHERE jsid = :jsid AND jobsid= :jobsid").setParameter("jsid",jsid).setParameter("jobsid",jobsid).getResultList().isEmpty();
    

                em.getTransaction().commit();
        
                emf.close();
                em.close();


                return doesExist;
            }
        
    
	@SuppressWarnings("unchecked")
	public ArrayList<JobSeeker> listJS()
	{
		ArrayList<JobSeeker> seeker = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		seeker = (ArrayList<JobSeeker>) em.createQuery("FROM JobSeeker").getResultList();	
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return seeker;
		
	}
	public boolean JobSeekeResumerid(int jsid) {

		boolean doesExistResume = false;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		doesExistResume = !em.createQuery("FROM Resume WHERE jsid = :jsid ")
					   .setParameter("jsid", jsid)
					   
					   .getResultList()
					   .isEmpty();		

		em.getTransaction().commit();


		em.close();
		emf.close();

		return doesExistResume;
	}

	public boolean addJobSeeker(JobSeeker jobseeker) {
		
		boolean status=true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
			em.persist(jobseeker);
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
	public List<Jobs> findAllJobs() {

		ArrayList<Jobs> jobs = new ArrayList<>();
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				
				jobs = (ArrayList<Jobs>) em.createQuery("FROM Jobs").getResultList();	
				
				em.getTransaction().commit();		
				
				em.close();
				emf.close();
				
				return jobs;

				
			}
	public JobSeeker findJobSeekerByid(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();	
		
		JobSeeker js=em.find(JobSeeker.class,id);
			
		em.close();
		emf.close();
		
		return js;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<ApplyJobs> findAllApplyJobs(Integer jsid) {

		        ArrayList<ApplyJobs> applyjobs = new ArrayList<>();
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				
				applyjobs= (ArrayList<ApplyJobs>) em.createQuery("FROM ApplyJobs WHERE jsid= ?1").setParameter(1,jsid).getResultList();	
				
				
				em.getTransaction().commit();		
				
				em.close();
				emf.close();
				
				return applyjobs ;

				
			}
	
	public boolean updateJobSeeker(JobSeeker updatedJobSeeker) {
		
		boolean status=true;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			em.merge(updatedJobSeeker);

		} catch (Exception e) {
			e.printStackTrace();
			status=false;
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

		return status;
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

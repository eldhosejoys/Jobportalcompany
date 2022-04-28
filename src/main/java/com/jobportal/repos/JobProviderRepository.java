package com.jobportal.repos;

import java.util.ArrayList;
import java.util.List;

import com.jobportal.entities.ApplyJobs;
import com.jobportal.entities.JobProvider;
import com.jobportal.entities.JobSeeker;
import com.jobportal.entities.Jobs;
import com.jobportal.entities.Resume;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JobProviderRepository {

	public JobProviderRepository() {
	
	}
	
	public boolean JobProviderlogin(String email, String password) {

		boolean doesExist = false;


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();	
		em.getTransaction().begin();

		doesExist = !em.createQuery("FROM JobProvider WHERE email = :email AND password = :password")
					   .setParameter("email", email)
					   .setParameter("password", password)
					   .getResultList()
					   .isEmpty();		

		em.getTransaction().commit();

		em.close();
		emf.close();

		return doesExist;
	}
	@SuppressWarnings("unchecked")
	public List<JobProvider> JobProviderlogin2(String email, String password) {

		ArrayList<JobProvider> doesExist = new ArrayList<>();


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();	
		em.getTransaction().begin();

		doesExist = (ArrayList<JobProvider>) em.createQuery("FROM JobProvider WHERE email = :email AND password = :password")
					   .setParameter("email", email)
					   .setParameter("password", password)
					   .getResultList();
					  		

		em.getTransaction().commit();

		em.close();
		emf.close();

		return doesExist;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<JobProvider> listJP()
	{
		ArrayList<JobProvider> provider = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		provider = (ArrayList<JobProvider>) em.createQuery("FROM JobProvider").getResultList();	
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return provider;
		
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
	public boolean addJobProvider(JobProvider jobprovider) {
		
		boolean status=true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
			em.persist(jobprovider);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}		
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return status;
		
	}
	
	public JobProvider findJobProviderById(int id) {
		JobProvider jp=null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();	
		
		jp=  em.find(JobProvider.class,id);
			
		em.close();
		emf.close();
		
		return jp;
		
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

	@SuppressWarnings("unchecked")
	public List<ApplyJobs> appliedjobs2(int jpid,int jid)
	{
		ArrayList<ApplyJobs> jobs = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		jobs = (ArrayList<ApplyJobs>) em.createQuery("FROM ApplyJobs WHERE jpid= :id AND jobsid= :jid")
				.setParameter("id", jpid)
				.setParameter("jid", jid)
				.getResultList();	
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return jobs;
		
	}
	public Jobs findJobsById(Integer jpid) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();	
		
		Jobs j=em.find(Jobs.class,jpid);
			
		em.close();
		emf.close();
		
		return j;
		
	}
	@SuppressWarnings("unchecked")
	public List<ApplyJobs> findAllApplyJobs(Integer jpid) {

		        ArrayList<ApplyJobs> applyjobs = new ArrayList<>();
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				
				applyjobs= (ArrayList<ApplyJobs>) em.createQuery("FROM ApplyJobs WHERE jpid= ?1").setParameter(1,jpid).getResultList();	
				
				
				em.getTransaction().commit();		
				
				em.close();
				emf.close();
				
				return applyjobs ;

				
			}
	public Resume findResumeById(Integer id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();	
		
		Resume j=em.find(Resume.class,id);
			
		em.close();
		emf.close();
		
		return j;
	
}
	public JobSeeker findJobSeekerById(Integer id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();	
		
		JobSeeker j=em.find(JobSeeker.class,id);
			
		em.close();
		emf.close();
		
		return j;
	
}
	
	public boolean updateJobProvider(JobProvider updatedJobProvider) {
		
		boolean status=true;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {
			em.merge(updatedJobProvider);

		} catch (Exception e) {
			e.printStackTrace();
			status=false;
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

		return status;
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
public boolean addJob(JobProvider jobprovider) {
		
		boolean status=true;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		try {
			em.persist(jobprovider);
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}		
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return status;
		
	}
	
	
	public int deleteJobs(Integer id) {
		
		int status=0;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {

			Jobs jobs = em.find(Jobs.class,id);
			em.remove(jobs);
			
		} catch (Exception e) {
			e.printStackTrace();
			status=1;
		}
		
		try {

			ApplyJobs applyjobs = em.find(ApplyJobs.class,id);
			em.remove(applyjobs);
			
		} catch (Exception e) {
			e.printStackTrace();
			status+=1;
		}

		em.getTransaction().commit();

		em.close();
		emf.close();

		return status;
	}
}

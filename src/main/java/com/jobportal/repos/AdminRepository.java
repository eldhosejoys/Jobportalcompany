package com.jobportal.repos;

import java.util.ArrayList;
import java.util.List;

import com.jobportal.entities.JobProvider;
import com.jobportal.entities.JobSeeker;
import com.jobportal.entities.Jobs;
import com.jobportal.entities.Resume;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AdminRepository {

	public AdminRepository() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<JobProvider> findAllJobproviders() {

        ArrayList<JobProvider> jobproviders = new ArrayList<>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		jobproviders= (ArrayList<JobProvider>) em.createQuery("FROM JobProvider").getResultList();	
		
		em.getTransaction().commit();		
		
		em.close();
		emf.close();
		
		return jobproviders;

		
	}
	@SuppressWarnings("unchecked")
	public List<JobSeeker> findAllJobseekers() {

		        ArrayList<JobSeeker> jobseekers = new ArrayList<>();
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				
				jobseekers= (ArrayList<JobSeeker>) em.createQuery("FROM JobSeeker").getResultList();	
				
				em.getTransaction().commit();		
				
				em.close();
				emf.close();
				
				return jobseekers;

				
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
	@SuppressWarnings("unchecked")
	public List<Resume> findAllResume() {

		ArrayList<Resume> resumes = new ArrayList<>();
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				
				resumes = (ArrayList<Resume>) em.createQuery("FROM Resume").getResultList();	
				
				em.getTransaction().commit();		
				
				em.close();
				emf.close();
				
				return resumes;

				
			}
	
	public boolean deleteJobProvider(Integer id) {
		
		boolean status=false;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {

			JobProvider jobprovider = em.find(JobProvider.class,id);
			em.remove(jobprovider);
			
		} catch (Exception e) {
			e.printStackTrace();
			status=true;
		}
		
		try {

			Jobs jobs = em.find(Jobs.class,id);
			em.remove(jobs);
			
		} catch (Exception e) {
			e.printStackTrace();
			status=true;
		}
		em.getTransaction().commit();

		em.close();
		emf.close();

		return status;
	}
	
	public int deleteJobSeeker(Integer id) {
		
		int status=0;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jobportalcompany");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		try {

			JobSeeker jobseeker = em.find(JobSeeker.class,id);
			em.remove(jobseeker);
			
		} catch (Exception e) {
			e.printStackTrace();
			status=1;
		}
		
		try {

			Resume resume = em.find(Resume.class,id);
			em.remove(resume);
			
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

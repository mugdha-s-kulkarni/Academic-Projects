package com.mugdha.project.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.Job;
import com.mugdha.project.pojo.JobSeeker;
import com.mugdha.project.pojo.Profile;

public class JobSeekerDAO extends DAO {

	public JobSeekerDAO() {

	}
	
	public JobSeeker get(String username) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from JobSeeker where username = :username");
			q.setString("username", username);
			JobSeeker emp = (JobSeeker) q.uniqueResult();
			commit();
			return emp;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get jobSeeker " + username, e);
		}
	}
	
	public Profile getProfileByJobSeekerID(int id){
		
		begin();
		Criteria cr = getSession().createCriteria(Profile.class);
		cr.add(Restrictions.eq("profileId", id));
		
        Profile profile = (Profile) cr.uniqueResult();
		commit();
		
		return profile;
	}
	
	public JobSeeker getJobSeeker(String emailId) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from JobSeeker where emailId = :emailId");
			q.setString("emailId", emailId);
			JobSeeker emp = (JobSeeker) q.uniqueResult();
			commit();
			return emp;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get jobseeker " + emailId, e);
		}
	}
	
	public void updateProfile(JobSeeker jobSeeker,Profile profile){
		begin();
		
		jobSeeker.setProfile(profile);
		getSession().saveOrUpdate(jobSeeker);
		commit();
		
	}

	public void updateJobSeeker(JobSeeker jobSeeker){
		begin();
		
		getSession().saveOrUpdate(jobSeeker);
		commit();
		
	}
	public JobSeeker create(String name, String username, String password, String emailId) {
		try {
			begin();

			JobSeeker jobSeeker = new JobSeeker();			
		    			
		    jobSeeker.setName(name);
		    jobSeeker.setEmailId(emailId);
		    jobSeeker.setUsername(username);
		    jobSeeker.setPassword(password);
		    
			getSession().save(jobSeeker);
			commit();

			return jobSeeker;
		} catch (HibernateException e) {
			rollback();
			return null;
		}
	}

	public JobSeeker verifyJobSeeker(String username, String password) {
		try {
			begin();
			Query q = getSession().createQuery("from JobSeeker where username = :username and password= :password");
			q.setString("username", username);
			q.setString("password", password);
			JobSeeker j = (JobSeeker) q.uniqueResult();
			System.out.println("************");
			System.out.println(j.getUsername());
			commit();
			return j;
		} catch (HibernateException e) {
			rollback();
		}
		return null;


	}
	public JobSeeker findJobSeeker(int id) throws Exception{
    	
		 begin();
    	     	
    	 Query q = getSession().createQuery("from JobSeeker where jobSeekerId = :jobSeekerId");
         q.setInteger("jobSeekerId", id);
        
         JobSeeker j  = (JobSeeker) q.uniqueResult();
         commit();
      
		 return j;
    	
    }
}

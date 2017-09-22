package com.mugdha.project.DAO;

import org.hibernate.Criteria;

import com.mugdha.project.pojo.Job;
import com.mugdha.project.pojo.JobSeeker;
import org.hibernate.criterion.Restrictions;


public class JobSeeker_JobDAO extends DAO {

	 public void applyToJob(int jobSeekerId, int jobId){
	    	begin();
	    	
	    	Criteria cr = getSession().createCriteria(Job.class);
			cr.add(Restrictions.eq("jobId", jobId));
		    Job job  = (Job) cr.uniqueResult();
		    
		    Criteria cr1 = getSession().createCriteria(JobSeeker.class);
			cr1.add(Restrictions.eq("jobSeekerId", jobSeekerId));
		    JobSeeker jobSeeker  = (JobSeeker) cr1.uniqueResult();
		    
		    jobSeeker.getJobsApplied().add(job);
		    
		    getSession().saveOrUpdate(jobSeeker);
	    	
	    	commit();
	    }
	 
	

}

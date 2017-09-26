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

public class JobDAO extends DAO {


	public void update(Job job){
	   begin();
	   getSession().saveOrUpdate(job);
	   commit();	   
	}
	
	
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
    
	public Job create(String category, String title, int vacancies, String location, String description,String requirements, int salary,String status,
			Employer employer) throws Exception {
		try {
			begin();
			Job job = new Job(category, title, vacancies, location, description,requirements, salary, status, employer);
			getSession().save(job);
			commit();
			return job;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating job: " + e.getMessage());
		}
	}

	public void delete(Job job) throws Exception {
		try {
			begin();
			getSession().delete(job);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete job", e);
		}
	}

	public List<Job> getJobList(int emp_id) throws Exception {
		begin();

		Query q = getSession().createQuery("from Job where employer_id = :emp_id");
		q.setInteger("emp_id", emp_id);

		@SuppressWarnings("unchecked")
		List<Job> jobList = q.list();
		commit();

		return jobList;

	}

	public List<Job> getJobListByLocation(String location) throws Exception {
		begin();

		Criteria cr = getSession().createCriteria(Job.class);
		cr.add(Restrictions.ilike("jobLocation", location, MatchMode.ANYWHERE));
		cr.add(Restrictions.eq("status", "Open"));

		@SuppressWarnings("unchecked")
		List<Job> result = cr.list();
		commit();
		return result;

	}

	public List<Job> getJobListByTitle(String title) throws Exception {
		begin();

		Criteria cr = getSession().createCriteria(Job.class);
		cr.add(Restrictions.ilike("title", title, MatchMode.ANYWHERE));

		@SuppressWarnings("unchecked")
		List<Job> result = cr.list();
		commit();

		return result;

	}

	public List<Job> getJobListByCategory(String category) throws Exception {
		begin();

		Criteria cr = getSession().createCriteria(Job.class);
		cr.add(Restrictions.ilike("category", category, MatchMode.ANYWHERE));

		@SuppressWarnings("unchecked")
		List<Job> result = cr.list();
		commit();

		return result;

	}

	public List<Job> getJobListByCompanyId(int companyId) throws Exception {
		begin();

		Criteria cr = getSession().createCriteria(Job.class);
		cr.add(Restrictions.eq("employer", companyId));
        
		@SuppressWarnings("unchecked")
		List<Job> result = cr.list();
		commit();

		return result;

	}
	
	public Job getJobByJobId(int jobId) throws Exception {
		begin();

		Criteria cr = getSession().createCriteria(Job.class);
		cr.add(Restrictions.eq("jobId", jobId));

	    Job job  = (Job) cr.uniqueResult();
		commit();

		return job;

	}



}
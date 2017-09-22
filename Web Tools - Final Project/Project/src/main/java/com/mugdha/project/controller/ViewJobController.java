package com.mugdha.project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mugdha.project.DAO.EmployerDAO;
import com.mugdha.project.DAO.JobDAO;
import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.Job;
import com.mugdha.project.pojo.JobSeeker;

@Controller
public class ViewJobController {
	
	@Autowired
	@Qualifier("employerDAO")
	EmployerDAO emp;

	@RequestMapping(value = "viewJob.htm")
	protected String viewJob(HttpServletRequest hsr) throws Exception {

		HttpSession session = hsr.getSession();

		String username = (String) session.getAttribute("username");
		
		Employer e = emp.get(username);
		List<Job> jobList = new ArrayList<Job>();

		Iterator<Job> jobIterator = e.getJobs().iterator();
		while (jobIterator.hasNext()) {
			Job job = (Job) jobIterator.next();
			jobList.add(job);
		}

		session.setAttribute("jobList", jobList);
		hsr.setAttribute("jobList", jobList);

		return "viewJob";
	}
	
	@RequestMapping(value = "viewApplications.htm")
	protected String viewApplications(HttpServletRequest hsr) throws Exception {

		int jobId =  Integer.parseInt(hsr.getParameter("jobId"));
		JobDAO jobDAO = new JobDAO();
		Job job = jobDAO.getJobByJobId(jobId);
		
		
		List<JobSeeker> jobSeekerList = new ArrayList<JobSeeker>();

		Iterator<JobSeeker> jobSeekerIterator = job.getJobSeekerList().iterator();

		while (jobSeekerIterator.hasNext()) {
			JobSeeker jobSeeker = (JobSeeker) jobSeekerIterator.next();
			jobSeekerList.add(jobSeeker);
		}

		System.out.println(jobSeekerList.size());
		hsr.setAttribute("jobSeekerList", jobSeekerList);
		hsr.setAttribute("jobId",jobId);
		hsr.setAttribute("job", job);

		return "viewApplications";
	}

	

}

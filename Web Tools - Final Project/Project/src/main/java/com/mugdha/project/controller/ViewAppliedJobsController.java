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
import com.mugdha.project.DAO.JobSeekerDAO;
import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.Job;
import com.mugdha.project.pojo.JobSeeker;

@Controller
public class ViewAppliedJobsController {

	@Autowired
	@Qualifier("jobSeekerDAO")
	JobSeekerDAO jobSeekerDAO;
	
	@RequestMapping(value = "viewAppliedJobs.htm")
	protected String viewJob(HttpServletRequest hsr) throws Exception {

		HttpSession session = hsr.getSession();

		int id = Integer.parseInt( hsr.getParameter("jobSeekerId"));
		System.out.println("jobseekerid--------------"+id);
		JobSeeker j = jobSeekerDAO.findJobSeeker(id);
		List<Job> jobList = new ArrayList<Job>();

		Iterator<Job> jobIterator = j.getJobsApplied().iterator();

		while (jobIterator.hasNext()) {
			Job job = (Job) jobIterator.next();
			jobList.add(job);
		}

		session.setAttribute("jobList", jobList);
		hsr.setAttribute("jobList", jobList);

		return "viewAppliedJobs";
	}

}

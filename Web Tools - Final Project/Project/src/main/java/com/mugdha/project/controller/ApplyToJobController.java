package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mugdha.project.DAO.JobDAO;
import com.mugdha.project.DAO.JobSeekerDAO;
import com.mugdha.project.DAO.JobSeeker_JobDAO;
import com.mugdha.project.pojo.Job;
import com.mugdha.project.pojo.JobSeeker;
import com.mugdha.project.pojo.Profile;

@Controller
public class ApplyToJobController {

	@Autowired
	JobSeeker_JobDAO dao;

	@Autowired
	@Qualifier("jobSeekerDAO")
	JobSeekerDAO jobSeekerDAO;

	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;

	@RequestMapping(value = "applyToJob.htm", method = RequestMethod.POST)
	protected String applyToJob(HttpServletRequest hsr) throws Exception {

		try {
			
		
			HttpSession session = hsr.getSession();
			int jobId = Integer.parseInt(hsr.getParameter("jobId"));
			JobSeeker jobSeeker = (JobSeeker) session.getAttribute("jobSeeker");	
			
			Profile profile = jobSeeker.getProfile();			
			hsr.setAttribute("profile", profile);
		    System.out.println(profile.getProfileId());
		    
			JobSeeker_JobDAO dao = new JobSeeker_JobDAO();
			dao.applyToJob(jobSeeker.getJobSeekerId(), jobId);
           
			return "addedJobSeeker";
		} catch (Exception e) {
			
			hsr.setAttribute("err", 1);
			return "errorPage";
		}

		
	}

	@RequestMapping(value = "applyToJob.htm", method = RequestMethod.GET)
	protected String doSubmit(HttpServletRequest hsr) throws Exception {

		try {	
		
	
		String stringId = hsr.getParameter("v");
		int id = Integer.parseInt(hsr.getParameter("v"));

		Job job = jobDAO.getJobByJobId(id);
		System.out.println("Job Id-----" + id);
		hsr.setAttribute("jobId", stringId);
		hsr.setAttribute("job", job);

		return "applyToJob";

		} catch (Exception e) {
			
			return "errorPage";
		}
	}

}

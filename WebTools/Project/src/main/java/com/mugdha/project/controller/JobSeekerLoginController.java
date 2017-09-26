package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mugdha.project.DAO.JobSeekerDAO;
import com.mugdha.project.pojo.JobSeeker;

@Controller
public class JobSeekerLoginController {

	@Autowired
	@Qualifier("jobSeekerDAO")
	JobSeekerDAO jobSeekerDAO;

	@RequestMapping(value = "loginJobSeeker.htm", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) {

		try {
			
		
		String uname = hsr.getParameter("username1");
		String pwd = hsr.getParameter("password1");
		System.out.println(uname + " " + pwd);

		JobSeeker jobSeeker = jobSeekerDAO.verifyJobSeeker(uname, pwd);

		if (jobSeeker == null) {
			hsr.setAttribute("err", 5);
			return "errorPage";
		} else {

			HttpSession session = hsr.getSession();

			session.setAttribute("jobSeeker", jobSeeker);
			session.setAttribute("jobSeekerId", jobSeeker.getJobSeekerId());
			hsr.setAttribute("username", jobSeeker.getName());
			return "jobSeekerWorkArea";
		}
		} catch (Exception e) {
			hsr.setAttribute("err", 5);
			return "errorPage";
		}
	}

	@RequestMapping(value = "loginJobSeeker.htm", method = RequestMethod.GET)
	public String showForm(HttpServletRequest hsr, HttpServletResponse hsr1) {

		return "loginJobSeeker";
	}

	@RequestMapping(value = "redirectJobSeeker.htm", method = RequestMethod.GET)
	public String showRedirectedForm(HttpServletRequest hsr, HttpServletResponse hsr1) {

		return "jobSeekerWorkArea";
	}

}

package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mugdha.project.DAO.EmployerDAO;
import com.mugdha.project.DAO.JobSeekerDAO;
import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.JobSeeker;

@Controller
public class JobSeekerSignUpController {

	@Autowired
	@Qualifier("jobSeekerValidator")
	JobSeekerValidator jobValidator;

	@Autowired
	@Qualifier("jobSeekerDAO")
	JobSeekerDAO jobSeekerDAO;
	
	@Autowired
	@Qualifier("employerDAO")
	EmployerDAO employerDAO;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(jobValidator);
	}

	@RequestMapping(value = "signupJobSeeker.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("jobSeeker") JobSeeker jobSeeker, BindingResult result,
			HttpServletRequest hsr) throws Exception {

		jobValidator.validate(jobSeeker, result);
		if (result.hasErrors()) {
			return "errorPage";

		}
		try {			
			
			Employer emp = employerDAO.get(jobSeeker.getUsername());
			JobSeeker j = jobSeekerDAO.get(jobSeeker.getUsername());
			
			Employer emp1 = employerDAO.getEmp(jobSeeker.getEmailId());
			JobSeeker j1 = jobSeekerDAO.getJobSeeker(jobSeeker.getEmailId());
			
			if (emp == null && j == null && emp1 == null && j1 == null) {

				jobSeekerDAO.create(jobSeeker.getName(), jobSeeker.getUsername(), jobSeeker.getPassword(),
						jobSeeker.getEmailId());

				return "addedJobSeeker";
			} else {
				hsr.setAttribute("err", 4);
				return "errorPage";
			}
			

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return "signupJobSeeker";

		}
	}

	@RequestMapping(value = "signupJobSeeker.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("jobSeeker") JobSeeker jobSeeker, BindingResult result) {

		return "signupJobSeeker";
	}
}

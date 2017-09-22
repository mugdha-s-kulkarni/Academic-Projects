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
public class SignUpController {

	@Autowired
	@Qualifier("employerValidator")
	EmployerValidator validator;

	@Autowired
	@Qualifier("employerDAO")
	EmployerDAO employerDAO;

	@Autowired
	@Qualifier("jobSeekerDAO")
	JobSeekerDAO jobSeekerDAO;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "signup.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("employer") Employer employer, BindingResult result,
			HttpServletRequest hsr) throws Exception {
		validator.validate(employer, result);

		if (result.hasErrors()) {

			return "errorPage";
		}
		try {

			Employer emp = employerDAO.get(employer.getUsername());
			JobSeeker j = jobSeekerDAO.get(employer.getUsername());
			
			Employer emp1 = employerDAO.getEmp(employer.getEmailId());
			JobSeeker j1 = jobSeekerDAO.getJobSeeker(employer.getEmailId());
			
			if (emp == null && j == null && emp1 == null && j1 == null) {

				employerDAO.create(employer.getCompanyName(), employer.getCity(), employer.getUsername(),
						employer.getPassword(), employer.getEmailId());

				return "addedEmployer";
			} else {
				hsr.setAttribute("err", 4);
				return "errorPage";
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return "signup";
		}

	}

	@RequestMapping(value = "signup.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("employer") Employer employer, BindingResult result) {

		return "signup";
	}

}

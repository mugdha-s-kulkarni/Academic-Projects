package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mugdha.project.DAO.EmployerDAO;
import com.mugdha.project.DAO.JobDAO;
import com.mugdha.project.DAO.JobSeekerDAO;
import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.Job;
import com.mugdha.project.pojo.JobSeeker;
import com.mugdha.project.pojo.Profile;
import java.util.List;

@Controller
public class SearchJobController {
	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobDAO;

	@Autowired
	@Qualifier("jobSeekerDAO")
	JobSeekerDAO jobSeekerDAO;

	@RequestMapping(value = "searchJob.htm", method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest hsr) throws Exception {

		try {

			String val = hsr.getParameter("searchBy");
			String key = hsr.getParameter("keyword");

			if (!key.matches("[a-zA-Z ]+")) {
				return "errorPage";
			}

			List<Job> jobs = null;
			HttpSession session = hsr.getSession();

			JobSeeker jobSeeker = (JobSeeker) session.getAttribute("jobSeeker");

			if (val.equalsIgnoreCase("locationSearch")) {
				jobs = jobDAO.getJobListByLocation(key);

			} else if (val.equalsIgnoreCase("titleSearch")) {
				jobs = jobDAO.getJobListByTitle(key);

			} else if (val.equalsIgnoreCase("companySearch")) {
				EmployerDAO empDAO = new EmployerDAO();
				Employer emp = empDAO.getEmployerByCompany(key);
				int id = emp.getEmployerID();
				jobs = jobDAO.getJobListByCompanyId(id);

			} else if (val.equalsIgnoreCase("categorySearch")) {
				jobs = jobDAO.getJobListByCategory(key);

			}

			session.setAttribute("jobNotApplied", jobs);

			return "jobSearchResult";
		} catch (Exception e) {

			return "errorPage";

		}

	}

	@RequestMapping(value = "searchJob.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("profile") Profile p, BindingResult result) {

		return "searchJob";
	}

}
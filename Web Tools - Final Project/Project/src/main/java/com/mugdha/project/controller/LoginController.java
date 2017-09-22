package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mugdha.project.DAO.EmployerDAO;
import com.mugdha.project.pojo.Employer;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("employerDAO")
	EmployerDAO employerDAO;

	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) {

		try {

			String uname = hsr.getParameter("username");
			String pwd = hsr.getParameter("password");

			Employer c = employerDAO.verifyEmployer(uname, pwd);

			HttpSession session = hsr.getSession();

			session.setAttribute("employerId", c.getEmployerID());
			session.setAttribute("username", c.getUsername());
			hsr.setAttribute("username", c.getUsername());

			return "employerWorkArea";
		} catch (Exception e) {
			hsr.setAttribute("err", 5);
			return "errorPage";
		}

	}

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String showForm(HttpServletRequest hsr, HttpServletResponse hsr1) {

		return "login";
	}

	@RequestMapping(value = "redirectEmployerHome.htm", method = RequestMethod.GET)
	public String redirectHome(HttpServletRequest hsr, HttpServletResponse hsr1) {

		String username = (String) hsr.getAttribute("username");
		hsr.setAttribute("username", username);
		return "employerWorkArea";
	}

	// Employer Logout
	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	public String Logout(HttpServletRequest hsr, HttpServletResponse hsr1) {
		HttpSession session = hsr.getSession();
		session.invalidate();
		return "index";
	}

}

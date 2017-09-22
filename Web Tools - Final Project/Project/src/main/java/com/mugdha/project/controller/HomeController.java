package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	@RequestMapping(value = "home.htm", method = RequestMethod.GET)
	public String home(HttpServletRequest hsr, HttpServletResponse hsr1) {

		HttpSession session = hsr.getSession();
		System.out.println(session.getAttribute("employerId"));
	    hsr.setAttribute("employerId", session.getAttribute("employerId"));
		return "index";
	}
	
}

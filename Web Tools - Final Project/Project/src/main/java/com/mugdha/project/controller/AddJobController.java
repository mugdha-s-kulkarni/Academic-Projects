package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.mugdha.project.DAO.JobDAO;
import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.Job;

@Controller
public class AddJobController {

	@Autowired
	@Qualifier("jobValidator")
	JobValidator jobValidator;
	
	@Autowired
	@Qualifier("employerDAO")
	EmployerDAO emp;
	
	@Autowired
	@Qualifier("jobDAO")
	JobDAO jobs;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(jobValidator);
	}
	
	@RequestMapping(value = "addJob.htm",method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("job")Job job,BindingResult result, HttpServletRequest hsr) throws Exception{

		jobValidator.validate(job, result);
		if(result.hasErrors())
		{
			return "errorPage";
		}
		HttpSession session = hsr.getSession();
    	
        String category = job.getCategory();   
        String title = job.getTitle();   
        int vacancies = job.getVacancies();
        String location = job.getJobLocation();
        String description = job.getJobDescription();
        String requirements = job.getJobRequirements();
        int salary = job.getSalary();
        String status = job.getStatus();
      
        try {
            
            Employer e = (Employer)emp.get((String)session.getAttribute("username"));            
            Job j = jobs.create(category,title,vacancies,location,description,requirements,salary,status,e);                        
            e.addJob(j);       
            hsr.setAttribute("employerId", e.getEmployerID());
    		hsr.setAttribute("username", e.getUsername());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return "addedJob";
    }
    
	@RequestMapping(value = "addJob.htm",method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("job")Job job, BindingResult result, HttpServletRequest hsr) { 
   
		hsr.setAttribute("username", hsr.getAttribute("username"));
        return "addJob"; 
    } 
	
	@RequestMapping(value = "changeStatus.htm",method=RequestMethod.GET)
    public String changeStatus(HttpServletRequest hsr) throws NumberFormatException, Exception { 
   
		
	    int jobId = Integer.parseInt(hsr.getParameter("jobId"));
	    System.out.println(jobId);
	    Job job = jobs.getJobByJobId(jobId);
		job.setStatus("Closed");
		jobs.update(job);
        return "viewApplications"; 
    } 
}

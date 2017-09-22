package com.mugdha.project.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mugdha.project.pojo.Job;

import org.springframework.validation.ValidationUtils;

public class JobValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Job.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Job job = (Job) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "error.invalid.job", "Category Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.job", "Title Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vacancies", "error.invalid.job", "Vacancies Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobLocation", "error.invalid.job", "Location Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription", "error.invalid.job", "Description Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobRequirements", "error.invalid.jobRequirements", "Job Requirements Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "error.invalid.salary", "Salary Required");
        
        if(!job.getTitle().matches("[a-zA-Z ]+")){
        	errors.rejectValue("companyName","Invalid Title");
        }
        if(!job.getJobLocation().matches("[a-zA-Z ]+")){
        	errors.rejectValue("password","Invalid City Name");
        }
        if(!job.getJobDescription().matches("[a-zA-Z0-9 ,.]+")){
        	errors.rejectValue("jobDescription","Invalid Job Description");
        }
        if(!job.getJobRequirements().matches("[a-zA-Z0-9 ,.]+")){
        	errors.rejectValue("jobRequirements","Invalid Job Requirements");
        }
        if(job.getVacancies() < 0){
        	errors.rejectValue("vacancies","Invalid Vacancy Number");
        }
        String v = Integer.toString(job.getVacancies());
        if(!v.matches("[0-9]+")){
        	errors.rejectValue("vacancies","Invalid Vacancies");
        }
        if(job.getSalary() < 0){
        	errors.rejectValue("salary","Invalid Salary");
        }
        String s = Integer.toString(job.getSalary());
        if(!s.matches("[0-9]+")){
        	errors.rejectValue("salary","Invalid Salary");
        }
        
    }
}
package com.mugdha.project.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.JobSeeker;

import org.springframework.validation.ValidationUtils;

public class JobSeekerValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(JobSeeker.class);
    }

    public void validate(Object obj, Errors errors)
    {
        JobSeeker j = (JobSeeker) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.jobSeeker", "Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.jobSeeker", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.emailId", "Email Required");
        
        if(!j.getName().matches("[a-zA-Z ]+")){
        	errors.rejectValue("name","Invalid Company Name");
        }
        if(!j.getUsername().matches("[a-zA-Z0-9]+")){
        	errors.rejectValue("username","Invalid User Name");
        }
        if(!j.getPassword().matches("[a-zA-Z]+")){
        	errors.rejectValue("password","Invalid City Name");
        }
        if(!j.getEmailId().matches("[a-zA-Z ]+@[a-zA-Z]+.[a-z]+")){
        	errors.rejectValue("emailId","Invalid Email Address");
        }
    }
}

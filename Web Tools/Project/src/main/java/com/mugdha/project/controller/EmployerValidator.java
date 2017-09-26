package com.mugdha.project.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mugdha.project.pojo.Employer;

import org.springframework.validation.ValidationUtils;

public class EmployerValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Employer.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Employer e = (Employer) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "error.invalid.employer", "Company Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.employer", "City Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.employer", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.emailId", "Email Required");
        
        
        if(!e.getCompanyName().matches("[a-zA-Z ]+")){
        	errors.rejectValue("companyName","Invalid Company Name");
        }
        if(!e.getCity().matches("[a-zA-Z ]+")){
        	errors.rejectValue("city","Invalid City Name");
        }
        if(!e.getUsername().matches("[a-zA-Z0-9]+")){
        	errors.rejectValue("username","Invalid User Name");
        }
        if(!e.getPassword().matches("[a-zA-Z]+")){
        	errors.rejectValue("password","Invalid City Name");
        }
        if(!e.getEmailId().matches("[a-zA-Z ]+@[a-zA-Z]+.[a-z]+")){
        	errors.rejectValue("emailId","Invalid Email Address");
        }
    }
}

package com.mugdha.project.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mugdha.project.pojo.Employer;
import com.mugdha.project.pojo.Profile;

import org.springframework.validation.ValidationUtils;

public class ProfileValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Profile.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Profile p = (Profile) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.firstName", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.lastName", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.country", "Country Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.state", "State name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "error.invalid.zipcode", "ZipCode Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNo", "error.invalid.phoneNo", "Phone No Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.invalid.name", "Resume name Required");
        
        if(!p.getFirstName().matches("[a-zA-Z]+")){
        	errors.rejectValue("firstName","Invalid First Name");
        }
        if(!p.getLastName().matches("[a-zA-Z]+")){
        	errors.rejectValue("firstName","Invalid First Name");
        }
        if(!p.getCountry().matches("[a-zA-Z ]+")){
        	errors.rejectValue("country","Invalid Country");
        }
        if(!p.getState().matches("[a-zA-Z ]+")){
        	errors.rejectValue("state","Invalid State");
        }
        if(!p.getName().matches("[a-zA-Z0-9 ]+")){
        	errors.rejectValue("name","Invalid ResumeName");
        }
        if(p.getZipCode() < 0){
        	errors.rejectValue("zipCode	","Invalid ZipCode");
        }
        String zip = Integer.toString(p.getZipCode());
        if(!zip.matches("[0-9]+")){
        	errors.rejectValue("zipCode","Invalid ZipCode");
        }
        
        if(!p.getPhoneNo().matches("[0-9]{10}")){
        	errors.rejectValue("country","Invalid PhoneNo");
        }
      
    }
}

package com.mugdha.project.DAO;

import java.io.InputStream;
import java.sql.Blob;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.mugdha.project.pojo.Job;
import com.mugdha.project.pojo.JobSeeker;
import com.mugdha.project.pojo.Profile;

public class ProfileDAO extends DAO{

	public ProfileDAO(){	
		
	}
	
	
	public void updateProfile(Profile profile){
		begin();
		getSession().saveOrUpdate(profile);
		commit();
		
	}
	
	public Profile getProfileByProfileId(int profileId) throws Exception {
		begin();

		Criteria cr = getSession().createCriteria(Profile.class);
		cr.add(Restrictions.eq("profileId", profileId));

	        Profile profile  = (Profile) cr.uniqueResult();
		commit();

		return profile;

	}
	
	public Blob createBlob(InputStream inputStream, long l){
		
		Blob blob = Hibernate.getLobCreator(getSession()).createBlob(inputStream, l);
		return blob;
		
	}
	
	public Profile create(String firstName, String lastName, String country, String state,int zipCode,String eduLevel,String workAuth,String phoneNo,String prevEmployer,String jobTitle,String prevWorkCountry,String expYears, JobSeeker j) {
		try {
			
			begin();
			Profile profile = new Profile();	
			
		    profile.setFirstName(firstName);
		    profile.setLastName(lastName);
		    profile.setCountry(prevWorkCountry);
		    profile.setState(state);
		    profile.setZipCode(zipCode);
		    profile.setEduLevel(eduLevel);
		    profile.setWorkAuth(workAuth);
		    profile.setPhoneNo(phoneNo);
		    profile.setPrevEmployer(prevEmployer);
		    profile.setJobTitle(jobTitle);
		    profile.setPrevWorkCountry(prevWorkCountry);
		    profile.setExpYears(expYears);
		    profile.setJobSeeker(j);
		    
		    
			getSession().save(profile);
			commit();

		   return profile ;
		} catch (HibernateException e) {
			rollback();
			return null;
		}
	}
}

package com.mugdha.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.mugdha.project.DAO.JobSeekerDAO;
import com.mugdha.project.DAO.ProfileDAO;
import com.mugdha.project.pojo.Profile;
import com.mugdha.project.pojo.JobSeeker;

@Controller
public class SetupProfileController {
	
	@Autowired
	@Qualifier("profileValidator")
	ProfileValidator profileValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(profileValidator);
	}
	
	@Autowired
	@Qualifier("jobSeekerDAO")
	JobSeekerDAO jobSeekerDAO;
	
	@Autowired
	@Qualifier("profileDAO")
	ProfileDAO profileDAO;

	@RequestMapping(value = "setupProfile.htm", method = RequestMethod.POST)
	protected String setUpProfile(@ModelAttribute("profile") Profile p,
			@RequestParam("file") MultipartFile file, HttpServletRequest hsr, BindingResult result) throws Exception {
		try {
			profileValidator.validate(p, result);
			
			if (result.hasErrors()) {
				return "errorPage";
			}

			HttpSession session = hsr.getSession();
			JobSeeker j = (JobSeeker) session.getAttribute("jobSeeker");
			int id = j.getJobSeekerId();
			JobSeeker jobSeeker = jobSeekerDAO.findJobSeeker(id);
			
			Profile profile = profileDAO.create(p.getFirstName(), p.getLastName(), p.getCountry(), p.getState(),
					p.getZipCode(), p.getEduLevel(), p.getWorkAuth(), p.getPhoneNo(), p.getPrevEmployer(),
					p.getJobTitle(), p.getPrevWorkCountry(), p.getExpYears(), jobSeeker);

			byte[] bytes = IOUtils.toByteArray(file.getInputStream());
			long l = bytes.length;
			Blob blob = profileDAO.createBlob(file.getInputStream(), l);

			profile.setFileName(file.getOriginalFilename());
			profile.setName(file.getName());
			profile.setContent(blob);
			profile.setContentType(file.getContentType());

			jobSeeker.setProfile(profile);
			jobSeekerDAO.updateProfile(jobSeeker,profile);
		    session.setAttribute("profileId", profile.getProfileId());
		    
		    hsr.setAttribute("jobSeekerId", id);
            
			return "addedProfile";

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return "setupProfile";
		}

	}

	@RequestMapping(value = "setupProfile.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("profile") Profile p, BindingResult result, HttpServletRequest hsr) {
        
		return "setupProfile";
	}

	@RequestMapping(value = "download.htm")
	public String viewProfile(HttpServletRequest hsr, HttpServletResponse response) throws Exception {

		int id = Integer.parseInt(hsr.getParameter("profileId"));
		ProfileDAO profileDao = new ProfileDAO();
		Profile profile = profileDao.getProfileByProfileId(id);
		try {
			hsr.setAttribute("profile", profile);
			response.setHeader("Content-Disposition", "inline;filename=\"" + profile.getFileName() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(profile.getContentType());
			IOUtils.copy(profile.getContent().getBinaryStream(), out);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	

	@RequestMapping(value = "viewProfile.htm", method = RequestMethod.GET)
	public String download(HttpServletRequest hsr, HttpServletResponse response) throws Exception {

		try {
			HttpSession session = hsr.getSession();
			JobSeeker jobSeeker = (JobSeeker) session.getAttribute("jobSeeker");
			int id = jobSeeker.getJobSeekerId();
			
			Profile profile = jobSeeker.getProfile();			
			hsr.setAttribute("profile", profile);
			//System.out.println("ProfileId----"+ profile.getProfileId());
			return "viewProfile";
										
			} catch (Exception e) {
		
			hsr.setAttribute("err", 1);
			return "errorPage";
			}
		
	}
}

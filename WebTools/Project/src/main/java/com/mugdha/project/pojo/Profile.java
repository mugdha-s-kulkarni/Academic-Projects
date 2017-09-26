package com.mugdha.project.pojo;

import java.io.File;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "profile")
public class Profile {
	
	public Profile(){
		
	}
	@Id
	@GenericGenerator(name="generator", strategy="foreign", parameters = @Parameter(name="property", value="jobSeeker"))
	@GeneratedValue(generator = "generator")
	@Column(name = "jobSeekerId", unique = true, nullable = false)
	int profileId;

	@Column(name = "firstName")
	String firstName;
	@Column(name = "lastName")
	String lastName;
	@Column(name = "country")
	String country;
	@Column(name = "state")
	String state;
	@Column(name = "zipcode")
	int zipCode;
	@Column(name = "eduLevel")
	String eduLevel;
	@Column(name = "workAuth")
	String workAuth;
	@Column(name = "phoneNo")
	String phoneNo;
	@Column(name = "prevEmployer")
	String prevEmployer;
	@Column(name = "jobTitle")
	String jobTitle;
	@Column(name = "prevWorkCountry")
	String prevWorkCountry;
	@Column(name = "expYears")
	String expYears;
	
	@Column(name="name")
	private String name;
	
	@Column(name="fileName")
	private String fileName;

	
	@Column(name="content")
	@Lob
	private Blob content;
	
	@Column(name="content_type")
	private String contentType;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	JobSeeker jobSeeker;

	public int getProfileId() {
		return profileId;
	}

	public void setProfile_id(int profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getEduLevel() {
		return eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	public String getWorkAuth() {
		return workAuth;
	}

	public void setWorkAuth(String workAuth) {
		this.workAuth = workAuth;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPrevEmployer() {
		return prevEmployer;
	}

	public void setPrevEmployer(String prevEmployer) {
		this.prevEmployer = prevEmployer;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPrevWorkCountry() {
		return prevWorkCountry;
	}

	public void setPrevWorkCountry(String prevWorkCountry) {
		this.prevWorkCountry = prevWorkCountry;
	}

	public String getExpYears() {
		return expYears;
	}

	public void setExpYears(String expYears) {
		this.expYears = expYears;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

}

package com.mugdha.project.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "jobId", unique = true, nullable = false)
	int jobId;

	@Column(name = "category")
	String category;
	@Column(name = "title")
	String title;
	@Column(name = "vacancies")
	int vacancies;
	@Column(name = "jobLocation")
	String jobLocation;
	@Column(name = "jobDescription")
	String jobDescription;
	@Column(name = "salary")
	int salary;
	@Column(name = "status")
	String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="jobRequirements")
	String jobRequirements;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "companyName", nullable = false)
	private Employer employer;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "jobsApplied")
	private Set<JobSeeker> jobSeekerList = new HashSet<JobSeeker>();

	

	public Job(String category, String title, int vacancies, String location, String description,String requirements, int salary, String status,
			Employer employer) {

		this.category = category;
		this.title = title;
		this.vacancies = vacancies;
		this.jobLocation = location;
		this.jobDescription = description;
		this.jobRequirements = requirements;
		this.salary = salary;
		this.status = status;
		this.employer = employer;
	}

	Job() {
		this.jobSeekerList = new HashSet<JobSeeker>();
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setUser(Employer employer) {
		this.employer = employer;
	}

	public String getJobRequirements() {
		return jobRequirements;
	}

	public void setJobRequirements(String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}

	public Set<JobSeeker> getJobSeekerList() {
		return jobSeekerList;
	}

	public void setJobSeekerList(Set<JobSeeker> jobSeekerList) {
		this.jobSeekerList = jobSeekerList;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
}

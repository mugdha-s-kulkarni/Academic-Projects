package com.mugdha.project.pojo;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "employer")
@PrimaryKeyJoinColumn(name = "personId")

public class Employer extends Person {

	private static int count = 1;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employerId", unique = true)
	int employerId;

	@Column(name = "companyName")
	String companyName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employer")
	private Set<Job> jobs = new HashSet<Job>();

	public Employer() {
		employerId = count;
		count++;
		this.jobs = new HashSet<Job>();
	}

	public int getEmployerID() {
		return employerId;
	}

	public void setEmployerID(int employerId) {
		this.employerId = employerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
	
	public void addJob(Job job) {
        getJobs().add(job);
    }

}

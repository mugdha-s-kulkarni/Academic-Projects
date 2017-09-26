package com.mugdha.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "job_seeker")
@PrimaryKeyJoinColumn(name = "personId")

public class JobSeeker extends Person {

	private static int count = 1;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobSeekerId", unique = true)
	private int jobSeekerId;

	@Column(name = "name")
	private String name;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "jobSeeker", cascade = CascadeType.ALL)
	private Profile profile;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "jobSeeker_job", joinColumns = {
			@JoinColumn(name = "jobSeekerId", nullable = false, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "jobId", nullable = false, updatable = true) })
	private Set<Job> jobsApplied = new HashSet<Job>();

	public Set<Job> getJobsApplied() {
		return jobsApplied;
	}

	public void setJobsApplied(Set<Job> jobsApplied) {
		this.jobsApplied = jobsApplied;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public JobSeeker() {
		jobSeekerId = count;
		count++;
		this.jobsApplied = new HashSet<Job>();

	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.mugdha.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="person")
@Inheritance(strategy = InheritanceType.JOINED) // table for subclass

public class Person {

	@Id
	@GeneratedValue
	@Column(name = "personId", unique = true, nullable = false)
	private int personId;

	@Column(name = "city")
	String city;

	@Column(name = "username",unique = true)
	String username;

	@Column(name = "password")
	String password;

	@Column(name = "emailId",unique = true)
	String emailId;

	public Person() {

	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonID(int personId) {
		this.personId = personId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

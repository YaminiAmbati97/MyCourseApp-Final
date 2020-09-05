package com.xyz.app.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xyz.app.entities.Student;
import com.xyz.app.entities.Subject;

public class StudentResponse {

	private long id;

	@JsonProperty("first_name")
	private String firstName;

	private String lastName;

	private String email;
	
	private String street;

	private String city;
	
	private List<SubjectResponse> learningSubjects;
	
	public StudentResponse (Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();
		
		if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}
	}

	public StudentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentResponse(long id, String firstName, String lastName, String email, String street, String city,
			List<SubjectResponse> learningSubjects) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.learningSubjects = learningSubjects;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<SubjectResponse> getLearningSubjects() {
		return learningSubjects;
	}

	public void setLearningSubjects(List<SubjectResponse> learningSubjects) {
		this.learningSubjects = learningSubjects;
	}

	@Override
	public String toString() {
		return "StudentResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", street=" + street + ", city=" + city + ", learningSubjects=" + learningSubjects + "]";
	}
	

}

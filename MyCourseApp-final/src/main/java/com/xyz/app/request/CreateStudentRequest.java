package com.xyz.app.request;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateStudentRequest {

	@JsonProperty("first_name")
	@NotBlank(message = "First name is required")
	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<CreateSubjectRequest> subjectsLearning;

	public CreateStudentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateStudentRequest(String firstName, String lastName, String email, String street, String city,
			List<CreateSubjectRequest> subjectsLearning) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.subjectsLearning = subjectsLearning;
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

	public List<CreateSubjectRequest> getSubjectsLearning() {
		return subjectsLearning;
	}

	public void setSubjectsLearning(List<CreateSubjectRequest> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
	}
	

}
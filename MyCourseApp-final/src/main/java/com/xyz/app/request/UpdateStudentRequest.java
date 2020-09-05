package com.xyz.app.request;

import javax.validation.constraints.NotNull;

public class UpdateStudentRequest {
	
	@NotNull(message = "Student Id is required")
	private Long id;
	
	private String firstName;

	private String lastName;

	private String email;

	public UpdateStudentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateStudentRequest(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	

}
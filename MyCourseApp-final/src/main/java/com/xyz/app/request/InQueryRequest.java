package com.xyz.app.request;

import java.util.List;

public class InQueryRequest {

	private List<String> firstNames;

	public InQueryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InQueryRequest(List<String> firstNames) {
		super();
		this.firstNames = firstNames;
	}

	public List<String> getFirstNames() {
		return firstNames;
	}

	public void setFirstNames(List<String> firstNames) {
		this.firstNames = firstNames;
	}

	@Override
	public String toString() {
		return "InQueryRequest [firstNames=" + firstNames + "]";
	}
	
	
}

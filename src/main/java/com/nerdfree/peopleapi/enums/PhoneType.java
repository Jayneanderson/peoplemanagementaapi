package com.nerdfree.peopleapi.enums;

public enum PhoneType {
	
	MOBILE("mobile"),
	COMERCIAL("comercial");
	
	private final String description;
	
	PhoneType(String description) {
		this.description = description;	
	}
	
	public String getDescription() {return description;}
	
}


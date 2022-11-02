package com.ssafy.passproject.dto;

public class Email {

	String id;
	String domain;
	public Email(String id, String domain) {
		super();
		this.id = id;
		this.domain = domain;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getEmail() {
		return id + "@" + domain;
	}
	
	public static Email of(String email) {
		String[] split = email.split("@");
		return new Email(split[0], split[1]);
	}
}

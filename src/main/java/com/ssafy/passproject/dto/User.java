package com.ssafy.passproject.dto;

import com.ssafy.passproject.dto.Email;

public class User {
	
	private Integer userno;
	private Email email;
	private String password;
	private String name;
	private String addr;
	private String phone;
	
	public User(Integer userno, Email email, String password, String name, String addr, String phone) {
		super();
		this.userno = userno;
		this.email = email;
		this.password = password;
		this.name = name;
		this.addr = addr;
		this.phone = phone;
	}
	public User(String email_id , String email_domain , String password , String name,String userno) {
		super();
		this.userno = Integer.parseInt(userno);
		this.email=new Email(email_id,email_domain);
		this.password=password;
		this.name=name;
	}

	public User(Integer userno, String emailId, String emailDomain, String password, String name, String addr, String phone) {
		this(userno, new Email(emailId, emailDomain), password, name, addr, phone);
	}
	
	public Integer getUserno() {
		return userno;
	}

	public void setUserno(Integer userno) {
		this.userno = userno;
	}

	public Email getEmail() {
		return email;
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
		
}

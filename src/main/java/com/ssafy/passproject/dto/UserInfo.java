package com.ssafy.passproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.passproject.dto.Email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// user를 왜 extends 하는지 모르겠습니다. 

@ApiModel(value = "UserInfo (회원정보)", description = "회원번호, 이메일,  비번, 이름, 주소, 전화번호, 관심지역을 가진   Domain Class")
public class UserInfo extends User {
	
	private List<Dong> interestRegion = new ArrayList<>();

	public UserInfo(int userno, Email email, String password, String name, String addr, String phone, List<Dong> interestRegion) {
		super(userno, email, password, name, addr, phone);
		this.interestRegion = interestRegion;
	}
	
	public static UserInfo of(User user, List<Dong> interestRegion) {
		return new UserInfo(
					user.getUserno(),
					user.getEmail(),
					user.getPassword(),
					user.getName(),
					user.getAddr(),
					user.getPhone(),
					interestRegion
				);
	}

	public List<Dong> getInterestRegion() {
		return interestRegion;
	}

	public void setInterestRegion(List<Dong> interestRegion) {
		this.interestRegion = interestRegion;
	}
	
	
//	@ApiModelProperty(value = "회원 번호")
//	private Integer userno;
//	@ApiModelProperty(value = "회원 이메일")
//	private Email email;
//	@ApiModelProperty(value = "회원 비밀번호")
//	private String password;
//	@ApiModelProperty(value = "회원이름")
//	private String name;
//	@ApiModelProperty(value = "회원 주소")
//	private String addr;
//	@ApiModelProperty(value = "회원 전화번호")
//	private String phone;
//	@ApiModelProperty(value = "회원 관심지역")
//	private List<Dong> interestRegion;
//	
//	public Integer getUserno() {
//		return userno;
//	}
//	public void setUserno(int userno) {
//		this.userno = userno;
//	}
//	public Email getEmail() {
//		return email;
//	}
//	public void setEmail(Email email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getAddr() {
//		return addr;
//	}
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//	public List<Dong> getInterestRegion() {
//		return interestRegion;
//	}
//	public void setInterestRegion(List<Dong> interestRegion) {
//		this.interestRegion = interestRegion;
//	}
//	
//	@Override
//	public String toString() {
//		return "UserInfo [userno=" + userno + ", email=" + email + ", password=" + password + ", name=" + name
//				+ ", addr=" + addr + ", phone=" + phone + ", interestRegion=" + interestRegion + "]";
//	}
	
	
	
	
}

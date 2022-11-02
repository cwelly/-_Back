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
	
	
	
	
	
	
}

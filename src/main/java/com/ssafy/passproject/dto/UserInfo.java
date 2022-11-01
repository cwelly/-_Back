package com.ssafy.passproject.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.passproject.domain.Email;

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

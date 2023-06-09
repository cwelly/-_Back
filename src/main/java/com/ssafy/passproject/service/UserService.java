package com.ssafy.passproject.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.ssafy.passproject.dto.Email;
import com.ssafy.passproject.dto.User;

public interface UserService {
	
	int join(User user) throws SQLException, NoSuchAlgorithmException;
	User login(Email email, String password) throws SQLException, NoSuchAlgorithmException;
	User getByEmail(Email email) throws SQLException;
	User findByUserno(String userno) throws SQLException;
	void withdrawal(Email email) throws SQLException;
	void modify(User user) throws SQLException, NoSuchAlgorithmException;
	boolean registInterestRegion(int userno, String dongcode) throws SQLException;
	public void saveRefreshToken(String emailid, String refreshToken) throws Exception;
	public Object getRefreshToken(String userno) throws Exception;
	public void deleRefreshToken(String emailid) throws Exception;
	
}

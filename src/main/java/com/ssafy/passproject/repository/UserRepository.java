package com.ssafy.passproject.repository;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.passproject.dto.Email;
import com.ssafy.passproject.dto.User;
import com.ssafy.passproject.dto.UserInfo;

@Mapper
public interface UserRepository {
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String userid) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
	int save(User user) throws SQLException;
	User findByEmail(Email email) throws SQLException;
	User findByUserno(String userno) throws SQLException;
	User login(Map<String, String> map) throws SQLException;
	void delete(Email email) throws SQLException;
	void update(User user) throws SQLException;
	void saveInterestRegion(Map<String, String> map) throws SQLException;
}

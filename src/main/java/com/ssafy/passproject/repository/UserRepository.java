package com.ssafy.passproject.repository;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.passproject.domain.Email;
import com.ssafy.passproject.dto.User;
import com.ssafy.passproject.dto.UserInfo;
@Mapper
public interface UserRepository {

	int save(User user) throws SQLException;
	User findByEmail(Email email) throws SQLException;
	boolean login(Email email, String password) throws SQLException;
	void delete(Email email) throws SQLException;
	void update(User user) throws SQLException;
	void saveInterestRegion(int userno, String dongcode) throws SQLException;
}

package com.ssafy.passproject.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.passproject.domain.Email;
import com.ssafy.passproject.dto.User;
import com.ssafy.passproject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());

        return bytesToHex(md.digest());
    }
	
	private String bytesToHex(byte[] bytes) {
		 StringBuilder builder = new StringBuilder();
	        for (byte b : bytes) {
	            builder.append(String.format("%02x", b));
	        }
	        return builder.toString();
	}

	
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl(UserRepository userRepository  ) {
		this.userRepository = userRepository;
	}

	
	// 암호화로 인한 코드 변경
	@Override
	public int join(User user) throws SQLException, NoSuchAlgorithmException {
		if (userRepository.findByEmail(user.getEmail()) != null) {
			System.out.println("already registered user");
			return 0;
		}
		user.setPassword(encrypt(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public boolean login(Email email, String password) throws SQLException, NoSuchAlgorithmException {
		return userRepository.login(email, encrypt(password));
	}

	@Override
	public User getByEmail(Email email) throws SQLException {
		return userRepository.findByEmail(email);
	}

	@Override
	public void withdrawal(Email email) throws SQLException {
		userRepository.delete(email);
	}
	// 암호화로 인한 코드 변경
	@Override
	public void modify(User user) throws SQLException, NoSuchAlgorithmException {
		user.setPassword(encrypt(user.getPassword()));
		userRepository.update(user);
	}

	@Override
	public void registInterestRegion(int userno, String dongcode) throws SQLException {
		userRepository.saveInterestRegion(userno, dongcode);
	}

}

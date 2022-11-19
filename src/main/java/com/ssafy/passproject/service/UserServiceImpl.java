package com.ssafy.passproject.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.passproject.dto.Dong;
import com.ssafy.passproject.dto.Email;
import com.ssafy.passproject.dto.User;
import com.ssafy.passproject.repository.RegionRepository;
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

	private RegionRepository regionRepository;
	
	
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl(UserRepository userRepository ,RegionRepository regionRepository ) {
		this.userRepository = userRepository;
		this.regionRepository = regionRepository;
	}

	
	// 암호화로 인한 코드 변경
	@Override
	public int join(User user) throws SQLException, NoSuchAlgorithmException {
		System.out.println("회가입");
		if (userRepository.findByEmail(user.getEmail()) != null) {
			System.out.println("already registered user");
			return 0;
		}
		user.setPassword(encrypt(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User login(Email email, String password) throws SQLException, NoSuchAlgorithmException {
		Map<String, String> map =new HashMap<>();
		map.put("emailid", email.getId());
		map.put("emaildomain", email.getDomain());
		map.put("userpassword", encrypt(password));
		
		return userRepository.login(map);
		
	}

	@Override
	public User getByEmail(Email email) throws SQLException {
		return userRepository.findByEmail(email);
	}
	
	
	
	@Override
	public void withdrawal(Email email) throws SQLException {
		User user = userRepository.findByEmail(email);
		regionRepository.delete(user.getUserno());
		userRepository.delete(email);
		
	}
	// 암호화로 인한 코드 변경
	@Override
	public void modify(User user) throws SQLException, NoSuchAlgorithmException {
		user.setPassword(encrypt(user.getPassword()));
		userRepository.update(user);
	}

	@Override
	public boolean registInterestRegion(int userno, String dongcode) throws SQLException {
		Map<String, String> map =new HashMap<>();
		
		
		map.put("userno", userno+"");
		map.put("dongcode", dongcode);
		List<Dong> Inter = regionRepository.findInterestRegionByUserno(userno); 
		for (Dong dong : Inter) {
			if(dong.getDongCode().equals(dongcode)) {
				return false;
			}
		}
		
		userRepository.saveInterestRegion(map);
		return true;
	}

	@Override
	public void saveRefreshToken(String userno, String refreshToken) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("userno", userno);
		map.put("token", refreshToken);
		userRepository.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String emailid) throws Exception {
		// TODO Auto-generated method stub
		return userRepository.getRefreshToken(emailid);
	}

	@Override
	public void deleRefreshToken(String emailid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("emailid", emailid);
		map.put("token", null);
		userRepository.deleteRefreshToken(map);
	}

	@Override
	public User findByUserno(String userno) throws SQLException {
		// TODO Auto-generated method stub
		return userRepository.findByUserno(userno);
	}


}

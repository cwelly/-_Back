package com.ssafy.passproject.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.passproject.dto.Email;
import com.ssafy.passproject.dto.Region;
import com.ssafy.passproject.dto.Dong;
import com.ssafy.passproject.dto.User;
import com.ssafy.passproject.dto.UserInfo;
import com.ssafy.passproject.service.RegionService;
import com.ssafy.passproject.service.UserService;

@Controller
@RequestMapping("/user.do")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;
	private RegionService regionService;

	@Autowired
	public UserController(UserService userService,RegionService regionService) {
		logger.info("UserCotroller 생성자 호출!!!!");
		this.userService = userService;
		this.regionService = regionService;
	}
	/*
	 * 1. registRegion 관심지역 설정 () 2. modify 회원정보 수정 () 3. withdrawal 로그아웃 () 4.
	 * login 로그인 () 5. join 회원가입 () 6. buildUser 회원리스트 보기 ()
	 */


	
	@GetMapping("/registregion/{dongcode}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  registregion(@PathVariable String dongcode, HttpServletRequest request){
		ResponseEntity<Map<String,Object>> res;
		HttpSession session =request.getSession();
		Map<String, Object> map = new HashMap();
		UserInfo user = (UserInfo) session.getAttribute("user");
		try {
			
			if(userService.registInterestRegion(user.getUserno(), dongcode)) {
				map.put("resMsg", "Success OK");
				map.put("userno",user.getUserno());
				map.put("dongcode",dongcode);				
			}
			else {
				map.put("resMsg", "이미 있는 dong 입니다 ");
			}
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
	
	@PostMapping("/update/{emailid}/{emaildomain}/{password}/{name}/{addr}/{phone}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  update(@PathVariable String emailid,
			@PathVariable String emaildomain,@PathVariable String password,
			@PathVariable String name,@PathVariable String addr,@PathVariable String phone, HttpServletRequest request) {
		User user = new User(null, new Email(emailid, emaildomain) , password, name, addr, phone);
		ResponseEntity<Map<String,Object>> res;
		Map<String, Object> map = new HashMap();
		try {
			userService.modify(user);
			user =userService.getByEmail(user.getEmail());
			map.put("resMsg", "개인정보수정완료");
			System.out.println(user.getUserno());
			List<Dong> interestRegion = regionService.getInterestRegionByUserno(user.getUserno());
			UserInfo info = UserInfo.of(user, interestRegion);
			request.getSession().removeAttribute("login");
			request.getSession().setAttribute("login", user);
			request.getSession().removeAttribute("user");
			request.getSession().setAttribute("user", info);
			
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
//	public String update(@RequestParam("emailid") String emailid, String emaildomain, String password,
//			String name, String addr, String phone) {
//		User user = new User(null, new Email(emailid, emaildomain) , password, name, addr, phone);
//		try {
//			userService.modify(user);
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return "redirect:/";
//	}
	
	@PostMapping("/join/{emailid}/{emaildomain}/{password}/{name}/{addr}/{phone}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  join(@PathVariable String emailid,
			@PathVariable String emaildomain,@PathVariable String password,
			@PathVariable String name,@PathVariable String addr,@PathVariable String phone) {
		
		User user = new User(null, new Email(emailid, emaildomain) , password, name, addr, phone);
		ResponseEntity<Map<String,Object>> res;
		Map<String, Object> map = new HashMap();
		try {
			if(0!=userService.join(user)) {
				map.put("resMsg", "회원등록완료");			
			}
			else {
				
				map.put("resMsg", "중복회원");			
			}
			
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
		

	}


	@PostMapping("/login/{emailid}/{emaildomain}/{password}") // 실제 로그인
	public @ResponseBody ResponseEntity<Map<String,Object>> login(@PathVariable String emailid,@PathVariable String emaildomain,@PathVariable String password, Model model, HttpSession session,
			 HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, SQLException {
		
		
			Email email = new Email(emailid, emaildomain);
			
			ResponseEntity<Map<String,Object>> res;
			Map<String, Object> map = new HashMap();
			try {
				User user = userService.login(email, password);
				if(user!=null) {
					List<Dong> interestRegion = regionService.getInterestRegionByUserno(user.getUserno());
					UserInfo info = UserInfo.of(user, interestRegion);
					request.getSession().setAttribute("user", info);
					request.setAttribute("loginResult", "로그인 성공!!!");
					request.getSession().setAttribute("login", user);
					map.put("userInfo", info);	
					map.put("resMsg", "로그인 성공!!!");			
				}
				else {
					
					map.put("resMsg", "로그인 실패");			
				}
				
			}catch(Exception e) {
				map.put("resMsg", "false ");
			}
			res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
			return res;
	}
	
	@GetMapping("/logout")
	public @ResponseBody ResponseEntity<Map<String,Object>> logout(HttpServletRequest request, HttpSession session) {
		ResponseEntity<Map<String,Object>> res;
		Map<String, Object> map = new HashMap();
		try {
			session.invalidate();
			map.put("resMsg", "로그아웃완료");
			
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
	@GetMapping("/withdrawal")
	public @ResponseBody ResponseEntity<Map<String,Object>> withdrawal ( HttpServletRequest request) {
		ResponseEntity<Map<String,Object>> res;
		HttpSession session =request.getSession();
		Map<String, Object> map = new HashMap();
		UserInfo user = (UserInfo) session.getAttribute("user");
		Email email = user.getEmail();
		try {
			userService.withdrawal(email);
			session.invalidate();
			map.put("resMsg", "삭제완료");
			
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}


}

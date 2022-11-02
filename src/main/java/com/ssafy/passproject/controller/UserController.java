package com.ssafy.passproject.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public UserController(UserService userService) {
		logger.info("UserCotroller 생성자 호출!!!!");
		this.userService = userService;
		this.regionService = regionService;
	}
	/*
	 * 1. registRegion 관심지역 설정 () 2. modify 회원정보 수정 () 3. withdrawal 로그아웃 () 4.
	 * login 로그인 () 5. join 회원가입 () 6. buildUser 회원리스트 보기 ()
	 */

//	// 회원 조회
//	@GetMapping("/join")
//	public String join() {
//		return "user/join";
//	}
//	
//	// 특정 회원 조회 -> 아이디 검색 (기능 없음)
//	@GetMapping("/{userid}")
//	@ResponseBody
//	public String idCheck(@PathVariable("email") Email email) throws Exception {
//		logger.debug("idCheck userid : {}", userId);
//		int cnt = userService.login(email, password);
//		return cnt + "";
//	}
//	
	@PostMapping("/join")
	public String join(@RequestParam("emailid") String emailid, String emaildomain, String password,
			String name, String addr, String phone, Model model) {
		
		User user = new User(null, new Email(emailid, emaildomain) , password, name, addr, phone);
		try {
			int result = userService.join(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
		
		
//		try {
//			userService.joinMember(userInfo);
//			return "redirect:/user/login";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "회원 가입 중 문제 발생!!!");
//			return "error/error";
//		}
	}

//	@GetMapping("/login") // 로그인 페이지 이동
//	public String login() {
//		return "user/login";
//	}

	@PostMapping("/login") // 실제 로그인
	//String email = request.getParameter("email) //@RequestParam("email") String email
	public String login(@RequestParam("emailid") String emailid,@RequestParam("emaildomain") String emaildomain, String password, Model model, HttpSession session,
			 HttpServletRequest request, HttpServletResponse response) {

		try {
			Email email = new Email(emailid, emaildomain);
			
			User user = userService.login(email, password);
			if (user!=null) {
//				List<Dong> interestRegion = regionService.getInterestRegionByUserno(user.getUserno());

//				UserInfo info = UserInfo.of(user, interestRegion);

				request.getSession().setAttribute("user", user);
				request.setAttribute("loginResult", "로그인 성공!!!");
				request.getSession().setAttribute("login", user);
				
			} else {
				request.setAttribute("loginResult", "로그인 실패!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제 발생!!!");
			return "error/error";
		}
		return "redirect:/";
	}
	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
//	
//	@GetMapping("/list")
//	public String list() {
//		return "redirect:/assets/list.html";
//	}
//	
}

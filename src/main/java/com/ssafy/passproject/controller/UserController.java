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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.passproject.dto.Email;
import com.ssafy.passproject.dto.Region;
import com.ssafy.passproject.dto.Dong;
import com.ssafy.passproject.dto.User;
import com.ssafy.passproject.dto.UserInfo;
import com.ssafy.passproject.service.JwtServiceImpl;
import com.ssafy.passproject.service.RegionService;
import com.ssafy.passproject.service.UserService;

import io.swagger.annotations.ApiParam;
@CrossOrigin(origins = {"*"},maxAge = 6000)
@Controller
@RequestMapping("/user.do")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;
	
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
	public @ResponseBody ResponseEntity<Map<String,Object>>  registregion(@PathVariable String dongcode,@RequestParam("emailid") String emailid,@RequestParam("emaildomain") String emaildomain,HttpServletRequest request){
		ResponseEntity<Map<String,Object>> res;
		Email email = new Email(emailid, emaildomain);
		Map<String, Object> map = new HashMap();
//		UserInfo user =(UserInfo)user1;
		try {
			User findeduser =userService.getByEmail(email);
			if(userService.registInterestRegion(findeduser.getUserno(), dongcode)) {
				List<Dong> interestRegion = regionService.getInterestRegionByUserno(findeduser.getUserno());
				UserInfo info = UserInfo.of(findeduser, interestRegion);
				map.put("resMsg", "Success OK");
				map.put("userno",findeduser.getUserno());
				map.put("dongcode",dongcode);	
				map.put("userInfo", info);
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
			map.put("userInfo", info);	
			
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

	
	@GetMapping("/login/{emailid}/{emaildomain}/{password}") // 실제 로그인
	public @ResponseBody ResponseEntity<Map<String,Object>> login(@PathVariable String emailid,@PathVariable String emaildomain,@PathVariable String password) throws NoSuchAlgorithmException, SQLException {

			Email email = new Email(emailid, emaildomain);
			HttpStatus status = null;
			ResponseEntity<Map<String,Object>> res;
			Map<String, Object> map = new HashMap();
			System.out.println(email.getDomain()+" , "+email.getId()+" , "+password);
			try {
				User user = userService.login(email, password);
				System.out.println("try? 이거 맞나");
//				List<Dong> interestRegion = regionService.getInterestRegionByUserno(user.getUserno());
//				UserInfo info = UserInfo.of(user, interestRegion);
				if(user!=null) {
					String accessToken = jwtService.createAccessToken("userno", user.getUserno());// key, data
					String refreshToken = jwtService.createRefreshToken("userno", user.getUserno());// key, data
					userService.saveRefreshToken(user.getUserno()+"", refreshToken);
					logger.debug("로그인 accessToken 정보 : {}", accessToken);
					logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
					map.put("access-token", accessToken);
					map.put("refresh-token", refreshToken);
					map.put("message", SUCCESS);
//					map.put("userInfo", info);	
					map.put("resMsg", "로그인 성공!!!");
					status = HttpStatus.ACCEPTED;
				}
				else {
					map.put("message", FAIL);
					status = HttpStatus.ACCEPTED;
					map.put("resMsg", FAIL);			
				}
				
			}catch(Exception e) {
				logger.error("로그인 실패 : {}", e);
				map.put("resMsg", e.getMessage());
				map.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
			res = new ResponseEntity<Map<String,Object>>(map, status);
			return res;
	}
//	@GetMapping("/login/{emailid}/{emaildomain}/{password}") // 실제 로그인
//	public @ResponseBody ResponseEntity<Map<String,Object>> login(@PathVariable String emailid,@PathVariable String emaildomain,@PathVariable String password, Model model, HttpSession session,
//			HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, SQLException {
//		
//		Email email = new Email(emailid, emaildomain);
//		
//		ResponseEntity<Map<String,Object>> res;
//		Map<String, Object> map = new HashMap();
//		try {
//			User user = userService.login(email, password);
//			if(user!=null) {
//				List<Dong> interestRegion = regionService.getInterestRegionByUserno(user.getUserno());
//				UserInfo info = UserInfo.of(user, interestRegion);
//				request.getSession().setAttribute("user", info);
//				request.setAttribute("loginResult", "로그인 성공!!!");
//				request.getSession().setAttribute("login", user);
//				map.put("userInfo", info);	
//				map.put("resMsg", "로그인 성공!!!");			
//			}
//			else {
//				
//				map.put("resMsg", "로그인 실패");			
//			}
//			
//		}catch(Exception e) {
//			map.put("resMsg", "false ");
//		}
//		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
//		
//		return res;
//	}
	
	@GetMapping("/info/{userno}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userno")  String userno,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		System.out.println(request.getHeader("access-token"));
		if (jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				User user = userService.findByUserno(userno);
				resultMap.put("userInfo", user);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
//	@GetMapping("/logout")
//	public @ResponseBody ResponseEntity<Map<String,Object>> logout(HttpServletRequest request, HttpSession session) {
//		ResponseEntity<Map<String,Object>> res;
//		Map<String, Object> map = new HashMap();
//		try {
//			session.invalidate();
//			map.put("resMsg", "로그아웃완료");
//			
//		}catch(Exception e) {
//			map.put("resMsg", "false ");
//		}
//		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
//		
//		return res;
//	}
	
	@GetMapping("/logout/{userno}")
	public ResponseEntity<?> removeToken(@PathVariable("userno") String userno) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userno);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody User user, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, user);
		if (jwtService.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(user.getUserno()+""))) {
				String accessToken = jwtService.createAccessToken("userno", user.getUserno()+"");
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/withdrawal")
	public @ResponseBody ResponseEntity<Map<String,Object>> withdrawal ( @RequestParam("emailid") String emailid,@RequestParam("emaildomain") String emaildomain,HttpServletRequest request) {
		ResponseEntity<Map<String,Object>> res;
		Map<String, Object> map = new HashMap();
		Email email = new Email(emailid, emaildomain);
		try {
			System.out.println(emailid+" , "+emaildomain);
			userService.withdrawal(email);
			map.put("resMsg", "삭제완료");
			
		}catch(Exception e) {
			System.out.println("실패");
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}


}

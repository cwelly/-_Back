package com.ssafy.passproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.passproject.dto.Case;
import com.ssafy.passproject.service.CaseService;
import com.ssafy.passproject.service.MapService;

@CrossOrigin(origins = {"*"},maxAge = 6000)
@Controller()
@RequestMapping("/case.do")
public class CaseController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
//	logger.error("로그인 실패 : {}", e);
//	logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
	
	
	
	private CaseService caseService;
	@Autowired
	public CaseController(CaseService caseService) {
		this.caseService=caseService;
	}
	
	//전체를 리턴하는 요청
	@GetMapping("/getall")
	public @ResponseBody ResponseEntity<Map<String,Object>>  getall( ){
		ResponseEntity<Map<String,Object>> res;
		Map<String, Object> map = new HashMap();
		List<Case> allcase = new ArrayList<>();
		try {
			allcase=caseService.getCaseAll();
			map.put("resMsg", "Success OK");
			map.put("caseList", allcase);
		}
		catch(Exception e) {
			System.out.println(e);
			map.put("resMsg", "false ");
		}
		
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		return res;
	}
	//해당 교통수단에 해당되는 정보만 요청
	
	// 해당 성별에 해당되는 사건만 요청
	
	// 해당 나잇대에 해당되는 사건만 요청
	
	// 사용자의 정보에 해당하는  사건만 요청
	@GetMapping("/getfit/{sex}/{age}/{trans}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  getfit( @PathVariable String sex,
			@PathVariable String age, @PathVariable String trans){
		ResponseEntity<Map<String,Object>> res;
		Map<String, Object> map = new HashMap();
		List<Case> fitcase = new ArrayList<>();
		System.out.println("입력으로 들어온  sex값 : "+sex+" , age값 : "+age+" , trans 값 : "+trans );
		try {
			fitcase=caseService.getCaseFit(sex, trans, age);
			map.put("resMsg", "Success OK");
			map.put("fitList", fitcase);
		}
		catch(Exception e) {
			System.out.println(e);
			map.put("resMsg", "false ");
		}
		
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		return res;
	}
	// 출발점과 도착점의 정보에 해당하는 범위 요청                               
	@GetMapping("/getway/{lat1}/{lat2}/{lng1}/{lng2}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  getway( @PathVariable String lat1 ,@PathVariable String lat2,@PathVariable String lng1,@PathVariable String lng2){
		ResponseEntity<Map<String,Object>> res;
		Map<String, Object> map = new HashMap();
		List<Case> waycase = new ArrayList<>();
		try {
			waycase=caseService.getCaseWayout(lat1, lat2, lng1, lng2);
			map.put("resMsg", "Success OK");
			map.put("wayList", waycase);
		}
		catch(Exception e) {
			System.out.println(e);
			map.put("resMsg", "false ");
		}
		
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		return res;
	}
	
	
	
	
	
	
	
}

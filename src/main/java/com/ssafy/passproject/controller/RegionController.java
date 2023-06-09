package com.ssafy.passproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.passproject.dto.Region;
import com.ssafy.passproject.service.RegionService;
@CrossOrigin(origins = {"*"},maxAge = 6000)
@RestController
@RequestMapping("/region.do")
public class RegionController {
	private RegionService regionService;
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
//	logger.error("로그인 실패 : {}", e);
//	logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
	
	@Autowired
	public RegionController(RegionService regionService) {
		this.regionService= regionService;
	}
	
	
	@GetMapping("/sido")
	public @ResponseBody ResponseEntity<Map<String,Object>>  sido(){
		ResponseEntity<Map<String,Object>> res;
		Region region;
		Map<String, Object> map = new HashMap();
		try {
			List<Region> listMember = regionService.getSidoList();
			map.put("resMsg", "Success OK");
			map.put("regions", listMember);
		}catch(Exception e) {
			logger.error("시도 조회 실패 : {}", e);
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
	//!
	@GetMapping("/gugun/{sido}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  gugun(@PathVariable String sido){
		ResponseEntity<Map<String,Object>> res;
		Region region;
//		System.out.println(sido);
		logger.debug("sido 정보 : {}", sido);
		Map<String, Object> map = new HashMap();
		try {
			List<Region> listMember = regionService.getGugunList(sido);
			map.put("resMsg", "Success OK");
			map.put("regions", listMember);
		}catch(Exception e) {
			logger.error("구군 조회 실패 : {}", e);
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
	@GetMapping("/dong/{gugun}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  dong(@PathVariable String gugun){
		ResponseEntity<Map<String,Object>> res;
		Region region;
//		System.out.println(gugun);
		logger.debug("gugun 정보 : {}", gugun);
		Map<String, Object> map = new HashMap();
		try {
			List<Region> listMember = regionService.getDongList(gugun);
			map.put("resMsg", "Success OK");
			map.put("regions", listMember);
		}catch(Exception e) {
			logger.error("동 조회 실패 : {}", e);
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
	
}

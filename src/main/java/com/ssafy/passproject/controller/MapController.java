package com.ssafy.passproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.passproject.dto.MapInfo;
import com.ssafy.passproject.dto.Region;
import com.ssafy.passproject.service.MapService;

@CrossOrigin(origins = {"*"},maxAge = 6000)
@Controller()
@RequestMapping("/map.do")
public class MapController {

	private MapService mapService;
	@Autowired
	public MapController(MapService mapService) {
		this.mapService=mapService;
	}
	//동으로 검색
	///map.do/searchDong/${sido}/${gugun}/${dong}
	
	@GetMapping("/searchDong/{sido}/{gugun}/{dong}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  searchDong(
			@PathVariable String sido,@PathVariable String gugun,@PathVariable String dong ,HttpServletRequest request){
		ResponseEntity<Map<String,Object>> res;
		Region region;
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap();
		try {
			if(session.getAttribute("list")!=null) {
				session.removeAttribute("list");
			}
			List<MapInfo> listMember = mapService.searchDong(sido, dong, gugun);
			session.setAttribute("list", listMember);
			map.put("resMsg", "Success OK");
			map.put("aptList", listMember);
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
	@GetMapping("/searchName/{aptName}")
	public @ResponseBody ResponseEntity<Map<String,Object>>  searchDong(
			@PathVariable String aptName, HttpServletRequest request){
		ResponseEntity<Map<String,Object>> res;
		HttpSession session = request.getSession();
		Region region;
		Map<String, Object> map = new HashMap();
		
		try {
			if(session.getAttribute("list")!=null) {
				session.removeAttribute("list");
			}
			List<MapInfo> listMember = mapService.searchName(aptName);
			session.setAttribute("list", listMember);
			map.put("resMsg", "Success OK");
			map.put("aptList", listMember);
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
	}
	@GetMapping("/sortAmount")
	public @ResponseBody  ResponseEntity<Map<String,Object>>  sortAmount(HttpServletRequest request){
		ResponseEntity<Map<String,Object>> res;
		Region region;
		Map<String, Object> map = new HashMap();
		try {
			HttpSession session = request.getSession();
			List<MapInfo> origin = (List<MapInfo>) session.getAttribute("list");
			List<MapInfo> listMember = mapService.sortAmount(origin);
			System.out.println(listMember.size());
			map.put("resMsg", "Success OK");
			map.put("aptList", listMember);
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
		
	}
	@GetMapping("/sortYear")
	public @ResponseBody  ResponseEntity<Map<String,Object>>  sortYear(HttpServletRequest request){
		ResponseEntity<Map<String,Object>> res;
		Region region;
		Map<String, Object> map = new HashMap();
		try {
			HttpSession session = request.getSession();
			List<MapInfo> origin = (List<MapInfo>) session.getAttribute("list");
			
			List<MapInfo> listMember = mapService.sortYear(origin);
			System.out.println(listMember.size());
			map.put("resMsg", "Success OK");
			map.put("aptList", listMember);
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
		
	}
	@GetMapping("/sortArea")
	public @ResponseBody  ResponseEntity<Map<String,Object>>  sortArea(HttpServletRequest request){
		ResponseEntity<Map<String,Object>> res;
		Region region;
		Map<String, Object> map = new HashMap();
		try {
			HttpSession session = request.getSession();
			List<MapInfo> origin = (List<MapInfo>) session.getAttribute("list");
			List<MapInfo> listMember = mapService.sortArea(origin);
			System.out.println(listMember.size());
			map.put("resMsg", "Success OK");
			map.put("aptList", listMember);
		}catch(Exception e) {
			map.put("resMsg", "false ");
		}
		res = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		
		return res;
		
	}
	
	
}

package com.ssafy.passproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.passproject.service.RegionService;

@RestController
public class RegionController {
	private RegionService regionService;
	
	@Autowired
	public RegionController(RegionService regionService) {
		this.regionService= regionService;
	}
	
}

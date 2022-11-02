package com.ssafy.passproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.passproject.service.MapService;

@RestController
public class MapController {

	private MapService mapService;
	@Autowired
	public MapController(MapService mapService) {
		this.mapService=mapService;
	}
	
	
	
	
	
}

package com.ssafy.passproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.passproject.service.UserService;

@RestController
public class UserController {
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
}

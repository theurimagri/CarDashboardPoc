package com.globallogic.car.dashboard.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.service.spi.UserService;

@RestController
public class TokenController {

	public static final String TOKEN = "AB123THYUJ76ddspoauiew99fdjkhfSDSADGV";
	private UserService userService;

	public TokenController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/token")
	public String getToken(@RequestHeader("userId") Long userId) {
		userService.getUserById(userId);
		return TOKEN;
	}
}
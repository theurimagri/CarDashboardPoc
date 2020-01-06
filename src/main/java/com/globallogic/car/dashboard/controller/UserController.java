package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.entity.User;
import com.globallogic.car.dashboard.service.spi.UserService;

@RestController
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/users", produces = APPLICATION_JSON)
    private Set<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

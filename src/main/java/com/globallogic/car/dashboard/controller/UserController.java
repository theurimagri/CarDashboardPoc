package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@GetMapping(value = "/rest/user", produces = APPLICATION_JSON)
    private ResponseEntity<User> getUser(@RequestHeader("userId") Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), OK);
    }
}

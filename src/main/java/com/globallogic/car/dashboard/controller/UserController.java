package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.dto.UserDto;
import com.globallogic.car.dashboard.service.spi.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/rest")
@OpenAPIDefinition(security = { @SecurityRequirement(name = "bearerScheme") })
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping(value = "/user", produces = APPLICATION_JSON)
	private ResponseEntity<UserDto> getUser(@RequestHeader("userId") Long userId) {
		return new ResponseEntity<>(userService.getUserById(userId), OK);
	}

	@GetMapping(value = "/users/info", produces = APPLICATION_JSON)
	private ResponseEntity<Set<UserDto>> getUsersInforation() {
		return new ResponseEntity<>(userService.getAllUsers(), OK);
	}
}

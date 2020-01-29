package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.dto.LayoutDto;
import com.globallogic.car.dashboard.service.spi.LayoutService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/rest")
@OpenAPIDefinition(security = { @SecurityRequirement(name = "bearerScheme") })
public class LayoutController {

	private final LayoutService layoutService;

	public LayoutController(LayoutService layoutService) {
		this.layoutService = layoutService;
	}

	@PostMapping(value = "/layout", produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
	private ResponseEntity<LayoutDto> saveLayout(@RequestBody final LayoutDto layoutDto) {
		return new ResponseEntity<>(layoutService.saveLayout(layoutDto), OK);
	}

	@PutMapping(value = "/layout", produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
	private ResponseEntity<Void> updateLayout(@RequestBody final LayoutDto layoutDto) {
		layoutService.updateLayout(layoutDto);
		return new ResponseEntity<>(OK);
	}

	@GetMapping(value = "/layout", produces = APPLICATION_JSON)
	private ResponseEntity<List<LayoutDto>> getUser() {
		return new ResponseEntity<>(layoutService.findAll(), OK);
	}

	@DeleteMapping(value = "/layout/{layoutId}", produces = APPLICATION_JSON)
	private ResponseEntity<Void> deleteLayout(@PathVariable("layoutId") Long layoutId) {
		layoutService.deleteLayout(layoutId);
		return new ResponseEntity<>(OK);
	}
}

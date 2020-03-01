package com.globallogic.car.dashboard.controller;

import static com.globallogic.car.dashboard.controller.CarDashboardEndpointResources.REST_API_PREFIX;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.dto.LayoutDto;
import com.globallogic.car.dashboard.service.spi.LayoutService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(REST_API_PREFIX)
@OpenAPIDefinition(security = { @SecurityRequirement(name = "bearerScheme") })
public class LayoutController {

	private final LayoutService layoutService;

	public LayoutController(LayoutService layoutService) {
		this.layoutService = layoutService;
	}

	@PostMapping(value = "/layout", produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
	private ResponseEntity<LayoutDto> saveLayout(@ModelAttribute final LayoutDto layoutDto) {
		return new ResponseEntity<>(layoutService.saveLayout(layoutDto), OK);
	}

	@PutMapping(value = "/layout", produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
	private ResponseEntity<Void> updateLayout(@ModelAttribute final LayoutDto layoutDto) {
		layoutService.updateLayout(layoutDto);
		return new ResponseEntity<>(OK);
	}

	@GetMapping(value = "/layouts", produces = APPLICATION_JSON)
	private ResponseEntity<List<LayoutDto>> getAllLayouts() {
		return new ResponseEntity<>(layoutService.findAll(), OK);
	}

	@GetMapping(value = "/layouts/car/{carId}", produces = APPLICATION_JSON)
	private ResponseEntity<List<LayoutDto>> getLayoutsByCar(@PathVariable("carId") final Long carId) {
		return new ResponseEntity<>(layoutService.findByCarId(carId), OK);
	}
	
	@GetMapping(value = "/layout", produces = APPLICATION_JSON)
	private ResponseEntity<LayoutDto> getLayoutByFilter(@RequestParam("layoutName") final String layoutName) {
		return new ResponseEntity<>(layoutService.findByName(layoutName), OK);
	}

	@GetMapping(value = "/layout/{layoutId}", produces = APPLICATION_JSON)
	private ResponseEntity<LayoutDto> getLayoutByFilter(@PathVariable("layoutId") final Long layoutId) {
		return new ResponseEntity<>(layoutService.findById(layoutId), OK);
	}

	@DeleteMapping(value = "/layout/{layoutId}", produces = APPLICATION_JSON)
	private ResponseEntity<Void> deleteLayout(@PathVariable("layoutId") Long layoutId) {
		layoutService.deleteLayout(layoutId);
		return new ResponseEntity<>(OK);
	}
	
	@DeleteMapping(value = "/layouts/car/{carId}", produces = APPLICATION_JSON)
	private ResponseEntity<Void> deleteLayoutsByCar(@PathVariable("carId") final Long carId) {
		layoutService.deleteByCarId(carId);
		return new ResponseEntity<>(OK);
	}
}

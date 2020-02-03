package com.globallogic.car.dashboard.controller;

import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.service.spi.DashboardConfigurationService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/rest")
@OpenAPIDefinition(security = { @SecurityRequirement(name = "bearerScheme") })
public class DashboardConfigurationController {

	private DashboardConfigurationService dashboardConfigurationService;

	public DashboardConfigurationController(DashboardConfigurationService dashboardConfigurationService) {
		super();
		this.dashboardConfigurationService = dashboardConfigurationService;
	}

	@PostMapping(value = "/configuration", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	private ResponseEntity<Long> createDashboardConfiguration(
			@RequestHeader(value = "userId", required = false) Long userId,
			@RequestHeader(value = "userName", required = false) String userName,
			@RequestBody DashboardConfigurationDto dashboardConfigurationDto) {
		return new ResponseEntity<>(dashboardConfigurationService
				.createDashboardConfiguration(userName, dashboardConfigurationDto).getConfigurationId(), OK);
	}

	@PutMapping(value = "/configuration", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	private ResponseEntity<Long> updateDashboardConfiguration(@RequestBody DashboardConfigurationDto dashboardConfigurationDto) {
		dashboardConfigurationService.updateDashboardConfiguration(dashboardConfigurationDto);
		return new ResponseEntity<>(dashboardConfigurationDto.getConfigurationId(), OK);
	}
	
	@PutMapping(value = "/configuration/car/{carId}", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	private ResponseEntity<Long> updateDashboardConfiguration(
			@RequestHeader(value = "userId", required = false) Long userId,
			@RequestHeader(value = "userName", required = false) String userName, 
			@PathVariable("carId") Long carId,
			@RequestBody DashboardConfigurationDto dashboardConfigurationDto) {
		dashboardConfigurationService.updateDashboardConfigurationByUserAndCarId(userId, userName, carId, dashboardConfigurationDto);
		return new ResponseEntity<>(dashboardConfigurationDto.getConfigurationId(), OK);
	}

	@GetMapping(value = "/configuration/{carId}", produces = APPLICATION_JSON)
	private ResponseEntity<String> getDashboardConfiguration(
			@RequestHeader(value = "userId", required = false) Long userId,
			@RequestHeader(value = "userName", required = false) String userName, 
			@PathVariable("carId") Long carId) {
		
		final DashboardConfigurationDto dashboardConfigurationDto = dashboardConfigurationService.findByUserAndCarId(userId, userName, carId);
		return ResponseEntity.ok()
				.header("Last-Modified",dashboardConfigurationDto.getUpdateAt().format(RFC_1123_DATE_TIME))
				.body(dashboardConfigurationDto.getFile());
	}

	@DeleteMapping(value = "/configuration/{configurationId}", produces = APPLICATION_JSON)
	private ResponseEntity<String> deleteDashboardConfiguration(@PathVariable("configurationId") Long configurationId) {
		dashboardConfigurationService.deleteDashboardConfiguration(configurationId);
		return new ResponseEntity<>(OK);
	}
}

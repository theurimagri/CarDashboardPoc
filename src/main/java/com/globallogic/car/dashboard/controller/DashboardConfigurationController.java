package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.service.spi.DashboardConfigurationService;

@RestController
@RequestMapping("/rest")
public class DashboardConfigurationController {
	
	private DashboardConfigurationService dashboardConfigurationService;
	
	public DashboardConfigurationController(DashboardConfigurationService dashboardConfigurationService) {
		super();
		this.dashboardConfigurationService = dashboardConfigurationService;
	}

	@PostMapping(value = "/configuration", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	private ResponseEntity<Long> createDashboardConfiguration(@RequestHeader("userId") Long userId, @RequestBody DashboardConfigurationDto dashboardConfigurationDto) {
		return new ResponseEntity<>(dashboardConfigurationService.createDashboardConfiguration(dashboardConfigurationDto).getConfigurationId(), OK);
	}
	
	@PutMapping(value = "/configuration", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	private ResponseEntity<Long> updateDashboardConfiguration(@RequestHeader("userId") Long userId, @RequestBody DashboardConfigurationDto dashboardConfigurationDto) {
		dashboardConfigurationService.updateDashboardConfiguration(dashboardConfigurationDto);
		return new ResponseEntity<>(dashboardConfigurationDto.getConfigurationId(), OK);
	}
}

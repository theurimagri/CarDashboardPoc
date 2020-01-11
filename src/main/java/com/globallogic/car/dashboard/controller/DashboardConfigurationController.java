package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.entity.DashboardConfiguration;
import com.globallogic.car.dashboard.service.spi.DashboardConfigurationService;

@RestController
public class DashboardConfigurationController {
	
	private DashboardConfigurationService dashboardConfigurationService;
	
	public DashboardConfigurationController(DashboardConfigurationService dashboardConfigurationService) {
		super();
		this.dashboardConfigurationService = dashboardConfigurationService;
	}

	@GetMapping(value = "/rest/configuration/{carId}", produces = APPLICATION_JSON)
    private ResponseEntity<DashboardConfiguration> getDashboardConfiguration(@RequestHeader("userId") Long userId, @PathVariable("carId") Long carId) {
		return dashboardConfigurationService.getDashboardConfigurationByUserAndCar(userId, carId)
        		.map(config -> new ResponseEntity<DashboardConfiguration>(config, OK))
        		.orElse(ResponseEntity.ok().build());
    }
	
	@PostMapping(value = "/rest/configuration", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	private ResponseEntity<Long> createDashboardConfiguration(@RequestHeader("userId") Long userId, @RequestBody DashboardConfiguration dashboardConfiguration) {
		return new ResponseEntity<>(dashboardConfigurationService.createDashboardConfiguration(dashboardConfiguration).getId(), OK);
	}
}

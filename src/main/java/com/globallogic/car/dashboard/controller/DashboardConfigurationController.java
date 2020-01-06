package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping(value = "/configurations", produces = APPLICATION_JSON)
    private Set<DashboardConfiguration> getAllDashboardConfiguration() {
        return dashboardConfigurationService.getAllDashboardConfigurations();
    }
	
	@RequestMapping(value = "/configuration/{carId}", method = GET, produces = APPLICATION_JSON)
    private ResponseEntity<DashboardConfiguration> getDashboardConfiguration(@RequestHeader("userId") Long userId, @PathVariable("carId") Long carId) {
		return dashboardConfigurationService.getDashboardConfigurationByUserAndCar(userId, carId)
        		.map(config -> new ResponseEntity<DashboardConfiguration>(config, OK))
        		.orElse(ResponseEntity.ok().build());
    }
	
	@PostMapping(value = "configuration", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	private long createDashboardConfiguration(@RequestHeader("userId") Long userId, @RequestBody DashboardConfiguration dashboardConfiguration) {
		return dashboardConfigurationService.createDashboardConfiguration(dashboardConfiguration).getId();
	}
}

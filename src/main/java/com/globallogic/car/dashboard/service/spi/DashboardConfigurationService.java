package com.globallogic.car.dashboard.service.spi;

import java.util.Optional;
import java.util.Set;

import com.globallogic.car.dashboard.entity.DashboardConfiguration;

public interface DashboardConfigurationService {

	Set<DashboardConfiguration> getAllDashboardConfigurations();
	
	DashboardConfiguration getDashboardConfigurationById(Long dashboardId);
	
	Optional<DashboardConfiguration> getDashboardConfigurationByUserAndCar(Long userId, Long carId);
	
	DashboardConfiguration createDashboardConfiguration(DashboardConfiguration dashboardConfiguration);
	
	void updateDashboardConfiguration(DashboardConfiguration dashboardConfiguration);
}

package com.globallogic.car.dashboard.service.spi;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.entity.DashboardConfiguration;

public interface DashboardConfigurationService {

	DashboardConfiguration createDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto);
	
	void updateDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto);
	
	DashboardConfigurationDto findByUserIdAndCarId(Long userId, Long carId);
	
	void deleteDashboardConfiguration(Long configurationId);
}

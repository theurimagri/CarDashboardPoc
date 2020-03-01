package com.globallogic.car.dashboard.service.spi;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.entity.DashboardConfiguration;

public interface DashboardConfigurationService {

	DashboardConfiguration createDashboardConfiguration(String userName, DashboardConfigurationDto dashboardConfigurationDto);
	
	void updateDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto);
	
	void updateDashboardConfigurationByUserAndCarId(Long userId, String userName, Long carId, DashboardConfigurationDto dashboardConfigurationDto);
	
	DashboardConfigurationDto findByUserAndCarId(Long userId, String userName, Long carId);
	
	DashboardConfigurationDto findByUserIdAndCarId(Long userId, Long carId);
	
	void deleteDashboardConfiguration(Long configurationId);
}

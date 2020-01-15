package com.globallogic.car.dashboard.dto;

import java.util.Set;

import com.globallogic.car.dashboard.enums.CarType;

public class CarDto {

	private Long carId;
	private String carModel;
	private CarType carType;
	private Set<DashboardConfigurationDto> dashboardConfigurations;

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Set<DashboardConfigurationDto> getDashboardConfigurations() {
		return dashboardConfigurations;
	}

	public void setDashboardConfigurations(Set<DashboardConfigurationDto> dashboardConfigurationsDto) {
		this.dashboardConfigurations = dashboardConfigurationsDto;
	}
	
}

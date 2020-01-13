package com.globallogic.car.dashboard.dto;

import java.util.Set;

import com.globallogic.car.dashboard.enums.CarType;

public class CarDto {

	private Long id;
	private String model;
	private CarType type;
	private Set<UserDto> usersDto;
	private Set<DashboardConfigurationDto> dashboardConfigurationsDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CarType getType() {
		return type;
	}

	public void setType(CarType type) {
		this.type = type;
	}

	public Set<UserDto> getUsersDto() {
		return usersDto;
	}

	public void setUsers(Set<UserDto> usersDto) {
		this.usersDto = usersDto;
	}

	public Set<DashboardConfigurationDto> getDashboardConfigurationsDto() {
		return dashboardConfigurationsDto;
	}

	public void setDashboardConfigurationsDto(Set<DashboardConfigurationDto> dashboardConfigurationsDto) {
		this.dashboardConfigurationsDto = dashboardConfigurationsDto;
	}
	
}

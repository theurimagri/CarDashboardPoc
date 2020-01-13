package com.globallogic.car.dashboard.dto;

import java.util.List;
import java.util.Set;

public class UserDto {

	private Long id;
	private String name;
	private Set<DashboardConfigurationDto> dashboardConfigurationsDto;
	private List<CarDto> carsDto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DashboardConfigurationDto> getDashboardConfigurationsDto() {
		return dashboardConfigurationsDto;
	}
	
	public void setDashboardConfigurationsDto(Set<DashboardConfigurationDto> dashboardConfigurationsDto) {
		this.dashboardConfigurationsDto = dashboardConfigurationsDto;
	}

	public List<CarDto> getCarsDto() {
		return carsDto;
	}

	public void setCarsDto(List<CarDto> carsDto) {
		this.carsDto = carsDto;
	}
	
}

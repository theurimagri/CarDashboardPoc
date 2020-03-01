package com.globallogic.car.dashboard.dto;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class DashboardConfigurationDto {

	private Long configurationId;
	private Long userId;
	private String file;
	private Long carId;
	
	@JsonIgnore
	private ZonedDateTime createAt;
	
	@JsonIgnore
	private ZonedDateTime updateAt;
}

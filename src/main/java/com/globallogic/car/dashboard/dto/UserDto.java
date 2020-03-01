package com.globallogic.car.dashboard.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {

	private Long userId;
	private String userName;
	private List<CarDto> cars;
}

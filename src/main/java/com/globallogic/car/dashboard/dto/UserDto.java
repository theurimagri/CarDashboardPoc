package com.globallogic.car.dashboard.dto;

import java.util.List;

public class UserDto {

	private Long userId;
	private String userName;
	private List<CarDto> cars;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<CarDto> getCars() {
		return cars;
	}

	public void setCars(List<CarDto> carsDto) {
		this.cars = carsDto;
	}
}

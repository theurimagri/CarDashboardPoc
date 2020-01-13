package com.globallogic.car.dashboard.dto;

public class DashboardConfigurationDto {

	private Long id;
	private UserDto userDto;
	private String file;
	private CarDto carDto;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public CarDto getCarDto() {
		return carDto;
	}

	public void setCarDto(CarDto carDto) {
		this.carDto = carDto;
	}
}

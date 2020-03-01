package com.globallogic.car.dashboard.dto;

import com.globallogic.car.dashboard.enums.CarType;

import lombok.Data;

@Data
public class CarDto {

	private Long carId;
	private String carModel;
	private CarType carType;
}

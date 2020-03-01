package com.globallogic.car.dashboard.dto;

import lombok.Data;

@Data
public class LayoutDto {

	private Long layoutId;
	private String layoutName;
	private CarDto car;
}

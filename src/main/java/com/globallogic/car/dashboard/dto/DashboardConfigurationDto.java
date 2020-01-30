package com.globallogic.car.dashboard.dto;

import java.time.ZonedDateTime;

public class DashboardConfigurationDto {

	private Long configurationId;
	private Long userId;
	private String file;
	private Long carId;
	private ZonedDateTime createAt;
	private ZonedDateTime updateAt;

	public Long getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(Long configurationId) {
		this.configurationId = configurationId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public ZonedDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(ZonedDateTime createAt) {
		this.createAt = createAt;
	}

	public ZonedDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(ZonedDateTime updateAt) {
		this.updateAt = updateAt;
	}
}

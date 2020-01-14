package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "DASHBOARD_CONFIG")
public class DashboardConfiguration {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CONFIG_ID", updatable = false, nullable = false)
	private Long configurationId;
	
	@Column(name="USER_ID", nullable = false)
	private Long userId;
	
	@Lob
	@Column(name = "CONFIG_FILE", nullable = false)
	private String file;
	
	@Column(name="CAR_ID", nullable = false)
	private Long carId;
	
	public Long getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(Long configurationId) {
		this.configurationId = configurationId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
}

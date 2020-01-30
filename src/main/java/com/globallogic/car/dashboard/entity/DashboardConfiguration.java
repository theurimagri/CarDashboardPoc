package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "DASHBOARD_CONFIG", uniqueConstraints = @UniqueConstraint(columnNames = { "USER_ID", "CAR_ID" }))
@SequenceGenerator(name = "DASHBOARD_CONFIG_SEQ", sequenceName = "DASHBOARD_CONFIG_SEQ", allocationSize = 1)
public class DashboardConfiguration {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "DASHBOARD_CONFIG_SEQ")
	@Column(name = "CONFIG_ID", updatable = false, nullable = false)
	private Long configurationId;

	@Column(name = "USER_ID", nullable = false)
	private Long userId;

	@Lob
	@Column(name = "CONFIG_FILE", nullable = false)
	private String file;

	@Column(name = "CAR_ID", nullable = false)
	private Long carId;

	@Column(name = "CREATE_AT", nullable = false, columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private ZonedDateTime createAt;

	@Column(name = "UPDATE_AT", nullable = false, columnDefinition = "TIMESTAMP")
	@UpdateTimestamp
	private ZonedDateTime updateAt;

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

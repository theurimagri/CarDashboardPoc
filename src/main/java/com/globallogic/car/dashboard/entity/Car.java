package com.globallogic.car.dashboard.entity;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.globallogic.car.dashboard.enums.CarType;

@Entity
@Table(name = "CAR")
@SequenceGenerator(name = "CAR_SEQ", sequenceName = "CAR_SEQ", allocationSize = 1)
public class Car {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "CAR_SEQ")
	@Column(name = "CAR_ID", updatable = false, nullable = false)
	private Long carId;
	
	@Column(name = "CAR_MODEL", unique = true)
	private String carModel;

	@Column(name = "CAR_TYPE")
	@Enumerated(STRING)
	private CarType carType;
	
	@OneToMany
	@JoinColumn(name="CAR_ID")
	private Set<DashboardConfiguration> dashboardConfigurations;

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public Set<DashboardConfiguration> getDashboardConfigurations() {
		return dashboardConfigurations;
	}

	public void setDashboardConfigurations(Set<DashboardConfiguration> dashboardConfigurations) {
		this.dashboardConfigurations = dashboardConfigurations;
	}
	
}

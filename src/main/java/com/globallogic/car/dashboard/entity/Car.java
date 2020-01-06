package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CAR")
public class Car {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CAR_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "CAR_MODEL")
	private String model;
	
	@ManyToMany(mappedBy = "cars")
	private Set<User> users;
	
	@OneToMany(mappedBy="car")
	private Set<DashboardConfiguration> dashboardConfigurations;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<DashboardConfiguration> getDashboardConfigurations() {
		return dashboardConfigurations;
	}

	public void setDashboardConfigurations(Set<DashboardConfiguration> dashboardConfigurations) {
		this.dashboardConfigurations = dashboardConfigurations;
	}
	
}

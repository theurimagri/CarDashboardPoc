package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "USER")
public class User {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "USER_NAME", updatable = false, nullable = false)
	private String name;
	
	@OneToMany(mappedBy="user")
	private Set<DashboardConfiguration> dashboardConfigurations;

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "USER_CAR", 
        joinColumns = { @JoinColumn(name = "USER_ID") }, 
        inverseJoinColumns = { @JoinColumn(name = "CAR_ID") }
    )
	private List<Car> cars;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DashboardConfiguration> getDashboardConfigurations() {
		return dashboardConfigurations;
	}

	public void setCars(Set<DashboardConfiguration> dashboardConfigurations) {
		this.dashboardConfigurations = dashboardConfigurations;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public void setDashboardConfigurations(Set<DashboardConfiguration> dashboardConfigurations) {
		this.dashboardConfigurations = dashboardConfigurations;
	}
	
}

package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBlobType;

@Entity
@Table(name = "DASHBOARD_CONFIG")
@TypeDef(name = "jsonb", typeClass = JsonBlobType.class)
public class DashboardConfiguration {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CONFIG_ID", updatable = false, nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	@Type(type = "jsonb")
	@Column(name = "CONFIG_FILE", updatable = false, nullable = false)
	private String file;
	
	@ManyToOne
    @JoinColumn(name="CAR_ID", nullable=false)
	private Car car;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
}

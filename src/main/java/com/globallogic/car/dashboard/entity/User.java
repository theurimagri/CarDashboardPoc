package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
@Data
public class User {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "USER_SEQ")
	@Column(name = "USER_ID", updatable = false, nullable = false)
	private Long userId;

	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String userName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_CAR", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CAR_ID") })
	private List<Car> cars;
}

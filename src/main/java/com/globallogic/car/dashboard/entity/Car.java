package com.globallogic.car.dashboard.entity;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.globallogic.car.dashboard.enums.CarType;

import lombok.Data;

@Entity
@Table(name = "CAR")
@SequenceGenerator(name = "CAR_SEQ", sequenceName = "CAR_SEQ", allocationSize = 1)
@Data
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
}

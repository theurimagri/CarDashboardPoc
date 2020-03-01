package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LAYOUT")
@SequenceGenerator(name = "LAYOUT_SEQ", sequenceName = "LAYOUT_SEQ", allocationSize = 1)
@Data
public class Layout {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "LAYOUT_SEQ")
	@Column(name = "LAYOUT_ID", updatable = false, nullable = false)
	private Long layoutId;

	@Column(name = "LAYOUT_NAME", nullable = false, unique = true)
	private String layoutName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAR_ID", nullable = false, updatable = false, insertable = false)
	private Car car;
}

package com.globallogic.car.dashboard.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LAYOUT")
@SequenceGenerator(name = "LAYOUT_SEQ", sequenceName = "LAYOUT_SEQ", allocationSize = 1)
public class Layout {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "LAYOUT_SEQ")
	@Column(name = "LAYOUT_ID", updatable = false, nullable = false)
	private Long layoutId;

	@Column(name = "LAYOUT_NAME", nullable = false, unique = true)
	private String layoutName;

	public Long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Long layoutId) {
		this.layoutId = layoutId;
	}

	public String getLayoutName() {
		return layoutName;
	}

	public void setLayoutName(String layoutName) {
		this.layoutName = layoutName;
	}
}

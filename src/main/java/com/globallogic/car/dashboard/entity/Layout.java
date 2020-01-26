package com.globallogic.car.dashboard.entity;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LAYOUT")
@SequenceGenerator(initialValue = 50, name = "LAYOUT_SEQ", sequenceName = "LAYOUT_SEQ")
public class Layout {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "LAYOUT_SEQ")
	@Column(name = "LAYOUT_ID", updatable = false, nullable = false)
	private Long layoutId;

	@Column(name = "LAYOUT_NAME", nullable = false, unique = true)
	private String layoutName;

	@Column(name = "USER_ID", nullable = false)
	private Long userId;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	private User user;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

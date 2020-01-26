package com.globallogic.car.dashboard.service.spi;

import java.util.List;

import com.globallogic.car.dashboard.dto.LayoutDto;

public interface LayoutService {

	LayoutDto saveLayout(LayoutDto layoutDto);

	void updateLayout(LayoutDto layoutDto);

	List<LayoutDto> findByUserId(Long userId);

	void deleteLayout(Long layoutId, Long userId);
}

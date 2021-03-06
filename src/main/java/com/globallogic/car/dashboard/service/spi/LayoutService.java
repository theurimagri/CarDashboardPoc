package com.globallogic.car.dashboard.service.spi;

import java.util.List;

import com.globallogic.car.dashboard.dto.LayoutDto;

public interface LayoutService {

	LayoutDto saveLayout(LayoutDto layoutDto);

	void updateLayout(LayoutDto layoutDto);

	List<LayoutDto> findAll();
	
	List<LayoutDto> findByCarId(Long carId);

	LayoutDto findById(Long layoutId);
	
	byte[] getLayoutTemplatePreview(Long layoutId);

	LayoutDto findByName(String layoutName);

	void deleteLayout(Long layoutId);
	
	void deleteByCarId(Long carId);
}

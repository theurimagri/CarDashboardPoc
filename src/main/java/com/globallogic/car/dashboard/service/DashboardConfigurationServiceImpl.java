package com.globallogic.car.dashboard.service;

import static java.lang.String.format;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.entity.DashboardConfiguration;
import com.globallogic.car.dashboard.mapper.DashboardConfigurationMapper;
import com.globallogic.car.dashboard.repository.DashboardConfigurationRepository;
import com.globallogic.car.dashboard.service.spi.DashboardConfigurationService;

@Service
public class DashboardConfigurationServiceImpl implements DashboardConfigurationService {

	private final DashboardConfigurationRepository dashboardConfigurationRepository;
	private final DashboardConfigurationMapper dashboardConfigurationMapper;
	
	public DashboardConfigurationServiceImpl(DashboardConfigurationRepository dashboardConfigurationRepository, DashboardConfigurationMapper dashboardConfigurationMapper) {
		super();
		this.dashboardConfigurationRepository = dashboardConfigurationRepository;
		this.dashboardConfigurationMapper = dashboardConfigurationMapper;
	}
	
	@Override
	@Transactional
	public DashboardConfiguration createDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto) {
		return dashboardConfigurationRepository.save(dashboardConfigurationMapper.dashboardConfigurationDtoToDashboardConfiguration(dashboardConfigurationDto));
	}

	@Override
	@Transactional
	public void updateDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto) {
		DashboardConfiguration dashboardConfiguration = dashboardConfigurationRepository.findById(dashboardConfigurationDto.getConfigurationId())
				.orElseThrow(() -> new EntityNotFoundException(dashboardConfigurationDto.getConfigurationId().toString()));
		dashboardConfiguration.setFile(dashboardConfigurationDto.getFile());
		dashboardConfigurationRepository.save(dashboardConfiguration);
	}

	@Override
	public DashboardConfigurationDto findByUserIdAndCarId(Long userId, Long carId) {
		return dashboardConfigurationRepository.findDashboardConfigurationByUserIdAndCarId(userId, carId)
				.map(dashboardConfigurationMapper::dashboardConfigurationToDashboardConfigurationDto)
				.orElseThrow(() -> new EntityNotFoundException(format("Dashboard configuration not found for userId: %d and carId: %d.", userId, carId)));
	}
}

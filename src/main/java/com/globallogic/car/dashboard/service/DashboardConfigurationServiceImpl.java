package com.globallogic.car.dashboard.service;

import static java.util.stream.Collectors.toSet;

import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly = true)
	public Set<DashboardConfiguration> getAllDashboardConfigurations() {
		return StreamSupport
				.stream(dashboardConfigurationRepository.findAll().spliterator(), false)
			    .collect(toSet());
	}

	@Override
	@Transactional(readOnly = true)
	public DashboardConfiguration getDashboardConfigurationById(Long dashboardId) {
		return dashboardConfigurationRepository.findById(dashboardId).orElseThrow(() -> new EntityNotFoundException(dashboardId.toString()));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DashboardConfiguration> getDashboardConfigurationByUserAndCar(Long userId, Long carId) {
		return dashboardConfigurationRepository.findDashboardConfigurationByUserIdAndCarId(userId, carId);
	}

	@Override
	@Transactional
	public DashboardConfiguration createDashboardConfiguration(DashboardConfiguration dashboardConfiguration) {
		return dashboardConfigurationRepository.save(dashboardConfiguration);
	}

	@Override
	public void updateDashboardConfiguration(DashboardConfiguration dashboardConfiguration) {
		dashboardConfigurationRepository.save(dashboardConfiguration);
		
	}
	
	

}

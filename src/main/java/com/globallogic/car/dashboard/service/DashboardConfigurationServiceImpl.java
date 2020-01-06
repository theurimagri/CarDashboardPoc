package com.globallogic.car.dashboard.service;

import static java.util.stream.Collectors.toSet;

import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.globallogic.car.dashboard.entity.DashboardConfiguration;
import com.globallogic.car.dashboard.repository.DashboardConfigurationRepository;
import com.globallogic.car.dashboard.service.spi.DashboardConfigurationService;

@Service
public class DashboardConfigurationServiceImpl implements DashboardConfigurationService {

	private final DashboardConfigurationRepository dashboardConfigurationRepository;
	
	public DashboardConfigurationServiceImpl(DashboardConfigurationRepository dashboardConfigurationRepository) {
		super();
		this.dashboardConfigurationRepository = dashboardConfigurationRepository;
	}
	
	@Override
	public Set<DashboardConfiguration> getAllDashboardConfigurations() {
		return StreamSupport
				.stream(dashboardConfigurationRepository.findAll().spliterator(), false)
			    .collect(toSet());
	}

	@Override
	public DashboardConfiguration getDashboardConfigurationById(Long dashboardId) {
		return dashboardConfigurationRepository.findById(dashboardId).orElseThrow(() -> new EntityNotFoundException(dashboardId.toString()));
	}

	@Override
	public Optional<DashboardConfiguration> getDashboardConfigurationByUserAndCar(Long userId, Long carId) {
		return dashboardConfigurationRepository.findDashboardConfigurationByUserIdAndCarId(userId, carId);
	}

	@Override
	public DashboardConfiguration createDashboardConfiguration(DashboardConfiguration dashboardConfiguration) {
		return dashboardConfigurationRepository.save(dashboardConfiguration);
	}

}

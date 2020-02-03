package com.globallogic.car.dashboard.service;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.entity.DashboardConfiguration;
import com.globallogic.car.dashboard.entity.User;
import com.globallogic.car.dashboard.mapper.DashboardConfigurationMapper;
import com.globallogic.car.dashboard.repository.DashboardConfigurationRepository;
import com.globallogic.car.dashboard.repository.UserRepository;
import com.globallogic.car.dashboard.service.spi.DashboardConfigurationService;

@Service
public class DashboardConfigurationServiceImpl implements DashboardConfigurationService {

	private final DashboardConfigurationRepository dashboardConfigurationRepository;
	private final UserRepository userRepository;
	private final DashboardConfigurationMapper dashboardConfigurationMapper;
	
	public DashboardConfigurationServiceImpl(DashboardConfigurationRepository dashboardConfigurationRepository, UserRepository userRepository, DashboardConfigurationMapper dashboardConfigurationMapper) {
		this.dashboardConfigurationRepository = dashboardConfigurationRepository;
		this.dashboardConfigurationMapper = dashboardConfigurationMapper;
		this.userRepository = userRepository;
	}
	
	@Override
	@Transactional
	public DashboardConfiguration createDashboardConfiguration(String userName, DashboardConfigurationDto dashboardConfigurationDto) {
		dashboardConfigurationDto.setUserId(getUserId(dashboardConfigurationDto.getUserId(), userName));
		return dashboardConfigurationRepository.save(dashboardConfigurationMapper.dashboardConfigurationDtoToDashboardConfiguration(dashboardConfigurationDto));
	}

	@Override
	@Transactional
	public void updateDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto) {
		DashboardConfiguration dashboardConfiguration = dashboardConfigurationRepository.findById(dashboardConfigurationDto.getConfigurationId())
				.orElseThrow(() -> new EntityNotFoundException("Dashboard configuration not found."));
		dashboardConfiguration.setFile(dashboardConfigurationDto.getFile());
		dashboardConfigurationRepository.save(dashboardConfiguration);
	}

	@Override
	public void updateDashboardConfigurationByUserAndCarId(final Long userId, final String userName, 
			final Long carId,final DashboardConfigurationDto dashboardConfigurationDto) {
		
		dashboardConfigurationRepository.findDashboardConfigurationByUserIdAndCarId(getUserId(userId, userName), carId)
			.map(DashboardConfiguration::getConfigurationId)
			.ifPresent(dashboardConfigurationDto::setConfigurationId);
		
		updateDashboardConfiguration(dashboardConfigurationDto);
	}

	@Override
	public DashboardConfigurationDto findByUserAndCarId(final Long userId, final String userName, final Long carId) {
		return dashboardConfigurationRepository.findDashboardConfigurationByUserIdAndCarId(getUserId(userId, userName), carId)
				.map(dashboardConfigurationMapper::dashboardConfigurationToDashboardConfigurationDto)
				.orElseThrow(() -> new EntityNotFoundException(format("Dashboard configuration not found for userId: %d and carId: %d.", userId, carId)));
	}

	@Override
	public void deleteDashboardConfiguration(Long configurationId) {
		dashboardConfigurationRepository
			.findById(configurationId)
			.ifPresent(config -> dashboardConfigurationRepository.deleteById(config.getConfigurationId()));
	}
	
	private Long getUserId(final Long userId, final String userName) {
		if (isNotBlank(userName) && userId == null) {
			return userRepository.findByUserName(userName)
					.map(User::getUserId)
					.orElseThrow(() -> new EntityNotFoundException(format("User [%s] not found.", userName)));
		}
		return userId;
	}
}

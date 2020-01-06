package com.globallogic.car.dashboard.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.car.dashboard.entity.DashboardConfiguration;

@Repository
public interface DashboardConfigurationRepository extends CrudRepository<DashboardConfiguration, Long> {

	Optional<DashboardConfiguration> findDashboardConfigurationByUserIdAndCarId(Long userId, Long carId);
}

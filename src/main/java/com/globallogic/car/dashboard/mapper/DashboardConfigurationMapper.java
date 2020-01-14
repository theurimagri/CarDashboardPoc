package com.globallogic.car.dashboard.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.entity.DashboardConfiguration;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface DashboardConfigurationMapper {

	DashboardConfigurationDto dashboardConfigurationToDashboardConfigurationDto(DashboardConfiguration dashboardConfiguration);
    
    DashboardConfiguration dashboardConfigurationDtoToDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto);
    
}

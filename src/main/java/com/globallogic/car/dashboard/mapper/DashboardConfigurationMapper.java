package com.globallogic.car.dashboard.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.globallogic.car.dashboard.dto.DashboardConfigurationDto;
import com.globallogic.car.dashboard.entity.DashboardConfiguration;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface DashboardConfigurationMapper {

	@Mappings({ 
        @Mapping(source = "user", target = "userDto"), 
        @Mapping(source = "car", target = "carDto")
    })
	DashboardConfigurationDto dashboardConfigurationToDashboardConfigurationDto(DashboardConfiguration dashboardConfiguration);
    
	@Mappings({ 
        @Mapping(source = "userDto", target = "user"), 
        @Mapping(source = "carDto", target = "car")
    })
    DashboardConfiguration dashboardConfigurationDtoToDashboardConfiguration(DashboardConfigurationDto dashboardConfigurationDto);
    
}

package com.globallogic.car.dashboard.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.globallogic.car.dashboard.dto.CarDto;
import com.globallogic.car.dashboard.entity.Car;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface CarMapper {

	@Mappings({ 
        @Mapping(source = "users", target = "usersDto"), 
        @Mapping(source = "dashboardConfigurations", target = "dashboardConfigurationsDto")
    })
	CarDto carToCarDto(Car car);

	@Mappings({ 
        @Mapping(source = "dashboardConfigurationsDto", target = "dashboardConfigurations"), 
        @Mapping(source = "usersDto", target = "users")
    })
	Car carDtoToCar(CarDto carDto);
	
}

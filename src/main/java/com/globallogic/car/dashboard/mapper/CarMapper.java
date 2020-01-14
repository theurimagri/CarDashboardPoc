package com.globallogic.car.dashboard.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;

import com.globallogic.car.dashboard.dto.CarDto;
import com.globallogic.car.dashboard.entity.Car;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface CarMapper {

	CarDto carToCarDto(Car car);

	Car carDtoToCar(CarDto carDto);
	
}

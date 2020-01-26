package com.globallogic.car.dashboard.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;

import com.globallogic.car.dashboard.dto.LayoutDto;
import com.globallogic.car.dashboard.entity.Layout;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface LayoutMapper {

	LayoutDto layoutToLayoutDto(Layout layout);

	Layout layoutDtoToLayout(LayoutDto layoutDto);

}

package com.globallogic.car.dashboard.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.globallogic.car.dashboard.dto.UserDto;
import com.globallogic.car.dashboard.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface UserMapper {

	@Mappings({ 
        @Mapping(source = "dashboardConfigurations", target = "dashboardConfigurationsDto"), 
        @Mapping(source = "cars", target = "carsDto")
    })
	UserDto userToUserDto(User user);

	@Mappings({ 
        @Mapping(source = "dashboardConfigurationsDto", target = "dashboardConfigurations"), 
        @Mapping(source = "carsDto", target = "cars")
    })
	User userDtoToUser(UserDto userDto);

}

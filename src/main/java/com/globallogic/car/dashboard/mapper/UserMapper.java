package com.globallogic.car.dashboard.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;

import com.globallogic.car.dashboard.dto.UserDto;
import com.globallogic.car.dashboard.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface UserMapper {

	UserDto userToUserDto(User user);

	User userDtoToUser(UserDto userDto);

}
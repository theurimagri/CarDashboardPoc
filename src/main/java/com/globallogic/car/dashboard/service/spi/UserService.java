package com.globallogic.car.dashboard.service.spi;

import java.util.Set;

import com.globallogic.car.dashboard.dto.UserDto;

public interface UserService {

	Set<UserDto> getAllUsers();
	
	UserDto getUserById(Long userId);
}

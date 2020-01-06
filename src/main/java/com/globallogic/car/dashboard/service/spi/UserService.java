package com.globallogic.car.dashboard.service.spi;

import java.util.Set;

import com.globallogic.car.dashboard.entity.User;

public interface UserService {

	Set<User> getAllUsers();
	
	User getUserById(Long userId);
	
	void createUser(User user);
}

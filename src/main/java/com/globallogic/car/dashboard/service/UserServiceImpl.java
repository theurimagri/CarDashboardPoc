package com.globallogic.car.dashboard.service;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.globallogic.car.dashboard.entity.User;
import com.globallogic.car.dashboard.repository.UserRepository;
import com.globallogic.car.dashboard.service.spi.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public Set<User> getAllUsers() {
		return StreamSupport
				.stream(userRepository.findAll().spliterator(), false)
			    .collect(toSet());
	}

	@Override
	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(userId.toString()));
	}

	@Override
	public void createUser(User user) {
		userRepository.save(user);
	}

}

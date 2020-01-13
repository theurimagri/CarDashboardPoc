package com.globallogic.car.dashboard.service;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.car.dashboard.entity.User;
import com.globallogic.car.dashboard.mapper.UserMapper;
import com.globallogic.car.dashboard.repository.UserRepository;
import com.globallogic.car.dashboard.service.spi.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Set<User> getAllUsers() {
		return StreamSupport
				.stream(userRepository.findAll().spliterator(), false)
				//.map(userMapper::userToUserDto)
			    .collect(toSet());
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(Long userId) {
		return userRepository.findById(userId)
				//.map(userMapper::userToUserDto)
				.orElseThrow(() -> new EntityNotFoundException(userId.toString()));
	}

	@Override
	@Transactional
	public void createUser(User user) {
		userRepository.save(user);
	}

}

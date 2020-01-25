package com.globallogic.car.dashboard.service;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.StreamSupport.stream;

import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.car.dashboard.dto.UserDto;
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
	public UserDto saveUser(UserDto userDto) {
		final User user = userMapper.userDtoToUser(userDto);
		return of(userRepository.save(user))
				.map(userMapper::userToUserDto)
				.orElseThrow(() -> new PersistenceException());
	}

	@Override
	@Transactional(readOnly = true)
	public Set<UserDto> getAllUsers() {
		return stream(userRepository.findAll().spliterator(), false)
				.map(userMapper::userToUserDto)
				.collect(toSet());
	}

	@Override
	@Transactional(readOnly = true)
	public UserDto getUserById(Long userId) {
		return userRepository.findById(userId)
				.map(userMapper::userToUserDto)
				.orElseThrow(() -> new EntityNotFoundException(userId.toString()));
	}
}

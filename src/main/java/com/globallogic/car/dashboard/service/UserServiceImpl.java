package com.globallogic.car.dashboard.service;

import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.StreamSupport.stream;
import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.car.dashboard.dto.UserDto;
import com.globallogic.car.dashboard.entity.Car;
import com.globallogic.car.dashboard.entity.User;
import com.globallogic.car.dashboard.mapper.UserMapper;
import com.globallogic.car.dashboard.repository.CarRepository;
import com.globallogic.car.dashboard.repository.UserRepository;
import com.globallogic.car.dashboard.service.spi.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final CarRepository carRepository;

	public UserServiceImpl(final UserRepository userRepository, 
			  			   final UserMapper userMapper, 
			  			   final CarRepository carRepository) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.carRepository = carRepository;
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		final User user = userMapper.userDtoToUser(userDto);
		user.setCars(getCars(user));
		
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
	
	@Override
	public void deleteUser(Long userId) {
		final User user = userRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException(userId.toString()));
		
		userRepository.delete(user);
	}
	
	private List<Car> getCars(final User user) {
		if (isNotEmpty(user.getCars())) {
			return user.getCars()
					.stream()
					.map(this::getCar)
					.collect(toList());
		}
		
		return null;
	}
	
	private Car getCar(final Car car) {
		return of(car)
			.map(Car::getCarId)
			.flatMap(carRepository::findById)
			.orElseGet(() -> {
				car.setCarId(null);
				return car;
			});
	}
}

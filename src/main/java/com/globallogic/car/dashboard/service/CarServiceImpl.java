package com.globallogic.car.dashboard.service;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.car.dashboard.entity.Car;
import com.globallogic.car.dashboard.mapper.CarMapper;
import com.globallogic.car.dashboard.repository.CarRepository;
import com.globallogic.car.dashboard.service.spi.CarService;

@Service
public class CarServiceImpl implements CarService {

	private final CarRepository carRepository;
	private final CarMapper carMapper;
	
	public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
		super();
		this.carRepository = carRepository;
		this.carMapper = carMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public Set<Car> getAllCars() {
		return StreamSupport
				.stream(carRepository.findAll().spliterator(), false)
			    .collect(toSet());
	}

	@Override
	@Transactional(readOnly = true)
	public Set<Car> getAllCarsByUserId(Long userId) {
		return carRepository.findCarByUsersId(userId);
	}

	@Override
	@Transactional(readOnly = true)
	public Car getCarById(Long carId) {
		return carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException(carId.toString()));
	}

	@Override
	@Transactional
	public void createCar(Car car) {
		carRepository.save(car);
	}

}

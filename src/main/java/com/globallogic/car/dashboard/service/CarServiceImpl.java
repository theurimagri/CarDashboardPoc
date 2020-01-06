package com.globallogic.car.dashboard.service;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.globallogic.car.dashboard.entity.Car;
import com.globallogic.car.dashboard.repository.CarRepository;
import com.globallogic.car.dashboard.service.spi.CarService;

@Service
public class CarServiceImpl implements CarService {

	private final CarRepository carRepository;
	
	public CarServiceImpl(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}

	@Override
	public Set<Car> getAllCars() {
		return StreamSupport
				.stream(carRepository.findAll().spliterator(), false)
			    .collect(toSet());
	}

	@Override
	public Set<Car> getAllCarsByUserId(Long userId) {
		return carRepository.findCarByUsersId(userId);
	}

	@Override
	public Car getCarById(Long carId) {
		return carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException(carId.toString()));
	}

	@Override
	public void createCar(Car car) {
		carRepository.save(car);
	}

}

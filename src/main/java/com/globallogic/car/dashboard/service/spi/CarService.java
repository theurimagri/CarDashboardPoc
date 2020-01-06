package com.globallogic.car.dashboard.service.spi;

import java.util.Set;

import com.globallogic.car.dashboard.entity.Car;

public interface CarService {

	Set<Car> getAllCars();
	
	Set<Car> getAllCarsByUserId(Long userId);
	
	Car getCarById(Long carId);
	
	void createCar(Car car);
}

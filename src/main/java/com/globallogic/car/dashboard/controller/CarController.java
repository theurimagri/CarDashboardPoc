package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.car.dashboard.entity.Car;
import com.globallogic.car.dashboard.service.spi.CarService;

@RestController
public class CarController {
	
	private CarService carService;
	
	public CarController(CarService carService) {
		super();
		this.carService = carService;
	}

	@GetMapping(value = "/cars", produces = APPLICATION_JSON)
    private Set<Car> getAllCars() {
        return carService.getAllCars();
    }
}

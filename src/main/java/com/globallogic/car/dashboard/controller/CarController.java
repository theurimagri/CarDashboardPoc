package com.globallogic.car.dashboard.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.springframework.http.HttpStatus.OK;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

	@GetMapping(value = "/rest/cars", produces = APPLICATION_JSON)
    private ResponseEntity<Set<Car>> getCarsByUser(@RequestHeader("userId") Long userId) {
        return new ResponseEntity<>(carService.getAllCarsByUserId(userId), OK);
    }
}

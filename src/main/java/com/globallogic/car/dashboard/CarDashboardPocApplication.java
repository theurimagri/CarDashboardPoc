package com.globallogic.car.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.globallogic.car.dashboard.config.ApplicationConfiguration;
import com.globallogic.car.dashboard.config.DatabaseConfiguration;

@SpringBootApplication
@ComponentScan(basePackageClasses = {DatabaseConfiguration.class, ApplicationConfiguration.class})
public class CarDashboardPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDashboardPocApplication.class, args);
	}

}

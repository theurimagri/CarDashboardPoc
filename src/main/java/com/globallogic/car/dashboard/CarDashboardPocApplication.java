package com.globallogic.car.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import com.globallogic.car.dashboard.config.ApplicationConfiguration;
import com.globallogic.car.dashboard.config.DatabaseConfiguration;
import com.globallogic.car.dashboard.config.SecurityConfiguration;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackageClasses = {DatabaseConfiguration.class, ApplicationConfiguration.class, SecurityConfiguration.class})
public class CarDashboardPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarDashboardPocApplication.class, args);
	}

}
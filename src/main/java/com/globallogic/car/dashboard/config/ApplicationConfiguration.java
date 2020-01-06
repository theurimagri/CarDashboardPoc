package com.globallogic.car.dashboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.globallogic.car.dashboard.service", "com.globallogic.car.dashboard.controller"})
public class ApplicationConfiguration {
	
}

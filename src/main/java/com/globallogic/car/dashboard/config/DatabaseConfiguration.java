package com.globallogic.car.dashboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.globallogic.car.dashboard.entity", "com.globallogic.car.dashboard.repository"})
public class DatabaseConfiguration {
	
}

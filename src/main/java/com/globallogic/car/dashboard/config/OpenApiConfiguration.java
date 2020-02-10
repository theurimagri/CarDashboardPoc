package com.globallogic.car.dashboard.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfiguration {

	@Bean
	public OpenAPI customOpenAPI(@Value("${cardashboard.version}") String appVersion) {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearerScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")))
				.info(new Info().title("Car Dashoard").version(appVersion));
	}

	@Bean
	public GroupedOpenApi carDashboardApi() {
		String[] paths = { "/api/*/rest/**" };
		return GroupedOpenApi.builder().setGroup("dashboard").pathsToMatch(paths).build();
	}

	@Bean
	public GroupedOpenApi modelApi() {
		String[] paths = { "/api/*/stream/**" };
		String[] packagedToMatch = { "com.globallogic.car.dashboard.dto" };
		return GroupedOpenApi.builder().setGroup("stream").pathsToMatch(paths).packagesToScan(packagedToMatch).build();
	}

}

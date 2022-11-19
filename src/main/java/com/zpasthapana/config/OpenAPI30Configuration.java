package com.zpasthapana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPI30Configuration {

	@Bean
	public OpenAPI customizeOpenAPI() {
		return new OpenAPI().info(new Info().title("ZP API").version("1.0").description("ZPA back end API")
								.license(new License().name("zpastapana")));
	}
	
}
package com.zpasthapana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperConf {


	@Bean
	public ObjectMapper getObject() {
		return new ObjectMapper();
	}
}

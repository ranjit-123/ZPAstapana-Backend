package com.zpasthapana.util;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MasterDropDownQueryUtil {

	Map<String, String> masterQuery = new HashMap<>();

	@PostConstruct
	public void setUpQuery() {
		masterQuery.put("", "");
	}

	public String getQuery(String masterKey) {
		return masterQuery.get(masterKey);
	}
}

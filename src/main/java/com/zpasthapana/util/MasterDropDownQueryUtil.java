package com.zpasthapana.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import com.zpasthapana.pojo.MasterQueries;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MasterDropDownQueryUtil {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	Map<String, String> masterQuery = new HashMap<>();

	@PostConstruct
	@Scheduled(fixedDelay = 1000 * 60 * 1)
	public void setUpQuery() {
		log.info("master queries loaded");
		List<MasterQueries> queries = jdbcTemplate.query("select type, query from tblmasterdropdownqueries", BeanPropertyRowMapper.newInstance(MasterQueries.class));
		for (MasterQueries masterQueries : queries) {
			masterQuery.put(masterQueries.getType(), masterQueries.getQuery());
		}
	}

	public String getQuery(String masterKey) {
		return masterQuery.get(masterKey);
	}

	public String getQuery(Map<String, String> queryParam) {
		String query = masterQuery.get(queryParam.get("type"));
		for (Entry<String, String> element : queryParam.entrySet()) {
			query = StringUtils.replace(query, "[" + element.getKey() + "]", element.getValue());
		}
		return query;
	}
}

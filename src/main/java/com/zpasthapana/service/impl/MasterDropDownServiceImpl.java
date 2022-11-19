package com.zpasthapana.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zpasthapana.pojo.MasterDropDownPojo;
import com.zpasthapana.service.MasterDropDownService;
import com.zpasthapana.util.MasterDropDownQueryUtil;

@Service
public class MasterDropDownServiceImpl implements MasterDropDownService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private MasterDropDownQueryUtil masterDropDownQueryUtil;

	@Override
	public List<MasterDropDownPojo> getDetails(String type, Integer id) {
		String query = masterDropDownQueryUtil.getQuery(type);
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(MasterDropDownPojo.class));
	}

	@Override
	public List<MasterDropDownPojo> getDetails(Map<String, String> queryParam) {
		String query = masterDropDownQueryUtil.getQuery(queryParam);
		return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(MasterDropDownPojo.class));
	}

}

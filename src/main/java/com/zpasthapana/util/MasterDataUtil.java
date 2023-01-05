package com.zpasthapana.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import com.zpasthapana.pojo.KeyData;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MasterDataUtil {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	static Map<String, String> masterData = new HashMap<>();

	@PostConstruct
	@Scheduled(fixedDelay = 1000 * 60 * 5)
	public void setUpQuery() {
		log.info("master data loaded");
		List<KeyData> date = jdbcTemplate.query("select divisionID as keyId, divisionName as keyName from tblDivision", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("division_" + keys.getKeyId(), keys.getKeyName());
		}
		
		date = jdbcTemplate.query("SELECT subDivisionID as keyId, subDivisionName as keyName FROM tblSubDivision", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("subdivision_" + keys.getKeyId(), keys.getKeyName());
		}
		
		date = jdbcTemplate.query("SELECT talukaID as keyId, talukaName as keyName FROM tblTaluka", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("taluka_" + keys.getKeyId(), keys.getKeyName());
		}
		
		date = jdbcTemplate.query("SELECT designationID as keyId, designationName as keyName FROM tblDesignation", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("designation_" + keys.getKeyId(), keys.getKeyName());
		}
		
		date = jdbcTemplate.query("SELECT casteCategoryID as keyId, casteCategoryName as keyName FROM tblCasteCategory", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("castecategory_" + keys.getKeyId(), keys.getKeyName());
		}
		
		date = jdbcTemplate.query("SELECT properOfficeID as keyId, properOfficeName as keyName FROM tblProperOffice", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("subdepartment_" + keys.getKeyId(), keys.getKeyName());
		}
		
		date = jdbcTemplate.query("SELECT payCommissionID as keyId, payCommissionName as keyName FROM tblPayCommission", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("paycommission_" + keys.getKeyId(), keys.getKeyName());
		}
		
		date = jdbcTemplate.query("SELECT departmentID as keyId, departmentName as keyName FROM tblDepartment", BeanPropertyRowMapper.newInstance(KeyData.class));
		for (KeyData keys : date) {
			masterData.put("department_" + keys.getKeyId(), keys.getKeyName());
		}
		
		masterData.put("niyuktitype_"+ 1, "सरळसेवा");
		masterData.put("niyuktitype_"+ 2, "पदौन्नती");
		masterData.put("niyuktitype_"+ 3, "स्पर्धा परिक्षा");
	}


	public static String getKeyDate(String type, Long key) {
		return masterData.get(type + key);
	}
	
	public static String getKeyDate(String type, Integer key) {
		return masterData.get(type + key);
	}
	
	public static String getKeyDate(String type, String key) {
		return masterData.get(type + key);
	}
}
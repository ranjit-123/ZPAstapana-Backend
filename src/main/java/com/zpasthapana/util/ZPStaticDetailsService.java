package com.zpasthapana.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.User;
import com.zpasthapana.pojo.ZPBean;
import com.zpasthapana.pojo.ZPManjurPade;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ZPStaticDetailsService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	static Map<ZPBean, ZPManjurPade> zpManujurPade = new HashMap<>();
	
	public void loadManjurPade(User user) {
		log.info("majur pad data loaded");
		List<ZPManjurPade> date = jdbcTemplate.query("SELECT p.*, d.designationClassID FROM tblZillaParishadDesignation p inner join tblDesignation d on p.designationID = d.designationID where p.zillaParishadID = " + user.getZillaParishadID(), BeanPropertyRowMapper.newInstance(ZPManjurPade.class));
		for (ZPManjurPade d : date) {
			zpManujurPade.put(ZPBean.builder().designationId(d.getDesignationID()).zpId(d.getZillaParishadID()).build(), d);
		}
	}
	
	public Map<ZPBean, ZPManjurPade> getManjurPade() {
		return zpManujurPade;
	}
	
}

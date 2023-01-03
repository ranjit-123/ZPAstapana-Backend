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
	
	public Map<ZPBean, ZPManjurPade> loadManjurPade(User user) {
		log.info("majur pad data loaded");
		Map<ZPBean, ZPManjurPade> zpManujurPade = new HashMap<>();
		String query = "SELECT p.*, d.designationClassID FROM tblZillaParishadDesignation p inner join tblDesignation d on p.designationID = d.designationID where p.zillaParishadID = " + user.getZillaParishadID();
		
		if(user.getDepartmentID() > 0) {
			
		}
		
		List<ZPManjurPade> date = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ZPManjurPade.class));
		for (ZPManjurPade d : date) {
			zpManujurPade.put(ZPBean.builder().designationId(d.getDesignationID()).zpId(d.getZillaParishadID()).build(), d);
		}
		return zpManujurPade;
	}
	
	public Map<ZPBean, ZPManjurPade> loadDepartmentWisePade(User user) {
		Map<ZPBean, ZPManjurPade> zpManujurPadeDepartmentWise = new HashMap<>();
		List<ZPManjurPade> date = jdbcTemplate.query(
				"SELECT d.departmentID as departmentID, sum(straightforwardServiceApproved) as straightforwardServiceApproved, sum(examApproved) as examApproved, sum(promotionApproved) as promotionApproved, sum(straightForwardServiceApprovedTribal) as straightForwardServiceApprovedTribal, sum(straightForwardServiceApprovedTribalSC) as straightForwardServiceApprovedTribalSC, sum(straightForwardServiceApprovedTribalST) as straightForwardServiceApprovedTribalST, sum(straightForwardServiceApprovedTribalVJA) as straightForwardServiceApprovedTribalVJA, sum(straightForwardServiceApprovedTribalNTB) as straightForwardServiceApprovedTribalNTB, sum(straightForwardServiceApprovedTribalNTC) as straightForwardServiceApprovedTribalNTC, sum(straightForwardServiceApprovedTribalNTD) as straightForwardServiceApprovedTribalNTD, sum(straightForwardServiceApprovedTribalSBC) as straightForwardServiceApprovedTribalSBC, sum(straightForwardServiceApprovedTribalOBC) as straightForwardServiceApprovedTribalOBC, sum(straightForwardServiceApprovedTribalEWS) as straightForwardServiceApprovedTribalEWS, sum(straightForwardServiceApprovedTribalOpen) as straightForwardServiceApprovedTribalOpen, sum(straightForwardServiceApprovedNonTribal) as straightForwardServiceApprovedNonTribal, sum(straightForwardServiceApprovedNonTribalSC) as straightForwardServiceApprovedNonTribalSC, sum(straightForwardServiceApprovedNonTribalST) as straightForwardServiceApprovedNonTribalST, sum(straightForwardServiceApprovedNonTribalVJA) as straightForwardServiceApprovedNonTribalVJA, sum(straightForwardServiceApprovedNonTribalNTB) as straightForwardServiceApprovedNonTribalNTB, sum(straightForwardServiceApprovedNonTribalNTC) as straightForwardServiceApprovedNonTribalNTC, sum(straightForwardServiceApprovedNonTribalNTD) as straightForwardServiceApprovedNonTribalNTD, sum(straightForwardServiceApprovedNonTribalSBC) as straightForwardServiceApprovedNonTribalSBC, sum(straightForwardServiceApprovedNonTribalOBC) as straightForwardServiceApprovedNonTribalOBC, sum(straightForwardServiceApprovedNonTribalEWS) as straightForwardServiceApprovedNonTribalEWS, sum(straightForwardServiceApprovedNonTribalOpen) as straightForwardServiceApprovedNonTribalOpen, sum(examApprovedTribal) as examApprovedTribal, sum(examApprovedTribalSC) as examApprovedTribalSC, sum(examApprovedTribalST) as examApprovedTribalST, sum(examApprovedTribalVJA) as examApprovedTribalVJA, sum(examApprovedTribalNTB) as examApprovedTribalNTB, sum(examApprovedTribalNTC) as examApprovedTribalNTC, sum(examApprovedTribalNTD) as examApprovedTribalNTD, sum(examApprovedTribalSBC) as examApprovedTribalOBC, sum(examApprovedTribalOBC) as examApprovedTribalOBC, sum(examApprovedTribalEWS) as examApprovedTribalEWS, sum(examApprovedTribalOpen) as examApprovedTribalOpen, sum(examApprovedNonTribal) as examApprovedNonTribal, sum(examApprovedNonTribalSC) as examApprovedNonTribalSC, sum(examApprovedNonTribalST) as examApprovedNonTribalST, sum(examApprovedNonTribalVJA) as examApprovedNonTribalVJA, sum(examApprovedNonTribalNTB) as examApprovedNonTribalNTB, sum(examApprovedNonTribalNTC) as examApprovedNonTribalNTC, sum(examApprovedNonTribalNTD) as examApprovedNonTribalNTD, sum(examApprovedNonTribalSBC) as examApprovedNonTribalSBC, sum(examApprovedNonTribalOBC) as examApprovedNonTribalOBC, sum(examApprovedNonTribalEWS) as examApprovedNonTribalEWS, sum(examApprovedNonTribalOpen) as examApprovedNonTribalOpen, sum(promotionApprovedTribal) as promotionApprovedTribal, sum(promotionApprovedTribalSC) as promotionApprovedTribalSC, sum(promotionApprovedTribalST) as promotionApprovedTribalST, sum(promotionApprovedTribalVJA) as promotionApprovedTribalVJA, sum(promotionApprovedTribalNTB) as promotionApprovedTribalNTB, sum(promotionApprovedTribalNTC) as promotionApprovedTribalNTC, sum(promotionApprovedTribalNTD) as promotionApprovedTribalNTD, sum(promotionApprovedTribalSBC) as promotionApprovedTribalSBC, sum(promotionApprovedTribalOBC) as promotionApprovedTribalOBC, sum(promotionApprovedTribalEWS) as promotionApprovedTribalEWS, sum(promotionApprovedTribalOpen) as promotionApprovedTribalOpen, sum(promotionApprovedNonTribal) as promotionApprovedNonTribal, sum(promotionApprovedNonTribalSC) as promotionApprovedNonTribalSC, sum(promotionApprovedNonTribalST) as promotionApprovedNonTribalST, sum(promotionApprovedNonTribalVJA) as promotionApprovedNonTribalVJA, sum(promotionApprovedNonTribalNTB) as promotionApprovedNonTribalNTB, sum(promotionApprovedNonTribalNTC) as promotionApprovedNonTribalNTC, sum(promotionApprovedNonTribalNTD) as promotionApprovedNonTribalNTD, sum(promotionApprovedNonTribalSBC) as promotionApprovedNonTribalSBC, sum(promotionApprovedNonTribalOBC) as promotionApprovedNonTribalOBC, sum(promotionApprovedNonTribalEWS) as promotionApprovedNonTribalEWS, sum(promotionApprovedNonTribalOpen) as promotionApprovedNonTribalOpen, sum(straightforwardServiceApprovedDisability) as straightforwardServiceApprovedDisability, sum(examApprovedDisability) as examApprovedDisability, sum(promotionApprovedDisability) as promotionApprovedDisability, sum(straightForwardServiceApprovedDisabilityTribal) as straightForwardServiceApprovedDisabilityTribal, sum(straightForwardServiceApprovedDisabilityNonTribal) as straightForwardServiceApprovedDisabilityNonTribal, sum(examApprovedDisabilityTribal) as examApprovedDisabilityTribal, sum(examApprovedDisabilityNonTribal) as examApprovedDisabilityNonTribal, sum(promotionApprovedDisabilityTribal) as promotionApprovedDisabilityTribal, sum(promotionApprovedDisabilityNonTribal) as promotionApprovedDisabilityNonTribal\r\n"
						+ "		FROM tblZillaParishadDesignation p inner join tblDesignation d on p.designationID = d.designationID where p.zillaParishadID = "+ user.getZillaParishadID() +" group by d.departmentID",
				BeanPropertyRowMapper.newInstance(ZPManjurPade.class));
		for (ZPManjurPade d : date) {
			zpManujurPadeDepartmentWise.put(ZPBean.builder().designationId(d.getDesignationID()).zpId(d.getZillaParishadID()).build(),
					d);
		}
		return zpManujurPadeDepartmentWise;
	}
}

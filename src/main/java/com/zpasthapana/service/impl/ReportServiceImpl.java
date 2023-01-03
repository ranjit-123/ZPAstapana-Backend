package com.zpasthapana.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.User;
import com.zpasthapana.pojo.DataThreeInteger;
import com.zpasthapana.pojo.ZPBean;
import com.zpasthapana.pojo.ZPDesAndCategoryBean;
import com.zpasthapana.pojo.ZPMajurPadereport;
import com.zpasthapana.pojo.ZPMajurPadereportWrapper;
import com.zpasthapana.pojo.ZPManjurPade;
import com.zpasthapana.service.ReportService;
import com.zpasthapana.service.UserService;
import com.zpasthapana.util.MasterDataUtil;
import com.zpasthapana.util.ZPStaticDetailsService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	ZPStaticDetailsService zPStaticDetailsService;

	@Autowired
	UserService userService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ZPMajurPadereportWrapper getMajurPadeReport(Long userId) {
		List<ZPMajurPadereport> report = new ArrayList<ZPMajurPadereport>();
		List<ZPMajurPadereport> report4 = new ArrayList<ZPMajurPadereport>();
		User user = userService.findUserById(userId);
		Map<ZPBean, ZPManjurPade> manjurPade = zPStaticDetailsService.loadManjurPade(user);
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPade(user);
		Integer itemTotal3[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Integer itemTotal4[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Integer itemTotal[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (Entry<ZPBean, ZPManjurPade> zpMajurPade : manjurPade.entrySet()) {
			if (zpMajurPade.getValue().getDesignationClassID() == 1) {
				ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(zpMajurPade.getValue().getDesignationID())
						.padName(MasterDataUtil.getKeyDate("designation_", zpMajurPade.getValue().getDesignationID()))
						.build();
				rep.setItem(setItems(rep.getItem(), zpMajurPade.getValue(), zpMajurPade.getKey(), bharaleliPad,
						itemTotal3));
				report.add(rep);
			} else {
				ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(zpMajurPade.getValue().getDesignationID())
						.padName(MasterDataUtil.getKeyDate("designation_", zpMajurPade.getValue().getDesignationID()))
						.build();
				rep.setItem(setItems(rep.getItem(), zpMajurPade.getValue(), zpMajurPade.getKey(), bharaleliPad,
						itemTotal4));
				report4.add(rep);
			}
		}
		ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(900).padName("एकुण वर्ग ३").build();
		rep.setItem(itemTotal3);
		report.add(rep);
		ZPMajurPadereport rep4 = ZPMajurPadereport.builder().pad(900).padName("एकुण वर्ग ४").build();
		rep4.setItem(itemTotal4);
		report4.add(rep4);
		Collections.sort(report);
		Collections.sort(report4);

		for (int i = 0; i < 12; i++) {
			itemTotal[i] = itemTotal3[i] + itemTotal4[i];
		}
		ZPMajurPadereport total = ZPMajurPadereport.builder().pad(900).padName("एकुण (वर्ग ३ + वर्ग ४)").build();
		total.setItem(itemTotal);

		return ZPMajurPadereportWrapper.builder().varg3(report).varg4(report4).total(total).build();
	}
	
	@Override
	public List<ZPMajurPadereport> getMajurPadeDepartMentWiseReport(Long userId) {
		List<ZPMajurPadereport> report = new ArrayList<ZPMajurPadereport>();
		User user = userService.findUserById(userId);
		Map<ZPBean, ZPManjurPade> manjurPade = zPStaticDetailsService.loadDepartmentWisePade(user);
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPadeDepartment(user);
		Integer itemTotal[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (Entry<ZPBean, ZPManjurPade> zpMajurPade : manjurPade.entrySet()) {
			ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(zpMajurPade.getValue().getDepartmentID())
					.padName(MasterDataUtil.getKeyDate("department_", zpMajurPade.getValue().getDepartmentID()))
					.build();
			rep.setItem(
					setItems(rep.getItem(), zpMajurPade.getValue(), zpMajurPade.getKey(), bharaleliPad, itemTotal));
			report.add(rep);
		}
		ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(900).padName("एकुण").build();
		rep.setItem(itemTotal);
		report.add(rep);
		return report;
	}

	private Integer[] setItems(Integer[] item, ZPManjurPade value, ZPBean zpBean,
			Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad, Integer[] itemTotal) {

		item[0] = value.getStraightforwardServiceApproved();
		item[1] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(1).designationId(value.getDepartmentID()).build(),
				DataThreeInteger.builder().val3(0).build()).getVal3();
		item[2] = item[0] - item[1];

		item[3] = value.getExamApproved();
		item[4] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(3).designationId(value.getDepartmentID()).build(),
				DataThreeInteger.builder().val3(0).build()).getVal3();
		item[5] = item[3] - item[4];

		item[6] = value.getPromotionApproved();
		item[7] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(2).designationId(value.getDepartmentID()).build(),
				DataThreeInteger.builder().val3(0).build()).getVal3();
		item[8] = item[6] - item[7];

		item[9] = item[0] + item[3] + item[6];
		item[10] = item[1] + item[4] + item[7];
		item[11] = item[2] + item[5] + item[8];

		for (int i = 0; i < 12; i++) {
			itemTotal[i] = itemTotal[i] + item[i];
		}

		return item;
	}

	public Map<ZPDesAndCategoryBean, DataThreeInteger> loadFilledPade(User user) {
		List<DataThreeInteger> data = jdbcTemplate.query(
				"SELECT ee.employeeDesiganationId as val1, ed.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
						+ "inner join employee_designation_details ee on e.employee_id = ee.employeeId\r\n"
						+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
						+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
						+ "where ew.zpId = " + user.getZillaParishadID()
						+ " group by ed.employeeselectioncategory, ee.employeeDesiganationId",
				BeanPropertyRowMapper.newInstance(DataThreeInteger.class));

		Map<ZPDesAndCategoryBean, DataThreeInteger> result = new HashMap<>();
		for (DataThreeInteger dataThreeInteger : data) {
			result.put(ZPDesAndCategoryBean.builder().categoryId(dataThreeInteger.getVal2())
					.designationId(dataThreeInteger.getVal1()).build(), dataThreeInteger);
		}
		return result;
	}
	
	public Map<ZPDesAndCategoryBean, DataThreeInteger> loadFilledPadeDepartment(User user) {
		List<DataThreeInteger> data = jdbcTemplate.query(
				"SELECT ew.departmentId as val1, ed.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
						+ "inner join employee_designation_details ee on e.employee_id = ee.employeeId\r\n"
						+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
						+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
						+ "where ew.zpId = " + user.getZillaParishadID()
						+ " group by ed.employeeselectioncategory, ew.departmentId",
				BeanPropertyRowMapper.newInstance(DataThreeInteger.class));

		Map<ZPDesAndCategoryBean, DataThreeInteger> result = new HashMap<>();
		for (DataThreeInteger dataThreeInteger : data) {
			result.put(ZPDesAndCategoryBean.builder().categoryId(dataThreeInteger.getVal2())
					.designationId(dataThreeInteger.getVal1()).build(), dataThreeInteger);
		}
		return result;
	}

}

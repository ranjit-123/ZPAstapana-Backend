package com.zpasthapana.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.User;
import com.zpasthapana.pojo.BinduNamavaliReport;
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
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPade(user, false);
		return getManjurBharaleliPadReport(report, report4, manjurPade, bharaleliPad, false);
	}

	@Override
	public List<ZPMajurPadereport> getMajurPadeDepartMentWiseReport(Long userId) {
		List<ZPMajurPadereport> report = new ArrayList<ZPMajurPadereport>();
		User user = userService.findUserById(userId);
		Map<ZPBean, ZPManjurPade> manjurPade = zPStaticDetailsService.loadDepartmentWisePade(user);
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPadeDepartment(user, false);
		Integer itemTotal[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (Entry<ZPBean, ZPManjurPade> zpMajurPade : manjurPade.entrySet()) {
			ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(zpMajurPade.getValue().getDepartmentID())
					.padName(MasterDataUtil.getKeyDate("department_", zpMajurPade.getValue().getDepartmentID()))
					.build();
			rep.setItem(
					setItems(rep.getItem(), zpMajurPade.getValue(), zpMajurPade.getKey(), bharaleliPad, itemTotal, false));
			report.add(rep);
		}
		ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(900).padName("एकुण").build();
		rep.setItem(itemTotal);
		report.add(rep);
		return report;
	}

	public Map<ZPDesAndCategoryBean, DataThreeInteger> loadFilledPade(User user, boolean b) {
		
		String query = "SELECT ee.employeeDesiganationId as val1, ed.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
				+ "inner join employee_designation_details ee on e.employee_id = ee.employeeId\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "where ew.zpId = " + user.getZillaParishadID();
		
		if(b) {
			query = query + " and ee.parallelReservationType = 7";
		}
		
		query = query + " group by ed.employeeselectioncategory, ee.employeeDesiganationId";
		
		List<DataThreeInteger> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(DataThreeInteger.class));

		Map<ZPDesAndCategoryBean, DataThreeInteger> result = new HashMap<>();
		for (DataThreeInteger dataThreeInteger : data) {
			result.put(ZPDesAndCategoryBean.builder().categoryId(dataThreeInteger.getVal2())
					.designationId(dataThreeInteger.getVal1()).build(), dataThreeInteger);
		}
		return result;
	}
	
	public Map<ZPDesAndCategoryBean, DataThreeInteger> loadFilledPade(User user, Long departmentId, boolean b) {
		
		String query = "SELECT ee.employeeDesiganationId as val1, ed.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
				+ "inner join employee_designation_details ee on e.employee_id = ee.employeeId\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "where ew.zpId = " + user.getZillaParishadID() + " and ew.departmentId = " + departmentId;
		
		if(b) {
			query = query + " and ee.parallelReservationType = 7";
		}
		
		query = query + " group by ed.employeeselectioncategory, ee.employeeDesiganationId";
		
		List<DataThreeInteger> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(DataThreeInteger.class));

		Map<ZPDesAndCategoryBean, DataThreeInteger> result = new HashMap<>();
		for (DataThreeInteger dataThreeInteger : data) {
			result.put(ZPDesAndCategoryBean.builder().categoryId(dataThreeInteger.getVal2())
					.designationId(dataThreeInteger.getVal1()).build(), dataThreeInteger);
		}
		return result;
	}
	
	public Map<ZPDesAndCategoryBean, DataThreeInteger> loadFilledPadeDepartment(User user, boolean b) {
		String query = "SELECT ew.departmentId as val1, ed.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
				+ "inner join employee_designation_details ee on e.employee_id = ee.employeeId\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "where ew.zpId = " + user.getZillaParishadID();
		
		if(b) {
			query = query + " and ee.parallelReservationType = 7";
		}
		
		query = query + " group by ed.employeeselectioncategory, ew.departmentId";
		List<DataThreeInteger> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(DataThreeInteger.class));

		Map<ZPDesAndCategoryBean, DataThreeInteger> result = new HashMap<>();
		for (DataThreeInteger dataThreeInteger : data) {
			result.put(ZPDesAndCategoryBean.builder().categoryId(dataThreeInteger.getVal2())
					.designationId(dataThreeInteger.getVal1()).build(), dataThreeInteger);
		}
		return result;
	}

	@Override
	public ZPMajurPadereportWrapper getMajurPadeReportByDepartMentId(Long userId, Long departmentId) {
		List<ZPMajurPadereport> report = new ArrayList<ZPMajurPadereport>();
		List<ZPMajurPadereport> report4 = new ArrayList<ZPMajurPadereport>();
		User user = userService.findUserById(userId);
		Map<ZPBean, ZPManjurPade> manjurPade = zPStaticDetailsService.loadManjurPadeForDepartment(user, departmentId);
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPade(user, departmentId, false);
		return getManjurBharaleliPadReport(report, report4, manjurPade, bharaleliPad, false);
	}

	@Override
	public ZPMajurPadereportWrapper getMajurPadeReportHandicap(Long userId) {
		List<ZPMajurPadereport> report = new ArrayList<ZPMajurPadereport>();
		List<ZPMajurPadereport> report4 = new ArrayList<ZPMajurPadereport>();
		User user = userService.findUserById(userId);
		Map<ZPBean, ZPManjurPade> manjurPade = zPStaticDetailsService.loadManjurPade(user);
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPade(user, true);
		return getManjurBharaleliPadReport(report, report4, manjurPade, bharaleliPad, true);
	}

	@Override
	public ZPMajurPadereportWrapper getMajurPadeReportByDepartMentIdHandicap(Long userId, Long departmentId) {
		List<ZPMajurPadereport> report = new ArrayList<ZPMajurPadereport>();
		List<ZPMajurPadereport> report4 = new ArrayList<ZPMajurPadereport>();
		User user = userService.findUserById(userId);
		Map<ZPBean, ZPManjurPade> manjurPade = zPStaticDetailsService.loadManjurPadeForDepartment(user, departmentId);
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPade(user, departmentId, true);
		return getManjurBharaleliPadReport(report, report4, manjurPade, bharaleliPad, true);
	}

	@Override
	public List<ZPMajurPadereport> getMajurPadeDepartMentWiseReportHandicap(Long userId) {
		List<ZPMajurPadereport> report = new ArrayList<ZPMajurPadereport>();
		User user = userService.findUserById(userId);
		Map<ZPBean, ZPManjurPade> manjurPade = zPStaticDetailsService.loadDepartmentWisePade(user);
		Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad = loadFilledPadeDepartment(user, true);
		Integer itemTotal[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (Entry<ZPBean, ZPManjurPade> zpMajurPade : manjurPade.entrySet()) {
			ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(zpMajurPade.getValue().getDepartmentID())
					.padName(MasterDataUtil.getKeyDate("department_", zpMajurPade.getValue().getDepartmentID()))
					.build();
			rep.setItem(
					setItems(rep.getItem(), zpMajurPade.getValue(), zpMajurPade.getKey(), bharaleliPad, itemTotal, true));
			report.add(rep);
		}
		ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(900).padName("एकुण").build();
		rep.setItem(itemTotal);
		report.add(rep);
		return report;
	}
	
	private ZPMajurPadereportWrapper getManjurBharaleliPadReport(List<ZPMajurPadereport> report,
			List<ZPMajurPadereport> report4, Map<ZPBean, ZPManjurPade> manjurPade,
			Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad, boolean isHandicap) {
		Integer itemTotal3[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Integer itemTotal4[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Integer itemTotal[] = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		for (Entry<ZPBean, ZPManjurPade> zpMajurPade : manjurPade.entrySet()) {
			if (zpMajurPade.getValue().getDesignationClassID() == 1) {
				ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(zpMajurPade.getValue().getDesignationID())
						.padName(MasterDataUtil.getKeyDate("designation_", zpMajurPade.getValue().getDesignationID()))
						.build();
				rep.setItem(setItemsDesigNation(rep.getItem(), zpMajurPade.getValue(), zpMajurPade.getKey(), bharaleliPad,
						itemTotal3, isHandicap));
				report.add(rep);
			} else {
				ZPMajurPadereport rep = ZPMajurPadereport.builder().pad(zpMajurPade.getValue().getDesignationID())
						.padName(MasterDataUtil.getKeyDate("designation_", zpMajurPade.getValue().getDesignationID()))
						.build();
				rep.setItem(setItemsDesigNation(rep.getItem(), zpMajurPade.getValue(), zpMajurPade.getKey(), bharaleliPad,
						itemTotal4, isHandicap));
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

	private Integer[] setItems(Integer[] item, ZPManjurPade value, ZPBean zpBean,
			Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad, Integer[] itemTotal, boolean isHandicap) {

		item[0] = isHandicap ? value.getStraightforwardServiceApprovedDisability() : value.getStraightforwardServiceApproved();
		item[1] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(1).designationId(value.getDepartmentID()).build(),
				DataThreeInteger.builder().val3(0).build()).getVal3();
		item[2] = item[0] - item[1];

		item[3] = isHandicap ? value.getExamApprovedDisability() : value.getExamApproved();
		item[4] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(3).designationId(value.getDepartmentID()).build(),
				DataThreeInteger.builder().val3(0).build()).getVal3();
		item[5] = item[3] - item[4];

		item[6] = isHandicap ? value.getPromotionApprovedDisability() : value.getPromotionApproved();
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
	
	private Integer[] setItemsDesigNation(Integer[] item, ZPManjurPade value, ZPBean zpBean,
			Map<ZPDesAndCategoryBean, DataThreeInteger> bharaleliPad, Integer[] itemTotal, boolean isHandicap) {

		item[0] = isHandicap ? value.getStraightforwardServiceApprovedDisability() : value.getStraightforwardServiceApproved();
		item[1] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(1).designationId(zpBean.getDesignationId()).build(),
				DataThreeInteger.builder().val3(0).build()).getVal3();
		item[2] = item[0] - item[1];

		item[3] = isHandicap ? value.getExamApprovedDisability() : value.getExamApproved();
		item[4] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(3).designationId(zpBean.getDesignationId()).build(),
				DataThreeInteger.builder().val3(0).build()).getVal3();
		item[5] = item[3] - item[4];

		item[6] = isHandicap ? value.getPromotionApprovedDisability() : value.getPromotionApproved();
		item[7] = bharaleliPad.getOrDefault(
				ZPDesAndCategoryBean.builder().categoryId(2).designationId(zpBean.getDesignationId()).build(),
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

	@Override
	public List<BinduNamavaliReport> getBindunamavaliReport(Long userId, String type) {
		User user = userService.findUserById(userId);
		String query = "SELECT YEAR(edm.dateOfAppointed) as bharatiVarsh, '' as kramank, '' as arakshan, \r\n"
				+ " concat(e.firstName , ' ' , e.middleName , ' ' , e.lastName) as name, \r\n"
				+ "    ec.caste as jat, ec.castecategory as jatichaPravarg, ec.appointmentCasteCategoryID as nemnukichaPravarg, \r\n"
				+ "    ifnull(ec.casteCertificateNumber,'') as jatPramanpatraKramank, ec.casteCertificateDate as jatPramanpatraDinak, \r\n"
				+ "    ifnull(ec.casteCertificatedIssuedOfficerName, '') as jatPramanpatraDenareAdhikari, ifnull(ec.casteValidityNumber,'') as jatVaidhataKramank, \r\n"
				+ "    ifnull(ec.casteValidityDate, '') as jatVaidhataDinak, ifnull(ec.casteValidityCommitteeName,'') as jatVaidhataSamiti,\r\n"
				+ "    DAY(ed.dateOfAppointed) as niyuktichaDinank, MONTH(ed.dateOfAppointed) as niyuktichaMahina, \r\n"
				+ "    YEAR(ed.dateOfAppointed) as niyukticheVarsh,\r\n"
				+ "	DAY(edm.dateOfAppointed) as mulNiyuktichaDinank, MONTH(edm.dateOfAppointed) as mulNiyuktichaMahina, YEAR(edm.dateOfAppointed) as mulNiyukticheVarsh,\r\n"
				+ "	DAY(dateOfBirth) as janmDinank, MONTH(dateOfBirth) as janmMahina, YEAR(dateOfBirth) as janmVarsh,\r\n"
				+ "    ifnull(DAY(ifnull(empr.retirementDate, e.retirementDate)),'') as sevaNivrutDinank, \r\n"
				+ "    ifnull(MONTH(ifnull(empr.retirementDate, e.retirementDate)),'') as sevaNivrutMahina, ifnull(YEAR(ifnull(empr.retirementDate, e.retirementDate)), '') as sevaNivrutVarsh\r\n"
				+ "    ,ifnull(empr.retirementReason, '') as retirementReason FROM employee e inner join employee_designation_details ed \r\n"
				+ "on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId \r\n"
				+ "inner join (select employeeId, min(dateOfAppointed) as dateOfAppointed from employee_designation_details group by employeeId) edm\r\n"
				+ "on e.employee_id = edm.employeeId\r\n"
				+ "inner join employee_cast_details ec on e.employeeCastDetailsId = ec.employeeCastDetailsId\r\n"
				+ "inner join employee_worklocation ew on e.employee_id = ew.employeeId\r\n"
				+ "left join (select employeeId, max(retirementDate) as retirementDate from retierment group by employeeId) empr on e.employee_id = empr.employeeId "
				+ " where ew.zpId = " + user.getZillaParishadID();
		
		if(user.getDepartmentID() > 0) {
			query = query + " and ew.departmentId = " + user.getDepartmentID();
		}
		
		if(StringUtils.equalsIgnoreCase(type, "karayarat")) {
			query = query + " and (ifnull(empr.retirementDate, ifnull(e.retirementDate, CURDATE())) >= CURDATE())";
		} else if(StringUtils.equalsIgnoreCase(type, "nivrut")) {
			query = query + " and ifnull(empr.retirementDate, e.retirementDate) < CURDATE() ";
		} 
		
		List<BinduNamavaliReport> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(BinduNamavaliReport.class));

		return data;
	}
	
}

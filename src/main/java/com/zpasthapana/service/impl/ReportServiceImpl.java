package com.zpasthapana.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.User;
import com.zpasthapana.pojo.AbsenceReport;
import com.zpasthapana.pojo.BinduNamavaliReport;
import com.zpasthapana.pojo.DataThreeInteger;
import com.zpasthapana.pojo.JestatechaReport;
import com.zpasthapana.pojo.Report3055Response;
import com.zpasthapana.pojo.ReportData;
import com.zpasthapana.pojo.ReportGopaniyAhvalResponse;
import com.zpasthapana.pojo.ReportLanguageResponse;
import com.zpasthapana.pojo.ReportMattaDayitvaResponse;
import com.zpasthapana.pojo.ReportSanganakAhartaResponse;
import com.zpasthapana.pojo.ReportSevaNivrutDepartmentLevelResponse;
import com.zpasthapana.pojo.ReportSevaNivrutResponse;
import com.zpasthapana.pojo.ReportStayitvaReponse;
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
		
		String query = "SELECT ee.employeeDesiganationId as val1, ee.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "inner join employee_designation_details ee on e.employeeDesiganationDetailsId = ee.employeeDesiganationDetailsId\r\n"
				+ "where e.active = 1 and ew.zpId = " + user.getZillaParishadID();
		
		if(b) {
			query = query + " and ee.parallelReservationType = 7";
		}
		
		query = query + " group by ee.employeeselectioncategory, ee.employeeDesiganationId";
		
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
		
		String query = "SELECT ee.employeeDesiganationId as val1, ee.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "inner join employee_designation_details ee on e.employeeDesiganationDetailsId = ee.employeeDesiganationDetailsId\r\n"
				+ "where e.active = 1 and ew.zpId = " + user.getZillaParishadID() + " and ew.departmentId = " + departmentId;
		
		if(b) {
			query = query + " and ee.parallelReservationType = 7";
		}
		
		query = query + " group by ee.employeeselectioncategory, ee.employeeDesiganationId";
		
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
		String query = "SELECT ew.departmentId as val1, ee.employeeselectioncategory as val2, count(e.employee_id) as val3 FROM employee e\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "inner join employee_designation_details ee on ee.employeeDesiganationDetailsId = e.employeeDesiganationDetailsId\r\n"
				+ "where e.active = 1 and ew.zpId = " + user.getZillaParishadID();
		
		if(b) {
			query = query + " and ee.parallelReservationType = 7";
		}
		
		query = query + " group by ee.employeeselectioncategory, ew.departmentId";
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
	public List<BinduNamavaliReport> getBindunamavaliReport(Long userId, String type, Integer designationId) {
		User user = userService.findUserById(userId);
		String query = "SELECT distinct YEAR(edm.dateOfAppointed) as bharatiVarsh, '' as kramank, '' as arakshan, \r\n"
				+ " concat(e.firstName , ' ' , e.middleName , ' ' , e.lastName) as name, \r\n"
				+ "    ec.caste as jat, ec.castecategory as jatichaPravarg, ec.appointmentCasteCategoryID as nemnukichaPravarg, \r\n"
				+ "    ifnull(ec.casteCertificateNumber,'') as jatPramanpatraKramank, ec.casteCertificateDate as jatPramanpatraDinak, \r\n"
				+ "    ifnull(ec.casteCertificatedIssuedOfficerName, '') as jatPramanpatraDenareAdhikari, ifnull(ec.casteValidityNumber,'') as jatVaidhataKramank, \r\n"
				+ "    ifnull(ec.casteValidityDate, '') as jatVaidhataDinak, ifnull(ec.casteValidityCommitteeName,'') as jatVaidhataSamiti,\r\n"
				+ "    DAY(ed.dateOfAppointed) as niyuktichaDinank, MONTH(ed.dateOfAppointed) as niyuktichaMahina, \r\n"
				+ "    YEAR(ed.dateOfAppointed) as niyukticheVarsh, ed.dateOfAppointed as dateOfHumanitySeniority, ed.employeeDesiganationId as employeeDesiganationId, \r\n"
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
				+ "left join retierment empr on e.employee_id = empr.employeeId "
				+ " where e.active = 1 and ew.zpId = " + user.getZillaParishadID();
		
		if(user.getDepartmentID() > 0) {
			query = query + " and ew.departmentId = " + user.getDepartmentID();
		}
		
		if(StringUtils.equalsIgnoreCase(type, "karayarat")) {
			query = query + " and (ifnull(empr.retirementDate, ifnull(e.retirementDate, CURDATE())) >= CURDATE())";
		} else if(StringUtils.equalsIgnoreCase(type, "nivrut")) {
			query = query + " and ifnull(empr.retirementDate, e.retirementDate) < CURDATE() ";
		}
		
		if(ObjectUtils.isNotEmpty(designationId) && designationId > 0) {
			query = query + " and employeeDesiganationId = " + designationId;
		}
		
		List<BinduNamavaliReport> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(BinduNamavaliReport.class));

		return data;
	}
	
	@Override
	public List<JestatechaReport> getJestatechaReport(Long userId, String type, Integer designationId) {
		User user = userService.findUserById(userId);
		String query = "SELECT distinct '' as jeshtataNumber, \r\n"
				+ " concat(e.firstName , ' ' , e.middleName , ' ' , e.lastName) as name, \r\n"
				+ "    ec.caste as caste, ec.castecategory as mulJatPravarg, ec.appointmentCasteCategoryID as niyuktiPravarg, \r\n"
				+ "    '' as pravargChangeDate, dateOfBirth as birthDate, ed.dateOfAppointed as hallichaNiyuktDinank, employeeselectioncategory as niyuktichaMarg, ed.dateOfHumanitySeniority as jeshtataManivDate, \r\n"
				+ "    e.sevaDate as sevaPaveshottarPassDate\r\n"
				+ ", ifnull(ifnull(empr.retirementDate, e.retirementDate),'') as retirementDate"
				+ "    ,'' as prathamPadonnatiNiyuktiDate, '' as dvitiyaPadonnatiNiyuktiDate, '' as trutiyaPadonnatiNiyuktiDate, ifnull(eed.degreeName,'') as degreeName "
				+ " , edm.dateOfAppointed as prathamPadavarilDate, '' as remark FROM employee e inner join employee_designation_details ed \r\n"
				+ "on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId \r\n"
				+ "inner join (select employeeId, min(dateOfAppointed) as dateOfAppointed from employee_designation_details group by employeeId) edm\r\n"
				+ "on e.employee_id = edm.employeeId\r\n"
				+ "inner join employee_cast_details ec on e.employeeCastDetailsId = ec.employeeCastDetailsId\r\n"
				+ "inner join employee_worklocation ew on e.employee_id = ew.employeeId\r\n"
				+ "left join retierment empr on e.employee_id = empr.employeeId "
				+ "left join employee_education_details eed on eed.employeeId = e.employee_id "
				+ " where e.active = 1 and ew.zpId = " + user.getZillaParishadID();
		
		if(user.getDepartmentID() > 0) {
			query = query + " and ew.departmentId = " + user.getDepartmentID();
		}
		
		if(StringUtils.equalsIgnoreCase(type, "karayarat")) {
			query = query + " and (ifnull(empr.retirementDate, ifnull(e.retirementDate, CURDATE())) >= CURDATE())";
		} else if(StringUtils.equalsIgnoreCase(type, "nivrut")) {
			query = query + " and ifnull(empr.retirementDate, e.retirementDate) < CURDATE() ";
		} 
		
		if(ObjectUtils.isNotEmpty(designationId) && designationId > 0) {
			query = query + " and ed.employeeDesiganationId = " + designationId;
		}
		
		List<JestatechaReport> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(JestatechaReport.class));

		return data;
	}
	
	@Override
	public List<AbsenceReport> getUnAuthorisedAbsenceReport(Long userId, Integer departmentId) {
		User user = userService.findUserById(userId);
		String query = "SELECT distinct ew.departmentId as departmentName, concat(e.firstName , ' ' , e.middleName , ' ' , e.lastName) as employeName,\r\n"
				+ "					ed.employeeDesiganationId as designation, ifnull(empr.retirementDate, e.retirementDate) as retirementDate,\r\n"
				+ "					ew.taluka, timestampdiff(DAY, absenceStartDate, absenceEndDate) absencePeriod, accountEnquiryCase as actionTaken, isPresent\r\n"
				+ "                    , ifnull(ew.subDepartment, ew.subDivision) as officeName, '' as morethan6monthsCase FROM employee e inner join employee_designation_details ed \r\n"
				+ "				on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId \r\n"
				+ "				inner join (select employeeId, min(dateOfAppointed) as dateOfAppointed from employee_designation_details group by employeeId) edm\r\n"
				+ "				on e.employee_id = edm.employeeId\r\n"
				+ "				inner join employee_cast_details ec on e.employeeCastDetailsId = ec.employeeCastDetailsId\r\n"
				+ "				inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "                inner join unathorized_absence_period a on e.employee_id = a.employeeId\r\n"
				+ "				left join retierment empr on e.employee_id = empr.employeeId"
				+ " where e.active = 1 and ew.zpId = " + user.getZillaParishadID();
		
		if(user.getDepartmentID() > 0) {
			query = query + " and ew.departmentId = " + user.getDepartmentID();
		} else if(ObjectUtils.isNotEmpty(departmentId) && departmentId > 0) {
			query = query + " and ew.departmentId = " + departmentId;
		}
		
		
		List<AbsenceReport> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(AbsenceReport.class));

		return data;
	}

	@Override
	public List<ReportData> getUnAuthorisedAbsenceReport1(Long userId, Integer departmentId) {
		User user = userService.findUserById(userId);
		String query = "SELECT distinct ew.departmentId as departmentName, concat(e.firstName , ' ' , e.middleName , ' ' , e.lastName) as employeName,\r\n"
				+ "					ed.employeeDesiganationId as designation, ifnull(empr.retirementDate, e.retirementDate) as retirementDate,\r\n"
				+ "					ew.taluka, timestampdiff(DAY, absenceStartDate, absenceEndDate) absencePeriod, accountEnquiryCase as actionTaken, isPresent\r\n"
				+ "                    , ifnull(ew.subDepartment, ew.subDivision) as officeName, '' as morethan6monthsCase FROM employee e inner join employee_designation_details ed \r\n"
				+ "				on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId \r\n"
				+ "				inner join (select employeeId, min(dateOfAppointed) as dateOfAppointed from employee_designation_details group by employeeId) edm\r\n"
				+ "				on e.employee_id = edm.employeeId\r\n"
				+ "				inner join employee_cast_details ec on e.employeeCastDetailsId = ec.employeeCastDetailsId\r\n"
				+ "				inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "                inner join unathorized_absence_period a on e.employee_id = a.employeeId\r\n"
				+ "				left join retierment empr on e.employee_id = empr.employeeId"
				+ " where e.active = 1 and ew.zpId = " + user.getZillaParishadID();
		
		if(user.getDepartmentID() > 0) {
			query = query + " and ew.departmentId = " + user.getDepartmentID();
		} else if(ObjectUtils.isNotEmpty(departmentId) && departmentId > 0) {
			query = query + " and ew.departmentId = " + departmentId;
		}
		
		
		List<ReportData> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(ReportData.class));

		return data;
	}

	@Override
	public List<ReportSevaNivrutResponse> getRetirementCases(Long userId, Integer departmentId) {
		User user = userService.findUserById(userId);
		String query = "select *, (pendigOn142021 + retirementAfter142021) as totalRetirementCase, \r\n"
				+ "((pendigOn142021 + retirementAfter142021) - totalRetirementFinalisedCases) as totalPendingCases,  \r\n"
				+ "(pendingDueToDepartmentalEnquiry + judicialCases) as departmentalPlusJudicialCases,\r\n"
				+ "(((pendigOn142021 + retirementAfter142021) - totalRetirementFinalisedCases) - (pendingDueToDepartmentalEnquiry + judicialCases)) as exceptAccountEnquiryAndJudicial\r\n"
				+ "from (select ew.departmentId as departmentName, sum(case when (pendingPensionDate >= '2022-04-01' and pendingPensionDate < '2023-04-01') then 1 else 0 end) as pendigOn142021,\r\n"
				+ "sum(case when (pendingPensionDate >= '2023-04-01') then 1 else 0 end) as retirementAfter142021,\r\n"
				+ "sum(case when (pensionDate >= '2023-04-01') then 1 else 0 end) as totalRetirementFinalisedCases,\r\n"
				+ "sum(case when (MONTH(pensionDate) = month(CURDATE())) then 1 else 0 end) as finalCasesInReportMonth,\r\n"
				+ "sum(case when (pensionDate is null and a.employeeId is not null) then 1 else 0 end) as pendingDueToDepartmentalEnquiry,\r\n"
				+ "sum(case when (pensionDate is null and c.employeeId is not null) then 1 else 0 end) as judicialCases,\r\n"
				+ "sum(case when (c.employeeId is null and a.employeeId is null and pensionDate is null and TIMESTAMPDIFF(MONTH, pendingPensionDate, CURDATE())\r\n"
				+ ")  >= 6 then 1 else 0 end) as pendingMoreThanSixMonth  \r\n"
				+ "from retierment r inner join employee e on r.employeeId = e.employee_id"
				+ " left join (select employeeId from criminal_offence where courtResultImplemented = 0 group by employeeId)  c\r\n"
				+ "on r.employeeId = c.employeeId left join (select employeeId from account_inquiry where implementationDone = 0 group by employeeId) a \r\n"
				+ "on r.employeeId = a.employeeId "
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId" + ""
			    + " where pensionDate is null or pensionDate >= '2023-04-01' and e.active = 1 and ew.zpId = " + user.getZillaParishadID();

		if (user.getDepartmentID() > 0) {
			query = query + " and ew.departmentId = " + user.getDepartmentID();
		} else if (ObjectUtils.isNotEmpty(departmentId) && departmentId > 0) {
			query = query + " and ew.departmentId = " + departmentId;
		}
		query = query + " group by ew.departmentId ) tmp;";

		List<ReportSevaNivrutResponse> data = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(ReportSevaNivrutResponse.class));
		return data;
	}

	@Override
	public List<ReportSevaNivrutDepartmentLevelResponse> getRetirementCasesAll(Long userId, String type) {
		User user = userService.findUserById(userId);
		String query = "select distinct ew.departmentId as departmentName,concat(e.firstName , ' ' , e.middleName , ' ' , e.lastName) as employeeName,\r\n"
				+ "ed.employeeDesiganationId as designation,ifnull(ew.subDepartment, ew.subDivision) as officeName, ew.taluka, r.retirementReason, r.currentCondition as currentSituationOfCase, r.pendingLevel,\r\n"
				+ " ifnull(r.retirementDate, e.retirementDate) as retirementDate, (case when (pensionDate is null and TIMESTAMPDIFF(MONTH, pendingPensionDate, CURDATE())\r\n"
				+ ")  >= 6 then 1 else 0 end) as isCaseOldThan6Months, declarationDate from retierment r inner join employee e on r.employeeId = e.employee_id \r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId "
		+ " where e.active = 1 and ew.zpId = " + user.getZillaParishadID();
		
		if(user.getDepartmentID() > 0) {
			query = query + " and ew.departmentId = " + user.getDepartmentID();
		}
		
		if(StringUtils.endsWithIgnoreCase(type, "pending")) {
			query = query + " and pensionDate is null ";
		} else {
			query = query + " and pensionDate is not null ";
		}
		
		query = query + " order by ew.departmentId";
		
		List<ReportSevaNivrutDepartmentLevelResponse> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(ReportSevaNivrutDepartmentLevelResponse.class));

		return data;
	}

	@Override
	public List<ReportMattaDayitvaResponse> getMattadayitvaAll(Long userId, String year, Long departmentId) {

		String query = "SELECT\r\n"
				+ "d.designationID as designation, \r\n"
				+ "sum(case when (d.designationClassID = 3 and ifnull(a.isAssetLiabilitySubmitted, 0) = 0) then 1 else 0 end) as workingEmployeeA,\r\n"
				+ "sum(case when (d.designationClassID = 4 and ifnull(a.isAssetLiabilitySubmitted, 0) = 0) then 1 else 0 end) as workingEmployeeB,\r\n"
				+ "sum(case when (d.designationClassID = 1 and ifnull(a.isAssetLiabilitySubmitted, 0) = 0) then 1 else 0 end) as workingEmployeeC,\r\n"
				+ "sum(case when (d.designationClassID = 3 and ifnull(a.isAssetLiabilitySubmitted, 0) = 1) then 1 else 0 end) as mattaDayitvaSubmittedA,\r\n"
				+ "sum(case when (d.designationClassID = 4 and ifnull(a.isAssetLiabilitySubmitted, 0) = 1) then 1 else 0 end) as mattaDayitvaSubmittedB,\r\n"
				+ "sum(case when (d.designationClassID = 1 and ifnull(a.isAssetLiabilitySubmitted, 0) = 1) then 1 else 0 end) as mattaDayitvaSubmittedC  \r\n"
				+ "FROM employee e\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "inner join tblDesignation d on ed.employeeDesiganationId = d.designationID\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId "
				+ "left join assetLiability a on e.employee_id = a.employeeId and a.financialYear = '"+ year + "'";
				
		query = query + " where ew.departmentId = " + departmentId;
				
		query = query + " group by d.designationID;";
		
		List<ReportMattaDayitvaResponse> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(ReportMattaDayitvaResponse.class));

		return data;
	}

	@Override
	public List<ReportGopaniyAhvalResponse> getGopaniyAhvalAll(Long userId, String year, Long departmentId) {
		
		String lastYear = year.substring(year.indexOf("-") + 1);
		
		String query = "SELECT\r\n"
				+ "d.designationID as designation, \r\n"
				+ "sum(case when (d.designationClassID = 3) then 1 else 0 end) as allEmployeeA,\r\n"
				+ "sum(case when (d.designationClassID = 4) then 1 else 0 end) as allEmployeeB,\r\n"
				+ "sum(case when (d.designationClassID = 1) then 1 else 0 end) as allEmployeeC,\r\n"
				+ "sum(case when (d.designationClassID = 3 and tmp1.toDate >= '"+lastYear+"-03-31') then 1 else 0 end) as confidentialDataSubmittedA,\r\n"
				+ "sum(case when (d.designationClassID = 4 and tmp1.toDate >= '"+lastYear+"-03-31') then 1 else 0 end) as confidentialDataSubmittedB,\r\n"
				+ "sum(case when (d.designationClassID = 1 and tmp1.toDate >= '"+lastYear+"-03-31') then 1 else 0 end) as confidentialDataSubmittedC,\r\n"
				+ "sum(case when (d.designationClassID = 3 and tmp2.toDate >= '"+lastYear+"-03-31') then 1 else 0 end) as confidentialUpdatedA,\r\n"
				+ "sum(case when (d.designationClassID = 4 and tmp2.toDate >= '"+lastYear+"-03-31') then 1 else 0 end) as confidentialUpdatedB,\r\n"
				+ "sum(case when (d.designationClassID = 1 and tmp2.toDate >= '"+lastYear+"-03-31') then 1 else 0 end) as confidentialUpdatedC    \r\n"
				+ "FROM employee e\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "inner join tblDesignation d on ed.employeeDesiganationId = d.designationID\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId "
				+ "left join (\r\n"
				+ "SELECT employeeId, financialYear, \r\n"
				+ "min(fromDate) as fromDate, max(toDate) as toDate\r\n"
				+ " FROM confidential where reportingOfficerMarks is not null group by financialYear, employeeId\r\n"
				+ ") tmp1 on e.employee_id = tmp1.employeeId and tmp1.financialYear = '"+ year + "'\r\n"
				+ "left join (\r\n"
				+ "SELECT employeeId, financialYear, \r\n"
				+ "min(fromDate) as fromDate, max(toDate) as toDate\r\n"
				+ " FROM confidential where reviewOfficerMarks is not null group by financialYear, employeeId\r\n"
				+ ") tmp2 on e.employee_id = tmp2.employeeId and tmp2.financialYear = '"+ year + "'";
				
		query = query + " where ew.departmentId = " + departmentId;
				
		query = query + " group by d.designationID;";
		
		List<ReportGopaniyAhvalResponse> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(ReportGopaniyAhvalResponse.class));

		return data;
	}

	@Override
	public List<ReportStayitvaReponse> getStayitvaReportAll(Long userId, String year, Long departmentId) {
		
		String query = "SELECT\r\n"
				+ "d.designationID as designation, \r\n"
				+ "sum(case when (d.designationClassID = 1) then 1 else 0 end) as totalWorkingEmpC,\r\n"
				+ "sum(case when (d.designationClassID = 2) then 1 else 0 end) as totalWorkingEmpD,\r\n"
				+ "sum(case when (d.designationClassID = 1 and TIMESTAMPDIFF(YEAR, edm.dateOfAppointed, CURDATE()) >= 3) then 1 else 0 end) as stayitvaEligibleEmpC,\r\n"
				+ "sum(case when (d.designationClassID = 2 and TIMESTAMPDIFF(YEAR, edm.dateOfAppointed, CURDATE()) >= 3) then 1 else 0 end) as stayitvaEligibleEmpD, \r\n"
				+ "sum(case when (d.designationClassID = 1 and ifnull(tmp1.isAppealed, 0) > 0) then 1 else 0 end) as stayitvaReceivedEmpC,\r\n"
				+ "sum(case when (d.designationClassID = 2 and ifnull(tmp1.isAppealed, 0) > 0) then 1 else 0 end) as stayitvaReceivedEmpD  \r\n"
				+ "FROM employee e\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "inner join tblDesignation d on ed.employeeDesiganationId = d.designationID\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId "
				+ "inner join (select employeeId, min(dateOfAppointed) as dateOfAppointed from employee_designation_details group by employeeId) edm on e.employee_id = edm.employeeId\r\n"
				+ "left join stayitva_pramanpatra tmp1 on e.employee_id = tmp1.employeeId\r\n";
				
		query = query + " where ew.departmentId = " + departmentId;
				
		query = query + " group by d.designationID;";
		
		List<ReportStayitvaReponse> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(ReportStayitvaReponse.class));

		return data;
	}

	@Override
	public List<ReportSanganakAhartaResponse> getComputerQualificationReportAll(Long userId, String year,
			Long departmentId) {
		String query = "SELECT\r\n"
				+ "d.designationID, \r\n"
				+ "sum(case when (e.employee_id > 0) then 1 else 0 end) as totalEmployee,\r\n"
				+ "sum(case when tmp1.computerFlag = 0 then 1 else 0 end) as pass,\r\n"
				+ "sum(case when tmp1.computerFlag = 1 then 1 else 0 end) as notApplicable,\r\n"
				+ "sum(case when tmp1.computerFlag = 1 or tmp1.computerFlag = 0 then 1 else 0 end) as total,\r\n"
				+ "sum(case when ifnull(tmp1.computerFlag, 2) = 2 or tmp1.computerFlag = 1 then 1 else 0 end) as notQualified,\r\n"
				+ "sum(case when tmp1.computerFlag = 1 then 1 else 0 end) as notQualifiedNotApplicable \r\n"
				+ "FROM employee e\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId "
				+ "inner join tblDesignation d on ed.employeeDesiganationId = d.designationID\r\n"
				+ "left join employee_computer_details tmp1 on e.employee_id = tmp1.employeeId";
				
		query = query + " where ew.departmentId = " + departmentId;
				
		query = query + " group by d.designationID;";
		
		List<ReportSanganakAhartaResponse> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(ReportSanganakAhartaResponse.class));

		return data;
	}

	@Override
	public List<ReportLanguageResponse> getHindiMarathiReportAll(Long userId, String year, Long departmentId) {
		String query = "SELECT\r\n"
				+ "d.designationID, \r\n"
				+ "sum(case when (e.employee_id > 0) then 1 else 0 end) as totalEmployee,\r\n"
				+ "sum(case when (tmp1.marathiHindiFlag = 1 and marathiFlag = 0) or (tmp1.marathiHindiFlag = 0 and marathiHinidCombineFlag = 0) then 1 else 0 end) as marathiPass,\r\n"
				+ "sum(case when (tmp1.marathiHindiFlag = 1 and hindiFlag = 0) or (tmp1.marathiHindiFlag = 0 and marathiHinidCombineFlag = 0) then 1 else 0 end) as hindiPass,\r\n"
				+ "sum(case when (tmp1.marathiHindiFlag = 1 and marathiFlag = 1) or (tmp1.marathiHindiFlag = 0 and marathiHinidCombineFlag = 1) then 1 else 0 end) as marathiSut,\r\n"
				+ "sum(case when (tmp1.marathiHindiFlag = 1 and hindiFlag = 1) or (tmp1.marathiHindiFlag = 0 and marathiHinidCombineFlag = 1) then 1 else 0 end) as hindiSut,\r\n"
				+ "sum(case when (tmp1.marathiHindiFlag = 1 and marathiFlag = 2) or (tmp1.marathiHindiFlag = 0 and marathiHinidCombineFlag = 2) or tmp1.marathiHindiFlag is null then 1 else 0 end) as marathiNotPass,\r\n"
				+ "sum(case when (tmp1.marathiHindiFlag = 1 and hindiFlag = 2) or (tmp1.marathiHindiFlag = 0 and marathiHinidCombineFlag = 2) or tmp1.marathiHindiFlag is null then 1 else 0 end) as hindiNotPass,\r\n"
				+ "sum(case when (e.employee_id > 0) then 1 else 0 end) as marathiTotal,\r\n"
				+ "sum(case when (e.employee_id > 0) then 1 else 0 end) as hindiTotal \r\n"
				+ "FROM employee e\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "inner join tblDesignation d on ed.employeeDesiganationId = d.designationID\r\n"
				+ "inner join employee_worklocation ew on e.employeeWorklocationId = ew.employeeWorklocationId "
				+ "left join employee_language_exam tmp1 on e.employee_id = tmp1.employeeId\r\n";
				
		query = query + " where ew.departmentId = " + departmentId;
				
		query = query + " group by d.designationID;";
		
		List<ReportLanguageResponse> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(ReportLanguageResponse.class));

		return data;
	}

	@Override
	public List<Report3055Response> getEmployee3055Report(Long userId, String year, Long departmentId) {
		String query = "SELECT\r\n"
				+ "d.designationID, \r\n"
				+ "sum(case when (TIMESTAMPDIFF(DAY, edm.dateOfAppointed, CURDATE()) - (365 * 30) > TIMESTAMPDIFF(DAY, dateOfBirth, CURDATE()) - (365 * 55))\r\n"
				+ "and TIMESTAMPDIFF(DAY, edm.dateOfAppointed, CURDATE()) - (365 * 30) > 0 then 1 else 0 end)\r\n"
				+ " as age30Completed,\r\n"
				+ "sum(case when (TIMESTAMPDIFF(DAY, dateOfBirth, CURDATE()) - (365 * 55) >= TIMESTAMPDIFF(DAY, edm.dateOfAppointed, CURDATE()) - (365 * 30)) and TIMESTAMPDIFF(DAY, dateOfBirth, CURDATE()) - (365 * 55) > 0 then 1 else 0 end) \r\n"
				+ "as age55Completed,\r\n"
				+ "0 as reviewedEmployees,\r\n"
				+ "0 as notReviewedEmployees\r\n"
				+ "FROM employee e\r\n"
				+ "inner join employee_designation_details ed on e.employeeDesiganationDetailsId = ed.employeeDesiganationDetailsId\r\n"
				+ "inner join (select employeeId, min(dateOfAppointed) as dateOfAppointed from employee_designation_details group by employeeId) edm\r\n"
				+ "on e.employee_id = edm.employeeId\r\n"
				+ "inner join tblDesignation d on ed.employeeDesiganationId = d.designationID\r\n"
				+ "left join employee_language_exam tmp1 on e.employee_id = tmp1.employeeId";
				
		query = query + " where ew.departmentId = " + departmentId;
				
		query = query + " group by d.designationID;";
		
		List<Report3055Response> data = jdbcTemplate.query(
				query,
				BeanPropertyRowMapper.newInstance(Report3055Response.class));

		return data;
	}
	
}

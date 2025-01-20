package com.zpasthapana.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.AbsenceReport;
import com.zpasthapana.pojo.BinduNamavaliReport;
import com.zpasthapana.pojo.JestatechaReport;
import com.zpasthapana.pojo.Report3055Response;
import com.zpasthapana.pojo.ReportData;
import com.zpasthapana.pojo.ReportGopaniyAhvalResponse;
import com.zpasthapana.pojo.ReportLanguageResponse;
import com.zpasthapana.pojo.ReportMattaDayitvaResponse;
import com.zpasthapana.pojo.ReportSanganakAhartaResponse;
import com.zpasthapana.pojo.ReportSevaNivrutDepartmentLevelResponse;
import com.zpasthapana.pojo.ReportSevaNivrutResponse;
import com.zpasthapana.pojo.ReportStayitvaEmpListResponse;
import com.zpasthapana.pojo.ReportStayitvaReponse;
import com.zpasthapana.pojo.ZPMajurPadereport;
import com.zpasthapana.pojo.ZPMajurPadereportWrapper;
import com.zpasthapana.service.ReportService;
import com.zpasthapana.util.MasterDataUtil;

@RestController
@RequestMapping("reports")
public class ReportController {

	@Autowired
	ReportService reportService;

	@GetMapping("/manjur-bharaleli-pade/{userId}")
	public ResponseEntity<ZPMajurPadereportWrapper> getManjurBharaleliPadeForDepartment(@PathVariable Long userId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(reportService.getMajurPadeReport(userId), HttpStatus.OK);
	}

	@GetMapping("/manjur-bharaleli-pade-admin/{userId}/{departmentId}")
	public ResponseEntity<ZPMajurPadereportWrapper> getManjurBharaleliPadeForDepartmentAdmin(@PathVariable Long userId,
			@PathVariable Long departmentId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(
				reportService.getMajurPadeReportByDepartMentId(userId, departmentId), HttpStatus.OK);
	}

	@GetMapping("/manjur-bharaleli-pade-all/{userId}")
	public ResponseEntity<List<ZPMajurPadereport>> getManjurBharaleliPadeForAll(@PathVariable Long userId) {
		return new ResponseEntity<List<ZPMajurPadereport>>(reportService.getMajurPadeDepartMentWiseReport(userId),
				HttpStatus.OK);
	}

	@GetMapping("/manjur-bharaleli-pade-divyang/{userId}")
	public ResponseEntity<ZPMajurPadereportWrapper> getManjurBharaleliPadeForDepartmentHandicap(
			@PathVariable Long userId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(reportService.getMajurPadeReportHandicap(userId),
				HttpStatus.OK);
	}

	@GetMapping("/manjur-bharaleli-pade-admin-divyang/{userId}/{departmentId}")
	public ResponseEntity<ZPMajurPadereportWrapper> getManjurBharaleliPadeForDepartmentAdminHandicap(
			@PathVariable Long userId, @PathVariable Long departmentId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(
				reportService.getMajurPadeReportByDepartMentIdHandicap(userId, departmentId), HttpStatus.OK);
	}

	@GetMapping("/manjur-bharaleli-pade-all-divyang/{userId}")
	public ResponseEntity<List<ZPMajurPadereport>> getManjurBharaleliPadeForAllHandicap(@PathVariable Long userId) {
		return new ResponseEntity<List<ZPMajurPadereport>>(
				reportService.getMajurPadeDepartMentWiseReportHandicap(userId), HttpStatus.OK);
	}

	@GetMapping("/bindu-namavali/{userId}")
	public ResponseEntity<List<BinduNamavaliReport>> getBinduNamavali(@PathVariable Long userId,
			@RequestParam(name = "type", required = false) String type,
			@RequestParam(name = "designationId", required = false) Integer designationId) {
		List<BinduNamavaliReport> result = reportService.getBindunamavaliReport(userId, type, designationId);
		result = result.stream().map(s -> {
			s.setJatichaPravarg(MasterDataUtil.getKeyDate("castecategory_", s.getJatichaPravarg()));
			s.setNemnukichaPravarg(MasterDataUtil.getKeyDate("castecategory_", s.getNemnukichaPravarg()));
			return s;
		}).sorted(Comparator.comparing(BinduNamavaliReport::getEmployeeDesiganationId)
				.thenComparing(BinduNamavaliReport::getDateOfHumanitySeniority)).collect(Collectors.toList());
		return new ResponseEntity<List<BinduNamavaliReport>>(result, HttpStatus.OK);
	}

	@GetMapping("/jestatechi-suchi/{userId}")
	public ResponseEntity<List<JestatechaReport>> getJestatechiSuchi(@PathVariable Long userId,
			@RequestParam(required = false) String type, @RequestParam(required = false) Integer designationId) {

		List<JestatechaReport> result = reportService.getJestatechaReport(userId, type, designationId);

		if (result == null || result.isEmpty()) {
			return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
		}

		result = result.stream().peek(s -> {
			s.setCaste(MasterDataUtil.getKeyDate("castecategory_", s.getCaste()));
			s.setNiyuktiPravarg(MasterDataUtil.getKeyDate("castecategory_", s.getNiyuktiPravarg()));
			s.setNiyuktichaMarg(MasterDataUtil.getKeyDate("niyuktitype_", s.getNiyuktichaMarg()));
		}).sorted(Comparator.comparing(JestatechaReport::getJeshtataManivDate,
				Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/unauthorized-absence-cases/{userId}")
	public ResponseEntity<List<AbsenceReport>> getUnAuthorisedAbsenceReport(@PathVariable Long userId,
			@RequestParam(name = "departmentId", required = false) Integer departmentId) {
		List<AbsenceReport> result = reportService.getUnAuthorisedAbsenceReport(userId, departmentId);
		result = result.stream().map(s -> {
			s.setTaluka(MasterDataUtil.getKeyDate("taluka_", s.getTaluka()));
			s.setDepartmentName(MasterDataUtil.getKeyDate("department_", s.getDepartmentName()));
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			String officeName = s.getOfficeName();
			s.setOfficeName(MasterDataUtil.getKeyDate("subdepartment_", officeName));
			if (StringUtils.isEmpty(s.getOfficeName())) {
				s.setOfficeName(MasterDataUtil.getKeyDate("subdivision_", officeName));
			}
			s.setAbsencePeriod(s.getAbsencePeriod() + " days");
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<AbsenceReport>>(result, HttpStatus.OK);
	}

	@GetMapping("/report/{userId}")
	public ResponseEntity<List<ReportData>> getUnAuthorisedAbsenceReport1(@PathVariable Long userId,
			@RequestParam(name = "departmentId", required = false) Integer departmentId) {
		List<ReportData> result = reportService.getUnAuthorisedAbsenceReport1(userId, departmentId);
//		result = result.stream().map(s->{
//			s.setTaluka(MasterDataUtil.getKeyDate("taluka_", s.getTaluka()));
//			s.setDepartmentName(MasterDataUtil.getKeyDate("department_", s.getDepartmentName()));
//			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
//			String officeName = s.getOfficeName();
//			s.setOfficeName(MasterDataUtil.getKeyDate("subdepartment_", officeName));
//			if(StringUtils.isEmpty(s.getOfficeName())) {
//				s.setOfficeName(MasterDataUtil.getKeyDate("subdivision_", officeName));
//			}
//			s.setAbsencePeriod(s.getAbsencePeriod() + " days");
//			return s;
//		}).collect(Collectors.toList());
		return new ResponseEntity<List<ReportData>>(result, HttpStatus.OK);
	}

	@GetMapping("/retirement-cases/department-level/{userId}")
	public ResponseEntity<List<ReportSevaNivrutResponse>> getRetirementCases(@PathVariable Long userId,
			@RequestParam(name = "departmentId", required = false) Integer departmentId) {
		List<ReportSevaNivrutResponse> result = reportService.getRetirementCases(userId, departmentId);
		result = result.stream().map(s -> {
			s.setDepartmentName(MasterDataUtil.getKeyDate("department_", s.getDepartmentName()));
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ReportSevaNivrutResponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/retirement-cases/department/{userId}")
	public ResponseEntity<List<ReportSevaNivrutDepartmentLevelResponse>> getRetirementCasesAll(
			@PathVariable Long userId, @RequestParam(name = "type", required = false) String type) {
		List<ReportSevaNivrutDepartmentLevelResponse> result = reportService.getRetirementCasesAll(userId, type);
		result = result.stream().map(s -> {
			s.setTaluka(MasterDataUtil.getKeyDate("taluka_", s.getTaluka()));
			s.setDepartmentName(MasterDataUtil.getKeyDate("department_", s.getDepartmentName()));
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			String officeName = s.getOfficeName();
			s.setOfficeName(MasterDataUtil.getKeyDate("subdepartment_", officeName));
			if (StringUtils.isEmpty(s.getOfficeName())) {
				s.setOfficeName(MasterDataUtil.getKeyDate("subdivision_", officeName));
			}
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ReportSevaNivrutDepartmentLevelResponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/matta-dayitva/yearly-details/{userId}")
	public ResponseEntity<List<ReportMattaDayitvaResponse>> getMattadayitvaAll(@PathVariable Long userId,
			@RequestParam(name = "year", required = false) String year,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<ReportMattaDayitvaResponse> result = reportService.getMattadayitvaAll(userId, year, departmentId);
		result = result.stream().map(s -> {
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			s.setWorkingEmployeeTotal(s.getWorkingEmployeeA() + s.getWorkingEmployeeB() + s.getWorkingEmployeeC());
			s.setMattaDayitvaSubmittedTotal(
					s.getMattaDayitvaSubmittedA() + s.getMattaDayitvaSubmittedB() + s.getMattaDayitvaSubmittedC());
			s.setMattaDayitvaNotSubmittedA(s.getWorkingEmployeeA() - s.getMattaDayitvaSubmittedA());
			s.setMattaDayitvaNotSubmittedB(s.getWorkingEmployeeB() - s.getMattaDayitvaSubmittedB());
			s.setMattaDayitvaNotSubmittedC(s.getWorkingEmployeeC() - s.getMattaDayitvaSubmittedC());
			s.setMattaDayitvaNotSubmittedTotal(s.getMattaDayitvaNotSubmittedA() + s.getMattaDayitvaNotSubmittedB()
					+ s.getMattaDayitvaNotSubmittedC());
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ReportMattaDayitvaResponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/confidential-report/yearly-details/{userId}")
	public ResponseEntity<List<ReportGopaniyAhvalResponse>> getGopaniyAhvalAll(@PathVariable Long userId,
			@RequestParam(name = "year", required = false) String year,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<ReportGopaniyAhvalResponse> result = reportService.getGopaniyAhvalAll(userId, year, departmentId);
		result = result.stream().map(s -> {
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			s.setAllEmployeeTotal(s.getAllEmployeeA() + s.getAllEmployeeB() + s.getAllEmployeeC());
			s.setConfidentialDataSubmittedTotal(s.getConfidentialDataSubmittedA() + s.getConfidentialDataSubmittedB()
					+ s.getConfidentialDataSubmittedC());
			s.setConfidentialNotSubmittedA(s.getAllEmployeeA() - s.getConfidentialDataSubmittedA());
			s.setConfidentialNotSubmittedB(s.getAllEmployeeB() - s.getConfidentialDataSubmittedB());
			s.setConfidentialNotSubmittedC(s.getAllEmployeeC() - s.getConfidentialDataSubmittedC());
			s.setConfidentialNotSubmittedTotal(s.getConfidentialNotSubmittedA() + s.getConfidentialNotSubmittedB()
					+ s.getConfidentialNotSubmittedC());
			s.setConfidentialUpdatedTotal(
					s.getConfidentialUpdatedA() + s.getConfidentialUpdatedB() + s.getConfidentialUpdatedC());
			s.setConfidentialNotUpdatedA(s.getConfidentialDataSubmittedA() - s.getConfidentialUpdatedA());
			s.setConfidentialNotUpdatedB(s.getConfidentialDataSubmittedB() - s.getConfidentialUpdatedB());
			s.setConfidentialNotUpdatedC(s.getConfidentialDataSubmittedC() - s.getConfidentialUpdatedC());
			s.setConfidentialNotUpdatedTotal(
					s.getConfidentialNotUpdatedA() + s.getConfidentialNotUpdatedB() + s.getConfidentialNotUpdatedC());
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ReportGopaniyAhvalResponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/stayitva-certification/department-level/{userId}")
	public ResponseEntity<List<ReportStayitvaReponse>> getStayitvaReportAll(@PathVariable Long userId,
			@RequestParam(name = "year", required = false) String year,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<ReportStayitvaReponse> result = reportService.getStayitvaReportAll(userId, year, departmentId);
		result = result.stream().map(s -> {
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			s.setTotalWorkingEmpTotal(s.getTotalWorkingEmpC() + s.getTotalWorkingEmpD());
			s.setStayitvaNotReceivedEmpC(s.getStayitvaEligibleEmpC() - s.getStayitvaReceivedEmpC());
			s.setStayitvaNotReceivedEmpD(s.getStayitvaEligibleEmpD() - s.getStayitvaReceivedEmpD());
			s.setStayitvaNotReceivedEmpTotal(s.getStayitvaNotReceivedEmpC() + s.getStayitvaNotReceivedEmpD());
			s.setStayitvaEligibleEmpTotal(s.getStayitvaEligibleEmpC() + s.getStayitvaEligibleEmpD());
			s.setStayitvaReceivedEmpTotal(s.getStayitvaReceivedEmpC() + s.getStayitvaReceivedEmpD());
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ReportStayitvaReponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/stayitva-certification/designation-level/{userId}")
	public ResponseEntity<List<ReportStayitvaEmpListResponse>> getStayitvaReportWithDesignation(
			@PathVariable Long userId, @RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<ReportStayitvaEmpListResponse> result = reportService.getStayitvaReportWithDesignation(userId,
				departmentId);
		result = result.stream().map(s -> {
			s.setFirstAppointDesignation(MasterDataUtil.getKeyDate("designation_", s.getFirstAppointDesignation()));
			s.setSelectionType(MasterDataUtil.getKeyDate("castecategory_", s.getSelectionType()));
			s.setFirstAppointType(MasterDataUtil.getKeyDate("niyuktitype_", s.getFirstAppointType()));
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ReportStayitvaEmpListResponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/computer-qualification/department-level/{userId}")
	public ResponseEntity<List<ReportSanganakAhartaResponse>> getComputerQualificationReportAll(
			@PathVariable Long userId, @RequestParam(name = "year", required = false) String year,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<ReportSanganakAhartaResponse> result = reportService.getComputerQualificationReportAll(userId, year,
				departmentId);
		ReportSanganakAhartaResponse total = ReportSanganakAhartaResponse.builder().notApplicable(0).notQualified(0)
				.totalEmployee(0).total(0).notQualifiedNotApplicable(0).pass(0).designation("एकूण").department("")
				.build();
		result = result.stream().map(s -> {
			total.setTotal(total.getTotal() + s.getTotal());
			total.setNotApplicable(total.getNotApplicable() + s.getNotApplicable());
			total.setNotQualified(total.getNotQualified() + s.getNotQualified());
			total.setTotalEmployee(total.getTotalEmployee() + s.getTotalEmployee());
			total.setNotQualifiedNotApplicable(total.getNotQualifiedNotApplicable() + s.getNotQualifiedNotApplicable());
			total.setPass(total.getPass() + s.getPass());
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			total.setDepartment(s.getDepartment());
			return s;
		}).collect(Collectors.toList());
		result.add(total);
		return new ResponseEntity<List<ReportSanganakAhartaResponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/marathi-hindi/language-test-department-level/{userId}")
	public ResponseEntity<List<ReportLanguageResponse>> getHindiMarathiReportAll(@PathVariable Long userId,
			@RequestParam(name = "year", required = false) String year,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<ReportLanguageResponse> result = reportService.getHindiMarathiReportAll(userId, year, departmentId);
		ReportLanguageResponse total = ReportLanguageResponse.builder().designation("एकूण").hindiNotPass(0).hindiPass(0)
				.hindiSut(0).hindiTotal(0).marathiNotPass(0).marathiPass(0).marathiSut(0).marathiTotal(0)
				.totalWorkingEmployee(0).build();
		result = result.stream().map(s -> {
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			total.setHindiNotPass(total.getHindiNotPass() + s.getHindiNotPass());
			total.setHindiPass(total.getHindiPass() + s.getHindiPass());
			total.setHindiSut(total.getHindiSut() + s.getHindiSut());
			total.setHindiTotal(total.getHindiTotal() + s.getHindiTotal());
			total.setMarathiNotPass(total.getMarathiNotPass() + s.getMarathiNotPass());
			total.setMarathiPass(total.getMarathiPass() + s.getMarathiPass());
			total.setMarathiSut(s.getMarathiSut() + total.getMarathiSut());
			total.setMarathiTotal(s.getMarathiTotal() + total.getMarathiTotal());
			total.setTotalWorkingEmployee(s.getTotalWorkingEmployee());
			return s;
		}).collect(Collectors.toList());
		result.add(total);
		return new ResponseEntity<List<ReportLanguageResponse>>(result, HttpStatus.OK);
	}

	@GetMapping("/employee-age-30-55/department-level/{userId}")
	public ResponseEntity<List<Report3055Response>> getEmployee3055Report(@PathVariable Long userId,
			@RequestParam(name = "year", required = false) String year,
			@RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<Report3055Response> result = reportService.getEmployee3055Report(userId, year, departmentId);
		Report3055Response total = Report3055Response.builder().designation("एकूण").age30Completed(0).age55Completed(0)
				.reviewedEmployees(0).notReviewedEmployees(0).total30Plus55(0).build();
		result = result.stream().map(s -> {
			s.setDesignation(MasterDataUtil.getKeyDate("designation_", s.getDesignation()));
			int total30Plus55 = s.getAge30Completed() + s.getAge55Completed();
			s.setTotal30Plus55(total30Plus55);
			s.setNotReviewedEmployees(total30Plus55);
			total.setAge30Completed(total.getAge30Completed() + s.getAge30Completed());
			total.setAge55Completed(total.getAge55Completed() + s.getAge55Completed());
			total.setReviewedEmployees(total.getReviewedEmployees() + s.getReviewedEmployees());
			total.setNotReviewedEmployees(total.getNotReviewedEmployees() + total30Plus55);
			total.setTotal30Plus55(total.getTotal30Plus55() + total30Plus55);
			return s;
		}).collect(Collectors.toList());
		result.add(total);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/marathi-hindi/designation-level/{userId}")
	public ResponseEntity<List<ReportStayitvaEmpListResponse>> getMarathiHindiReportWithDesignation(
			@PathVariable Long userId, @RequestParam(name = "departmentId", required = false) Long departmentId) {
		List<ReportStayitvaEmpListResponse> result = reportService.getMarathiHindiReportWithDesignation(userId,
				departmentId);
		result = result.stream().map(s -> {
			s.setFirstAppointDesignation(MasterDataUtil.getKeyDate("designation_", s.getFirstAppointDesignation()));
			s.setSelectionType(MasterDataUtil.getKeyDate("castecategory_", s.getSelectionType()));
			s.setFirstAppointType(MasterDataUtil.getKeyDate("niyuktitype_", s.getFirstAppointType()));
			return s;
		}).collect(Collectors.toList());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}

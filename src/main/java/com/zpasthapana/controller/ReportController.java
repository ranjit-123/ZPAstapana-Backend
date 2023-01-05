package com.zpasthapana.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.BinduNamavaliReport;
import com.zpasthapana.pojo.JestatechaReport;
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
	public ResponseEntity<ZPMajurPadereportWrapper> getManjurBharaleliPadeForDepartmentAdmin(@PathVariable Long userId, @PathVariable Long departmentId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(reportService.getMajurPadeReportByDepartMentId(userId, departmentId), HttpStatus.OK);
	}
	
	@GetMapping("/manjur-bharaleli-pade-all/{userId}")
	public ResponseEntity<List<ZPMajurPadereport>> getManjurBharaleliPadeForAll(@PathVariable Long userId) {
		return new ResponseEntity<List<ZPMajurPadereport>>(reportService.getMajurPadeDepartMentWiseReport(userId), HttpStatus.OK);
	}
	
	@GetMapping("/manjur-bharaleli-pade-divyang/{userId}")
	public ResponseEntity<ZPMajurPadereportWrapper> getManjurBharaleliPadeForDepartmentHandicap(@PathVariable Long userId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(reportService.getMajurPadeReportHandicap(userId), HttpStatus.OK);
	}
	
	@GetMapping("/manjur-bharaleli-pade-admin-divyang/{userId}/{departmentId}")
	public ResponseEntity<ZPMajurPadereportWrapper> getManjurBharaleliPadeForDepartmentAdminHandicap(@PathVariable Long userId, @PathVariable Long departmentId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(reportService.getMajurPadeReportByDepartMentIdHandicap(userId, departmentId), HttpStatus.OK);
	}
	
	@GetMapping("/manjur-bharaleli-pade-all-divyang/{userId}")
	public ResponseEntity<List<ZPMajurPadereport>> getManjurBharaleliPadeForAllHandicap(@PathVariable Long userId) {
		return new ResponseEntity<List<ZPMajurPadereport>>(reportService.getMajurPadeDepartMentWiseReportHandicap(userId), HttpStatus.OK);
	}
	
	@GetMapping("/bindu-namavali/{userId}")
	public ResponseEntity<List<BinduNamavaliReport>> getBinduNamavali(@PathVariable Long userId, @RequestParam(name = "type", required = false) String type) {
		List<BinduNamavaliReport> result = reportService.getBindunamavaliReport(userId, type);
		result = result.stream().map(s->{
			s.setJatichaPravarg(MasterDataUtil.getKeyDate("castecategory_", s.getJatichaPravarg()));
			s.setNemnukichaPravarg(MasterDataUtil.getKeyDate("castecategory_", s.getNemnukichaPravarg()));
			return s;
		}).sorted(Comparator.comparing(BinduNamavaliReport::getEmployeeDesiganationId).thenComparing(BinduNamavaliReport::getDateOfHumanitySeniority)).collect(Collectors.toList());
		return new ResponseEntity<List<BinduNamavaliReport>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/jestatechi-suchi/{userId}")
	public ResponseEntity<List<JestatechaReport>> getJestatechiSuchi(@PathVariable Long userId, @RequestParam(name = "type", required = false) String type) {
		List<JestatechaReport> result = reportService.getJestatechaReport(userId, type);
		result = result.stream().map(s->{
			s.setJatichaPravarg(MasterDataUtil.getKeyDate("castecategory_", s.getJatichaPravarg()));
			s.setNemnukichaPravarg(MasterDataUtil.getKeyDate("castecategory_", s.getNemnukichaPravarg()));
			s.setNiyuktichaMarg(MasterDataUtil.getKeyDate("niyuktitype_", s.getNiyuktichaMarg()));
			return s;
		}).sorted(Comparator.comparing(JestatechaReport::getDateOfHumanitySeniority)).collect(Collectors.toList());
		return new ResponseEntity<List<JestatechaReport>>(result, HttpStatus.OK);
	}

}

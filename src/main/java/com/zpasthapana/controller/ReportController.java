package com.zpasthapana.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.BinduNamavaliReport;
import com.zpasthapana.pojo.ZPMajurPadereport;
import com.zpasthapana.pojo.ZPMajurPadereportWrapper;
import com.zpasthapana.service.ReportService;

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
		return new ResponseEntity<List<BinduNamavaliReport>>(result, HttpStatus.OK);
	}

}

package com.zpasthapana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.ZPMajurPadereportWrapper;
import com.zpasthapana.service.ReportService;

@RestController
@RequestMapping("reports")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("/manjur-bharaleli-pade/{userId}")
	public ResponseEntity<ZPMajurPadereportWrapper> getAllTollAndParkings(@PathVariable Long userId) {
		return new ResponseEntity<ZPMajurPadereportWrapper>(reportService.getMajurPadeReport(userId), HttpStatus.OK);
	}

}

package com.zpasthapana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.entity.AccidentalInsurance;
import com.zpasthapana.pojo.AccidentalInsuranceRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.service.AccidentalInsuranceService;

@RestController
@RequestMapping("accidental-insurances")
public class AccidentalInsuranceController {

	@Autowired
	AccidentalInsuranceService accidentalInsuranceService; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addAccidentalInsurance(@ModelAttribute AccidentalInsuranceRequest request) {
		accidentalInsuranceService.addAccidentalInsurance(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AccidentalInsurance>> getAllAccidentalInsurance() {
		return new ResponseEntity<List<AccidentalInsurance>>(accidentalInsuranceService.getAllAccidentalInsurance(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<List<AccidentalInsurance>> getEmployeeAccidentalInsurance(@PathVariable Long employeeId) {
		return new ResponseEntity<List<AccidentalInsurance>>(accidentalInsuranceService.getEmployeeAccidentalInsurance(employeeId),
				HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<ResponseMessage> updateAccidentalInsurance(@PathVariable Long employeeId, @RequestBody AccidentalInsuranceRequest request) {
		accidentalInsuranceService.updateAccidentalInsurance(employeeId, request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.OK).build(),
				HttpStatus.OK);
	}
	
}

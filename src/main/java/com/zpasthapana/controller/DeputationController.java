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

import com.zpasthapana.entity.Deputation;
import com.zpasthapana.pojo.DeputationRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.service.DeputationService;

@RestController
@RequestMapping("deputations")
public class DeputationController {

	@Autowired
	DeputationService deputationService; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addAccidentalInsurance(@ModelAttribute DeputationRequest request) {
		deputationService.addDeputation(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Deputation>> getAllAccidentalInsurance() {
		return new ResponseEntity<List<Deputation>>(deputationService.getAllDeputation(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<List<Deputation>> getEmployeeAccidentalInsurance(@PathVariable Long employeeId) {
		return new ResponseEntity<List<Deputation>>(deputationService.getEmployeeDeputation(employeeId),
				HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<ResponseMessage> updateAccidentalInsurance(@PathVariable Long employeeId, @RequestBody DeputationRequest request) {
		deputationService.updateDeputation(employeeId, request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.OK).build(),
				HttpStatus.OK);
	}
	
	
}

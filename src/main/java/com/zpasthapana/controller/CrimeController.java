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

import com.zpasthapana.entity.Crime;
import com.zpasthapana.pojo.CrimeRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.service.CrimeService;

@RestController
@RequestMapping("crimes")
public class CrimeController {

	@Autowired
	CrimeService crimeService; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addCrime(@ModelAttribute CrimeRequest request) {
		crimeService.addCrime(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Crime>> getAllCrime() {
		return new ResponseEntity<List<Crime>>(crimeService.getAllCrime(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<List<Crime>> getEmployeeCrime(@PathVariable Long employeeId) {
		return new ResponseEntity<List<Crime>>(crimeService.getEmployeeCrime(employeeId),
				HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<ResponseMessage> updateCrime(@PathVariable Long employeeId, @RequestBody CrimeRequest request) {
		crimeService.updateCrime(employeeId, request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.OK).build(),
				HttpStatus.OK);
	}
	
}

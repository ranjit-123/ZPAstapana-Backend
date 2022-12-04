package com.zpasthapana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.entity.Retierment;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.RetiermentRequest;
import com.zpasthapana.service.RetiermentService;

@RestController
@RequestMapping("retirements")
public class RetiermentController {

	@Autowired
	RetiermentService retiermentService; 
	
	@PostMapping
	public ResponseEntity<ResponseMessage> addRetierment(@RequestBody RetiermentRequest request) {
		retiermentService.addRetirement(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Retierment>> getAllRetierment() {
		return new ResponseEntity<List<Retierment>>(retiermentService.getAllRetirement(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<List<Retierment>> getEmployeeRetierment(@PathVariable Long employeeId) {
		return new ResponseEntity<List<Retierment>>(retiermentService.getEmployeeRetirement(employeeId),
				HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<ResponseMessage> updateRetierment(@PathVariable Long employeeId, @RequestBody RetiermentRequest request) {
		retiermentService.updateRetierment(employeeId, request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.OK).build(),
				HttpStatus.OK);
	}
	
}

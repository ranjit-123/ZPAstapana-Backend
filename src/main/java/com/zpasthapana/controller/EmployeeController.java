package com.zpasthapana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;
import com.zpasthapana.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody EmployeeRequest request){
		EmployeeResponse employeeResponse = employeeService.createEmployee(request);
		return new ResponseEntity<EmployeeResponse>(
				employeeResponse, HttpStatus.CREATED);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long employeeId, @RequestBody EmployeeRequest request){
		EmployeeResponse employeeResponse = employeeService.updateEmployee(employeeId, request);
		return new ResponseEntity<EmployeeResponse>(
				employeeResponse, HttpStatus.CREATED);
	}

}

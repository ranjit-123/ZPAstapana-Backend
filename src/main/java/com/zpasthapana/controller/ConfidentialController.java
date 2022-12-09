package com.zpasthapana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.entity.Confidential;
import com.zpasthapana.pojo.ConfidentialRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.ConfidentialService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("confidentials")
public class ConfidentialController {

	@Autowired
	ConfidentialService confidentialService; 
	
	@PostMapping
	public ResponseEntity<ResponseMessage> addConfidential(@RequestBody ConfidentialRequest request) {
		confidentialService.addConfidential(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Confidential>> getAllConfidential() {
		return new ResponseEntity<List<Confidential>>(confidentialService.getAllConfidential(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<List<Confidential>> getEmployeeConfidential(@PathVariable Long employeeId) {
		return new ResponseEntity<List<Confidential>>(confidentialService.getEmployeeConfidential(employeeId),
				HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<ResponseMessage> updateConfidential(@PathVariable Long employeeId, @RequestBody ConfidentialRequest request) {
		confidentialService.updateConfidential(employeeId, request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.OK).build(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<Confidential>> getAllConfidential(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<Confidential> pageData = confidentialService.getAllConfidential(paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<Confidential>>(pageData,
				HttpStatus.OK);
	}
}

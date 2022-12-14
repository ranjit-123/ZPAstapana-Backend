package com.zpasthapana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.entity.CriminalOffence;
import com.zpasthapana.pojo.CriminalOffenceRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.CriminalOffenceService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("criminal-offences")
public class CriminalOffenceController {

	@Autowired
	CriminalOffenceService criminalOffenceService; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addCriminalOffence(@ModelAttribute CriminalOffenceRequest request) {
		criminalOffenceService.addCriminalOffence(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CriminalOffence>> getAllCriminalOffence() {
		return new ResponseEntity<List<CriminalOffence>>(criminalOffenceService.getAllCriminalOffence(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<CriminalOffence>> getAllCriminalOffence(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<CriminalOffence> pageData = criminalOffenceService.getAllCriminalOffence(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<CriminalOffence>>(pageData,
				HttpStatus.OK);
	}
	
}

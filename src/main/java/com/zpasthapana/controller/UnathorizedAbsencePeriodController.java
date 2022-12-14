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

import com.zpasthapana.entity.UnathorizedAbsencePeriod;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.pojo.UnathorizedAbsencePeriodRequest;
import com.zpasthapana.service.UnathorizedAbsencePeriodService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("unathorized-absence-period")
public class UnathorizedAbsencePeriodController {

	@Autowired
	UnathorizedAbsencePeriodService unathorizedAbsencePeriodService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addUnathorizedAbsencePeriod(@ModelAttribute UnathorizedAbsencePeriodRequest request) {
		unathorizedAbsencePeriodService.addUnathorizedAbsencePeriod(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UnathorizedAbsencePeriod>> getAllUnathorizedAbsencePeriod() {
		return new ResponseEntity<List<UnathorizedAbsencePeriod>>(unathorizedAbsencePeriodService.getUnathorizedAbsencePeriod(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<UnathorizedAbsencePeriod>> getUnathorizedAbsencePeriod(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<UnathorizedAbsencePeriod> pageData = unathorizedAbsencePeriodService.getUnathorizedAbsencePeriod(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<UnathorizedAbsencePeriod>>(pageData,
				HttpStatus.OK);
	}

}

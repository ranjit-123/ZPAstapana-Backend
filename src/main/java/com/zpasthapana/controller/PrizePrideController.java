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

import com.zpasthapana.entity.PrizePrides;
import com.zpasthapana.pojo.PrizePridesRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.PrizePridesService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("prizes")
public class PrizePrideController {

	@Autowired
	PrizePridesService prizePridesService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addPrizePride(@ModelAttribute PrizePridesRequest request) {
		prizePridesService.addPrizePride(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}


	@GetMapping
	public ResponseEntity<List<PrizePrides>> getAllPrizePride() {
		return new ResponseEntity<List<PrizePrides>>(prizePridesService.getAllPrizePride(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<PrizePrides>> getAllPrizePride(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<PrizePrides> pageData = prizePridesService.getAllPrizePride(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<PrizePrides>>(pageData,
				HttpStatus.OK);
	}
	
}

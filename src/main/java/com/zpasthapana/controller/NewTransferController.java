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

import com.zpasthapana.entity.NewTransfer;
import com.zpasthapana.pojo.NewTransferRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.NewTransferService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("new-transfer")
public class NewTransferController {
	
	@Autowired
	NewTransferService newTransferService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addNewTransfer(@ModelAttribute NewTransferRequest request) {
		newTransferService.addNewTransfer(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<NewTransfer>> getAllNewTransfer() {
		return new ResponseEntity<List<NewTransfer>>(newTransferService.getAllNewTransfer(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<NewTransfer>> getAllNewTransfer(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<NewTransfer> pageData = newTransferService.getAllNewTransfer(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<NewTransfer>>(pageData,
				HttpStatus.OK);
	}
	
	@PostMapping("/inter-district/page")
	public ResponseEntity<ResponsePageDto<NewTransfer>> getAllDistrictNewTransfer(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<NewTransfer> pageData = newTransferService.getAllDistrictNewTransfer(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<NewTransfer>>(pageData,
				HttpStatus.OK);
	}
}

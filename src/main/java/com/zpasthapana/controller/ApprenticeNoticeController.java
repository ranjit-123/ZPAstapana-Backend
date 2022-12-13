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

import com.zpasthapana.entity.ApprenticeNotice;
import com.zpasthapana.pojo.ApprenticeNoticeRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.ApprenticeNoticeService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("apprentice-notices")
public class ApprenticeNoticeController {

	@Autowired
	ApprenticeNoticeService apprenticeNoticeService; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addApprenticeNotice(@ModelAttribute ApprenticeNoticeRequest request) {
		apprenticeNoticeService.addApprenticeNotice(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ApprenticeNotice>> getAllApprenticeNotice() {
		return new ResponseEntity<List<ApprenticeNotice>>(apprenticeNoticeService.getAllAssetLiability(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<ApprenticeNotice>> getAllApprenticeNotice(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<ApprenticeNotice> pageData = apprenticeNoticeService.getAllAssetLiability(paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<ApprenticeNotice>>(pageData,
				HttpStatus.OK);
	}
	
}

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

import com.zpasthapana.entity.RejectedPromotion;
import com.zpasthapana.pojo.RejectedPromotionRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.RejectedPromotionService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("rejected-promotions")
public class RejectedPromotionController {

	@Autowired
	RejectedPromotionService rejectedPromotionService; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addRejectedPromotion(@ModelAttribute RejectedPromotionRequest request) {
		rejectedPromotionService.addRejectedPromotion(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<RejectedPromotion>> getAllRejectedPromotion() {
		return new ResponseEntity<List<RejectedPromotion>>(rejectedPromotionService.getAllRejectedPromotion(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<RejectedPromotion>> getAllRejectedPromotion(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<RejectedPromotion> pageData = rejectedPromotionService.getAllRejectedPromotion(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<RejectedPromotion>>(pageData,
				HttpStatus.OK);
	}
	
}

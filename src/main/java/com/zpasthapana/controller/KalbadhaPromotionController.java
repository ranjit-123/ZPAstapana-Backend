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

import com.zpasthapana.entity.KalbadhaPromotion;
import com.zpasthapana.pojo.KalbadhaPromotionRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.KalbadhaPromotionService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("kalbadha-promotions")
public class KalbadhaPromotionController {

	@Autowired
	KalbadhaPromotionService kalbadhaPromotionService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addKalbadhaPromotion(@ModelAttribute KalbadhaPromotionRequest request){
		kalbadhaPromotionService.addKalbadhaPromotion(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<KalbadhaPromotion>> getAllKalbadhaPromotion() {
		return new ResponseEntity<List<KalbadhaPromotion>>(kalbadhaPromotionService.getAllPurchasePermission(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<KalbadhaPromotion>> getAllKalbadhaPromotion(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<KalbadhaPromotion> pageData = kalbadhaPromotionService.getAllPurchasePermission(paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<KalbadhaPromotion>>(pageData,
				HttpStatus.OK);
	}
}

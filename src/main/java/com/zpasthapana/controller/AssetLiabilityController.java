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

import com.zpasthapana.entity.AssetLiability;
import com.zpasthapana.pojo.AssetLiabilityRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.AssetLiabilityService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("asset-liabilities")
public class AssetLiabilityController {

	@Autowired
	AssetLiabilityService assetLiabilityService; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addAssetLiability(@ModelAttribute AssetLiabilityRequest request) {
		assetLiabilityService.addAssetLiability(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<AssetLiability>> getAllAssetLiability() {
		return new ResponseEntity<List<AssetLiability>>(assetLiabilityService.getAllAssetLiability(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<AssetLiability>> getAllAssetLiability(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<AssetLiability> pageData = assetLiabilityService.getAllAssetLiability(paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<AssetLiability>>(pageData,
				HttpStatus.OK);
	}

	
}

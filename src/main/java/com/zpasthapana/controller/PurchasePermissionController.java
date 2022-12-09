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

import com.zpasthapana.entity.PurchasePermission;
import com.zpasthapana.pojo.PurchasePermissionRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.PurchasePermissionsService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("purchase-permissions")
public class PurchasePermissionController {

	@Autowired
	PurchasePermissionsService purchasePermissionsService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addPurchasePermission(@ModelAttribute PurchasePermissionRequest request) {
		purchasePermissionsService.addPurchasePermissions(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PurchasePermission>> getAllPurchasePermission() {
		return new ResponseEntity<List<PurchasePermission>>(purchasePermissionsService.getAllPurchasePermission(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<PurchasePermission>> getAllPurchasePermission(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<PurchasePermission> pageData = purchasePermissionsService.getAllPurchasePermission(paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<PurchasePermission>>(pageData,
				HttpStatus.OK);
	}

}

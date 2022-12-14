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

import com.zpasthapana.entity.ExtraOrdinaryLeaves;
import com.zpasthapana.pojo.ExtraOrdinaryLeaveRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.ExtraOrdinaryLeavesService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("extra-ordinary-leaves")
public class ExtraOrdinaryLeaveController {
	
	@Autowired
	ExtraOrdinaryLeavesService extraOrdinaryLeavesService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addExtraOrdinaryLeave(@ModelAttribute ExtraOrdinaryLeaveRequest request){
		extraOrdinaryLeavesService.addExtraOrdinaryLeave(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ExtraOrdinaryLeaves>> getAllCourtCase() {
		return new ResponseEntity<List<ExtraOrdinaryLeaves>>(extraOrdinaryLeavesService.getAllAssetLiability(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<ExtraOrdinaryLeaves>> getAllCourtCase(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<ExtraOrdinaryLeaves> pageData = extraOrdinaryLeavesService.getAllAssetLiability(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<ExtraOrdinaryLeaves>>(pageData,
				HttpStatus.OK);
	}

}

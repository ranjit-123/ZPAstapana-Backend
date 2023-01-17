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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.entity.StayitvaPramanpatra;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.StayitvaPramanpatraRequest;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.StayitvaPramanpatraService;
import com.zpasthapana.util.ZPUtility;

@RestController
@RequestMapping("stayitva-pramanpatra")
public class StayitvaPramanpatraController {
	
	@Autowired
	StayitvaPramanpatraService stayitvaPramanpatra; 
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseMessage> addStayitvaPramanpatra(@ModelAttribute StayitvaPramanpatraRequest request) {
		stayitvaPramanpatra.addStayitvaPramanpatra(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<StayitvaPramanpatra>> getAllStayitvaPramanpatra() {
		return new ResponseEntity<List<StayitvaPramanpatra>>(stayitvaPramanpatra.getAllStayitvaPramanpatra(),
				HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<List<StayitvaPramanpatra>> getEmployeeStayitvaPramanpatra(@PathVariable Long employeeId) {
		return new ResponseEntity<List<StayitvaPramanpatra>>(stayitvaPramanpatra.getEmployeeStayitvaPramanpatra(employeeId),
				HttpStatus.OK);
	}
	
	@PutMapping("/{employeeId}")
	public ResponseEntity<ResponseMessage> updateStayitvaPramanpatra(@PathVariable Long employeeId, @RequestBody StayitvaPramanpatraRequest request) {
		stayitvaPramanpatra.updateStayitvaPramanpatra(employeeId, request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.OK).build(),
				HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<StayitvaPramanpatra>> getAllCourtCase(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<StayitvaPramanpatra> pageData = stayitvaPramanpatra.getAllStayitvaPramanpatra(pageRequest, paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<StayitvaPramanpatra>>(pageData,
				HttpStatus.OK);
	}
	

}

package com.zpasthapana.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.MasterDropDownPojo;
import com.zpasthapana.service.MasterDropDownService;

@RestController
@RequestMapping("master")
public class MasterDropDownController {

	@Autowired
	private MasterDropDownService masterDropDownService;

	@GetMapping
	public ResponseEntity<List<MasterDropDownPojo>> getDetails(@RequestParam Map<String, String> queryParam) {
		return new ResponseEntity<>(masterDropDownService.getDetails(queryParam), HttpStatus.OK);
	}

}

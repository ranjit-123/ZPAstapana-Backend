package com.zpasthapana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.NewPublicCommRequest;
import com.zpasthapana.pojo.ResponseMessage;
import com.zpasthapana.service.NewPublicCommService;

@RestController
@RequestMapping("other-reports")
public class NewPublicCommissionerController {

	@Autowired
	NewPublicCommService newPublicCommService;

	@PostMapping("/new-public-commissioner/{userId}")
	public ResponseEntity<ResponseMessage> addNewPublicCommissioner(@PathVariable Long userId,
			@RequestBody NewPublicCommRequest request) {
		newPublicCommService.addNewPublicCommissioner(request);
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().status(HttpStatus.CREATED).build(),
				HttpStatus.CREATED);
	}

}

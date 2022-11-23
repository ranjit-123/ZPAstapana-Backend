package com.zpasthapana.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.UserPojo;
import com.zpasthapana.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("{id}")
	public ResponseEntity<UserPojo> getUserById(@PathVariable Long id) {
		Optional<UserPojo> user = userService.getUserById(id);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping
	public ResponseEntity<UserPojo> updateUserInfo(@RequestBody UserPojo user) {
		Optional<UserPojo> userResp = userService.updateUserInfo(user);
		if (userResp.isPresent()) {
			return ResponseEntity.ok(userResp.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}

package com.zpasthapana.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.entity.User;
import com.zpasthapana.pojo.AuthResponse;
import com.zpasthapana.pojo.UserPojo;
import com.zpasthapana.service.UserService;
import com.zpasthapana.util.JwtTokenUtil;
import com.zpasthapana.util.ZPStaticDetailsService;

@RestController
@RequestMapping("authenticate")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ZPStaticDetailsService zPStaticDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping
	public ResponseEntity<AuthResponse> authenticate(@RequestBody UserPojo user) throws UsernameNotFoundException {
		Optional<User> userResponse = userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (userResponse.isPresent()) {
			String token = jwtTokenUtil.generateToken(userResponse.get().getUserName(), "user");
			zPStaticDetailsService.loadManjurPade(userResponse.get());
			String zpName = zPStaticDetailsService.getZPNameByZPID(userResponse.get().getZillaParishadID());
			return ResponseEntity.ok(new AuthResponse(token, userResponse.get().getUserId(),zpName));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}

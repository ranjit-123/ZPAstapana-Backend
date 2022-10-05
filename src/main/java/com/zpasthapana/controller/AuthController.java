package com.zpasthapana.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.pojo.AuthResponse;
import com.zpasthapana.pojo.User;
import com.zpasthapana.service.UserService;

@RestController
@RequestMapping("authenticate")
public class AuthController {

	@Autowired
	private UserService userService;

	public ResponseEntity<AuthResponse> authenticate(@RequestBody User user) throws UsernameNotFoundException {
		Optional<com.zpasthapana.entity.User> userResponse = userService.findByUserNameAndPassword(user.getUserName(),
				user.getPassword());
//		if (user.isPresent()) {
//			String token = jwtTokenUtil.generateToken(user.get().getEmail(), "user");
//			return ResponseEntity.ok(new JwtResponse(token, user.get().getUserId()));
//		} else {
//			throw new LoginUnauthorizedException();
//		}
		return null;// generate the token and pass back
	}
}

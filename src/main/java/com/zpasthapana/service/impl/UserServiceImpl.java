package com.zpasthapana.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zpasthapana.repo.UserRepo;
import com.zpasthapana.service.UserService;
import com.zpasthapana.util.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		String userEmail = jwtTokenUtil.getUsernameFromToken(username);
//
//		Optional<User> user = userService.findByEmail(userEmail);
//
//		if (user.isPresent()) {
//			return new User(user.get().getEmail(), "", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}

		return new User("", "", new ArrayList<>());
	}

	@Override
	public Optional<com.zpasthapana.entity.User> findByUserNameAndPassword(String userName, String password)
			throws UsernameNotFoundException {
		Optional<com.zpasthapana.entity.User> user = userRepo.findByUserNameAndPassword(userName, password);
		if (user.isPresent()) {
			return user;
		}
		throw new UsernameNotFoundException("Not Found");

	}

}
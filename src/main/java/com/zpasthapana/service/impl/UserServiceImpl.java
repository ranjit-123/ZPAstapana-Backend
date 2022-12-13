package com.zpasthapana.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zpasthapana.entity.User;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UserPojo;
import com.zpasthapana.repo.UserRepo;
import com.zpasthapana.service.UserService;
import com.zpasthapana.util.JwtTokenUtil;
import com.zpasthapana.util.ZPUtility;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {

		String userEmail = jwtTokenUtil.getUsernameFromToken(token);

		Optional<User> user = userRepo.findByUserName(userEmail);

		if (user.isPresent()) {
			return new org.springframework.security.core.userdetails.User(user.get().getUserName(), "",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + userEmail);
		}
	}

	@Override
	public Optional<User> findByUserNameAndPassword(String userName, String password) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserNameAndPassword(userName, password);
		if (user.isPresent()) {
			return user;
		}
		throw new UsernameNotFoundException("Not Found");

	}

	@Override
	public Optional<UserPojo> getUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent()) {
			return Optional.of(objectMapper.convertValue(user.get(), UserPojo.class));
		}
		return Optional.empty();
	}

	@Override
	@Transactional
	public Optional<UserPojo> updateUserInfo(UserPojo userReq) {
		Optional<User> user = userRepo.findById(userReq.getUserId());
		if (user.isPresent()) {
			User userToUpdate = user.get();
			String password = user.get().getPassword();
			userToUpdate = objectMapper.convertValue(userReq, User.class);
			userToUpdate.setPassword(password);
			userRepo.save(userToUpdate);
		}
		return Optional.of(userReq);
	}

	@Override
	public ResponsePageDto<User> getAllUsers(Pageable paging) {
		return ZPUtility.getPage(paging, userRepo.findAll(paging));
	}

}
package com.zpasthapana.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zpasthapana.entity.User;



public interface UserService extends UserDetailsService {

	Optional<User> findByUserNameAndPassword(String userName, String password) throws UsernameNotFoundException;

}

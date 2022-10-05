package com.zpasthapana.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByUserNameAndPassword(String userName, String password);

}

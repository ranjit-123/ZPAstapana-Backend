package com.zpasthapana.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByUserNameAndPassword(String userName, String password);

	Optional<User> findByUserName(String userName);

}

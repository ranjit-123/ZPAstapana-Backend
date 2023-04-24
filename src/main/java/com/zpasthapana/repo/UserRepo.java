package com.zpasthapana.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zpasthapana.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByUserNameAndPassword(String userName, String password);

	Optional<User> findByUserName(String userName);
	
	@Query(value = "select e from User e where e.isActive = 1 and (:zpId is null or e.zillaParishadID = :zpId) "
			+ " and (:devisionId is null or e.divisionID = :devisionId) and (:departmentId is null or e.departmentID = :departmentId)"
			+ " and (:talukaId is null or e.talukaID = :talukaId)")
	Page<User> findAllUsers(Long devisionId, Long zpId, Long departmentId, Long talukaId,
			Pageable paging);

}

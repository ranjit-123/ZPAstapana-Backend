package com.zpasthapana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.EmployeeTypingDetails;

public interface EmployeeTypingDetailsRepo extends JpaRepository<EmployeeTypingDetails, Long>{
	EmployeeTypingDetails findByEmployeeId(Long employeeId);
}

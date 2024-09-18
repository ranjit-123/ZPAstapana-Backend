package com.zpasthapana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.EmployeeJoinDetails;

public interface EmployeeJoinDetailsRepo extends JpaRepository<EmployeeJoinDetails, Long>{
	EmployeeJoinDetails findByEmployeeId(Long employeeId);
}

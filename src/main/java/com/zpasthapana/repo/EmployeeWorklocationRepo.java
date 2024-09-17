package com.zpasthapana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.EmployeeWorklocation;

public interface EmployeeWorklocationRepo extends JpaRepository<EmployeeWorklocation, Long>{
	EmployeeWorklocation findByEmployeeId(Long employeeId);
}

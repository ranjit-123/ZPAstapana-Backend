package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.EmployeeWorklocation;

public interface EmployeeWorklocationRepo extends JpaRepository<EmployeeWorklocation, Long>{
	List<EmployeeWorklocation> findByEmployeeId(Long employeeId);
}

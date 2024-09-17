package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.EmployeeEducation;

public interface EmployeeEducationRepo extends JpaRepository<EmployeeEducation, Long> {
	List<EmployeeEducation> findByEmployeeId(Long employeeId);
}

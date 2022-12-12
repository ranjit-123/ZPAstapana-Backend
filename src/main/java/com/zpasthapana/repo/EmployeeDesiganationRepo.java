package com.zpasthapana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.EmployeeDesiganation;

public interface EmployeeDesiganationRepo extends JpaRepository<EmployeeDesiganation, Long>{

	EmployeeDesiganation findAllByEmployeeIdAndIsCurrent(Long employeeId, Boolean true1);

}

package com.zpasthapana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}

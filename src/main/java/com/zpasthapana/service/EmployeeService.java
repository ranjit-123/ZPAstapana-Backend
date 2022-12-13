package com.zpasthapana.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.Employee;
import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;
import com.zpasthapana.pojo.ResponsePageDto;

public interface EmployeeService {
	EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

	EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest request);

	List<Employee> getAllEmployee();

	ResponsePageDto<Employee> getAllAssetLiability(Pageable paging);

	Optional<Employee> getEmployeeById(Long employeeId);

	ResponsePageDto<Employee> getAllRetieredEmployees(Pageable paging);

	ResponsePageDto<Employee> getAllWorkingEmployees(Pageable paging);
}

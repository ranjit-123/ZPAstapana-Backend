package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.entity.Employee;
import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;

public interface EmployeeService {
	EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

	EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest request);

	List<Employee> getAllEmployee();
}

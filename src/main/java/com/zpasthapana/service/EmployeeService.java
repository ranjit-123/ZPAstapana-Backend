package com.zpasthapana.service;

import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;

public interface EmployeeService {
	EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

	EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest request);
}

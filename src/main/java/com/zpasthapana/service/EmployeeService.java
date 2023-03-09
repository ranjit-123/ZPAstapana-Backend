package com.zpasthapana.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.Employee;
import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface EmployeeService {
	EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

	EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest request);

	List<Employee> getAllEmployee();

	ResponsePageDto<Employee> getAllAssetLiability(UIPageRequest pageRequest, Pageable paging);

	Optional<Employee> getEmployeeById(Long employeeId);

	ResponsePageDto<Employee> getAllRetieredEmployees(UIPageRequest pageRequest, Pageable paging);

	ResponsePageDto<Employee> getAllWorkingEmployees(UIPageRequest pageRequest, Pageable paging);

	void deactivateEmployee(Long employeeId);
}

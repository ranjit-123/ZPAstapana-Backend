package com.zpasthapana.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zpasthapana.entity.BaseEntity;
import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.EmployeeCastDetails;
import com.zpasthapana.entity.EmployeeDesiganation;
import com.zpasthapana.entity.EmployeeWorklocation;
import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.service.EmployeeService;
import com.zpasthapana.util.MasterDataUtil;
import com.zpasthapana.util.ZPUtility;


@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeResponse> createEmployee(@ModelAttribute EmployeeRequest request){
		EmployeeResponse employeeResponse = employeeService.createEmployee(request);
		return new ResponseEntity<EmployeeResponse>(
				employeeResponse, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{employeeId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long employeeId, @ModelAttribute EmployeeRequest request){
		EmployeeResponse employeeResponse = employeeService.updateEmployee(employeeId, request);
		return new ResponseEntity<EmployeeResponse>(
				employeeResponse, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<List<Employee>>(
				employeeService.getAllEmployee(), HttpStatus.OK);
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<BaseEntity> getEmployee(@PathVariable Long employeeId){
		Optional<Employee> employee = employeeService.getEmployeeById(employeeId);
		if(employee.isEmpty()) {
			throw new EntityNotFoundException("Employee not exist");
		}
		BaseEntity e = employee.get();
		if(ObjectUtils.isNotEmpty(employee.get().getEmployeeDesiganation())) {
			e.payCommissionName = MasterDataUtil.getKeyDate("paycommission_", employee.get().getEmployeeDesiganation().getPayCommission());
		}
		e.employeeFullName = employee.get().getFirstName() + " " + employee.get().getMiddleName() + " " + employee.get().getLastName();
		e.employeeFullNameEng = employee.get().getFirstNameEng() + " " + employee.get().getMiddleNameEng() + " " + employee.get().getLastNameEng();
		
		if(ObjectUtils.isNotEmpty(employee.get().getEmployeeWorkLocation())) {
			EmployeeWorklocation em = employee.get().getEmployeeWorkLocation();
			e.talukaName = MasterDataUtil.getKeyDate("taluka_", em.getTaluka());
			e.subDivisionName = MasterDataUtil.getKeyDate("subdivision_", em.getSubDivision());
			e.subDepartmentName = MasterDataUtil.getKeyDate("subdepartment_", em.getSubDepartment()); 		
		}
		
		if(ObjectUtils.isNotEmpty(employee.get().getEmployeeDesiganation())) {
			EmployeeDesiganation emDesignation = employee.get().getEmployeeDesiganation();
			e.designationName = MasterDataUtil.getKeyDate("designation_", emDesignation.getEmployeeDesiganationId());
		}
		
		if(ObjectUtils.isNotEmpty(employee.get().getEmployeeCastDetails())) {
			EmployeeCastDetails ec = employee.get().getEmployeeCastDetails();
			e.castCategoryName = MasterDataUtil.getKeyDate("castecategory_", ec.getCastecategory());
		}
		
		return new ResponseEntity<BaseEntity>(
				e, HttpStatus.OK);
	}
	
	@PostMapping("/page")
	public ResponseEntity<ResponsePageDto<Employee>> getAllCourtCase(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<Employee> pageData = employeeService.getAllAssetLiability(paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<Employee>>(pageData,
				HttpStatus.OK);
	}
	
	@PostMapping("/retiered/page")
	public ResponseEntity<ResponsePageDto<Employee>> getAllRetieredEmployees(@RequestBody UIPageRequest pageRequest) {
		Pageable paging = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), ZPUtility.getSort(pageRequest.getSortFields()));
		ResponsePageDto<Employee> pageData = employeeService.getAllRetieredEmployees(paging);
		pageData.setDraw(pageRequest.getPageNumber() + 1);
		return new ResponseEntity<ResponsePageDto<Employee>>(pageData,
				HttpStatus.OK);
	}

}

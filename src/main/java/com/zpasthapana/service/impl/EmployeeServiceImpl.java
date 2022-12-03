package com.zpasthapana.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.EmployeeBasicDetails;
import com.zpasthapana.entity.EmployeeCastDetails;
import com.zpasthapana.entity.EmployeeDesiganation;
import com.zpasthapana.entity.EmployeeDisability;
import com.zpasthapana.entity.EmployeeEducation;
import com.zpasthapana.entity.EmployeeFlag;
import com.zpasthapana.entity.EmployeeJoinDetails;
import com.zpasthapana.entity.EmployeeTypingDetails;
import com.zpasthapana.entity.EmployeeWorklocation;
import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;
import com.zpasthapana.repo.EmployeeBasicDetailsRepo;
import com.zpasthapana.repo.EmployeeCastDetailsRepo;
import com.zpasthapana.repo.EmployeeDesiganationRepo;
import com.zpasthapana.repo.EmployeeDisabilityRepo;
import com.zpasthapana.repo.EmployeeEducationRepo;
import com.zpasthapana.repo.EmployeeFlagRepo;
import com.zpasthapana.repo.EmployeeJoinDetailsRepo;
import com.zpasthapana.repo.EmployeeRepo;
import com.zpasthapana.repo.EmployeeTypingDetailsRepo;
import com.zpasthapana.repo.EmployeeWorklocationRepo;
import com.zpasthapana.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo employeeRepo; 
	
	@Autowired
	EmployeeBasicDetailsRepo employeeBasicDetailsRepo; 
	
	@Autowired
	EmployeeCastDetailsRepo employeeCastDetailsRepo; 
	
	@Autowired
	EmployeeDesiganationRepo employeeDesiganationRepo; 
	
	@Autowired
	EmployeeDisabilityRepo employeeDisabilityRepo; 
	
	@Autowired
	EmployeeEducationRepo employeeEducationRepo; 
	
	@Autowired
	EmployeeFlagRepo employeeFlagRepo; 
	
	@Autowired
	EmployeeJoinDetailsRepo employeeJoinDetailsRepo; 
	
	@Autowired
	EmployeeTypingDetailsRepo employeeTypingDetailsRepo; 
	
	@Autowired
	EmployeeWorklocationRepo employeeWorklocationRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
		
		log.info("Insert employee");
		
		EmployeeResponse response = EmployeeResponse.builder().build();
		
		Employee employee = modelMapper.map(employeeRequest, Employee.class);
		employee = employeeRepo.save(employee);
		employeeRequest.setEmployeeId(employee.getEmployeeId());
		
		response = modelMapper.map(employee, EmployeeResponse.class);
		
		EmployeeBasicDetails employeeBasicDetails = modelMapper.map(employeeRequest, EmployeeBasicDetails.class);
		employeeBasicDetails = employeeBasicDetailsRepo.save(employeeBasicDetails);
		
		response = modelMapper.map(employeeBasicDetails, EmployeeResponse.class);
		
		EmployeeCastDetails employeeCastDetails = modelMapper.map(employeeRequest, EmployeeCastDetails.class);
		employeeCastDetails = employeeCastDetailsRepo.save(employeeCastDetails);
		response = modelMapper.map(employeeCastDetails, EmployeeResponse.class);
		
		EmployeeDesiganation employeeDesiganation = modelMapper.map(employeeRequest, EmployeeDesiganation.class);
		employeeDesiganation = employeeDesiganationRepo.save(employeeDesiganation);
		response = modelMapper.map(employeeDesiganation, EmployeeResponse.class);
		
		EmployeeDisability employeeDisability = modelMapper.map(employeeRequest, EmployeeDisability.class);
		employeeDisability = employeeDisabilityRepo.save(employeeDisability);
		response = modelMapper.map(employeeDisability, EmployeeResponse.class);
		
		EmployeeEducation employeeEducation = modelMapper.map(employeeRequest, EmployeeEducation.class);
		employeeEducation = employeeEducationRepo.save(employeeEducation);
		response = modelMapper.map(employeeEducation, EmployeeResponse.class);
		
		EmployeeFlag employeeFlag = modelMapper.map(employeeRequest, EmployeeFlag.class);
		employeeFlag = employeeFlagRepo.save(employeeFlag);
		response = modelMapper.map(employeeFlag, EmployeeResponse.class);
		
		EmployeeJoinDetails employeeJoinDetails = modelMapper.map(employeeRequest, EmployeeJoinDetails.class);
		employeeJoinDetails = employeeJoinDetailsRepo.save(employeeJoinDetails);
		response = modelMapper.map(employeeJoinDetails, EmployeeResponse.class);
		
		EmployeeTypingDetails employeeTypingDetails = modelMapper.map(employeeRequest, EmployeeTypingDetails.class);
		employeeTypingDetails = employeeTypingDetailsRepo.save(employeeTypingDetails);
		response = modelMapper.map(employeeTypingDetails, EmployeeResponse.class);
		
		EmployeeWorklocation employeeWorklocation = modelMapper.map(employeeRequest, EmployeeWorklocation.class);
		employeeWorklocation = employeeWorklocationRepo.save(employeeWorklocation);	
		response = modelMapper.map(employeeWorklocation, EmployeeResponse.class);
		
		return response;
	}

	@Override
	public EmployeeResponse updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {
		log.info("Insert employee");
		
		EmployeeResponse response = EmployeeResponse.builder().build();
		
		Optional<Employee> employeeEntity = employeeRepo.findById(employeeId);
		
		if(employeeEntity.isEmpty()) {
			throw new EntityNotFoundException("Employee not found");
		}
		
		Employee employee = modelMapper.map(employeeRequest, Employee.class);
		employee.setEmployeeId(employeeId);
		employee = employeeRepo.save(employee);
	
		employeeRequest.setEmployeeId(employeeId);
		response = modelMapper.map(employee, EmployeeResponse.class);
		
		EmployeeBasicDetails employeeBasicDetails = modelMapper.map(employeeRequest, EmployeeBasicDetails.class);
		employeeBasicDetails = employeeBasicDetailsRepo.save(employeeBasicDetails);
		
		response = modelMapper.map(employeeBasicDetails, EmployeeResponse.class);
		
		EmployeeCastDetails employeeCastDetails = modelMapper.map(employeeRequest, EmployeeCastDetails.class);
		employeeCastDetails = employeeCastDetailsRepo.save(employeeCastDetails);
		response = modelMapper.map(employeeCastDetails, EmployeeResponse.class);
		
		EmployeeDesiganation employeeDesiganation = modelMapper.map(employeeRequest, EmployeeDesiganation.class);
		employeeDesiganation = employeeDesiganationRepo.save(employeeDesiganation);
		response = modelMapper.map(employeeDesiganation, EmployeeResponse.class);
		
		EmployeeDisability employeeDisability = modelMapper.map(employeeRequest, EmployeeDisability.class);
		employeeDisability = employeeDisabilityRepo.save(employeeDisability);
		response = modelMapper.map(employeeDisability, EmployeeResponse.class);
		
		EmployeeEducation employeeEducation = modelMapper.map(employeeRequest, EmployeeEducation.class);
		employeeEducation = employeeEducationRepo.save(employeeEducation);
		response = modelMapper.map(employeeEducation, EmployeeResponse.class);
		
		EmployeeFlag employeeFlag = modelMapper.map(employeeRequest, EmployeeFlag.class);
		employeeFlag = employeeFlagRepo.save(employeeFlag);
		response = modelMapper.map(employeeFlag, EmployeeResponse.class);
		
		EmployeeJoinDetails employeeJoinDetails = modelMapper.map(employeeRequest, EmployeeJoinDetails.class);
		employeeJoinDetails = employeeJoinDetailsRepo.save(employeeJoinDetails);
		response = modelMapper.map(employeeJoinDetails, EmployeeResponse.class);
		
		EmployeeTypingDetails employeeTypingDetails = modelMapper.map(employeeRequest, EmployeeTypingDetails.class);
		employeeTypingDetails = employeeTypingDetailsRepo.save(employeeTypingDetails);
		response = modelMapper.map(employeeTypingDetails, EmployeeResponse.class);
		
		EmployeeWorklocation employeeWorklocation = modelMapper.map(employeeRequest, EmployeeWorklocation.class);
		employeeWorklocation = employeeWorklocationRepo.save(employeeWorklocation);	
		response = modelMapper.map(employeeWorklocation, EmployeeResponse.class);
		
		return response;
	}

}

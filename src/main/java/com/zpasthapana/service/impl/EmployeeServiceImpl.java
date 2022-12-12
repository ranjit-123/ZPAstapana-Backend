package com.zpasthapana.service.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zpasthapana.entity.ConcessionDetails;
import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.EmployeeCastDetails;
import com.zpasthapana.entity.EmployeeDesiganation;
import com.zpasthapana.entity.EmployeeDisability;
import com.zpasthapana.entity.EmployeeEducation;
import com.zpasthapana.entity.EmployeeFlag;
import com.zpasthapana.entity.EmployeeJoinDetails;
import com.zpasthapana.entity.EmployeeLanguageExam;
import com.zpasthapana.entity.EmployeeNomineeDetails;
import com.zpasthapana.entity.EmployeeTypingDetails;
import com.zpasthapana.entity.EmployeeWorklocation;
import com.zpasthapana.pojo.EmployeeRequest;
import com.zpasthapana.pojo.EmployeeResponse;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.ConcessionDetailsRepo;
import com.zpasthapana.repo.EmployeeCastDetailsRepo;
import com.zpasthapana.repo.EmployeeDesiganationRepo;
import com.zpasthapana.repo.EmployeeDisabilityRepo;
import com.zpasthapana.repo.EmployeeEducationRepo;
import com.zpasthapana.repo.EmployeeFlagRepo;
import com.zpasthapana.repo.EmployeeJoinDetailsRepo;
import com.zpasthapana.repo.EmployeeLanguageExamRepo;
import com.zpasthapana.repo.EmployeeNomineeDetailsRepo;
import com.zpasthapana.repo.EmployeeRepo;
import com.zpasthapana.repo.EmployeeTypingDetailsRepo;
import com.zpasthapana.repo.EmployeeWorklocationRepo;
import com.zpasthapana.service.EmployeeService;
import com.zpasthapana.util.ZPUtility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo employeeRepo; 
	
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
	ConcessionDetailsRepo concessionDetailsRepo; 
	
	@Autowired
	EmployeeLanguageExamRepo employeeLanguageExamRepo; 
	
	@Autowired
	EmployeeNomineeDetailsRepo employeeNomineeDetailsRepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
		try {
			log.info("Insert employee");
			
			EmployeeResponse response = EmployeeResponse.builder().build();
			
			Employee employee = modelMapper.map(employeeRequest, Employee.class);
			
			employee = employeeRepo.save(employee);
			employeeRequest.setEmployeeId(employee.getEmployeeId());
			ZPUtility.uploadFiles(employeeRequest, null, employeeRequest.getEmployeeId());
			
			response = modelMapper.map(employee, EmployeeResponse.class);
			
			EmployeeCastDetails employeeCastDetails = modelMapper.map(employeeRequest, EmployeeCastDetails.class);
			
			
			List<Field> fields = List.of(employeeRequest.getClass().getDeclaredFields()).stream()
					.filter(f -> f.getType() == MultipartFile.class).collect(Collectors.toList());
			
			ZPUtility.updateFileNames(employeeRequest, employeeCastDetails, fields);
			
			employeeCastDetails = employeeCastDetailsRepo.save(employeeCastDetails);
			response = modelMapper.map(employeeCastDetails, EmployeeResponse.class);
			
			EmployeeDesiganation employeeDesiganation = modelMapper.map(employeeRequest, EmployeeDesiganation.class);
			ZPUtility.updateFileNames(employeeRequest, employeeDesiganation, fields);
			employeeDesiganation = employeeDesiganationRepo.save(employeeDesiganation);
			response = modelMapper.map(employeeDesiganation, EmployeeResponse.class);
			
			employee.setEmployeeDesiganationDetailsId(employeeDesiganation.getEmployeeDesiganationDetailsId());
			
			EmployeeDisability employeeDisability = modelMapper.map(employeeRequest, EmployeeDisability.class);
			ZPUtility.updateFileNames(employeeRequest, employeeDisability, fields);
			employeeDisability = employeeDisabilityRepo.save(employeeDisability);
			response = modelMapper.map(employeeDisability, EmployeeResponse.class);
			
			EmployeeEducation employeeEducation = modelMapper.map(employeeRequest, EmployeeEducation.class);
			ZPUtility.updateFileNames(employeeRequest, employeeDisability, fields);
			employeeEducation = employeeEducationRepo.save(employeeEducation);
			response = modelMapper.map(employeeEducation, EmployeeResponse.class);
			
			EmployeeFlag employeeFlag = modelMapper.map(employeeRequest, EmployeeFlag.class);
			employeeFlag = employeeFlagRepo.save(employeeFlag);
			response = modelMapper.map(employeeFlag, EmployeeResponse.class);
			
			EmployeeJoinDetails employeeJoinDetails = modelMapper.map(employeeRequest, EmployeeJoinDetails.class);
			ZPUtility.updateFileNames(employeeRequest, employeeJoinDetails, fields);
			employeeJoinDetails = employeeJoinDetailsRepo.save(employeeJoinDetails);
			response = modelMapper.map(employeeJoinDetails, EmployeeResponse.class);
			
			EmployeeTypingDetails employeeTypingDetails = modelMapper.map(employeeRequest, EmployeeTypingDetails.class);
			ZPUtility.updateFileNames(employeeRequest, employeeTypingDetails, fields);
			employeeTypingDetails = employeeTypingDetailsRepo.save(employeeTypingDetails);
			response = modelMapper.map(employeeTypingDetails, EmployeeResponse.class);
			
			EmployeeWorklocation employeeWorklocation = modelMapper.map(employeeRequest, EmployeeWorklocation.class);
			employeeWorklocation = employeeWorklocationRepo.save(employeeWorklocation);	
			response = modelMapper.map(employeeWorklocation, EmployeeResponse.class);
			
			employee.setEmployeeWorklocationId(employeeWorklocation.getEmployeeWorklocationId());
			
			ConcessionDetails concessionDetails = modelMapper.map(employeeRequest, ConcessionDetails.class);
			ZPUtility.updateFileNames(employeeRequest, concessionDetails, fields);
			concessionDetails = concessionDetailsRepo.save(concessionDetails);	
			response = modelMapper.map(concessionDetails, EmployeeResponse.class);
			
			EmployeeNomineeDetails employeeNomineeDetails = modelMapper.map(employeeRequest, EmployeeNomineeDetails.class);
			ZPUtility.updateFileNames(employeeRequest, employeeNomineeDetails, fields);
			employeeNomineeDetails = employeeNomineeDetailsRepo.save(employeeNomineeDetails);	
			response = modelMapper.map(employeeNomineeDetails, EmployeeResponse.class);
			
			EmployeeLanguageExam employeeLanguageExam = modelMapper.map(employeeRequest, EmployeeLanguageExam.class);
			ZPUtility.updateFileNames(employeeRequest, employeeLanguageExam, fields);
			employeeLanguageExam = employeeLanguageExamRepo.save(employeeLanguageExam);	
			response = modelMapper.map(concessionDetails, EmployeeResponse.class);
			
			employee = employeeRepo.save(employee);
			response = modelMapper.map(employee, EmployeeResponse.class);
			
			return response;
		} catch (Exception e) {
			log.error("Exception: ", e);
			throw e;
		}
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
	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	@Override
	public ResponsePageDto<Employee> getAllAssetLiability(Pageable paging) {
		return ZPUtility.getPage(paging, employeeRepo.findAll(paging));
	}

	@Override
	public Optional<Employee> getEmployeeById(Long employeeId) {
		return employeeRepo.findById(employeeId);
	}

}

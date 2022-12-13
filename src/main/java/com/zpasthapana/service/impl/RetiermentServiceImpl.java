package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.Retierment;
import com.zpasthapana.pojo.RetiermentRequest;
import com.zpasthapana.repo.EmployeeRepo;
import com.zpasthapana.repo.RetiermentRepo;
import com.zpasthapana.service.RetiermentService;

@Service
public class RetiermentServiceImpl implements RetiermentService {

	@Autowired
	RetiermentRepo retiermentRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addRetirement(RetiermentRequest request) {
		Retierment r = retiermentRepo.save(modelMapper.map(request, Retierment.class));
		Employee emp = employeeRepo.findById(request.getEmployeeId()).get();
		emp.setRetiermentId(r.getId());
		employeeRepo.save(emp);
	}

	@Override
	public List<Retierment> getAllRetirement() {
		return retiermentRepo.findAll();
	}

	@Override
	public List<Retierment> getEmployeeRetirement(Long employeeId) {
		return retiermentRepo.findAllByEmployeeId(employeeId);
	}

	@Override
	public void updateRetierment(Long employeeId, RetiermentRequest request) {
		// TODO Auto-generated method stub
		
	}

}

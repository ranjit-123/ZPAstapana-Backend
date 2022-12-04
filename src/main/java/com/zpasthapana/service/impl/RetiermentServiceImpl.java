package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Retierment;
import com.zpasthapana.pojo.RetiermentRequest;
import com.zpasthapana.repo.RetiermentRepo;
import com.zpasthapana.service.RetiermentService;

@Service
public class RetiermentServiceImpl implements RetiermentService {

	@Autowired
	RetiermentRepo retiermentRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addRetirement(RetiermentRequest request) {
		retiermentRepo.save(modelMapper.map(request, Retierment.class));
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

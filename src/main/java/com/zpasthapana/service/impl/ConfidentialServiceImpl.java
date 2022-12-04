package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Confidential;
import com.zpasthapana.pojo.ConfidentialRequest;
import com.zpasthapana.repo.ConfidentialRepo;
import com.zpasthapana.service.ConfidentialService;

@Service
public class ConfidentialServiceImpl implements ConfidentialService{

	@Autowired
	ConfidentialRepo confidentialRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addConfidential(ConfidentialRequest request) {
		confidentialRepo.save(modelMapper.map(request, Confidential.class));
	}

	@Override
	public List<Confidential> getAllConfidential() {
		return confidentialRepo.findAll();
	}

	@Override
	public List<Confidential> getEmployeeConfidential(Long employeeId) {
		return confidentialRepo.findAllByEmployeeId(employeeId);
	}

	@Override
	public void updateConfidential(Long employeeId, ConfidentialRequest request) {
		// TODO Auto-generated method stub
		
	}

}

package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.AccidentalInsurance;
import com.zpasthapana.pojo.AccidentalInsuranceRequest;
import com.zpasthapana.repo.AccidentalInsuranceRepo;
import com.zpasthapana.service.AccidentalInsuranceService;
import com.zpasthapana.util.ZPUtility;

@Service
public class AccidentalInsuranceServiceImpl implements AccidentalInsuranceService {

	@Autowired
	AccidentalInsuranceRepo accidentalInsuranceRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addAccidentalInsurance(AccidentalInsuranceRequest request) {
		AccidentalInsurance entity = modelMapper.map(request, AccidentalInsurance.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		accidentalInsuranceRepo.save(entity);
	}

	@Override
	public List<AccidentalInsurance> getAllAccidentalInsurance() {
		return accidentalInsuranceRepo.findAll();
	}

	@Override
	public List<AccidentalInsurance> getEmployeeAccidentalInsurance(Long employeeId) {
		return accidentalInsuranceRepo.findAllByEmployeeId(employeeId);
	}

	@Override
	public void updateAccidentalInsurance(Long employeeId, AccidentalInsuranceRequest request) {
		// TODO Auto-generated method stub
		
	}

}

package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Crime;
import com.zpasthapana.pojo.CrimeRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.CrimeRepo;
import com.zpasthapana.service.CrimeService;
import com.zpasthapana.util.ZPUtility;

@Service
public class CrimeServiceImpl implements CrimeService {

	@Autowired
	CrimeRepo crimeRepo; 
	
	@Autowired
	ModelMapper modelMapper; 
	
	@Override
	public void addCrime(CrimeRequest request) {
		Crime entity = modelMapper.map(request, Crime.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		crimeRepo.save(entity);
	}

	@Override
	public List<Crime> getAllCrime() {
		return crimeRepo.findAll();
	}

	@Override
	public List<Crime> getEmployeeCrime(Long employeeId) {
		return crimeRepo.findAllByEmployeeId(employeeId);
	}

	@Override
	public void updateCrime(Long employeeId, CrimeRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponsePageDto<Crime> getAllCrime(Pageable paging) {
		return ZPUtility.getPage(paging, crimeRepo.findAll(paging));
	}

}

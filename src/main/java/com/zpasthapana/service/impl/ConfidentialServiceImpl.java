package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Confidential;
import com.zpasthapana.pojo.ConfidentialRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.ConfidentialRepo;
import com.zpasthapana.service.ConfidentialService;
import com.zpasthapana.util.ZPUtility;

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

	@Override
	public ResponsePageDto<Confidential> getAllConfidential(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, confidentialRepo.findAllByPermission(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

}

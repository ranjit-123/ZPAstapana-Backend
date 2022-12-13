package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.AdditionalService;
import com.zpasthapana.pojo.AdditionalServiceRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.AdditionalServiceRepo;
import com.zpasthapana.service.AdditionalServiceService;
import com.zpasthapana.util.ZPUtility;

@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService {

	@Autowired
	AdditionalServiceRepo additionalServiceRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addAdditionalService(AdditionalServiceRequest request) {
		AdditionalService entity = modelMapper.map(request, AdditionalService.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		additionalServiceRepo.save(entity);
	}

	@Override
	public List<AdditionalService> getAllAdditionalService() {
		return additionalServiceRepo.findAll();
	}

	@Override
	public ResponsePageDto<AdditionalService> getAllAdditionalService(Pageable paging) {
		return ZPUtility.getPage(paging, additionalServiceRepo.findAll(paging));
	}

}

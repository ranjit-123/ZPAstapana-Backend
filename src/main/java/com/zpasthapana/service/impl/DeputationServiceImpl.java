package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Deputation;
import com.zpasthapana.pojo.DeputationRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.DeputationRepo;
import com.zpasthapana.service.DeputationService;
import com.zpasthapana.util.ZPUtility;


@Service
public class DeputationServiceImpl implements DeputationService{
	
	@Autowired
	DeputationRepo deputationRepo; 

	@Autowired
	ModelMapper modelMapper; 
	
	@Override
	public void addDeputation(DeputationRequest request) {
		Deputation deputation = modelMapper.map(request, Deputation.class);
		ZPUtility.uploadFiles(request, deputation, request.getEmployeeId());
		deputationRepo.save(deputation);
	}

	@Override
	public List<Deputation> getAllDeputation() {
		return deputationRepo.findAll();
	}

	@Override
	public List<Deputation> getEmployeeDeputation(Long employeeId) {
		return deputationRepo.findAllByEmployeeId(employeeId);
	}

	@Override
	public void updateDeputation(Long employeeId, DeputationRequest request) {
		
	}

	@Override
	public ResponsePageDto<Deputation> getAllDeputation(Pageable paging) {
		return ZPUtility.getPage(paging, deputationRepo.findAll(paging));
	}

	@Override
	public ResponsePageDto<Deputation> getAllDeputation(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, deputationRepo.findAllByPermission(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(),
				paging));
	}

}

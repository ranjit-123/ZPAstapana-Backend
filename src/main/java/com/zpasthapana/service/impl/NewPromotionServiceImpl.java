package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.NewPromotion;
import com.zpasthapana.pojo.NewPromotionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.NewPromotionRepo;
import com.zpasthapana.service.EmployeeCurrentStatusService;
import com.zpasthapana.service.NewPromotionService;
import com.zpasthapana.util.ZPUtility;

@Service
public class NewPromotionServiceImpl implements NewPromotionService {

	@Autowired
	NewPromotionRepo newPromotionRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EmployeeCurrentStatusService employeeCurrentStatusService;
	
	@Override
	public void addNewPromotion(NewPromotionRequest request) {
		NewPromotion entity = modelMapper.map(request, NewPromotion.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		this.newPromotionRepo.save(entity);
		this.employeeCurrentStatusService.updateCurrentDesignation(entity, request);
		this.employeeCurrentStatusService.updateCurrentWorkLocation(entity, request);
	}

	@Override
	public List<NewPromotion> getAllNewPromotion() {
		return newPromotionRepo.findAll();
	}

	@Override
	public ResponsePageDto<NewPromotion> getAllNewPromotion(Pageable paging) {
		return ZPUtility.getPage(paging, newPromotionRepo.findAll(paging));
	}

}

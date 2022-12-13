package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.RejectedPromotion;
import com.zpasthapana.pojo.RejectedPromotionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.RejectedPromotionRepo;
import com.zpasthapana.service.RejectedPromotionService;
import com.zpasthapana.util.ZPUtility;

@Service
public class RejectedPromotionServiceImpl implements RejectedPromotionService {

	@Autowired
	RejectedPromotionRepo rejectedPromotionRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addRejectedPromotion(RejectedPromotionRequest request) {
		RejectedPromotion entity = modelMapper.map(request, RejectedPromotion.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		rejectedPromotionRepo.save(entity);
	}

	@Override
	public List<RejectedPromotion> getAllRejectedPromotion() {
		return rejectedPromotionRepo.findAll();
	}

	@Override
	public ResponsePageDto<RejectedPromotion> getAllRejectedPromotion(Pageable paging) {
		return ZPUtility.getPage(paging, rejectedPromotionRepo.findAll(paging));
	}

}

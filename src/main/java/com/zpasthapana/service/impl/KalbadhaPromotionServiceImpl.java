package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.KalbadhaPromotion;
import com.zpasthapana.pojo.KalbadhaPromotionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.KalbadhaPromotionRepo;
import com.zpasthapana.service.EmployeeCurrentStatusService;
import com.zpasthapana.service.KalbadhaPromotionService;
import com.zpasthapana.util.ZPUtility;

@Service
public class KalbadhaPromotionServiceImpl implements KalbadhaPromotionService {

	@Autowired
	KalbadhaPromotionRepo kalbadhaPromotionRepo;
	
	@Autowired
	EmployeeCurrentStatusService employeeCurrentStatusService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addKalbadhaPromotion(KalbadhaPromotionRequest request) {
		KalbadhaPromotion entity = modelMapper.map(request, KalbadhaPromotion.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		entity = kalbadhaPromotionRepo.save(entity);
		employeeCurrentStatusService.updateCurrentDesignation(entity, request);
	}

	@Override
	public ResponsePageDto<KalbadhaPromotion> getAllPurchasePermission(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, kalbadhaPromotionRepo.findAllByPermission(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

	@Override
	public List<KalbadhaPromotion> getAllPurchasePermission() {
		return kalbadhaPromotionRepo.findAll();
	}

}

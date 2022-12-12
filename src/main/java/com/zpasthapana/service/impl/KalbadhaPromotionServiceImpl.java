package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.EmployeeDesiganation;
import com.zpasthapana.entity.KalbadhaPromotion;
import com.zpasthapana.pojo.KalbadhaPromotionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.EmployeeDesiganationRepo;
import com.zpasthapana.repo.EmployeeRepo;
import com.zpasthapana.repo.KalbadhaPromotionRepo;
import com.zpasthapana.service.KalbadhaPromotionService;
import com.zpasthapana.util.ZPUtility;

@Service
public class KalbadhaPromotionServiceImpl implements KalbadhaPromotionService {

	@Autowired
	KalbadhaPromotionRepo kalbadhaPromotionRepo;
	
	@Autowired
	EmployeeDesiganationRepo employeeDesiganationRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addKalbadhaPromotion(KalbadhaPromotionRequest request) {
		KalbadhaPromotion entity = modelMapper.map(request, KalbadhaPromotion.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		entity = kalbadhaPromotionRepo.save(entity);

		EmployeeDesiganation empDesignation = employeeDesiganationRepo
				.findAllByEmployeeIdAndIsCurrent(request.getEmployeeId(), Boolean.TRUE);

		EmployeeDesiganation addNewDesignation = modelMapper.map(empDesignation, EmployeeDesiganation.class);

		addNewDesignation.setEmployeeDesiganationId(null);
		addNewDesignation.setEmployeeDesiganationId(Long.valueOf(entity.getAddKalbadhaPromotionDisignation() + ""));
		addNewDesignation.setPayCommission(entity.getAddKalbadhaPromotionPayCommission() + "");
		addNewDesignation.setSalaryRange(entity.getAddKalbadhaPromotionGrade());

		addNewDesignation = employeeDesiganationRepo.save(addNewDesignation);
		empDesignation.setIsCurrent(Boolean.FALSE);
		employeeDesiganationRepo.save(empDesignation);

		Employee em = employeeRepo.findById(request.getEmployeeId()).get();
		em.setEmployeeDesiganationId(addNewDesignation.getEmployeeDesiganationId());
		employeeRepo.save(em);
	}

	@Override
	public ResponsePageDto<KalbadhaPromotion> getAllPurchasePermission(Pageable paging) {
		return ZPUtility.getPage(paging, kalbadhaPromotionRepo.findAll(paging));
	}

	@Override
	public List<KalbadhaPromotion> getAllPurchasePermission() {
		return kalbadhaPromotionRepo.findAll();
	}

}

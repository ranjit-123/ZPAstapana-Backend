package com.zpasthapana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.BaseEntity;
import com.zpasthapana.entity.Employee;
import com.zpasthapana.entity.EmployeeDesiganation;
import com.zpasthapana.entity.EmployeeWorklocation;
import com.zpasthapana.entity.KalbadhaPromotion;
import com.zpasthapana.entity.NewPromotion;
import com.zpasthapana.entity.NewTransfer;
import com.zpasthapana.pojo.BaseRequest;
import com.zpasthapana.repo.EmployeeDesiganationRepo;
import com.zpasthapana.repo.EmployeeRepo;
import com.zpasthapana.repo.EmployeeWorklocationRepo;
import com.zpasthapana.service.EmployeeCurrentStatusService;

@Service
public class EmployeeCurrentStatusServiceImpl implements EmployeeCurrentStatusService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	EmployeeDesiganationRepo employeeDesiganationRepo;
	
	@Autowired
	EmployeeWorklocationRepo employeeWorklocationRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void updateCurrentDesignation(BaseEntity entity, BaseRequest request) {
		if(entity instanceof KalbadhaPromotion) {
			KalbadhaPromotion promotionEntity = (KalbadhaPromotion) entity;
			changeDesignation(promotionEntity.getEmployeeId(), Long.valueOf(promotionEntity.getAddKalbadhaPromotionDisignation() + ""), 
					promotionEntity.getAddKalbadhaPromotionPayCommission() + "", promotionEntity.getAddKalbadhaPromotionGrade());
		} else if(entity instanceof NewPromotion) {
			NewPromotion promotionEntity = (NewPromotion) entity;
			changeDesignation(promotionEntity.getEmployeeId(), Long.valueOf(promotionEntity.getAddNewPromotionDisignation()), 
					promotionEntity.getAddNewPromotionPayCommission() + "", promotionEntity.getAddNewPromotionGrade());
		}
	}

	
	
	@Override
	public void updateCurrentWorkLocation(BaseEntity entity, BaseRequest request) {
		if (entity instanceof NewPromotion) {
			NewPromotion promotionEntity = (NewPromotion) entity;
			changeWorkLocation(promotionEntity.getEmployeeId(), promotionEntity.getTalukaID(),
					promotionEntity.getSubDivisionID(), promotionEntity.getSubDepartmentId());
		} else if(entity instanceof NewTransfer) {
			NewTransfer promotionEntity = (NewTransfer) entity;
			changeWorkLocation(promotionEntity.getEmployeeId(), promotionEntity.getTalukaID(),
					promotionEntity.getSubDivisionID(), promotionEntity.getSubDepartmentId());
		}
	}
	
	
	private void changeDesignation(Long employeeId, Long designationId, String payCommition, String grade) {
		EmployeeDesiganation empDesignation = employeeDesiganationRepo
				.findAllByEmployeeIdAndIsCurrent(employeeId, Boolean.TRUE);
		EmployeeDesiganation addNewDesignation = new EmployeeDesiganation();
		modelMapper.map(empDesignation, addNewDesignation);
		addNewDesignation.setEmployeeDesiganationDetailsId(null);
		addNewDesignation.setEmployeeDesiganationId(designationId);
		addNewDesignation.setPayCommission(payCommition);
		addNewDesignation.setEmployeeselectioncategory(2);
		addNewDesignation.setSalaryRange(grade);
		addNewDesignation = employeeDesiganationRepo.save(addNewDesignation);
		empDesignation.setIsCurrent(Boolean.FALSE);
		employeeDesiganationRepo.save(empDesignation);
		Employee em = employeeRepo.findById(employeeId).get();
		em.setEmployeeDesiganationDetailsId(addNewDesignation.getEmployeeDesiganationDetailsId());
		employeeRepo.save(em);
	}
	
	private void changeWorkLocation(Long employeeId, Long talukaID, Long subDivisionID, Long subDepartmentId) {
		Employee em = employeeRepo.findById(employeeId).get();
		EmployeeWorklocation emWorkLocation = em.getEmployeeWorkLocation();
		EmployeeWorklocation addNewWorkLocation = new EmployeeWorklocation();
		modelMapper.map(emWorkLocation, addNewWorkLocation);
		addNewWorkLocation.setEmployeeWorklocationId(null);
		addNewWorkLocation.setTaluka(talukaID);
		addNewWorkLocation.setSubDivision(subDivisionID);
		addNewWorkLocation.setSubDepartment(subDepartmentId);
		addNewWorkLocation = employeeWorklocationRepo.save(addNewWorkLocation);
		emWorkLocation.setIsCurrent(Boolean.FALSE);
		employeeWorklocationRepo.save(emWorkLocation);
		em.setEmployeeWorklocationId(addNewWorkLocation.getEmployeeWorklocationId());
		employeeRepo.save(em);
	}

}

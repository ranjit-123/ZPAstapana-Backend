package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.PurchasePermission;
import com.zpasthapana.pojo.PurchasePermissionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.PurchasePermissionRepo;
import com.zpasthapana.service.PurchasePermissionsService;
import com.zpasthapana.util.ZPUtility;

@Service
public class PurchasePermissionsServiceImpl implements PurchasePermissionsService{

	@Autowired
	PurchasePermissionRepo purchasePermissionRepo; 
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addPurchasePermissions(PurchasePermissionRequest request) {
		PurchasePermission entity = modelMapper.map(request, PurchasePermission.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		purchasePermissionRepo.save(entity);
	}

	@Override
	public List<PurchasePermission> getAllPurchasePermission() {
		return purchasePermissionRepo.findAll();
	}

	@Override
	public ResponsePageDto<PurchasePermission> getAllPurchasePermission(Pageable paging) {
		return ZPUtility.getPage(paging, purchasePermissionRepo.findAll(paging));
	}

}

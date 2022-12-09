package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.AssetLiability;
import com.zpasthapana.pojo.AssetLiabilityRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.AssetLiabilityRepo;
import com.zpasthapana.service.AssetLiabilityService;
import com.zpasthapana.util.ZPUtility;

@Service
public class AssetLiabilityServiceImpl implements AssetLiabilityService {

	@Autowired
	AssetLiabilityRepo assetLiabilityRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addAssetLiability(AssetLiabilityRequest request) {
		AssetLiability entity = modelMapper.map(request, AssetLiability.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		assetLiabilityRepo.save(entity);
	}

	@Override
	public List<AssetLiability> getAllAssetLiability() {
		return assetLiabilityRepo.findAll();
	}

	@Override
	public ResponsePageDto<AssetLiability> getAllAssetLiability(Pageable paging) {
		return ZPUtility.getPage(paging, assetLiabilityRepo.findAll(paging));
	}

}

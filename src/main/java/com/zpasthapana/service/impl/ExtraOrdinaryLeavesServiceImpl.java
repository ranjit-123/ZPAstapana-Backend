package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.ExtraOrdinaryLeaves;
import com.zpasthapana.pojo.ExtraOrdinaryLeaveRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.ExtraOrdinaryLeavesRepo;
import com.zpasthapana.service.ExtraOrdinaryLeavesService;
import com.zpasthapana.util.ZPUtility;

@Service
public class ExtraOrdinaryLeavesServiceImpl implements ExtraOrdinaryLeavesService {

	@Autowired
	ExtraOrdinaryLeavesRepo extraOrdinaryLeavesRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public void addExtraOrdinaryLeave(ExtraOrdinaryLeaveRequest request) {
		ExtraOrdinaryLeaves entity = modelMapper.map(request, ExtraOrdinaryLeaves.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		extraOrdinaryLeavesRepo.save(entity);
	}

	@Override
	public List<ExtraOrdinaryLeaves> getAllAssetLiability() {
		return extraOrdinaryLeavesRepo.findAll();
	}

	@Override
	public ResponsePageDto<ExtraOrdinaryLeaves> getAllAssetLiability(Pageable paging) {
		return ZPUtility.getPage(paging, extraOrdinaryLeavesRepo.findAll(paging));
	}

}

package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.ExtraOrdinaryLeaves;
import com.zpasthapana.pojo.ExtraOrdinaryLeaveRequest;
import com.zpasthapana.pojo.LeaveDetails;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
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
		for (LeaveDetails leave : request.getLeaves()) {
			ExtraOrdinaryLeaves entitySave = new ExtraOrdinaryLeaves();
			modelMapper.map(entity, entitySave);
			modelMapper.map(leave, entitySave);
			extraOrdinaryLeavesRepo.save(entitySave);
		}
	}

	@Override
	public List<ExtraOrdinaryLeaves> getAllAssetLiability() {
		return extraOrdinaryLeavesRepo.findAll();
	}

	@Override
	public ResponsePageDto<ExtraOrdinaryLeaves> getAllAssetLiability(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, extraOrdinaryLeavesRepo.findAllByPermissions(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

}

package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.CourtCase;
import com.zpasthapana.pojo.CourtCaseRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.CourtCaseRepo;
import com.zpasthapana.service.CourtCaseService;
import com.zpasthapana.util.ZPUtility;

@Service
public class CourtCaseServiceImpl implements CourtCaseService {

	@Autowired
	ModelMapper modelMapper; 
	
	@Autowired
	CourtCaseRepo courtCaseRepo;
	
	@Override
	public void addCourtCase(CourtCaseRequest request) {
		CourtCase entity = modelMapper.map(request, CourtCase.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		courtCaseRepo.save(entity);
	}

	@Override
	public List<CourtCase> getAllAssetLiability() {
		return courtCaseRepo.findAll();
	}

	@Override
	public ResponsePageDto<CourtCase> getAllAssetLiability(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, courtCaseRepo.findAllByPermision(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

}

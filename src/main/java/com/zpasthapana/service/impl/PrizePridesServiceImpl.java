package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.PrizePrides;
import com.zpasthapana.pojo.PrizePridesRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.PrizePridesRepo;
import com.zpasthapana.service.PrizePridesService;
import com.zpasthapana.util.ZPUtility;

@Service
public class PrizePridesServiceImpl implements PrizePridesService{

	@Autowired
	PrizePridesRepo prizePridesRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addPrizePride(PrizePridesRequest request) {
		PrizePrides entity = modelMapper.map(request, PrizePrides.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		prizePridesRepo.save(entity);
	}

	@Override
	public List<PrizePrides> getAllPrizePride() {
		return prizePridesRepo.findAll();
	}

	@Override
	public ResponsePageDto<PrizePrides> getAllPrizePride(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, prizePridesRepo.findAllByPermissions(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

}

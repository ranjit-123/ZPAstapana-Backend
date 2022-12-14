package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.Suspention;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.SuspenssionRequest;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.SuspentionRepo;
import com.zpasthapana.service.SuspensionsService;
import com.zpasthapana.util.ZPUtility;

@Service
public class SuspensionsServiceImpl implements SuspensionsService {

	@Autowired
	SuspentionRepo suspentionRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addSuspenssion(SuspenssionRequest request) {
		Suspention entity = modelMapper.map(request, Suspention.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		suspentionRepo.save(modelMapper.map(request, Suspention.class));
	}

	@Override
	public List<Suspention> getAllSuspenssion() {
		return suspentionRepo.findAll();
	}

	@Override
	public ResponsePageDto<Suspention> getAllSuspenssion(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, suspentionRepo.findAllByPermissions(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

}

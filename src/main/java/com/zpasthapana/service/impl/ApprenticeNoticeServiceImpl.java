package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.ApprenticeNotice;
import com.zpasthapana.pojo.ApprenticeNoticeRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.ApprenticeNoticeRepo;
import com.zpasthapana.service.ApprenticeNoticeService;
import com.zpasthapana.util.ZPUtility;

@Service
public class ApprenticeNoticeServiceImpl implements ApprenticeNoticeService {

	@Autowired
	ApprenticeNoticeRepo apprenticeNoticeRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addApprenticeNotice(ApprenticeNoticeRequest request) {
		ApprenticeNotice entity = modelMapper.map(request, ApprenticeNotice.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		apprenticeNoticeRepo.save(entity);
	}

	@Override
	public List<ApprenticeNotice> getAllAssetLiability() {
		return apprenticeNoticeRepo.findAll();
	}

	@Override
	public ResponsePageDto<ApprenticeNotice> getAllAssetLiability(Pageable paging) {
		return ZPUtility.getPage(paging, apprenticeNoticeRepo.findAll(paging));
	}

}

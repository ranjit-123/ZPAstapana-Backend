package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.CriminalOffence;
import com.zpasthapana.pojo.CriminalOffenceRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.CriminalOffenceRepo;
import com.zpasthapana.service.CriminalOffenceService;
import com.zpasthapana.util.ZPUtility;

@Service
public class CriminalOffenceServiceImpl implements CriminalOffenceService {

	@Autowired
	CriminalOffenceRepo criminalOffenceRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addCriminalOffence(CriminalOffenceRequest request) {
		CriminalOffence entity = modelMapper.map(request, CriminalOffence.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		criminalOffenceRepo.save(entity);
	}

	@Override
	public List<CriminalOffence> getAllCriminalOffence() {
		return criminalOffenceRepo.findAll();
	}

	@Override
	public ResponsePageDto<CriminalOffence> getAllCriminalOffence(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, criminalOffenceRepo.findAllByPermissions(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

}

package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.UnathorizedAbsencePeriod;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UnathorizedAbsencePeriodRequest;
import com.zpasthapana.repo.UnathorizedAbsencePeriodRepo;
import com.zpasthapana.service.UnathorizedAbsencePeriodService;
import com.zpasthapana.util.ZPUtility;
@Service
public class UnathorizedAbsencePeriodServiceImpl implements UnathorizedAbsencePeriodService{

	@Autowired
	UnathorizedAbsencePeriodRepo unathorizedAbsencePeriodRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addUnathorizedAbsencePeriod(UnathorizedAbsencePeriodRequest request) {
		unathorizedAbsencePeriodRepo.save(this.modelMapper.map(request, UnathorizedAbsencePeriod.class));
	}

	@Override
	public List<UnathorizedAbsencePeriod> getUnathorizedAbsencePeriod() {
		return unathorizedAbsencePeriodRepo.findAll();
	}

	@Override
	public ResponsePageDto<UnathorizedAbsencePeriod> getUnathorizedAbsencePeriod(Pageable paging) {
		return ZPUtility.getPage(paging, unathorizedAbsencePeriodRepo.findAll(paging));
	}

}

package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.ServiceSegment;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.ServiceSegmentRequest;
import com.zpasthapana.repo.ServiceSegmentRepo;
import com.zpasthapana.service.ServiceSegmentService;
import com.zpasthapana.util.ZPUtility;

@Service
public class ServiceSegmentServiceImpl implements ServiceSegmentService {

	@Autowired
	ServiceSegmentRepo serviceSegmentRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addServiceSegment(ServiceSegmentRequest request) {
		ServiceSegment entity = modelMapper.map(request, ServiceSegment.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		serviceSegmentRepo.save(entity);
	}

	@Override
	public List<ServiceSegment> getAllServiceSegment() {
		return serviceSegmentRepo.findAll();
	}

	@Override
	public ResponsePageDto<ServiceSegment> getAllServiceSegment(Pageable paging) {
		return ZPUtility.getPage(paging, serviceSegmentRepo.findAll(paging));
	}

}

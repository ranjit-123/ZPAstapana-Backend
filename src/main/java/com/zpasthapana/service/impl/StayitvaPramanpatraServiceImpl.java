package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.StayitvaPramanpatra;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.StayitvaPramanpatraRequest;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.repo.StayitvaPramanpatraRepo;
import com.zpasthapana.service.StayitvaPramanpatraService;
import com.zpasthapana.util.ZPUtility;

@Service
public class StayitvaPramanpatraServiceImpl implements StayitvaPramanpatraService {
	
	@Autowired
	StayitvaPramanpatraRepo stayitvaPramanpatraRepo; 
	
	@Autowired
	ModelMapper modelMapper; 

	
	@Override
	public void addStayitvaPramanpatra(StayitvaPramanpatraRequest request) {
		StayitvaPramanpatra entity = modelMapper.map(request, StayitvaPramanpatra.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		stayitvaPramanpatraRepo.save(entity);
	}

	@Override
	public List<StayitvaPramanpatra> getAllStayitvaPramanpatra() {
		return stayitvaPramanpatraRepo.findAll();
	}

	@Override
	public List<StayitvaPramanpatra> getEmployeeStayitvaPramanpatra(Long employeeId) {
		return stayitvaPramanpatraRepo.findAllByEmployeeId(employeeId);
	}

	@Override
	public void updateStayitvaPramanpatra(Long employeeId, StayitvaPramanpatraRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponsePageDto<StayitvaPramanpatra> getAllStayitvaPramanpatra(UIPageRequest pageRequest, Pageable paging) {
		return ZPUtility.getPage(paging, stayitvaPramanpatraRepo.findAllByPermissions(pageRequest.getDevisionId(), pageRequest.getZpId(),
				pageRequest.getDepartmentId(), pageRequest.getTalukaId(), paging));
	}

}

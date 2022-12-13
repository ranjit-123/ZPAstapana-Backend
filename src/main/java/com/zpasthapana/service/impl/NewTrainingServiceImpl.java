package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.NewTraining;
import com.zpasthapana.pojo.NewTrainingRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.NewTrainingRepo;
import com.zpasthapana.service.NewTrainingService;
import com.zpasthapana.util.ZPUtility;

@Service
public class NewTrainingServiceImpl implements NewTrainingService {

	@Autowired
	NewTrainingRepo newTrainingRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addNewTraining(NewTrainingRequest request) {
		NewTraining entity = modelMapper.map(request, NewTraining.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		newTrainingRepo.save(entity);
	}

	@Override
	public List<NewTraining> getAllNewTraining() {
		return newTrainingRepo.findAll();
	}

	@Override
	public ResponsePageDto<NewTraining> getAllNewTraining(Pageable paging) {
		return ZPUtility.getPage(paging, newTrainingRepo.findAll(paging));
	}

}

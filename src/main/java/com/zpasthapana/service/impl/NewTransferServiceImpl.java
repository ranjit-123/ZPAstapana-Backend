package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.NewTransfer;
import com.zpasthapana.pojo.NewTransferRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.NewTransferRepo;
import com.zpasthapana.service.NewTransferService;
import com.zpasthapana.util.ZPUtility;

@Service
public class NewTransferServiceImpl implements NewTransferService {

	@Autowired
	NewTransferRepo newTransferRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addNewTransfer(NewTransferRequest request) {
		NewTransfer entity = modelMapper.map(request, NewTransfer.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		newTransferRepo.save(entity);
	}

	@Override
	public List<NewTransfer> getAllNewTransfer() {
		return newTransferRepo.findAll();
	}

	@Override
	public ResponsePageDto<NewTransfer> getAllNewTransfer(Pageable paging) {
		return ZPUtility.getPage(paging, newTransferRepo.findAll(paging));
	}
	
}

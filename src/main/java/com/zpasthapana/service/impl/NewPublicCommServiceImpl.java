package com.zpasthapana.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zpasthapana.entity.NewPublicCommissioner;
import com.zpasthapana.pojo.NewPublicCommRequest;
import com.zpasthapana.repo.NewPublicCommRepo;
import com.zpasthapana.service.NewPublicCommService;

@Service
public class NewPublicCommServiceImpl implements NewPublicCommService {

	@Autowired
	NewPublicCommRepo newPublicCommRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public void addNewPublicCommissioner(NewPublicCommRequest request) {
		// TODO Auto-generated method stub
		NewPublicCommissioner entity = modelMapper.map(request, NewPublicCommissioner.class);
		this.newPublicCommRepo.save(entity);
	}

}

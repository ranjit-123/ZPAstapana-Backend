package com.zpasthapana.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zpasthapana.entity.AccountInquiry;
import com.zpasthapana.pojo.AccountInquiryRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.repo.AccountInquiryRepo;
import com.zpasthapana.service.AccountInquiryService;
import com.zpasthapana.util.ZPUtility;

@Service
public class AccountInquiryServiceImpl implements AccountInquiryService{

	@Autowired
	AccountInquiryRepo accountInquiryRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void addAccountInquiry(AccountInquiryRequest request) {
		AccountInquiry entity = modelMapper.map(request, AccountInquiry.class);
		ZPUtility.uploadFiles(request, entity, request.getEmployeeId());
		accountInquiryRepo.save(entity);
	}

	@Override
	public List<AccountInquiry> getAllAssetLiability() {
		return accountInquiryRepo.findAll();
	}

	@Override
	public ResponsePageDto<AccountInquiry> getAllAssetLiability(Pageable paging) {
		return ZPUtility.getPage(paging, accountInquiryRepo.findAll(paging));
	}

}

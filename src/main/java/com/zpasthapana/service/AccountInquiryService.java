package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.AccountInquiry;
import com.zpasthapana.pojo.AccountInquiryRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface AccountInquiryService {

	void addAccountInquiry(AccountInquiryRequest request);

	List<AccountInquiry> getAllAssetLiability();

	ResponsePageDto<AccountInquiry> getAllAssetLiability(UIPageRequest pageRequest, Pageable paging);


}

package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.ApprenticeNotice;
import com.zpasthapana.pojo.ApprenticeNoticeRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface ApprenticeNoticeService {

	void addApprenticeNotice(ApprenticeNoticeRequest request);

	List<ApprenticeNotice> getAllAssetLiability();

	ResponsePageDto<ApprenticeNotice> getAllAssetLiability(Pageable paging);

}

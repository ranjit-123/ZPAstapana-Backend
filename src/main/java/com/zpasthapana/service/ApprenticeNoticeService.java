package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.ApprenticeNotice;
import com.zpasthapana.pojo.ApprenticeNoticeRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface ApprenticeNoticeService {

	void addApprenticeNotice(ApprenticeNoticeRequest request);

	List<ApprenticeNotice> getAllAssetLiability();

	ResponsePageDto<ApprenticeNotice> getAllAssetLiability(UIPageRequest pageRequest, Pageable paging);

}

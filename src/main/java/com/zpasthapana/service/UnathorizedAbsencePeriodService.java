package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.UnathorizedAbsencePeriod;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;
import com.zpasthapana.pojo.UnathorizedAbsencePeriodRequest;

public interface UnathorizedAbsencePeriodService {

	void addUnathorizedAbsencePeriod(UnathorizedAbsencePeriodRequest request);

	List<UnathorizedAbsencePeriod> getUnathorizedAbsencePeriod();

	ResponsePageDto<UnathorizedAbsencePeriod> getUnathorizedAbsencePeriod(UIPageRequest pageRequest, Pageable paging);

}

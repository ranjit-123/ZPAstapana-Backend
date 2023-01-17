package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zpasthapana.entity.ExtraOrdinaryLeaves;
import com.zpasthapana.pojo.ExtraOrdinaryLeaveRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface ExtraOrdinaryLeavesService {

	void addExtraOrdinaryLeave(ExtraOrdinaryLeaveRequest request) throws JsonMappingException, JsonProcessingException;

	List<ExtraOrdinaryLeaves> getAllAssetLiability();

	ResponsePageDto<ExtraOrdinaryLeaves> getAllAssetLiability(UIPageRequest pageRequest, Pageable paging);


}

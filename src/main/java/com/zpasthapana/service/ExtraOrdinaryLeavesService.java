package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.ExtraOrdinaryLeaves;
import com.zpasthapana.pojo.ExtraOrdinaryLeaveRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface ExtraOrdinaryLeavesService {

	void addExtraOrdinaryLeave(ExtraOrdinaryLeaveRequest request);

	List<ExtraOrdinaryLeaves> getAllAssetLiability();

	ResponsePageDto<ExtraOrdinaryLeaves> getAllAssetLiability(Pageable paging);


}

package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.CourtCase;
import com.zpasthapana.pojo.CourtCaseRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface CourtCaseService {

	void addCourtCase(CourtCaseRequest request);

	List<CourtCase> getAllAssetLiability();

	ResponsePageDto<CourtCase> getAllAssetLiability(Pageable paging);

}

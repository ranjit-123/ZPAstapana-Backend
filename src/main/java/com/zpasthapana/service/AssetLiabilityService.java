package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.AssetLiability;
import com.zpasthapana.pojo.AssetLiabilityRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface AssetLiabilityService {

	void addAssetLiability(AssetLiabilityRequest request);

	List<AssetLiability> getAllAssetLiability();

	ResponsePageDto<AssetLiability> getAllAssetLiability(Pageable paging);

}

package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.AdditionalService;
import com.zpasthapana.pojo.AdditionalServiceRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface AdditionalServiceService {

	void addAdditionalService(AdditionalServiceRequest request);

	List<AdditionalService> getAllAdditionalService();

	ResponsePageDto<AdditionalService> getAllAdditionalService(Pageable paging);

}

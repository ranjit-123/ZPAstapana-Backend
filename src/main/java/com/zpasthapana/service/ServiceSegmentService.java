package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.ServiceSegment;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.ServiceSegmentRequest;

public interface ServiceSegmentService {

	void addServiceSegment(ServiceSegmentRequest request);

	List<ServiceSegment> getAllServiceSegment();

	ResponsePageDto<ServiceSegment> getAllServiceSegment(Pageable paging);

}

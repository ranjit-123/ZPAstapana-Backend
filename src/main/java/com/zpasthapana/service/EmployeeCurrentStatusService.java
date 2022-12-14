package com.zpasthapana.service;

import com.zpasthapana.entity.BaseEntity;
import com.zpasthapana.pojo.BaseRequest;

public interface EmployeeCurrentStatusService {
	
	void updateCurrentDesignation(BaseEntity entity, BaseRequest request);

	void updateCurrentWorkLocation(BaseEntity entity, BaseRequest request);

}

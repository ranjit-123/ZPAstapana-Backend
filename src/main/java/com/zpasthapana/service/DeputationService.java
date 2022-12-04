package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.entity.Deputation;
import com.zpasthapana.pojo.DeputationRequest;

public interface DeputationService {
	public void addDeputation(DeputationRequest request);
	public List<Deputation> getAllDeputation();
	public List<Deputation> getEmployeeDeputation(Long employeeId);
	public void updateDeputation(Long employeeId, DeputationRequest request);
}

package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.entity.Confidential;
import com.zpasthapana.pojo.ConfidentialRequest;

public interface ConfidentialService {
	public void addConfidential(ConfidentialRequest request);
	public List<Confidential> getAllConfidential();
	public List<Confidential> getEmployeeConfidential(Long employeeId);
	public void updateConfidential(Long employeeId, ConfidentialRequest request);
}

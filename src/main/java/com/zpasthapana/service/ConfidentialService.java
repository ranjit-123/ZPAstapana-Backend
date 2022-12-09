package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.Confidential;
import com.zpasthapana.pojo.ConfidentialRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface ConfidentialService {
	public void addConfidential(ConfidentialRequest request);
	public List<Confidential> getAllConfidential();
	public List<Confidential> getEmployeeConfidential(Long employeeId);
	public void updateConfidential(Long employeeId, ConfidentialRequest request);
	public ResponsePageDto<Confidential> getAllConfidential(Pageable paging);
}

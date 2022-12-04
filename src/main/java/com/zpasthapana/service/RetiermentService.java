package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.entity.Retierment;
import com.zpasthapana.pojo.RetiermentRequest;

public interface RetiermentService {
	public void addRetirement(RetiermentRequest request);
	public List<Retierment> getAllRetirement();
	public List<Retierment> getEmployeeRetirement(Long employeeId);
	public void updateRetierment(Long employeeId, RetiermentRequest request);
}

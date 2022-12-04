package com.zpasthapana.service;

import java.util.List;

import com.zpasthapana.entity.Crime;
import com.zpasthapana.pojo.CrimeRequest;

public interface CrimeService {
	public void addCrime(CrimeRequest request);
	public List<Crime> getAllCrime();
	public List<Crime> getEmployeeCrime(Long employeeId);
	public void updateCrime(Long employeeId, CrimeRequest request);
}

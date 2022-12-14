package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.Crime;
import com.zpasthapana.pojo.CrimeRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface CrimeService {
	public void addCrime(CrimeRequest request);
	public List<Crime> getAllCrime();
	public List<Crime> getEmployeeCrime(Long employeeId);
	public void updateCrime(Long employeeId, CrimeRequest request);
	public ResponsePageDto<Crime> getAllCrime(UIPageRequest pageRequest, Pageable paging);
}

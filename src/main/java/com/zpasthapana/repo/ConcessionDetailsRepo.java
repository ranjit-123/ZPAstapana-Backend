package com.zpasthapana.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.ConcessionDetails;

public interface ConcessionDetailsRepo extends JpaRepository<ConcessionDetails, Long>{
	ConcessionDetails findByEmployeeId(Long employeeId);
}

package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.Confidential;

public interface ConfidentialRepo extends JpaRepository<Confidential, Long>{

	List<Confidential> findAllByEmployeeId(Long employeeId);

}

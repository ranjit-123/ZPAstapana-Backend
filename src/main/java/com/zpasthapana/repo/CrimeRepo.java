package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.Crime;

public interface CrimeRepo extends JpaRepository<Crime, Long>{

	List<Crime> findAllByEmployeeId(Long employeeId);

}

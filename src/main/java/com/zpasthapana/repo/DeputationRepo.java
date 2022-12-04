package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.Deputation;

public interface DeputationRepo extends JpaRepository<Deputation, Long>{

	List<Deputation> findAllByEmployeeId(Long employeeId);

}

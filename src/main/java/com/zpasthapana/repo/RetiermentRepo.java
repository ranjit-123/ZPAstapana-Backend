package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.Retierment;

public interface RetiermentRepo extends JpaRepository<Retierment, Long>{

	List<Retierment> findAllByEmployeeId(Long employeeId);

}

package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.AccidentalInsurance;

public interface AccidentalInsuranceRepo extends JpaRepository<AccidentalInsurance, Long>{

	List<AccidentalInsurance> findAllByEmployeeId(Long employeeId);

}

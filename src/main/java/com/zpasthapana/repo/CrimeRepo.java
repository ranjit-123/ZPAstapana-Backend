package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zpasthapana.entity.Crime;

public interface CrimeRepo extends JpaRepository<Crime, Long>{

	List<Crime> findAllByEmployeeId(Long employeeId);

	@Query(value = "select c from Crime c inner join c.employee e inner join e.employeeWorkLocation w "
			+ "where (:zpId is null or w.zpId = :zpId) and (:devisionId is null or w.divisionId = :devisionId) and (:departmentId is null or w.departmentId = :departmentId) "
			+ "and (:talukaId is null or w.taluka = :talukaId)")
	Page<Crime> findAllByPermissions(Long devisionId, Long zpId, Long departmentId, Long talukaId, Pageable paging);

}

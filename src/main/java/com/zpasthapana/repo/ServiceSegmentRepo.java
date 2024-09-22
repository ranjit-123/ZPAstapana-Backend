package com.zpasthapana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zpasthapana.entity.ServiceSegment;

public interface ServiceSegmentRepo extends JpaRepository<ServiceSegment, Long> {

	@Query(value = "select s from ServiceSegment s inner join s.employee e inner join e.employeeWorkLocation w "
			+ "where (:zpId is null or w.zpId = :zpId) and (:devisionId is null or w.divisionId = :devisionId) and (:departmentId is null or w.departmentId = :departmentId) "
			+ "and (:talukaId is null or w.taluka = :talukaId)")
	Page<ServiceSegment> findAllByPermissions(Long devisionId, Long zpId, Long departmentId, Long talukaId,
			Pageable paging);

	ServiceSegment findByEmployeeId(Long employeeId);

}

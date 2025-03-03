package com.zpasthapana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zpasthapana.entity.KalbadhaPromotion;

import antlr.collections.List;

public interface KalbadhaPromotionRepo extends JpaRepository<KalbadhaPromotion, Long> {

	@Query(value = "select d from KalbadhaPromotion d inner join d.employee e inner join e.employeeWorkLocation w "
			+ "where (:zpId is null or w.zpId = :zpId) and (:devisionId is null or w.divisionId = :devisionId) and (:departmentId is null or w.departmentId = :departmentId) "
			+ "and (:talukaId is null or w.taluka = :talukaId)")
	Page<KalbadhaPromotion> findAllByPermission(Long devisionId, Long zpId, Long departmentId, Long talukaId, Pageable paging);
	
	java.util.List<KalbadhaPromotion> findByEmployeeId(Long employeeId);

}

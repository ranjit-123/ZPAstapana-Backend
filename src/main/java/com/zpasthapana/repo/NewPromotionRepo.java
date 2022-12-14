package com.zpasthapana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zpasthapana.entity.NewPromotion;

public interface NewPromotionRepo extends JpaRepository<NewPromotion, Long>{

	@Query(value = "select p from NewPromotion p inner join p.employee e inner join e.employeeWorkLocation w "
			+ "where (:zpId is null or w.zpId = :zpId) and (:devisionId is null or w.divisionId = :devisionId) and (:departmentId is null or w.departmentId = :departmentId) "
			+ "and (:talukaId is null or w.taluka = :talukaId)")
	Page<NewPromotion> findAllByPermissions(Long devisionId, Long zpId, Long departmentId, Long talukaId, Pageable paging);

}

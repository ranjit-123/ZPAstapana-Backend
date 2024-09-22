package com.zpasthapana.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zpasthapana.entity.AccountInquiry;

public interface AccountInquiryRepo extends JpaRepository<AccountInquiry, Long> {

	@Query(value = "select a from AccountInquiry a inner join a.employee e inner join e.employeeWorkLocation w "
			+ "where (:zpId is null or w.zpId = :zpId) and (:devisionId is null or w.divisionId = :devisionId) and (:departmentId is null or w.departmentId = :departmentId) "
			+ "and (:talukaId is null or w.taluka = :talukaId)")
	Page<AccountInquiry> findAllByPermission(Long devisionId, Long zpId, Long departmentId, Long talukaId, Pageable paging);
	
	List<AccountInquiry> findAllByEmployeeId(Long employeeId);

}

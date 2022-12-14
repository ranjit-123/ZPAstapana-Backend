package com.zpasthapana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zpasthapana.entity.NewTransfer;

public interface NewTransferRepo extends JpaRepository<NewTransfer, Long> {

	Page<NewTransfer> findAllByInterDistrictTransferFlag(Integer interDistrictTransferFlag, Pageable paging);

	@Query(value = "select t from NewTransfer t inner join t.employee e inner join e.employeeWorkLocation w "
			+ "where t.interDistrictTransferFlag = :interDistrictTransferFlag and (:zpId is null or w.zpId = :zpId) and (:devisionId is null or w.divisionId = :devisionId) and (:departmentId is null or w.departmentId = :departmentId) "
			+ "and (:talukaId is null or w.taluka = :talukaId)")
	Page<NewTransfer> findAllByInterDistrictTransferFlag(Long devisionId, Long zpId, Long departmentId, Long talukaId, Integer interDistrictTransferFlag,
			Pageable paging);

}

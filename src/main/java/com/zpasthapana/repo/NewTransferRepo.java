package com.zpasthapana.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zpasthapana.entity.NewTransfer;

public interface NewTransferRepo extends JpaRepository<NewTransfer, Long> {

	Page<NewTransfer> findAllByInterDistrictTransferFlag(Integer interDistrictTransferFlag, Pageable paging);

}

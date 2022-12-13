package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.NewTransfer;
import com.zpasthapana.pojo.NewTransferRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface NewTransferService {

	void addNewTransfer(NewTransferRequest request);

	List<NewTransfer> getAllNewTransfer();

	ResponsePageDto<NewTransfer> getAllNewTransfer(Pageable paging);

	ResponsePageDto<NewTransfer> getAllDistrictNewTransfer(Pageable paging);

}

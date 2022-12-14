package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.NewTransfer;
import com.zpasthapana.pojo.NewTransferRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface NewTransferService {

	void addNewTransfer(NewTransferRequest request);

	List<NewTransfer> getAllNewTransfer();

	ResponsePageDto<NewTransfer> getAllNewTransfer(UIPageRequest pageRequest, Pageable paging);

	ResponsePageDto<NewTransfer> getAllDistrictNewTransfer(UIPageRequest pageRequest, Pageable paging);

}

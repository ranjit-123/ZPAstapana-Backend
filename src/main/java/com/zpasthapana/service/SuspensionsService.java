package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.Suspention;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.SuspenssionRequest;
import com.zpasthapana.pojo.UIPageRequest;

public interface SuspensionsService {

	void addSuspenssion(SuspenssionRequest request);

	List<Suspention> getAllSuspenssion();

	ResponsePageDto<Suspention> getAllSuspenssion(UIPageRequest pageRequest, Pageable paging);

}

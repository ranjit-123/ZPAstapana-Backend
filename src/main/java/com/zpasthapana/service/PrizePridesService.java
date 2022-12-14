package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.PrizePrides;
import com.zpasthapana.pojo.PrizePridesRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface PrizePridesService {

	void addPrizePride(PrizePridesRequest request);

	List<PrizePrides> getAllPrizePride();

	ResponsePageDto<PrizePrides> getAllPrizePride(UIPageRequest pageRequest, Pageable paging);

}

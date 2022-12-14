package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.CriminalOffence;
import com.zpasthapana.pojo.CriminalOffenceRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface CriminalOffenceService {

	void addCriminalOffence(CriminalOffenceRequest request);

	List<CriminalOffence> getAllCriminalOffence();

	ResponsePageDto<CriminalOffence> getAllCriminalOffence(UIPageRequest pageRequest, Pageable paging);

}

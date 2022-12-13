package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.CriminalOffence;
import com.zpasthapana.pojo.CriminalOffenceRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface CriminalOffenceService {

	void addCriminalOffence(CriminalOffenceRequest request);

	List<CriminalOffence> getAllCriminalOffence();

	ResponsePageDto<CriminalOffence> getAllCriminalOffence(Pageable paging);

}

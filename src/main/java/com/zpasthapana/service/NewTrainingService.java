package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.NewTraining;
import com.zpasthapana.pojo.NewTrainingRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface NewTrainingService {

	void addNewTraining(NewTrainingRequest request);

	List<NewTraining> getAllNewTraining();

	ResponsePageDto<NewTraining> getAllNewTraining(UIPageRequest pageRequest, Pageable paging);

}

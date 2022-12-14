package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.NewPromotion;
import com.zpasthapana.pojo.NewPromotionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface NewPromotionService {

	void addNewPromotion(NewPromotionRequest request);

	List<NewPromotion> getAllNewPromotion();

	ResponsePageDto<NewPromotion> getAllNewPromotion(UIPageRequest pageRequest, Pageable paging);

}

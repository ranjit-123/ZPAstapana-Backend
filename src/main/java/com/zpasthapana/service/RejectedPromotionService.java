package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.RejectedPromotion;
import com.zpasthapana.pojo.RejectedPromotionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface RejectedPromotionService {

	void addRejectedPromotion(RejectedPromotionRequest request);

	List<RejectedPromotion> getAllRejectedPromotion();

	ResponsePageDto<RejectedPromotion> getAllRejectedPromotion(UIPageRequest pageRequest, Pageable paging);

}

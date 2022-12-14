package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.KalbadhaPromotion;
import com.zpasthapana.pojo.KalbadhaPromotionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface KalbadhaPromotionService {

	void addKalbadhaPromotion(KalbadhaPromotionRequest request);

	ResponsePageDto<KalbadhaPromotion> getAllPurchasePermission(UIPageRequest pageRequest, Pageable paging);

	List<KalbadhaPromotion> getAllPurchasePermission();

}

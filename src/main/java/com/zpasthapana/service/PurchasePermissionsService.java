package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.PurchasePermission;
import com.zpasthapana.pojo.PurchasePermissionRequest;
import com.zpasthapana.pojo.ResponsePageDto;
import com.zpasthapana.pojo.UIPageRequest;

public interface PurchasePermissionsService {

	void addPurchasePermissions(PurchasePermissionRequest request);

	List<PurchasePermission> getAllPurchasePermission();

	ResponsePageDto<PurchasePermission> getAllPurchasePermission(UIPageRequest pageRequest, Pageable paging);

}

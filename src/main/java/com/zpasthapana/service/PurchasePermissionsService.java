package com.zpasthapana.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zpasthapana.entity.PurchasePermission;
import com.zpasthapana.pojo.PurchasePermissionRequest;
import com.zpasthapana.pojo.ResponsePageDto;

public interface PurchasePermissionsService {

	void addPurchasePermissions(PurchasePermissionRequest request);

	List<PurchasePermission> getAllPurchasePermission();

	ResponsePageDto<PurchasePermission> getAllPurchasePermission(Pageable paging);

}

package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchasePermissionRequest extends BaseRequest{
	private Long id;
	private Integer purchaseOrderNumber;
	private String orderDate; 
	private MultipartFile purchaseOrderPdf;
	private String purchaseDetails;
	private Long employeeId;
}

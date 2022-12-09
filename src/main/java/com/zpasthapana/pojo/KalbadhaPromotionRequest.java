package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KalbadhaPromotionRequest extends BaseRequest{
	private Long id;
	private Integer addKalbadhaPromotionRegularPromotionsFlag;
	private Integer addKalbadhaPromotioneEployeeSelectionCategoryIDFlag;
	private String addKalbadhaPromotionGrade;
	private String kalbadhaPromotionApplyDate;
	private Integer addKalbadhaPromotionDisignation;
	private Integer addKalbadhaPromotionPayCommission;
	private String addKalbadhaPromotionOrderNumber;
	private String addKalbadhaPromotionOrderDate;
	private MultipartFile addKalbadhaPromotionPDF;
	private Long employeeId;
}

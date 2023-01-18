package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RejectedPromotionRequest extends BaseRequest{
	private Long employeeId;
	private Long rejectedPromotionPayCommission;
	private Long rejectedPromotionDisignation;
	private String rejectedPromotionGrade;
	private String rejectedPromotionOrderNumber;
	private MultipartFile rejectedPromotionPDF;
	private String rejectedPromotionOrderDate;
	private Long rejectedPromotionCastecategory;
	private Integer rejectedGotPromotionFlag;
	private String rejectedGotPromotionOrderNumber;
	private String rejectedGotPromotionOrderDate;
	private MultipartFile rejectedGotPromotionPDF;
	private String rejectedGotPromotionDetails;
	private String rejectedGotPromotionTermsAndConditions;
}

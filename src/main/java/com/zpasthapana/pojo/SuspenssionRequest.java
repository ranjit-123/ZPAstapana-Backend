package com.zpasthapana.pojo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SuspenssionRequest extends BaseRequest {
	private Long id;
	private Long employeeId;
	private Integer suspensionOrderNo;
	private String suspensionOrderDate;
	private String suspensionDate;
	private String suspensionReason;
	private Integer suspensionTaluka;
	private Integer suspensionSubdivision;
	private String suspensionOfficeName;
	private Integer subsistenceIncreased;
	private String subsistenceOrderNo;
	private String subsistenceOrderDate;
	private Double subsistenceAmt;
	private Integer isAcbReviewed;
	private String acbReviewedDate;
	private Integer officeChangedInSuspension;
	private Integer changedTaluka;
	private Integer changedSubdivision;
	private Integer changedOfficeName;
	private Integer isReinstated;
	private Integer reinstatedOrderNo;
	private String reinstatedOrderDate;
	private String reinstatedOrderReason;
	private String presentDateInReinstated;
	private Integer reinstatedTaluka;
	private Integer reinstatedSubdivision;
	private Integer reinstatedOfficeName;
	private MultipartFile suspensionPdf;
}

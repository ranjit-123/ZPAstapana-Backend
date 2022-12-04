package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CrimeRequest extends BaseRequest {
	private Integer isArrested;
	private Integer isSuspended;
	private Integer suspendCase;
	private String reasonNotSuspended;
	private Integer indictmentNumber;
	private String indictmentDate;
	private String actualIndictmentNumber;
	private String actualIndictmentDate;
	private String conditionOfCase;
	private Integer courtResult;
	private String courtResultReason;
	private String whatIsActionTaken;
	private Integer punishmentOrderNo;
	private String punishmentOrderPdf;
	private String punishmentOrderDate;
	private String resultPdf;
	private Integer appealedInHigherCourt;
	private String caseDetails;
	private Integer appealNumber;
	private String appealDate;
	private Long employeeId;
}

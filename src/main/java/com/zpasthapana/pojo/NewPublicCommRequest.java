package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewPublicCommRequest extends BaseRequest{
	
	private Long stateId;
	private Long divisionId;
	private Long zpId;
	private Long departmentId;
	private Long designationId;
	private String complainantName;
	private String referenceNo;
	private String referenceDate;
	private String receivedDate;
	private String complaint;
	private Integer isMidReportSubmitted;
	private String midReportSubmittedDate;
	private String midReportDescription;
	private Integer isFinalReportSubmitted;
	private String finalReportDate;
	private String finalReportDescription;
	private Integer isFinalised;
	private String finalisedDate;

}

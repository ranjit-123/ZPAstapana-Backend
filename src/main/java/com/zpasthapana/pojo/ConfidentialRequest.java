package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConfidentialRequest extends BaseRequest{
	private String financialYear;
	private String fromDate;
	private String toDate;
	private Integer reportingOfficerMarks;
	private Integer reviewOfficerMarks;
	private String reportSubmitDate;
	private String reportCopy;
	private String isAppealed;
	private String appealDecision;
	private Integer appealMarks;
	private Long employeeId;
}

package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportVibhagiyaChowkashiResponse {
	private String departmentName;
	private Integer pendingCases;
	private Integer casesTillReportMonthEnd;
	private Integer totalCases;
	private Integer receivedInquiryReports;
	private Integer finalActionCompletedCases;
	private Integer pendingFinalActionCases;
	private Integer retiredEmployeeCases;
	private Integer judicialCases;
	private Integer pendingActionOverSixMonths;
	private Integer retiredEmployeePendingActionCases;
}

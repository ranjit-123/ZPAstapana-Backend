package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnauthorizedAbsenceReport {
	private Integer departmentId;
	private Integer tillLastYearPendingCases;
	private Integer currentFinancialYearPendingCases;
	private Integer totalCases;
	private Integer disciplinaryEndCases;
	private Integer disciplinaryStartedCases;
	private Integer disciplinaryNotStartedCases;
	private Integer sixMonthsPendingCases;
}

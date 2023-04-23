package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportSevaNivrutResponse {
	public String departmentName;
    public String pendigOn142021;
    public String retirementAfter142021;
    public String totalRetirementCase;
    public String totalRetirementFinalisedCases;
    public String finalCasesInReportMonth;
    public String totalPendingCases;
    public String pendingDueToDepartmentalEnquiry;
    public String judicialCases;
    public String departmentalPlusJudicialCases;
    public String exceptAccountEnquiryAndJudicial;
    public String pendingMoreThanSixMonth;
}

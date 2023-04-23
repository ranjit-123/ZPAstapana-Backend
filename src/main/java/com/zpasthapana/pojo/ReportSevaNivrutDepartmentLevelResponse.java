package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportSevaNivrutDepartmentLevelResponse {
	public String departmentName;
    public String employeeName;
    public String designation;
    public String officeName;
    public String taluka;
    public String retirementDate;
    public String retirementReason;
    public String currentSituationOfCase;
    public String pendingLevel;
    public String isCaseOldThan6Months;
    public String declarationDate;
}

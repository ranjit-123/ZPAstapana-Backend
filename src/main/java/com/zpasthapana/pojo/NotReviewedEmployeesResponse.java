package com.zpasthapana.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotReviewedEmployeesResponse {
	public String employeeNameAndOffice;
	public String seniorityNumber;
	public Date firstAppointDate;
	public String firstAppointDesignation;
	public String firstAppointType;
	public Integer isEmployeeSelectedByPrescribedWay;
	public String socialClass;
	public String selectionType;
	public String isCasteCertifiacteSubmitted;
	public String absencePeriod;
	public Integer moreThanThreeMonthAbsence;
	public String probationaryPeriodApprovedDate;
	public Date threeYearsCompletedDate;
	public Integer isDepartmentEnquiryGoingOn;
	public Integer stayitvaNotReceivedEmpTotal;
	public String comment;
	public Integer isMedicalCertificatePresented;
	public Integer characterVerifiedFlag;
	public Integer rbtnEnglishTypingFlag;
	public Integer retierment;
	public String computerExamPassOrDiscountDate;
	public Integer isAssetLiabilitySubmitted;
	public Integer isCourtCasePending;

}

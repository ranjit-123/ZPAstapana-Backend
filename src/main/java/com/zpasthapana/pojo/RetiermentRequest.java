package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RetiermentRequest extends BaseRequest{
	private String retirementOrderNumber;
	private String orderDate;
	private String retirementDate;
	private String retirementReason;
	private Integer isPayAfterRetirement;
	private Integer isPension;
	private String declarationDate;
	private String fromDate;
	private Integer pendingLevel;
	private String currentCondition;
	private Boolean homeLoanPending;
	private Boolean castCertificatePending;
	private Boolean docsIncomplte;
	private Boolean amountDue;
	private Long employeeId;
	private Integer panchayatSamiti;
}

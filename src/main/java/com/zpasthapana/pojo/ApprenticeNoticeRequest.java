package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApprenticeNoticeRequest extends BaseRequest{
	private Long employeeId;
	private Integer apprenticePeriodFlag;
	private String apprenticePeriodOrderNumber;
	private String apprenticePeriodOrderDate;
	private String apprenticePeriodOrderPDF;
	private String apprenticePeriodApplyDate;
}

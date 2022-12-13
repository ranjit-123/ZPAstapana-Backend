package com.zpasthapana.pojo;

import java.util.Date;

import com.zpasthapana.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UnathorizedAbsencePeriodRequest extends BaseEntity{
	private Long id;
	private String absenceStartDate;
	private String absenceEndDate;
	private String absenceStartDetails;
	private Integer isPresent;
	private String presentDate;
	private Integer isEnquiryOn;
	private String enquiryDetails;
	private Integer accountEnquiryCase;
	private Integer isCaseResolved;
	private String resolutionDetails;
	private String resolutionDate;
	private Long employeeId;        
}

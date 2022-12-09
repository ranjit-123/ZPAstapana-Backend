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
	private Date absenceStartDate;
	private Date absenceEndDate;
	private String absenceStart;
	private Integer isPresent;
	private Date presentDate;
	private Integer isEnquiryOn;
	private String enquiryDetails;
	private Integer accountEnquiryCase;
	private Integer isCaseResolved;
	private String resolutionDetails;
	private Date resolutionDate;
	private Long employeeId;        
}

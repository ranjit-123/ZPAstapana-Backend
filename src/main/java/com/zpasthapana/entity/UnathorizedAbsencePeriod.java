package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "unathorized_absence_period")
public class UnathorizedAbsencePeriod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

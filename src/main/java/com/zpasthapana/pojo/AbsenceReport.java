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
public class AbsenceReport {
	private String departmentName;
	private String employeName;
	private String designation;
	private Date retirementDate;
	private String officeName;
	private String taluka;
	private String absencePeriod;
	private String actionTaken;
	private String isPresent;
	private String morethan6monthsCase;
}

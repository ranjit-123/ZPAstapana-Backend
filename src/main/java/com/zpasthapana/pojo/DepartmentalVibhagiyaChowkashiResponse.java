package com.zpasthapana.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentalVibhagiyaChowkashiResponse {
	private Long accountInquiryID;
	private String employeeFirstName;
	private String employeeMiddelName;
	private String employeeLastName;
	private String departmentName;
	private String designationName;
	private String talukaName;
	private String subDivisionName;
	private String properOfficeName;
	private String retirementDate;
}

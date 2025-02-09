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
public class ReportMarathiEmpListResponse {
	private Long employeeId;
	private String employeeNameAndOffice;
	private Date appointmentOrderDate;
	private String firstAppointDesignation;
	private Date dateOfBirth;
	private String departmentName;
}

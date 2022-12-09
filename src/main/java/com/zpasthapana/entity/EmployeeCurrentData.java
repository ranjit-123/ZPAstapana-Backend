package com.zpasthapana.entity;

import javax.persistence.Entity;
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
@Table(name = "employee_current_data")
public class EmployeeCurrentData {
	@Id
	private Long employeeId;
	private Long nomineeId;
	private Long deputationId;
	private Long confidentialId;
	private Long accidentInsuranceId;
	private Long crimeId;
	private Long employeeDesiganationId;
	private Long employeeDisabilityId;
	private Long employeeWorklocationId;
}

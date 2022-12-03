package com.zpasthapana.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_education_details")
public class EmployeeEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeEducationId;
	private Long employeeId;
	private String universityName; 
	private String degreeName ;
	private String passoutDate  ;
	private String certificatePDF; 
}

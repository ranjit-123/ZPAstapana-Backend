package com.zpasthapana.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_designation_details")
public class EmployeeDesiganation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeDesiganationId;
	private Long employeeId;
	private String employeeselectioncategory;
	private String payCommission;
	private Integer appointmentQualificationFlag;
	private Long qualification;
	private Long parallelReservationType;
	private String salaryRange;
	private LocalDate dateOfAppointed;
	private String appointedDateFirstPagePDF;
	private String appointmentOrderPDF;
	private LocalDate dateOfHumanitySeniority;
	private String appointmentOrderNumber;
	private LocalDate appointmentOrderDate;
	private String serviceBookFirstPagePDF;
	
	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}

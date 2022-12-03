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
@Table(name = "employee_joining_details")
public class EmployeeJoinDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeJoinDetailsId;
	private Long employeeId;
	private LocalDate joiningData;
	private String appointmentQualificationExamName;
	private LocalDate dateOfPass;
	private String appointmentQualificationPDF;
	private String characterVerifiedOrderNumber;
	private LocalDate characterVerifiedOrderDate;
	private String characterVerifiedPDF;
	private String medicalCertificateOrderNumber;
	private LocalDate medicalCertificateOrderDate;
	private String medicalCertificatePDF;
	private String furtherServiceOrderNumber;
	private LocalDate furtherServiceOrderDate;
	private String furtherServicePDF;
	
	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}

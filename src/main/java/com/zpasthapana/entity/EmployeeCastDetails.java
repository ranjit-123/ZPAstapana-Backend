package com.zpasthapana.entity;

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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_cast_details")
public class EmployeeCastDetails extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeCastDetailsId;
	private Long employeeId;
	private String caste;
	private Integer castecategory;
	private Integer casteCertificateFlag;
	private Long appointmentCasteCategoryID;
	private String casteCertificateNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date casteCertificateDate;
	private String casteCertificatedIssuedOfficerName;
	private String casteCertificatePDF;
	private Integer casteValidityFlag;
	private String casteValidityNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date casteValidityDate;
	private String casteValidityPDF;
	private String casteValidityCommitteeName;
	private Integer casteCategoryChangedAfterAppointmentFlag;
	private Integer casteCategoryChangedAfterAppointmentID;
	private String casteCategoryChangedAfterAppointmentNumber;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date casteCategoryChangedAfterAppointmentDate;
	private String casteValidityChangedAfterAppointmentPDF;

	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "Asia/Calcutta")
	private Date modifyDate;
}

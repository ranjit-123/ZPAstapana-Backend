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
@Table(name = "employee_disability_details")
public class EmployeeDisability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeDisabilityId;
	private Long employeeId;
	private Integer disabilityFlag;
	private Integer disabilityReservation;
	private String appointmentDisability;
	private Integer disabilityID;
	private String disabilityPercentage;
	private LocalDate certificateDisabilityDate;
	private String disabilityCertificatePDF;
	
	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}

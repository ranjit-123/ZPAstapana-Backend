package com.zpasthapana.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
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
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	
	private Long employeeBasicDetailsId;
	private String loginEmail;
	private String contactNumber;
	private String alternateContactNumber;
	private String pancardNumber;
	private String aadhaarCardNumber;
	private LocalDate dateOfBirth;
	private Long religionID;
	private Integer gender;
	private Long employeeWorklocationId;
	private LocalDate retirementDate;
	private String txtSalaryServiceIDNumber;
	private String permanentAddress;
	private String currentAddress;
	private String declaredScale;
	
	@Column(name = "active", nullable = false)
	@ColumnDefault(value = "true")
	@Generated(GenerationTime.INSERT)
	private Boolean isActive;
	
	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}

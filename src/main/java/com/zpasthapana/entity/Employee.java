package com.zpasthapana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Employee extends BaseEntity {
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
	
	private Date dateOfBirth;
	private Long religionID;
	private Integer gender;
	private Long employeeWorklocationId;
	
	private Date retirementDate;
	private String salaryServiceIDNumber;
	private String permanentAddress;
	private String currentAddress;
	private String declaredScale;
	private String firstName;
	private String middleName;
	private String lastName;
	private String firstNameEng;
	private String middleNameEng;
	private String lastNameEng;
	
	private Long employeeDesiganationDetailsId;
	private Long employeeCastDetailsId;
	
	private Long retiermentId;
	private String pranNumber;
	
	
	@OneToOne
	@JoinColumn(table = "employee", name ="employeeWorklocationId", insertable = false, updatable = false)
	private EmployeeWorklocation employeeWorkLocation;
	
	@OneToOne
	@JoinColumn(table = "employee", name ="employeeCastDetailsId",  insertable = false, updatable = false)
	private EmployeeCastDetails employeeCastDetails;
	
	@OneToOne
	@JoinColumn(table = "employee", name ="employeeDesiganationDetailsId", insertable = false, updatable = false)
	private EmployeeDesiganation employeeDesiganation;
	
	@OneToOne
	@JoinColumn(table = "employee", name ="retiermentId", insertable = false, updatable = false)
	private Retierment retierment;

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

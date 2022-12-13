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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee_nominee_details")
public class EmployeeNomineeDetails extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Integer nomineePensionFlag;
	
	private Date nomineePensionDate;
	private String nomineePensionPDF;
	private Integer nomineeServiceAllowanceFlag;
	
	private Date nomineeDateOfServiceAllowance;
	private String nomineeServiceAllowancePDF;
	private Integer nomineeProvidentFundFlag;
	private String nomineeProvidentFundAccountNumber;
	
	private Date nomineeDateOfProvidentFund;
	private String nomineeProvidentFundPDF;
	private Integer nomineeGroupInsurancePlanFlag;
	
	private Date nomineeDateOfGroupInsurancePlan;
	private String nomineeGroupInsurancePlanPDF;
	private Integer nomineeAccidentInsurancePlanFlag;
	
	private Date nomineeDateOfAccidentInsurancePlan;
	private String nomineeAccidentInsurancePlanPDF;
	private Integer nomineeNPSFlag;
	private String nomineeNPSAccountNumber;
	
	private Date nomineeDateOfNPS;
	private String nomineeNPSPDF;
	private Integer nomineeFamilyCertificateFlag;
	
	private Date nomineeDateOfFamilyCertificate;
	private String nomineeFamilyCertificatePDF;
	private Integer nomineePromiseFlag;
	
	private Date nomineeDateOfPromise;
	private String nomineePromisePDF;

	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date modifyDate;
}

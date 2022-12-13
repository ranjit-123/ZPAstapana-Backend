package com.zpasthapana.entity;

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
@Table(name = "employee_designation_details")
public class EmployeeDesiganation extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeDesiganationDetailsId;
	
	private Long employeeDesiganationId;
	private Long employeeId;
	private String employeeselectioncategory;
	private String payCommission;
	private Integer appointmentQualificationFlag;
	private Long qualification;
	private Long parallelReservationType;
	private String salaryRange;
	
	private Date dateOfAppointed;
	private String appointedDateFirstPagePDF;
	private String appointmentOrderPDF;
	
	private Date dateOfHumanitySeniority;
	private String appointmentOrderNumber;
	
	private Date appointmentOrderDate;
	private String serviceBookFirstPagePDF;

	
	@Column(name = "current", nullable = false)
	@ColumnDefault(value = "true")
	@Generated(GenerationTime.INSERT)
	private Boolean isCurrent;
	
	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date modifyDate;
}

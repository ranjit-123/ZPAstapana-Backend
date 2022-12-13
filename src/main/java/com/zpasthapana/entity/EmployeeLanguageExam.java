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
@Table(name = "employee_language_exam")
public class EmployeeLanguageExam extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private Integer marathiHindiFlag;
	private String marathiOrderNumber;
	private Integer marathiFlag;
	
	private Date marathiOrderDate;
	private String marathiPDF;
	private Integer hindiFlag;
	private String hindiOrderNumber;
	
	private Date hindiOrderDate;
	private String hindiPDF;
	private Integer marathiHinidCombineFlag;
	private String marathiHinidCombineOrderNumber;
	
	private Date marathiHinidCombineOrderDate;
	private String marathiHinidCombinePDF;

	private Long createdBy;
	private Long modifiedBy;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date modifyDate;
}
